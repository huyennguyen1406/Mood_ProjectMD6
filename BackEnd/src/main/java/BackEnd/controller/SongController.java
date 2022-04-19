package BackEnd.controller;

import BackEnd.model.Song;
import BackEnd.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/home/song")
@CrossOrigin("*")
public class SongController {

    @Autowired
    private ISongService songService;

    @GetMapping()
    public ResponseEntity<List<Song>> getAllSong() {
        return new ResponseEntity<>(songService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{idSong}")
    public ResponseEntity<Song> getOneSong(@PathVariable("idSong") Long idSong) {
        return new ResponseEntity<>(songService.findById(idSong), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Song> createSong(@RequestBody Song song) {
        songService.save(song);
        return new ResponseEntity<>(song, HttpStatus.OK);
    }

    @PutMapping("/{idSong}")
    public ResponseEntity<Song> updateSong(@PathVariable("idSong") Long idSong, @RequestBody Song song) {
        song.setIdSong(idSong);
        songService.save(song);
        return new ResponseEntity<>(song, HttpStatus.OK);
    }

    @DeleteMapping("/{idSong}")
    public ResponseEntity<?> deleteSong(@PathVariable("idSong") Long idSong) {
        songService.deleteById(idSong);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Song>> findSongByName(@RequestParam("search") String search) {
        List<Song> songs = songService.findSongByNameSearch(search);
        return new ResponseEntity<>(songs, HttpStatus.OK);
    }

    @GetMapping("/{idSong}/{idPlaylist}")
    public ResponseEntity<?> addSongToPlaylist(@PathVariable("idSong") Long idSong, @PathVariable("idPlaylist") Long idPlaylist) {
        try {
            songService.getSongToPlaylist(idSong, idPlaylist);
            Song song = songService.findById(idSong);
            return new ResponseEntity<>(song, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Đã có sẵn trong playlist",HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/nameTag")
    public ResponseEntity<List<Song>> findSongByNameTag(@RequestParam("nameTag") String nameTag) {
        List<Song> songs = songService.findSongByNameTag(nameTag);
        return new ResponseEntity<>(songs, HttpStatus.OK);
    }

    @GetMapping("/newest")
    public ResponseEntity<List<Song>> getSevenSongNewest(){
        return new ResponseEntity<>(songService.getSevenSongNewest(), HttpStatus.OK);
    }

    @GetMapping("/like-most")
    public ResponseEntity<List<Song>> getSevenSongLikeMost(){
        return new ResponseEntity<>(songService.getSevenSongLikeMost(), HttpStatus.OK);
    }

    @GetMapping("/{idUser}/liked")
    public ResponseEntity<List<Song>> getAllSongLiked(@PathVariable("idUser") Long idUser){
        return new ResponseEntity<>(songService.getAllSongLiked(idUser), HttpStatus.OK);
    }

    @GetMapping("/view/{idSong}")
    public ResponseEntity<?> increaseViewSong(@PathVariable("idSong") Long idSong) {
        songService.increaseViewSong(idSong);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

package BackEnd.controller;

import BackEnd.model.Playlist;
import BackEnd.model.User;
import BackEnd.service.IPlaylistService;
import BackEnd.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/home/playlist")
@CrossOrigin("*")
public class PlaylistController {

    @Autowired
    private IPlaylistService playlistService;

    @Autowired
    private IUserService userService;

    @GetMapping()
    public ResponseEntity<List<Playlist>> getAllPlaylist() {
        return new ResponseEntity<>(playlistService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{idPlaylist}")
    public ResponseEntity<Playlist> getOnePlaylist(@PathVariable("idPlaylist") Long idPlaylist) {
        return new ResponseEntity<>(playlistService.findById(idPlaylist), HttpStatus.OK);
    }

    @PostMapping("/{idUser}")
    public ResponseEntity<Playlist> createPlaylist(@PathVariable("idUser") Long idUser, @RequestBody Playlist playlist) {
        User user = userService.findById(idUser);
        playlist.setUser(user);
        playlistService.save(playlist);
        return new ResponseEntity<>(playlist, HttpStatus.OK);
    }

    @PutMapping("/{idUser}/{idPlaylist}")
    public ResponseEntity<Playlist> updatePlaylist(@PathVariable("idUser") Long idUser,@PathVariable("idPlaylist") Long idPlaylist, @RequestBody Playlist playlist){
        User user = userService.findById(idUser);
        playlist.setUser(user);
        playlist.setIdPlaylist(idPlaylist);
        playlistService.save(playlist);
        return new ResponseEntity<>(playlist, HttpStatus.OK);
    }

    @DeleteMapping("/{idPlaylist}")
    public ResponseEntity<?> deletePlaylist(@PathVariable("idPlaylist") Long idPlaylist) {
        playlistService.deleteById(idPlaylist);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Playlist>> findPlaylistBySearch(@RequestParam("search") String search) {
        return new ResponseEntity<>(playlistService.findPlaylistByNameSearch(search), HttpStatus.OK);
    }

    @GetMapping("/newest")
    public ResponseEntity<List<Playlist>> getSevenPlaylistNewest() {
        return new ResponseEntity<>(playlistService.getSevenPlaylistNewest(), HttpStatus.OK);
    }

    @GetMapping("/like-most")
    public ResponseEntity<List<Playlist>> getSevenPlaylistLikeMost() {
        return new ResponseEntity<>(playlistService.getSevenPlaylistLikeMost(), HttpStatus.OK);
    }

    @GetMapping("/list/{idUser}")
    public ResponseEntity<List<Playlist>> getAllPlaylistByUserId(@PathVariable("idUser") Long idUser){
        return new ResponseEntity<>(playlistService.findAllByUserId(idUser), HttpStatus.OK);
    }


}

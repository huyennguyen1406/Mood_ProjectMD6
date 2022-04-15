package BackEnd.controller;

import BackEnd.model.CommentPlaylist;
import BackEnd.model.CommentSong;
import BackEnd.service.ICommentPlaylistService;
import BackEnd.service.ICommentSongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/home/comment")
public class CommentController {
    @Autowired
    private ICommentSongService commentSongService;

    @Autowired
    private ICommentPlaylistService commentPlaylistService;

    // Phần triển khai comment Song

    @GetMapping("/song")
    public ResponseEntity<List<CommentSong>> getAllCommentSong() {
        return new ResponseEntity<>(commentSongService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/song/{idCommentSong}")
    public ResponseEntity<CommentSong> getOneCommentSong(@PathVariable("idCommentSong") Long idCommentSong) {
        return new ResponseEntity<>(commentSongService.findById(idCommentSong), HttpStatus.OK);
    }

    @PostMapping("/song")
    public ResponseEntity<CommentSong> createCommentSong(@RequestBody CommentSong commentSong) {
        commentSongService.save(commentSong);
        return new ResponseEntity<>(commentSong, HttpStatus.OK);
    }

    @DeleteMapping("/song/{idCommentSong}")
    public ResponseEntity<?> deleteCommentSong(@PathVariable("idCommentSong") Long idCommentSong) {
        commentSongService.deleteById(idCommentSong);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/song/list/{idSong}")
    public ResponseEntity<List<CommentSong>> getAllCommentBySongId(@PathVariable("idSong") Long idSong) {
        return new ResponseEntity<>(commentSongService.findAllBySongCommentSongIdSong(idSong), HttpStatus.OK);
    }

    // Phần triển khai comment Playlist

    @GetMapping("/playlist")
    public ResponseEntity<List<CommentPlaylist>> getAllCommentPlaylist() {
        return new ResponseEntity<>(commentPlaylistService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/playlist/{idCommentPlaylist}")
    public ResponseEntity<CommentPlaylist> getOneCommentPlaylist(@PathVariable("idCommentPlaylist") Long idCommentPlaylist) {
        return new ResponseEntity<>(commentPlaylistService.findById(idCommentPlaylist), HttpStatus.OK);
    }

    @PostMapping("/playlist")
    public ResponseEntity<CommentPlaylist> createCommentPlaylist(@RequestBody CommentPlaylist commentPlaylist) {
        commentPlaylistService.save(commentPlaylist);
        return new ResponseEntity<>(commentPlaylist, HttpStatus.OK);
    }

    @DeleteMapping("/playlist/{idCommentPlaylist}")
    public ResponseEntity<?> deleteCommentPlaylist(@PathVariable("idCommentPlaylist") Long idCommentPlaylist) {
        commentPlaylistService.deleteById(idCommentPlaylist);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/playlist/list/{idPlaylist}")
    public ResponseEntity<List<CommentPlaylist>> getAllCommentByPlaylistId(@PathVariable("idPlaylist") Long idPlaylist) {
        return new ResponseEntity<>(commentPlaylistService.findAllByPlaylistCommentPlaylistIdPlaylist(idPlaylist), HttpStatus.OK);
    }
}

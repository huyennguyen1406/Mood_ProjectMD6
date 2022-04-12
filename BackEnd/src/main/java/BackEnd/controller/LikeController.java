package BackEnd.controller;

import BackEnd.service.ILikePlaylistService;
import BackEnd.service.ILikeSongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/home/like")
public class LikeController {
    @Autowired
    private ILikeSongService likeSongService;

    @Autowired
    private ILikePlaylistService likePlaylistService;

    // Phần like của Song
    @GetMapping("/song/{idSong}")
    public ResponseEntity<Integer> countLikeSong(@PathVariable("idSong") Long idSong){
        return new ResponseEntity<>(likeSongService.countBySongLikeSongIdSong(idSong), HttpStatus.OK);
    }




    // Phần like của Playlist
    @GetMapping("/playlist/{idPlaylist}")
    public ResponseEntity<Integer> countLikePlaylist(@PathVariable("idPlaylist") Long idPlaylist){
        return new ResponseEntity<>(likePlaylistService.countByPlaylistLikeSongIdPlaylist(idPlaylist), HttpStatus.OK);
    }


}

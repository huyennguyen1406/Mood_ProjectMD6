package BackEnd.controller;

import BackEnd.model.LikePlaylist;
import BackEnd.model.LikeSong;
import BackEnd.service.*;
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

    @Autowired
    private ISongService songService;

    @Autowired
    private IPlaylistService playlistService;

    @Autowired
    private IUserService userService;


    // Phần like của Song
    @GetMapping("/song/{idSong}")
    public ResponseEntity<Integer> countLikeSong(@PathVariable("idSong") Long idSong) {
        return new ResponseEntity<>(likeSongService.countBySongLikeSongIdSong(idSong), HttpStatus.OK);
    }

    @GetMapping("/song/{idUser}/{idSong}")
    public ResponseEntity<Integer> likeUnlikeSong(@PathVariable("idUser") Long idUser, @PathVariable("idSong") Long idSong) {
        LikeSong likeSong = likeSongService.findBySongLikeSongIdSongAndUserLikeSongId(idSong, idUser);
        if (likeSong != null) {
            likeSongService.deleteLikeSong(likeSong);
        } else {
            likeSongService.save(new LikeSong(songService.findById(idSong), userService.findById(idUser)));
        }
        Integer likeTotal = likeSongService.countBySongLikeSongIdSong(idSong);
        return new ResponseEntity<>(likeTotal, HttpStatus.OK);
    }

    // Phần like của Playlist
    @GetMapping("/playlist/{idPlaylist}")
    public ResponseEntity<Integer> countLikePlaylist(@PathVariable("idPlaylist") Long idPlaylist) {
        return new ResponseEntity<>(likePlaylistService.countByPlaylistLikeSongIdPlaylist(idPlaylist), HttpStatus.OK);
    }

    @GetMapping("/playlist/{idUser}/{idPlaylist}")
    public ResponseEntity<Integer> likeUnlikePlaylist(@PathVariable("idUser") Long idUser, @PathVariable("idPlaylist") Long idPlaylist) {
        LikePlaylist likePlaylist = likePlaylistService.findByPlaylistLikeSongIdPlaylistAndUserLikeSongId(idPlaylist, idUser);
        if (likePlaylist != null) {
            likePlaylistService.deleteLikePlaylist(likePlaylist);
        } else {
            likePlaylistService.save(new LikePlaylist(userService.findById(idUser), playlistService.findById(idPlaylist)));
        }
        Integer likeTotal = likePlaylistService.countByPlaylistLikeSongIdPlaylist(idPlaylist);
        return new ResponseEntity<>(likeTotal, HttpStatus.OK);
    }


}

package BackEnd.service;

import BackEnd.model.CommentSong;
import BackEnd.model.User;

import java.util.List;

public interface ICommentSongService {
    CommentSong findById(Long idCommentSong);

    List<CommentSong> findAll();

    CommentSong save(CommentSong commentSong);

    void deleteById(Long idCommentSong);

    List<CommentSong> findAllBySongCommentSongIdSong(Long idSong);
}

package BackEnd.service;

import BackEnd.model.CommentPlaylist;
import BackEnd.model.CommentSong;

import java.util.List;

public interface ICommentPlaylistService {
    CommentPlaylist findById(Long idCommentPlaylist);

    List<CommentPlaylist> findAll();

    CommentPlaylist save(CommentPlaylist commentPlaylist);

    void deleteById(Long idCommentPlaylist);

    List<CommentPlaylist> findAllByPlaylistCommentPlaylistIdPlaylist(Long idCommentPlaylist);
}

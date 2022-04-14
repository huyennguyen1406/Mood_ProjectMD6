package BackEnd.service.impl;

import BackEnd.model.CommentPlaylist;
import BackEnd.repository.ICommentPlaylistRepository;
import BackEnd.service.ICommentPlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentPlaylistServiceImpl implements ICommentPlaylistService {

    @Autowired
    private ICommentPlaylistRepository commentPlaylistRepository;

    @Override
    public CommentPlaylist findById(Long idCommentPlaylist) {
        if (commentPlaylistRepository.findById(idCommentPlaylist).isPresent()) {
            return commentPlaylistRepository.findById(idCommentPlaylist).get();
        }
        return null;
    }

    @Override
    public List<CommentPlaylist> findAll() {
        return commentPlaylistRepository.findAll();
    }

    @Override
    public CommentPlaylist save(CommentPlaylist commentPlaylist) {
        return commentPlaylistRepository.save(commentPlaylist);
    }

    @Override
    public void deleteById(Long idCommentPlaylist) {
        commentPlaylistRepository.deleteById(idCommentPlaylist);
    }

    @Override
    public List<CommentPlaylist> findAllByPlaylistCommentPlaylistIdPlaylist(Long idCommentPlaylist) {
        return commentPlaylistRepository.findAllByPlaylistCommentPlaylistIdPlaylist(idCommentPlaylist);
    }
}

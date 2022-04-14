package BackEnd.service.impl;

import BackEnd.model.CommentSong;
import BackEnd.repository.ICommentSongRepository;
import BackEnd.service.ICommentSongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentSongServiceImpl implements ICommentSongService {
    @Autowired
    private ICommentSongRepository commentSongRepository;

    @Override
    public CommentSong findById(Long idCommentSong) {
        if (commentSongRepository.findById(idCommentSong).isPresent()){
            return commentSongRepository.findById(idCommentSong).get();
        }
        return null;
    }

    @Override
    public List<CommentSong> findAll() {
        return commentSongRepository.findAll();
    }

    @Override
    public CommentSong save(CommentSong commentSong) {
        return commentSongRepository.save(commentSong);
    }

    @Override
    public void deleteById(Long idCommentSong) {
        commentSongRepository.deleteById(idCommentSong);
    }

    @Override
    public List<CommentSong> findAllBySongCommentSongIdSong(Long idSong) {
        return commentSongRepository.findAllBySongCommentSongIdSong(idSong);
    }
}

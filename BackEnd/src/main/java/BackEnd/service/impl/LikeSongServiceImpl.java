package BackEnd.service.impl;

import BackEnd.model.LikeSong;
import BackEnd.repository.ILikeSongRepository;
import BackEnd.service.ILikeSongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeSongServiceImpl implements ILikeSongService {
    @Autowired
    private ILikeSongRepository likeSongRepository;

    @Override
    public Integer countBySongLikeSongIdSong(Long idSong) {
        return likeSongRepository.countBySongLikeSongIdSong(idSong);
    }

    @Override
    public LikeSong findBySongLikeSongIdSongAndUserLikeSongId(Long idSong, Long idUser) {
        return likeSongRepository.findBySongLikeSongIdSongAndUserLikeSongId(idSong, idUser);
    }

    @Override
    public void deleteLikeSong(LikeSong likeSong) {
        likeSongRepository.delete(likeSong);
    }

    @Override
    public LikeSong save(LikeSong likeSong) {
        return likeSongRepository.save(likeSong);
    }

}

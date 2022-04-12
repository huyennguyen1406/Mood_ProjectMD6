package BackEnd.service.impl;

import BackEnd.model.LikePlaylist;
import BackEnd.repository.ILikePlaylistRepository;
import BackEnd.service.ILikePlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikePlaylistServiceImpl implements ILikePlaylistService {
    @Autowired
    private ILikePlaylistRepository likePlaylistRepository;

    @Override
    public Integer countByPlaylistLikeSongIdPlaylist(Long idPlaylist) {
        return likePlaylistRepository.countByPlaylistLikeSongIdPlaylist(idPlaylist);
    }

    @Override
    public LikePlaylist findByPlaylistLikeSongIdPlaylistAndUserLikeSongId(Long idPlaylist, Long idUser) {
        return likePlaylistRepository.findByPlaylistLikeSongIdPlaylistAndUserLikeSongId(idPlaylist, idUser);
    }

    @Override
    public void deleteLikePlaylist(LikePlaylist likePlaylist) {
        likePlaylistRepository.delete(likePlaylist);
    }

    @Override
    public LikePlaylist save(LikePlaylist likePlaylist) {
        return likePlaylistRepository.save(likePlaylist);
    }
}

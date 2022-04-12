package BackEnd.service;

import BackEnd.model.LikePlaylist;

public interface ILikePlaylistService {

    Integer countByPlaylistLikeSongIdPlaylist(Long idPlaylist);

    LikePlaylist findByPlaylistLikeSongIdPlaylistAndUserLikeSongId(Long idPlaylist, Long idUser);

    void deleteLikePlaylist(LikePlaylist likePlaylist);

    LikePlaylist save(LikePlaylist likePlaylist);
}

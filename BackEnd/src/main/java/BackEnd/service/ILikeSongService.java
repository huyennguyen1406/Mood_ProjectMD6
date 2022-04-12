package BackEnd.service;

import BackEnd.model.LikeSong;

public interface ILikeSongService {

    Integer countBySongLikeSongIdSong(Long idSong);

    LikeSong findBySongLikeSongIdSongAndUserLikeSongId(Long idSong, Long idUser);

    void deleteLikeSong(LikeSong likeSong);

    LikeSong save(LikeSong likeSong);
}

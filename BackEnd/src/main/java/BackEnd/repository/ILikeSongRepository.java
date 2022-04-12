package BackEnd.repository;

import BackEnd.model.LikePlaylist;
import BackEnd.model.LikeSong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ILikeSongRepository extends JpaRepository<LikeSong, Long> {
    Integer countBySongLikeSongIdSong(Long idSong);

    LikeSong findBySongLikeSongIdSongAndUserLikeSongId(Long idSong, Long idUser);

}

package BackEnd.repository;

import BackEnd.model.LikePlaylist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ILikePlaylistRepository extends JpaRepository<LikePlaylist, Long> {
    Integer countByPlaylistLikeSongIdPlaylist(Long idPlaylist);

    LikePlaylist findByPlaylistLikeSongIdPlaylistAndUserLikeSongId(Long idPlaylist, Long idUser);

//    @Query(value = "select * from like_post where id_post = :idPost and id_like = :idLike", nativeQuery = true)
//    LikePlaylist findLikeByPostIdAndLikeId(@Param("idPost") Long idPost, @Param("idLike") Long idLike);
}

package BackEnd.repository;

import BackEnd.model.CommentSong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ICommentSongRepository extends JpaRepository<CommentSong, Long>{
    List<CommentSong> findAllBySongCommentSongIdSong(Long idSong);
}

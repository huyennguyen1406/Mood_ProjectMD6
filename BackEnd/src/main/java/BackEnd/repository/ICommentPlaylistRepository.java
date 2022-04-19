package BackEnd.repository;

import BackEnd.model.CommentPlaylist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ICommentPlaylistRepository extends JpaRepository<CommentPlaylist, Long> {
    List<CommentPlaylist> findAllByPlaylistCommentPlaylistIdPlaylist(Long idPlaylist);
}

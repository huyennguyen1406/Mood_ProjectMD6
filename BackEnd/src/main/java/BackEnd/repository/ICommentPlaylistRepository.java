package BackEnd.repository;

import BackEnd.model.CommentPlaylist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICommentPlaylistRepository extends JpaRepository<CommentPlaylist, Long> {
    List<CommentPlaylist> findAllByPlaylistCommentPlaylistIdPlaylist(Long idPlaylist);
}

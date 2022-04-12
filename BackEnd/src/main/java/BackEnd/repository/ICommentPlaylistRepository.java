package BackEnd.repository;

import BackEnd.model.CommentPlaylist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICommentPlaylistRepository extends JpaRepository<CommentPlaylist, Long> {
}

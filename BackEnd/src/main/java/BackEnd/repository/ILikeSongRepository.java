package BackEnd.repository;

import BackEnd.model.LikeSong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILikeSongRepository extends JpaRepository<LikeSong, Long> {


}

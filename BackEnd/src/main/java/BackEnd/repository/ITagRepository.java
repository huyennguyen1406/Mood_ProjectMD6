package BackEnd.repository;

import BackEnd.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITagRepository extends JpaRepository<Tag, Long> {

    @Query(value = "select tag.id_tag, name_tag from song" +
            "inner join tag_song on song.id_song = tag_song.id_song" +
            "inner join tag on tag.id_tag = tag_song.id_tag" +
            "where song.id_song = :idSong", nativeQuery = true)
    List<Tag> getAllTagSong(@Param("idSong") Long idSong);

    @Modifying
    @Query(value = "insert into tag_song (id_tag, id_song) values (:idTag, :idSong)", nativeQuery = true)
    void addTagToSong(@Param("idTag") Long idTag, @Param("idSong") Long idSong);



}

package BackEnd.repository;

import BackEnd.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface ISongRepository extends JpaRepository<Song, Long> {
    @Query(value = "select id_song, avatar_url_song, description_song, mp3url_song,name_song, song.id_author, id_category, id_singer, number_of_view_song " +
            "from song inner join author on song.id_author = author.id_author inner join users on id_singer = users.id " +
            "where name_song like :search or name like :search or name_author like :search", nativeQuery = true)
    List<Song> findSongByNameSearch(@Param("search") String search);

    @Modifying
    @Query(value = "insert into playlist_song (id_playlist, id_song) values (:idPlaylist, :idSong)", nativeQuery = true)
    void getSongToPlaylist(@Param("idSong") Long idSong, @Param("idPlaylist") Long idPlaylist);
}

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
    @Query(value = "select id_song, avatar_url_song, description_song, mp3url_song,name_song, id_singer, number_of_view_song, date_create_song " +
            "from song inner join users on id_singer = users.id " +
            "where name_song like :search or name like :search or name like :search", nativeQuery = true)
    List<Song> findSongByNameSearch(@Param("search") String search);

    @Modifying
    @Query(value = "insert into playlist_song (id_playlist, id_song) values (:idPlaylist, :idSong)", nativeQuery = true)
    void getSongToPlaylist(@Param("idSong") Long idSong, @Param("idPlaylist") Long idPlaylist);

    @Query(value = "select song.id_song, avatar_url_song, description_song, mp3url_song,name_song, id_singer, number_of_view_song from song " +
            "inner join tag_song on song.id_song = tag_song.id_song " +
            "inner join tag on tag.id_tag = tag_song.id_tag " +
            "where name_tag = :nameTag", nativeQuery = true)
    List<Song> findSongByNameTag(@Param("nameTag") String nameTag);

    @Query(value = "select id_song, avatar_url_song, description_song, mp3url_song,name_song, id_singer, number_of_view_song, date_create_song from song " +
            "inner join like_song on song.id_song = like_song.id_song_like " +
            "group by id_song_like order by count(id_song_like) desc limit 7", nativeQuery = true)
    List<Song> getSevenSongLikeMost();

    @Query(value = "select * from song order by date_create_song desc limit 7", nativeQuery = true)
    List<Song> getSevenSongNewest();

    @Query(value = "select id_song, avatar_url_song, description_song, mp3url_song, name_song, id_singer, number_of_view_song, date_create_song from like_song " +
            "inner join song on like_song.id_song_like = song.id_song where id_user_like = :idUser", nativeQuery = true)
    List<Song> getAllSongLiked(@Param("idUser") Long idUser);

    @Modifying
    @Query(value = "delete from playlist_song where (id_playlist = :idPlaylist) and (id_song = :idSong)", nativeQuery = true)
    void removeSongFromPlaylist(@Param("idSong") Long idSong,@Param("idPlaylist") Long idPlaylist);

    List<Song> findAllByUserId(Long idUser);
}

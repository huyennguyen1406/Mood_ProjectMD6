package BackEnd.repository;

import BackEnd.model.Playlist;
import BackEnd.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPlaylistRepository extends JpaRepository<Playlist, Long> {

    @Query(value = "select id_playlist, date_create_playlist, description_playlist, last_modifier_playlist, name_playlist, number_of_view_playlist, id_user, avatar_playlist_url from playlist " +
            "inner join users on playlist.id_user = users.id " +
            "where name_playlist like :search or name like :search", nativeQuery = true)
    List<Playlist> findPlaylistByNameSearch(@Param("search") String search);

    @Query(value = "select id_playlist, date_create_playlist, description_playlist, last_modifier_playlist, name_playlist, number_of_view_playlist, id_user, avatar_playlist_url from playlist " +
            "inner join like_playlist on playlist.id_playlist = like_playlist.id_playlist_like " +
            "group by id_playlist_like order by count(id_playlist_like) desc limit 7;", nativeQuery = true)
    List<Playlist> getSevenPlaylistLikeMost();

    @Query(value = "select * from playlist order by date_create_playlist desc limit 7;", nativeQuery = true)
    List<Playlist> getSevenPlaylistNewest();
}

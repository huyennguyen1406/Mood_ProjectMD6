package BackEnd.service;

import BackEnd.model.Song;
import BackEnd.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ISongService {
    Song findById(Long idSong);

    List<Song> findAll();

    Song save(Song song);

    void deleteById(Long idSong);

    List<Song> findSongByNameSearch(String search);

    void getSongToPlaylist(Long idSong, Long idPlaylist);

    List<Song> findSongByNameTag(String nameTag);

    List<Song> getSevenSongNewest();

    List<Song> getSevenSongLikeMost();
}

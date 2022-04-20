package BackEnd.service;

import BackEnd.model.Playlist;
import BackEnd.model.Song;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IPlaylistService {
    Playlist findById(Long idPlaylist);

    List<Playlist> findAll();

    Playlist save(Playlist playlist);

    void deleteById(Long idPlaylist);

    List<Playlist> findPlaylistByNameSearch(String search);

    List<Playlist> getSevenPlaylistLikeMost();

    List<Playlist> getSevenPlaylistNewest();

    List<Playlist> findAllByUserId(Long idUser);
}

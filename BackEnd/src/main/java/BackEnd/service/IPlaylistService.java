package BackEnd.service;

import BackEnd.model.Playlist;

import java.util.List;

public interface IPlaylistService {
    Playlist findById(Long idPlaylist);

    List<Playlist> findAll();

    Playlist save(Playlist playlist);

    void deleteById(Long idPlaylist);

    List<Playlist> findPlaylistByNameSearch(String search);
}

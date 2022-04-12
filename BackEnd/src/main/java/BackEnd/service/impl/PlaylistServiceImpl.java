package BackEnd.service.impl;

import BackEnd.model.Playlist;
import BackEnd.repository.IPlaylistRepository;
import BackEnd.service.IPlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaylistServiceImpl implements IPlaylistService {

    @Autowired
    private IPlaylistRepository playlistRepository;

    @Override
    public Playlist findById(Long idPlaylist) {
        if (playlistRepository.findById(idPlaylist).isPresent()){
            return playlistRepository.findById(idPlaylist).get();
        }
        return null;
    }

    @Override
    public List<Playlist> findAll() {
        return playlistRepository.findAll();
    }

    @Override
    public Playlist save(Playlist playlist) {
        return playlistRepository.save(playlist);
    }

    @Override
    public void deleteById(Long idPlaylist) {
        playlistRepository.deleteById(idPlaylist);
    }

    @Override
    public List<Playlist> findPlaylistByNameSearch(String search) {
        String tagSearch = "%" + search + "%";
        return playlistRepository.findPlaylistByNameSearch(tagSearch);
    }
}

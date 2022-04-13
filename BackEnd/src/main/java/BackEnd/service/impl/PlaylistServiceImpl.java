package BackEnd.service.impl;

import BackEnd.model.Playlist;
import BackEnd.repository.IPlaylistRepository;
import BackEnd.service.IPlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
        LocalDate dateCreate = LocalDate.parse(String.valueOf(playlist.getDateCreatePlaylist()), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate lastModifier = LocalDate.parse(String.valueOf(playlist.getLastModifierPlaylist()), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        playlist.setDateCreatePlaylist(dateCreate);
        playlist.setLastModifierPlaylist(lastModifier);
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

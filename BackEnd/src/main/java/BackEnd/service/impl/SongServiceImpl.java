package BackEnd.service.impl;

import BackEnd.model.Song;
import BackEnd.repository.ISongRepository;
import BackEnd.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements ISongService {
    @Autowired
    private ISongRepository songRepository;

    @Override
    public Song findById(Long idSong) {
        if (songRepository.findById(idSong).isPresent()){
            return songRepository.findById(idSong).get();
        }
        return null;
    }

    @Override
    public List<Song> findAll() {
        return songRepository.findAll();
    }

    @Override
    public Song save(Song song) {
        return songRepository.save(song);
    }

    @Override
    public void deleteById(Long idSong) {
        songRepository.deleteById(idSong);
    }

    @Override
    public List<Song> findSongByNameSearch(String search) {
        String tagSearch = "%" + search + "%";
        return songRepository.findSongByNameSearch(tagSearch);
    }

    @Override
    public void getSongToPlaylist(Long idSong, Long idPlaylist) {
        songRepository.getSongToPlaylist(idSong, idPlaylist);
    }
}

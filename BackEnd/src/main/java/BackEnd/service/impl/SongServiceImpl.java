package BackEnd.service.impl;

import BackEnd.model.Song;
import BackEnd.repository.ISongRepository;
import BackEnd.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
//        LocalDate dateCreate = LocalDate.parse(String.valueOf(song.getDateCreateSong()), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//        song.setDateCreateSong(dateCreate);
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

    @Override
    public List<Song> findSongByNameTag(String nameTag) {
        return songRepository.findSongByNameTag(nameTag);
    }

    @Override
    public List<Song> getSevenSongNewest() {
        return songRepository.getSevenSongNewest();
    }

    @Override
    public List<Song> getSevenSongLikeMost() {
        return songRepository.getSevenSongLikeMost();
    }

    @Override
    public List<Song> getAllSongLiked(Long idUser) {
        return songRepository.getAllSongLiked(idUser);
    }

    @Override
    public void removeSongFromPlaylist(Long idSong, Long idPlaylist) {
        songRepository.removeSongFromPlaylist(idSong, idPlaylist);
    }

    @Override
    public List<Song> findAllByAuthorIdAuthor(Long idUser) {
        return songRepository.findAllByUserId(idUser);
    }
}

package BackEnd.dto;

public class PlaylistSongDTO {
    private Long idPlaylist;
    private Long idSong;

    public Long getIdPlaylist() {
        return this.idPlaylist;
    }

    public void setIdPlaylist(Long idPlaylist) {
        this.idPlaylist = idPlaylist;
    }

    public Long getIdSong() {
        return this.idSong;
    }

    public void setIdSong(Long idSong) {
        this.idSong = idSong;
    }
}

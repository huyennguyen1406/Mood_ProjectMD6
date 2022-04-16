package BackEnd.dto;

public class TagSongDTO {
    private Long idTag;
    private Long idSong;

    public Long getIdTag() {
        return this.idTag;
    }

    public void setIdTag(Long idTag) {
        this.idTag = idTag;
    }

    public Long getIdSong() {
        return this.idSong;
    }

    public void setIdSong(Long idSong) {
        this.idSong = idSong;
    }
}

package BackEnd.dto;

public class LikeSongDTO {
    private Long idLikeSong;
    private Long idSongLike;
    private Long idUserLike;

    public Long getIdLikeSong() {
        return this.idLikeSong;
    }

    public void setIdLikeSong(Long idLikeSong) {
        this.idLikeSong = idLikeSong;
    }

    public Long getIdSongLike() {
        return this.idSongLike;
    }

    public void setIdSongLike(Long idSongLike) {
        this.idSongLike = idSongLike;
    }

    public Long getIdUserLike() {
        return this.idUserLike;
    }

    public void setIdUserLike(Long idUserLike) {
        this.idUserLike = idUserLike;
    }
}

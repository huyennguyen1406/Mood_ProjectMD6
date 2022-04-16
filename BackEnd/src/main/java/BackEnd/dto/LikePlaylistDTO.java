package BackEnd.dto;

public class LikePlaylistDTO {
    private Long idLikePlaylist;
    private Long idPlaylistLike;
    private Long idUserLike;

    public Long getIdLikePlaylist() {
        return this.idLikePlaylist;
    }

    public void setIdLikePlaylist(Long idLikePlaylist) {
        this.idLikePlaylist = idLikePlaylist;
    }

    public Long getIdPlaylistLike() {
        return this.idPlaylistLike;
    }

    public void setIdPlaylistLike(Long idPlaylistLike) {
        this.idPlaylistLike = idPlaylistLike;
    }

    public Long getIdUserLike() {
        return this.idUserLike;
    }

    public void setIdUserLike(Long idUserLike) {
        this.idUserLike = idUserLike;
    }
}

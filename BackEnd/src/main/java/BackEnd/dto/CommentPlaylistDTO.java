package BackEnd.dto;

public class CommentPlaylistDTO {
    private Long idCommentPlaylist;
    private String contentComment;
    private Long idPlaylistComment;
    private Long idUserComment;

    public Long getIdCommentPlaylist() {
        return this.idCommentPlaylist;
    }

    public void setIdCommentPlaylist(Long idCommentPlaylist) {
        this.idCommentPlaylist = idCommentPlaylist;
    }

    public String getContentComment() {
        return this.contentComment;
    }

    public void setContentComment(String contentComment) {
        this.contentComment = contentComment;
    }

    public Long getIdPlaylistComment() {
        return this.idPlaylistComment;
    }

    public void setIdPlaylistComment(Long idPlaylistComment) {
        this.idPlaylistComment = idPlaylistComment;
    }

    public Long getIdUserComment() {
        return this.idUserComment;
    }

    public void setIdUserComment(Long idUserComment) {
        this.idUserComment = idUserComment;
    }
}

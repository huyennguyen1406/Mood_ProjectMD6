package BackEnd.dto;

public class CommentSongDTO {
    private Long idCommentSong;
    private String contentComment;
    private Long idCommentComment;
    private Long idSongComment;
    private Long idUserComment;

    public Long getIdCommentSong() {
        return this.idCommentSong;
    }

    public void setIdCommentSong(Long idCommentSong) {
        this.idCommentSong = idCommentSong;
    }

    public String getContentComment() {
        return this.contentComment;
    }

    public void setContentComment(String contentComment) {
        this.contentComment = contentComment;
    }

    public Long getIdCommentComment() {
        return this.idCommentComment;
    }

    public void setIdCommentComment(Long idCommentComment) {
        this.idCommentComment = idCommentComment;
    }

    public Long getIdSongComment() {
        return this.idSongComment;
    }

    public void setIdSongComment(Long idSongComment) {
        this.idSongComment = idSongComment;
    }

    public Long getIdUserComment() {
        return this.idUserComment;
    }

    public void setIdUserComment(Long idUserComment) {
        this.idUserComment = idUserComment;
    }
}

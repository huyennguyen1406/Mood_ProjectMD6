package BackEnd.model;

import javax.persistence.*;

@Entity
@Table(name = "comment_song")
public class CommentSong {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCommentSong;

    @ManyToOne
    @JoinColumn(name = "id_user_comment")
    private User userCommentSong;

    @ManyToOne
    @JoinColumn(name = "id_song_comment")
    private Song songCommentSong;

    private String contentComment;

    @ManyToOne
    @JoinColumn(name = "id_comment_comment")
    private CommentSong commentSong;

    public CommentSong() {
    }

    public Long getIdCommentSong() {
        return idCommentSong;
    }

    public void setIdCommentSong(Long idCommentSong) {
        this.idCommentSong = idCommentSong;
    }

    public User getUserCommentSong() {
        return userCommentSong;
    }

    public void setUserCommentSong(User userCommentSong) {
        this.userCommentSong = userCommentSong;
    }

    public Song getSongCommentSong() {
        return songCommentSong;
    }

    public void setSongCommentSong(Song songCommentSong) {
        this.songCommentSong = songCommentSong;
    }

    public String getContentComment() {
        return contentComment;
    }

    public void setContentComment(String contentComment) {
        this.contentComment = contentComment;
    }

    public CommentSong getCommentSong() {
        return commentSong;
    }

    public void setCommentSong(CommentSong commentSong) {
        this.commentSong = commentSong;
    }
}

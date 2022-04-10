package BackEnd.model;

import javax.persistence.*;

@Entity
@Table(name = "comment_playlist")
public class CommentPlaylist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCommentPlaylist;

    @ManyToOne
    @JoinColumn(name = "id_user_comment")
    private User userCommentPlaylist;

    @ManyToOne
    @JoinColumn(name = "id_playlist_comment")
    private Playlist playlistCommentPlaylist;

    private String contentComment;

    @ManyToOne
    @JoinColumn(name = "id_comment_comment")
    private CommentSong commentSong;

    public CommentPlaylist() {
    }

    public Long getIdCommentPlaylist() {
        return idCommentPlaylist;
    }

    public void setIdCommentPlaylist(Long idCommentPlaylist) {
        this.idCommentPlaylist = idCommentPlaylist;
    }

    public User getUserCommentPlaylist() {
        return userCommentPlaylist;
    }

    public void setUserCommentPlaylist(User userCommentPlaylist) {
        this.userCommentPlaylist = userCommentPlaylist;
    }

    public Playlist getPlaylistCommentPlaylist() {
        return playlistCommentPlaylist;
    }

    public void setPlaylistCommentPlaylist(Playlist playlistCommentPlaylist) {
        this.playlistCommentPlaylist = playlistCommentPlaylist;
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

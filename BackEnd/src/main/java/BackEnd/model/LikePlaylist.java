package BackEnd.model;

import javax.persistence.*;

@Entity
@Table(name = "like_playlist")
public class LikePlaylist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLikePlaylist;

    @ManyToOne
    @JoinColumn(name = "id_user_like")
    private User userLikeSong;

    @ManyToOne
    @JoinColumn(name = "id_playlist_like")
    private Playlist playlistLikeSong;

    public LikePlaylist() {
    }

    public Long getIdLikePlaylist() {
        return idLikePlaylist;
    }

    public void setIdLikePlaylist(Long idLikePlaylist) {
        this.idLikePlaylist = idLikePlaylist;
    }

    public User getUserLikeSong() {
        return userLikeSong;
    }

    public void setUserLikeSong(User userLikeSong) {
        this.userLikeSong = userLikeSong;
    }

    public Playlist getPlaylistLikeSong() {
        return playlistLikeSong;
    }

    public void setPlaylistLikeSong(Playlist playlistLikeSong) {
        this.playlistLikeSong = playlistLikeSong;
    }
}

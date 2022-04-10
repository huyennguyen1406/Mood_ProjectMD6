package BackEnd.model;

import javax.persistence.*;

@Entity
@Table(name = "like_song")
public class LikeSong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLikeSong;

    @ManyToOne
    @JoinColumn(name = "id_user_like")
    private User userLikeSong;

    @ManyToOne
    @JoinColumn(name = "id_song_like")
    private Song songLikeSong;

    public LikeSong() {
    }

    public Long getIdLikeSong() {
        return idLikeSong;
    }

    public void setIdLikeSong(Long idLikeSong) {
        this.idLikeSong = idLikeSong;
    }

    public User getUserLikeSong() {
        return userLikeSong;
    }

    public void setUserLikeSong(User userLikeSong) {
        this.userLikeSong = userLikeSong;
    }

    public Song getSongLikeSong() {
        return songLikeSong;
    }

    public void setSongLikeSong(Song songLikeSong) {
        this.songLikeSong = songLikeSong;
    }
}

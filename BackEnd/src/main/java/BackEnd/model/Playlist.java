package BackEnd.model;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "playlist")
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPlaylist;

    private String namePlaylist;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    private String avatarPlaylistUrl;

    private String descriptionPlaylist;
    private LocalDate dateCreatePlaylist;
    private LocalDate lastModifierPlaylist;

    @Value("1")
    private Long numberOfViewPlaylist;

    @ManyToMany
    @JoinTable(name = "playlist_song", joinColumns = @JoinColumn(name = "id_playlist"), inverseJoinColumns = @JoinColumn(name = "id_song"))
    private Set<Song> songs;

    public Playlist() {
    }

    public String getAvatarPlaylistUrl() {
        return avatarPlaylistUrl;
    }

    public void setAvatarPlaylistUrl(String avatarPlaylistUrl) {
        this.avatarPlaylistUrl = avatarPlaylistUrl;
    }

    public Set<Song> getSongs() {
        return songs;
    }

    public void setSongs(Set<Song> songs) {
        this.songs = songs;
    }

    public Long getIdPlaylist() {
        return idPlaylist;
    }

    public void setIdPlaylist(Long idPlaylist) {
        this.idPlaylist = idPlaylist;
    }

    public String getNamePlaylist() {
        return namePlaylist;
    }

    public void setNamePlaylist(String namePlaylist) {
        this.namePlaylist = namePlaylist;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescriptionPlaylist() {
        return descriptionPlaylist;
    }

    public void setDescriptionPlaylist(String descriptionPlaylist) {
        this.descriptionPlaylist = descriptionPlaylist;
    }

    public LocalDate getDateCreatePlaylist() {
        return dateCreatePlaylist;
    }

    public void setDateCreatePlaylist(LocalDate dateCreatePlaylist) {
        this.dateCreatePlaylist = dateCreatePlaylist;
    }

    public LocalDate getLastModifierPlaylist() {
        return lastModifierPlaylist;
    }

    public void setLastModifierPlaylist(LocalDate lastModifierPlaylist) {
        this.lastModifierPlaylist = lastModifierPlaylist;
    }

    public Long getNumberOfViewPlaylist() {
        return numberOfViewPlaylist;
    }

    public void setNumberOfViewPlaylist(Long numberOfViewPlaylist) {
        this.numberOfViewPlaylist = numberOfViewPlaylist;
    }
}

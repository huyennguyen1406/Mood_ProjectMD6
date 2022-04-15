package BackEnd.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import net.bytebuddy.implementation.bind.annotation.Default;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "song")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSong;

    private String nameSong;
    private String descriptionSong;
    private String mp3UrlSong;
    private String avatarUrlSong;

//    @ManyToOne
//    @JoinColumn(name = "id_author")
//    private Author author;

    @ManyToOne
    @JoinColumn(name = "id_singer")
    private User user;

//    @ManyToOne
//    @JoinColumn(name = "id_category")
//    private Category category;

    @Value("0")
    private Long numberOfViewSong;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateCreateSong;

    public Song() {
    }

    public LocalDate getDateCreateSong() {
        return dateCreateSong;
    }

    public void setDateCreateSong(LocalDate dateCreateSong) {
        this.dateCreateSong = dateCreateSong;
    }

    public Long getNumberOfViewSong() {
        return numberOfViewSong;
    }

    public void setNumberOfViewSong(Long numberOfViewSong) {
        this.numberOfViewSong = numberOfViewSong;
    }

    public Long getIdSong() {
        return idSong;
    }

    public void setIdSong(Long idSong) {
        this.idSong = idSong;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getDescriptionSong() {
        return descriptionSong;
    }

    public void setDescriptionSong(String descriptionSong) {
        this.descriptionSong = descriptionSong;
    }

    public String getMp3UrlSong() {
        return mp3UrlSong;
    }

    public void setMp3UrlSong(String mp3UrlSong) {
        this.mp3UrlSong = mp3UrlSong;
    }

    public String getAvatarUrlSong() {
        return avatarUrlSong;
    }

    public void setAvatarUrlSong(String avatarUrlSong) {
        this.avatarUrlSong = avatarUrlSong;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}

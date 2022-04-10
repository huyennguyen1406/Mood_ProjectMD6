package BackEnd.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tag")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTag;

    private String nameTag;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tag_song",
            joinColumns = @JoinColumn(name = "id_tag"),
            inverseJoinColumns = @JoinColumn(name = "id_song"))
    private List<Song> songs;

    public Tag() {
    }

//    public Tag(Long idTag, String nameTag, List<Song> songs) {
//        this.idTag = idTag;
//        this.nameTag = nameTag;
//        this.songs = songs;
//    }

    public Long getIdTag() {
        return idTag;
    }

    public void setIdTag(Long idTag) {
        this.idTag = idTag;
    }

    public String getNameTag() {
        return nameTag;
    }

    public void setNameTag(String nameTag) {
        this.nameTag = nameTag;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
}

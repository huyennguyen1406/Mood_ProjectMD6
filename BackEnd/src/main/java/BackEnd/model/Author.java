package BackEnd.model;

import javax.persistence.*;

@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAuthor;

    private String nameAuthor;

    public Author() {
    }

    public Author(Long idAuthor, String nameAuthor) {
        this.idAuthor = idAuthor;
        this.nameAuthor = nameAuthor;
    }

    public Long getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(Long idAuthor) {
        this.idAuthor = idAuthor;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }
}

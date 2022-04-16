package BackEnd.dto;

public class AuthorDTO {
    private Long idAuthor;
    private String nameAuthor;

    public Long getIdAuthor() {
        return this.idAuthor;
    }

    public void setIdAuthor(Long idAuthor) {
        this.idAuthor = idAuthor;
    }

    public String getNameAuthor() {
        return this.nameAuthor;
    }

    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }
}

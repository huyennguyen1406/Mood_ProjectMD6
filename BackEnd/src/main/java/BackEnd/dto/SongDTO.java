package BackEnd.dto;

public class SongDTO {
    private Long idSong;
    private String avatarUrlSong;
    private java.sql.Date dateCreateSong;
    private String descriptionSong;
    private String mp3UrlSong;
    private String nameSong;
    private Long numberOfViewSong;
    private Long idAuthor;
    private Long idCategory;
    private Long idSinger;

    public Long getIdSong() {
        return this.idSong;
    }

    public void setIdSong(Long idSong) {
        this.idSong = idSong;
    }

    public String getAvatarUrlSong() {
        return this.avatarUrlSong;
    }

    public void setAvatarUrlSong(String avatarUrlSong) {
        this.avatarUrlSong = avatarUrlSong;
    }

    public java.sql.Date getDateCreateSong() {
        return this.dateCreateSong;
    }

    public void setDateCreateSong(java.sql.Date dateCreateSong) {
        this.dateCreateSong = dateCreateSong;
    }

    public String getDescriptionSong() {
        return this.descriptionSong;
    }

    public void setDescriptionSong(String descriptionSong) {
        this.descriptionSong = descriptionSong;
    }

    public String getMp3UrlSong() {
        return this.mp3UrlSong;
    }

    public void setMp3UrlSong(String mp3UrlSong) {
        this.mp3UrlSong = mp3UrlSong;
    }

    public String getNameSong() {
        return this.nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public Long getNumberOfViewSong() {
        return this.numberOfViewSong;
    }

    public void setNumberOfViewSong(Long numberOfViewSong) {
        this.numberOfViewSong = numberOfViewSong;
    }

    public Long getIdAuthor() {
        return this.idAuthor;
    }

    public void setIdAuthor(Long idAuthor) {
        this.idAuthor = idAuthor;
    }

    public Long getIdCategory() {
        return this.idCategory;
    }

    public void setIdCategory(Long idCategory) {
        this.idCategory = idCategory;
    }

    public Long getIdSinger() {
        return this.idSinger;
    }

    public void setIdSinger(Long idSinger) {
        this.idSinger = idSinger;
    }
}

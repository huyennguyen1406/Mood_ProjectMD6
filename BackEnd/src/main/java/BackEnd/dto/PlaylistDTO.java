package BackEnd.dto;

public class PlaylistDTO {
    private Long idPlaylist;
    private java.sql.Date dateCreatePlaylist;
    private String descriptionPlaylist;
    private java.sql.Date lastModifierPlaylist;
    private String namePlaylist;
    private Long numberOfViewPlaylist;
    private Long idUser;
    private String avatarPlaylistUrl;

    public Long getIdPlaylist() {
        return this.idPlaylist;
    }

    public void setIdPlaylist(Long idPlaylist) {
        this.idPlaylist = idPlaylist;
    }

    public java.sql.Date getDateCreatePlaylist() {
        return this.dateCreatePlaylist;
    }

    public void setDateCreatePlaylist(java.sql.Date dateCreatePlaylist) {
        this.dateCreatePlaylist = dateCreatePlaylist;
    }

    public String getDescriptionPlaylist() {
        return this.descriptionPlaylist;
    }

    public void setDescriptionPlaylist(String descriptionPlaylist) {
        this.descriptionPlaylist = descriptionPlaylist;
    }

    public java.sql.Date getLastModifierPlaylist() {
        return this.lastModifierPlaylist;
    }

    public void setLastModifierPlaylist(java.sql.Date lastModifierPlaylist) {
        this.lastModifierPlaylist = lastModifierPlaylist;
    }

    public String getNamePlaylist() {
        return this.namePlaylist;
    }

    public void setNamePlaylist(String namePlaylist) {
        this.namePlaylist = namePlaylist;
    }

    public Long getNumberOfViewPlaylist() {
        return this.numberOfViewPlaylist;
    }

    public void setNumberOfViewPlaylist(Long numberOfViewPlaylist) {
        this.numberOfViewPlaylist = numberOfViewPlaylist;
    }

    public Long getIdUser() {
        return this.idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getAvatarPlaylistUrl() {
        return this.avatarPlaylistUrl;
    }

    public void setAvatarPlaylistUrl(String avatarPlaylistUrl) {
        this.avatarPlaylistUrl = avatarPlaylistUrl;
    }
}

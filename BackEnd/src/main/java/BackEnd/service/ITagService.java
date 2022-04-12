package BackEnd.service;

import BackEnd.model.Tag;

import java.util.List;

public interface ITagService {
    Tag findById(Long idTag);

    List<Tag> findAll();

    Tag save(Tag tag);

    void deleteById(Long idTag);

    List<Tag> getAllTagSong(Long idSong);

    void addTagToSong(Long idTag, Long idSong);
}

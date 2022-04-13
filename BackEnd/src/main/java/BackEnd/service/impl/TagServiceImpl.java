package BackEnd.service.impl;

import BackEnd.model.Tag;
import BackEnd.repository.ITagRepository;
import BackEnd.service.ITagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements ITagService {
    @Autowired
    private ITagRepository tagRepository;

    @Override
    public Tag findById(Long idTag) {
        if (tagRepository.findById(idTag).isPresent()) {
            return tagRepository.findById(idTag).get();
        }
        return null;
    }

    @Override
    public List<Tag> findAll() {
        return tagRepository.findAll();
    }

    @Override
    public Tag save(Tag tag) {
        if (!checkTag(tag)){
            return tagRepository.save(tag);
        }
        return null;
    }

    @Override
    public void deleteById(Long idTag) {
        tagRepository.deleteById(idTag);
    }

    @Override
    public List<Tag> getAllTagSong(Long idSong) {
        return tagRepository.getAllTagSong(idSong);
    }

    @Override
    public void addTagToSong(Long idTag, Long idSong) {
        Tag tag = findById(idTag);
        if (tag != null) {
            tagRepository.addTagToSong(idTag, idSong);
        }
    }

    public boolean checkTag(Tag tag) {
        for (Tag tagRecord : tagRepository.findAll()) {
            if (tag.getNameTag().equals(tagRecord.getNameTag())){
                return true;
            }
        }
        return false;
    }
}

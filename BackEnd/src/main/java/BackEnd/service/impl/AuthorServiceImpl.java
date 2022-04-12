package BackEnd.service.impl;

import BackEnd.model.Author;
import BackEnd.repository.IAuthorRepository;
import BackEnd.service.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements IAuthorService {
    @Autowired
    private IAuthorRepository authorRepository;

    @Override
    public Author findById(Long idAuthor) {
        if (authorRepository.findById(idAuthor).isPresent()){
            return authorRepository.findById(idAuthor).get();
        } else
        return null;
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public void deleteById(Long idAuthor) {
        authorRepository.deleteById(idAuthor);
    }
}

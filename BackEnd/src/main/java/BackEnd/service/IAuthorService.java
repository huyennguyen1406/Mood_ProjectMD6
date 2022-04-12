package BackEnd.service;

import BackEnd.model.Author;

import java.util.List;

public interface IAuthorService {
    Author findById(Long idAuthor);

    List<Author> findAll();

    Author save(Author author);

    void deleteById(Long idAuthor);

}

package BackEnd.service;

import BackEnd.model.Category;

import java.util.List;

public interface ICategoryService {
    Category findById(Long idCategory);

    List<Category> findAll();

    Category save(Category category);

    void deleteById(Long idCategory);
}

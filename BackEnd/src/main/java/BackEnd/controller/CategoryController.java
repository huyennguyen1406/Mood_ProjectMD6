package BackEnd.controller;

import BackEnd.model.Category;
import BackEnd.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/home/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategory(){
        return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{idCategory}")
    public ResponseEntity<Category> getOneCategory(@PathVariable("idCategory") Long idCategory){
        return new ResponseEntity<>(categoryService.findById(idCategory), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Category> createCategory(@RequestBody Category category){
        categoryService.save(category);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @PutMapping("/{idCategory}")
    public ResponseEntity<Category> updateCategory(@PathVariable("idCategory") Long idCategory,@RequestBody Category category ){
        category.setIdCategory(idCategory);
        categoryService.save(category);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @DeleteMapping("/{idCategory}")
    public ResponseEntity<?> deleteCategory(@PathVariable("idCategory") Long idCategory){
        categoryService.deleteById(idCategory);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

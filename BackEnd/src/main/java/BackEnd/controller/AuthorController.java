package BackEnd.controller;

import BackEnd.model.Author;
import BackEnd.service.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/home/author")
public class AuthorController {
    @Autowired
    private IAuthorService authorService;

    @GetMapping()
    public ResponseEntity<List<Author>> findAllAuthor() {
        List<Author> authors = authorService.findAll();
        return new ResponseEntity<>(authors, HttpStatus.OK);
    }

    @GetMapping("/{idAuthor}")
    public ResponseEntity<Author> findOneAuthor(@PathVariable("idAuthor") Long idAuthor) {
        Author author = authorService.findById(idAuthor);
        return new ResponseEntity<>(author, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Author> createAuthor(@RequestBody Author author) {
        authorService.save(author);
        return new ResponseEntity<>(author, HttpStatus.OK);
    }

    @PutMapping("/{idAuthor}")
    public ResponseEntity<Author> updateAuthor(@PathVariable("idAuthor") Long idAuthor, @RequestBody Author author) {
        author.setIdAuthor(idAuthor);
        authorService.save(author);
        return new ResponseEntity<>(author, HttpStatus.OK);
    }

    @DeleteMapping("/{idAuthor}")
    public ResponseEntity<?> deleteAuthor(@PathVariable("idAuthor") Long idAuthor){
        authorService.deleteById(idAuthor);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

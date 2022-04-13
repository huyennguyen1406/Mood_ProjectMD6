package BackEnd.controller;

import BackEnd.model.Tag;
import BackEnd.service.ITagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/home/tag")
public class TagController {
    @Autowired
    private ITagService tagService;

    @GetMapping()
    public ResponseEntity<List<Tag>> getAllTag(){
        return new ResponseEntity<>(tagService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{idTag}")
    public ResponseEntity<Tag> getOneTag(@PathVariable("idTag") Long idTag){
        return new ResponseEntity<>(tagService.findById(idTag), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Tag> createTag(@RequestBody Tag tag){
        tagService.save(tag);
        return new ResponseEntity<>(tag, HttpStatus.OK);
    }

    @DeleteMapping("/{idTag}")
    public ResponseEntity<?> deleteTag(@PathVariable("idTag") Long idTag){
        tagService.deleteById(idTag);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{idSong}")
    public ResponseEntity<List<Tag>> getAllTagSong(@PathVariable("idSong") Long idSong){
        return new ResponseEntity<>(tagService.getAllTagSong(idSong), HttpStatus.OK);
    }

    @GetMapping("/{idSong}/{idTag}")
    public ResponseEntity<?> getAllTagSong(@PathVariable("idSong") Long idSong, @PathVariable("idTag") Long idTag){
        tagService.addTagToSong(idTag, idSong);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

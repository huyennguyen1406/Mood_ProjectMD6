package BackEnd.controller;

import BackEnd.model.User;
import BackEnd.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/home/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping()
    public ResponseEntity<List<User>> findAllUser() {
        List<User> users = userService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{idUser}")
    public ResponseEntity<User> findOneUser(@PathVariable("idUser") Long idUser) {
        User user = userService.findById(idUser);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<User> createUser(@RequestBody User user) {
        userService.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/{idUser}")
    public ResponseEntity<User> updateUser(@PathVariable("idUser") Long idUser, @RequestBody User user) {
        user.setId(idUser);
        userService.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/{idUser}")
    public ResponseEntity<?> deleteAuthor(@PathVariable("idUser") Long idUser){
        userService.deleteById(idUser);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

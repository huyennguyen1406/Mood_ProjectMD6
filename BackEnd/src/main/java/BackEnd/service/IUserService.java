package BackEnd.service;

import BackEnd.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    User findById(Long idUser);

    List<User> findAll();

    User save(User user);

    void deleteById(Long idUser);

    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    Boolean existsByPassword(String password);
    Optional<User> findByEmail(String email);
    Optional<User> findByUsername(String username);
    Optional<User> findByUsernameAndPassword(String username, String password);
    void activeUser(String token);
}

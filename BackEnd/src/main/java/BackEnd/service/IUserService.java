package BackEnd.service;

import BackEnd.model.User;

import java.util.List;

public interface IUserService {
    User findById(Long idUser);

    List<User> findAll();

    User save(User user);

    void deleteById(Long idUser);
}

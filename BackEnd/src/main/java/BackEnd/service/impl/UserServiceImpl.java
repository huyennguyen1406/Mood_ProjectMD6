package BackEnd.service.impl;

import BackEnd.model.User;
import BackEnd.repository.IUserRepository;
import BackEnd.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public User findById(Long idUser) {
        if (userRepository.findById(idUser).isPresent()){
            return userRepository.findById(idUser).get();
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteById(Long idUser) {
        userRepository.deleteById(idUser);
    }
}

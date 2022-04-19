package BackEnd.service.impl;

import BackEnd.mail_confirm.OnSendRegistrationUserConfirmEvent;
import BackEnd.mail_confirm.RegistrationUserToken;
import BackEnd.model.User;
import BackEnd.repository.IRegistrationUserTokenRepository;
import BackEnd.repository.IUserRepository;
import BackEnd.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private IRegistrationUserTokenRepository registrationUserTokenRepository;
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

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
        User account = userRepository.save(user);
        createNewRegistrationUserToken(account);
        sendConfirmationEmail(account.getEmail());
        return account;
    }

    @Override
    public void deleteById(Long idUser) {
        userRepository.deleteById(idUser);
    }

    @Override
    public Boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public Boolean existsByPassword(String password) {
        return userRepository.existsByPassword(password);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Optional<User> findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }

    private void createNewRegistrationUserToken(User account){
        final String newToken = UUID.randomUUID().toString();

        RegistrationUserToken token = new RegistrationUserToken(newToken, account);
        registrationUserTokenRepository.save(token);
    }

    private void sendConfirmationEmail(String email){
        applicationEventPublisher.publishEvent(new OnSendRegistrationUserConfirmEvent(email));
    }
    @Override
    public void activeUser(String token) {
        RegistrationUserToken newToken = registrationUserTokenRepository.findByToken(token);
        User account = newToken.getAccount();
        account.setStatusActive(true);
        userRepository.save(account);
        registrationUserTokenRepository.deleteById(newToken.getId());
    }
}

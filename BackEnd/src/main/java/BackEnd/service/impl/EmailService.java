package BackEnd.service.impl;

import BackEnd.model.User;
import BackEnd.repository.IRegistrationUserTokenRepository;
import BackEnd.service.IEmailService;
import BackEnd.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmailService implements IEmailService {
    @Autowired
    private IUserService userService;

    @Autowired
    public JavaMailSender mailSender;

    @Autowired
    private IRegistrationUserTokenRepository registrationUserTokenRepository;


    @Override
    public void SendRegistrationUserConfirm(String email) {
        Optional<User> account = userService.findByEmail(email);

        String token = registrationUserTokenRepository.findByAccount_Id(account.get().getId()).getToken();

        String confirmationUrl = "http://localhost:8080/api/auth/active/" + token;
        String subject = "PASSIO MUSIC - Xác Nhận Đăng Ký Account";
        String content = "Chào mừng đến với PASSIO MUSIC.\n Click vào link dưới đây để kích hoạt tài khoản \n" + confirmationUrl;

        sendEmail(email, subject, content);
    }

    private void sendEmail(final String recipientEmail, final String subject, final String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(recipientEmail);
        message.setSubject(subject);
        message.setText(content);
        mailSender.send(message);
    }
}

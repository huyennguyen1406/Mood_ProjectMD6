package BackEnd.controller;

import BackEnd.model.ERole;
import BackEnd.model.Role;
import BackEnd.model.User;
import BackEnd.payload.request.Login;
import BackEnd.payload.request.SignUp;
import BackEnd.payload.response.JwtResponse;
import BackEnd.payload.response.MessageResponse;
import BackEnd.repository.IRoleRepository;
import BackEnd.security.jwt.JwtUtils;
import BackEnd.security.service.UserDetailImpl;
import BackEnd.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    IRoleRepository iRoleRepository;
    @Autowired
    IUserService userService;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/sign-in")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody Login loginRequest) {
        User user = userService.findByUsername(loginRequest.getUsername()).get();
        if (userService.existsByEmail(user.getEmail())) {
            if (!userService.findByEmail(user.getEmail()).get().getStatusActive()) {
                return new ResponseEntity<>(new MessageResponse("Vui lòng kích hoạt tài khoản của bạn!"), HttpStatus.BAD_REQUEST);
            }
        }
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailImpl userDetails = (UserDetailImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles));

    }

    @PostMapping("/sign-up")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUp signUpRequest) {
        if (userService.existsByUsername(signUpRequest.getUsername())) {
            // tài khoản đã đăng kí
            return new ResponseEntity<>(new MessageResponse("Tài khoản đã tồn tại trong hệ thống" +
                    "Vui lòng điền tài khoản khác!"), HttpStatus.OK);
        } else if (userService.existsByEmail(signUpRequest.getEmail())) {
            //email đã đăng kí
            return new ResponseEntity<>(new MessageResponse("Email đã tồn tại trong hệ thống" +
                    "Vui lòng điền email khác!"), HttpStatus.OK);
        } else {
            User user = new User(
                    signUpRequest.getName(),
                    signUpRequest.getAddress(),
                    signUpRequest.getPhone(),
                    signUpRequest.getEmail(),
                    signUpRequest.getUsername(),
                    encoder.encode(signUpRequest.getPassword()));
            user.setStatusActive(false);
            user.setAvatarURL("https://cdn3.vectorstock.com/i/1000x1000/26/62/runner-avatar-figure-with-mp3-player-music-block-vector-32312662.jpg");
            Set<String> strRoles = signUpRequest.getRole();
            Set<Role> roles = new HashSet<>();

            if (strRoles == null) {
                Role userRole = iRoleRepository.findByName(ERole.ROLE_USER)
                        .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                roles.add(userRole);
            } else {
                strRoles.forEach(role -> {
                    switch (role) {
                        case "admin":
                            Role adminRole = iRoleRepository.findByName(ERole.ROLE_ADMIN)
                                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                            roles.add(adminRole);

                            break;
                        default:
                            Role userRole = iRoleRepository.findByName(ERole.ROLE_USER)
                                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                            roles.add(userRole);
                    }
                });
            }
            user.setRoles(roles);
            userService.save(user);
            return new ResponseEntity<>(new MessageResponse("Đã gửi mail kích hoạt tài khoản" +
                    "Vui lòng check mail để kích hoạt!"), HttpStatus.OK);
        }
    }

    @GetMapping("/active/{token}")
    public RedirectView activeUserByToken(@PathVariable String token, RedirectAttributes attributes) {
        userService.activeUser(token);
        attributes.addFlashAttribute("flashAttribute", "redirectWithRedirectView");
        attributes.addAttribute("attribute", "redirectWithRedirectView");
        return new RedirectView("http://localhost:4200/login");
    }

    @GetMapping("/check-email/{mail}")
    public ResponseEntity<?> checkEmail(@PathVariable String mail) {
        if (userService.existsByEmail(mail)) {
            if (userService.findByEmail(mail).get().getStatusActive()) {
                return new ResponseEntity<>(userService.findByEmail(mail), HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

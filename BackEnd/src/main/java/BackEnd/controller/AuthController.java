package BackEnd.controller;

import BackEnd.model.ERole;
import BackEnd.model.Role;
import BackEnd.model.User;
import BackEnd.payload.request.Login;
import BackEnd.payload.request.RePassword;
import BackEnd.payload.request.SignUp;
import BackEnd.payload.response.JwtResponse;
import BackEnd.payload.response.MessageResponse;
import BackEnd.repository.IRoleRepository;
import BackEnd.repository.IUserRepository;
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

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    IUserRepository iUserRepository;

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
        if (iUserRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken !"));
        } else if (iUserRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use !"));
        } else {

            // Create new user's account
            User user = new User(
                    signUpRequest.getName(),
                    signUpRequest.getAddress(),
                    signUpRequest.getPhone(),
                    signUpRequest.getEmail(),
                    signUpRequest.getUsername(),
                    encoder.encode(signUpRequest.getPassword()));
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
            iUserRepository.save(user);

            return ResponseEntity.ok(new MessageResponse("User registered successfully !"));
        }
    }

    @GetMapping("/active")
    public ResponseEntity<?> activeUserByToken(@RequestParam String token){
        userService.activeUser(token);
        return new ResponseEntity<>(new MessageResponse("Active successfully!"), HttpStatus.OK);
    }
    @GetMapping("/check-email/{mail}")
    public ResponseEntity<?> checkEmail(@PathVariable String mail){
        if (userService.existsByEmail(mail)){
            if (userService.findByEmail(mail).get().getStatusActive()){
                return new ResponseEntity<>(userService.findByEmail(mail), HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

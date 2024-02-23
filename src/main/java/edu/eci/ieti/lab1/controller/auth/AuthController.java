package edu.eci.ieti.lab1.controller.auth;

import edu.eci.ieti.lab1.exception.InvalidCredentialsException;
import edu.eci.ieti.lab1.model.User;
import edu.eci.ieti.lab1.service.UsersService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import static edu.eci.ieti.lab1.utils.Constants.CLAIMS_ROLES_KEY;
import static edu.eci.ieti.lab1.utils.Constants.TOKEN_DURATION_MINUTES;


@RestController
@RequestMapping("v1/auth")
public class AuthController {

    @Value("${app.secret}")
    String secret;

    private final UsersService userService;

    public AuthController(@Autowired UsersService userService) {
        this.userService = userService;
    }

    @PostMapping
    public TokenDto login(@RequestBody LoginDto loginDto) {
        Optional<User> optionalUser = userService.findByEmail(loginDto.email);
        if (optionalUser.isPresent() && BCrypt.checkpw(loginDto.password, optionalUser.get().getPasswordHash())) {
            return generateTokenDto(optionalUser.get());
        } else {
            throw new InvalidCredentialsException();
        }

    }

    private String generateToken(User user, Date expirationDate) {
        return Jwts.builder()
                .setSubject(user.getId())
                .claim(CLAIMS_ROLES_KEY, user.getRoles())
                .setIssuedAt(new Date())
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    private TokenDto generateTokenDto(User user) {
        Calendar expirationDate = Calendar.getInstance();
        expirationDate.add(Calendar.MINUTE, TOKEN_DURATION_MINUTES);
        String token = generateToken(user, expirationDate.getTime());
        return new TokenDto(token, expirationDate.getTime());
    }
}
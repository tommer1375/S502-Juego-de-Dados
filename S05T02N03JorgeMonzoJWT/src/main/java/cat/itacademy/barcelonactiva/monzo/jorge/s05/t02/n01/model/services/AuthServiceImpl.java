package cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01.model.services;

import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01.config.JwtService;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01.controllers.models.AuthResponse;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01.controllers.models.AuthenticationRequest;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01.controllers.models.RegisterRequest;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01.model.domain.Role;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01.model.domain.User;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01.model.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    
    @Override
    public AuthResponse register(RegisterRequest request) {
        var user = User.builder()
                .name(request.getName())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthResponse.builder()
                .token(jwtToken).build();
    }

    @Override
    public AuthResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getName(),
                        request.getPassword()
                )
        );
        var user = userRepository.findUserByName(request.getName()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthResponse.builder()
                .token(jwtToken).build();
    }
}

package cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01.controllers;

import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01.controllers.models.AuthResponse;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01.controllers.models.AuthenticationRequest;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01.controllers.models.RegisterRequest;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01.model.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity <AuthResponse> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authService.register(request));

    }
    @PostMapping("/authenticate")
    public ResponseEntity <AuthResponse> authenticate(@RequestBody AuthenticationRequest request){
        return ResponseEntity.ok(authService.authenticate(request));

    }

}

package cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01.model.services;

import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01.controllers.models.AuthResponse;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01.controllers.models.AuthenticationRequest;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01.controllers.models.RegisterRequest;

public interface AuthService {

    AuthResponse register (RegisterRequest request);
    AuthResponse authenticate  (AuthenticationRequest request);
}


package cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n02.model.services;

import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n02.model.dto.GameDTO;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n02.model.dto.PlayerDTO;

import java.util.*;


public interface GameService {

    GameDTO addGame (String id);
    void deleteAllGames (String id);
    List<GameDTO> getAllGames (String id);

}


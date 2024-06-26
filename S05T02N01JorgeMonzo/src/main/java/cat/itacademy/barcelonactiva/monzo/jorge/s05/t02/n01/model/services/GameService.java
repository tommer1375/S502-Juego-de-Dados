package cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01.model.services;

import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01.model.dto.GameDTO;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01.model.dto.PlayerDTO;

import java.util.*;


public interface GameService {

    GameDTO addGame (int id);
    void deleteAllGames (int id);
    List<GameDTO> getAllGames (int id);

}



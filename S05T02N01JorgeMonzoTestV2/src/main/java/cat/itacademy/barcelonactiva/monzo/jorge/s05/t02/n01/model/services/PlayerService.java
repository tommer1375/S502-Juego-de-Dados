package cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01.model.services;


import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01.exceptions.PlayerNotFound;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01.model.domain.Player;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01.model.dto.PlayerDTO;

import java.util.List;

public interface PlayerService {

    PlayerDTO addPlayer(PlayerDTO playerDTO);
    PlayerDTO updatePlayer (int id, PlayerDTO playerDTO);
    List<PlayerDTO> getAllPlayers();



}

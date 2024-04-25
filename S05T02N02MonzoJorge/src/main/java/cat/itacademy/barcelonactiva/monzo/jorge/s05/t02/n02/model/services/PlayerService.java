package cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n02.model.services;


import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n02.model.dto.PlayerDTO;

import java.util.List;

public interface PlayerService {

    PlayerDTO addPlayer(PlayerDTO playerDTO);
    PlayerDTO updatePlayer (String id, PlayerDTO playerDTO);
    List<PlayerDTO> getAllPlayers();
}

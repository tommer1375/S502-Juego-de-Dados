package cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n02.model.services;

import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n02.model.dto.PlayerDTO;

import java.util.List;

public interface PlayerService {
    PlayerDTO addPlayer (PlayerDTO player);
    PlayerDTO getOnePlayer (String playerId);
    List<PlayerDTO> getAllPlayers ();
    PlayerDTO updatePlayer (String playerId, PlayerDTO newPlayerDTO);
    void deletePlayer(String id);
}

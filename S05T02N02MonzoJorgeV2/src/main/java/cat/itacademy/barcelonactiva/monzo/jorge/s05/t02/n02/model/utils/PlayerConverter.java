package cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n02.model.utils;

import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n02.model.domain.Player;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n02.model.dto.PlayerDTO;
import org.springframework.stereotype.Component;

@Component
public class PlayerConverter {

    public static Player DTOtoEntity(PlayerDTO playerDTO) {
        Player player = new Player();
        player.setPlayerId(playerDTO.getPlayerId());
        player.setName(playerDTO.getName());
        player.setRegisterDate(playerDTO.getRegisterDate());
        return player;
    }

    public static PlayerDTO EntitytoDTO(Player player) {
        PlayerDTO playerDTO = new PlayerDTO();
        playerDTO.setPlayerId(player.getPlayerId());
        playerDTO.setName(player.getName());
        playerDTO.setRegisterDate(player.getRegisterDate());
        playerDTO.setSuccessRate(player.calculateSuccessRate());
        return playerDTO;
    }
}
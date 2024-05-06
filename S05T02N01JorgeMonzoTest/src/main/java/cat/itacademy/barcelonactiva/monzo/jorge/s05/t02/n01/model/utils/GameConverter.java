package cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01.model.utils;


import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01.model.domain.Game;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01.model.dto.GameDTO;
import org.springframework.stereotype.Component;

@Component
public class GameConverter {

    public static GameDTO EntitytoDTO(Game game) {
        GameDTO gameDTO = new GameDTO();
        gameDTO.setGameId(game.getGameId());
        gameDTO.setDice1(game.getDice1());
        gameDTO.setDice2(game.getDice2());
        gameDTO.setWon(game.isWon());
        return gameDTO;
    }
}

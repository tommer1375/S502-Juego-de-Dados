package cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01.model.utils;


import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01.model.domain.Game;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01.model.dto.GameDTO;

public class GameConverter {

    public static GameDTO EntitytoDTO(Game game) {
        GameDTO gameDTO = new GameDTO();
        GameDTO.setGameId(game.getGameId());
        GameDTO.setDice1(game.getDice1());
        GameDTO.setDice2(game.getDice2());
        GameDTO.setWon(game.isWon());
        return gameDTO;
    }
}

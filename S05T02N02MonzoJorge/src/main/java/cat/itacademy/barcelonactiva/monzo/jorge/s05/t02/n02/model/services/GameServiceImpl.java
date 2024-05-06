package cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n02.model.services;

import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n02.model.domain.Game;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n02.model.domain.Player;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n02.model.dto.GameDTO;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n02.model.dto.PlayerDTO;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n02.exceptions.*;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n02.model.repository.GameRepository;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n02.model.repository.PlayerRepository;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n02.model.services.GameService;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n02.model.utils.GameConverter;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n02.model.utils.PlayerConverter;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.*;


@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private PlayerRepository playerRepository;



    @Override
    public GameDTO addGame(String playerId) {
        Player player = findPlayerById(playerId);

        Game newGame = new Game();
        newGame.setPlayer(player);
        rollDice(newGame);
        newGame.setGameDate(LocalDate.now());
        player.addGame(newGame);
        gameRepository.save(newGame);

        return GameConverter.EntitytoDTO(newGame);
    }
    @Transactional
    @Override
    public void deleteAllGames(String playerId) {
        Player player = findPlayerById(playerId);
        List<Game> games = gameRepository.findByPlayer_PlayerId(player.getPlayerId());

        if (games == null || games.isEmpty()) {
            throw new GameNotFound("There are no games for the player " + playerId);
        }
        games.clear();
        gameRepository.deleteByPlayer_PlayerId(player.getPlayerId());

    }
    @Transactional

    public List<GameDTO> getAllGames(String playerId) {
        Player player = findPlayerById(playerId);
        List<Game> games = gameRepository.findByPlayer_PlayerId(player.getPlayerId());
        if (games == null || games.isEmpty()) {
            throw new GameNotFound("There are no games for the player " + playerId);
        }
        return games.stream().map(GameConverter::EntitytoDTO).collect(Collectors.toList());

    }

    private void rollDice(Game game) {
        Random random = new Random();
        int dice1 = random.nextInt(6) + 1;
        int dice2 = random.nextInt(6) + 1;
        game.setDice1(dice1);
        game.setDice2(dice2);
        game.setWon(game.isWon());
    }
    public Player findPlayerById (String playerId){
        return playerRepository.findById(playerId).orElseThrow(() -> new PlayerNotFound("Player not found."));
    }
}
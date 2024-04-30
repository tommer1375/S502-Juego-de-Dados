package cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01.model.services;

import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01.model.domain.Game;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01.model.domain.Player;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01.model.dto.GameDTO;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01.exceptions.*;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01.model.repository.GameRepository;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01.model.repository.PlayerRepository;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01.model.services.GameService;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01.model.utils.GameConverter;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01.model.utils.PlayerConverter;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private PlayerServiceImpl playerService;

    @Transactional
    @Override
    public GameDTO addGame(int playerId) {
        Player player = playerService.findPlayerById(playerId);

        Game newGame = new Game();
        newGame.setPlayer(player);
        rollDice(newGame);
        newGame.setGameDate(LocalDate.now());
        player.addGame(newGame);
        gameRepository.save(newGame);

        return GameConverter.EntitytoDTO(newGame);
    }

    private void rollDice (Game game){
        Random random = new Random();
        int dice1 = random.nextInt(6) + 1;
        int dice2 = random.nextInt(6) + 1;
        game.setDice1(dice1);
        game.setDice2(dice2);
        game.setWon(game.isWon());
    }

    @Transactional
    @Override
    public List<GameDTO> getAllGames(int playerId) {
        Player player = playerService.findPlayerById(playerId);
        List<Game> games = gameRepository.findByPlayer_PlayerId(player.getPlayerId());
        if(games==null || games.isEmpty()){
            throw new GameNotFound("There are no games for this player, sorry.");
        }
        return games.stream().map(GameConverter::EntitytoDTO).collect(Collectors.toList());
    }
    @Transactional
    public void deleteAllGames (int playerId) {
        Player player = playerService.findPlayerById(playerId);
        List<Game> games = player.getGames();

        if(games==null || games.isEmpty()){
            throw new GameNotFound("There are no games for this player, sorry.");
        }
        games.clear();
        gameRepository.deleteByPlayer_PlayerId(player.getPlayerId());
    }
}
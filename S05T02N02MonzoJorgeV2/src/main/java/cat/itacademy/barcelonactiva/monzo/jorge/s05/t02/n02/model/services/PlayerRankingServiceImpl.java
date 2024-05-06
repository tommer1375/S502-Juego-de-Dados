package cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n02.model.services;



import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n02.exceptions.PlayerNotFound;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n02.model.domain.Game;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n02.model.domain.Player;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n02.model.dto.PlayerDTO;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n02.model.repository.GameRepository;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n02.model.repository.PlayerRepository;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n02.model.services.PlayerRankingService;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n02.model.utils.PlayerConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class PlayerRankingServiceImpl implements PlayerRankingService {
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private GameRepository gameRepository;

    @Transactional
    @Override
    public double getSuccessRateAverage () {

        List<Player> players = playerRepository.findAll();
        if (players.isEmpty()) {
            throw new PlayerNotFound("Players not found in the system.");
        }
        for (Player player : players) {
            List<Game> playerGames = gameRepository.findByPlayer_PlayerId(player.getPlayerId());
            player.setGames(playerGames);
        }
        double totalSuccessRate = players.stream()
                .mapToDouble(Player::calculateSuccessRate)
                .sum();
        return Math.round(totalSuccessRate / players.size());
    }


    @Override
    public PlayerDTO getWinner (){
        List<Player> players = playerRepository.findAll();
        if(players.isEmpty()){
            throw new PlayerNotFound("Not players found.");
        }
        for (Player player : players) {
            List<Game> playerGames = gameRepository.findByPlayer_PlayerId(player.getPlayerId());
            player.setGames(playerGames);
        }
        Player winner = players.stream().max(Comparator.comparing(Player::calculateSuccessRate))
                .orElse(null);
        return PlayerConverter.EntitytoDTO(winner);
    }

    @Override
    public PlayerDTO getLoser (){
        List<Player> players = playerRepository.findAll();
        if(players.isEmpty()){
            throw new PlayerNotFound("Not players found.");
        }
        for (Player player : players) {
            List<Game> playerGames = gameRepository.findByPlayer_PlayerId(player.getPlayerId());
            player.setGames(playerGames);
        }
        Player loser = players.stream().min(Comparator.comparing(Player::calculateSuccessRate))
                .orElse(null);
        return PlayerConverter.EntitytoDTO(loser);
    }
}

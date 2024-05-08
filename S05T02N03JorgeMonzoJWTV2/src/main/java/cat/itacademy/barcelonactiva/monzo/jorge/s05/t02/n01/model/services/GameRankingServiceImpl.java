package cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01.model.services;

import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01.model.domain.Player;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01.model.dto.PlayerDTO;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01.exceptions.*;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01.model.repository.PlayerRepository;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01.model.services.GameRankingService;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01.model.utils.PlayerConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class GameRankingServiceImpl implements GameRankingService {
    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public double getAveragePlayer (){
        List<Player> players = playerRepository.findAll();
        if(players.isEmpty()){
            throw new PlayerNotFound("The players list is Empty.");
        }
        double totalSuccessRate = players.stream()
                .mapToDouble(Player::calculateSuccessRate)
                .sum();
        return Math.round(totalSuccessRate / players.size());
    }

    @Override
    public PlayerDTO getWinnerPlayer (){
        List<Player> players = playerRepository.findAll();
        if(players.isEmpty()){
            throw new PlayerNotFound("The players list is Empty.");
        }
        Player winner = players.stream().max(Comparator.comparing(Player::calculateSuccessRate))
                .orElse(null);
        return PlayerConverter.EntitytoDTO(winner);
    }

    @Override
    public PlayerDTO getLoserPlayer (){
        List<Player> players = playerRepository.findAll();
        if(players.isEmpty()){
            throw new PlayerNotFound("The players list is Empty.");
        }
        Player loser = players.stream().min(Comparator.comparing(Player::calculateSuccessRate))
                .orElse(null);
        return PlayerConverter.EntitytoDTO(loser);
    }
}
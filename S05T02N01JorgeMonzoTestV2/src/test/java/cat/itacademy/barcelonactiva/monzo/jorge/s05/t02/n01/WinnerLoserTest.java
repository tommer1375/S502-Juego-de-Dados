package cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01;

import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01.model.repository.PlayerRepository;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01.model.dto.PlayerDTO;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01.model.domain.Player;

import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01.model.domain.Game;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01.model.services.GameRankingServiceImpl;

import static org.mockito.Mockito.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;


@SpringBootTest
public class WinnerLoserTest {

    @Mock
    private PlayerRepository playerRepository;

    @InjectMocks
    private GameRankingServiceImpl gameRankingService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetWinnerPlayer() {

        List<Player> players = new ArrayList<>();
        Player winner = new Player(1, "Jorge", LocalDateTime.now(), new ArrayList<>());
        winner.addGame(new Game(1, LocalDate.now(), 1, 6, true, winner));
        winner.addGame(new Game(2, LocalDate.now(), 2, 5, true, winner));
        winner.addGame(new Game(3, LocalDate.now(), 3, 4, false, winner));


        Player loser = new Player(2, "Daniel", LocalDateTime.now(), new ArrayList<>());
        loser.addGame(new Game(4, LocalDate.now(), 1, 6, true, loser));
        loser.addGame(new Game(5, LocalDate.now(), 2, 5, false, loser));
        loser.addGame(new Game(6, LocalDate.now(), 3, 4, false, loser));

        players.add(winner);


        when(playerRepository.findAll()).thenReturn(players);

        PlayerDTO winnerPlayerDTO = gameRankingService.getWinnerPlayer();

        Assertions.assertNotNull(winnerPlayerDTO);
        Assertions.assertEquals(winner.getPlayerId(), winnerPlayerDTO.getPlayerId());
    }

    @Test
    public void testGetLoserPlayer() {

        List<Player> players = new ArrayList<>();
        Player winner = new Player(1, "Jorge", LocalDateTime.now(), new ArrayList<>());
        winner.addGame(new Game(1, LocalDate.now(), 1, 6, true, winner));
        winner.addGame(new Game(2, LocalDate.now(), 2, 5, true, winner));
        winner.addGame(new Game(3, LocalDate.now(), 3, 4, false, winner));


        Player loser = new Player(2, "Daniel", LocalDateTime.now(), new ArrayList<>());
        loser.addGame(new Game(4, LocalDate.now(), 1, 6, true, loser));
        loser.addGame(new Game(5, LocalDate.now(), 2, 5, false, loser));
        loser.addGame(new Game(6, LocalDate.now(), 3, 4, false, loser));

        players.add(loser);


        when(playerRepository.findAll()).thenReturn(players);

        PlayerDTO loserPlayerDTO = gameRankingService.getLoserPlayer();

        Assertions.assertNotNull(loserPlayerDTO);
        Assertions.assertEquals(loser.getPlayerId(), loserPlayerDTO.getPlayerId());
    }

}

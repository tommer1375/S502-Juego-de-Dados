package cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01;

import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01.model.repository.PlayerRepository;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01.model.dto.PlayerDTO;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01.model.domain.Player;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01.model.services.PlayerServiceImpl;

import static org.mockito.Mockito.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class GetAllPlayersTest {

    @Mock
    private PlayerRepository playerRepository;

    @InjectMocks
    private PlayerServiceImpl playerService;

    @Test
    public void testGetAllPlayer() {

        List<Player> players = new ArrayList<>();
        players.add(new Player(1, "Jorge", LocalDateTime.now(), new ArrayList<>()));
        players.add(new Player(2, "Daniel", LocalDateTime.now(), new ArrayList<>()));

        when(playerRepository.findAll()).thenReturn(players);

        List<PlayerDTO> playerDTOs = playerService.getAllPlayers();

        Assertions.assertNotNull(playerDTOs);
        Assertions.assertEquals(2, playerDTOs.size());

    }
}
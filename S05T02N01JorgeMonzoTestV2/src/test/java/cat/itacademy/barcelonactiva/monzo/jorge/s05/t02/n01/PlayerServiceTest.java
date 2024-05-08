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

@SpringBootTest
public class PlayerServiceTest {

    @Mock
    private PlayerRepository playerRepository;

    @InjectMocks
    private PlayerServiceImpl playerService;

    @Test
    public void testAddPlayer() {

        PlayerDTO playerDTO = new PlayerDTO();
        playerDTO.setName("Jorge");


        when(playerRepository.existsByNameIgnoreCase("Jorge")).thenReturn(false);
        when(playerRepository.save(any(Player.class))).thenReturn(new Player());


        PlayerDTO result = playerService.addPlayer(playerDTO);


        Assertions.assertNotNull(result);
        Assertions.assertEquals("Jorge", result.getName());


        verify(playerRepository, times(1)).existsByNameIgnoreCase("Jorge");
        verify(playerRepository, times(1)).save(any(Player.class));
    }
}
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

import java.util.Optional;

@SpringBootTest
public class UpdatePlayerTest {

    @Mock
    private PlayerRepository playerRepository;

    @InjectMocks
    private PlayerServiceImpl playerService;

    @Test
    public void testUpdatePlayer() {
       int playerId = 1;
        PlayerDTO newPlayerDTO = new PlayerDTO();
        newPlayerDTO.setName("Carlos");

        Player existingPlayer = new Player();
        existingPlayer.setPlayerId(playerId);
        existingPlayer.setName("Jorge");

        when(playerRepository.findById(playerId)).thenReturn(Optional.of(existingPlayer));

        when(playerRepository.save(any(Player.class))).thenAnswer(invocation -> {
            Player updatedPlayer = invocation.getArgument(0);
            updatedPlayer.setName(newPlayerDTO.getName());
            return updatedPlayer;
        });


        PlayerDTO updatedPlayerDTO = playerService.updatePlayer(playerId, newPlayerDTO);


        Assertions.assertNotNull(updatedPlayerDTO);
        Assertions.assertEquals(newPlayerDTO.getName(), updatedPlayerDTO.getName());
    }
}

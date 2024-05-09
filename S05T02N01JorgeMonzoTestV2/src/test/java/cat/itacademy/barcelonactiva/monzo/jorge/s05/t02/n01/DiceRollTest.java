package cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01;


import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01.model.dto.PlayerDTO;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01.model.dto.GameDTO;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01.model.services.GameServiceImpl;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01.model.services.PlayerServiceImpl;


import static org.mockito.Mockito.*;

import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01.model.utils.PlayerConverter;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DiceRollTest{

    @Mock
    private PlayerServiceImpl playerService;

    @InjectMocks
    private GameServiceImpl gameService;

    @Test
    public void testDiceRoll() {

        PlayerDTO playerDTO = new PlayerDTO();
        playerDTO.setPlayerId(1);
        playerDTO.setName("Jorge");

        when(playerService.findPlayerById(1)).thenReturn(PlayerConverter.DTOtoEntity(playerDTO));

        GameDTO result = gameService.addGame(1);

        Assertions.assertNotNull(result);
        Assertions.assertTrue(result.getDice1() >= 1 && result.getDice1() <= 6);
        Assertions.assertTrue(result.getDice2() >= 1 && result.getDice2() <= 6);
        Assertions.assertTrue(result.isWon());
    }

}


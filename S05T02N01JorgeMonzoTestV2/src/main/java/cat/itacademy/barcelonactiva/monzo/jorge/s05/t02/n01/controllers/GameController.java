package cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01.controllers;

import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01.model.dto.GameDTO;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01.model.dto.PlayerDTO;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01.model.services.GameService;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01.model.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class GameController {

    @Autowired
    private GameService gameService;
    @Autowired
    private PlayerService playerService;

    @PostMapping("/{id}/games")
    public ResponseEntity<?> addGame(@PathVariable int id) {
        GameDTO gameDTO = gameService.addGame(id);
        return new ResponseEntity<>(gameDTO, HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}/games")
    public ResponseEntity<?> deleteAllGames(@PathVariable int id) {
        gameService.deleteAllGames(id);
        return new ResponseEntity<>("Games have been deleted", HttpStatus.OK);
    }
    @GetMapping("/{id}/getAll")
    public ResponseEntity<?> getAllGames (@PathVariable int id) {
        List<GameDTO> gameDTOList = gameService.getAllGames(id);
        return new ResponseEntity<>(gameDTOList, HttpStatus.OK);
    }

}
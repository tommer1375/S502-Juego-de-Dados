package cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n02.controllers;

import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n02.model.dto.PlayerDTO;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n02.model.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @PostMapping
    public ResponseEntity<PlayerDTO> addPlayer(@RequestBody PlayerDTO playerDTO) {
        PlayerDTO newPlayer = playerService.addPlayer(playerDTO);
        return new ResponseEntity<>(newPlayer, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updatePlayer(@PathVariable("id") String id, @RequestBody PlayerDTO playerDTO) {
        PlayerDTO playertoUpadate = playerService.updatePlayer(id, playerDTO);
        return new ResponseEntity<>(playertoUpadate, HttpStatus.OK);
    }
    @GetMapping("/getAll")
    public ResponseEntity<?> getAllPlayers() {
        List<PlayerDTO> searchedPlayer = playerService.getAllPlayers();
        return ResponseEntity.status(HttpStatus.FOUND).body(searchedPlayer);

    }
}
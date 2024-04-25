package cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n02.controllers;

import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n02.model.dto.PlayerDTO;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n02.model.services.GameRankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/players")
public class GameRankingController {

    @Autowired
    private GameRankingService gameRankingService;

    @GetMapping("/ranking")
    public ResponseEntity<?> getAveragePlayer (){
        Double successAverage = gameRankingService.getAveragePlayer();
        return new ResponseEntity<>(successAverage, HttpStatus.OK);
    }

    @GetMapping("/ranking/winner")
    public ResponseEntity<?> getWinnerPlayer (){
        PlayerDTO winner = gameRankingService.getWinnerPlayer();
        return new ResponseEntity<>(winner, HttpStatus.OK);
    }

    @GetMapping("/ranking/loser")
    public ResponseEntity<?> getLoserPlayer (){
        PlayerDTO loser = gameRankingService.getLoserPlayer();
        return new ResponseEntity<>(loser, HttpStatus.OK);
    }

}
package cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01.model.services;


import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01.model.dto.PlayerDTO;

public interface GameRankingService {

    double getAveragePlayer ();
    PlayerDTO getWinnerPlayer ();
    PlayerDTO getLoserPlayer ();
}
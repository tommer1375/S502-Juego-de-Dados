package cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n02.model.services;


import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n02.model.dto.PlayerDTO;

public interface PlayerRankingService {

    double getSuccessRateAverage ();
    PlayerDTO getWinner ();
    PlayerDTO getLoser ();
}

package cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01.model.repository;

import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01.model.domain.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {

    List<Game> findByPlayer_PlayerId (int playerId);
    void deleteByPlayer_PlayerId(int playerId);
}
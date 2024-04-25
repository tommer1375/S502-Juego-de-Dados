package cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n02.model.repository;

import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n02.model.domain.Player;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n02.model.domain.Game;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;


import java.util.*;

@Repository
public interface PlayerRepository extends MongoRepository<Player, String> {

    boolean existsByNameIgnoreCase(String name);

    List<Game> findAllGamesByPlayerId (String id);
}
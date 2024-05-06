package cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n02.model.repository;


import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n02.model.domain.Game;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface GameRepository extends MongoRepository<Game,String> {

    List<Game> findByPlayer_PlayerId (String playerId);
    void deleteByPlayer_PlayerId(String playerId);
}
package cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01.model.repository;

import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01.model.domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface PlayerRepository extends JpaRepository <Player, Integer> {

    Optional<Player> findByName (String name);
    boolean existsByNameIgnoreCase(String name);

}


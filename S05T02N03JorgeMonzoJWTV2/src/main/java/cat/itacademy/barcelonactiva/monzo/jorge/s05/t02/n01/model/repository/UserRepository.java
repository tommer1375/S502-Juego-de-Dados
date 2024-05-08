package cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01.model.domain.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository <User, Integer> {

    Optional<User> findUserByName (String name);
    boolean existsByNameIgnoreCase (String name);
}

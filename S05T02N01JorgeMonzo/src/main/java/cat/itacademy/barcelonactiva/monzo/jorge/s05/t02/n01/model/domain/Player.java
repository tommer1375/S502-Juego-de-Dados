package cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01.model.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int playerId;
    @Column
    private String name;
    @Column
    private LocalDateTime registerDate;
    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Game> games;

    public void addGame (Game game){
        if(games == null){
            games = new ArrayList<>();
        }
        games.add(game);
        game.setPlayer(this);
    }

    public float calculateSuccessRate (){
        if(games != null && !games.isEmpty()){
            long totalGames = games.size();
            long wonGames = games.stream().filter(Game::isWon).count();
            return (float) wonGames/totalGames * 100;
        }
        return 0.0f;
    }

}
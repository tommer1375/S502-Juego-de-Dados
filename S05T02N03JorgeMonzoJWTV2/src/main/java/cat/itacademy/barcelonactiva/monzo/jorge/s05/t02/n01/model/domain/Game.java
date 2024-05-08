package cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01.model.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int gameId;
    @Column
    private LocalDate gameDate;
    @Column
    private int dice1;
    @Column
    private int dice2;
    @Column
    private boolean won;
    @ManyToOne
    @JoinColumn(name = "playerId", referencedColumnName = "playerId")
    private Player player;

    public boolean isWon() {
        return dice1 + dice2 == 7;
    }
}
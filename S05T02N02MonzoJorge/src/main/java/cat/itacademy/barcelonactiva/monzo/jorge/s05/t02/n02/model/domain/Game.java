package cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n02.model.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "game")
public class Game {
    @Id
    private String gameId;
    @DBRef
    private Player player;
    private LocalDate gameDate;
    private int dice1;
    private int dice2;
    private boolean won;

    public boolean isWon() {

        return dice1 + dice2 == 7;
    }
}
package cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01.model.dto;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameDTO {
    private int gameId;
    private int dice1;
    private int dice2;
    private boolean won;
}
package cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n02.model.dto;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameDTO {
    private String gameId;
    private int dice1;
    private int dice2;
    private boolean won;
}
package cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01.model.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDTO {
    private int playerId;
    private String name;
    private LocalDateTime registerDate;
    private float successRate;
}
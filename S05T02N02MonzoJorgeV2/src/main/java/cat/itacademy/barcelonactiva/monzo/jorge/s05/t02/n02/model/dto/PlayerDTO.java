package cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n02.model.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDTO {
    private String playerId;
    private String name;
    private LocalDateTime registerDate;
    private float successRate;
}
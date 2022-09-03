package tacos;

import lombok.*;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class TacoIngredientsUPK implements Serializable {

    private String tacoId;

    private String ingredient;
}

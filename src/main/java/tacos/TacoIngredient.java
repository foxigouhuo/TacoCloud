package tacos;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@IdClass(TacoIngredientsUPK.class)
@Table(name = "taco_ingredients")
public class TacoIngredient {
    @Id
    @Column(name = "tacoid")
    private String tacoId;
    @Id
    @Column(name = "ingredient")
    private String ingredient;
}

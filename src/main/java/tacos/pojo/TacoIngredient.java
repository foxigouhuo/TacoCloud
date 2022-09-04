package tacos.pojo;


import lombok.Data;
import tacos.TacoIngredientsUPK;

import javax.persistence.*;

@Data
@Entity
@IdClass(TacoIngredientsUPK.class)
@Table(name = "taco_ingredients")
public class TacoIngredient {
    @Id
    @Column(name = "taco_id")
    private String tacoId;
    @Id
    @Column(name = "ingredient_id")
    private String ingredient;
}

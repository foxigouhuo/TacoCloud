package tacos;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * ASUS
 * 2022/8/20
 * 18:36
 */
@Data
@Entity
public class Taco {
    @Id
    private int id;
    private String name;
    @ManyToMany(targetEntity = Ingredient.class)
    private List<Ingredient> ingredients;

}

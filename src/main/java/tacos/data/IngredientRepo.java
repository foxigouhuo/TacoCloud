package tacos.data;

import org.springframework.data.repository.CrudRepository;
import tacos.Ingredient;

/**
 * ASUS
 * 2022/8/24
 * 10:06
 */
public interface IngredientRepo extends CrudRepository<Ingredient,String> {

}

package tacos.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tacos.pojo.Ingredient;

/**
 * ASUS
 * 2022/8/24
 * 10:06
 */
@Repository
public interface IngredientRepo extends CrudRepository<Ingredient,String> {

    Ingredient findIngredientById(String id);
}

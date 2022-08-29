package tacos.data;

import tacos.Ingredient;

/**
 * ASUS
 * 2022/8/24
 * 10:06
 */
public interface IngredientRepo {
    Iterable<Ingredient> findAll();
    Ingredient findOne(String id);
    Boolean save(Ingredient ingredient);
}

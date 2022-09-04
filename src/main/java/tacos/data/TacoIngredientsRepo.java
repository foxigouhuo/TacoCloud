package tacos.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tacos.pojo.TacoIngredient;

import java.util.List;

@Repository
public interface TacoIngredientsRepo extends CrudRepository<TacoIngredient,String> {

    List<TacoIngredient> findTacoIngredientsByTacoId(String id);
}

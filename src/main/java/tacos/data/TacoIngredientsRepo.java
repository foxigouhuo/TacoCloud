package tacos.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TacoIngredientsRepo extends CrudRepository<tacos.TacoIngredient,String> {

}

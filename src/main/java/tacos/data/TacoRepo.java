package tacos.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tacos.pojo.Taco;

@Repository
public interface TacoRepo extends CrudRepository<Taco,String> {

    Taco findTacoById(String id);
}

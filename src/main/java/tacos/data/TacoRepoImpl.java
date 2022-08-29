package tacos.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import tacos.Taco;

@Repository
public class TacoRepoImpl implements TacoRepo {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public TacoRepoImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }

    @Override
    public Integer saveTaco(Taco taco) {
        jdbcTemplate.update(
                "insert into taco (name) values (?)",
                taco.getName()
        );
        Integer tacoId= jdbcTemplate.queryForObject(
                "select id from taco where name = ?",
                (rs, rowNum) -> rs.getInt("id"),
                taco.getName()
        );
        taco.getIngredients().forEach(x -> this.saveTacoIngredients(x,tacoId));
        return tacoId;
    }

    private void saveTacoIngredients(String ingredientName,int tacoId){
        jdbcTemplate.update(
                "insert into taco_ingredients (ingredientName,tacoId) values (?,?)",
                ingredientName,
                tacoId
        );
    }


}

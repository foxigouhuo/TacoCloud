package tacos.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import tacos.Ingredient;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * ASUS
 * 2022/8/24
 * 10:08
 */
@Repository
public class IngredientRepoImpl implements IngredientRepo{
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public IngredientRepoImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }

    @Override
    public Iterable<Ingredient> findAll() {
        return jdbcTemplate.query(
                "select id,name,type from Ingredient",this::mapRowToIngredient
        );
    }

    @Override
    public Ingredient findOne(String id) {
        return jdbcTemplate.queryForObject(
                "select id ,name,type form Ingredient where id=?",this::mapRowToIngredient,id
        );
    }

    @Override
    public Boolean save(Ingredient ingredient) {
        jdbcTemplate.update(
                "insert into taco_ingredients (name,type) values(?,?)",
                ingredient.getName(),
                ingredient.getType()
        );
        return true;
    }

    private Ingredient mapRowToIngredient(ResultSet rs,int rowNum)throws SQLException {
        return new Ingredient(
                rs.getInt("id"),
                rs.getString("name"),
                Ingredient.Type.valueOf(rs.getString("type")));
    }
}

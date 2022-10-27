package tacos.data.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import tacos.data.sqlProvider.IngredientProvider;
import tacos.pojo.entity.Ingredient;

import java.util.List;

@Mapper
@Repository
public interface IngredientMapper {
    int add(Ingredient ingredient);
    @Results(@Result(property = "type",column = "ingredientType",typeHandler = tacos.data.typehandlers.IngredientsTypeHandler.class))
    @Select("Select * from ingredient where name = #{name} ")
    Ingredient getIngredient(String name);
    @Results(@Result(property = "type",column = "ingredientType",typeHandler = tacos.data.typehandlers.IngredientsTypeHandler.class))
    @Select("Select * from ingredient")
    List<Ingredient> findAll();
}

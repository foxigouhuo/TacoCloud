package tacos.data.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import tacos.data.sqlProvider.Taco_IngredientProvider;
import tacos.pojo.entity.Taco;

@Mapper
public interface Taco_IngredientMapper {
    @InsertProvider(type = Taco_IngredientProvider.class,method = "saveTaco")
    int saveTaco(Taco taco);
}

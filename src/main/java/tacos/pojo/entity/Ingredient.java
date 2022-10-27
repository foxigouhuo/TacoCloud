package tacos.pojo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;
import org.springframework.beans.factory.annotation.Autowired;
import tacos.data.mapper.IngredientMapper;
import tacos.pojo.enums.IngredientEnum;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;


/**
 * ASUS
 * 2022/8/20
 * 18:36
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias(value = "ingredient")

public class Ingredient {

    private String id;
    private String name;
    private IngredientEnum type;
    private String info;

}

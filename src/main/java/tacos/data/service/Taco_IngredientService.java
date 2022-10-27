package tacos.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tacos.data.mapper.Taco_IngredientMapper;
import tacos.pojo.entity.Taco;

@Service
public class Taco_IngredientService {
    private final Taco_IngredientMapper taco_ingredientMapper;

    @Autowired
    public Taco_IngredientService(Taco_IngredientMapper taco_ingredientMapper) {
        this.taco_ingredientMapper = taco_ingredientMapper;
    }

    public int saveTaco(Taco taco){
        return taco_ingredientMapper.saveTaco(taco);
    }
}

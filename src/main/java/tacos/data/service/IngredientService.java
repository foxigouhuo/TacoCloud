package tacos.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tacos.data.mapper.IngredientMapper;
import tacos.pojo.entity.Ingredient;

import java.util.List;

@Service
public class IngredientService {
    private final IngredientMapper ingredientMapper;

    @Autowired
    public IngredientService(IngredientMapper ingredientMapper){
        this.ingredientMapper=ingredientMapper;
    }

    public Ingredient getIngredient(String name){
        return ingredientMapper.getIngredient(name);
    }

    public int addIngredient(Ingredient ingredient){
        return ingredientMapper.add(ingredient);
    }

    public List<Ingredient> findAll(){
        return ingredientMapper.findAll();
    }

}

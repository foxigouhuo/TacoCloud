package tacos.controllers;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tacos.*;
import tacos.data.IngredientRepo;
import tacos.data.OrderTacoRepo;
import tacos.data.TacoIngredientsRepo;
import tacos.data.TacoRepo;
import tacos.pojo.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * ASUS
 * 2022/8/20
 * 19:05
 */
@Controller
@RequestMapping("/designTaco")
@SessionAttributes({"taco","tacoList"})
public class IngredientController {
    private final IngredientRepo ingredientRepo;
    private final TacoRepo tacoRepo;
    private final TacoIngredientsRepo tacoIngredientsRepo;
    private final OrderTacoRepo orderTacoRepo;
    @Autowired
    public IngredientController(IngredientRepo ingredientRepo, TacoRepo tacoRepo, TacoIngredientsRepo tacoIngredientsRepo, OrderTacoRepo orderTacoRepo) {
        this.ingredientRepo = ingredientRepo;
        this.tacoRepo=tacoRepo;
        this.tacoIngredientsRepo = tacoIngredientsRepo;
        this.orderTacoRepo = orderTacoRepo;
    }


    @ModelAttribute("tacoIngredients")
    public IngredientsList tacoIngredients(){
        return new IngredientsList();
    }
    @ModelAttribute("taco")
    public Taco taco(){
        return new Taco();
    }
    @ModelAttribute("tacoList")
    public TacoList tacoList(){
        return new TacoList();
    }


    @GetMapping
    public String beginDesignTacoIngredients(Model model){
        List<Ingredient> ingredients=new ArrayList<>();
        ingredientRepo.findAll().forEach(ingredients::add);
        for(Type type: Type.values()){
            model.addAttribute(type.toString(),filterByType(type,ingredients));
        }
        return "designTacoIngredients";
    }

    @PostMapping
    public String getTacoIngredients (@ModelAttribute IngredientsList ingredientsList,
                                      @ModelAttribute Taco taco,
                                      @ModelAttribute TacoList tacoList){
        saveTaco(taco,ingredientsList);
        tacoList.addTaco(taco);
        return "redirect:tacoOrder";
    }

    public ArrayList<Ingredient> filterByType(Type type,List<Ingredient> ingredients){
        ArrayList<Ingredient> arrayList=new ArrayList<>();
        for(Ingredient ingredient:ingredients){
            if(ingredient.getType().equals(type)){
                arrayList.add(ingredient);
            }
        }
        return arrayList;
    }

    private void saveTaco(Taco taco, IngredientsList ingredientsList){
        String uuid= UUID.randomUUID().toString();
        taco.setId(uuid);
        tacoRepo.save(taco);

        TacoIngredient tacoIngredient = new TacoIngredient();
        tacoIngredient.setTacoId(uuid);
        for(String ingredientName:ingredientsList.getIngredients()){
            tacoIngredient.setIngredient(ingredientName);
            tacoIngredientsRepo.save(tacoIngredient);
        }
    }

}
@Data
class IngredientsList{
    private List<String> ingredients;
}
@Data
class TacoList{
    private List<Taco> tacos=new ArrayList<>();

    public void addTaco(Taco taco){
        tacos.add(taco);
    }
}


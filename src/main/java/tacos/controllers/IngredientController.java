package tacos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tacos.Ingredient;
import tacos.Order;
import tacos.Taco;
import tacos.data.IngredientRepoImpl;
import tacos.data.TacoRepoImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * ASUS
 * 2022/8/20
 * 19:05
 */
@Controller
@RequestMapping("/designTaco")
@SessionAttributes("taco")
public class IngredientController {
    private final IngredientRepoImpl ingredientRepo;
    private final TacoRepoImpl tacoRepo;

    @Autowired
    public IngredientController(IngredientRepoImpl ingredientRepo, TacoRepoImpl tacoRepo) {
        this.ingredientRepo = ingredientRepo;
        this.tacoRepo=tacoRepo;
    }



    @ModelAttribute("taco")
    public Taco taco(){
        return new Taco();
    }

    @GetMapping
    public String beginDesignTacoIngredients(Model model){
        List<Ingredient> ingredients=new ArrayList<>();
        ingredientRepo.findAll().forEach(ingredients::add);
        for(Ingredient.Type type: Ingredient.Type.values()){
            model.addAttribute(type.toString(),filterByType(type,ingredients));
        }
        return "designTacoIngredients";
    }

    @PostMapping
    public String getTacoIngredients (@ModelAttribute Taco taco) {
//        System.out.println("ingredient："+taco);
        taco.setId(tacoRepo.saveTaco(taco));
        return "redirect:tacoOrder";
    }

//    public static List<Ingredient> ingredients = Arrays.asList(
//            new Ingredient("FLTO", "Flour Tortilla", Ingredient.Type.WRAP),
//            new Ingredient("COTO", "Corn Tortilla", Ingredient.Type.WRAP),
//            new Ingredient("GRBF", "Ground Beef", Ingredient.Type.PROTEIN),
//            new Ingredient("CARN", "Carnitas", Ingredient.Type.PROTEIN),
//            new Ingredient("TMTO", "Diced Tomatoes", Ingredient.Type.VEGETABLE),
//            new Ingredient("LETC", "Lettuce", Ingredient.Type.VEGETABLE),
//            new Ingredient("CHED", "Cheddar", Ingredient.Type.CHEESE),
//            new Ingredient("JACK", "Monterrey Jack", Ingredient.Type.CHEESE),
//            new Ingredient("SLSA", "Salsa", Ingredient.Type.SAUCE),
//            new Ingredient("SRCR", "Sour Cream", Ingredient.Type.SAUCE)
//    );
//
//    public static List<Ingredient> getIngredients(){
//        return ingredients;
//    }
//
    public ArrayList<Ingredient> filterByType(Ingredient.Type type,List<Ingredient> ingredients){
        ArrayList<Ingredient> arrayList=new ArrayList<>();
        for(Ingredient ingredient:ingredients){
            if(ingredient.getType().equals(type)){
                arrayList.add(ingredient);
            }
        }
        return arrayList;
    }
}

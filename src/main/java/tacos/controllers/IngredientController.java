package tacos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tacos.data.service.IngredientService;
import tacos.data.service.OrderService;
import tacos.data.service.TacoService;
import tacos.data.service.Taco_IngredientService;
import tacos.pojo.entity.Ingredient;
import tacos.pojo.entity.Order;
import tacos.pojo.entity.Taco;
import tacos.pojo.enums.IngredientEnum;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * ASUS
 * 2022/8/20
 * 19:05
 */
@Controller
@RequestMapping("/designTaco")
public class IngredientController {
    private final IngredientService ingredientService;
    private final TacoService tacoService;
    private final Taco_IngredientService taco_ingredientService;
    private final HttpSession httpSession;

    @Autowired
    public IngredientController(IngredientService ingredientService, TacoService tacoService, Taco_IngredientService taco_ingredientService, HttpSession httpSession) {
        this.ingredientService = ingredientService;
        this.tacoService = tacoService;
        this.taco_ingredientService = taco_ingredientService;
        this.httpSession = httpSession;
    }

    @GetMapping
    public String beginDesignTacoIngredients(Model model){
        List<Ingredient> ingredients = new ArrayList<>(ingredientService.findAll());
        for(IngredientEnum ingredientEnum: IngredientEnum.values()){
            model.addAttribute(ingredientEnum.toString(),filterByType(ingredientEnum,ingredients));
        }
        model.addAttribute(new Taco());
        return "designTacoIngredients";
    }

    @PostMapping
    public String getTacoIngredients (@ModelAttribute Taco taco){
        saveTaco(taco);
        System.out.println("getTacoIngredients");
        return "redirect:tacoOrder";
    }

    public void saveTaco(Taco taco){
        tacoService.saveTaco(taco);
        taco_ingredientService.saveTaco(taco);
        Order order=httpSession.getAttribute("order")==null?new Order(): (Order) httpSession.getAttribute("order");
        order.addTaco(taco);
        httpSession.setAttribute("order",order);
    }
    public ArrayList<Ingredient> filterByType(IngredientEnum ingredientEnum,List<Ingredient> ingredients){
        ArrayList<Ingredient> arrayList=new ArrayList<>();
        for(Ingredient ingredient:ingredients){
            if(ingredient.getType().equals(ingredientEnum)){
                arrayList.add(ingredient);
            }
        }
        return arrayList;
    }

}


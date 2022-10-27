package tacos.controllers;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import tacos.pojo.entity.Ingredient;
import tacos.pojo.entity.Order;
import tacos.pojo.entity.Taco;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("orderInfo")
@SessionAttributes({"order","taco"})
public class InfoController {
//    private final OrderRepo orderRepo;
//    private final OrderTacoRepo orderTacoRepo;
//    private final TacoRepo tacoRepo;
//    private final IngredientRepo ingredientRepo;
//    private final TacoIngredientsRepo tacoIngredientsRepo;

//    @Autowired
//    public InfoController(OrderRepo orderRepo, OrderTacoRepo orderTacoRepo, TacoRepo tacoRepo, IngredientRepo ingredientRepo, TacoIngredientsRepo tacoIngredientsRepo){
//        this.orderRepo=orderRepo;
//        this.orderTacoRepo = orderTacoRepo;
//        this.tacoRepo = tacoRepo;
//        this.ingredientRepo = ingredientRepo;
//        this.tacoIngredientsRepo = tacoIngredientsRepo;
//    }

    @GetMapping
    public String showOrderInfo(Model model, @ModelAttribute Order order){
//        System.out.println(order.getId());
//        List<OrderTaco> orderTacoList = orderTacoRepo.findOrderTacoByOrderId(order.getId());
////        System.out.println(orderTacoList);
//        OrderInfo orderInfo=new OrderInfo();
//        for (OrderTaco orderTaco : orderTacoList) {
//            Taco taco = tacoRepo.findTacoById(orderTaco.getTacoId());
////            System.out.println(taco);
//            List<TacoIngredient> tacoIngredients=tacoIngredientsRepo.findTacoIngredientsByTacoId(taco.getId());
////            System.out.println(tacoIngredients);
//            List<Ingredient> list=new ArrayList<>();
//            tacoIngredients.forEach(x->list.add(ingredientRepo.findIngredientById(x.getIngredient())));
////            System.out.println(list);
//            orderInfo.getTacoInfos().add(new TacoInfo(taco,list));
//        }
//        model.addAttribute(orderInfo);
        return "showOrderInfo";
//        return "designTacoIngredients";
    }


    @PostMapping
    public String showInfo(SessionStatus sessionStatus){
        sessionStatus.setComplete();
        return "designTacoIngredients";
    }

}
@Data
class OrderInfo{
    private List<TacoInfo> tacoInfos=new ArrayList<>();
}
@Data
@AllArgsConstructor
class TacoInfo{
    private Taco taco;
    private List<Ingredient> ingredients;
}

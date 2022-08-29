package tacos.controllers;

import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import tacos.Order;
import tacos.Taco;
import tacos.data.OrderRepo;
import tacos.data.OrderRepoImpl;

@Controller
@RequestMapping("orderInfo")
@SessionAttributes({"order","taco"})
public class InfoController {
    private OrderRepoImpl orderRepo;

    @Autowired
    public InfoController(OrderRepoImpl orderRepo){
        this.orderRepo=orderRepo;
    }

    @GetMapping
    public String showOrderInfo(Model model,
                                @ModelAttribute Order order,
                                @ModelAttribute Taco taco){
        model.addAttribute(order);
        model.addAttribute(taco);
        return "showOrderInfo";
    }

    @PostMapping
    public String showInfo(SessionStatus sessionStatus){
        sessionStatus.setComplete();
        return "designTacoIngredients";
    }

}

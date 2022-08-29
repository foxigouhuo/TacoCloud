package tacos.controllers;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ASUS
 * 2022/8/23
 * 17:37
 */
@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping
    public String toDesignTaco(){
        return "redirect:designTaco";
    }
}

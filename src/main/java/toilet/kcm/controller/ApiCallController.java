package toilet.kcm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ApiCallController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String ApiCallTest(Model model){
        model.addAttribute("hello","Thymeleaf Call Test.");
        return "/index";
    }

}

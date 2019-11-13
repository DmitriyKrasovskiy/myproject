package by.pvt;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.util.logging.Logger;

@Controller
@RequestMapping("/home")
public class HomeController {

    private static Logger log=Logger.getLogger("HomeController");

    public HomeController() {
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showHomePage(){
        return "homePage";
    }

}

package rocks.process.Studentstuff.Studentstuffweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/")
public class HomeController {

    @GetMapping
    public String getHomeView(){
        return "Home.html";
    }

}

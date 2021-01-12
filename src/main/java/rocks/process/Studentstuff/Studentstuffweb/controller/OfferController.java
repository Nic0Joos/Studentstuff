package rocks.process.Studentstuff.Studentstuffweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/market")
public class OfferController {

    @GetMapping
    public String getMarketView() {return "Marketplace.html";}
}


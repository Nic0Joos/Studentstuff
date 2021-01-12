package rocks.process.Studentstuff.Studentstuffweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;
import rocks.process.Studentstuff.Studentstuffweb.business.service.CustomerService;
import rocks.process.Studentstuff.Studentstuffweb.data.domain.Customer;

@Controller
@RequestMapping(path = "/offer")
public class CustomerController {

    @Autowired
    private Offerservice offerservice;

       @GetMapping(path = "/create")
    public String getCustomerCreateView() {
        return "CreateOffer.html";
    }



}



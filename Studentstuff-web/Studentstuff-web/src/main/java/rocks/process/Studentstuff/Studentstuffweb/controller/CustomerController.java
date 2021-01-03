package rocks.process.Studentstuff.Studentstuffweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;
import rocks.process.Studentstuff.Studentstuffweb.business.service.CustomerService;
import rocks.process.Studentstuff.Studentstuffweb.data.domain.Customer;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/user/register")
    public ResponseEntity<Void> postRegister(@RequestBody Customer customer) {
        try {
            customerService.saveCustomer(customer);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage());
        }
        return ResponseEntity.ok().build();
    }

    @RequestMapping (path = "/edit")
        public String getCustomerEditView() {return "EditAccount.html"}

        @GetMapping ("/create")
            public string getCustomerCreateView() {return "CreateOffer.html"}

        @GetMapping ("/buy")
            public string getMarketplaceView() {return "Marketplace.html"}

        @GetMapping ("/Policy")
            public string getPolicyView() {return "PrivacyPolicy.html"}





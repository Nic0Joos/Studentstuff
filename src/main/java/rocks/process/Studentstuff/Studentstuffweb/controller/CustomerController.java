package rocks.process.Studentstuff.Studentstuffweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import rocks.process.Studentstuff.Studentstuffweb.business.service.CustomerService;
import rocks.process.Studentstuff.Studentstuffweb.data.domain.Customer;

@Controller
@RequestMapping(path = "/customer")
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

    @GetMapping(path = "/edit")
    public String getCustomerEditView() {
        return "EditAccount.html";
    }

    @GetMapping(path = "/create")
    public String getCustomerCreateView() {
        return "CreateOffer.html";
    }

    @GetMapping(path = "/Policy")
    public String getPolicyView() {
        return "PrivacyPolicy.html";
    }

    @PutMapping("/edit")
    public ResponseEntity<Void> putProfile(@RequestBody Customer customer) {
        try {
              customerService.saveCustomer(customer);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage());
        }
        return ResponseEntity.ok().build();
    }

}



package rocks.process.Studentstuff.Studentstuffweb.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import rocks.process.Studentstuff.Studentstuffweb.business.service.CustomerService;
import rocks.process.Studentstuff.Studentstuffweb.data.domain.Customer;

import javax.validation.ConstraintViolationException;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path ="/api")
public class CustomerEndpoint {

    @Autowired
    private CustomerService customerService;

    @PostMapping(path = "/customer", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Customer> postCustomer(@RequestBody Customer customer) {
        try {
            customer = customerService.editCustomer(customer);
        } catch (ConstraintViolationException e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getConstraintViolations().iterator().next().getMessage());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{customerId}")
                .buildAndExpand(customer.getId()).toUri();

        return ResponseEntity.created(location).body(customer);
    }


}


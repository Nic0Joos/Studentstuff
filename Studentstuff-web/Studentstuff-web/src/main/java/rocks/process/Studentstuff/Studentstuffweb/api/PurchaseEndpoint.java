package rocks.process.Studentstuff.Studentstuffweb.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import rocks.process.Studentstuff.Studentstuffweb.business.service.PurchaseService;
import rocks.process.Studentstuff.Studentstuffweb.data.domain.Purchase;

import javax.validation.ConstraintViolationException;
import java.net.URI;

@RestController
@RequestMapping(path ="/api")
public class PurchaseEndpoint {

    @Autowired
    private PurchaseService purchaseService;

    @PostMapping(path = "/market", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Purchase> postPurchase(@RequestBody Purchase purchase) {
        try {
            purchase = purchaseService.editPurchase(purchase);
        } catch (ConstraintViolationException e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getConstraintViolations().iterator().next().getMessage());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{PurchaseID}")
                .buildAndExpand(purchase.getId()).toUri();

        return ResponseEntity.created(location).body(purchase);
    }


}


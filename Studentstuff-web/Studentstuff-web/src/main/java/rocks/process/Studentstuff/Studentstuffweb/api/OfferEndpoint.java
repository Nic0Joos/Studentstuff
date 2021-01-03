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
import rocks.process.Studentstuff.Studentstuffweb.business.service.OfferService;
import rocks.process.Studentstuff.Studentstuffweb.data.domain.Offer;

import javax.validation.ConstraintViolationException;
import java.net.URI;

@RestController
@RequestMapping(path ="/api")
public class OfferEndpoint {

    @Autowired
    private OfferService offerService;

    @PostMapping(path = "/offer", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Offer> postOffer(@RequestBody Offer offer) {
        try {
            offer = offerService.editOffer(offer);
        } catch (ConstraintViolationException e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getConstraintViolations().iterator().next().getMessage());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{customerId}")
                .buildAndExpand(offer.getId()).toUri();

        return ResponseEntity.created(location).body(offer);
    }


}

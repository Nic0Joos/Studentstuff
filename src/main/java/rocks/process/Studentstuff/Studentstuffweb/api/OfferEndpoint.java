package rocks.process.Studentstuff.Studentstuffweb.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import rocks.process.Studentstuff.Studentstuffweb.business.service.OfferService;
import rocks.process.Studentstuff.Studentstuffweb.data.domain.Offer;

import javax.validation.ConstraintViolationException;
import java.net.URI;
import java.util.List;

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
                .fromCurrentRequest().path("/{OfferID}")
                .buildAndExpand(offer.getOfferId()).toUri();

        return ResponseEntity.created(location).body(offer);
    }

    @GetMapping(path = "/market", produces = "application/json")
    public List<Offer> getOffers() {
        return offerService.findAllOpenOffers();
    }

    @GetMapping(path = "/offer", produces = "application/json")
    public List<Offer> getMyOffers(){return offerService.findMyOffers();}

    @DeleteMapping(path = "/offer/delete/{OfferID}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable(value = "OfferID") String OfferID) {
        try {
            offerService.deleteOffer(Long.parseLong(OfferID));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage());
        }
        return ResponseEntity.accepted().build();
    }

    @PutMapping(path = "/market/buy", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Offer> putOffer (@RequestBody Offer offer, @PathVariable(value = "OfferID")String OfferID){
    try {
        offer.setOfferId(Long.parseLong(OfferID));
        offer =offerService.putOffer(offer);
    } catch (Exception e) {
        throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage());
    }
        return ResponseEntity.accepted().body(offer);
    }



}


/*
 * Copyright (c) 2020. University of Applied Sciences and Arts Northwestern Switzerland FHNW.
 * All rights reserved.
 */

package rocks.process.Studentstuff.Studentstuffweb.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import rocks.process.Studentstuff.Studentstuffweb.data.domain.Offer;
import rocks.process.Studentstuff.Studentstuffweb.data.repository.OfferRepository;

import javax.validation.Valid;
import java.util.List;

@Service
@Validated
public class OfferService {

    @Autowired
    private OfferRepository offerRepository;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private Offer offer;

    public Offer editOffer(@Valid Offer offer) throws Exception {
        offer.setProvider(customerService.getCurrentCustomer());
        offer.setOpen(true);
        return offerRepository.save(offer);
    }

    public Offer putOffer(@Valid Offer offer) throws Exception {
        offer.setOpen(false);
        return offerRepository.save(offer);
    }

    public List<Offer> findAllOpenOffers() {
        return offerRepository.findAllOpenOffers(offer.isOpen());
    }

    public List<Offer> findMyOffers() {
        return offerRepository.findMyOffers(customerService.getCurrentCustomer().getId());
    }

    public void deleteOffer(Long OfferID)
    {
        offerRepository.deleteById(OfferID);
    }


}

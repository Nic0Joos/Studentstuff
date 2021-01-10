/*
 * Copyright (c) 2020. University of Applied Sciences and Arts Northwestern Switzerland FHNW.
 * All rights reserved.
 */

package rocks.process.Studentstuff.Studentstuffweb.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import rocks.process.Studentstuff.Studentstuffweb.data.domain.Purchase;
import rocks.process.Studentstuff.Studentstuffweb.data.repository.PurchaseRepository;

import javax.validation.Valid;

@Service
@Validated
public class PurchaseService {

    @Autowired
    private PurchaseRepository PurchaseRepository;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerService offerService;
    @Autowired
    private Purchase purchase;

    public Purchase editPurchase(@Valid Purchase purchase) throws Exception {
        purchase.setBuyer(customerService.getCurrentCustomer());

        return PurchaseRepository.save(purchase);
    }

}

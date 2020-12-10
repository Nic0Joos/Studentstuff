/*
 * Copyright (c) 2020. University of Applied Sciences and Arts Northwestern Switzerland FHNW.
 * All rights reserved.
 */

package rocks.process.Studentstuff.Studentstuffweb.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import rocks.process.Studentstuff.Studentstuffweb.data.domain.Seller;
import rocks.process.Studentstuff.Studentstuffweb.data.repository.SellerRepository;

import javax.validation.Valid;
import java.util.List;

@Service
@Validated
public class SellerService {

	@Autowired
	private SellerRepository SellerRepository;



}

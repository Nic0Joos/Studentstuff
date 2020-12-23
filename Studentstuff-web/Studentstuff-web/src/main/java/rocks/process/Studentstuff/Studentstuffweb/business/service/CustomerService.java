/*
 * Copyright (c) 2020. University of Applied Sciences and Arts Northwestern Switzerland FHNW.
 * All rights reserved.
 */

package rocks.process.Studentstuff.Studentstuffweb.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import rocks.process.Studentstuff.Studentstuffweb.data.domain.Customer;
import rocks.process.Studentstuff.Studentstuffweb.data.repository.CustomerRepository;

@Service
@Validated
public class CustomerService {

	@Autowired
	private CustomerRepository CustomerRepository;

	public void deleteCustomer(Long customerId)
	{
		CustomerRepository.deleteById(customerId);
	}



}

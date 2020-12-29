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

import javax.validation.Valid;

@Service
@Validated
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public Customer editCustomer(@Valid Customer customer) throws Exception {
		if (customer.getId() == null) {
			if (customerRepository.findByMail(customer.getEmail()) == null) {

				return customerRepository.save(customer);
			}
			throw new Exception("Email " + customer.getEmail() + " already assigned to a customer.");
		}
		if (customerRepository.findyByMailAndIdNot(customer.getEmail(), customer.getId()) == null) {

			return customerRepository.save(customer); //If mail and ID doesn't exist -> save
		}
		throw new Exception("Email " + customer.getEmail() + " already assigned to a customer.");
	}
}

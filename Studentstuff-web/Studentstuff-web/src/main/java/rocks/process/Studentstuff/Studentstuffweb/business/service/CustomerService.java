/*
 * Copyright (c) 2020. University of Applied Sciences and Arts Northwestern Switzerland FHNW.
 * All rights reserved.
 */

package rocks.process.Studentstuff.Studentstuffweb.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import rocks.process.Studentstuff.Studentstuffweb.data.domain.Customer;
import rocks.process.Studentstuff.Studentstuffweb.data.repository.CustomerRepository;

import javax.validation.Valid;
import javax.validation.Validator;

@Service
@Validated
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	Validator validator;
	@Autowired
	PasswordEncoder passwordEncoder;

	public void saveCustomer(@Valid Customer customer) throws Exception {
		if (customer.getId() == null) {
			if (customerRepository.findByMail(customer.getEmail()) != null) {
				throw new Exception("Email address " + customer.getEmail() + " already in use.");
			}
		} else if (customerRepository.findyByMailAndIdNot(customer.getEmail(), customer.getId()) != null) {
			throw new Exception("Email address " + customer.getEmail() + " already in use.");
		}
		customer.setPassword(passwordEncoder.encode(customer.getPassword()));
		customerRepository.save(customer);
	}

	public Customer getCurrentCustomer() {
		String userEmail = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return customerRepository.findByMail(userEmail);
	}
}

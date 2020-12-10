/*
 * Copyright (c) 2020. University of Applied Sciences and Arts Northwestern Switzerland FHNW.
 * All rights reserved.
 */

package rocks.process.Studentstuff.Studentstuffweb.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rocks.process.Studentstuff.Studentstuffweb.data.domain.Seller;

import java.util.List;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long> {
	Seller findByMobile(String mobile);
	Seller findByMobileAndIdNot(String mobile, Long SellerId);

}
package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.PaymentDetails;

@Repository
public interface PaymentDetailsRepo extends JpaRepository<PaymentDetails, Integer> {
	@Query(value="select * from payment_details p where p.email=:email",nativeQuery = true)
	public List<PaymentDetails> findByEmail(String email);
}

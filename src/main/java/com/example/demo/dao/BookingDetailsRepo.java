package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.BookingDetails;

@Repository
public interface BookingDetailsRepo extends JpaRepository<BookingDetails, Integer>{
	@Query(value="select * from booking_details b where b.email=:email",nativeQuery = true)
	public List<BookingDetails> findByEmail(String email);
}

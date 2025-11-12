package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.AddCust;

@Repository
public interface AddCustRepo extends JpaRepository<AddCust, Long> {
	@Query(value="select * from add_cust c where c.email=:email",nativeQuery = true)
	public AddCust findByEmail(String email);
}

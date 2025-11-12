package com.example.demo.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.AddBus;

@Repository
public interface BookBusRepo extends JpaRepository<AddBus, Integer> {
	@Query(value="select * from add_bus a where a.source=:source and a.dest=:dest and a.date=:date",nativeQuery = true)
	public List<AddBus> findBySrcAndDestAndDate(String source, String dest, LocalDate date);
}

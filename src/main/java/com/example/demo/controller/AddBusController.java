package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dao.AddBusRepo;
import com.example.demo.model.AddBus;
import com.example.demo.model.AddBus;

@Controller
public class AddBusController {
	
	@Autowired
	AddBusRepo repo;
	
	@PostMapping("/insertBus")
	public String insertBusData(AddBus ab)
	{
		repo.save(ab);
		return "redirect:/adminhome.html";
	}
	
	@GetMapping("/updateBus")
	public String updateBusData(AddBus ab)
	{
		AddBus abus=repo.findById(ab.getBusno()).get();
		abus.setSource(ab.getSource());
		abus.setDest(ab.getDest());
		abus.setDate(ab.getDate());
		abus.setTime(ab.getTime());
		abus.setFare(ab.getFare());
		repo.save(abus);
		return "redirect:/adminhome.html";
	}
	
	@GetMapping("/deleteBus")
	public String deleteBusData(int busno)
	{
		repo.deleteById(busno);
		return "redirect:/adminhome.html";
	}
	
	@GetMapping("/displayAllBus")
	public String displayBus(Model m)
	{
		List<AddBus> abus=repo.findAll();
		m.addAttribute("AddBus", abus);
		return "viewallbus";
	}
	
	@GetMapping("/searchBus")
	public String displaySingleBus(int busno, Model m)
	{
		AddBus abus=repo.findById(busno).get();
		m.addAttribute("AddBus", abus);
		return "viewsinglebus";
	}
	
}

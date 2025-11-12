package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.dao.BookBusRepo;
import com.example.demo.model.AddBus;
import com.example.demo.model.BookBus;

@Controller
public class BookBusController {
	@Autowired
	BookBusRepo repo;
	
	@GetMapping("/displaySearchBus")
	public String showSearchBus(BookBus bb,Model m)
	{
		List<AddBus> abus=(List<AddBus>)repo.findBySrcAndDestAndDate(bb.getSource(), bb.getDest(), bb.getDate());
		m.addAttribute("ShowBus", abus);
		return "displaysearchbus";
	}
	
}

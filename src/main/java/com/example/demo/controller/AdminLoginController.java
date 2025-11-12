package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.dao.AdminLoginRepo;
import com.example.demo.dao.BookingDetailsRepo;
import com.example.demo.model.AdminLogin;
import com.example.demo.model.BookingDetails;

import java.util.List;
@Controller
public class AdminLoginController {
	@Autowired
	AdminLoginRepo adminrepo;
	
	@Autowired
	BookingDetailsRepo bdetailsrepo;
	
	@GetMapping("/verifyAdmin")
	public String checkAdmin(String email, String password)
	{
		List<AdminLogin> admin=(List<AdminLogin>)adminrepo.findAll();
		for(AdminLogin a:admin)
		{
			if(a.getEmail().equals(email) && a.getPassword().equals(password))
			{
				return "redirect:/adminhome.html";
			}
		}
		return "redirect:/adminlogin.html";
	}
	
	@GetMapping("/displayAllBookings")
	public String dispAllBookings(Model m)
	{
		List<BookingDetails> bookdetails=(List<BookingDetails>)bdetailsrepo.findAll();
		m.addAttribute("BookDetails", bookdetails);
		return "dispallbookings";
	}
	
}

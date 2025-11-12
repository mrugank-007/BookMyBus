package com.example.demo.controller;

import java.util.Enumeration;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dao.AddCustRepo;
import com.example.demo.model.AddCust;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class AddCustController {
	@Autowired
	AddCustRepo repo;
	
	@PostMapping("/insertCust")
	public String insertCustomer(AddCust cust)
	{
		repo.save(cust);
		return "redirect:/index.html";
	}
	
	@GetMapping("/displayAllCust")
	public String displayAllCustomer(Model m)
	{
		List<AddCust> cust=(List<AddCust>)repo.findAll();
		m.addAttribute("Customer", cust);
		return "viewallcustomer";
	}
	
	@GetMapping("/checkUser")
	public String verifyUser(String email,String password,HttpSession session)
	{
		session.setAttribute("email", email);
		System.out.println(session.getId());
		List<AddCust> cust=(List<AddCust>)repo.findAll();
		for(AddCust ac:cust)
		{
			if(ac.getEmail().equals(email) && ac.getPassword().equals(password))
			{
				return "redirect:/homepage.html";
			}
		}
		return "redirect:/index.html";
		
	}
	
	@PostMapping("/updateCust")
	public String updateCustDetails(HttpSession session,AddCust ac)
	{
		String mail=(String)session.getAttribute("email");
		AddCust cust=(AddCust)repo.findByEmail(mail);
		cust.setFname(ac.getFname());
		cust.setLname(ac.getLname());
		cust.setContactno(ac.getContactno());
		cust.setEmail(ac.getEmail());
		cust.setPassword(ac.getPassword());
		repo.save(cust);
		return "redirect:/homepage.html";
	}
	
	@GetMapping("/logout")
	public String logoutUser(HttpServletRequest request)
	{
		HttpSession session=request.getSession();
		session.invalidate();
		return "redirect:/index.html";
	}
}

package com.example.demo.controller;

import java.awt.print.Book;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.AddBusRepo;
import com.example.demo.dao.BookingDetailsRepo;
import com.example.demo.dao.PaymentDetailsRepo;
import com.example.demo.model.AddBus;
import com.example.demo.model.BookBus;
import com.example.demo.model.BookingDetails;
import com.example.demo.model.PaymentDetails;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;

@Controller
public class BookingDetailsController {
	@Autowired
	BookingDetailsRepo bdetailsrepo;
	
	@Autowired
	AddBusRepo abusrepo;
	
	@Autowired
	PaymentDetailsRepo paydetailsrepo;
	
	@PostMapping("/addBookData")
	public String addBookingData(int busno,HttpSession context)
	{		
		AddBus abus=abusrepo.findById(busno).get();
		String mail=(String)context.getAttribute("email");
		context.setAttribute("mail", mail);
		context.setAttribute("busno", abus.getBusno());
		context.setAttribute("source", abus.getSource());
		context.setAttribute("dest", abus.getDest());
		context.setAttribute("date", abus.getDate());
		context.setAttribute("time", abus.getTime());
		context.setAttribute("fare", abus.getFare());
		return "redirect:/selectbusseat.html";
	}
	
	@PostMapping("/selectSeat")
	public String selectSeats(HttpSession context,@RequestParam("seats")List<String> getSeats)
	{
		BookingDetails bdetails=new BookingDetails();
		bdetails.setEmail((String) context.getAttribute("mail"));
		bdetails.setBusno((int) context.getAttribute("busno"));
		bdetails.setSource((String) context.getAttribute("source"));
		bdetails.setDest((String) context.getAttribute("dest"));
		bdetails.setDate((LocalDate) context.getAttribute("date"));
		bdetails.setTime((String) context.getAttribute("time"));
		bdetails.setFare((int) context.getAttribute("fare")*getSeats.size());
		//System.out.println(getSeats);
		bdetails.setGetSeats(getSeats);
		//bdetailsrepo.save(bdetails);
		
		
		int fare=(int)context.getAttribute("fare"); 
		int amt=(getSeats.size()*fare);
		context.setAttribute("amount", amt);
		
		context.setAttribute("bookingdata", bdetails);
		return "paymentpage";
		//return "redirect:/index.html";
	}
	
	@GetMapping("/viewBookings")
	public String viewBookingDetails(HttpSession session,Model m)
	{
		String mail=(String)session.getAttribute("email");
		List<BookingDetails> bdetails=(List<BookingDetails>)bdetailsrepo.findByEmail(mail);
		m.addAttribute("BookingDetails", bdetails);
		return "viewbookingdetail";
	}
	
	@GetMapping("/cancelBus")
	public String cancelBusBooking(int bookingid)
	{
		bdetailsrepo.deleteById(bookingid);
		return "redirect:/homepage.html";
	}
	
}
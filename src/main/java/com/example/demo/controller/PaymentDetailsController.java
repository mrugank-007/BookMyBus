package com.example.demo.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dao.BookingDetailsRepo;
import com.example.demo.dao.PaymentDetailsRepo;
import com.example.demo.model.BookingDetails;
import com.example.demo.model.PaymentDetails;

import jakarta.servlet.http.HttpSession;

@Controller
public class PaymentDetailsController {
	@Autowired
	PaymentDetailsRepo payrepo;
	
	@Autowired
	BookingDetailsRepo bookrepo;
	
	@PostMapping("/makePayment")
	public String makeFinalPayment(HttpSession session,PaymentDetails pd)
	{
		BookingDetails bdetails=new BookingDetails();
		bdetails=(BookingDetails)session.getAttribute("bookingdata");
		bookrepo.save(bdetails);
		
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		PaymentDetails pdetails=new PaymentDetails();
		pdetails.setEmail((String)session.getAttribute("email"));
		pdetails.setAmount(pd.getAmount());
		pdetails.setDatetime(dtf.format(LocalDateTime.now()));
		pdetails.setCardno(pd.getCardno());
		pdetails.setExpirymonth(pd.getExpirymonth());
		pdetails.setExpiryyear(pd.getExpiryyear());
		pdetails.setCvv(pd.getCvv());
		pdetails.setDetails(pd.getDetails());
		payrepo.save(pdetails);
		return "redirect:/homepage.html";
	}
	
	@GetMapping("/viewPayment")
	public String getPaymentDetails(HttpSession session,Model m)
	{
		String mail=(String)session.getAttribute("email");
		List<PaymentDetails> paydetails=(List<PaymentDetails>)payrepo.findByEmail(mail);
		m.addAttribute("PaymentDetail", paydetails);
		return "viewpaymentdetails";
		
	}
}

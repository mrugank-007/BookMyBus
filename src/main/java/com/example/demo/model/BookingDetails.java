package com.example.demo.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BookingDetails {
	private String email;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int booking_id;
	private int busno;
	private String source;
	private String dest;
	private LocalDate date;
	private String time;
	private int fare;
//	private String[] getSeats;
	private List<String> getSeats;
	public BookingDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BookingDetails(String email, int booking_id, int busno, String source, String dest, LocalDate date,
			String time, int fare, List<String> getSeats) {
		super();
		this.email = email;
		this.booking_id = booking_id;
		this.busno = busno;
		this.source = source;
		this.dest = dest;
		this.date = date;
		this.time = time;
		this.fare = fare;
		this.getSeats = getSeats;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getBooking_id() {
		return booking_id;
	}
	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}
	public int getBusno() {
		return busno;
	}
	public void setBusno(int busno) {
		this.busno = busno;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDest() {
		return dest;
	}
	public void setDest(String dest) {
		this.dest = dest;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getFare() {
		return fare;
	}
	public void setFare(int fare) {
		this.fare = fare;
	}
	public List<String> getGetSeats() {
		return getSeats;
	}
	public void setGetSeats(List<String> getSeats) {
		this.getSeats = getSeats;
	}
	
}

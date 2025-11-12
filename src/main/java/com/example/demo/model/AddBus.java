package com.example.demo.model;

import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class AddBus {
	@Id
	private int busno;
	private String source;
	private String dest;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;
	private String time;
	private int fare;

	public AddBus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AddBus(int busno, String source, String dest, LocalDate date, String time, int fare) {
		super();
		this.busno = busno;
		this.source = source;
		this.dest = dest;
		this.date = date;
		this.time = time;
		this.fare = fare;
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

	@Override
	public String toString() {
		return "AddBus [busno=" + busno + ", source=" + source + ", dest=" + dest + ", date=" + date + ", time=" + time
				+ ", fare=" + fare + "]";
	}

	
}

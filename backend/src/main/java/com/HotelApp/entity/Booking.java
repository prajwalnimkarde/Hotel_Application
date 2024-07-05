package com.HotelApp.entity;

import java.time.LocalDate;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "bookings")
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "check in date is required")
	private LocalDate checkInDate;
	
	@NotNull(message = "check out date must be in the future")
	private LocalDate checkOutDate;
	
	@Min(value = 1, message = "Number of adults cannot be less than 1")
	private int numOfAdults;
	
	private int numOfChildren;
	
	private int totalNumOfGuest;
	private String bookingConfirmationCode;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "room_id")
	private Room room;
	
	
	public void calculateTotalGuest() {
		this.totalNumOfGuest = this.numOfAdults + this.numOfChildren;
	}


	public void setNumOfAdults(int numOfAdults) {
		this.numOfAdults = numOfAdults;
		calculateTotalGuest();
	}


	public void setNumOfChildren(int numOfChildren) {
		this.numOfChildren = numOfChildren;
		calculateTotalGuest();
	}


	@Override
	public String toString() {
		return "Booking [id=" + id + 
				", checkInDate=" + checkInDate + 
				", checkOutDate=" + checkOutDate + 
				", numOfAdults=" + numOfAdults + 
				", numOfChildren=" + numOfChildren + 
				", totalNumOfGuest=" + totalNumOfGuest + 
				", bookingConfirmationCode=" + bookingConfirmationCode + 
				"]";
	}
	
	
	
	
	
}

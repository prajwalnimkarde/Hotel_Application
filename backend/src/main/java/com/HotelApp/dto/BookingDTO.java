package com.HotelApp.dto;

import java.time.LocalDate;
import com.HotelApp.entity.Room;
import com.HotelApp.entity.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookingDTO {

	private Long id;
	private LocalDate checkInDate;
	private LocalDate checkOutDate;
	private int numOfAdults;
	private int numOfChildren;
	private int totalNumOfGuest;
	private String bookingConfirmationCode;
	private UserDTO user;
	private RoomDTO room;
}

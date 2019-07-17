package com.cg.onlinehotelmanagementsystem.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="bookingdetails")

public class BookingDetailsDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="book_seq")
	@SequenceGenerator(name="book_seq", sequenceName="book_seq", allocationSize=1)
	private int bookingid;
	
	@Column(name="checkin")
	private LocalDate checkinbook;
	
	@Column(name="checkout")
	private LocalDate checkoutbook;
	
	private Double amount;
	
	@OneToOne
	@JoinColumn(name="roomid")
	private RoomDetailsDTO roomDetailsDTO;
	
	@OneToOne
	@JoinColumn(name="hotelid")
	private HotelDetailsDTO hotelDetailsDTO;
	
	@OneToOne
	@JoinColumn(name="customerid")
	private CustomerDataDTO userDataDTO;

	public int getBookingid() {
		return bookingid;
	}

	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}

	public LocalDate getCheckinbook() {
		return checkinbook;
	}

	public void setCheckinbook(LocalDate checkinbook) {
		this.checkinbook = checkinbook;
	}

	public LocalDate getCheckoutbook() {
		return checkoutbook;
	}

	public void setCheckoutbook(LocalDate checkoutbook) {
		this.checkoutbook = checkoutbook;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public RoomDetailsDTO getRoomDetailsDTO() {
		return roomDetailsDTO;
	}

	public void setRoomDetailsDTO(RoomDetailsDTO roomDetailsDTO) {
		this.roomDetailsDTO = roomDetailsDTO;
	}

	public HotelDetailsDTO getHotelDetailsDTO() {
		return hotelDetailsDTO;
	}

	public void setHotelDetailsDTO(HotelDetailsDTO hotelDetailsDTO) {
		this.hotelDetailsDTO = hotelDetailsDTO;
	}

	public CustomerDataDTO getUserDataDTO() {
		return userDataDTO;
	}

	public void setUserDataDTO(CustomerDataDTO userDataDTO) {
		this.userDataDTO = userDataDTO;
	}
	
	
	

	
}

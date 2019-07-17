package com.cg.onlinehotelmanagementsystem.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="roomdetails")
public class RoomDetailsDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	@Column(name="number_of_persons")
	private int numberOfPersons;
	private String roomType;
	@Id
	@Column(name="roomid")
	private int roomId;
	private double price;
	@OneToMany(mappedBy="roomDetailsDTO")
	private List<BookingDetailsDTO> bookingDetailsDTO=new ArrayList<BookingDetailsDTO>();
	public int getNumberOfPersons() {
		return numberOfPersons;
	}

	public void setNumberOfPersons(int numberOfPersons) {
		this.numberOfPersons = numberOfPersons;
	}

	public String getRoomType() {
		return roomType;
	}

	public List<BookingDetailsDTO> getBookingDetailsDTO() {
		return bookingDetailsDTO;
	}

	public void setBookingDetailsDTO(List<BookingDetailsDTO> bookingDetailsDTO) {
		this.bookingDetailsDTO = bookingDetailsDTO;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}

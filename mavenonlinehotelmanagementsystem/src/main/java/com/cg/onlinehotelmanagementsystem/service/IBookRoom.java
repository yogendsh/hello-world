package com.cg.onlinehotelmanagementsystem.service;


import com.cg.onlinehotelmanagementsystem.dto.BookingDetailsDTO;
import com.cg.onlinehotelmanagementsystem.dto.RoomDetailsDTO;
import com.cg.onlinehotelmanagementsystem.exception.ExceptionHandler;

public interface IBookRoom {
	int bookRoom(RoomDetailsDTO roomDetailsDTO,BookingDetailsDTO bookingDetailsDTO)throws ExceptionHandler;

	void cancelBooking(int bookingId)throws ExceptionHandler;

}

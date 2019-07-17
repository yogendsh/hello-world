package com.cg.onlinehotelmanagementsystem.dao;



import com.cg.onlinehotelmanagementsystem.dto.BookingDetailsDTO;
import com.cg.onlinehotelmanagementsystem.dto.CustomerDataDTO;
import com.cg.onlinehotelmanagementsystem.dto.HotelDetailsDTO;
import com.cg.onlinehotelmanagementsystem.dto.RoomDetailsDTO;
import com.cg.onlinehotelmanagementsystem.exception.ExceptionHandler;

public interface IBookingDAO {
	int bookingConnection(int roomId,BookingDetailsDTO bookingDetailsDTO) throws ExceptionHandler;
	int setBookingDetails(BookingDetailsDTO bookingDetailsDTO, RoomDetailsDTO roomDetailsDTO,HotelDetailsDTO hotelDetailsDTO,CustomerDataDTO customerDataDTO) throws ExceptionHandler;

}

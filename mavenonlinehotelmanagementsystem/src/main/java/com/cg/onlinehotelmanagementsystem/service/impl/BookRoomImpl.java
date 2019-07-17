package com.cg.onlinehotelmanagementsystem.service.impl;




import java.time.temporal.ChronoUnit;

import com.cg.onlinehotelmanagementsystem.dao.BookingDAO;
import com.cg.onlinehotelmanagementsystem.dto.BookingDetailsDTO;
import com.cg.onlinehotelmanagementsystem.dto.CustomerDataDTO;
import com.cg.onlinehotelmanagementsystem.dto.HotelDetailsDTO;
import com.cg.onlinehotelmanagementsystem.dto.RoomDetailsDTO;
import com.cg.onlinehotelmanagementsystem.exception.ExceptionHandler;
import com.cg.onlinehotelmanagementsystem.service.IBookRoom;
import com.cg.onlinehotelmanagementsystem.utility.IExceptionClass;
import com.cg.onlinehotelmanagementsystem.utility.Validation;

public class BookRoomImpl implements IBookRoom {
	public int bookRoom(RoomDetailsDTO roomDetailsDTO, BookingDetailsDTO bookingDetailsDTO) throws ExceptionHandler {
		
		
		BookingDAO bookingDAO = new BookingDAO();
		Validation validation = new Validation();
		validation.dateCheckIn(bookingDetailsDTO.getCheckinbook());
		validation.dateCheckout(bookingDetailsDTO.getCheckinbook(), bookingDetailsDTO.getCheckoutbook());
		validation.isValidRoom(roomDetailsDTO);
		CustomerDataDTO userDataDTO=new CustomerDataDTO();
		userDataDTO.setCustomerID(1);
		HotelDetailsDTO hotelDetailsDTO=new HotelDetailsDTO();
		hotelDetailsDTO.setHotelid(123456);
		System.out.println("26");
		bookingDetailsDTO.setAmount(roomDetailsDTO.getPrice()* ChronoUnit.DAYS.between(bookingDetailsDTO.getCheckinbook(), bookingDetailsDTO.getCheckoutbook()));
		int numberOfColumn = bookingDAO.bookingConnection(roomDetailsDTO.getRoomId(),bookingDetailsDTO);
		System.out.println("1");
		if (numberOfColumn==0) {
			System.out.println("22");
			if (roomDetailsDTO.getRoomId() == 1) {System.out.println("23");
				if (roomDetailsDTO.getNumberOfPersons() > 4)
					throw new ExceptionHandler(IExceptionClass.PERSON_EXCEED);
				
			}
			else if (roomDetailsDTO.getRoomId() == 2) {
				
				if (roomDetailsDTO.getNumberOfPersons() > 3)
					throw new ExceptionHandler(IExceptionClass.PERSON_EXCEED);
				
			}
			else if (roomDetailsDTO.getRoomId() == 3) {
				if (roomDetailsDTO.getNumberOfPersons() > 5)
					throw new ExceptionHandler(IExceptionClass.PERSON_EXCEED);
				
			}
			else if (roomDetailsDTO.getRoomId() == 4) {
				if (roomDetailsDTO.getNumberOfPersons() > 4)
					throw new ExceptionHandler(IExceptionClass.PERSON_EXCEED);
				
			}
			System.out.println("8");
			if (bookingDAO.setBookingDetails(bookingDetailsDTO, roomDetailsDTO,hotelDetailsDTO,userDataDTO) == 0)
				return 1;
			else
				new ExceptionHandler(IExceptionClass.ERROR_IN_BOOKING);

		} else
			throw new ExceptionHandler(IExceptionClass.ROOM_BOOKED);
		return 0;

	}

	public void cancelBooking(int bookingId) throws ExceptionHandler {

		BookingDAO bookingDAO = new BookingDAO();
		bookingDAO.searchIdForCancel(bookingId);
		

	}

}

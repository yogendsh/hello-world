package com.cg.onlinehotelmanagementsystem.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.cg.onlinehotelmanagementsystem.dto.BookingDetailsDTO;
import com.cg.onlinehotelmanagementsystem.dto.RoomDetailsDTO;
import com.cg.onlinehotelmanagementsystem.exception.CancelBookingException;
import com.cg.onlinehotelmanagementsystem.exception.NoRoomAvailable;
import com.cg.onlinehotelmanagementsystem.exception.PersonExceedException;
import com.cg.onlinehotelmanagementsystem.exception.RoomAlreadyBookedException;


public interface IBookRoom {
	Object bookRoom(int roomType,Date checkIn,Date checkOut,int numberOfPerson)
			throws PersonExceedException, RoomAlreadyBookedException, NoRoomAvailable;

	Object cancelRoom(int id, Map<Integer, BookingDetailsDTO> cancelneedmap) throws CancelBookingException;
}

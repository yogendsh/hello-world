package com.cg.onlinehotelmanagementsystem.ui;

import java.util.Date;

import com.cg.onlinehotelmanagementsystem.dto.RoomDetailsDTO;
import com.cg.onlinehotelmanagementsystem.service.IBookRoom;
import com.cg.onlinehotelmanagementsystem.service.impl.BookRoomImpl;

public class HMSMainHelper {
	public RoomDetailsDTO setRoomDetails(int roomType,Date checkIn,Date checkOut)
	{
		RoomDetailsDTO roomDetails=new RoomDetailsDTO();
		IBookRoom bookRoom=new BookRoomImpl();
		if(roomType==1) {
		roomDetails.setTypeOfRoom("King Size Room");
		roomDetails.setRoomsId(1);
		roomDetails.setStatus(true);
		roomDetails.setCheckIn(checkIn);
		roomDetails.setCheckOut(checkOut);
		roomDetails.setNumberOfPerson(4);
		roomDetails.setPrice(2500*((checkOut.getTime() - checkIn.getTime())/(24 * 60 * 60 * 1000)));
		bookRoom.bookRoom(roomDetails, checkIn, checkOut, numberOfPerson)
		}
		if(roomType==2)
		{
			roomDetails.setTypeOfRoom("Queen Size Room");
			roomDetails.setRoomsId(2);
			roomDetails.setStatus(true);
			roomDetails.setCheckIn(checkIn);
			roomDetails.setCheckOut(checkOut);
			roomDetails.setNumberOfPerson(3);
			roomDetails.setPrice(2400*((checkOut.getTime() - checkIn.getTime())/(24 * 60 * 60 * 1000)));
		}
		if(roomType==3)
		{
			roomDetails.setTypeOfRoom("AC Room");
			roomDetails.setRoomsId(3);
			roomDetails.setStatus(true);
			roomDetails.setCheckIn(checkIn);
			roomDetails.setCheckOut(checkOut);
			roomDetails.setNumberOfPerson(3);
			roomDetails.setPrice(2300*((checkOut.getTime() - checkIn.getTime())/(24 * 60 * 60 * 1000)));
		}
		if(roomType==4)
		{
			roomDetails.setTypeOfRoom("Non AC Room");
			roomDetails.setRoomsId(4);
			roomDetails.setStatus(true);
			roomDetails.setCheckIn(checkIn);
			roomDetails.setCheckOut(checkOut);
			roomDetails.setNumberOfPerson(2);
			roomDetails.setPrice(2200*((checkOut.getTime() - checkIn.getTime())/(24 * 60 * 60 * 1000)));
		}
		return roomDetails;
	}

}

package com.cg.onlinehotelmanagementsystem.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import com.cg.onlinehotelmanagementsystem.dto.BookingDetailsDTO;
import com.cg.onlinehotelmanagementsystem.dto.RoomDetailsDTO;
import com.cg.onlinehotelmanagementsystem.exception.CancelBookingException;
import com.cg.onlinehotelmanagementsystem.exception.NoRoomAvailable;
import com.cg.onlinehotelmanagementsystem.exception.PersonExceedException;
import com.cg.onlinehotelmanagementsystem.exception.RoomAlreadyBookedException;
import com.cg.onlinehotelmanagementsystem.service.IBookRoom;
import com.cg.onlinehotelmanagementsystem.staticdb.ListData;

public class BookRoomImpl implements IBookRoom {
	public Object bookRoom(int roomType,Date checkIn,Date checkOut,int numberOfPerson)
			throws PersonExceedException, RoomAlreadyBookedException, NoRoomAvailable {
		if (roomType == 1) {
			
			
			if (roomDetails.getNumberOfPerson() < numberOfPerson)
				throw new PersonExceedException("You Exceed Accomodate Size of Room");
			else {
				if (roomDetails.isStatus() == true)
					throw new RoomAlreadyBookedException("Room Already Booked");
				else {
					if (roomDetails.getNumberOfRooms() == 0)
						throw new NoRoomAvailable("No Room Available");
					else {
						roomDetails.setStatus(true);
						roomDetails.setNumberofkingrooms(roomDetails.getNumberofkingrooms() - 1);
						bookingDetails.setPrice(diffdays * roomDetails.getPrice());
					}
				}
			}
			
			return roomDetails;

		}
		if (roomtype == 2) {
			QueenRoomDetailsDTO queenRoomDetails = (QueenRoomDetailsDTO)object;
			if (queenRoomDetails.getNumberofperson() < numberperson)
				throw new PersonExceedException("You Exceed Accomodate Size of Room");
			else {
				if (queenRoomDetails.getStatus() == true)
					throw new RoomAlreadyBookedException("Room Already Booked");
				else {
					if (queenRoomDetails.getNumberofqueenrooms() == 0)
						throw new NoRoomAvailable("No Room Available");
					else {
						queenRoomDetails.setStatus(true);
						queenRoomDetails.setNumberofqueenrooms(queenRoomDetails.getNumberofqueenrooms() - 1);
						bookingDetails.setPrice(diffdays * queenRoomDetails.getPrice());
					}
				}
			}
			return queenRoomDetails;

		}
		if (roomtype == 3) {
			ACRoomDetailsDTO acRoomDetails = (ACRoomDetailsDTO) object;
			if (acRoomDetails.getNumberofperson() < numberperson)
				throw new PersonExceedException("You Exceed Accomodate Size of Room");
			else {
				if (acRoomDetails.getStatus() == true)
					throw new RoomAlreadyBookedException("Room Already Booked");
				else {
					if (acRoomDetails.getNumberofacrooms() == 0)
						throw new NoRoomAvailable("No Room Available");
					else {
						acRoomDetails.setStatus(true);
						acRoomDetails.setNumberofacrooms(acRoomDetails.getNumberofacrooms() - 1);
						bookingDetails.setPrice( diffdays * acRoomDetails.getPrice());
					}
				}
			}
			return acRoomDetails;

		}
		if (roomtype == 4) {
			NonACRoomDetailsDTO nonacRoomDetails = (NonACRoomDetailsDTO) object;
			if (nonacRoomDetails.getNumberofperson() < numberperson)
				throw new PersonExceedException("You Exceed Accomodate Size of Room");
			else {
				if (nonacRoomDetails.getStatus() == true)
					throw new RoomAlreadyBookedException("Room Already Booked");
				else {
					if (nonacRoomDetails.getNumberofnonacrooms() == 0)
						throw new NoRoomAvailable("No Room Available");
					else {
						nonacRoomDetails.setStatus(true);
						nonacRoomDetails.setNumberofnonacrooms(nonacRoomDetails.getNumberofnonacrooms() - 1);
						bookingDetails.setPrice( diffdays * nonacRoomDetails.getPrice());
					}
				}
			}
			return nonacRoomDetails;
		}

		return null;
	}
	 @SuppressWarnings("unlikely-arg-type")
	public Object cancelRoom(int id,Map<Integer,BookingDetailsDTO> cancelneedmap)throws CancelBookingException {
		  if(cancelneedmap.isEmpty())
		  {
			  throw new CancelBookingException("No Booking for this Id");
		  }
		  else { 
			  cancelneedmap.remove(cancelneedmap.get(0));
	    	   return cancelneedmap;
		  }
	    	
	    		   
					 
		 
	 }

}

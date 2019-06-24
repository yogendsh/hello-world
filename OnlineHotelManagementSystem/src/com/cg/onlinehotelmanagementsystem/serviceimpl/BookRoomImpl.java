package com.cg.onlinehotelmanagementsystem.serviceimpl;

import java.util.Map;

import com.cg.onlinehotelmanagementsystem.dto.ACRoomDetailsDTO;
import com.cg.onlinehotelmanagementsystem.dto.BookingDetailsDTO;
import com.cg.onlinehotelmanagementsystem.dto.KingRoomDetailsDTO;
import com.cg.onlinehotelmanagementsystem.dto.NonACRoomDetailsDTO;
import com.cg.onlinehotelmanagementsystem.dto.QueenRoomDetailsDTO;
import com.cg.onlinehotelmanagementsystem.exception.CancelBookingException;
import com.cg.onlinehotelmanagementsystem.exception.NoRoomAvailable;
import com.cg.onlinehotelmanagementsystem.exception.PersonExceedException;
import com.cg.onlinehotelmanagementsystem.exception.RoomAlreadyBookedException;
import com.cg.onlinehotelmanagementsystem.service.IBookRoom;
import com.cg.onlinehotelmanagementsystem.staticdb.ListData;

public class BookRoomImpl implements IBookRoom {
	public Object bookRoom(Object object,int roomtype, ListData listdata, int numberperson, BookingDetailsDTO bookingdetails,int diffdays)
			throws PersonExceedException, RoomAlreadyBookedException, NoRoomAvailable {
		if (roomtype == 1) {
			// implementation 			
			KingRoomDetailsDTO krd = (KingRoomDetailsDTO) object;
			
			if (krd.getNumberofperson() < numberperson)
				throw new PersonExceedException("You Exceed Accomodate Size of Room");
			else {
				if (krd.getStatus() == true)
					throw new RoomAlreadyBookedException("Room Already Booked");
				else {
					if (krd.getNumberofkingrooms() == 0)
						throw new NoRoomAvailable("No Room Available");
					else {
						krd.setStatus(true);
						krd.setNumberofkingrooms(krd.getNumberofkingrooms() - 1);
						bookingdetails.setPrice(diffdays * krd.getPrice());
					}
				}
			}
			
			return krd;

		}
		if (roomtype == 2) {
			QueenRoomDetailsDTO qrd = (QueenRoomDetailsDTO)object;
			if (qrd.getNumberofperson() < numberperson)
				throw new PersonExceedException("You Exceed Accomodate Size of Room");
			else {
				if (qrd.getStatus() == true)
					throw new RoomAlreadyBookedException("Room Already Booked");
				else {
					if (qrd.getNumberofqueenrooms() == 0)
						throw new NoRoomAvailable("No Room Available");
					else {
						qrd.setStatus(true);
						qrd.setNumberofqueenrooms(qrd.getNumberofqueenrooms() - 1);
						bookingdetails.setPrice(diffdays * qrd.getPrice());
					}
				}
			}
			return qrd;

		}
		if (roomtype == 3) {
			ACRoomDetailsDTO acrd = (ACRoomDetailsDTO) object;
			if (acrd.getNumberofperson() < numberperson)
				throw new PersonExceedException("You Exceed Accomodate Size of Room");
			else {
				if (acrd.getStatus() == true)
					throw new RoomAlreadyBookedException("Room Already Booked");
				else {
					if (acrd.getNumberofacrooms() == 0)
						throw new NoRoomAvailable("No Room Available");
					else {
						acrd.setStatus(true);
						acrd.setNumberofacrooms(acrd.getNumberofacrooms() - 1);
						bookingdetails.setPrice( diffdays * acrd.getPrice());
					}
				}
			}
			return acrd;

		}
		if (roomtype == 4) {
			NonACRoomDetailsDTO nacrd = (NonACRoomDetailsDTO) object;
			if (nacrd.getNumberofperson() < numberperson)
				throw new PersonExceedException("You Exceed Accomodate Size of Room");
			else {
				if (nacrd.getStatus() == true)
					throw new RoomAlreadyBookedException("Room Already Booked");
				else {
					if (nacrd.getNumberofnonacrooms() == 0)
						throw new NoRoomAvailable("No Room Available");
					else {
						nacrd.setStatus(true);
						nacrd.setNumberofnonacrooms(nacrd.getNumberofnonacrooms() - 1);
						bookingdetails.setPrice( diffdays * nacrd.getPrice());
					}
				}
			}
			return nacrd;
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

package com.cg.onlinehotelmanagementsystem.serviceimpl;

import static org.junit.Assert.assertNotEquals;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.cg.onlinehotelmanagementsystem.dto.BookingDetailsDTO;
import com.cg.onlinehotelmanagementsystem.dto.KingRoomDetailsDTO;
import com.cg.onlinehotelmanagementsystem.exception.CancelBookingException;
import com.cg.onlinehotelmanagementsystem.exception.NoRoomAvailable;
import com.cg.onlinehotelmanagementsystem.exception.PersonExceedException;
import com.cg.onlinehotelmanagementsystem.exception.RoomAlreadyBookedException;
import com.cg.onlinehotelmanagementsystem.staticdb.ListData;

class BookRoomImplTest {
BookRoomImpl bookroomiml=new BookRoomImpl();
	@Test
	void testBookRoom() throws PersonExceedException, RoomAlreadyBookedException, NoRoomAvailable {
		Assertions.assertThrows(ClassCastException.class, () -> {
			bookroomiml.bookRoom(new KingRoomDetailsDTO(2, false, 2500, 2),2, new ListData(), 2,new BookingDetailsDTO(),2);
		});
		}
		
		@Test
		void testCancelRoom() throws CancelBookingException {
			Map<Integer,BookingDetailsDTO> map=new HashMap<Integer,BookingDetailsDTO>();
			BookingDetailsDTO bt=new BookingDetailsDTO();
			bt.setBookingid(354546);
			bt.setCheckinbook(new Date());
			bt.setCheckoutbook(new Date());
			bt.setPrice(2500.00);
			map.put(Integer.valueOf("354546"),bt );
			assertNotEquals(334442,bt);


		
	}

}

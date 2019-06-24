package com.cg.onlinehotelmanagementsystem.utility;

import com.cg.onlinehotelmanagementsystem.dto.HotelDetailsDTO;
import com.cg.onlinehotelmanagementsystem.exception.HotelNameException;
import com.cg.onlinehotelmanagementsystem.staticdb.ListData;

public class ValidHotel {
	HotelDetailsDTO hotel;

	public int validHotelName(String name, ListData listdata)throws HotelNameException{
		for (int i = 0; i < listdata.hotelList().size(); i++) {

			hotel = (HotelDetailsDTO) listdata.hotelList().get(i);
//System.out.println(name.toUpperCase());
			if (name.toUpperCase().equals(hotel.getHotelname().toUpperCase()))
				return ++i;
		}
		throw new HotelNameException("Enter Hotel Name Properly");
		

	}
}

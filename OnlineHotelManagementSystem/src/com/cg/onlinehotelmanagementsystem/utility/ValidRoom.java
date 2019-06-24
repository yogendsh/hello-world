package com.cg.onlinehotelmanagementsystem.utility;

import com.cg.onlinehotelmanagementsystem.exception.RoomNameException;
import com.cg.onlinehotelmanagementsystem.staticdb.ListData;

public class ValidRoom {
	public int validRoomType(String typename, ListData listdata)throws RoomNameException
	{
		 for(int i=0;i<listdata.typeOfRoom().size();i++)
		 {
			 String check=(String) listdata.typeOfRoom().get(i);
			// System.out.println(name.toUpperCase());
			 if(typename.toUpperCase().equals(check.toUpperCase()))
				 return ++i;
		 }
		 
		throw new RoomNameException("Enter Room Type Properly");
	}

}

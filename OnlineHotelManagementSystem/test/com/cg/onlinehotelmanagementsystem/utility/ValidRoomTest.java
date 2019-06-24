package com.cg.onlinehotelmanagementsystem.utility;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.cg.onlinehotelmanagementsystem.exception.AreaNameException;
import com.cg.onlinehotelmanagementsystem.exception.RoomNameException;
import com.cg.onlinehotelmanagementsystem.staticdb.ListData;

class ValidRoomTest {

	@Test
	void testValidRoomPass() throws RoomNameException {
		ValidRoom validroom = new ValidRoom();
		ListData listdata = new ListData();
		int testvar = validroom.validRoomType("AC", listdata);
		assertEquals(3, testvar);
	}
	@Test
	void testValidAreaFail() throws RoomNameException {
		ValidRoom validroom = new ValidRoom();
		ListData listdata = new ListData();
		
		Assertions.assertThrows(RoomNameException.class, () -> {
			validroom.validRoomType("Non Ac",listdata);
		});
}}

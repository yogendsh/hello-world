package com.cg.onlinehotelmanagementsystem.utility;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;


import com.cg.onlinehotelmanagementsystem.exception.DateCheckInException;
import com.cg.onlinehotelmanagementsystem.exception.DateCheckOutException;

public class DateValidation {
	final static String DATE_FORMAT = "dd-MM-yyyy";
	static DateFormat dateformat = new SimpleDateFormat(DATE_FORMAT);

	public static boolean dateCheckIn(String checkin)
			throws DateCheckInException, ParseException {
		try {

			dateformat.setLenient(false);

			Date checkindate = new SimpleDateFormat("dd-MM-yyyy").parse(checkin);
			DateFormat newPattern = new SimpleDateFormat("dd-MM-yyyy");
			String currentdatestring = newPattern.format(new Date());
			Date currentdate = new SimpleDateFormat("dd-MM-yyyy").parse(currentdatestring);
			dateformat.parse(checkin);
			if (currentdate.compareTo(checkindate) < 0 || currentdate.compareTo(checkindate) == 0) {

				
				return true;
			}
			throw new DateCheckInException("This Date is not valid");

		} catch (ParseException e) {
			// TODO: handle exception
			throw new ParseException("This Date is not valid", 0);

		}

	}

	public static boolean dateCheckout(String checkout, Date checkindate)
			throws DateCheckOutException, ParseException {
		try {
			dateformat.setLenient(false);
			Date checkoutdate = new SimpleDateFormat("dd-MM-yyyy").parse(checkout);
			dateformat.parse(checkout);
			if (checkoutdate.compareTo(checkindate) > 0 || checkoutdate.compareTo(checkindate) == 0) {

				
				return true;
			}
			throw new DateCheckOutException("This Date is not valid");
		} catch (ParseException e) {
			// TODO: handle exception
			throw new ParseException("This Date is not valid", 0);
		}

	}
}

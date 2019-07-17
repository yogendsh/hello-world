package com.cg.onlinehotelmanagementsystem.dao;

import java.sql.Date;
import java.time.temporal.ChronoUnit;

import javax.persistence.EntityManager;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.cg.onlinehotelmanagementsystem.dto.BookingDetailsDTO;
import com.cg.onlinehotelmanagementsystem.dto.CustomerDataDTO;
import com.cg.onlinehotelmanagementsystem.dto.HotelDetailsDTO;
import com.cg.onlinehotelmanagementsystem.dto.RoomDetailsDTO;
import com.cg.onlinehotelmanagementsystem.exception.ExceptionHandler;
import com.cg.onlinehotelmanagementsystem.utility.DbUtil;
import com.cg.onlinehotelmanagementsystem.utility.IExceptionClass;
import com.cg.onlinehotelmanagementsystem.utility.JPAQuery;

public class BookingDAO implements IBookingDAO {

	public int bookingConnection(int roomId, BookingDetailsDTO bookingDetailsDTO) throws ExceptionHandler {

		EntityManager entityManager = DbUtil.getConnection();
		TypedQuery<BookingDetailsDTO> query = entityManager.createQuery(
				"SELECT bookObject from BookingDetailsDTO bookObject where bookObject.checkinbook BETWEEN TO_DATE(:checkinbook,'dd-MM-yyyy') AND TO_DATE(:checkoutbook,'dd-MM-yyyy') OR bookObject.checkoutbook BETWEEN TO_DATE(:checkinbook,'dd-MM-yyyy') AND TO_DATE(:checkoutbook,'dd-MM-yyyy')",
				BookingDetailsDTO.class);
		// query.setParameter("roomid", roomId);
		query.setParameter("checkinbook", Date.valueOf(bookingDetailsDTO.getCheckinbook()));
		System.out.println("3");
		query.setParameter("checkoutbook", Date.valueOf(bookingDetailsDTO.getCheckoutbook()));
		System.out.println("4");
		query.setParameter("checkinbook", Date.valueOf(bookingDetailsDTO.getCheckinbook()));
		System.out.println("3");
		query.setParameter("checkoutbook", Date.valueOf(bookingDetailsDTO.getCheckoutbook()));
		if (query.getResultList().size() == 0) {
			return 0;
		} else
			return 1;
		

	}

	public int setBookingDetails(BookingDetailsDTO bookingDetailsDTO, RoomDetailsDTO roomDetailsDTO,HotelDetailsDTO hotelDetailsDTO,CustomerDataDTO userDataDTO)
	 {
	

		bookingDetailsDTO.setRoomDetailsDTO(roomDetailsDTO);
		bookingDetailsDTO.setHotelDetailsDTO(hotelDetailsDTO);
		bookingDetailsDTO.setUserDataDTO(userDataDTO);
		EntityManager entityManager = DbUtil.getConnection();
		entityManager.getTransaction().begin();
		entityManager.persist(bookingDetailsDTO);
		entityManager.getTransaction().commit();
		return 0;
	}

	public void searchIdForCancel(int bookingId) throws ExceptionHandler {
		EntityManager entityManager = DbUtil.getConnection();
		BookingDetailsDTO bookingDetailsDTO = entityManager.find(BookingDetailsDTO.class, bookingId);
		if (bookingDetailsDTO != null) {
			entityManager.getTransaction().begin();
			entityManager.remove(bookingDetailsDTO);
			entityManager.getTransaction().commit();
		} else
			throw new ExceptionHandler(IExceptionClass.CANCEL_BOOKING);
	

	}



}

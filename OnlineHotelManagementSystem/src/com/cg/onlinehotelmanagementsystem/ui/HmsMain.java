package com.cg.onlinehotelmanagementsystem.ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import com.cg.onlinehotelmanagementsystem.dto.*;
import com.cg.onlinehotelmanagementsystem.exception.AreaNameException;
import com.cg.onlinehotelmanagementsystem.exception.CancelBookingException;
import com.cg.onlinehotelmanagementsystem.exception.CityNameException;
import com.cg.onlinehotelmanagementsystem.exception.DateCheckInException;
import com.cg.onlinehotelmanagementsystem.exception.DateCheckOutException;
import com.cg.onlinehotelmanagementsystem.exception.HotelNameException;
import com.cg.onlinehotelmanagementsystem.exception.NoRoomAvailable;
import com.cg.onlinehotelmanagementsystem.exception.PersonExceedException;
import com.cg.onlinehotelmanagementsystem.exception.RoomAlreadyBookedException;
import com.cg.onlinehotelmanagementsystem.exception.RoomNameException;
import com.cg.onlinehotelmanagementsystem.service.IBookRoom;
import com.cg.onlinehotelmanagementsystem.service.impl.BookRoomImpl;
import com.cg.onlinehotelmanagementsystem.staticdb.ListData;
import com.cg.onlinehotelmanagementsystem.utility.DateValidation;
import com.cg.onlinehotelmanagementsystem.utility.ValidCity;
import com.cg.onlinehotelmanagementsystem.utility.ValidHotel;
import com.cg.onlinehotelmanagementsystem.utility.ValidRoom;

public class HmsMain {

		@SuppressWarnings("unchecked")
		public static void main(String[] args) {
		ListData listData = new ListData();
		ValidCity validCity = new ValidCity();
		HotelDetailsDTO hotel;
		ValidHotel validHotel = new ValidHotel();
		ValidRoom validroom = new ValidRoom();
		BookingDetailsDTO bookingdetails = new BookingDetailsDTO();
		Map<Integer, BookingDetailsDTO> cancelneedmap = null;
		List<RoomDetailsDTO> roomList=listData.typeOfRoom();
		IBookRoom bookRoom = null;
		int n = 0;
		int hotelvariable=0;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < 50; i++)
			System.out.print("*");
		System.out.print("WELCOME TO ONLINE HOTEL BOOKING SYSTEM");
		for (int i = 0; i < 50; i++)
			System.out.print("*");
		
		while (true) {
			System.out.println("");
			for (int i = 0; i < 60; i++)
				System.out.print(" ");
			System.out.println("Press 1 for Booking");
			for (int i = 0; i < 58; i++)
				System.out.print(" ");
			System.out.println("Press 2 for Cancel Booking");
			try {
				try {

					n = scanner.nextInt();
				} catch (Exception e) {
					System.out.println("Press ctrl+f11 to continue!!!!");
					break;
					
				}
				switch (n) {
				case 1:
					for (int i = 0; i < 60; i++)
						System.out.print(" ");
					System.out.println("List Of City");
					for (String cityName:(List<String>)listData.cityList()) {
						for (int k = 0; k < 60; k++)
							System.out.print(" ");
						System.out.println(cityName);
					}
					for (int i = 0; i < 60; i++)
						System.out.print(" ");
					System.out.println("Enter the Location");
					scanner.nextLine();
					String cityname = scanner.nextLine();
					int j = validCity.validCityName(cityname);
					if (j != 0) {
						for (int i = 0; i < 60; i++)
							System.out.print(" ");
						System.out.println("List Of Area in " + cityname.toUpperCase());
						if (j == 1) {
							for (String areaName:(List<String>)listData.areaListPune()) {
								for (int k = 0; k < 60; k++)
									System.out.print(" ");
								System.out.println(areaName);
							}
							for (int i = 0; i < 60; i++)
								System.out.print(" ");
							System.out.println("Enter the Area");
							
							String areaname = scanner.next();
							validCity.validAreaName(areaname, j);
                           
						}
						if (j == 2) {
							for (String areaName:(List<String>)listData.areaListJaipur()) {
								for (int k = 0; k < 60; k++)
									System.out.print(" ");
								System.out.println(areaName);
							}
							for (int k = 0; k < 60; k++)
								System.out.print(" ");
							System.out.println("Enter the Area");
							String areaname = scanner.next();
							validCity.validAreaName(areaname, j);

						}
						if (j == 3) {
							for (String areaName:(List<String>)listData.areaListMumbai()) {
								for (int k = 0; k < 60; k++)
									System.out.print(" ");
								System.out.println(areaName);
							}
							System.out.println("Enter the Area");
							String areaname = scanner.next();
							validCity.validAreaName(areaname, j);
						}
						
						if (j == 4) {
							for (String areaName:(List<String>)listData.areaListDelhi()) {
								for (int k = 0; k < 60; k++)
									System.out.print(" ");
								System.out.println(areaName);
							}
							System.out.println("Enter the Area");
							String areaname = scanner.next();
							validCity.validAreaName(areaname, j);
						}
						
						for (int k = 0; k < 60; k++)
							System.out.print(" ");
						System.out.println("Enter the Hotel");
						for (int i = 0; i < listData.hotelList().size(); i++) {
							hotel = (HotelDetailsDTO) listData.hotelList().get(i);
							for (int k = 0; k < 60; k++)
								System.out.print(" ");
							System.out.println(hotel.getHotelname());
						}
						
						for (int k = 0; k < 60; k++)
							System.out.print(" ");
						System.out.println("Enter the Hotel Name");
						String hotelname = scanner.next();
						hotelvariable = validHotel.validHotelName(hotelname, listData);
						if(hotelvariable==1);
						
						for (int k = 0; k < 60; k++)
							System.out.print(" ");
						System.out.println("List of Room Available");
						for (String roomName:(List<String>)listData.typeOfRoom()) {
							for (int k = 0; k < 60; k++)
								System.out.print(" ");
							System.out.println(roomName);
						}
						
						for (int k = 0; k < 60; k++)
							System.out.print(" ");
						System.out.println("Enter Room type you want");
						
						String room = scanner.next();
						int roomtype = validroom.validRoomType(room, listData);
						if (roomtype == 1) {
						for (int k = 0; k < 60; k++)
						System.out.print(" ");
						System.out.println("Enter Check In Date in dd-MM-yyyy format");
						String datecheckin = scanner.next();
						if (DateValidation.dateCheckIn(datecheckin)) {
						for (int k = 0; k < 60; k++)
						System.out.print(" ");
						System.out.println("Enter Check Out Date in dd-MM-yyyy format");
						String datecheckout = scanner.next();
					    if (DateValidation.dateCheckout(datecheckout)) {
						Date diffcheckin=new SimpleDateFormat("dd-MM-yyyy").parse(datecheckin);
						Date diffcheckout=new SimpleDateFormat("dd-MM-yyyy").parse(datecheckout);
						long diff = diffcheckout.getTime() - diffcheckin.getTime();
						int diffDays = (int) (diff / (24 * 60 * 60 * 1000));
						for (int k = 0; k < 60; k++)
						System.out.print(" ");
						System.out.println("Enter Number of Persons");
						int numberOfPerson = scanner.nextInt();
						bookRoom = new BookRoomImpl();
						if (roomtype == 1) {
						HMSMainHelper mainHelper=new HMSMainHelper();
						mainHelper.setRoomDetails(roomtype,diffcheckin,diffcheckout);
									
							
							
						}
						if (roomtype == 2) {
							queenRoomDetails = (QueenRoomDetailsDTO) bookRoom.bookRoom(queenRoomDetails,
									roomtype, listData, numberperson, bookingdetails,diffDays);
						}
						if (roomtype == 3) {
							acRoomDetails = (ACRoomDetailsDTO) bookRoom.bookRoom(acRoomDetails, roomtype,
									listData, numberperson, bookingdetails,diffDays);
						}
						if (roomtype == 4) {
							nonAcRoomDetails = (NonACRoomDetailsDTO) bookRoom.bookRoom(nonAcRoomDetails,
									roomtype, listData, numberperson, bookingdetails,diffDays);
						}
						Double bookingid = ThreadLocalRandom.current().nextDouble();
						int bookid = (int) (bookingid * 1000000);
						bookingdetails.setBookingid(bookid);
							bookingdetails.setCheckinbook(new SimpleDateFormat("dd-MM-yyyy").parse(datecheckin));
						bookingdetails
								.setCheckoutbook(new SimpleDateFormat("dd-MM-yyyy").parse(datecheckout));
						cancelneedmap = listData.cancelBookingList();
						cancelneedmap.put(Integer.valueOf(bookid), bookingdetails);
						for (int k = 0; k < 60; k++)
							System.out.print(" ");
						System.out.println("Booking is confirmed");
						System.out.println();
						for (int k = 0; k < 60; k++)
							System.out.print(" ");
						System.out.println("Your Booking Id is " + bookid);

								}

							}

						}

					} else {

						System.out.println("Enter proper name");
					}

					break;
				case 2:
					System.out.println("Enter Your Booking Id to cancel booking");
					int bookidcancel = scanner.nextInt();
					if (bookidcancel == bookingdetails.getBooingid()) 
					{
						@SuppressWarnings("unused")
						Object objcancel=bookRoom.cancelRoom(bookidcancel, cancelneedmap);
						System.out.println("Your Booking Details were as follows");
						System.out.println(bookingdetails);
						System.out.println("Booking is Canceled");
						System.out.println("Thank You");
					} else
						System.out.println("No Booking for this Id");

					break;

				default:
					System.out.println("For contine press 1");
					int count = scanner.nextInt();
					if (count != 1)
						System.exit(1);
					break;
				}
			} catch (CityNameException cne) {
				
				System.out.println(cne.getMessage());
			} catch (AreaNameException ane) {
				
				System.out.println(ane.getMessage());
			} catch (HotelNameException hne) {
				
				System.out.println(hne.getMessage());
			} catch (RoomNameException rne) {
			
				System.out.println(rne.getMessage());
			} catch (DateCheckInException dce) {
				
				System.out.println(dce.getMessage());
			} catch (DateCheckOutException dcoe) {
				
				System.out.println(dcoe.getMessage());
			} catch (PersonExceedException pee) {
				
				System.out.println(pee.getMessage());
			} catch (RoomAlreadyBookedException rabe) {
				
				System.out.println(rabe.getMessage());
			} catch (NoRoomAvailable nre) {
				
				System.out.println(nre.getMessage());
			} catch (CancelBookingException cbe) {
				
				System.out.println(cbe.getMessage());
			}
			catch (NumberFormatException nfe) {
				System.out.println("Enter data properly");
				
			}
			catch (InputMismatchException ime) {
				
			System.out.println("Enter data properly");
			continue;
				}
		    catch(ParseException pe) {
				System.out.println(pe.getMessage());
			}
			catch (NoSuchElementException nse) {
				
			}
			
			catch (Exception e) {
				
				System.exit(1);
			}
			

		}
	}

}

package com.cg.onlinehotelmanagementsystem.ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
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
import com.cg.onlinehotelmanagementsystem.serviceimpl.BookRoomImpl;
import com.cg.onlinehotelmanagementsystem.staticdb.ListData;
import com.cg.onlinehotelmanagementsystem.utility.DateValidation;
import com.cg.onlinehotelmanagementsystem.utility.ValidCity;
import com.cg.onlinehotelmanagementsystem.utility.ValidHotel;
import com.cg.onlinehotelmanagementsystem.utility.ValidRoom;

public class HmsMain {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListData listData = new ListData();
		ValidCity validCity = new ValidCity();
		HotelDetailsDTO hotel;
		ValidHotel validhotel = new ValidHotel();
		ValidRoom validroom = new ValidRoom();
		BookingDetailsDTO bookingdetails = new BookingDetailsDTO();
		BookRoomDetailsDTO bookroomdetails = new BookRoomDetailsDTO();
		Map<Integer, BookingDetailsDTO> cancelneedmap = null;
		KingRoomDetailsDTO kingroomdetails = (KingRoomDetailsDTO) listData.kingRoomList().get(0);
		QueenRoomDetailsDTO queenroomdetails = (QueenRoomDetailsDTO) listData.queenRoomList().get(0);
		ACRoomDetailsDTO acroomdetails = (ACRoomDetailsDTO) listData.acRoomList().get(0);
		NonACRoomDetailsDTO nonacroomdetails = (NonACRoomDetailsDTO) listData.nonACRoomList().get(0);
		IBookRoom bookroom = null;
		
		int n = 0;
		int area=0;
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
					// TODO: handle exception
					System.out.println("Press ctrl+f11 to continue!!!!");
					break;
					
				}
				switch (n) {
				case 1:
					for (int i = 0; i < 60; i++)
						System.out.print(" ");
					System.out.println("List Of City");
					for (int i = 0; i < listData.cityList().size(); i++) {
						for (int k = 0; k < 60; k++)
							System.out.print(" ");
						System.out.println(listData.cityList().get(i));
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
							for (int i = 0; i < listData.areaListPune().size(); i++) {
								for (int k = 0; k < 60; k++)
									System.out.print(" ");
								System.out.println(listData.areaListPune().get(i));
							}
							for (int i = 0; i < 60; i++)
								System.out.print(" ");
							System.out.println("Enter the Area");
							
							String areaname = scanner.next();
							area = validCity.validAreaName(areaname, j);
                            if(area==1);
						}
						if (j == 2) {
							for (int i = 0; i < listData.areaListJaipur().size(); i++) {
								for (int k = 0; k < 60; k++)
									System.out.print(" ");
								System.out.println(listData.areaListJaipur().get(i));
							}
							for (int k = 0; k < 60; k++)
								System.out.print(" ");
							System.out.println("Enter the Area");
							
							String areaname = scanner.next();
							area = validCity.validAreaName(areaname, j);

						}
						if (j == 3) {
							for (int i = 0; i < listData.areaListMumbai().size(); i++) {
								for (int k = 0; k < 60; k++)
									System.out.print(" ");
								System.out.println(listData.areaListMumbai().get(i));
							}
							System.out.println("Enter the Area");
							// scanner.nextLine();
							String areaname = scanner.next();
							area = validCity.validAreaName(areaname, j);
						}
						
						if (j == 4) {
							for (int i = 0; i < listData.areaListDelhi().size(); i++) {
								for (int k = 0; k < 60; k++)
									System.out.print(" ");
								System.out.println(listData.areaListDelhi().get(i));
							}
							System.out.println("Enter the Area");
							// scanner.nextLine();
							String areaname = scanner.next();
							area = validCity.validAreaName(areaname, j);
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
						// scanner.nextLine();
						String hotelname = scanner.next();
						hotelvariable = validhotel.validHotelName(hotelname, listData);
						if(hotelvariable==1);
						
						for (int k = 0; k < 60; k++)
							System.out.print(" ");
						System.out.println("List of Room Available");
						for (int i = 0; i < listData.typeOfRoom().size(); i++) {
							for (int k = 0; k < 60; k++)
								System.out.print(" ");
							System.out.println(listData.typeOfRoom().get(i));
						}
						
						for (int k = 0; k < 60; k++)
							System.out.print(" ");
						System.out.println("Enter Room type you want");
						
						String room = scanner.next();
						int roomtype = validroom.validRoomType(room, listData);
						if (roomtype != 0) {
						for (int k = 0; k < 60; k++)
						System.out.print(" ");
						System.out.println("Enter Check In Date in dd-MM-yyyy format");
						String datecheckin = scanner.next();
						
						if (DateValidation.dateCheckIn(datecheckin, bookroomdetails)) {
						for (int k = 0; k < 60; k++)
						System.out.print(" ");
						System.out.println("Enter Check Out Date in dd-MM-yyyy format");
						String datecheckout = scanner.next();
					            
						if (DateValidation.dateCheckout(datecheckout, bookroomdetails.getCheckin(),bookroomdetails)) {
						Date diffcheckin=new SimpleDateFormat("dd-MM-yyyy").parse(datecheckin);
						Date diffcheckout=new SimpleDateFormat("dd-MM-yyyy").parse(datecheckout);
						long diff = diffcheckout.getTime() - diffcheckin.getTime();
						int diffDays = (int) (diff / (24 * 60 * 60 * 1000));
						for (int k = 0; k < 60; k++)
						System.out.print(" ");
						System.out.println("Enter Number of Persons");
						int numberperson = scanner.nextInt();
						bookroom = new BookRoomImpl();
						if (roomtype == 1) {

							kingroomdetails = (KingRoomDetailsDTO) bookroom.bookRoom(kingroomdetails, roomtype,
									listData, numberperson, bookingdetails,diffDays);
							
							
						}
						if (roomtype == 2) {
							queenroomdetails = (QueenRoomDetailsDTO) bookroom.bookRoom(queenroomdetails,
									roomtype, listData, numberperson, bookingdetails,diffDays);
						}
						if (roomtype == 3) {
							acroomdetails = (ACRoomDetailsDTO) bookroom.bookRoom(acroomdetails, roomtype,
									listData, numberperson, bookingdetails,diffDays);
						}
						if (roomtype == 4) {
							nonacroomdetails = (NonACRoomDetailsDTO) bookroom.bookRoom(nonacroomdetails,
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
						Object objcancel=bookroom.cancelRoom(bookidcancel, cancelneedmap);
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
				// TODO: handle exception
				System.out.println(cne.getMessage());
			} catch (AreaNameException ane) {
				// TODO: handle exception
				System.out.println(ane.getMessage());
			} catch (HotelNameException hne) {
				// TODO: handle exception
				System.out.println(hne.getMessage());
			} catch (RoomNameException rne) {
				// TODO: handle exception
				System.out.println(rne.getMessage());
			} catch (DateCheckInException dce) {
				// TODO: handle exception
				System.out.println(dce.getMessage());
			} catch (DateCheckOutException dcoe) {
				// TODO: handle exception
				System.out.println(dcoe.getMessage());
			} catch (PersonExceedException pee) {
				// TODO: handle exception
				System.out.println(pee.getMessage());
			} catch (RoomAlreadyBookedException rabe) {
				// TODO: handle exception
				System.out.println(rabe.getMessage());
			} catch (NoRoomAvailable nre) {
				// TODO: handle exception
				System.out.println(nre.getMessage());
			} catch (CancelBookingException cbe) {
				// TODO: handle exception
				System.out.println(cbe.getMessage());
			}
			catch (NumberFormatException nfe) {
				System.out.println("Enter data properly");
				// TODO: handle exception
			}
			catch (InputMismatchException ime) {
				// TODO: handle exception
			System.out.println("Enter data properly");
			continue;
				}
		    catch(ParseException pe) {
				System.out.println(pe.getMessage());
			}
			catch (NoSuchElementException nse) {
				// TODO: handle exception
			}
			
			catch (Exception e) {
				// TODO: handle exception
				System.exit(1);
			}
			

		}
	}

}

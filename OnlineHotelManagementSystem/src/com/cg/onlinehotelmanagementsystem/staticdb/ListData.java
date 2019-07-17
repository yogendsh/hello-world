package com.cg.onlinehotelmanagementsystem.staticdb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.cg.onlinehotelmanagementsystem.dto.BookingDetailsDTO;
import com.cg.onlinehotelmanagementsystem.dto.HotelDetailsDTO;
import com.cg.onlinehotelmanagementsystem.dto.RoomDetailsDTO;


public class ListData {
	public void puneHotelList()
	{
		List<String> mukundnagar=new ArrayList<>();
		mukundnagar.add("Hotel Paradise");
		mukundnagar.add("Hotel RajLakshmai");
		
		
		List<String> sahakarnagar=new ArrayList<>();
		sahakarnagar.add("Hotel CityPlus");
		sahakarnagar.add("Hotel Mankind");
		
		List<String> delhiHotel=new ArrayList<>();
		delhiHotel.add("Hotel Heaven");
		delhiHotel.add("Hotel DharmLakshmai");
		
		
		List<String> mumbaiHotel=new ArrayList<>();
		mumbaiHotel.add("Hotel Taj");
		mumbaiHotel.add("Hotel Obroi");
		
	}
	public void jaipurHotelList()
	{
		List<String> malviyanagar=new ArrayList<>();
		malviyanagar.add("Hotel Raddison");
		malviyanagar.add("Hotel Marriot");
		
		List<String> jhotwara=new ArrayList<>();
		jhotwara.add("Hotel Nalanda");
		jhotwara.add("Hotel Rampur");
		
		List<String> kartarpura=new ArrayList<>();
		kartarpura.add("Hotel Khalsa");
		kartarpura.add("Hotel Toytoy");
		
		List<String>sanganer=new ArrayList<>();
		sanganer.add("Hotel SaiDharsan");
		sanganer.add("Hotel BellaCasa");
	}
	public void mumbaiHotelList()
	{
		List<String> thane=new ArrayList<>();
		thane.add("Hotel JayShree");
		thane.add("Hotel Marriot");
		
		List<String> andheri=new ArrayList<>();
		andheri.add("Hotel Mango");
		andheri.add("Hotel Rampur");
		
		List<String> bandra=new ArrayList<>();
		bandra.add("Hotel Alka");
		bandra.add("Hotel Ginger");
		
		List<String>civillines=new ArrayList<>();
		civillines.add("Hotel SaiDharsan");
		civillines.add("Hotel BellaCasa");
	}
	public void delhiHotelList()
	{
		List<String>mukherjinagar=new ArrayList<>();
		mukherjinagar.add("Hotel JayShree");
		mukherjinagar.add("Hotel Marriot");
		
		List<String>rajivchowk=new ArrayList<>();
		rajivchowk.add("Hotel Mango");
		rajivchowk.add("Hotel Rampur");
		
		List<String>hauzkaus=new ArrayList<>();
		hauzkaus.add("Hotel Alka");
		hauzkaus.add("Hotel Ginger");
		
		List<String>rajendranagar=new ArrayList<>();
		rajendranagar.add("Hotel SaiDharsan");
		rajendranagar.add("Hotel BellaCasa");
	}
	@SuppressWarnings("rawtypes")
	public List cityList()
	{
		List<String> citylist = new ArrayList<>();
		citylist.add("PUNE");
		citylist.add("JAIPUR");
		citylist.add("MUMBAI");
		citylist.add("DELHI");
		return citylist;
	}
	
	@SuppressWarnings("rawtypes")
	public List areaListPune()
	{
		List<String> arealistpune = new ArrayList<>();
		arealistpune.add("MukundNagar");
		arealistpune.add("Sahakarnagar");
		arealistpune.add("Ganeshkhind");
		arealistpune.add("Baner");
		return arealistpune;
	}
	@SuppressWarnings("rawtypes")
	public List areaListJaipur()
	{
		List<String> arealistjaipur = new ArrayList<>();
		arealistjaipur.add("MalviyaNagar");
		arealistjaipur.add("Jhotwara");
		arealistjaipur.add("Kartarpura");
		arealistjaipur.add("Sanganer");
		return arealistjaipur;
	}
	@SuppressWarnings("rawtypes")
	public List areaListMumbai()
	{
		List<String> arealistmumbai = new ArrayList<>();
		arealistmumbai.add("Thane");
		arealistmumbai.add("Andheri");
		arealistmumbai.add("Bandra");
		arealistmumbai.add("CivilLines");
		return arealistmumbai;
	}
	@SuppressWarnings("rawtypes")
	public List areaListDelhi()
	{
		List<String> arealistdelhi = new ArrayList<>();
		arealistdelhi.add("MukherjiNagar");
		arealistdelhi.add("RajivChowk");
		arealistdelhi.add("HauzKaus");
		arealistdelhi.add("RajendraNagar");
		return arealistdelhi;
	}
	@SuppressWarnings("rawtypes")
	public List hotelList()
	{
		List<HotelDetailsDTO> hotellist=new ArrayList<>();
		hotellist.add(new HotelDetailsDTO(1,"Paradise","ABC Colony",4));
		hotellist.add(new HotelDetailsDTO(2,"Taj","XYZ Colony",4));
		return hotellist;
	}
	@SuppressWarnings("rawtypes")
	public List roomList()
	{
		List<RoomDetailsDTO> roomdetail=new ArrayList<>();
		return roomdetail;
		
	}
	
	
	@SuppressWarnings("rawtypes")
	public List typeOfRoom()
	{
		List<String> typeofroom=new ArrayList<>();
		typeofroom.add("KingSize");
		typeofroom.add("QueenSize");
		typeofroom.add("AC");
		typeofroom.add("NonAc");
		return typeofroom;
	}
	@SuppressWarnings("rawtypes")
	public List bookingDetailList() {
		List<BookingDetailsDTO> bookdetail=new ArrayList<>();
		return bookdetail;
	}
	@SuppressWarnings("rawtypes")
	public Map cancelBookingList()
	{
		Map<Integer, BookingDetailsDTO> cancelbookmap=new HashMap<>();
		return cancelbookmap;
		
	}
	
}

package com.cg.onlinehotelmanagementsystem.dto;

public class QueenRoomDetailsDTO {
	private int numberofqueenrooms;
	private boolean status;
	private double price;
	private int numberofperson;

	public QueenRoomDetailsDTO(int numberofqueenrooms, Boolean status, double price, int numberofperson) {
		super();
		this.numberofqueenrooms = numberofqueenrooms;
		this.status = status;
		this.price = price;
		this.numberofperson = numberofperson;
	}

	public int getNumberofqueenrooms() {
		return numberofqueenrooms;
	}

	public void setNumberofqueenrooms(int numberofqueenrooms) {
		this.numberofqueenrooms = numberofqueenrooms;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setNumberofperson(int numberofperson) {
		this.numberofperson = numberofperson;
	}

	public boolean getStatus() {
		return status;
	}

	public double getPrice() {
		return price;
	}

	public int getNumberofperson() {
		return numberofperson;
	}

}

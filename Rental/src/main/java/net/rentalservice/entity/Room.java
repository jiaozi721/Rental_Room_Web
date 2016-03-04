package net.rentalservice.entity;

import org.springframework.stereotype.Component;


@Component
public class Room {
	private int id;
	private String name;
	private int admitted;
	private int price;
	private String state;
	private String infor;
	private String img;
	
	public Room() {}
	
	public Room(int id, String name, int admitted, int price, String state, String infor, String img) {
		this.id = id;
		this.name = name;
		this.admitted = admitted;
		this.price = price;
		this.state = state;
		this.infor = infor;
		this.img = img;
		
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAdmitted() {
		return this.admitted;
	}
	
	public void setAdmitted(int admitted) {
		this.admitted = admitted;
	}
	
	public int getPrice() {
		return this.price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getState() {
		return this.state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public String getInfor() {
		return this.infor;
	}
	
	public void setInfor(String infor) {
		this.infor = infor;
	}
	
	public String getImg() {
		return this.img;
	}
	
	public void setImg(String img) {
		this.img = img;
	}
}

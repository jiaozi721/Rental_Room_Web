package net.rentalservice.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import net.rentalservice.entity.Member;
import net.rentalservice.entity.Room;
import net.rentalservice.service.RentalServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class RoomController {
	
	@Autowired
	private RentalServiceImpl rentalServiceImpl;
	
	private String logined_user = "";
		
	
	@RequestMapping(value="/status", method = RequestMethod.GET)
	@ResponseBody
	public String getStatus() {
		return logined_user;
	}
	
	
	
	@RequestMapping(value="/room", method=RequestMethod.GET)
	@ResponseBody
	public ArrayList<Room> allOfRooms() {
		ArrayList<Room> room = new ArrayList<Room>();
		room = rentalServiceImpl.getRooms();
		return room;
	}
	
	@RequestMapping(value="/room/{id}", method=RequestMethod.GET)
	@ResponseBody
	public Room seacrhRoom(@PathVariable("id") int id) {
		Room room = rentalServiceImpl.inqueryRoom(id);
		return room;
	}
	
	@RequestMapping(value="/room/{id}", method=RequestMethod.PUT)
	@ResponseBody
	public String updateRoom(@PathVariable("id") int id) {
		Room tRoom = rentalServiceImpl.inqueryRoom(id);
		String state = tRoom.getState();
		System.out.println(state);
		if(state.equals("used") == true) {
			return "Reservation failed!";
		}
		else {
			rentalServiceImpl.updateRoom(id);
			return "Reservation success!";
		}
	}
	
	@RequestMapping(value="/room/{id}", method=RequestMethod.DELETE)
	@ResponseBody
	public Room deleteRoom(@PathVariable("id") int id) {
		rentalServiceImpl.deleteRoom(id);
		Room deletedRoom = new Room();
		deletedRoom.setId(id);
		return deletedRoom;
	}
	
	@RequestMapping(value="/room", method=RequestMethod.POST)
	@ResponseBody
	public Room insertRoom(@RequestBody Room room) {
		rentalServiceImpl.insertRoom(room);
		Room insertedRoom = rentalServiceImpl.inqueryRoom(room.getId());
		return insertedRoom;
	}
	
	
	/////////////////////////////////////////////////////////////////////////////
	
	
	@RequestMapping(value="/user/{id}/{pw}", method=RequestMethod.GET)
	@ResponseBody
	public String inqueryUser(@PathVariable("id") String id, @PathVariable("pw") String pw) {
		Member member = new Member();
		String mesg = "";
		Map<String,String> map = new HashMap<String,String>();
		map.put("id", id);
		map.put("password", pw);
		member = rentalServiceImpl.inqueryMember(map);
		if(member != null)
		{
			logined_user = member.getId();
			mesg = "Hello " + logined_user + "!!!";
		}
		else {
			mesg = "Login failed.";
		}
		return mesg;
	}
	
	@RequestMapping(value="/user/logout",method=RequestMethod.GET)
	@ResponseBody
	public void logoutUser() {
		logined_user = "";
	}
	
	@RequestMapping(value="/user/signup", method=RequestMethod.POST)
	@ResponseBody
	public Member signUpUser(@RequestBody Member member) {
		rentalServiceImpl.insertMember(member);
		Member signedUpUser = rentalServiceImpl.searchMember(member.getId());
		return signedUpUser;
	}
	
	@RequestMapping(value="/user/{id}/modify", method=RequestMethod.PUT)
	@ResponseBody
	public Member modifyUserInfo(@PathVariable("id") String id, @RequestBody Member member) {
		rentalServiceImpl.updateMember(member);
		Member updatedUser = rentalServiceImpl.searchMember(member.getId());
		return updatedUser;		
	}
	
	@RequestMapping(value="/user/{id}", method=RequestMethod.DELETE)
	@ResponseBody
	public Member deleteUser(@PathVariable("id") String id) {
		rentalServiceImpl.deleteMember(id);
		Member deletedUser = new Member();
		deletedUser.setId(id);
		return deletedUser;
	}
	
}

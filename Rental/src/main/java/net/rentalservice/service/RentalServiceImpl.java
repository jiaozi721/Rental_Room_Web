package net.rentalservice.service;

import java.util.ArrayList;
import java.util.Map;

import net.rentalservice.dao.MemberDaoImpl;
import net.rentalservice.dao.RoomDaoImpl;
import net.rentalservice.entity.Member;
import net.rentalservice.entity.Room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RentalServiceImpl implements RentalService{
	
	@Autowired
	private MemberDaoImpl memberDaoImpl;
	@Autowired
	private RoomDaoImpl roomDaoImpl;
	
	
	@Override
	public ArrayList<Room> getRooms() {
		ArrayList<Room> room = new ArrayList<Room>();
		room = roomDaoImpl.getRooms();
		return room;
	}
	
	@Override
	public Room inqueryRoom(int id){
		Room room = new Room();
		room = roomDaoImpl.SearchRooms(id);
		return room;
	}
	
	@Override
	public void insertRoom(Room room) {
		roomDaoImpl.insertRoom(room);
	}
	
	@Override
	public void updateRoom(int id) {
		roomDaoImpl.updateRoom(id);
	}

	@Override
	public void deleteRoom(int id) {
		roomDaoImpl.deleteRoom(id);
	}
	
	
	
	
	@Override
	public Member inqueryMember(Map<String,String> map) {
		Member member = new Member();
		member = memberDaoImpl.inqueryMember(map);
		return member;
	}
	
	@Override
	public void insertMember(Member member) {
		memberDaoImpl.insertMember(member);
	}
	
	@Override
	public void updateMember(Member member) {
		memberDaoImpl.updateMember(member);
	}
	
	@Override
	public void deleteMember(String id) {
		memberDaoImpl.deleteMember(id);
	}
	
	@Override
	public Member searchMember(String id) {
		Member member = new Member();
		member = memberDaoImpl.searchMember(id);
		return member;	
	}
	
	
	///////////////////////
	@Override
	public boolean checkMember(String id, String pw) {
		return false;
	}
}

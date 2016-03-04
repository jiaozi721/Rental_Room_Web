package net.rentalservice.mapper;

import java.util.ArrayList;
import java.util.Map;

import net.rentalservice.entity.Room;
import net.rentalservice.entity.Member;

public interface Mapper {
	
	public ArrayList<Room> getRooms();
	public Room inqueryRoom(int id);
	public void insertRoom(Room room);
	public void updateRoom(int id);
	public void deleteRoom(int id);
	
	public Member inqueryMember(Map<String,String> map);
	public void insertMember(Member member);
	public void updateMember(Member member);
	public void deleteMember(String id);
	public Member searchMember(String id);

}

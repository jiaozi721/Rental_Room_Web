package net.rentalservice.dao;

import java.util.ArrayList;

import net.rentalservice.entity.Room;

public interface RoomDao {
	public ArrayList<Room> getRooms();
	public Room SearchRooms(int id);
	public void insertRoom(Room room);
	public void updateRoom(int id);
	public void deleteRoom(int id);
}
package net.rentalservice.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.rentalservice.mapper.Mapper;
import net.rentalservice.entity.Room;

@Repository
public class RoomDaoImpl implements RoomDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public ArrayList<Room> getRooms() {
		ArrayList<Room> result = new ArrayList<Room>();
		Mapper mapper = sqlSession.getMapper(Mapper.class);
		result = mapper.getRooms();
		return result;
	}
	
	@Override
	public Room SearchRooms(int id) {
		Room room = new Room();
		Mapper mapper = sqlSession.getMapper(Mapper.class);
		room = mapper.inqueryRoom(id);
		return room;
	}
	
	@Override
	public void insertRoom(Room room) {
		Mapper mapper = sqlSession.getMapper(Mapper.class);
		mapper.insertRoom(room);
	}
	
	@Override
	public void updateRoom(int id) {
		Mapper mapper = sqlSession.getMapper(Mapper.class);
		mapper.updateRoom(id);
	}
	
	@Override
	public void deleteRoom(int id) {
		Mapper mapper = sqlSession.getMapper(Mapper.class);
		mapper.deleteRoom(id);
	}
}

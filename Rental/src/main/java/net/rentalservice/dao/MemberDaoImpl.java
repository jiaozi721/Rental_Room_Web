package net.rentalservice.dao;

import java.util.Map;

import net.rentalservice.entity.Member;
import net.rentalservice.mapper.Mapper;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class MemberDaoImpl implements MemberDao{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public Member inqueryMember(Map<String,String> map) {
		Member member = new Member();
		Mapper mapper = sqlSession.getMapper(Mapper.class) ;
		member = mapper.inqueryMember(map);
		return member;		
	}
	
	@Override
	public void insertMember(Member member) {
		Mapper mapper = sqlSession.getMapper(Mapper.class);
		mapper.insertMember(member);
	}
	
	@Override
	public void updateMember(Member member) {
		Mapper mapper = sqlSession.getMapper(Mapper.class);
		mapper.updateMember(member);
	}
	
	@Override
	public void deleteMember(String id) {
		Mapper mapper = sqlSession.getMapper(Mapper.class);
		mapper.deleteMember(id);
	}
	
	////////////////////////////
	@Override
	public void checkMember(String pw) {
		//Mapper mapper = sqlSession.getMapper(Mapper.class);
	}
	
	@Override
	public Member searchMember(String id) {
		Member member = new Member();
		Mapper mapper = sqlSession.getMapper(Mapper.class);
		member = mapper.searchMember(id);
		return member;
	}
	
}

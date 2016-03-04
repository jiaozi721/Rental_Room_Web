package net.rentalservice.dao;

import java.util.Map;

import net.rentalservice.entity.Member;

public interface MemberDao {
	
	public Member inqueryMember(Map<String,String> map);
	public void updateMember(Member member);
	public void insertMember(Member member);
	public void deleteMember(String id);
	public void checkMember(String pw);
	public Member searchMember(String id);
	
}

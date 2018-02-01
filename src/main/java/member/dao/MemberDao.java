package member.dao;

import java.sql.Connection;
import java.util.List;

import member.model.Member;

public interface MemberDao {
	public void insert(Member member);
	public void update(Member member);
	public Member selectById(String id);
	public List<Member> selectMember();
}

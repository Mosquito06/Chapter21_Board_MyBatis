package member.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import member.dao.MemberDao;
import member.model.Member;
import mvc.util.MySqlSessionFactory;

public class MemberService {
	private static final MemberService instance = new MemberService();

	public static MemberService getInstance() {
		return instance;
	}

	private MemberService() {
	}

	public Member selectMember(String id) {
		SqlSession session = null;

		try {
			session = MySqlSessionFactory.openSession();
			MemberDao dao = session.getMapper(MemberDao.class);

			Member member = dao.selectById(id);
			return member;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MySqlSessionFactory.closeSession(session);
		}

		return null;

	}

	public List<Member> selectList() {
		SqlSession session = null;
		List<Member> memberList = new ArrayList<>();

		try {
			session = MySqlSessionFactory.openSession();
			MemberDao dao = session.getMapper(MemberDao.class);

			return memberList = dao.selectMember();

		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			MySqlSessionFactory.closeSession(session);
		}

		return null;

	}

	// -2 : dupulicateId
	public int insertMember(Member member) {
		SqlSession session = null;

		try {
			session = MySqlSessionFactory.openSession();
			MemberDao dao = session.getMapper(MemberDao.class);

			Member existMember = dao.selectById(member.getId());
			if (existMember != null) {
				return -2;
			}

			dao.insert(member);
			session.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MySqlSessionFactory.closeSession(session);
		}

		return -1;
	}

	public int updateMember(Member member) {
		SqlSession session = null;
		int result = 0;
		try {
			session = MySqlSessionFactory.openSession();
			MemberDao dao = session.getMapper(MemberDao.class);

			dao.update( member);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			MySqlSessionFactory.closeSession(session);
		}
		return -1;

	}
}

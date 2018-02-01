package member.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import member.model.Member;
import mvc.util.MySqlSessionFactory;

public class MemberDaoTest {

	/*@Test
	public void testInsert() {
		SqlSession session = null;

		try {
			session = MySqlSessionFactory.openSession();
			MemberDao dao = session.getMapper(MemberDao.class);
			Member mem = new Member("test", "김동환", "123", new Date());
			dao.insert(mem);

			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MySqlSessionFactory.closeSession(session);
		}
	}*/

	@Test
	public void testMember() {
		SqlSession session = null;

		try {
			session = MySqlSessionFactory.openSession();
			MemberDao dao = session.getMapper(MemberDao.class);

			List<Member> member = dao.selectMember();

			for (Member m : member) {
				System.out.println(m.toString());
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MySqlSessionFactory.closeSession(session);
		}

	}

	@Test
	public void testUpdate() {
		SqlSession session = null;

		try {
			session = MySqlSessionFactory.openSession();
			MemberDao dao = session.getMapper(MemberDao.class);
			Member mem = new Member("test", "김동환", "1234", new Date());
			dao.update(mem);

			session.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MySqlSessionFactory.closeSession(session);
		}

	}

	@Test
	public void testSelectById() {
		SqlSession session = null;

		try {
			session = MySqlSessionFactory.openSession();
			MemberDao dao = session.getMapper(MemberDao.class);

			Member member = dao.selectById("mosquito");
			
			System.out.println(member.getName());
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MySqlSessionFactory.closeSession(session);
		}

	}
}

package himedia.myportal.repositories.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import himedia.myportal.exceptions.GuestbookDaoException;
import himedia.myportal.repositories.vo.GuestbookVo;

@Repository("guestbookDao")
public class GuestbookDaoImpl implements GuestbookDao {
	@Autowired
	SqlSession sqlSession; 
	
	@Override
	public List<GuestbookVo> selectAll() {
		List<GuestbookVo> list = 
				sqlSession.selectList("guestbook.selectAll");
		return list;
	}

	@Override
	public int insert(GuestbookVo vo) {
		try {
			int insertedCount = sqlSession.insert("guestbook.insert", vo);
			return insertedCount;
		} catch(Exception e) {		// 원래는 PersistenceException 사용 -> DAO Exception 은 구체적인 사용자정의 예외로 전환하여 throw 한다.
			throw new GuestbookDaoException("방명록 기록 중 예외 발생!", vo);
		}
	}

	@Override
	public int delete(GuestbookVo vo) {
		try {
			return sqlSession.delete("guestbook.delete", vo);
		} catch (Exception e) {
			throw new GuestbookDaoException("방명록 삭제 중 예외 발생!", vo);
		}
		
	}

}

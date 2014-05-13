package dao;

import ibatis.SqlMapLocator;

import java.sql.SQLException;

import model.MemBean;

public class MemDAOImpl implements MemDAO {
	
	/*
	 * ibatis쿼리문 실행 메서드 5가지 정리
	 *  1.insert(): 레코드 저장
	 *  2.update(): 레코드 수정
	 *  3.delete(): 레코드 삭제
	 *  4.queryForObject() : 단 한개의레코드 만을 검색
	 *  5.queryForList():하나이상의 레코드를 검색하여 컬렉션 List로 반환할때
	 */
	@Override
	public void insertM(MemBean m) throws SQLException {
		SqlMapLocator.getMapper().insert("mem_in", m);
		//mem_in은 insert 아이디 이름
	}//회원저장

	@Override
	public MemBean findId(String mem_id) throws SQLException {
		return (MemBean) SqlMapLocator.getMapper().queryForObject("dbid_check",mem_id);
		//dbid_check는 select 아이디 이름
	}//중복아이디 검색

	@Override
	public MemBean loginCheck(String login_id) throws SQLException {
	    return (MemBean)SqlMapLocator.getMapper().queryForObject("logincheck", login_id);
	}//로그인 인증
	
}

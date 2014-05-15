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

	@Override
	public String findPhone(String id) throws SQLException {
	  return (String)SqlMapLocator.getMapper().queryForObject("phonecheck",id);	
	
	}//전화번호

	@Override
	public int editM(MemBean em) throws SQLException {
		int re=0;
		re=SqlMapLocator.getMapper().update("medit", em);
		//medit는 udpate 아이디 이름
		return re;
		/* 
		 * 월말평가 문제
		 * 1. ibatis에서 update(),delete()메서드는 반환값이 쿼리문
		 *    실행된 레코드의 행(rows)의 갯수를 반환, 한개의 레코드 값이
		 *    수정 성공시 리턴값은 정수형 숫자 1
		 */
	}//정보수정

	@Override
	public void deleteM(MemBean dm) throws SQLException {
	SqlMapLocator.getMapper().update("mdel",dm);
	//mdel은 udpate 아이디 이름.
		
	}//회원탈퇴
	
}

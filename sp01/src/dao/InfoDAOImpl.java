package dao;

import ibatis.SqlMapLocator;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.InfoBean;

public class InfoDAOImpl implements InfoDAO {
/* 
 * ibatis ORM 디비 연동 프레임웍 쿼리문 실행 메서드
 * (월말평가문제)
 *  1.insert():레코드 저장
 *  2.udpate():레코드 수정
 *  3.delete():레코드 삭제
 *  4.queryForObject():단 한개의 레코드만 검색
 *  5.queryForList():하나이상 레코드를 검색해서 컬렉션 List로 반환할때사용
 *  
 */
	
	@Override
	public void insertB(InfoBean ib) throws SQLException {
	 SqlMapLocator.getMapper().insert("ib_in", ib);
	 //ib_in은 insert 아이디 이름
		
	}//저장

	@Override
	public List<InfoBean> getIList() throws SQLException {
		List<InfoBean> glist=new ArrayList<InfoBean>();
	return SqlMapLocator.getMapper().queryForList("ilist", glist);

	}

}

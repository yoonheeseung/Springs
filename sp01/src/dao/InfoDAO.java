package dao;

import java.sql.SQLException;
import java.util.List;

import model.InfoBean;

public interface  InfoDAO {

	void insertB(InfoBean ib) throws SQLException;//저장
	//추상메서드

	List<InfoBean> getIList() throws SQLException;//list 가져오기
    //추상메서드
}

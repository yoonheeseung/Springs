package dao;

import java.sql.SQLException;

import model.MemBean;

public interface MemDAO {

void insertM(MemBean m) throws SQLException;//저장

MemBean findId(String mem_id) throws SQLException;//중복 체크,public abstract이 생략된 추상메서드

MemBean loginCheck(String login_id) throws SQLException;//로그인 인증
}

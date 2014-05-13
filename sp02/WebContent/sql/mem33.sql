/* mem33.sql */
/*
 * ibatis ORM 디비연동 프레임웍을 사용할려면 테이블 필드명과
 * 자바 저장빈 클래스의 변수명을 같게 한다. 자료형도 같게 한다.
 */

create table mem33(
mem_id varchar2(30) primary key,
mem_pwd varchar2(30) not null,
mem_name varchar2(30) not null,
mem_addr varchar2(200) not null,
mem_phone01 varchar2(6),
mem_phone02 varchar2(10) not null,
mem_phone03 varchar2(10) not null,
mem_regdate date,/* 회원등록 날짜 */
mem_status int, /* 가입회원 1, 탈퇴 회원 2*/
mem_delcont varchar2(4000),/* 탈퇴 사유 */
mem_deldate date /* 탈퇴 날짜 */
);
 

select * from mem33;
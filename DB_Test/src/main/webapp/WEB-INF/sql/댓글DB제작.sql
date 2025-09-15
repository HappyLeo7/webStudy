-- 댓글 테이블 생성
create table comments(
	idx int
	, name varchar2(100) not null
	, content varchar2(2000) not null
	, pwd varchar2(100) not null
	, ip varchar2(100) not null
	, regdate date
)

-- 기본키 설정
alter table comments add constraint pk_comments_idx primary key(idx)

-- 시퀀스 1개를 만든다.
create sequence seq_visit_idx

-- 데이터 넣어두기
insert into comments values(seq_visit_idx.nextVal,'익명자','수업이 너무 재미있고 알차요','1234','0.0.0.0.0.0.1',sysdate)
insert into comments values(seq_visit_idx.nextVal,'익명자','수업중에 잠을 잘수 없게 집중돼요','1234','0.0.0.0.0.0.2',sysdate)


-- 테이블 전체 조회
select * from comments

--일련번호 관리객체(내용을 생략하면 1부터 시작 1씩증) , sequence가 만들어지면 초기값은 0이다.
create sequence seq_visit_idx


--방명록 테이블
create table visit
(
	idx int,					-- 일련번호
	name varchar2(100) not null,   --이름
	content varchar2(2000) not null, --내용
	pwd varchar2(100) not null, --비밀번호
	ip varchar2(100) not null, --아이피
	regdate date 				--등록일자
)

--기본키(pk) 지정
alter table visit
	add constraint pk_visit_idx primary key(idx)
	
	
-- sample data
-- date 1)
insert into visit values(seq_visit_idx.nextVal
						,'일길동'
						,'내가 1등이야'
						,'1234'
						,'127.0.0.1'
						,sysdate
)
-- date 2)
insert into visit values(seq_visit_idx.nextVal
						,'이길동'
						,'아쉽네 내가 1등할수 있었는데....'
						,'1234'
						,'127.0.0.1'
						,sysdate
)
-- date 에서 데이터 대신에 물음표를 넣는다.
insert into visit values(seq_visit_idx.nextVal
						,?  -- name
						,?  -- content
						,?	-- pwd
						,?	-- ip
						,sysdate
)
insert into visit values(seq_visit_idx.nextVal,?,?,?,?,sysdate)
select * from visit order by idx desc

commit
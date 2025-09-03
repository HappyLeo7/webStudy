--일련번호 관리객체
create sequence seq_member_mem_idx;

--테이블
create table member(
mem_idx int  -- 회원번호
,mem_name varchar2(100) not null --회원명
,mem_id varchar2(100) not null  --아이디
,mem_pwd varchar2(100) not null  --비밀번호
,mem_email varchar2(100) not null  --이메일
,mem_zippcode varchar2(10) not null  --우편번호
,mem_addr varchar2(200) not null  --주소
,mem_ip varchar2(100) not null  --아이피
,mem_regdate date not null  --가입일자
,mem_grade varchar2(100) not null  --회원등급

);

--기본키
alter table member add constraint pk_member_mem_idx primary key(mem_idx);

-- unique제약
alter table member add constraint unique_member_mem_id unique(mem_id);

-- 체크제약
alter table member add constraint ck_member_mem_grade check(mem_grade in('일반','관리자'));


--샘플데이터
insert into member values (seq_member_mem_idx.nextval
							,'경원이'
							,'suh'
							,'1122##'
							,'suh@gg.com'
							,'1522-1'
							,'서울시 관악구 남부순환로123'
							,'192.255.111.231'
							,sysdate
							,'관리자'
							);
insert into member values (seq_member_mem_idx.nextval
							,'이기자'
							,'li1'
							,'1122##'
							,'li@gg.com'
							,'1522-1'
							,'서울시 관악구 남부순환로123'
							,'192.255.111.231'
							,sysdate
							,'일반'
							);

--전체조회							
select * from member;

--회원번호로 1개 조회
select * from member where mem_idx =1;
--회원아이디로 1개 조회
select * from member where mem_id = 'suh';

commit

select * from all_tables;

create table board2(
	bid int primary key,
	title varchar(200),
	writer varchar(100),
	content varchar(500),
	bdate date default sysdate,
	cnt int default 0,
	filepath varchar(100)
);
/* MySQL: insert ? now() */

select * from board2;

create table member2(
	mid varchar(100) primary key,
	password varchar(100),
	name varchar(100),
	role varchar(100)
);
insert into member2 values('kim','1234','티모','USER');
insert into member2 values('admin','1234','관리자','ADMIN');
select * from member2;

drop table member2;
drop table board2;
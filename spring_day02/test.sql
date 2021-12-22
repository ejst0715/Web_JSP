select * from all_tables;

create table board2(
	bid int primary key,
	title varchar(20),
	writer varchar(10),
	content varchar(50),
	bdate date default sysdate,
	cnt int default 0
);

select * from BOARD2;


create table member2(
	mid varchar(10) primary key,
	password varchar(10),
	name varchar(10),
	role varchar(10)
);

select * from member2;

insert into member2 values('bang','1234','길동','user');
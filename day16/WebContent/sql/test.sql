select * from all_tables;

drop table member;;

create table board(
	bid int primary key,
	mid varchar(20) not null,
	msg varchar(50) not null,
	favcnt int default 0
);

create table member(
	mid varchar(20) primary key,
	mpw varchar(20) not null,
	mname varchar(15) not null
);

create table reply(
	rid int primary key,
	bid int not null,
	mid varchar(20) not null,
	rsmg varchar(30) not null,
	constraint board_fk foreign key(bid) references board(bid) on delete cascade
);



select * from board;
select * from member;


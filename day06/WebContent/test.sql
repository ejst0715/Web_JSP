select * from all_tables;

create  table test(
	a int,
	b varchar(10)
);
insert into test values(10,'홍길동');
insert into test values(20,'김철수');
insert into test values(30,'김영희');
insert into test values(40,'김따릉');
insert into test values(50,'김하나');
insert into test values(60,'김무개');
insert into test values(70,'김설춘');
select * from test;
drop table test;
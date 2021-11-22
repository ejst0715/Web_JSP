select * from all_tables;

create  table test(
	a int,
	b varchar(10)
);
insert into test values(10,'홍길동');
select * from test;
drop table test;
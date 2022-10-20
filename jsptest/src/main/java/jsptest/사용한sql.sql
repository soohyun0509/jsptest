drop database if exists jsptest;
create database jsptest;

use jsptest;


drop table if exists board;
create table board(
	bno int auto_increment primary key,
    btitle varchar(100),
    bcontent varchar(1000),
    bwriter varchar(20),
    bpassword char(10),
    bdate datetime default now(),
    bview int default 0
);
create database online_banking;

create table user_accounts
( 
name varchar(40),
account_number int,
user_n varchar(40),
pass varchar(40),
email varchar(60),
balance int
);

insert into user_accounts values('mridul',1,'abc',123,'mridulchopra97@gmail.com',1000);
insert into user_accounts values('Ashutosh',2,'xyz',123,'mridulchopra97@gmail.com',500);
select * from user_accounts 
delete  from user_accounts;

create table admin
(
	branch varchar(40),
	pass varchar(40),
)

insert into admin values('branch 1' ,'1');
insert into admin values('branch 2' ,'2');
insert into admin values('branch 3' ,'3');
insert into admin values('branch 4' ,'4');
insert into admin values('branch 5' ,'5');

select * from admin
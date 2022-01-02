/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.5.40 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `loginuser` (
	`loginName` varchar (765),
	`userPassword` varchar (765)
); 
insert into `loginuser` (`loginName`, `userPassword`) values('Emma Stone','123');
insert into `loginuser` (`loginName`, `userPassword`) values('','');
insert into `loginuser` (`loginName`, `userPassword`) values('John Legend','123');

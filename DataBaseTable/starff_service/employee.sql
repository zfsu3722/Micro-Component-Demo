/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.5.40 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `employee` (
	`empNo` varchar (60),
	`itemId` varchar (60),
	`empName` varchar (60),
	`empPhoneNo` bigint (15),
	`empAdress` varchar (60),
	`account` bigint (20)
); 
insert into `employee` (`empNo`, `itemId`, `empName`, `empPhoneNo`, `empAdress`, `account`) values('JC2021','T19950901','James Cameron','4103562000',NULL,'4117744000000000');
insert into `employee` (`empNo`, `itemId`, `empName`, `empPhoneNo`, `empAdress`, `account`) values('JK2006','La20161216','J.K.Simmons','6203562231',NULL,'6257744000000142');

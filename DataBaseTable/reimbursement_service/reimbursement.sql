/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.5.40 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `reimbursement` (
	`serialId` varchar (60),
	`itemId` varchar (60),
	`itemName` varchar (60),
	`total` varchar (60),
	`refund` varchar (60),
	`refundTime` varchar (60),
	`financeStaff` varchar (60),
	`account` varchar (60)
); 
insert into `reimbursement` (`serialId`, `itemId`, `itemName`, `total`, `refund`, `refundTime`, `financeStaff`, `account`) values('s19971201','T19950901','Titanic','$20000000','$20000000','12,02,1997','J.R.Smith','4117744000000000');
insert into `reimbursement` (`serialId`, `itemId`, `itemName`, `total`, `refund`, `refundTime`, `financeStaff`, `account`) values('s20170101','La20161216','La La Land','$30000000','$10000000','01,02,2017','Ryan Gosling','6257744000000142');
insert into `reimbursement` (`serialId`, `itemId`, `itemName`, `total`, `refund`, `refundTime`, `financeStaff`, `account`) values('s20200101','La20161216','La La Land','$30000000','$19000000','01,02,2020','Ryan Gosling','6257744000000142');

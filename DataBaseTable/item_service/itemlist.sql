/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.5.40 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `itemlist` (
	`itemId` varchar (60),
	`itemName` varchar (60),
	`empNo` varchar (60),
	`startTime` varchar (60),
	`endTime` varchar (60),
	`total` int (20),
	`finishFlag` varchar (60)
); 
insert into `itemlist` (`itemId`, `itemName`, `empNo`, `startTime`, `endTime`, `total`, `finishFlag`) values('La20161216','La La Land','JK2006','12,16,2016',NULL,'30000000','executing');
insert into `itemlist` (`itemId`, `itemName`, `empNo`, `startTime`, `endTime`, `total`, `finishFlag`) values('T19950901','Titanic','JC2021','09,01,1995','12,01,1997','20000000','finished');

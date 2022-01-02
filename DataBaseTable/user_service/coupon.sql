/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.5.40 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `coupon` (
	`couponId` varchar (60),
	`couponDesc` varchar (150),
	`originalPrice` varchar (30),
	`discount` varchar (30),
	`loginName` varchar (60),
	`id` int (10),
	`goodsType` varchar (60)
); 
insert into `coupon` (`couponId`, `couponDesc`, `originalPrice`, `discount`, `loginName`, `id`, `goodsType`) values('3c2201814','$200 USD discount FOR more THAN $1999 USD','$1999','$200','Emma Stone','2','3c');
insert into `coupon` (`couponId`, `couponDesc`, `originalPrice`, `discount`, `loginName`, `id`, `goodsType`) values('food20220101','$0.1 USD discount FOR more THAN $2 USD','$2','$0.1','Emma Stone','3','foods');
insert into `coupon` (`couponId`, `couponDesc`, `originalPrice`, `discount`, `loginName`, `id`, `goodsType`) values('shoes20220101','$10 USD discount FOR more THAN $100 USD','$100','$10','Emma Stone','4','shoes');

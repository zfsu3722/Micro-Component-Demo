/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.5.40 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `shoppingcart` (
	`Id` int (10),
	`goodsId` varchar (60),
	`goodsName` varchar (300),
	`goodsPrice` varchar (45),
	`goodsDesc` varchar (300),
	`goodsNumber` varchar (45),
	`loginName` varchar (60),
	`goodsType` varchar (60),
	`goodsImg` varchar (60)
); 
insert into `shoppingcart` (`Id`, `goodsId`, `goodsName`, `goodsPrice`, `goodsDesc`, `goodsNumber`, `loginName`, `goodsType`, `goodsImg`) values('33','3','Jordan Preschool Air 6 Retro PS 384666 106 Carmine 2021 - Size','$144.50','Sufficient inventory  no reason to return within 7 days','50000+','Emma Stone','shoes','goods3.png');
insert into `shoppingcart` (`Id`, `goodsId`, `goodsName`, `goodsPrice`, `goodsDesc`, `goodsNumber`, `loginName`, `goodsType`, `goodsImg`) values('34','1','Apple iPhone 11 Pro 64GB Space Gray-Unlocked','$599.00','Enjoy 12 periods of interest free + free iPhone headset','6000+','Emma Stone','3c','goods1.png');

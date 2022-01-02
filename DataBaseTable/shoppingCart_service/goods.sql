/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.5.40 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `goods` (
	`goodsId` varchar (60),
	`goodsName` varchar (300),
	`goodsPrice` varchar (60),
	`goodsDesc` varchar (300),
	`goodsNumber` varchar (60),
	`goodsType` varchar (60),
	`goodsImg` varchar (60)
); 
insert into `goods` (`goodsId`, `goodsName`, `goodsPrice`, `goodsDesc`, `goodsNumber`, `goodsType`, `goodsImg`) values('1','Apple iPhone 11 Pro 64GB Space Gray-Unlocked','$599.00','Enjoy 12 periods of interest free + free iPhone headset','6000+','3c','goods1.png');
insert into `goods` (`goodsId`, `goodsName`, `goodsPrice`, `goodsDesc`, `goodsNumber`, `goodsType`, `goodsImg`) values('2','Marvel Avengers Action Figures','$42.99','Pack 8 Marvel Super Hero figures Hulk','7000+','toys','goods2.png');
insert into `goods` (`goodsId`, `goodsName`, `goodsPrice`, `goodsDesc`, `goodsNumber`, `goodsType`, `goodsImg`) values('3','Jordan Preschool Air 6 Retro PS 384666 106 Carmine 2021 - Size','$144.50','Sufficient inventory  no reason to return within 7 days','50000+','shoes','goods3.png');
insert into `goods` (`goodsId`, `goodsName`, `goodsPrice`, `goodsDesc`, `goodsNumber`, `goodsType`, `goodsImg`) values('4','Lay Kettle Cooked Potato Chips Variety Pack','$19.90','Enjoy your favorite Lay Kettle Cooked and original recipe potato chips in one variety pack','20000+','foods','goods4.png');
insert into `goods` (`goodsId`, `goodsName`, `goodsPrice`, `goodsDesc`, `goodsNumber`, `goodsType`, `goodsImg`) values('5','Men Full-Zip Polar Fleece Vest','$24.90','Fall 21 new fashion cartoon printed round neck sweater black','5000+','clothes','goods5.png');
insert into `goods` (`goodsId`, `goodsName`, `goodsPrice`, `goodsDesc`, `goodsNumber`, `goodsType`, `goodsImg`) values('6','Flying Cauldron Butterscotch Beer 12 Oz 4 Bottles','$19.90','If you are a wizard or not you will love Flying Cauldron Butterscotch Beer','50000+','beers','goods6.png');

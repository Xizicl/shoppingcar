/*
SQLyog Community v13.1.7 (64 bit)
MySQL - 8.0.27 : Database - bookcart
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bookcart` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `bookcart`;

/*Table structure for table `bookcart` */

DROP TABLE IF EXISTS `bookcart`;

CREATE TABLE `bookcart` (
  `cartID` int NOT NULL AUTO_INCREMENT,
  `memberID` int DEFAULT NULL,
  `createTime` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `totalPrice` float NOT NULL,
  ` totalCount` int DEFAULT NULL,
  PRIMARY KEY (`cartID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;

/*Data for the table `bookcart` */

/*Table structure for table `books` */

DROP TABLE IF EXISTS `books`;

CREATE TABLE `books` (
  `bookID` int NOT NULL AUTO_INCREMENT,
  `isbn` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `bookName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `bookPrice` float NOT NULL,
  `discount` float DEFAULT NULL,
  `author` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `publisher` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`bookID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;

/*Data for the table `books` */

insert  into `books`(`bookID`,`isbn`,`bookName`,`bookPrice`,`discount`,`author`,`publisher`) values 
(1,'98754651234','JavaScript',26,0.65,'',''),
(2,'9787302150718','Java1',49,0.8,'',''),
(3,'9787302150097','Java2',64,0.85,'',''),
(4,'9787302145783','Java3',29.5,0.7,'',''),
(5,'9787302148760','JBossJavaEE',38,0.8,'',''),
(6,'9787302146957','Java4',35,0.9,'',''),
(7,'9787302145981','Java5',19.8,0.75,'','');

/*Table structure for table `cartlist` */

DROP TABLE IF EXISTS `cartlist`;

CREATE TABLE `cartlist` (
  `cartlistID` int NOT NULL AUTO_INCREMENT,
  `cartID` int DEFAULT NULL,
  `bookID` int NOT NULL,
  `disPrice` float NOT NULL,
  `bookCount` int DEFAULT NULL,
  PRIMARY KEY (`cartlistID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

/*Data for the table `cartlist` */

/*Table structure for table `member` */

DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
  `memberID` int NOT NULL AUTO_INCREMENT,
  `memberEmail` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `memberName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `memberPassword` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`memberID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;

/*Data for the table `member` */

insert  into `member`(`memberID`,`memberEmail`,`memberName`,`memberPassword`) values 
(1,'admin','admin','123456');

/*Table structure for table `orderlist` */

DROP TABLE IF EXISTS `orderlist`;

CREATE TABLE `orderlist` (
  `orderlistID` int NOT NULL AUTO_INCREMENT,
  `orderID` int DEFAULT NULL,
  `bookID` int NOT NULL,
  `disPrice` float unsigned zerofill NOT NULL,
  `discount` int DEFAULT NULL,
  PRIMARY KEY (`orderlistID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

/*Data for the table `orderlist` */

/*Table structure for table `orders` */

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `orderID` int NOT NULL AUTO_INCREMENT,
  `memeberID` int DEFAULT NULL,
  `orderTime` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `consignee` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `tel` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `postNumber` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `totalCount` float DEFAULT NULL,
  `totalPrice` float DEFAULT NULL,
  `paymode` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `delivemode` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `isOut` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`orderID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

/*Data for the table `orders` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

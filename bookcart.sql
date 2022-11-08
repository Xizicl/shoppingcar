/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : localhost:3306
 Source Schema         : bookcart

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 22/02/2022 20:02:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bookcart
-- ----------------------------
DROP TABLE IF EXISTS `bookcart`;
CREATE TABLE `bookcart`  (
  `cartID` int(4) NOT NULL AUTO_INCREMENT,
  `memberID` int(4) NULL DEFAULT NULL,
  `createTime` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `totalPrice` float NOT NULL,
  ` totalCount` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`cartID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci;

-- ----------------------------
-- Records of bookcart
-- ----------------------------
BEGIN;
INSERT INTO `bookcart` VALUES (1, 1, '2019-12-17', 0, 0);
COMMIT;

-- ----------------------------
-- Table structure for books
-- ----------------------------
DROP TABLE IF EXISTS `books`;
CREATE TABLE `books`  (
  `bookID` int(4) NOT NULL AUTO_INCREMENT,
  `isbn` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bookName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `bookPrice` float NOT NULL,
  `discount` float NULL DEFAULT NULL,
  `author` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `publisher` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`bookID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci;

-- ----------------------------
-- Records of books
-- ----------------------------
BEGIN;
INSERT INTO `books` VALUES (1, '98754651234', 'JavaScript程序设计', 26, 0.65, '贾素玲等', '清华大学出版社'), (2, '9787302150718', 'Java基础及应用教程', 49, 0.8, '史斌星等', '清华大学出版社'), (3, '9787302150097', 'Java2面向对象程序设计基础与·实例解析', 64, 0.85, '陈艳华', '清华大学出版社'), (4, '9787302145783', 'Java基础教程（第二版）', 29.5, 0.7, '耿祥义', '清华大学出版社'), (5, '9787302148760', 'JBoss平台上的JavaEE程序开发指南', 38, 0.8, '张洪斌', '高等教育出版社'), (6, '9787302146957', 'Java程序设计全真模拟试卷（二级）', 35, 0.9, '戴军', '高等教育出版社'), (7, '9787302145981', 'Java基础教程（第二版）实践学习与提高', 19.8, 0.75, '耿祥义', '高等教育出版社');
COMMIT;

-- ----------------------------
-- Table structure for cartlist
-- ----------------------------
DROP TABLE IF EXISTS `cartlist`;
CREATE TABLE `cartlist`  (
  `cartlistID` int(4) NOT NULL AUTO_INCREMENT,
  `cartID` int(4) NULL DEFAULT NULL,
  `bookID` int(4) NOT NULL,
  `disPrice` float NOT NULL,
  `bookCount` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`cartlistID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci;

-- ----------------------------
-- Records of cartlist
-- ----------------------------
BEGIN;
INSERT INTO `cartlist` VALUES (1, 1, 1, 1, 1);
COMMIT;

-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member`  (
  `memberID` int(4) NOT NULL AUTO_INCREMENT,
  `memberEmail` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `memberName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `memberPassword` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`memberID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci;

-- ----------------------------
-- Records of member
-- ----------------------------
BEGIN;
INSERT INTO `member` VALUES (1, 'admin', 'admin', '123456');
COMMIT;

-- ----------------------------
-- Table structure for orderlist
-- ----------------------------
DROP TABLE IF EXISTS `orderlist`;
CREATE TABLE `orderlist`  (
  `orderlistID` int(4) NOT NULL AUTO_INCREMENT,
  `orderID` int(4) NULL DEFAULT NULL,
  `bookID` int(4) NOT NULL,
  `disPrice` float UNSIGNED ZEROFILL NOT NULL,
  `discount` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`orderlistID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci;

-- ----------------------------
-- Records of orderlist
-- ----------------------------
BEGIN;
INSERT INTO `orderlist` VALUES (1, 1, 1, 0000000016.9, 1), (2, 3, 1, 0000000016.9, 2), (3, 3, 2, 0000000039.2, 1), (4, 4, 1, 0000000016.9, 2), (5, 5, 1, 0000000016.9, 1), (6, 5, 2, 0000000039.2, 1), (7, 6, 1, 0000000016.9, 2), (8, 6, 2, 0000000039.2, 1), (9, 6, 3, 0000000054.4, 2), (10, 6, 4, 000000020.65, 1), (11, 2, 1, 0000000016.9, 2), (12, 2, 2, 0000000039.2, 1), (13, 2, 1, 0000000016.9, 2), (14, 2, 4, 000000020.65, 1);
COMMIT;

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `orderID` int(4) NOT NULL AUTO_INCREMENT,
  `memeberID` int(4) NULL DEFAULT NULL,
  `orderTime` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `consignee` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `tel` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `postNumber` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `totalCount` float NULL DEFAULT NULL,
  `totalPrice` float NULL DEFAULT NULL,
  `paymode` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `delivemode` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `isOut` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`orderID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci;

-- ----------------------------
-- Records of orders
-- ----------------------------
BEGIN;
INSERT INTO `orders` VALUES (1, 11, '11', '3121', '1', '1', '1', 1, 1, '1', '11', '1'), (7, 1, '2020-01-03 10:54:38', '', '', '', '', 3, 73, '邮局汇款', '普通邮寄', '0'), (8, 1, '2020-01-03 11:01:36', '', '', '', '', 3, 54.45, '邮局汇款', '普通邮寄', '0');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;

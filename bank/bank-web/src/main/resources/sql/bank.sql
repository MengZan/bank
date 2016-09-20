/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50628
Source Host           : localhost:3306
Source Database       : bank

Target Server Type    : MYSQL
Target Server Version : 50628
File Encoding         : 65001

Date: 2016-08-17 19:30:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin_user
-- ----------------------------
DROP TABLE IF EXISTS `admin_user`;
CREATE TABLE `admin_user` (
  `id` bigint(12) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin_user
-- ----------------------------
INSERT INTO `admin_user` VALUES ('1', 'admin', '480');

-- ----------------------------
-- Table structure for bank_data
-- ----------------------------
DROP TABLE IF EXISTS `bank_data`;
CREATE TABLE `bank_data` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `fromuser` int(18) NOT NULL,
  `touser` int(18) NOT NULL,
  `money` decimal(20,2) NOT NULL,
  `datetime` datetime NOT NULL,
  `fromplace` varchar(50) NOT NULL,
  `toplace` varchar(50) NOT NULL,
  `tool` varchar(50) NOT NULL,
  `safe_level` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bank_data
-- ----------------------------
INSERT INTO `bank_data` VALUES ('1', '1', '2', '100.00', '2016-08-17 16:22:32', '上海', '南京', '手机', null);
INSERT INTO `bank_data` VALUES ('2', '1', '2', '10.00', '2016-08-17 16:23:05', '上海', '上海', '手机', null);
INSERT INTO `bank_data` VALUES ('3', '1', '2', '20.00', '2016-08-17 16:24:00', '上海', '上海', '手机', null);

-- ----------------------------
-- Table structure for bank_rule
-- ----------------------------
DROP TABLE IF EXISTS `bank_rule`;
CREATE TABLE `bank_rule` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `rulename` varchar(50) NOT NULL,
  `ruledesc` varchar(255) DEFAULT NULL,
  `frequency` bigint(255) NOT NULL DEFAULT '0',
  `type` varchar(50) DEFAULT NULL,
  `safe_level` int(2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bank_rule
-- ----------------------------
INSERT INTO `bank_rule` VALUES ('1', '短时间内频繁交易', '{\"time\":\"30min\",\"deals\":3,\"isCommonFromPlace\":null}', '0', '网银', '2');
INSERT INTO `bank_rule` VALUES ('2', '转出地址可疑', '{\"time\":\"\",\"deals\":null,\"isCommonFromPlace\":true}', '0', '所有', '3');

-- ----------------------------
-- Table structure for bank_user
-- ----------------------------
DROP TABLE IF EXISTS `bank_user`;
CREATE TABLE `bank_user` (
  `id` bigint(18) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(32) NOT NULL,
  `usertype` int(12) NOT NULL DEFAULT '2',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bank_user
-- ----------------------------
INSERT INTO `bank_user` VALUES ('1', '张三', '480', '2');
INSERT INTO `bank_user` VALUES ('2', '李四', '480', '2');

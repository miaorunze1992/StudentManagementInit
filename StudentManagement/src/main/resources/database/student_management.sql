/*
 Navicat Premium Data Transfer

 Source Server         : mysql5.7
 Source Server Type    : MySQL
 Source Server Version : 50720 (5.7.20)
 Source Host           : localhost:3306
 Source Schema         : student_management

 Target Server Type    : MySQL
 Target Server Version : 50720 (5.7.20)
 File Encoding         : 65001

 Date: 05/03/2023 14:17:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for USER_INFO
-- ----------------------------
DROP TABLE IF EXISTS `USER_INFO`;
CREATE TABLE `USER_INFO` (
  `USERNAME` varchar(10) NOT NULL COMMENT '用户名',
  `PASSWORD` varchar(8) NOT NULL COMMENT '密码',
  `GENDER` int(1) DEFAULT NULL COMMENT '性别',
  `ADDRESS` varchar(20) DEFAULT NULL COMMENT '住址',
  `COUNTRY` int(1) DEFAULT NULL COMMENT '国家',
  `COMMENT` varchar(80) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`USERNAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of USER_INFO
-- ----------------------------
BEGIN;
INSERT INTO `USER_INFO` (`USERNAME`, `PASSWORD`, `GENDER`, `ADDRESS`, `COUNTRY`, `COMMENT`) VALUES ('刘六', '123', 0, '新小岩', 0, '吃货');
INSERT INTO `USER_INFO` (`USERNAME`, `PASSWORD`, `GENDER`, `ADDRESS`, `COUNTRY`, `COMMENT`) VALUES ('张三', '123', 1, '秋叶原', 1, '技术不错');
INSERT INTO `USER_INFO` (`USERNAME`, `PASSWORD`, `GENDER`, `ADDRESS`, `COUNTRY`, `COMMENT`) VALUES ('李四', '123', 0, '上野', 0, '前台厉害');
INSERT INTO `USER_INFO` (`USERNAME`, `PASSWORD`, `GENDER`, `ADDRESS`, `COUNTRY`, `COMMENT`) VALUES ('王五', '123', 0, '池袋', 2, '万年PG');
INSERT INTO `USER_INFO` (`USERNAME`, `PASSWORD`, `GENDER`, `ADDRESS`, `COUNTRY`, `COMMENT`) VALUES ('田七', '123', 1, '西川口', 0, '后台厉害');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;

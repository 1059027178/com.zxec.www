/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50096
Source Host           : localhost:3306
Source Database       : thinkway

Target Server Type    : MYSQL
Target Server Version : 50096
File Encoding         : 10008

Date: 2014-07-03 08:56:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sequence`
-- ----------------------------
DROP TABLE IF EXISTS sequence;
/
CREATE TABLE sequence (
  NAME varchar2(50) NOT NULL ,
  NEXTID integer(10) NOT NULL
)
/
-- ----------------------------
-- Records of sequence
-- ----------------------------
INSERT INTO sequence VALUES ('user', '1001');
INSERT INTO sequence VALUES ('hrminfo', '1001');

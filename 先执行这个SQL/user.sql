/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50559
Source Host           : localhost:3306
Source Database       : springsecurity_test

Target Server Type    : MYSQL
Target Server Version : 50559
File Encoding         : 65001

Date: 2020-12-11 19:02:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(30) NOT NULL,
  `password` varchar(60) NOT NULL,
  `role` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'answer', '$2a$10$Nv2zUaxoNegAqyoHZzv78OpTOsCezOjqJw8f9IgiFCxeyXAmuA3wm', 'ROLE_USER');
INSERT INTO `user` VALUES ('2', 'wenxin', '$2a$10$Nv2zUaxoNegAqyoHZzv78OpTOsCezOjqJw8f9IgiFCxeyXAmuA3wm', 'ROLE_ADMIN');

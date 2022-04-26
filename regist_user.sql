/*
 Navicat Premium Data Transfer

 Source Server         : kk
 Source Server Type    : MySQL
 Source Server Version : 50554
 Source Host           : localhost:3306
 Source Schema         : loginregist

 Target Server Type    : MySQL
 Target Server Version : 50554
 File Encoding         : 65001

 Date: 25/04/2022 23:04:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for regist_user
-- ----------------------------
DROP TABLE IF EXISTS `regist_user`;
CREATE TABLE `regist_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `email` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `sex` int(2) NOT NULL DEFAULT 0 COMMENT '性别1:男0:女',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 48 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;

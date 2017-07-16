/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : pchina

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2017-07-16 21:43:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `basic_article`
-- ----------------------------
DROP TABLE IF EXISTS `basic_article`;
CREATE TABLE `basic_article` (
  `BASIC_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增长ID',
  `BASIC_TITLE` varchar(300) DEFAULT NULL COMMENT '标题',
  `BASIC_DESCRIPTION` text COMMENT '描述',
  `BASIC_THUMBNAILS` varchar(1000) DEFAULT NULL COMMENT '缩略图',
  `BASIC_PHOTOS` varchar(1000) DEFAULT NULL,
  `BASIC_HIT` bigint(22) DEFAULT NULL COMMENT '点击次数',
  `BASIC_SORT` int(11) DEFAULT NULL COMMENT '排序',
  `BASIC_DATETIME` datetime DEFAULT NULL COMMENT ' 发布时间',
  `BASIC_UPDATETIME` datetime DEFAULT NULL COMMENT '更新时间',
  `BASIC_CATEGORYID` int(22) DEFAULT NULL COMMENT '所属分类编号',
  `BASIC_ATTRIBUTE` varchar(255) DEFAULT NULL COMMENT '属性',
  PRIMARY KEY (`BASIC_ID`),
  UNIQUE KEY `SYS_C009068` (`BASIC_ID`),
  KEY `BASIC_TITLE` (`BASIC_TITLE`(255)),
  KEY `BASIC_CATEGORYID` (`BASIC_CATEGORYID`) USING BTREE,
  KEY `BASIC_DATETIME` (`BASIC_DATETIME`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='基础表';

-- ----------------------------
-- Records of basic_article
-- ----------------------------

-- ----------------------------
-- Table structure for `basic_category`
-- ----------------------------
DROP TABLE IF EXISTS `basic_category`;
CREATE TABLE `basic_category` (
  `CATEGORY_ID` int(22) NOT NULL AUTO_INCREMENT COMMENT '类别ID',
  `CATEGORY_TITLE` varchar(50) DEFAULT NULL COMMENT '类别标题',
  `CATEGORY_SORT` int(10) DEFAULT NULL COMMENT '类别排序',
  `CATEGORY_CATEGORYID` int(22) DEFAULT NULL COMMENT '父类别编号',
  `CATEGORY_THUMBNAILS` varchar(120) DEFAULT NULL COMMENT '栏目略缩图',
  `CATEGORY_DESCRIPTION` varchar(45) DEFAULT NULL COMMENT '栏目描述',
  `CATEGORY_PARENT_ID` varchar(255) DEFAULT NULL COMMENT '父类型编号',
  `CATEGORY_CREATE_DATE` datetime DEFAULT NULL COMMENT '创建时间',
  `CATEGORY_UPDATE_DATE` datetime DEFAULT NULL COMMENT '更新时间',
  `CATEGORY_DEL` int(11) NOT NULL DEFAULT '0' COMMENT '删除状态',
  PRIMARY KEY (`CATEGORY_ID`),
  KEY `CATEGORY_CATEGORYID` (`CATEGORY_CATEGORYID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='分类表';

-- ----------------------------
-- Records of basic_category
-- ----------------------------

-- ----------------------------
-- Table structure for `cms_article`
-- ----------------------------
DROP TABLE IF EXISTS `cms_article`;
CREATE TABLE `cms_article` (
  `ARTICLE_BASICID` int(20) NOT NULL DEFAULT '0' COMMENT '文章ID',
  `ARTICLE_AUTHOR` varchar(20) DEFAULT NULL COMMENT '文章作者',
  `ARTICLE_CONTENT` longtext COMMENT '文章内容',
  `ARTICLE_PHOTOS` varchar(1000) DEFAULT NULL,
  `ARTICLE_TYPE` varchar(100) DEFAULT NULL COMMENT '文章类型',
  `ARTICLE_URL` varchar(200) DEFAULT NULL COMMENT '文章跳转链接地址',
  `ARTICLE_KEYWORD` varchar(300) DEFAULT NULL COMMENT '文章关键字',
  `ARTICLE_FREEORDER` int(255) DEFAULT NULL COMMENT '文章自定义显示顺序',
  PRIMARY KEY (`ARTICLE_BASICID`),
  UNIQUE KEY `ARTICLE_BASICID` (`ARTICLE_BASICID`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='文章表';

-- ----------------------------
-- Records of cms_article
-- ----------------------------

-- ----------------------------
-- Table structure for `cms_category`
-- ----------------------------
DROP TABLE IF EXISTS `cms_category`;
CREATE TABLE `cms_category` (
  `CMS_CATEGORYID` int(22) NOT NULL DEFAULT '0' COMMENT '关联basic_category表（类别表ID）',
  `CMS_KEYWORD` varchar(300) DEFAULT NULL COMMENT '栏目简介',
  `CMS_DESCRIP` varchar(500) DEFAULT NULL COMMENT '栏目关键字的扩展',
  `CMS_CONTENT` longtext COMMENT '封面内容',
  `CMS_TYPE` int(2) DEFAULT NULL COMMENT '1,代表最终列表栏目。2，代表频道封面。3，带表外部链接',
  `CMS_DISPLAY` int(2) DEFAULT NULL,
  `CMS_URL` varchar(50) DEFAULT NULL COMMENT '如果是外部链接，则保持外部链接地址。如果为最终列表栏目，就保存文章显示列表',
  `CMS_LISTURL` varchar(50) DEFAULT NULL COMMENT '最终列表栏目的列表模板地址',
  `CMS_PATH` varchar(150) DEFAULT NULL COMMENT '栏目路径',
  PRIMARY KEY (`CMS_CATEGORYID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='栏目表';

-- ----------------------------
-- Records of cms_category
-- ----------------------------

-- ----------------------------
-- Table structure for `pchina_admin`
-- ----------------------------
DROP TABLE IF EXISTS `pchina_admin`;
CREATE TABLE `pchina_admin` (
  `id` int(12) unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT '超级管理员主键',
  `username` varchar(16) NOT NULL COMMENT '超级管理员账号',
  `password` varchar(32) NOT NULL COMMENT '超级管理员密码',
  `create_time` date DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pchina_admin
-- ----------------------------
INSERT INTO `pchina_admin` VALUES ('000000000001', 'yang', 'e10adc3949ba59abbe56e057f20f883e', null);

-- ----------------------------
-- Table structure for `pchina_article`
-- ----------------------------
DROP TABLE IF EXISTS `pchina_article`;
CREATE TABLE `pchina_article` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `content` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pchina_article
-- ----------------------------
INSERT INTO `pchina_article` VALUES ('15', 'test1', 'test1', '2017-07-02 21:03:28');
INSERT INTO `pchina_article` VALUES ('16', 'test2', 'test2', '2017-07-02 21:04:02');
INSERT INTO `pchina_article` VALUES ('17', 'test3', 'test3', '2017-07-02 21:04:15');

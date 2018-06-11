/*
SQLyog Ultimate v8.32 
MySQL - 5.6.35-log : Database - library
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`library` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `library`;

/*Table structure for table `author` */

DROP TABLE IF EXISTS `author`;

CREATE TABLE `author` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL COMMENT '姓名',
  `birthday` date DEFAULT NULL COMMENT '生日(可以计算年龄)',
  `sex` enum('male','female') DEFAULT NULL COMMENT '性别(男，女)',
  `summary` varchar(1000) DEFAULT NULL COMMENT '人物简介(人物信息及主要作品等)',
  `create_at` datetime DEFAULT NULL,
  `update_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='作者';

/*Data for the table `author` */

/*Table structure for table `book` */

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL COMMENT '书籍名',
  `summary` varchar(500) DEFAULT NULL COMMENT '简介',
  `publisher_id` bigint(20) NOT NULL COMMENT '出版社id',
  `publish_time` datetime NOT NULL COMMENT '出版时间',
  `language` enum('en','zh') DEFAULT NULL COMMENT '语言(英文，中文)',
  `author_id` bigint(20) DEFAULT NULL COMMENT '作者',
  `price` float DEFAULT NULL COMMENT '单价',
  `clicks` int(11) DEFAULT NULL COMMENT '热度(点击数)',
  `score` float DEFAULT NULL COMMENT '评分(满分10)',
  `category_id` bigint(20) DEFAULT NULL COMMENT '分类',
  `create_at` datetime DEFAULT NULL,
  `update_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='书籍';

/*Data for the table `book` */

/*Table structure for table `category` */

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '分类名',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父类Id(顶级为0)',
  `path` varchar(255) DEFAULT NULL COMMENT '分类路径(0,xxxxxx)',
  `create_at` datetime DEFAULT NULL,
  `update_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `category` */

/*Table structure for table `publisher` */

DROP TABLE IF EXISTS `publisher`;

CREATE TABLE `publisher` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '出版社名称',
  `summary` varchar(1000) DEFAULT NULL COMMENT '简介',
  `establishment_time` datetime DEFAULT NULL COMMENT '成立时间',
  `create_at` datetime DEFAULT NULL,
  `update_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='出版社';

/*Data for the table `publisher` */

/*Table structure for table `qrtz_blob_triggers` */

DROP TABLE IF EXISTS `qrtz_blob_triggers`;

CREATE TABLE `qrtz_blob_triggers` (
  `sched_name` varchar(120) NOT NULL,
  `trigger_name` varchar(80) NOT NULL,
  `trigger_group` varchar(80) NOT NULL,
  `blob_data` blob,
  PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`),
  CONSTRAINT `qrtz_blob_triggers_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `qrtz_triggers` (`sched_name`, `trigger_name`, `trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `qrtz_blob_triggers` */

/*Table structure for table `qrtz_calendars` */

DROP TABLE IF EXISTS `qrtz_calendars`;

CREATE TABLE `qrtz_calendars` (
  `sched_name` varchar(120) NOT NULL,
  `calendar_name` varchar(80) NOT NULL,
  `calendar` blob NOT NULL,
  PRIMARY KEY (`calendar_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `qrtz_calendars` */

/*Table structure for table `qrtz_cron_triggers` */

DROP TABLE IF EXISTS `qrtz_cron_triggers`;

CREATE TABLE `qrtz_cron_triggers` (
  `sched_name` varchar(120) NOT NULL,
  `trigger_name` varchar(80) NOT NULL,
  `trigger_group` varchar(80) NOT NULL,
  `cron_expression` varchar(120) NOT NULL,
  `time_zone_id` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`),
  CONSTRAINT `qrtz_cron_triggers_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `qrtz_triggers` (`sched_name`, `trigger_name`, `trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `qrtz_cron_triggers` */

insert  into `qrtz_cron_triggers`(`sched_name`,`trigger_name`,`trigger_group`,`cron_expression`,`time_zone_id`) values ('quartzScheduler','trigger_job','dufy_trigger','0/2 * * * * ?','Asia/Shanghai');

/*Table structure for table `qrtz_fired_triggers` */

DROP TABLE IF EXISTS `qrtz_fired_triggers`;

CREATE TABLE `qrtz_fired_triggers` (
  `sched_name` varchar(120) NOT NULL,
  `entry_id` varchar(95) NOT NULL,
  `trigger_name` varchar(80) NOT NULL,
  `trigger_group` varchar(80) NOT NULL,
  `instance_name` varchar(80) NOT NULL,
  `fired_time` bigint(20) NOT NULL,
  `sched_time` bigint(20) NOT NULL,
  `priority` int(11) NOT NULL,
  `state` varchar(16) NOT NULL,
  `job_name` varchar(80) DEFAULT NULL,
  `job_group` varchar(80) DEFAULT NULL,
  `is_nonconcurrent` int(11) DEFAULT NULL,
  `requests_recovery` int(11) DEFAULT NULL,
  PRIMARY KEY (`sched_name`,`entry_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `qrtz_fired_triggers` */

/*Table structure for table `qrtz_job_details` */

DROP TABLE IF EXISTS `qrtz_job_details`;

CREATE TABLE `qrtz_job_details` (
  `sched_name` varchar(120) NOT NULL,
  `job_name` varchar(80) NOT NULL,
  `job_group` varchar(80) NOT NULL,
  `description` varchar(120) DEFAULT NULL,
  `job_class_name` varchar(128) NOT NULL,
  `is_durable` int(11) NOT NULL,
  `is_nonconcurrent` int(11) NOT NULL,
  `is_update_data` int(11) NOT NULL,
  `requests_recovery` int(11) NOT NULL,
  `job_data` blob,
  PRIMARY KEY (`sched_name`,`job_name`,`job_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `qrtz_job_details` */

insert  into `qrtz_job_details`(`sched_name`,`job_name`,`job_group`,`description`,`job_class_name`,`is_durable`,`is_nonconcurrent`,`is_update_data`,`requests_recovery`,`job_data`) values ('quartzScheduler','dufy','dufy_job',NULL,'net.ssm.quartz.web.job.demojob',0,0,0,0,'#\r\n#Thu Jan 25 00:43:18 CST 2018\r\n');

/*Table structure for table `qrtz_locks` */

DROP TABLE IF EXISTS `qrtz_locks`;

CREATE TABLE `qrtz_locks` (
  `sched_name` varchar(120) NOT NULL,
  `lock_name` varchar(40) NOT NULL,
  PRIMARY KEY (`sched_name`,`lock_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `qrtz_locks` */

insert  into `qrtz_locks`(`sched_name`,`lock_name`) values ('dufy_test','TRIGGER_ACCESS'),('quartzScheduler','TRIGGER_ACCESS'),('scheduler','TRIGGER_ACCESS');

/*Table structure for table `qrtz_paused_trigger_grps` */

DROP TABLE IF EXISTS `qrtz_paused_trigger_grps`;

CREATE TABLE `qrtz_paused_trigger_grps` (
  `sched_name` varchar(120) NOT NULL,
  `trigger_group` varchar(80) NOT NULL,
  PRIMARY KEY (`sched_name`,`trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `qrtz_paused_trigger_grps` */

/*Table structure for table `qrtz_scheduler_state` */

DROP TABLE IF EXISTS `qrtz_scheduler_state`;

CREATE TABLE `qrtz_scheduler_state` (
  `sched_name` varchar(120) NOT NULL,
  `instance_name` varchar(80) NOT NULL,
  `last_checkin_time` bigint(20) NOT NULL,
  `checkin_interval` bigint(20) NOT NULL,
  PRIMARY KEY (`sched_name`,`instance_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `qrtz_scheduler_state` */

/*Table structure for table `qrtz_simple_triggers` */

DROP TABLE IF EXISTS `qrtz_simple_triggers`;

CREATE TABLE `qrtz_simple_triggers` (
  `sched_name` varchar(120) NOT NULL,
  `trigger_name` varchar(80) NOT NULL,
  `trigger_group` varchar(80) NOT NULL,
  `repeat_count` bigint(20) NOT NULL,
  `repeat_interval` bigint(20) NOT NULL,
  `times_triggered` bigint(20) NOT NULL,
  PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`),
  CONSTRAINT `qrtz_simple_triggers_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `qrtz_triggers` (`sched_name`, `trigger_name`, `trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `qrtz_simple_triggers` */

/*Table structure for table `qrtz_simprop_triggers` */

DROP TABLE IF EXISTS `qrtz_simprop_triggers`;

CREATE TABLE `qrtz_simprop_triggers` (
  `sched_name` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `STR_PROP_1` varchar(512) DEFAULT NULL,
  `STR_PROP_2` varchar(512) DEFAULT NULL,
  `STR_PROP_3` varchar(512) DEFAULT NULL,
  `INT_PROP_1` int(11) DEFAULT NULL,
  `INT_PROP_2` int(11) DEFAULT NULL,
  `LONG_PROP_1` bigint(20) DEFAULT NULL,
  `LONG_PROP_2` bigint(20) DEFAULT NULL,
  `DEC_PROP_1` decimal(13,4) DEFAULT NULL,
  `DEC_PROP_2` decimal(13,4) DEFAULT NULL,
  `BOOL_PROP_1` varchar(1) DEFAULT NULL,
  `BOOL_PROP_2` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`sched_name`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_simprop_triggers_ibfk_1` FOREIGN KEY (`sched_name`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`sched_name`, `trigger_name`, `trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `qrtz_simprop_triggers` */

/*Table structure for table `qrtz_triggers` */

DROP TABLE IF EXISTS `qrtz_triggers`;

CREATE TABLE `qrtz_triggers` (
  `sched_name` varchar(120) NOT NULL,
  `trigger_name` varchar(80) NOT NULL,
  `trigger_group` varchar(80) NOT NULL,
  `job_name` varchar(80) NOT NULL,
  `job_group` varchar(80) NOT NULL,
  `description` varchar(120) DEFAULT NULL,
  `next_fire_time` bigint(20) DEFAULT NULL,
  `prev_fire_time` bigint(20) DEFAULT NULL,
  `priority` int(11) DEFAULT NULL,
  `trigger_state` varchar(16) NOT NULL,
  `trigger_type` varchar(8) NOT NULL,
  `start_time` bigint(20) NOT NULL,
  `end_time` bigint(20) DEFAULT NULL,
  `calendar_name` varchar(80) DEFAULT NULL,
  `misfire_instr` smallint(6) DEFAULT NULL,
  `job_data` blob,
  PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`),
  KEY `sched_name` (`sched_name`,`job_name`,`job_group`),
  CONSTRAINT `qrtz_triggers_ibfk_1` FOREIGN KEY (`sched_name`, `job_name`, `job_group`) REFERENCES `qrtz_job_details` (`sched_name`, `job_name`, `job_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `qrtz_triggers` */

insert  into `qrtz_triggers`(`sched_name`,`trigger_name`,`trigger_group`,`job_name`,`job_group`,`description`,`next_fire_time`,`prev_fire_time`,`priority`,`trigger_state`,`trigger_type`,`start_time`,`end_time`,`calendar_name`,`misfire_instr`,`job_data`) values ('quartzScheduler','trigger_job','dufy_trigger','dufy','dufy_job',NULL,1521360474000,1521360472000,5,'PAUSED','CRON',1516812198000,0,NULL,0,'');

/*Table structure for table `sys_menu` */

DROP TABLE IF EXISTS `sys_menu`;

CREATE TABLE `sys_menu` (
  `id` bigint(12) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `parent_id` bigint(12) DEFAULT NULL COMMENT '父级编号',
  `type` enum('menu','page','action') NOT NULL COMMENT '类型一级菜单，页面，功能按钮',
  `name` varchar(255) NOT NULL COMMENT '菜单名称',
  `href` varchar(255) DEFAULT NULL COMMENT '链接',
  `target` varchar(20) DEFAULT NULL COMMENT '目标',
  `icon` varchar(255) DEFAULT NULL COMMENT '图标',
  `sort` int(11) DEFAULT NULL COMMENT '排序（升序）',
  `status` enum('disabled','enable') NOT NULL COMMENT '状态',
  `permission` varchar(255) DEFAULT NULL COMMENT '权限标识',
  `create_at` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_at` datetime DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`),
  KEY `sys_menu_parent_id` (`parent_id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8 COMMENT='菜单表';

/*Data for the table `sys_menu` */

insert  into `sys_menu`(`id`,`parent_id`,`type`,`name`,`href`,`target`,`icon`,`sort`,`status`,`permission`,`create_at`,`update_at`,`remarks`) values (1,27,'menu','系统用户列表','/admin/userlist.html','宿舍','&#xe613;',1,'enable',NULL,'2017-10-26 23:04:32',NULL,'管理用户的一些菜单'),(2,0,'menu','系统配置','#',NULL,'&#xe631;',NULL,'enable',NULL,NULL,NULL,''),(3,2,'page','菜单管理','/menu/menulist',NULL,'&#xe64c;',NULL,'enable',NULL,NULL,NULL,'配置系统的菜单'),(4,2,'page','角色管理','/role/rolelist',NULL,'&#xe64c;',NULL,'enable',NULL,NULL,NULL,'角色列表'),(5,2,'page','角色权限','/menu/roleMenu',NULL,'&#xe64c;',NULL,'disabled',NULL,NULL,NULL,'角色对应的权限'),(21,3,'page','新增/编辑菜单页面','/menu/addMenu',NULL,NULL,NULL,'enable',NULL,'2017-11-19 21:47:03',NULL,''),(22,3,'action','保存菜单','/menu/addSysMenu',NULL,NULL,NULL,'enable',NULL,'2017-11-19 21:48:05',NULL,''),(23,1,'page','设置用户角色页面','/userRole/setUserRole',NULL,NULL,NULL,'enable',NULL,'2017-11-19 21:50:44',NULL,''),(24,1,'action','保存用户角色','/userRole/doSetUserRole',NULL,NULL,NULL,'enable',NULL,'2017-11-19 21:51:46',NULL,''),(25,4,'page','设置角色菜单页面','/roleMenu/setRoleMenu',NULL,NULL,NULL,'enable',NULL,'2017-11-19 22:16:31',NULL,''),(26,4,'action','保存角色菜单','/roleMenu/doSetRoleMenu',NULL,NULL,NULL,'enable',NULL,'2017-11-19 22:17:20',NULL,''),(27,0,'menu','用户管理','#',NULL,NULL,NULL,'enable',NULL,'2017-11-20 13:56:33',NULL,''),(28,1,'page','添加/编辑用户页面','/admin/addUser',NULL,NULL,NULL,'enable',NULL,'2017-12-03 21:59:46',NULL,''),(29,1,'action','保存用户','/admin/addAdminUser',NULL,NULL,NULL,'enable',NULL,'2017-12-04 23:16:52',NULL,''),(30,4,'page','添加/编辑角色','/role/addRole',NULL,NULL,NULL,'enable',NULL,'2017-12-07 22:42:17',NULL,''),(31,4,'action','保存角色','/role/addSysRole',NULL,NULL,NULL,'enable',NULL,'2017-12-07 22:58:49',NULL,''),(32,0,'menu','任务作业','#',NULL,NULL,NULL,'enable',NULL,'2018-01-23 22:46:32',NULL,''),(33,32,'page','作业列表','/quartz/listJob',NULL,NULL,NULL,'enable',NULL,'2018-01-23 22:47:23',NULL,'');

/*Table structure for table `sys_role` */

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `id` bigint(12) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(100) NOT NULL COMMENT '角色名称',
  `create_by` varchar(64) NOT NULL DEFAULT '' COMMENT '创建者',
  `create_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `update_at` datetime DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='角色表';

/*Data for the table `sys_role` */

insert  into `sys_role`(`id`,`name`,`create_by`,`create_at`,`update_by`,`update_at`,`remarks`) values (1,'主任','静态','2017-11-12 21:59:54',NULL,NULL,'宿舍'),(2,'老师','静态','2017-11-18 22:01:56',NULL,NULL,NULL),(3,'辅导员','夏晨曦','2017-12-07 23:16:57',NULL,NULL,'恩恩');

/*Table structure for table `sys_role_menu` */

DROP TABLE IF EXISTS `sys_role_menu`;

CREATE TABLE `sys_role_menu` (
  `id` bigint(12) NOT NULL AUTO_INCREMENT,
  `sys_role_id` bigint(12) NOT NULL COMMENT '角色编号',
  `sys_menu_id` bigint(12) NOT NULL COMMENT '菜单编号',
  PRIMARY KEY (`id`,`sys_role_id`,`sys_menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=471 DEFAULT CHARSET=utf8 COMMENT='角色-菜单';

/*Data for the table `sys_role_menu` */

insert  into `sys_role_menu`(`id`,`sys_role_id`,`sys_menu_id`) values (445,2,2),(446,2,3),(447,2,21),(448,2,22),(449,2,4),(450,2,25),(451,2,26),(452,2,30),(453,2,31),(454,2,27),(455,2,1),(456,2,23),(457,1,2),(458,1,3),(459,1,21),(460,1,22),(461,1,4),(462,1,25),(463,1,27),(464,1,1),(465,1,23),(466,1,24),(467,1,28),(468,1,29),(469,1,32),(470,1,33);

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `id` bigint(12) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `login_name` varchar(20) NOT NULL DEFAULT '' COMMENT '登录名',
  `password` varchar(255) NOT NULL DEFAULT '' COMMENT '密码',
  `name` varchar(100) NOT NULL DEFAULT '' COMMENT '姓名',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `mobile` bigint(20) DEFAULT NULL COMMENT '手机',
  `status` enum('disabled','enable') DEFAULT NULL COMMENT '状态',
  `login_ip` varchar(20) DEFAULT NULL COMMENT '最后登陆IP',
  `login_time` datetime DEFAULT NULL COMMENT '最后登陆时间',
  `login_times` int(11) DEFAULT '0' COMMENT '登录次数',
  `avatars` varchar(255) DEFAULT NULL COMMENT '头像URL',
  `create_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_at` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`),
  UNIQUE KEY `sys_user_login_name` (`login_name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='用户表';

/*Data for the table `sys_user` */

insert  into `sys_user`(`id`,`login_name`,`password`,`name`,`email`,`mobile`,`status`,`login_ip`,`login_time`,`login_times`,`avatars`,`create_at`,`update_at`,`remarks`) values (1,'静态','123456','','13421342@qq.com',15201874563,NULL,NULL,NULL,6,NULL,'2017-08-24 22:08:02','2018-04-27 11:20:42',''),(2,'蓉虾','2132131','sss','25f4g5d452@qq.com',211545,'enable',NULL,NULL,0,NULL,'2017-08-24 22:08:02','2017-08-26 22:00:34',NULL),(3,'夏晨曦','123456','','555@qq.com',15201588523,'enable',NULL,NULL,0,NULL,'2017-12-04 23:17:22','2017-12-09 21:28:01',''),(4,'yalunwang','123456','亚伦王','yalunwang12@163.com',15201253632,'enable',NULL,NULL,0,NULL,'2017-12-08 21:20:11',NULL,'');

/*Table structure for table `sys_user_role` */

DROP TABLE IF EXISTS `sys_user_role`;

CREATE TABLE `sys_user_role` (
  `id` bigint(12) NOT NULL AUTO_INCREMENT,
  `sys_user_id` bigint(12) NOT NULL COMMENT '用户编号',
  `sys_role_id` bigint(12) NOT NULL COMMENT '角色编号',
  PRIMARY KEY (`id`,`sys_user_id`,`sys_role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8 COMMENT='用户-角色';

/*Data for the table `sys_user_role` */

insert  into `sys_user_role`(`id`,`sys_user_id`,`sys_role_id`) values (49,2,1),(50,2,2),(51,2,3),(52,1,2),(53,1,3),(54,4,1),(55,3,1),(56,3,2),(57,3,3);

/*Table structure for table `user_t` */

DROP TABLE IF EXISTS `user_t`;

CREATE TABLE `user_t` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(40) NOT NULL,
  `password` varchar(255) NOT NULL,
  `age` int(4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user_t` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

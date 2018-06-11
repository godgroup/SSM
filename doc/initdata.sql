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

/*Data for the table `author` */

/*Data for the table `book` */

/*Data for the table `category` */

/*Data for the table `publisher` */

/*Data for the table `qrtz_blob_triggers` */

/*Data for the table `qrtz_calendars` */

/*Data for the table `qrtz_cron_triggers` */

insert  into `qrtz_cron_triggers`(`sched_name`,`trigger_name`,`trigger_group`,`cron_expression`,`time_zone_id`) values ('quartzScheduler','trigger_job','dufy_trigger','0/2 * * * * ?','Asia/Shanghai');

/*Data for the table `qrtz_fired_triggers` */

/*Data for the table `qrtz_job_details` */

insert  into `qrtz_job_details`(`sched_name`,`job_name`,`job_group`,`description`,`job_class_name`,`is_durable`,`is_nonconcurrent`,`is_update_data`,`requests_recovery`,`job_data`) values ('quartzScheduler','dufy','dufy_job',NULL,'net.ssm.quartz.web.job.demojob',0,0,0,0,'#\r\n#Thu Jan 25 00:43:18 CST 2018\r\n');

/*Data for the table `qrtz_locks` */

insert  into `qrtz_locks`(`sched_name`,`lock_name`) values ('dufy_test','TRIGGER_ACCESS'),('quartzScheduler','TRIGGER_ACCESS'),('scheduler','TRIGGER_ACCESS');

/*Data for the table `qrtz_paused_trigger_grps` */

/*Data for the table `qrtz_scheduler_state` */

/*Data for the table `qrtz_simple_triggers` */

/*Data for the table `qrtz_simprop_triggers` */

/*Data for the table `qrtz_triggers` */

insert  into `qrtz_triggers`(`sched_name`,`trigger_name`,`trigger_group`,`job_name`,`job_group`,`description`,`next_fire_time`,`prev_fire_time`,`priority`,`trigger_state`,`trigger_type`,`start_time`,`end_time`,`calendar_name`,`misfire_instr`,`job_data`) values ('quartzScheduler','trigger_job','dufy_trigger','dufy','dufy_job',NULL,1521360474000,1521360472000,5,'PAUSED','CRON',1516812198000,0,NULL,0,'');

/*Data for the table `sys_menu` */

insert  into `sys_menu`(`id`,`parent_id`,`type`,`name`,`href`,`target`,`icon`,`sort`,`status`,`permission`,`create_at`,`update_at`,`remarks`) values (1,27,'menu','系统用户列表','/admin/userlist.html','宿舍','&#xe613;',1,'enable',NULL,'2017-10-26 23:04:32',NULL,'管理用户的一些菜单'),(2,0,'menu','系统配置','#',NULL,'&#xe631;',NULL,'enable',NULL,NULL,NULL,''),(3,2,'page','菜单管理','/menu/menulist',NULL,'&#xe64c;',NULL,'enable',NULL,NULL,NULL,'配置系统的菜单'),(4,2,'page','角色管理','/role/rolelist',NULL,'&#xe64c;',NULL,'enable',NULL,NULL,NULL,'角色列表'),(5,2,'page','角色权限','/menu/roleMenu',NULL,'&#xe64c;',NULL,'disabled',NULL,NULL,NULL,'角色对应的权限'),(21,3,'page','新增/编辑菜单页面','/menu/addMenu',NULL,NULL,NULL,'enable',NULL,'2017-11-19 21:47:03',NULL,''),(22,3,'action','保存菜单','/menu/addSysMenu',NULL,NULL,NULL,'enable',NULL,'2017-11-19 21:48:05',NULL,''),(23,1,'page','设置用户角色页面','/userRole/setUserRole',NULL,NULL,NULL,'enable',NULL,'2017-11-19 21:50:44',NULL,''),(24,1,'action','保存用户角色','/userRole/doSetUserRole',NULL,NULL,NULL,'enable',NULL,'2017-11-19 21:51:46',NULL,''),(25,4,'page','设置角色菜单页面','/roleMenu/setRoleMenu',NULL,NULL,NULL,'enable',NULL,'2017-11-19 22:16:31',NULL,''),(26,4,'action','保存角色菜单','/roleMenu/doSetRoleMenu',NULL,NULL,NULL,'enable',NULL,'2017-11-19 22:17:20',NULL,''),(27,0,'menu','用户管理','#',NULL,NULL,NULL,'enable',NULL,'2017-11-20 13:56:33',NULL,''),(28,1,'page','添加/编辑用户页面','/admin/addUser',NULL,NULL,NULL,'enable',NULL,'2017-12-03 21:59:46',NULL,''),(29,1,'action','保存用户','/admin/addAdminUser',NULL,NULL,NULL,'enable',NULL,'2017-12-04 23:16:52',NULL,''),(30,4,'page','添加/编辑角色','/role/addRole',NULL,NULL,NULL,'enable',NULL,'2017-12-07 22:42:17',NULL,''),(31,4,'action','保存角色','/role/addSysRole',NULL,NULL,NULL,'enable',NULL,'2017-12-07 22:58:49',NULL,''),(32,0,'menu','任务作业','#',NULL,NULL,NULL,'enable',NULL,'2018-01-23 22:46:32',NULL,''),(33,32,'page','作业列表','/quartz/listJob',NULL,NULL,NULL,'enable',NULL,'2018-01-23 22:47:23',NULL,'');

/*Data for the table `sys_role` */

insert  into `sys_role`(`id`,`name`,`create_by`,`create_at`,`update_by`,`update_at`,`remarks`) values (1,'主任','静态','2017-11-12 21:59:54',NULL,NULL,'宿舍'),(2,'老师','静态','2017-11-18 22:01:56',NULL,NULL,NULL),(3,'辅导员','夏晨曦','2017-12-07 23:16:57',NULL,NULL,'恩恩');

/*Data for the table `sys_role_menu` */

insert  into `sys_role_menu`(`id`,`sys_role_id`,`sys_menu_id`) values (445,2,2),(446,2,3),(447,2,21),(448,2,22),(449,2,4),(450,2,25),(451,2,26),(452,2,30),(453,2,31),(454,2,27),(455,2,1),(456,2,23),(457,1,2),(458,1,3),(459,1,21),(460,1,22),(461,1,4),(462,1,25),(463,1,27),(464,1,1),(465,1,23),(466,1,24),(467,1,28),(468,1,29),(469,1,32),(470,1,33);

/*Data for the table `sys_user` */

insert  into `sys_user`(`id`,`login_name`,`password`,`name`,`email`,`mobile`,`status`,`login_ip`,`login_time`,`login_times`,`avatars`,`create_at`,`update_at`,`remarks`) values (1,'静态','123456','','13421342@qq.com',15201874563,NULL,NULL,NULL,6,NULL,'2017-08-24 22:08:02','2018-04-27 11:20:42',''),(2,'蓉虾','2132131','sss','25f4g5d452@qq.com',211545,'enable',NULL,NULL,0,NULL,'2017-08-24 22:08:02','2017-08-26 22:00:34',NULL),(3,'夏晨曦','123456','','555@qq.com',15201588523,'enable',NULL,NULL,0,NULL,'2017-12-04 23:17:22','2017-12-09 21:28:01',''),(4,'yalunwang','123456','亚伦王','yalunwang12@163.com',15201253632,'enable',NULL,NULL,0,NULL,'2017-12-08 21:20:11',NULL,'');

/*Data for the table `sys_user_role` */

insert  into `sys_user_role`(`id`,`sys_user_id`,`sys_role_id`) values (49,2,1),(50,2,2),(51,2,3),(52,1,2),(53,1,3),(54,4,1),(55,3,1),(56,3,2),(57,3,3);

/*Data for the table `user_t` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

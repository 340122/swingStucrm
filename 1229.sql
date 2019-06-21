/*
SQLyog Ultimate v11.3 (64 bit)
MySQL - 5.5.28 : Database - all
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`all` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `all`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `id` int(5) NOT NULL,
  `adminName` varchar(10) NOT NULL,
  `adminPassword` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `admin` */

insert  into `admin`(`id`,`adminName`,`adminPassword`) values (1,'admin','root');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uname` varchar(30) DEFAULT NULL,
  `upassword` varchar(30) DEFAULT NULL,
  `sclass` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=111 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`uname`,`upassword`,`sclass`) values (2,'dakai','123456','软件1班'),(6,'wangwu','12345655555','软件1班'),(7,'123','123','软件1班'),(8,'123','','软件2班'),(9,'123','123','软件1班'),(10,'123','',''),(11,'123','','软件1班'),(12,'abc','',''),(13,'','345','软件1班'),(14,'34','345',''),(15,'','',''),(16,'123','1234',''),(17,'12345','123457','软件1班'),(18,'1253','214','软件1班'),(19,'12345','1231',''),(20,'','123',''),(21,'','',''),(22,'1234','123','软件1班'),(23,'1234','1234','软件1班'),(24,'1234','','软件1班'),(25,'123','123','软件1班'),(26,'123','123','软件1班'),(27,'123','123','软件1班'),(28,'1234','1234','软件1班'),(29,'1234','12345','软件1班'),(30,'1234','12','软件1班'),(31,'1234','124','软件1班'),(32,'1234','1','软件1班'),(33,'1234','4','软件1班'),(34,'134','12',''),(35,'134','12',''),(36,'1234','123',''),(37,'123','123',''),(38,'123','123','软件1班'),(39,'123','123',''),(40,'123','123',''),(41,'123','123',''),(42,'1234','123',''),(43,'1234','1234','软件1班'),(44,'123','123','软件1班'),(52,'yaolei','123456','软件1班'),(53,'阿萨','111','软件1班'),(54,'123','12','软件1班'),(55,'12','12','软件1班'),(110,'yaolei','123','软件1班');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

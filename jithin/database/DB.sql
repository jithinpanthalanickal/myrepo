/*
SQLyog Community v12.4.1 (64 bit)
MySQL - 5.7.18-log : Database - questionnaire
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`questionnaire` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `questionnaire`;

/*Table structure for table `questions` */

DROP TABLE IF EXISTS `questions`;

CREATE TABLE `questions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `question_number` int(11) DEFAULT NULL,
  `question_text` varchar(1000) DEFAULT NULL,
  `archive` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `questions` */

insert  into `questions`(`id`,`question_number`,`question_text`,`archive`) values 
(1,1,'What is SDN ?',0),
(2,2,'What is DHCP ? ',0),
(3,3,'What is DNS ?',0);

/*Table structure for table `session` */

DROP TABLE IF EXISTS `session`;

CREATE TABLE `session` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `timestamp` bigint(20) DEFAULT NULL,
  `end` bigint(20) DEFAULT NULL,
  `ip_address` varchar(20) DEFAULT NULL,
  `browser` varchar(200) DEFAULT NULL,
  `platform` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `EAAE5B66` (`user_id`),
  CONSTRAINT `EAAE5B66` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `session` */

/*Table structure for table `submission` */

DROP TABLE IF EXISTS `submission`;

CREATE TABLE `submission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` text,
  `question_number` text,
  `answer` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*Data for the table `submission` */

insert  into `submission`(`id`,`username`,`question_number`,`answer`) values 
(1,'weblogic','1','Software Defined Network'),
(2,'weblogic','2','Dynamic Host Control Protocol'),
(3,'weblogic','3','Domain Name Server'),
(4,'weblogic','1','fre'),
(5,'weblogic','2','fere'),
(6,'weblogic','3','dwdws'),
(7,'ponnu','1','Software Defined Network'),
(8,'ponnu','2','Dynamic Host Control Protocol'),
(9,'ponnu','3','Domain Name Server'),
(10,'jibin','1','Software Defined Network'),
(11,'jibin','2','Dynamic Host Control Protocol'),
(12,'jibin','3','Domain Name Server'),
(13,'java','1','Software Defined Network'),
(14,'java','2','Dynamic Host Control Protocol'),
(15,'java','3','Domain Name Server');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `f_name` varchar(50) DEFAULT NULL,
  `l_name` varchar(50) DEFAULT NULL,
  `archive` int(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=latin1;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`,`f_name`,`l_name`,`archive`) values 
(1,'mukk','mukk','Mukesh','Nambiar',0),
(19,'weblogic','111222','Mukesh','Nambiar',1),
(26,'mukeshm','mukz','mukz','Nambiar',0),
(27,'ponnu','p1','ponnu','saju',1),
(28,'nnn','ns1','nnn','nsi',0),
(29,'jibin','hi','jibin','A',1),
(30,'java','111','java','java',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

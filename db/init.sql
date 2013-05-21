-- MySQL dump 10.13  Distrib 5.6.10, for Win32 (x86)
--
-- Host: localhost    Database: demo
-- ------------------------------------------------------
-- Server version	5.6.10

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `code_eq_status`
--

DROP TABLE IF EXISTS `code_eq_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `code_eq_status` (
  `CODE` varchar(4) NOT NULL,
  `NAME` varchar(32) NOT NULL,
  `DESC` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `code_eq_status`
--

LOCK TABLES `code_eq_status` WRITE;
/*!40000 ALTER TABLE `code_eq_status` DISABLE KEYS */;
INSERT INTO `code_eq_status` VALUES ('01','正常',NULL),('02','失效',NULL);
/*!40000 ALTER TABLE `code_eq_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `code_eq_type`
--

DROP TABLE IF EXISTS `code_eq_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `code_eq_type` (
  `CODE` varchar(4) NOT NULL,
  `NAME` varchar(64) NOT NULL,
  `DESC` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `code_eq_type`
--

LOCK TABLES `code_eq_type` WRITE;
/*!40000 ALTER TABLE `code_eq_type` DISABLE KEYS */;
INSERT INTO `code_eq_type` VALUES ('01','飞行器',NULL),('02','舰艇',NULL),('03','导弹',NULL);
/*!40000 ALTER TABLE `code_eq_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipment`
--

DROP TABLE IF EXISTS `equipment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equipment` (
  `EQ_SEQ` int(11) NOT NULL AUTO_INCREMENT,
  `EQ_ID` varchar(64) DEFAULT NULL,
  `MODEL` varchar(32) DEFAULT NULL,
  `TYPE` varchar(4) DEFAULT NULL,
  `QUANTITY` int(11) DEFAULT NULL,
  `WEIGHT` varchar(32) DEFAULT NULL,
  `STATUS` varchar(32) DEFAULT NULL,
  `PERSON_RESP` varchar(32) DEFAULT NULL,
  `DATE_MODIFIED` date DEFAULT NULL,
  `PERSON_MODIFIED` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`EQ_SEQ`),
  UNIQUE KEY `MODEL` (`MODEL`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipment`
--

LOCK TABLES `equipment` WRITE;
/*!40000 ALTER TABLE `equipment` DISABLE KEYS */;
INSERT INTO `equipment` VALUES (1,'001','XAPX-0098','01',10,'100','01','管理员一号',NULL,NULL),(3,'001','XAPX-0099','01',10,'100','01','管理员二号',NULL,NULL),(4,'102','HASD-981248','02',10,'9999','01','管理员一号',NULL,NULL),(5,'3123','YIUN-9872394','03',1000,'88888','01','管理员一号',NULL,NULL),(7,'3123','ASDF-1283','03',10,'88','02','管理员二号',NULL,NULL),(9,'333','LASJD-123123','01',11,'88888','02','管理员二号',NULL,NULL);
/*!40000 ALTER TABLE `equipment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_log`
--

DROP TABLE IF EXISTS `sys_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_log` (
  `USER_ID` int(11) NOT NULL,
  `USER_IP` varchar(100) DEFAULT NULL,
  `ACTION_TYPE` int(11) DEFAULT NULL,
  `ACTION_VALUE` varchar(500) DEFAULT NULL,
  `ACTION_TIME` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_log`
--

LOCK TABLES `sys_log` WRITE;
/*!40000 ALTER TABLE `sys_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role`
--

DROP TABLE IF EXISTS `sys_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role` (
  `ROLE_ID` int(11) NOT NULL,
  `ROLE_NAME` varchar(20) DEFAULT NULL,
  `DESC` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ROLE_ID`),
  UNIQUE KEY `ROLE_NAME` (`ROLE_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role`
--

LOCK TABLES `sys_role` WRITE;
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user`
--

DROP TABLE IF EXISTS `sys_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user` (
  `USER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(20) DEFAULT NULL,
  `PASSWORD` varchar(50) DEFAULT NULL,
  `ENABLED` char(1) DEFAULT '1',
  PRIMARY KEY (`USER_ID`),
  UNIQUE KEY `USERNAME` (`USERNAME`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user`
--

LOCK TABLES `sys_user` WRITE;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` VALUES (1,'test','*23AE809DDACAF96AF0FD78ED04B6A265E05AA257','1'),(2,'roo','*23AE809DDACAF96AF0FD78ED04B6A265E05AA257','1'),(3,'root','*CCB4F88E945E0E14F9BEB093EB797BB0BDBFA175','1'),(4,'admin','*4ACFE3202A5FF5CF467898FC58AAB1D615029441','1'),(5,'测试','*CCB4F88E945E0E14F9BEB093EB797BB0BDBFA175','1');
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_userrole`
--

DROP TABLE IF EXISTS `sys_userrole`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_userrole` (
  `USER_ID` int(11) NOT NULL,
  `ROLE_ID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_userrole`
--

LOCK TABLES `sys_userrole` WRITE;
/*!40000 ALTER TABLE `sys_userrole` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_userrole` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-03-22 16:43:14

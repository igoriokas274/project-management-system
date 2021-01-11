-- MariaDB dump 10.18  Distrib 10.5.8-MariaDB, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: managerpro
-- ------------------------------------------------------
-- Server version	10.5.8-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping data for table `contact`
--

LOCK TABLES `contact` WRITE;
/*!40000 ALTER TABLE `contact` DISABLE KEYS */;
/*!40000 ALTER TABLE `contact` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `country`
--

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` VALUES (1,'user','2021-01-10 15:44:17','user','2021-01-10 15:44:17','LT','Lithuania',0),(2,'user','2021-01-10 15:44:32','user','2021-01-10 15:44:32','LV','Latvia',0),(3,'user','2021-01-10 15:44:41','user','2021-01-10 15:44:41','EE','Estonia',0),(4,'user','2021-01-10 15:44:49','user','2021-01-10 15:44:49','PL','Poland',0),(5,'user','2021-01-10 15:45:33','user','2021-01-10 15:45:33','RU','Russian Federation',0),(6,'user','2021-01-10 15:45:47','user','2021-01-10 15:45:47','DE','Germany',0);
/*!40000 ALTER TABLE `country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `currency`
--

LOCK TABLES `currency` WRITE;
/*!40000 ALTER TABLE `currency` DISABLE KEYS */;
INSERT INTO `currency` VALUES (1,'user','2021-01-10 15:46:01','user','2021-01-10 15:46:01','EUR','Euro',0),(2,'user','2021-01-10 15:46:38','user','2021-01-10 15:46:38','PLN','Zloty',0),(3,'user','2021-01-10 15:47:16','user','2021-01-10 15:47:16','RUB','Russian Ruble',0),(4,'user','2021-01-10 15:47:47','user','2021-01-10 15:47:56','USD','US Dollar',0),(5,'user','2021-01-10 15:48:38','user','2021-01-10 15:48:38','GBP','Pound Sterling',0);
/*!40000 ALTER TABLE `currency` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (1,'user','2021-01-10 15:48:58','user','2021-01-10 15:48:58','Administration',0),(2,'user','2021-01-10 15:49:31','user','2021-01-10 15:49:31','Financial dept.',0),(3,'user','2021-01-10 15:49:39','user','2021-01-10 15:49:39','Sales dept.',0),(4,'user','2021-01-10 15:49:53','user','2021-01-10 15:49:53','Production dept.',0),(5,'user','2021-01-10 15:50:06','user','2021-01-10 15:50:06','HR',0);
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'admin','2021-01-10 16:18:08','admin','2021-01-10 16:18:08','','','','','','','1977-11-15','2018-02-01','John','M','',0,'Doe','Fidgerld','','','','CEO','j.f.doe@mail.com','',NULL,NULL),(2,'admin','2021-01-10 16:19:03','admin','2021-01-10 16:19:03','','','','','','','1983-08-31','2020-05-04','Henry','M','',0,'Ford','','','','','Manager','h.ford@mail.com','',NULL,NULL),(3,'admin','2021-01-10 16:20:29','admin','2021-01-10 16:20:29','','','','','','','1980-04-16','2019-02-06','Paul','M','',0,'Collins','','','','','Accountant','p.collins@mail.com','',NULL,NULL),(4,'admin','2021-01-10 16:21:33','admin','2021-01-10 16:23:01','','','','','','','1996-01-31','2019-03-01','Helen','F','',0,'Doe','','','','','Administrator','helen.doe@mail.com','',NULL,NULL),(5,'admin','2021-01-10 16:22:50','admin','2021-01-10 16:23:13','','','','','','','1994-02-15','2020-09-09','Eve','F','',0,'Brown','','','','','Manager','eve.brown@mail.com','',NULL,NULL),(6,'admin','2021-01-10 16:24:42','admin','2021-01-10 16:24:42','','','','','','','1998-10-26','2020-12-07','Felix','M','',0,'Fox','','','','','HR','f.fox@mail.com','',NULL,NULL);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `employee_project`
--

LOCK TABLES `employee_project` WRITE;
/*!40000 ALTER TABLE `employee_project` DISABLE KEYS */;
/*!40000 ALTER TABLE `employee_project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` VALUES (1,'user','2021-01-10 16:16:03','user','2021-01-10 16:16:03',0,'','Installation works','SERVICE',0,23.00,32.00,'kompl.',NULL,NULL,NULL);
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `item_to_quotation`
--

LOCK TABLES `item_to_quotation` WRITE;
/*!40000 ALTER TABLE `item_to_quotation` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_to_quotation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `pay_term`
--

LOCK TABLES `pay_term` WRITE;
/*!40000 ALTER TABLE `pay_term` DISABLE KEYS */;
INSERT INTO `pay_term` VALUES (5,'user','2021-01-10 15:50:18','user','2021-01-10 15:50:18'),(15,'user','2021-01-10 15:50:22','user','2021-01-10 15:50:22'),(30,'user','2021-01-10 15:50:31','user','2021-01-10 15:50:31'),(45,'user','2021-01-10 15:50:37','user','2021-01-10 15:50:37'),(60,'user','2021-01-10 15:50:43','user','2021-01-10 15:50:43');
/*!40000 ALTER TABLE `pay_term` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `project`
--

LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
/*!40000 ALTER TABLE `project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `project_status`
--

LOCK TABLES `project_status` WRITE;
/*!40000 ALTER TABLE `project_status` DISABLE KEYS */;
INSERT INTO `project_status` VALUES (1,'user','2021-01-10 15:51:08','user','2021-01-10 15:51:08','In Progress'),(2,'user','2021-01-10 15:51:21','user','2021-01-10 15:51:21','Completed');
/*!40000 ALTER TABLE `project_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `project_type`
--

LOCK TABLES `project_type` WRITE;
/*!40000 ALTER TABLE `project_type` DISABLE KEYS */;
INSERT INTO `project_type` VALUES (1,'user','2021-01-10 15:51:48','user','2021-01-10 15:51:48','Production'),(2,'user','2021-01-10 15:51:59','user','2021-01-10 15:51:59','Retail');
/*!40000 ALTER TABLE `project_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `quotation`
--

LOCK TABLES `quotation` WRITE;
/*!40000 ALTER TABLE `quotation` DISABLE KEYS */;
/*!40000 ALTER TABLE `quotation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `quotation_status`
--

LOCK TABLES `quotation_status` WRITE;
/*!40000 ALTER TABLE `quotation_status` DISABLE KEYS */;
INSERT INTO `quotation_status` VALUES (1,'user','2021-01-10 15:55:30','user','2021-01-10 15:55:30','Being prepared'),(2,'user','2021-01-10 15:56:39','user','2021-01-10 15:57:23','Provided to'),(3,'user','2021-01-10 15:57:17','user','2021-01-10 15:57:30','Approved by'),(4,'user','2021-01-10 15:57:58','user','2021-01-10 15:57:58','Rejected by'),(5,'user','2021-01-10 15:58:52','user','2021-01-10 15:58:52','Lost');
/*!40000 ALTER TABLE `quotation_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `stock_type`
--

LOCK TABLES `stock_type` WRITE;
/*!40000 ALTER TABLE `stock_type` DISABLE KEYS */;
INSERT INTO `stock_type` VALUES (1,'user','2021-01-10 15:59:28','user','2021-01-10 15:59:28','Some Street str. 1','','Vilnius',0,'Main','',NULL),(2,'user','2021-01-10 16:00:09','user','2021-01-10 16:00:09','','','',0,'Temporary','',NULL);
/*!40000 ALTER TABLE `stock_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `supplier`
--

LOCK TABLES `supplier` WRITE;
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user_accounts`
--

LOCK TABLES `user_accounts` WRITE;
/*!40000 ALTER TABLE `user_accounts` DISABLE KEYS */;
INSERT INTO `user_accounts` VALUES (4,'admin','2021-01-11 15:29:39','admin','2021-01-11 15:29:39',1,'$2a$10$EtBZb0Meft2cp9odhnMRPuYR9B4uv9RBrCfm.4luztYnuKkhnXMMa','ADMIN','admin',NULL),(5,'admin','2021-01-11 15:29:55','admin','2021-01-11 15:29:55',1,'$2a$10$pkX6ahfN8ezMCDTtTPP94uzRjHX7g5qiZQQNucwGmNuEBPDcud.dG','MANAGER','user',NULL);
/*!40000 ALTER TABLE `user_accounts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `vat_value`
--

LOCK TABLES `vat_value` WRITE;
/*!40000 ALTER TABLE `vat_value` DISABLE KEYS */;
INSERT INTO `vat_value` VALUES (1,'user','2021-01-10 16:01:04','user','2021-01-10 16:01:04','21%',21),(2,'user','2021-01-10 16:01:12','user','2021-01-10 16:01:12','9%',9),(3,'user','2021-01-10 16:01:48','user','2021-01-10 16:01:48','5%',5);
/*!40000 ALTER TABLE `vat_value` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-11 17:30:28

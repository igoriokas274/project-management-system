-- MySQL dump 10.13  Distrib 5.7.32, for Linux (x86_64)
--
-- Host: localhost    Database: managerpro
-- ------------------------------------------------------
-- Server version	5.7.32-0ubuntu0.18.04.1

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
-- Table structure for table `contact`
--

DROP TABLE IF EXISTS `contact`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contact` (
  `contact_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_modified_by` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `contact_email` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `contact_phone` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `first_name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `gender` varchar(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `closed` int(11) DEFAULT 0,
  `last_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `middle_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `title` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `customer_id` bigint(20) DEFAULT NULL,
  `supplier_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`contact_id`),
  KEY `FKckoarj5a5jmet3b3smgdhaopw` (`customer_id`),
  KEY `FK3y0riifnpi1p06oyyu1mwjbk2` (`supplier_id`),
  CONSTRAINT `FK3y0riifnpi1p06oyyu1mwjbk2` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`supplier_id`),
  CONSTRAINT `FKckoarj5a5jmet3b3smgdhaopw` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contact`
--

LOCK TABLES `contact` WRITE;
/*!40000 ALTER TABLE `contact` DISABLE KEYS */;
/*!40000 ALTER TABLE `contact` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `country`
--

DROP TABLE IF EXISTS `country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `country` (
  `country_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_modified_by` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `country_code` varchar(2) COLLATE utf8mb4_unicode_ci NOT NULL,
  `country_name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `closed` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`country_id`),
  UNIQUE KEY `UK_oqixmig4k8qxc8oba3fl4gqkr` (`country_code`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country`
--

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` VALUES (1,'user','2021-01-10 15:44:17','user','2021-01-10 15:44:17','LT','Lithuania',0),(2,'user','2021-01-10 15:44:32','user','2021-01-10 15:44:32','LV','Latvia',0),(3,'user','2021-01-10 15:44:41','user','2021-01-10 15:44:41','EE','Estonia',0),(4,'user','2021-01-10 15:44:49','user','2021-01-10 15:44:49','PL','Poland',0),(5,'user','2021-01-10 15:45:33','user','2021-01-10 15:45:33','RU','Russian Federation',0),(6,'user','2021-01-10 15:45:47','user','2021-01-10 15:45:47','DE','Germany',0);
/*!40000 ALTER TABLE `country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `currency`
--

DROP TABLE IF EXISTS `currency`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `currency` (
  `currency_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_modified_by` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `currency_code` varchar(3) COLLATE utf8mb4_unicode_ci NOT NULL,
  `currency_name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `closed` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`currency_id`),
  UNIQUE KEY `UK_7n17ygajjchsso2n0lyxrsyif` (`currency_code`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `currency`
--

LOCK TABLES `currency` WRITE;
/*!40000 ALTER TABLE `currency` DISABLE KEYS */;
INSERT INTO `currency` VALUES (1,'user','2021-01-10 15:46:01','user','2021-01-10 15:46:01','EUR','Euro',0),(2,'user','2021-01-10 15:46:38','user','2021-01-10 15:46:38','PLN','Zloty',0),(3,'user','2021-01-10 15:47:16','user','2021-01-10 15:47:16','RUB','Russian Ruble',0),(4,'user','2021-01-10 15:47:47','user','2021-01-10 15:47:56','USD','US Dollar',0),(5,'user','2021-01-10 15:48:38','user','2021-01-10 15:48:38','GBP','Pound Sterling',0);
/*!40000 ALTER TABLE `currency` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `customer_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_modified_by` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `address_line1` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `address_line2` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `bank_account` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `bank_code` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `bank_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `city` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `customer_email` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `customer_phone` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `customer_name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `customer_registration_number` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `customervatnumber` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `closed` int(11) NOT NULL DEFAULT 0,
  `swift` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `zip_code` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `country_id` bigint(20) DEFAULT NULL,
  `currency_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`customer_id`),
  KEY `FKmkr4ai7dyofddp8a83hp7yu1h` (`country_id`),
  KEY `FK3fqcpx7dko5slv9s6m31cm4g1` (`currency_id`),
  CONSTRAINT `FK3fqcpx7dko5slv9s6m31cm4g1` FOREIGN KEY (`currency_id`) REFERENCES `currency` (`currency_id`),
  CONSTRAINT `FKmkr4ai7dyofddp8a83hp7yu1h` FOREIGN KEY (`country_id`) REFERENCES `country` (`country_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `department` (
  `department_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_modified_by` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `department_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `closed` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`department_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (1,'user','2021-01-10 15:48:58','user','2021-01-10 15:48:58','Administration',0),(2,'user','2021-01-10 15:49:31','user','2021-01-10 15:49:31','Financial dept.',0),(3,'user','2021-01-10 15:49:39','user','2021-01-10 15:49:39','Sales dept.',0),(4,'user','2021-01-10 15:49:53','user','2021-01-10 15:49:53','Production dept.',0),(5,'user','2021-01-10 15:50:06','user','2021-01-10 15:50:06','HR',0);
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `employee_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_modified_by` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `address_line1` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `address_line2` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `bank_account` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `bank_code` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `bank_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `city` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `date_of_employment` date DEFAULT NULL,
  `first_name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `gender` varchar(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `home_phone` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `closed` int(11) NOT NULL DEFAULT 0,
  `last_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `middle_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `mobile_phone` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `office_phone` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `personal_email` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `title` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `work_email` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `zip_code` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `country_id` bigint(20) DEFAULT NULL,
  `department_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`employee_id`),
  KEY `FKivtkrlfso4toqek7i2rul2ggy` (`country_id`),
  KEY `FKbejtwvg9bxus2mffsm3swj3u9` (`department_id`),
  CONSTRAINT `FKbejtwvg9bxus2mffsm3swj3u9` FOREIGN KEY (`department_id`) REFERENCES `department` (`department_id`),
  CONSTRAINT `FKivtkrlfso4toqek7i2rul2ggy` FOREIGN KEY (`country_id`) REFERENCES `country` (`country_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'admin','2021-01-10 16:18:08','admin','2021-01-10 16:18:08','','','','','','','1977-11-15','2018-02-01','John','M','',0,'Doe','Fitzgerald','','','','CEO','j.f.doe@mail.com','',NULL,NULL),(2,'admin','2021-01-10 16:19:03','admin','2021-01-10 16:19:03','','','','','','','1983-08-31','2020-05-04','Henry','M','',0,'Ford','','','','','Manager','h.ford@mail.com','',NULL,NULL),(3,'admin','2021-01-10 16:20:29','admin','2021-01-10 16:20:29','','','','','','','1980-04-16','2019-02-06','Paul','M','',0,'Collins','','','','','Accountant','p.collins@mail.com','',NULL,NULL),(4,'admin','2021-01-10 16:21:33','admin','2021-01-10 16:23:01','','','','','','','1996-01-31','2019-03-01','Helen','F','',0,'Doe','','','','','Administrator','helen.doe@mail.com','',NULL,NULL),(5,'admin','2021-01-10 16:22:50','admin','2021-01-10 16:23:13','','','','','','','1994-02-15','2020-09-09','Eve','F','',0,'Brown','','','','','Manager','eve.brown@mail.com','',NULL,NULL),(6,'admin','2021-01-10 16:24:42','admin','2021-01-10 16:24:42','','','','','','','1998-10-26','2020-12-07','Felix','M','',0,'Fox','','','','','HR','f.fox@mail.com','',NULL,NULL);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_project`
--

DROP TABLE IF EXISTS `employee_project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee_project` (
  `employee_id` bigint(20) NOT NULL,
  `project_id` bigint(20) NOT NULL,
  PRIMARY KEY (`employee_id`,`project_id`),
  KEY `FK4yddvnm7283a40plkcti66wv9` (`project_id`),
  CONSTRAINT `FK4yddvnm7283a40plkcti66wv9` FOREIGN KEY (`project_id`) REFERENCES `project` (`project_id`),
  CONSTRAINT `FKb25s5hgggo6k4au4sye7teb3a` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_project`
--

LOCK TABLES `employee_project` WRITE;
/*!40000 ALTER TABLE `employee_project` DISABLE KEYS */;
/*!40000 ALTER TABLE `employee_project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item` (
  `item_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_modified_by` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `closed` int(11) NOT NULL DEFAULT 0,
  `item_description` text COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `item_name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `item_type` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `min_stock_level` int(11) DEFAULT NULL,
  `purchase_price` decimal(5,2) DEFAULT NULL,
  `sales_price` decimal(5,2) DEFAULT NULL,
  `unit` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `stock_id` bigint(20) DEFAULT NULL,
  `supplier_id` bigint(20) DEFAULT NULL,
  `vat_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`item_id`),
  KEY `FKrfa78251s9rxf5hxh2gr8bdlx` (`stock_id`),
  KEY `FKcjes46ncuefgrkgt6ib0oo2bb` (`supplier_id`),
  KEY `FKjiuoty48tefl27u5olb30f7op` (`vat_id`),
  CONSTRAINT `FKcjes46ncuefgrkgt6ib0oo2bb` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`supplier_id`),
  CONSTRAINT `FKjiuoty48tefl27u5olb30f7op` FOREIGN KEY (`vat_id`) REFERENCES `vat_value` (`vat_id`),
  CONSTRAINT `FKrfa78251s9rxf5hxh2gr8bdlx` FOREIGN KEY (`stock_id`) REFERENCES `stock_type` (`stock_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` VALUES (1,'user','2021-01-10 16:16:03','user','2021-01-10 16:16:03',0,'','Installation works','SERVICE',0,23.00,32.00,'kompl.',NULL,NULL,NULL);
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_to_quotation`
--

DROP TABLE IF EXISTS `item_to_quotation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item_to_quotation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_modified_by` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `item_name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `purchase_price` decimal(10,2) DEFAULT NULL,
  `quantity` double NOT NULL,
  `sales_price` decimal(10,2) DEFAULT NULL,
  `item_id` bigint(20) DEFAULT NULL,
  `quotation_id` bigint(20) DEFAULT NULL,
  `vat_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKeft60pa2bqqeoug8jrejcc399` (`item_id`),
  KEY `FK1bumu4acvc0k04te6jvw40ec8` (`quotation_id`),
  KEY `FK9ovfh67nl0acfyjnaqicfahql` (`vat_id`),
  CONSTRAINT `FK1bumu4acvc0k04te6jvw40ec8` FOREIGN KEY (`quotation_id`) REFERENCES `quotation` (`quotation_id`),
  CONSTRAINT `FK9ovfh67nl0acfyjnaqicfahql` FOREIGN KEY (`vat_id`) REFERENCES `vat_value` (`vat_id`),
  CONSTRAINT `FKeft60pa2bqqeoug8jrejcc399` FOREIGN KEY (`item_id`) REFERENCES `item` (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_to_quotation`
--

LOCK TABLES `item_to_quotation` WRITE;
/*!40000 ALTER TABLE `item_to_quotation` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_to_quotation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pay_term`
--

DROP TABLE IF EXISTS `pay_term`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pay_term` (
  `term` bigint(20) NOT NULL,
  `created_by` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_modified_by` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  PRIMARY KEY (`term`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pay_term`
--

LOCK TABLES `pay_term` WRITE;
/*!40000 ALTER TABLE `pay_term` DISABLE KEYS */;
INSERT INTO `pay_term` VALUES (5,'user','2021-01-10 15:50:18','user','2021-01-10 15:50:18'),(15,'user','2021-01-10 15:50:22','user','2021-01-10 15:50:22'),(30,'user','2021-01-10 15:50:31','user','2021-01-10 15:50:31'),(45,'user','2021-01-10 15:50:37','user','2021-01-10 15:50:37'),(60,'user','2021-01-10 15:50:43','user','2021-01-10 15:50:43');
/*!40000 ALTER TABLE `pay_term` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project` (
  `project_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_modified_by` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `closed` int(11) NOT NULL DEFAULT 0,
  `project_end_date` date DEFAULT NULL,
  `project_memo1` text COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `project_memo2` text COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `project_name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `project_start_date` date DEFAULT NULL,
  `customer_id` bigint(20) DEFAULT NULL,
  `term` bigint(20) DEFAULT NULL,
  `project_status_id` bigint(20) DEFAULT NULL,
  `project_type_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`project_id`),
  KEY `FKj948tru2ilgqxfxsppp9mom5j` (`customer_id`),
  KEY `FKcpjmvon7n7rlb4ws0t0wr0j97` (`term`),
  KEY `FKmshv9pg3iw2t70144rjjh378j` (`project_status_id`),
  KEY `FKah6s35k2p37mnlj6dbag3e8mw` (`project_type_id`),
  CONSTRAINT `FKah6s35k2p37mnlj6dbag3e8mw` FOREIGN KEY (`project_type_id`) REFERENCES `project_type` (`project_type_id`),
  CONSTRAINT `FKcpjmvon7n7rlb4ws0t0wr0j97` FOREIGN KEY (`term`) REFERENCES `pay_term` (`term`),
  CONSTRAINT `FKj948tru2ilgqxfxsppp9mom5j` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`),
  CONSTRAINT `FKmshv9pg3iw2t70144rjjh378j` FOREIGN KEY (`project_status_id`) REFERENCES `project_status` (`project_status_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project`
--

LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
/*!40000 ALTER TABLE `project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project_status`
--

DROP TABLE IF EXISTS `project_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project_status` (
  `project_status_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_modified_by` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `project_status_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`project_status_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_status`
--

LOCK TABLES `project_status` WRITE;
/*!40000 ALTER TABLE `project_status` DISABLE KEYS */;
INSERT INTO `project_status` VALUES (1,'user','2021-01-10 15:51:08','user','2021-01-10 15:51:08','In Progress'),(2,'user','2021-01-10 15:51:21','user','2021-01-10 15:51:21','Completed');
/*!40000 ALTER TABLE `project_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project_type`
--

DROP TABLE IF EXISTS `project_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project_type` (
  `project_type_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_modified_by` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `project_type_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`project_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_type`
--

LOCK TABLES `project_type` WRITE;
/*!40000 ALTER TABLE `project_type` DISABLE KEYS */;
INSERT INTO `project_type` VALUES (1,'user','2021-01-10 15:51:48','user','2021-01-10 15:51:48','Production'),(2,'user','2021-01-10 15:51:59','user','2021-01-10 15:51:59','Retail');
/*!40000 ALTER TABLE `project_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quotation`
--

DROP TABLE IF EXISTS `quotation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `quotation` (
  `quotation_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_modified_by` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `confirmed` int(11) NOT NULL DEFAULT 0,
  `quotation_date` date DEFAULT NULL,
  `quotation_title` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `project_id` bigint(20) DEFAULT NULL,
  `quotation_status_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`quotation_id`),
  KEY `FKcmbpweu50voolwthfnjqo2jpv` (`project_id`),
  KEY `FKp681igs52jpgaekdcf5petr0p` (`quotation_status_id`),
  CONSTRAINT `FKcmbpweu50voolwthfnjqo2jpv` FOREIGN KEY (`project_id`) REFERENCES `project` (`project_id`),
  CONSTRAINT `FKp681igs52jpgaekdcf5petr0p` FOREIGN KEY (`quotation_status_id`) REFERENCES `quotation_status` (`quotation_status_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quotation`
--

LOCK TABLES `quotation` WRITE;
/*!40000 ALTER TABLE `quotation` DISABLE KEYS */;
/*!40000 ALTER TABLE `quotation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quotation_status`
--

DROP TABLE IF EXISTS `quotation_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `quotation_status` (
  `quotation_status_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_modified_by` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `quotation_status_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`quotation_status_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quotation_status`
--

LOCK TABLES `quotation_status` WRITE;
/*!40000 ALTER TABLE `quotation_status` DISABLE KEYS */;
INSERT INTO `quotation_status` VALUES (1,'user','2021-01-10 15:55:30','user','2021-01-10 15:55:30','Being prepared'),(2,'user','2021-01-10 15:56:39','user','2021-01-10 15:57:23','Provided to'),(3,'user','2021-01-10 15:57:17','user','2021-01-10 15:57:30','Approved by'),(4,'user','2021-01-10 15:57:58','user','2021-01-10 15:57:58','Rejected by'),(5,'user','2021-01-10 15:58:52','user','2021-01-10 15:58:52','Lost');
/*!40000 ALTER TABLE `quotation_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock_type`
--

DROP TABLE IF EXISTS `stock_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stock_type` (
  `stock_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_modified_by` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `address_line1` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `address_line2` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `city` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `closed` int(11) NOT NULL DEFAULT 0,
  `stock_name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `zip_code` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `country_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`stock_id`),
  KEY `FKabmxhidu94k05n7pihhpkp4pb` (`country_id`),
  CONSTRAINT `FKabmxhidu94k05n7pihhpkp4pb` FOREIGN KEY (`country_id`) REFERENCES `country` (`country_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock_type`
--

LOCK TABLES `stock_type` WRITE;
/*!40000 ALTER TABLE `stock_type` DISABLE KEYS */;
INSERT INTO `stock_type` VALUES (1,'user','2021-01-10 15:59:28','user','2021-01-10 15:59:28','Some Street str. 1','','Vilnius',0,'Main','',NULL),(2,'user','2021-01-10 16:00:09','user','2021-01-10 16:00:09','','','',0,'Temporary','',NULL);
/*!40000 ALTER TABLE `stock_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplier`
--

DROP TABLE IF EXISTS `supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `supplier` (
  `supplier_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_modified_by` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `address_line1` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `address_line2` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `bank_account` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `bank_code` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `bank_name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `city` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `supplier_email` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `supplier_phone` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `closed` int(11) NOT NULL DEFAULT 0,
  `supplier_name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `supplier_registration_number` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `suppliervatnumber` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `swift` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `zip_code` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `country_id` bigint(20) DEFAULT NULL,
  `currency_id` bigint(20) DEFAULT NULL,
  `term` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`supplier_id`),
  KEY `FKdp2i9p8sxew7tj0dksty5dw4t` (`country_id`),
  KEY `FKcwxxjfv1uhv5b7ej4e30yh0wr` (`currency_id`),
  KEY `FKs00tu31w0449iolyb62sgscu2` (`term`),
  CONSTRAINT `FKcwxxjfv1uhv5b7ej4e30yh0wr` FOREIGN KEY (`currency_id`) REFERENCES `currency` (`currency_id`),
  CONSTRAINT `FKdp2i9p8sxew7tj0dksty5dw4t` FOREIGN KEY (`country_id`) REFERENCES `country` (`country_id`),
  CONSTRAINT `FKs00tu31w0449iolyb62sgscu2` FOREIGN KEY (`term`) REFERENCES `pay_term` (`term`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier`
--

LOCK TABLES `supplier` WRITE;
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_accounts`
--

DROP TABLE IF EXISTS `user_accounts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_accounts` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_modified_by` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `enabled` int(11) NOT NULL DEFAULT 1,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `role` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `username` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `UK_lxwlgwuy2yrbye2vgs9w9x7mr` (`username`),
  KEY `FKsalhmu557mx3otyqhkqc7rcsp` (`employee_id`),
  CONSTRAINT `FKsalhmu557mx3otyqhkqc7rcsp` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_accounts`
--

LOCK TABLES `user_accounts` WRITE;
/*!40000 ALTER TABLE `user_accounts` DISABLE KEYS */;
INSERT INTO `user_accounts` VALUES (1,'admin','2021-01-11 15:29:39','admin','2021-01-11 15:29:39',1,'$2a$10$EtBZb0Meft2cp9odhnMRPuYR9B4uv9RBrCfm.4luztYnuKkhnXMMa','ADMIN','admin',NULL),(2,'admin','2021-01-11 15:29:55','admin','2021-01-11 15:29:55',1,'$2a$10$pkX6ahfN8ezMCDTtTPP94uzRjHX7g5qiZQQNucwGmNuEBPDcud.dG','MANAGER','user',NULL);
/*!40000 ALTER TABLE `user_accounts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vat_value`
--

DROP TABLE IF EXISTS `vat_value`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vat_value` (
  `vat_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_modified_by` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `description` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `vat_value` bigint(20) NOT NULL,
  PRIMARY KEY (`vat_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

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
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-17 20:19:16

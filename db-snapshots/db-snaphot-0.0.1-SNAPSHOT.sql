-- MariaDB dump 10.18  Distrib 10.5.8-MariaDB, for Linux (x86_64)
--
-- Host: localhost    Database: managerpro
-- ------------------------------------------------------
-- Server version	10.5.8-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `CONTACTS`
--

DROP TABLE IF EXISTS `CONTACTS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CONTACTS` (
  `contactId` bigint(20) NOT NULL AUTO_INCREMENT,
  `addressLine1` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `addressLine2` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `city` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `birthdate` date DEFAULT NULL,
  `department` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `contactEmail` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `fullName` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `contactPhone` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `createdBy` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `createdDate` datetime NOT NULL,
  `gender` varchar(1) COLLATE utf8_unicode_ci DEFAULT NULL,
  `closed` int(11) NOT NULL DEFAULT 0,
  `lastUpdatedBy` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `lastUpdatedDate` datetime NOT NULL,
  `title` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `zipCode` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `countryId` varchar(3) COLLATE utf8_unicode_ci DEFAULT NULL,
  `customerId` bigint(20) DEFAULT NULL,
  `employee_employeeId` bigint(20) DEFAULT NULL,
  `supplierId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`contactId`),
  KEY `FKrhweinx42rrqvyso3xcgbmouj` (`countryId`),
  KEY `FKexiq20qnut83bke5t7090kj5y` (`customerId`),
  KEY `FK3ap2lws4liwv7fm2ajjlykjx1` (`employee_employeeId`),
  KEY `FK4xltbrdjo0a9cexq1kc3jbvis` (`supplierId`),
  CONSTRAINT `FK3ap2lws4liwv7fm2ajjlykjx1` FOREIGN KEY (`employee_employeeId`) REFERENCES `EMPLOYEE` (`employeeId`),
  CONSTRAINT `FK4xltbrdjo0a9cexq1kc3jbvis` FOREIGN KEY (`supplierId`) REFERENCES `SUPPLIERS` (`supplierId`),
  CONSTRAINT `FKexiq20qnut83bke5t7090kj5y` FOREIGN KEY (`customerId`) REFERENCES `CUSTOMERS` (`customerId`),
  CONSTRAINT `FKrhweinx42rrqvyso3xcgbmouj` FOREIGN KEY (`countryId`) REFERENCES `COUNTRIES` (`countryId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CONTACTS`
--

LOCK TABLES `CONTACTS` WRITE;
/*!40000 ALTER TABLE `CONTACTS` DISABLE KEYS */;
/*!40000 ALTER TABLE `CONTACTS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `COUNTRIES`
--

DROP TABLE IF EXISTS `COUNTRIES`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `COUNTRIES` (
  `countryId` varchar(3) COLLATE utf8_unicode_ci NOT NULL,
  `createdBy` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `createdDate` datetime NOT NULL,
  `closed` tinyint(1) NOT NULL DEFAULT 0,
  `lastUpdatedBy` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `lastUpdatedDate` datetime NOT NULL,
  PRIMARY KEY (`countryId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `COUNTRIES`
--

LOCK TABLES `COUNTRIES` WRITE;
/*!40000 ALTER TABLE `COUNTRIES` DISABLE KEYS */;
/*!40000 ALTER TABLE `COUNTRIES` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CURRENCIES`
--

DROP TABLE IF EXISTS `CURRENCIES`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CURRENCIES` (
  `currencyId` varchar(2) COLLATE utf8_unicode_ci NOT NULL,
  `createdBy` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `createdDate` datetime NOT NULL,
  `closed` tinyint(1) NOT NULL DEFAULT 0,
  `lastUpdatedBy` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `lastUpdatedDate` datetime NOT NULL,
  PRIMARY KEY (`currencyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CURRENCIES`
--

LOCK TABLES `CURRENCIES` WRITE;
/*!40000 ALTER TABLE `CURRENCIES` DISABLE KEYS */;
/*!40000 ALTER TABLE `CURRENCIES` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CUSTOMERS`
--

DROP TABLE IF EXISTS `CUSTOMERS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CUSTOMERS` (
  `customerId` bigint(20) NOT NULL AUTO_INCREMENT,
  `addressLine1` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `addressLine2` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `bankAccount` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `bankCode` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `bankName` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `city` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `customerEmail` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `customerPhone` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `createdBy` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `createdDate` datetime NOT NULL,
  `customerRegistrationNumber` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `customerVATNumber` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `closed` tinyint(1) NOT NULL DEFAULT 0,
  `lastUpdatedBy` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `lastUpdatedDate` datetime NOT NULL,
  `customerName` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `SWIFT` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `zipCode` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `countryId` varchar(3) COLLATE utf8_unicode_ci DEFAULT NULL,
  `currencyId` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL,
  `term` decimal(3,2) DEFAULT NULL,
  PRIMARY KEY (`customerId`),
  KEY `FKhd3d7p5uukjjkpapb3fuw2xqs` (`countryId`),
  KEY `FKjacnioay17tjpj8ycgo1qe6fd` (`currencyId`),
  KEY `FK7h8yhqc47nvyuwa1jq49et3wk` (`term`),
  CONSTRAINT `FK7h8yhqc47nvyuwa1jq49et3wk` FOREIGN KEY (`term`) REFERENCES `PAY_TERMS` (`term`),
  CONSTRAINT `FKhd3d7p5uukjjkpapb3fuw2xqs` FOREIGN KEY (`countryId`) REFERENCES `COUNTRIES` (`countryId`),
  CONSTRAINT `FKjacnioay17tjpj8ycgo1qe6fd` FOREIGN KEY (`currencyId`) REFERENCES `CURRENCIES` (`currencyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CUSTOMERS`
--

LOCK TABLES `CUSTOMERS` WRITE;
/*!40000 ALTER TABLE `CUSTOMERS` DISABLE KEYS */;
/*!40000 ALTER TABLE `CUSTOMERS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CUSTOMER_PROJECTS`
--

DROP TABLE IF EXISTS `CUSTOMER_PROJECTS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CUSTOMER_PROJECTS` (
  `customerId` bigint(20) NOT NULL,
  `projectId` bigint(20) NOT NULL,
  PRIMARY KEY (`customerId`,`projectId`),
  KEY `FK5v5ahksowlw5s34o5urhiqy21` (`projectId`),
  CONSTRAINT `FK5v5ahksowlw5s34o5urhiqy21` FOREIGN KEY (`projectId`) REFERENCES `PROJECTS` (`projectId`),
  CONSTRAINT `FKgfe2iobb7cu5q2k794smtiisn` FOREIGN KEY (`customerId`) REFERENCES `CUSTOMERS` (`customerId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CUSTOMER_PROJECTS`
--

LOCK TABLES `CUSTOMER_PROJECTS` WRITE;
/*!40000 ALTER TABLE `CUSTOMER_PROJECTS` DISABLE KEYS */;
/*!40000 ALTER TABLE `CUSTOMER_PROJECTS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `EMPLOYEE`
--

DROP TABLE IF EXISTS `EMPLOYEE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `EMPLOYEE` (
  `employeeId` bigint(20) NOT NULL AUTO_INCREMENT,
  `bankAccount` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `bankCode` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `bankName` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `createdBy` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `createdDate` datetime NOT NULL,
  `dateOfEmployment` date NOT NULL,
  `closed` tinyint(1) NOT NULL DEFAULT 0,
  `lastUpdatedBy` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `lastUpdatedDate` datetime NOT NULL,
  `contacts_contactId` bigint(20) DEFAULT NULL,
  `departmentId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`employeeId`),
  KEY `FK86o6dx6aps3uw6xeej8m5d83p` (`contacts_contactId`),
  KEY `FKe9a3xpqygchdixi7b6nal1egy` (`departmentId`),
  CONSTRAINT `FK86o6dx6aps3uw6xeej8m5d83p` FOREIGN KEY (`contacts_contactId`) REFERENCES `CONTACTS` (`contactId`),
  CONSTRAINT `FKe9a3xpqygchdixi7b6nal1egy` FOREIGN KEY (`departmentId`) REFERENCES `EMPLOYEE_DEPARTMENTS` (`departmentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `EMPLOYEE`
--

LOCK TABLES `EMPLOYEE` WRITE;
/*!40000 ALTER TABLE `EMPLOYEE` DISABLE KEYS */;
/*!40000 ALTER TABLE `EMPLOYEE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `EMPLOYEE_DEPARTMENTS`
--

DROP TABLE IF EXISTS `EMPLOYEE_DEPARTMENTS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `EMPLOYEE_DEPARTMENTS` (
  `departmentId` bigint(20) NOT NULL AUTO_INCREMENT,
  `createdBy` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `createdDate` datetime NOT NULL,
  `departmentName` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `lastUpdatedBy` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `lastUpdatedDate` datetime NOT NULL,
  PRIMARY KEY (`departmentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `EMPLOYEE_DEPARTMENTS`
--

LOCK TABLES `EMPLOYEE_DEPARTMENTS` WRITE;
/*!40000 ALTER TABLE `EMPLOYEE_DEPARTMENTS` DISABLE KEYS */;
/*!40000 ALTER TABLE `EMPLOYEE_DEPARTMENTS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `EMPLOYEE_PROJECTS`
--

DROP TABLE IF EXISTS `EMPLOYEE_PROJECTS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `EMPLOYEE_PROJECTS` (
  `employeeId` bigint(20) NOT NULL,
  `projectId` bigint(20) NOT NULL,
  PRIMARY KEY (`employeeId`,`projectId`),
  KEY `FK505e8gnu0hwqdh95r6dycnjdo` (`projectId`),
  CONSTRAINT `FK505e8gnu0hwqdh95r6dycnjdo` FOREIGN KEY (`projectId`) REFERENCES `PROJECTS` (`projectId`),
  CONSTRAINT `FKa5tywtvn4qo3x81t2t9uq24k9` FOREIGN KEY (`employeeId`) REFERENCES `EMPLOYEE` (`employeeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `EMPLOYEE_PROJECTS`
--

LOCK TABLES `EMPLOYEE_PROJECTS` WRITE;
/*!40000 ALTER TABLE `EMPLOYEE_PROJECTS` DISABLE KEYS */;
/*!40000 ALTER TABLE `EMPLOYEE_PROJECTS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ITEMS`
--

DROP TABLE IF EXISTS `ITEMS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ITEMS` (
  `itemId` bigint(20) NOT NULL AUTO_INCREMENT,
  `createdBy` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `createdDate` datetime NOT NULL,
  `closed` tinyint(1) NOT NULL DEFAULT 0,
  `itemDescription` text COLLATE utf8_unicode_ci DEFAULT NULL,
  `itemName` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `itemType` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `lastUpdatedBy` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `lastUpdatedDate` datetime NOT NULL,
  `minStockLevel` int(11) DEFAULT NULL,
  `salesPrice` decimal(10,2) DEFAULT NULL,
  `stockId` bigint(20) DEFAULT NULL,
  `supplierId` bigint(20) DEFAULT NULL,
  `vatId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`itemId`),
  KEY `FKs6fckeiwl76fbadvdel1u3auk` (`stockId`),
  KEY `FK2ufl6xam0io9ygdfvt1du2c7x` (`supplierId`),
  KEY `FK7woh0c49duq377ljau5qgkhhi` (`vatId`),
  CONSTRAINT `FK2ufl6xam0io9ygdfvt1du2c7x` FOREIGN KEY (`supplierId`) REFERENCES `SUPPLIERS` (`supplierId`),
  CONSTRAINT `FK7woh0c49duq377ljau5qgkhhi` FOREIGN KEY (`vatId`) REFERENCES `VAT_VALUES` (`vatId`),
  CONSTRAINT `FKs6fckeiwl76fbadvdel1u3auk` FOREIGN KEY (`stockId`) REFERENCES `STOCK_TYPES` (`stockId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ITEMS`
--

LOCK TABLES `ITEMS` WRITE;
/*!40000 ALTER TABLE `ITEMS` DISABLE KEYS */;
/*!40000 ALTER TABLE `ITEMS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PAY_TERMS`
--

DROP TABLE IF EXISTS `PAY_TERMS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PAY_TERMS` (
  `term` decimal(3,2) NOT NULL,
  `createdBy` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `createdDate` datetime NOT NULL,
  `lastUpdatedBy` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `lastUpdatedDate` datetime NOT NULL,
  PRIMARY KEY (`term`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PAY_TERMS`
--

LOCK TABLES `PAY_TERMS` WRITE;
/*!40000 ALTER TABLE `PAY_TERMS` DISABLE KEYS */;
/*!40000 ALTER TABLE `PAY_TERMS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PROJECTS`
--

DROP TABLE IF EXISTS `PROJECTS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PROJECTS` (
  `projectId` bigint(20) NOT NULL AUTO_INCREMENT,
  `ProjectEndDate` date DEFAULT NULL,
  `createdBy` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `createdDate` datetime NOT NULL,
  `closed` tinyint(1) NOT NULL DEFAULT 0,
  `lastUpdatedBy` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `lastUpdatedDate` datetime NOT NULL,
  `projectMemo1` text COLLATE utf8_unicode_ci DEFAULT NULL,
  `projectMemo2` text COLLATE utf8_unicode_ci DEFAULT NULL,
  `projectName` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `projectStartDate` date DEFAULT NULL,
  PRIMARY KEY (`projectId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PROJECTS`
--

LOCK TABLES `PROJECTS` WRITE;
/*!40000 ALTER TABLE `PROJECTS` DISABLE KEYS */;
/*!40000 ALTER TABLE `PROJECTS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PROJECT_STATUS`
--

DROP TABLE IF EXISTS `PROJECT_STATUS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PROJECT_STATUS` (
  `projectStatusId` bigint(20) NOT NULL AUTO_INCREMENT,
  `createdBy` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `createdDate` datetime NOT NULL,
  `lastUpdatedBy` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `lastUpdatedDate` datetime NOT NULL,
  `projectStatusName` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `projectId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`projectStatusId`),
  KEY `FK7lt7odpshfyc637hbvrl2lrjb` (`projectId`),
  CONSTRAINT `FK7lt7odpshfyc637hbvrl2lrjb` FOREIGN KEY (`projectId`) REFERENCES `PROJECTS` (`projectId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PROJECT_STATUS`
--

LOCK TABLES `PROJECT_STATUS` WRITE;
/*!40000 ALTER TABLE `PROJECT_STATUS` DISABLE KEYS */;
/*!40000 ALTER TABLE `PROJECT_STATUS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PROJECT_TYPE`
--

DROP TABLE IF EXISTS `PROJECT_TYPE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PROJECT_TYPE` (
  `projectTypeId` bigint(20) NOT NULL AUTO_INCREMENT,
  `createdBy` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `createdDate` datetime NOT NULL,
  `lastUpdatedBy` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `lastUpdatedDate` datetime NOT NULL,
  `projectTypeName` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `projectId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`projectTypeId`),
  KEY `FKhwjoyaoee9xherwrbmnlt9w6d` (`projectId`),
  CONSTRAINT `FKhwjoyaoee9xherwrbmnlt9w6d` FOREIGN KEY (`projectId`) REFERENCES `PROJECTS` (`projectId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PROJECT_TYPE`
--

LOCK TABLES `PROJECT_TYPE` WRITE;
/*!40000 ALTER TABLE `PROJECT_TYPE` DISABLE KEYS */;
/*!40000 ALTER TABLE `PROJECT_TYPE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `STOCK_TYPES`
--

DROP TABLE IF EXISTS `STOCK_TYPES`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `STOCK_TYPES` (
  `stockId` bigint(20) NOT NULL AUTO_INCREMENT,
  `addressLine1` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `addressLine2` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `city` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `createdBy` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `createdDate` datetime NOT NULL,
  `closed` tinyint(1) NOT NULL DEFAULT 0,
  `lastUpdatedBy` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `lastUpdatedDate` datetime NOT NULL,
  `stockName` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `zipCode` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `countryId` varchar(3) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`stockId`),
  KEY `FKg93sjwi889uxd2r4ybb76cd0e` (`countryId`),
  CONSTRAINT `FKg93sjwi889uxd2r4ybb76cd0e` FOREIGN KEY (`countryId`) REFERENCES `COUNTRIES` (`countryId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `STOCK_TYPES`
--

LOCK TABLES `STOCK_TYPES` WRITE;
/*!40000 ALTER TABLE `STOCK_TYPES` DISABLE KEYS */;
/*!40000 ALTER TABLE `STOCK_TYPES` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SUPPLIERS`
--

DROP TABLE IF EXISTS `SUPPLIERS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SUPPLIERS` (
  `supplierId` bigint(20) NOT NULL AUTO_INCREMENT,
  `addressLine1` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `addressLine2` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `bankAccount` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `bankCode` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `bankName` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `city` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `supplierEmail` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `supplierPhone` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `createdBy` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `createdDate` datetime NOT NULL,
  `closed` tinyint(1) NOT NULL DEFAULT 0,
  `lastUpdatedBy` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `lastUpdatedDate` datetime NOT NULL,
  `supplierName` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `supplierRegistrationNumber` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `supplierVATNumber` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `SWIFT` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `zipCode` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `countryId` varchar(3) COLLATE utf8_unicode_ci DEFAULT NULL,
  `currencyId` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL,
  `term` decimal(3,2) DEFAULT NULL,
  PRIMARY KEY (`supplierId`),
  KEY `FKkoviie0i9m7pswdpunxssce30` (`countryId`),
  KEY `FKti95s2y8ykccea7sd5srvridi` (`currencyId`),
  KEY `FKj5ghncw847aaxt1gmthaa5tek` (`term`),
  CONSTRAINT `FKj5ghncw847aaxt1gmthaa5tek` FOREIGN KEY (`term`) REFERENCES `PAY_TERMS` (`term`),
  CONSTRAINT `FKkoviie0i9m7pswdpunxssce30` FOREIGN KEY (`countryId`) REFERENCES `COUNTRIES` (`countryId`),
  CONSTRAINT `FKti95s2y8ykccea7sd5srvridi` FOREIGN KEY (`currencyId`) REFERENCES `CURRENCIES` (`currencyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SUPPLIERS`
--

LOCK TABLES `SUPPLIERS` WRITE;
/*!40000 ALTER TABLE `SUPPLIERS` DISABLE KEYS */;
/*!40000 ALTER TABLE `SUPPLIERS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `VAT_VALUES`
--

DROP TABLE IF EXISTS `VAT_VALUES`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `VAT_VALUES` (
  `vatId` bigint(20) NOT NULL AUTO_INCREMENT,
  `createdBy` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `createdDate` datetime NOT NULL,
  `description` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `lastUpdatedBy` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `lastUpdatedDate` datetime NOT NULL,
  `vatValue` decimal(3,2) NOT NULL,
  PRIMARY KEY (`vatId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `VAT_VALUES`
--

LOCK TABLES `VAT_VALUES` WRITE;
/*!40000 ALTER TABLE `VAT_VALUES` DISABLE KEYS */;
/*!40000 ALTER TABLE `VAT_VALUES` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contacts`
--

DROP TABLE IF EXISTS `contacts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contacts` (
  `contact_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address_line1` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `address_line2` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `city` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `birthdate` date DEFAULT NULL,
  `department` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `contact_email` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `full_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `contact_phone` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `created_by` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `created_date` datetime NOT NULL,
  `gender` varchar(1) COLLATE utf8_unicode_ci DEFAULT NULL,
  `closed` int(11) NOT NULL DEFAULT 0,
  `last_updated_by` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `last_updated_date` datetime NOT NULL,
  `title` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `zip_code` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `country_id` varchar(3) COLLATE utf8_unicode_ci DEFAULT NULL,
  `customer_id` bigint(20) DEFAULT NULL,
  `employee_employee_id` bigint(20) DEFAULT NULL,
  `supplier_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`contact_id`),
  KEY `FK6m9l9635wmsrwgejpa6q7o947` (`country_id`),
  KEY `FK7fn6qgtowm81subo3un6k5yoq` (`customer_id`),
  KEY `FKg32et05l6xn1klh29rgq1fjhn` (`employee_employee_id`),
  KEY `FKaklq8ij85cy15gicnmm287f84` (`supplier_id`),
  CONSTRAINT `FK6m9l9635wmsrwgejpa6q7o947` FOREIGN KEY (`country_id`) REFERENCES `countries` (`country_id`),
  CONSTRAINT `FK7fn6qgtowm81subo3un6k5yoq` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`customer_id`),
  CONSTRAINT `FKaklq8ij85cy15gicnmm287f84` FOREIGN KEY (`supplier_id`) REFERENCES `suppliers` (`supplier_id`),
  CONSTRAINT `FKg32et05l6xn1klh29rgq1fjhn` FOREIGN KEY (`employee_employee_id`) REFERENCES `employee` (`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contacts`
--

LOCK TABLES `contacts` WRITE;
/*!40000 ALTER TABLE `contacts` DISABLE KEYS */;
/*!40000 ALTER TABLE `contacts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `countries`
--

DROP TABLE IF EXISTS `countries`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `countries` (
  `country_id` varchar(3) COLLATE utf8_unicode_ci NOT NULL,
  `created_by` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `created_date` datetime NOT NULL,
  `closed` tinyint(1) NOT NULL DEFAULT 0,
  `last_updated_by` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `last_updated_date` datetime NOT NULL,
  PRIMARY KEY (`country_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `countries`
--

LOCK TABLES `countries` WRITE;
/*!40000 ALTER TABLE `countries` DISABLE KEYS */;
/*!40000 ALTER TABLE `countries` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `currencies`
--

DROP TABLE IF EXISTS `currencies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `currencies` (
  `currency_id` varchar(2) COLLATE utf8_unicode_ci NOT NULL,
  `created_by` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `created_date` datetime NOT NULL,
  `closed` tinyint(1) NOT NULL DEFAULT 0,
  `last_updated_by` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `last_updated_date` datetime NOT NULL,
  PRIMARY KEY (`currency_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `currencies`
--

LOCK TABLES `currencies` WRITE;
/*!40000 ALTER TABLE `currencies` DISABLE KEYS */;
/*!40000 ALTER TABLE `currencies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_projects`
--

DROP TABLE IF EXISTS `customer_projects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer_projects` (
  `customer_id` bigint(20) NOT NULL,
  `project_id` bigint(20) NOT NULL,
  PRIMARY KEY (`customer_id`,`project_id`),
  KEY `FKbe2it5qmqcyoiefmfexw5iheo` (`project_id`),
  CONSTRAINT `FKbe2it5qmqcyoiefmfexw5iheo` FOREIGN KEY (`project_id`) REFERENCES `projects` (`project_id`),
  CONSTRAINT `FKsdp09o4y1vhdypjhys5h24t24` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_projects`
--

LOCK TABLES `customer_projects` WRITE;
/*!40000 ALTER TABLE `customer_projects` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer_projects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customers` (
  `customer_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address_line1` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `address_line2` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `bank_account` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `bank_code` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `bank_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `city` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `customer_email` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `customer_phone` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `created_by` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `created_date` datetime NOT NULL,
  `customer_registration_number` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `customervatnumber` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `closed` tinyint(1) NOT NULL DEFAULT 0,
  `last_updated_by` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `last_updated_date` datetime NOT NULL,
  `customer_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `swift` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `zip_code` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `country_id` varchar(3) COLLATE utf8_unicode_ci DEFAULT NULL,
  `currency_id` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL,
  `term` decimal(3,2) DEFAULT NULL,
  PRIMARY KEY (`customer_id`),
  KEY `FK7b7p2myt0y31l4nyj1p7sk0b1` (`country_id`),
  KEY `FKq3wmhipr9kq0epd2id1umuygx` (`currency_id`),
  KEY `FKjseko8laojw03a58dc8y2nl4k` (`term`),
  CONSTRAINT `FK7b7p2myt0y31l4nyj1p7sk0b1` FOREIGN KEY (`country_id`) REFERENCES `countries` (`country_id`),
  CONSTRAINT `FKjseko8laojw03a58dc8y2nl4k` FOREIGN KEY (`term`) REFERENCES `pay_terms` (`term`),
  CONSTRAINT `FKq3wmhipr9kq0epd2id1umuygx` FOREIGN KEY (`currency_id`) REFERENCES `currencies` (`currency_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `employee_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `bank_account` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `bank_code` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `bank_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `created_by` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `created_date` datetime NOT NULL,
  `closed` tinyint(1) NOT NULL DEFAULT 0,
  `last_updated_by` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `last_updated_date` datetime NOT NULL,
  `contacts_contact_id` bigint(20) DEFAULT NULL,
  `department_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`employee_id`),
  KEY `FKdyn9sfhicdg52kuw2952p8lmg` (`contacts_contact_id`),
  KEY `FK7j6qu48rm5l3wmkqv4l05mtna` (`department_id`),
  CONSTRAINT `FK7j6qu48rm5l3wmkqv4l05mtna` FOREIGN KEY (`department_id`) REFERENCES `employee_departments` (`department_id`),
  CONSTRAINT `FKdyn9sfhicdg52kuw2952p8lmg` FOREIGN KEY (`contacts_contact_id`) REFERENCES `contacts` (`contact_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_departments`
--

DROP TABLE IF EXISTS `employee_departments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee_departments` (
  `department_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `created_date` datetime NOT NULL,
  `department_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `last_updated_by` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `last_updated_date` datetime NOT NULL,
  PRIMARY KEY (`department_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_departments`
--

LOCK TABLES `employee_departments` WRITE;
/*!40000 ALTER TABLE `employee_departments` DISABLE KEYS */;
/*!40000 ALTER TABLE `employee_departments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_projects`
--

DROP TABLE IF EXISTS `employee_projects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee_projects` (
  `employee_id` bigint(20) NOT NULL,
  `project_id` bigint(20) NOT NULL,
  PRIMARY KEY (`employee_id`,`project_id`),
  KEY `FKnxw95o16xcyxe3qaiy1tyarnc` (`project_id`),
  CONSTRAINT `FK97jl81fsrbblkqfoqwg2o7yps` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`),
  CONSTRAINT `FKnxw95o16xcyxe3qaiy1tyarnc` FOREIGN KEY (`project_id`) REFERENCES `projects` (`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_projects`
--

LOCK TABLES `employee_projects` WRITE;
/*!40000 ALTER TABLE `employee_projects` DISABLE KEYS */;
/*!40000 ALTER TABLE `employee_projects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `items`
--

DROP TABLE IF EXISTS `items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `items` (
  `item_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `created_date` datetime NOT NULL,
  `closed` tinyint(1) NOT NULL DEFAULT 0,
  `item_description` text COLLATE utf8_unicode_ci DEFAULT NULL,
  `item_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `item_type` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `last_updated_by` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `last_updated_date` datetime NOT NULL,
  `min_stock_level` int(11) DEFAULT NULL,
  `sales_price` decimal(10,2) DEFAULT NULL,
  `stock_id` bigint(20) DEFAULT NULL,
  `supplier_id` bigint(20) DEFAULT NULL,
  `vat_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`item_id`),
  KEY `FKeqlguxlwroq9qubbtf050n1v7` (`stock_id`),
  KEY `FK19no9r2d31i2g27fh8h72xif8` (`supplier_id`),
  KEY `FKinlt7obet9mt6sfirl9429opq` (`vat_id`),
  CONSTRAINT `FK19no9r2d31i2g27fh8h72xif8` FOREIGN KEY (`supplier_id`) REFERENCES `suppliers` (`supplier_id`),
  CONSTRAINT `FKeqlguxlwroq9qubbtf050n1v7` FOREIGN KEY (`stock_id`) REFERENCES `stock_types` (`stock_id`),
  CONSTRAINT `FKinlt7obet9mt6sfirl9429opq` FOREIGN KEY (`vat_id`) REFERENCES `vat_values` (`vat_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `items`
--

LOCK TABLES `items` WRITE;
/*!40000 ALTER TABLE `items` DISABLE KEYS */;
/*!40000 ALTER TABLE `items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pay_terms`
--

DROP TABLE IF EXISTS `pay_terms`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pay_terms` (
  `term` decimal(3,2) NOT NULL,
  `created_by` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `created_date` datetime NOT NULL,
  `last_updated_by` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `last_updated_date` datetime NOT NULL,
  PRIMARY KEY (`term`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pay_terms`
--

LOCK TABLES `pay_terms` WRITE;
/*!40000 ALTER TABLE `pay_terms` DISABLE KEYS */;
/*!40000 ALTER TABLE `pay_terms` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project_status`
--

DROP TABLE IF EXISTS `project_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project_status` (
  `project_status_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `created_date` datetime NOT NULL,
  `last_updated_by` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `last_updated_date` datetime NOT NULL,
  `project_status_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `project_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`project_status_id`),
  KEY `FKat74svjd9fp73higp9mep2dip` (`project_id`),
  CONSTRAINT `FKat74svjd9fp73higp9mep2dip` FOREIGN KEY (`project_id`) REFERENCES `projects` (`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_status`
--

LOCK TABLES `project_status` WRITE;
/*!40000 ALTER TABLE `project_status` DISABLE KEYS */;
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
  `created_by` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `created_date` datetime NOT NULL,
  `last_updated_by` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `last_updated_date` datetime NOT NULL,
  `project_type_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `project_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`project_type_id`),
  KEY `FK6kypnv8ujfl06myffbinhq7ft` (`project_id`),
  CONSTRAINT `FK6kypnv8ujfl06myffbinhq7ft` FOREIGN KEY (`project_id`) REFERENCES `projects` (`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_type`
--

LOCK TABLES `project_type` WRITE;
/*!40000 ALTER TABLE `project_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `project_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `projects`
--

DROP TABLE IF EXISTS `projects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `projects` (
  `project_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `project_end_date` date DEFAULT NULL,
  `created_by` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `created_date` datetime NOT NULL,
  `closed` tinyint(1) NOT NULL DEFAULT 0,
  `last_updated_by` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `last_updated_date` datetime NOT NULL,
  `project_memo1` text COLLATE utf8_unicode_ci DEFAULT NULL,
  `project_memo2` text COLLATE utf8_unicode_ci DEFAULT NULL,
  `project_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `project_start_date` date DEFAULT NULL,
  PRIMARY KEY (`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projects`
--

LOCK TABLES `projects` WRITE;
/*!40000 ALTER TABLE `projects` DISABLE KEYS */;
/*!40000 ALTER TABLE `projects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock_types`
--

DROP TABLE IF EXISTS `stock_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stock_types` (
  `stock_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address_line1` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `address_line2` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `city` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `created_by` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `created_date` datetime NOT NULL,
  `closed` tinyint(1) NOT NULL DEFAULT 0,
  `last_updated_by` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `last_updated_date` datetime NOT NULL,
  `stock_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `zip_code` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `country_id` varchar(3) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`stock_id`),
  KEY `FKdgirthrr3pijtuda52r1ih9x` (`country_id`),
  CONSTRAINT `FKdgirthrr3pijtuda52r1ih9x` FOREIGN KEY (`country_id`) REFERENCES `countries` (`country_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock_types`
--

LOCK TABLES `stock_types` WRITE;
/*!40000 ALTER TABLE `stock_types` DISABLE KEYS */;
/*!40000 ALTER TABLE `stock_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `suppliers`
--

DROP TABLE IF EXISTS `suppliers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `suppliers` (
  `supplier_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address_line1` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `address_line2` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `bank_account` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `bank_code` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `bank_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `city` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `supplier_email` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `supplier_phone` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `created_by` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `created_date` datetime NOT NULL,
  `closed` tinyint(1) NOT NULL DEFAULT 0,
  `last_updated_by` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `last_updated_date` datetime NOT NULL,
  `supplier_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `supplier_registration_number` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `suppliervatnumber` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `swift` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `zip_code` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `country_id` varchar(3) COLLATE utf8_unicode_ci DEFAULT NULL,
  `currency_id` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL,
  `term` decimal(3,2) DEFAULT NULL,
  PRIMARY KEY (`supplier_id`),
  KEY `FKjcuohexsi23vnpxi0t25kvwg7` (`country_id`),
  KEY `FK8nfhun55mc7gsfkvub7if534y` (`currency_id`),
  KEY `FK9f4keh4khxbrm7fwv7ua8amvu` (`term`),
  CONSTRAINT `FK8nfhun55mc7gsfkvub7if534y` FOREIGN KEY (`currency_id`) REFERENCES `currencies` (`currency_id`),
  CONSTRAINT `FK9f4keh4khxbrm7fwv7ua8amvu` FOREIGN KEY (`term`) REFERENCES `pay_terms` (`term`),
  CONSTRAINT `FKjcuohexsi23vnpxi0t25kvwg7` FOREIGN KEY (`country_id`) REFERENCES `countries` (`country_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `suppliers`
--

LOCK TABLES `suppliers` WRITE;
/*!40000 ALTER TABLE `suppliers` DISABLE KEYS */;
/*!40000 ALTER TABLE `suppliers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vat_values`
--

DROP TABLE IF EXISTS `vat_values`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vat_values` (
  `vat_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `created_date` datetime NOT NULL,
  `description` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `last_updated_by` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `last_updated_date` datetime NOT NULL,
  `vat_value` decimal(3,2) NOT NULL,
  PRIMARY KEY (`vat_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vat_values`
--

LOCK TABLES `vat_values` WRITE;
/*!40000 ALTER TABLE `vat_values` DISABLE KEYS */;
/*!40000 ALTER TABLE `vat_values` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-12 14:31:24

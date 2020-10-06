-- MariaDB dump 10.17  Distrib 10.5.5-MariaDB, for Linux (x86_64)
--
-- Host: localhost    Database: managerpro
-- ------------------------------------------------------
-- Server version	10.5.5-MariaDB

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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-10-06 10:44:03

-- MySQL dump 10.13  Distrib 8.0.39, for Win64 (x86_64)
--
-- Host: localhost    Database: ormlearn
-- ------------------------------------------------------
-- Server version	8.0.39

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `ormlearn`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `ormlearn` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `ormlearn`;

--
-- Table structure for table `country`
--

DROP TABLE IF EXISTS `country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `country` (
  `co_code` varchar(2) NOT NULL,
  `co_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`co_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country`
--

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` VALUES ('BV','Bouvet Island'),('DJ','Djibouti'),('GP','Guadeloupe'),('GS','South Georgia and the South Sandwich Islands'),('IN','India'),('LU','Luxembourg'),('SS','South Sudan'),('TF','French Southern Territories'),('UM','United States Minor Outlying Islands'),('US','United States of America'),('ZA','South Africa'),('ZM','Zambia'),('ZW','Zimbabwe');
/*!40000 ALTER TABLE `country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `department` (
  `dept_id` int NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (1,'IT'),(2,'HR'),(3,'Finance');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `emp_id` int NOT NULL AUTO_INCREMENT,
  `emp_name` varchar(100) DEFAULT NULL,
  `emp_salary` double DEFAULT NULL,
  `emp_department` varchar(50) DEFAULT NULL,
  `emp_doj` date DEFAULT NULL,
  `dept_id` int DEFAULT NULL,
  PRIMARY KEY (`emp_id`),
  KEY `fk_dept` (`dept_id`),
  CONSTRAINT `fk_dept` FOREIGN KEY (`dept_id`) REFERENCES `department` (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'Alice',60000,'IT','2022-01-10',1),(2,'Bob',48000,'HR','2021-03-15',2),(3,'Charlie',75000,'Finance','2023-06-01',3),(4,'Diana',50000,'IT','2023-02-10',1),(5,'Eve',82000,'IT','2022-11-25',1);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_skill`
--

DROP TABLE IF EXISTS `employee_skill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee_skill` (
  `emp_id` int NOT NULL,
  `skill_id` int NOT NULL,
  PRIMARY KEY (`emp_id`,`skill_id`),
  KEY `skill_id` (`skill_id`),
  CONSTRAINT `employee_skill_ibfk_1` FOREIGN KEY (`emp_id`) REFERENCES `employee` (`emp_id`),
  CONSTRAINT `employee_skill_ibfk_2` FOREIGN KEY (`skill_id`) REFERENCES `skill` (`skill_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_skill`
--

LOCK TABLES `employee_skill` WRITE;
/*!40000 ALTER TABLE `employee_skill` DISABLE KEYS */;
INSERT INTO `employee_skill` VALUES (1,1),(3,1),(1,2),(2,2),(3,3);
/*!40000 ALTER TABLE `employee_skill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `skill`
--

DROP TABLE IF EXISTS `skill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `skill` (
  `skill_id` int NOT NULL AUTO_INCREMENT,
  `skill_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`skill_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `skill`
--

LOCK TABLES `skill` WRITE;
/*!40000 ALTER TABLE `skill` DISABLE KEYS */;
INSERT INTO `skill` VALUES (1,'Java'),(2,'SQL'),(3,'Spring Boot');
/*!40000 ALTER TABLE `skill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock`
--

DROP TABLE IF EXISTS `stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stock` (
  `st_id` int NOT NULL AUTO_INCREMENT,
  `st_code` varchar(20) DEFAULT NULL,
  `st_date` date DEFAULT NULL,
  `st_open` double DEFAULT NULL,
  `st_close` double DEFAULT NULL,
  `st_volume` bigint DEFAULT NULL,
  PRIMARY KEY (`st_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock`
--

LOCK TABLES `stock` WRITE;
/*!40000 ALTER TABLE `stock` DISABLE KEYS */;
INSERT INTO `stock` VALUES (1,'FB','2019-09-01',140,145,5000000),(2,'FB','2019-09-10',145,150,7000000),(3,'GOOG','2019-09-01',1200,1225,3000000),(4,'NFLX','2019-09-01',290,295,4000000),(5,'GOOG','2019-09-10',1250,1245,3500000);
/*!40000 ALTER TABLE `stock` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-07-04 16:05:29

-- MySQL dump 10.13  Distrib 8.0.39, for Win64 (x86_64)
--
-- Host: localhost    Database: ormlearnquery
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
-- Table structure for table `attempt`
--

DROP TABLE IF EXISTS `attempt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `attempt` (
  `id` int NOT NULL,
  `user_id` int DEFAULT NULL,
  `date_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `attempt_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attempt`
--

LOCK TABLES `attempt` WRITE;
/*!40000 ALTER TABLE `attempt` DISABLE KEYS */;
INSERT INTO `attempt` VALUES (5001,1,'2025-07-04 10:00:00');
/*!40000 ALTER TABLE `attempt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `attempt_option`
--

DROP TABLE IF EXISTS `attempt_option`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `attempt_option` (
  `id` int NOT NULL,
  `attempt_question_id` int DEFAULT NULL,
  `option_id` int DEFAULT NULL,
  `is_selected` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `attempt_question_id` (`attempt_question_id`),
  KEY `option_id` (`option_id`),
  CONSTRAINT `attempt_option_ibfk_1` FOREIGN KEY (`attempt_question_id`) REFERENCES `attempt_question` (`id`),
  CONSTRAINT `attempt_option_ibfk_2` FOREIGN KEY (`option_id`) REFERENCES `options` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attempt_option`
--

LOCK TABLES `attempt_option` WRITE;
/*!40000 ALTER TABLE `attempt_option` DISABLE KEYS */;
INSERT INTO `attempt_option` VALUES (7001,6001,1002,1),(7002,6002,2001,1),(7003,6003,3001,1);
/*!40000 ALTER TABLE `attempt_option` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `attempt_question`
--

DROP TABLE IF EXISTS `attempt_question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `attempt_question` (
  `id` int NOT NULL,
  `attempt_id` int DEFAULT NULL,
  `question_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `attempt_id` (`attempt_id`),
  KEY `question_id` (`question_id`),
  CONSTRAINT `attempt_question_ibfk_1` FOREIGN KEY (`attempt_id`) REFERENCES `attempt` (`id`),
  CONSTRAINT `attempt_question_ibfk_2` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attempt_question`
--

LOCK TABLES `attempt_question` WRITE;
/*!40000 ALTER TABLE `attempt_question` DISABLE KEYS */;
INSERT INTO `attempt_question` VALUES (6001,5001,101),(6002,5001,102),(6003,5001,103);
/*!40000 ALTER TABLE `attempt_question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `department` (
  `dp_id` int NOT NULL,
  `dp_name` varchar(50) NOT NULL,
  PRIMARY KEY (`dp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (1,'HR'),(2,'Engineering');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `em_id` int NOT NULL,
  `em_name` varchar(50) NOT NULL,
  `em_salary` double DEFAULT NULL,
  `em_permanent` tinyint(1) DEFAULT NULL,
  `em_date_of_birth` date DEFAULT NULL,
  `em_dp_id` int DEFAULT NULL,
  PRIMARY KEY (`em_id`),
  KEY `em_dp_id` (`em_dp_id`),
  CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`em_dp_id`) REFERENCES `department` (`dp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (201,'John',50000,1,'1990-01-15',2),(202,'Alice',80000,1,'1992-03-22',1),(203,'Bob',90000,0,'1988-11-02',2),(204,'Charlie',60000,1,'1995-09-10',2);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `options`
--

DROP TABLE IF EXISTS `options`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `options` (
  `id` int NOT NULL,
  `question_id` int DEFAULT NULL,
  `text` varchar(255) DEFAULT NULL,
  `is_correct` tinyint(1) DEFAULT NULL,
  `score` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `question_id` (`question_id`),
  CONSTRAINT `options_ibfk_1` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `options`
--

LOCK TABLES `options` WRITE;
/*!40000 ALTER TABLE `options` DISABLE KEYS */;
INSERT INTO `options` VALUES (1001,101,'.htm',0,0),(1002,101,'.html',1,1),(1003,101,'.xhtml',0,0),(1004,101,'.ht',0,0),(2001,102,'4',0,0),(2002,102,'6',1,1),(2003,102,'3',0,0),(2004,102,'2',0,0),(3001,103,'True',1,1),(3002,103,'False',0,0);
/*!40000 ALTER TABLE `options` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` int NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `cpu` varchar(50) DEFAULT NULL,
  `ram` int DEFAULT NULL,
  `os` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'Dell XPS 13',1200,'Intel i7',16,'Windows'),(2,'MacBook Pro',2200,'Apple M1',16,'macOS'),(3,'HP Pavilion',800,'Intel i5',8,'Windows'),(4,'Lenovo ThinkPad',1500,'Intel i7',32,'Linux'),(5,'Asus Zenbook',1000,'AMD Ryzen 5',16,'Windows');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `question` (
  `id` int NOT NULL,
  `text` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` VALUES (101,'What is the extension of the HTML file?'),(102,'How many levels of heading tags are available in HTML?'),(103,'Does HTML document start with <html> and end with </html>?');
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'John');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-07-04 17:25:08

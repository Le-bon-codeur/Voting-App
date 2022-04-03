-- MySQL dump 10.13  Distrib 8.0.28, for Linux (x86_64)
--
-- Host: localhost    Database: voteit_maindb
-- ------------------------------------------------------
-- Server version	8.0.28-0ubuntu0.20.04.3

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
-- Create users mysql and grant privileges
--

CREATE USER 'administrator_voteit'@'localhost' IDENTIFIED BY 'TheAdminPassword';
GRANT ALL PRIVILEGES ON voteit_maindb.* TO 'administrator_voteit'@'localhost';
FLUSH PRIVILEGES;

CREATE USER 'classic_user_voteit'@'localhost' IDENTIFIED BY 'TheUserPassword';
GRANT SELECT ON voteit_maindb.* TO 'classic_user_voteit'@'localhost';
FLUSH PRIVILEGES;

--
-- Table structure for table `administrators`
--

DROP TABLE IF EXISTS `administrators`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `administrators` (
  `us_id` int DEFAULT NULL,
  `ad_location` varchar(40) DEFAULT NULL,
  KEY `us_id` (`us_id`),
  CONSTRAINT `administrators_ibfk_1` FOREIGN KEY (`us_id`) REFERENCES `users` (`us_id`)
) ENGINE=InnoDB;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrators`
--

LOCK TABLES `administrators` WRITE;
/*!40000 ALTER TABLE `administrators` DISABLE KEYS */;
INSERT INTO `administrators` VALUES (8,'Yvelines'),(12,'Poitou-Charante');
/*!40000 ALTER TABLE `administrators` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `candidates`
--

DROP TABLE IF EXISTS `candidates`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `candidates` (
  `us_id` int DEFAULT NULL,
  `ca_id` int NOT NULL AUTO_INCREMENT,
  `ca_politic_party` varchar(40) DEFAULT NULL,
  `ca_description` text,
  PRIMARY KEY (`ca_id`),
  KEY `us_id` (`us_id`),
  CONSTRAINT `candidates_ibfk_1` FOREIGN KEY (`us_id`) REFERENCES `users` (`us_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `candidates`
--

LOCK TABLES `candidates` WRITE;
/*!40000 ALTER TABLE `candidates` DISABLE KEYS */;
INSERT INTO `candidates` VALUES (6,1,'En Marche','Ceci est la description de manu macron'),(7,2,'Les Repu','Ceci est la description de marine lepen'),(10,3,'La Gauche','Ceci est la description de jean luc. Actuellement il est entrain de faire un tiktok car il est très connecté'),(11,4,'L\'extreme Dr','Ceci est la description de zemour, et oui il n\'est plus chroniqueur si vous vous demandiez.');
/*!40000 ALTER TABLE `candidates` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `citizens`
--

DROP TABLE IF EXISTS `citizens`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `citizens` (
  `us_id` int DEFAULT NULL,
  `ci_vote_id` int NOT NULL,
  `ci_vote_nbr` int DEFAULT NULL,
  PRIMARY KEY (`ci_vote_id`),
  KEY `us_id` (`us_id`),
  CONSTRAINT `citizens_ibfk_1` FOREIGN KEY (`us_id`) REFERENCES `users` (`us_id`)
) ENGINE=InnoDB;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `citizens`
--

LOCK TABLES `citizens` WRITE;
/*!40000 ALTER TABLE `citizens` DISABLE KEYS */;
INSERT INTO `citizens` VALUES (1,1001,0),(2,1002,0),(3,1003,0),(4,1004,0),(5,1005,0),(9,1010,0),(3333,1011,0),(666,1012,0),(123,1013,0);
/*!40000 ALTER TABLE `citizens` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `us_id` int NOT NULL AUTO_INCREMENT,
  `us_hash_pw` varchar(64) DEFAULT NULL,
  `us_f_name` varchar(30) DEFAULT NULL,
  `us_l_name` varchar(30) DEFAULT NULL,
  `us_gender` varchar(1) DEFAULT NULL,
  `us_location` varchar(40) DEFAULT NULL,
  `us_date_of_birth` date DEFAULT NULL,
  PRIMARY KEY (`us_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3334;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'defaultpw','Lapilote','lucien','b','Yvelines','2001-05-24'),(2,'defaultpw','Grognion','julie','b','Yvelines','2001-05-24'),(3,'defaultpw','Wohan','stephanie','b','Yvelines','2001-05-24'),(4,'defaultpw','Segado','jeanpierre','b','Yvelines','2001-05-24'),(5,'defaultpw','Hina','manolo','b','Yvelines','2001-05-24'),(6,'defaultpw','Macron','manu','b','Yvelines','2001-05-24'),(7,'defaultpw','Lepen','marine','b','Yvelines','2001-05-24'),(8,'defaultpw','Duval','beatrice','b','Yvelines','2001-05-24'),(9,'3af5b80571f7108f640a72535fc86b0359146d8ca2c1cb922772e735c05d5884','Letoq','Pilou','b','Yvelines','2001-05-24'),(10,'defaultpw','Melanchon','Jean-Luc','b','La Molette','2001-05-24'),(11,'defaultpw','Zémour','Eric','b','Essone','2001-05-24'),(12,'8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918','Delamollet','Maurine','g','Poitou-Charante','2001-05-24'),(123,'a9945f2229546e0bc6e2b6e3601c1d511caeb620bc3e5943ddfc09de050a347e','Tonie','Lalouchette','g','Versailles','2006-03-15'),(666,'3cadc6c1d9e94a5f311fa1b9baa147eb991b39dcef3995ac47fc4cda944d71dd','Anne','Sheit','f','Pary','1970-01-02'),(3333,'8f7617db7820ff2204be6c8524e000375183339ad6721e7e9d8922beb41ff62e','Gralou','TestT','f','LePec','1999-12-12');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `votes`
--

DROP TABLE IF EXISTS `votes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `votes` (
  `ci_vote_id` int DEFAULT NULL,
  `ca_id` int DEFAULT NULL,
  `v_date` date DEFAULT NULL,
  `v_location` varchar(40) DEFAULT NULL,
  KEY `ci_vote_id` (`ci_vote_id`),
  KEY `ca_id` (`ca_id`),
  CONSTRAINT `votes_ibfk_1` FOREIGN KEY (`ci_vote_id`) REFERENCES `citizens` (`ci_vote_id`),
  CONSTRAINT `votes_ibfk_2` FOREIGN KEY (`ca_id`) REFERENCES `candidates` (`ca_id`)
) ENGINE=InnoDB;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `votes`
--

LOCK TABLES `votes` WRITE;
/*!40000 ALTER TABLE `votes` DISABLE KEYS */;
INSERT INTO `votes` VALUES (1003,2,'2010-12-12','nope'),(1010,3,'2022-03-17','Yvelines'),(1001,1,'2010-12-12','Yvelines'),(1002,2,'2010-12-12','Yvelines'),(1003,3,'2010-12-12','Normandie'),(1004,4,'2010-12-12','Yvelines'),(1005,1,'2010-12-12','Normandie'),(1001,2,'2010-12-12','Pas-De-Calais'),(1002,3,'2010-12-12','Yvelines'),(1003,4,'2010-12-12','Bretagne'),(1004,1,'2010-12-12','Yvelines'),(1005,1,'2010-12-12','Yvelines'),(1001,1,'2010-12-12','Yvelines'),(1002,3,'2010-12-12','Bretage'),(1011,4,'2022-03-28','LePec'),(1012,1,'2022-03-28','Pary');
/*!40000 ALTER TABLE `votes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

--
-- grant privileges for classic user
--

GRANT INSERT ON voteit_maindb.votes TO 'classic_user_voteit'@'localhost';
FLUSH PRIVILEGES;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-03  8:51:57

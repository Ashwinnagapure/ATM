-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: team-alpha-air-transport-management.d.aivencloud.com    Database: atm
-- ------------------------------------------------------
-- Server version	8.0.30

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;
SET @@SESSION.SQL_LOG_BIN= 0;

--
-- GTID state at the beginning of the backup 
--

SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ 'b6affc80-c418-11ef-8731-d2888bc8e67b:1-179';

--
-- Table structure for table `baggage`
--

DROP TABLE IF EXISTS `baggage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `baggage` (
  `baggage_id` bigint NOT NULL AUTO_INCREMENT,
  `baggage_limit` bit(1) NOT NULL,
  `luggage_count` int NOT NULL,
  `weight` double DEFAULT NULL,
  `booking_id` bigint NOT NULL,
  `feedback` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`baggage_id`),
  KEY `FK4t9ynwhq2qjbalv55uq8yhyw1` (`booking_id`),
  CONSTRAINT `FK4t9ynwhq2qjbalv55uq8yhyw1` FOREIGN KEY (`booking_id`) REFERENCES `booking` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `baggage`
--

LOCK TABLES `baggage` WRITE;
/*!40000 ALTER TABLE `baggage` DISABLE KEYS */;
INSERT INTO `baggage` VALUES (1,_binary '',2,20.5,7,'{\r\n    \"feedback\": \"My baggage was lost during transit. Please assist.\"\r\n}\r\n'),(2,_binary '',2,20.5,8,NULL),(3,_binary '',2,20.5,9,NULL),(4,_binary '',2,20.5,9,NULL),(5,_binary '',2,20.5,7,NULL);
/*!40000 ALTER TABLE `baggage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `booking_date` datetime(6) DEFAULT NULL,
  `flight_number` varchar(255) DEFAULT NULL,
  `passenger_name` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `travel_date` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
INSERT INTO `booking` VALUES (7,'2024-12-30 10:00:00.000000','AM001','Amar','CONFIRMED','2024-12-31 15:00:00.000000'),(8,'2024-12-29 09:30:00.000000','AS002','Ashwin','PENDING','2024-12-31 14:00:00.000000'),(9,'2024-12-28 12:45:00.000000','JA003','Janvi','PENDING','2024-12-30 17:20:00.000000'),(10,'2024-12-27 08:15:00.000000','SA004','Saransh','PENDING','2024-12-29 18:00:00.000000'),(11,'2024-12-30 11:00:00.000000','AY005','Ayush','PENDING','2024-12-31 16:30:00.000000'),(12,'2024-12-30 00:00:00.000000','AI202','John Doe','CONFIRMED','2024-12-31 00:00:00.000000');
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `crew_management`
--

DROP TABLE IF EXISTS `crew_management`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `crew_management` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `availability` bit(1) NOT NULL,
  `name` varchar(255) NOT NULL,
  `role` enum('CABIN_CREW','GROUND_STAFF','PILOT') NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crew_management`
--

LOCK TABLES `crew_management` WRITE;
/*!40000 ALTER TABLE `crew_management` DISABLE KEYS */;
INSERT INTO `crew_management` VALUES (1,_binary '','Amarbirsingh Randhawa','PILOT'),(2,_binary '','Ashwin Nagapure','PILOT'),(3,_binary '','Janavi Jadhav','CABIN_CREW'),(5,_binary '','Aayush Meshram','CABIN_CREW'),(7,_binary '','Saransh Bhole','PILOT');
/*!40000 ALTER TABLE `crew_management` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flight`
--

DROP TABLE IF EXISTS `flight`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flight` (
  `flight_id` bigint NOT NULL AUTO_INCREMENT,
  `airline` varchar(255) DEFAULT NULL,
  `arrival` datetime(6) DEFAULT NULL,
  `departure` datetime(6) DEFAULT NULL,
  `destination` varchar(255) DEFAULT NULL,
  `flight_class` varchar(255) DEFAULT NULL,
  `flight_name` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `source` varchar(255) DEFAULT NULL,
  `status` tinyint DEFAULT NULL,
  PRIMARY KEY (`flight_id`),
  CONSTRAINT `flight_chk_1` CHECK ((`status` between 0 and 2))
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flight`
--

LOCK TABLES `flight` WRITE;
/*!40000 ALTER TABLE `flight` DISABLE KEYS */;
INSERT INTO `flight` VALUES (1,'Airways 1','2024-12-31 12:00:00.000000','2024-12-31 10:00:00.000000','London','Economy','Flight 101',500,'New York',0),(2,'Vistara','2024-12-31 14:00:00.000000','2024-12-30 12:00:00.000000','Pune','Economy','Flight 050',5000,'Mumbai',0),(3,'Indigo','2024-12-31 14:00:00.000000','2024-12-30 12:00:00.000000','Mumbai','Economy','Flight 420',16000,'Pune',0),(4,'Indigo','2024-12-31 14:00:00.000000','2024-12-30 12:00:00.000000','Nagpur','Economy','Flight 120',160,'Pune',0);
/*!40000 ALTER TABLE `flight` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `passengers`
--

DROP TABLE IF EXISTS `passengers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `passengers` (
  `complaint` varchar(255) DEFAULT NULL,
  `id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FKtapoakv3h32s8qnkl0h41c7cl` FOREIGN KEY (`id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `passengers`
--

LOCK TABLES `passengers` WRITE;
/*!40000 ALTER TABLE `passengers` DISABLE KEYS */;
INSERT INTO `passengers` VALUES (' delayed flight issue',1),('  flight attendent arrogant',2);
/*!40000 ALTER TABLE `passengers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment_receipts`
--

DROP TABLE IF EXISTS `payment_receipts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment_receipts` (
  `transaction_id` bigint NOT NULL AUTO_INCREMENT,
  `payment_id` bigint DEFAULT NULL,
  PRIMARY KEY (`transaction_id`),
  UNIQUE KEY `UK50ip0w8r9wb960x3h8vjnwtdd` (`payment_id`),
  CONSTRAINT `FK76tojr3jowlro8ao15tvuotcu` FOREIGN KEY (`payment_id`) REFERENCES `payments` (`payment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment_receipts`
--

LOCK TABLES `payment_receipts` WRITE;
/*!40000 ALTER TABLE `payment_receipts` DISABLE KEYS */;
INSERT INTO `payment_receipts` VALUES (2,1),(4,2),(3,3),(1,4);
/*!40000 ALTER TABLE `payment_receipts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payments`
--

DROP TABLE IF EXISTS `payments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payments` (
  `payment_id` bigint NOT NULL AUTO_INCREMENT,
  `amount` double NOT NULL,
  `payment_date` date DEFAULT NULL,
  `payment_method` enum('CREDIT_CARD','DEBIT_CARD','NET_BANKING','PAYPAL') DEFAULT NULL,
  `payment_status` enum('FAILED','PENDING','REFUNDED','SUCCESS') DEFAULT NULL,
  PRIMARY KEY (`payment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payments`
--

LOCK TABLES `payments` WRITE;
/*!40000 ALTER TABLE `payments` DISABLE KEYS */;
INSERT INTO `payments` VALUES (1,100.5,'2024-12-28','CREDIT_CARD','PENDING'),(2,1000,'2024-12-27','PAYPAL','SUCCESS'),(3,500,'2024-12-28','NET_BANKING','FAILED'),(4,2000,'2024-12-25','NET_BANKING','SUCCESS'),(5,500,'2024-12-28','CREDIT_CARD','PENDING'),(6,100,'2024-12-30','CREDIT_CARD','PENDING'),(7,5000,'2024-12-30','NET_BANKING','FAILED');
/*!40000 ALTER TABLE `payments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `travel_preferences`
--

DROP TABLE IF EXISTS `travel_preferences`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `travel_preferences` (
  `travel_preference_id` bigint NOT NULL AUTO_INCREMENT,
  `airline_preference` enum('AIR_INDIA','EMIRATES','INDIGO','QATAR_AIRWAYS','SPICEJET') DEFAULT NULL,
  `arrival_time` enum('AFTERNOON','EVENING','MORNING','NIGHT') DEFAULT NULL,
  `departure_time` enum('AFTERNOON','EVENING','MORNING','NIGHT') DEFAULT NULL,
  `meal_preference` enum('DIABETIC','GLUTEN_FREE','LOW_SODIUM','NON_VEGETARIAN','VEGAN','VEGETARIAN') DEFAULT NULL,
  `travel_class` enum('BUSINESS','ECONOMY','FIRST_CLASS','PREMIUM_ECONOMY') DEFAULT NULL,
  `user_id` bigint NOT NULL,
  PRIMARY KEY (`travel_preference_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `travel_preferences`
--

LOCK TABLES `travel_preferences` WRITE;
/*!40000 ALTER TABLE `travel_preferences` DISABLE KEYS */;
INSERT INTO `travel_preferences` VALUES (1,'AIR_INDIA','MORNING','AFTERNOON','VEGETARIAN','ECONOMY',1);
/*!40000 ALTER TABLE `travel_preferences` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `user_type` enum('ADMIN','PASSENGER') DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'john.doe@example.com','newPassword456','PASSENGER','john_doe'),(2,'ash@example.com','ash456','PASSENGER','ash');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-31  0:44:12

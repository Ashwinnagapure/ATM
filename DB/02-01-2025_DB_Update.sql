-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: pro
-- ------------------------------------------------------
-- Server version	8.1.0

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

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FKqer4e53tfnl17s22ior7fcsv8` FOREIGN KEY (`id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (6),(7),(11);
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `baggage`
--

DROP TABLE IF EXISTS `baggage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `baggage` (
  `baggage_id` bigint NOT NULL AUTO_INCREMENT,
  `baggage_limit` bit(1) NOT NULL,
  `feedback` varchar(1000) DEFAULT NULL,
  `luggage_count` int NOT NULL,
  `weight` double NOT NULL,
  `booking_id` bigint NOT NULL,
  PRIMARY KEY (`baggage_id`),
  KEY `FK4t9ynwhq2qjbalv55uq8yhyw1` (`booking_id`),
  CONSTRAINT `FK4t9ynwhq2qjbalv55uq8yhyw1` FOREIGN KEY (`booking_id`) REFERENCES `booking` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `baggage`
--

LOCK TABLES `baggage` WRITE;
/*!40000 ALTER TABLE `baggage` DISABLE KEYS */;
/*!40000 ALTER TABLE `baggage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `boarding_pass`
--

DROP TABLE IF EXISTS `boarding_pass`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `boarding_pass` (
  `boarding_pass_id` bigint NOT NULL AUTO_INCREMENT,
  `boarding_date` varchar(255) DEFAULT NULL,
  `boarding_gate` varchar(255) DEFAULT NULL,
  `boarding_time` varchar(255) DEFAULT NULL,
  `seat` varchar(255) DEFAULT NULL,
  `payment_id` bigint NOT NULL,
  PRIMARY KEY (`boarding_pass_id`),
  UNIQUE KEY `UKl632bpqedite5d54n0a52vc02` (`payment_id`),
  CONSTRAINT `FK935tiqpowr4rivggjhj5ux1wy` FOREIGN KEY (`payment_id`) REFERENCES `payments` (`payment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boarding_pass`
--

LOCK TABLES `boarding_pass` WRITE;
/*!40000 ALTER TABLE `boarding_pass` DISABLE KEYS */;
/*!40000 ALTER TABLE `boarding_pass` ENABLE KEYS */;
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
  `status` varchar(255) DEFAULT NULL,
  `travel_date` datetime(6) DEFAULT NULL,
  `charter_id` bigint DEFAULT NULL,
  `flight_id` bigint NOT NULL,
  `passenger_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKja3bp3ekq7h247a2aqyigafjj` (`flight_id`),
  UNIQUE KEY `UKldy8ei8ws7vurs9aolsw1iiq1` (`charter_id`),
  KEY `FK6diagj5g1i57rnn5o2sgmcy9x` (`passenger_id`),
  CONSTRAINT `FK546eybei9q7dsna94vryofrbr` FOREIGN KEY (`flight_id`) REFERENCES `flight` (`flight_id`),
  CONSTRAINT `FK6diagj5g1i57rnn5o2sgmcy9x` FOREIGN KEY (`passenger_id`) REFERENCES `passengers` (`id`),
  CONSTRAINT `FKcf37sixk7yv70j5nvs54bdhpm` FOREIGN KEY (`charter_id`) REFERENCES `charters` (`charter_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `charters`
--

DROP TABLE IF EXISTS `charters`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `charters` (
  `charter_id` bigint NOT NULL AUTO_INCREMENT,
  `arrival` datetime(6) DEFAULT NULL,
  `departure` datetime(6) DEFAULT NULL,
  `destination` varchar(255) DEFAULT NULL,
  `source` varchar(255) DEFAULT NULL,
  `status` enum('CANCELLED','DELAYED','ON_TIME') DEFAULT NULL,
  `vehicle_type` enum('HELICOPTER','PRIVATE_JET') DEFAULT NULL,
  `passenger_id` bigint NOT NULL,
  PRIMARY KEY (`charter_id`),
  KEY `FK78uiykywa0rtn625wp825cmoj` (`passenger_id`),
  CONSTRAINT `FK78uiykywa0rtn625wp825cmoj` FOREIGN KEY (`passenger_id`) REFERENCES `passengers` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `charters`
--

LOCK TABLES `charters` WRITE;
/*!40000 ALTER TABLE `charters` DISABLE KEYS */;
INSERT INTO `charters` VALUES (1,'2025-01-10 14:00:00.000000','2025-01-10 10:00:00.000000','Los Angeles','New York','DELAYED','PRIVATE_JET',15);
/*!40000 ALTER TABLE `charters` ENABLE KEYS */;
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
  `admin_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4jh9dietd4v3yq46w9rdr1agu` (`admin_id`),
  CONSTRAINT `FK4jh9dietd4v3yq46w9rdr1agu` FOREIGN KEY (`admin_id`) REFERENCES `admin` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crew_management`
--

LOCK TABLES `crew_management` WRITE;
/*!40000 ALTER TABLE `crew_management` DISABLE KEYS */;
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
  `admin_id` bigint NOT NULL,
  PRIMARY KEY (`flight_id`),
  KEY `FKmqi7k7n42myf2r6qcs2emh5dx` (`admin_id`),
  CONSTRAINT `FKmqi7k7n42myf2r6qcs2emh5dx` FOREIGN KEY (`admin_id`) REFERENCES `admin` (`id`),
  CONSTRAINT `flight_chk_1` CHECK ((`status` between 0 and 2))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flight`
--

LOCK TABLES `flight` WRITE;
/*!40000 ALTER TABLE `flight` DISABLE KEYS */;
/*!40000 ALTER TABLE `flight` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notification`
--

DROP TABLE IF EXISTS `notification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notification` (
  `notification_id` bigint NOT NULL AUTO_INCREMENT,
  `message` varchar(255) DEFAULT NULL,
  `recipient_id` bigint DEFAULT NULL,
  `admin_id` bigint NOT NULL,
  `passenger_id` bigint NOT NULL,
  PRIMARY KEY (`notification_id`),
  KEY `FK1ba0xmnpirxklxp7ggdnmhs3y` (`admin_id`),
  KEY `FK5f3rs0s581l0llmh6kttqxfsr` (`passenger_id`),
  CONSTRAINT `FK1ba0xmnpirxklxp7ggdnmhs3y` FOREIGN KEY (`admin_id`) REFERENCES `admin` (`id`),
  CONSTRAINT `FK5f3rs0s581l0llmh6kttqxfsr` FOREIGN KEY (`passenger_id`) REFERENCES `passengers` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notification`
--

LOCK TABLES `notification` WRITE;
/*!40000 ALTER TABLE `notification` DISABLE KEYS */;
/*!40000 ALTER TABLE `notification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `passenger_flights`
--

DROP TABLE IF EXISTS `passenger_flights`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `passenger_flights` (
  `passenger_id` bigint NOT NULL,
  `flight_id` bigint NOT NULL,
  KEY `FKsamt4q6ha57nivfklc2yk80wf` (`flight_id`),
  KEY `FKahqlqlassunon4n44x26gwfa4` (`passenger_id`),
  CONSTRAINT `FKahqlqlassunon4n44x26gwfa4` FOREIGN KEY (`passenger_id`) REFERENCES `passengers` (`id`),
  CONSTRAINT `FKsamt4q6ha57nivfklc2yk80wf` FOREIGN KEY (`flight_id`) REFERENCES `flight` (`flight_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `passenger_flights`
--

LOCK TABLES `passenger_flights` WRITE;
/*!40000 ALTER TABLE `passenger_flights` DISABLE KEYS */;
/*!40000 ALTER TABLE `passenger_flights` ENABLE KEYS */;
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
INSERT INTO `passengers` VALUES (NULL,14),(NULL,15);
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
  `booking_id` bigint DEFAULT NULL,
  `payment_id` bigint DEFAULT NULL,
  PRIMARY KEY (`transaction_id`),
  UNIQUE KEY `UKrxabtx90vhfqca6byc6f4cqig` (`booking_id`),
  UNIQUE KEY `UK50ip0w8r9wb960x3h8vjnwtdd` (`payment_id`),
  CONSTRAINT `FK76tojr3jowlro8ao15tvuotcu` FOREIGN KEY (`payment_id`) REFERENCES `payments` (`payment_id`),
  CONSTRAINT `FKge2srtp5j2c5ov85837eky5x8` FOREIGN KEY (`booking_id`) REFERENCES `booking` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment_receipts`
--

LOCK TABLES `payment_receipts` WRITE;
/*!40000 ALTER TABLE `payment_receipts` DISABLE KEYS */;
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
  `booking_id` bigint DEFAULT NULL,
  PRIMARY KEY (`payment_id`),
  UNIQUE KEY `UKnuscjm6x127hkb15kcb8n56wo` (`booking_id`),
  CONSTRAINT `FK1un2r8jiovdq34iwr8mcr91bo` FOREIGN KEY (`booking_id`) REFERENCES `booking` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payments`
--

LOCK TABLES `payments` WRITE;
/*!40000 ALTER TABLE `payments` DISABLE KEYS */;
/*!40000 ALTER TABLE `payments` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (2,'john.doe@example.com','password123','PASSENGER','john_doe'),(3,'ash.doe@example.com','Ashwin123','ADMIN','john_ash'),(4,'john.doe.updated@example.com','newpassword123','ADMIN','john_doe_updated'),(6,'admin@example.com','adminpass','ADMIN','AdminUser'),(7,'admin@example.com','adminpass','ADMIN','AdminUser'),(8,'admin1@example.com','admin123','ADMIN','Admin1'),(9,'ashwin@example.com','ashwin123','ADMIN','Ashwin'),(11,'ashwin@example.com','ashwin123','ADMIN','Ashwin'),(14,'passenger1@example.com','passengerpassword123','PASSENGER','passenger1'),(15,'john.doe@example.com','password123','PASSENGER','john_doe');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-01-03  2:58:22

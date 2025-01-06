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

SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ 'b6affc80-c418-11ef-8731-d2888bc8e67b:1-1682';

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
INSERT INTO `admin` VALUES (1);
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
  `passenger_id` bigint DEFAULT NULL,
  PRIMARY KEY (`charter_id`),
  KEY `FK78uiykywa0rtn625wp825cmoj` (`passenger_id`),
  CONSTRAINT `FK78uiykywa0rtn625wp825cmoj` FOREIGN KEY (`passenger_id`) REFERENCES `passengers` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `charters`
--

LOCK TABLES `charters` WRITE;
/*!40000 ALTER TABLE `charters` DISABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flight`
--

LOCK TABLES `flight` WRITE;
/*!40000 ALTER TABLE `flight` DISABLE KEYS */;
INSERT INTO `flight` VALUES (1,'Airline H','2025-01-25 12:00:00.000000','2025-01-25 10:00:00.000000','Mumbai','Economy','Flight 108',4000,'Delhi',NULL,1),(2,'Airline I','2025-02-10 16:00:00.000000','2025-02-10 15:00:00.000000','Bangalore','Business','Flight 109',3000,'Chennai',NULL,1),(3,'Airline J','2025-03-05 10:00:00.000000','2025-03-05 08:00:00.000000','Hyderabad','Premium Economy','Flight 110',3500,'Kolkata',NULL,1),(4,'Airline K','2025-01-30 09:45:00.000000','2025-01-30 09:00:00.000000','Pune','Economy','Flight 111',2000,'Mumbai',NULL,1),(5,'Airline S','2025-01-30 09:45:00.000000','2025-01-30 09:00:00.000000','Wardha','Economy','Flight 420',90000,'Samdurapur',NULL,1),(6,'Airline S','2025-01-06 01:54:00.000000','2025-01-06 05:07:00.000000','Nagpur','Economy','Flight 500',53888888,'Nanded',NULL,1),(7,'Airline vedant ','2025-01-06 10:37:00.000000','2025-01-06 10:37:00.000000','Nagpur','Economy','Flight 300',12323123123,'Nanded',NULL,1);
/*!40000 ALTER TABLE `flight` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `logs`
--

DROP TABLE IF EXISTS `logs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `logs` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `message` varchar(255) NOT NULL,
  `timestamp` datetime(6) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `logs`
--

LOCK TABLES `logs` WRITE;
/*!40000 ALTER TABLE `logs` DISABLE KEYS */;
/*!40000 ALTER TABLE `logs` ENABLE KEYS */;
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
  `passenger_id` bigint DEFAULT NULL,
  PRIMARY KEY (`notification_id`),
  KEY `FK1ba0xmnpirxklxp7ggdnmhs3y` (`admin_id`),
  KEY `FK5f3rs0s581l0llmh6kttqxfsr` (`passenger_id`),
  CONSTRAINT `FK1ba0xmnpirxklxp7ggdnmhs3y` FOREIGN KEY (`admin_id`) REFERENCES `admin` (`id`),
  CONSTRAINT `FK5f3rs0s581l0llmh6kttqxfsr` FOREIGN KEY (`passenger_id`) REFERENCES `passengers` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
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
  `id` bigint NOT NULL AUTO_INCREMENT,
  `passenger_id` bigint NOT NULL,
  `flight_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_passenger_flight` (`passenger_id`,`flight_id`),
  KEY `fk_flight` (`flight_id`),
  CONSTRAINT `fk_flight` FOREIGN KEY (`flight_id`) REFERENCES `flight` (`flight_id`) ON DELETE CASCADE,
  CONSTRAINT `fk_passenger` FOREIGN KEY (`passenger_id`) REFERENCES `passengers` (`id`) ON DELETE CASCADE
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
  `passenger_id` bigint NOT NULL,
  `travel_class` enum('BUSINESS','ECONOMY','FIRST_CLASS','PREMIUM_ECONOMY') DEFAULT NULL,
  PRIMARY KEY (`travel_preference_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `travel_preferences`
--

LOCK TABLES `travel_preferences` WRITE;
/*!40000 ALTER TABLE `travel_preferences` DISABLE KEYS */;
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
  `email` varchar(45) NOT NULL,
  `password` varchar(65) NOT NULL,
  `username` varchar(20) NOT NULL,
  `role` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK6dotkott2kjsp8vw4d0m25fb7` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'alpha@gmail.com','alpha','alpha','ADMIN'),(2,'aayush@gmail.com','aayush','aayush','USER'),(3,'saransh@gmail.com','saransh','saransh','USER'),(4,'ashwin@gmail.com','ashwin','ashwin','USER'),(5,'janavi@gmail.com','janavi','janavi','USER'),(6,'amar@gmail.com','amar','amar','USER');
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

-- Dump completed on 2025-01-06 12:42:18

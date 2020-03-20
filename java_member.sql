-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: java
-- ------------------------------------------------------
-- Server version	8.0.18

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
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `member` (
  `name` char(10) DEFAULT NULL,
  `ID` char(20) DEFAULT NULL,
  `password` char(30) DEFAULT NULL,
  `email` char(50) DEFAULT NULL,
  `number` char(13) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES ('박주주','parkjuju','asdf1234!','s2020s12@gmail.com','010-3645-7891'),('황윤아','hwangyouna03','mirim12341234','s2019s40@gmail.com','010-4134-8684'),('김나리','02kim','kim096754','sss142@naver.com','010-9524-7135'),('김지영','mintchoco','mintlove5656!','asdf@gmail.com','010-1234-8584'),('박사랑','happy1209','park1654~','zzz8976@naver.com','010-3498-2398'),('김지유','12kim','jiji34','kim0301@naver.com','010-3428-1357'),('박지후','park1234','park12545!!','park098@daum.net','010-1568-8213'),('최유림','ghkd0546','ch125!','s2019s40@gmail.com','010-9572-3586'),('강지환','ganggang1','gang030718~','kkdhkdk@naver.com','010-2361-7862'),('김수지','kimsu','kimkk2827','djjj32@daum.net','010-7561-4580'),('오정민','8871hq','o1122!','1212gg@daum.net','010-3321-6014'),('하지우','haha00','1298gigi!','65kang@gmail.com','010-7854-1563'),('김기ㄱ김ㅇ윤ㅁ민','s91320','pw91320','s2019s33@mirimpc.co.kr','010-0000-0000'),('2','2','2','2','2'),('오정민','rhddbwkd!!','gkwjddn','.','010-4567-8790');
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-03-09  2:45:29

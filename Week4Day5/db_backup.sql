-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: drivenowdb
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `department` (
  `dept_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`dept_id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (4,'Accounting'),(1,'Finance'),(7,'Human Resources'),(3,'IT'),(5,'Marketing'),(2,'Operations'),(6,'Sales'),(8,'Software Development');
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
  `last_name` varchar(255) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `age` int DEFAULT NULL,
  `dept_id` int DEFAULT NULL,
  `salary` decimal(10,2) DEFAULT NULL,
  `manager_id` int DEFAULT '0',
  PRIMARY KEY (`emp_id`),
  UNIQUE KEY `last_name` (`last_name`,`first_name`),
  KEY `dept_id` (`dept_id`),
  KEY `idx_lastname` (`last_name`),
  CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`dept_id`) REFERENCES `department` (`dept_id`),
  CONSTRAINT `employee_chk_1` CHECK ((`age` >= 18))
) ENGINE=InnoDB AUTO_INCREMENT=992 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'Clossman','Seth',36,8,120000.00,0),(2,'Dylan','Bob',83,7,84000.00,0),(3,'Hankins','Reginald',23,8,120000.00,1),(4,'Blakeman','Dan',39,4,95000.00,0),(5,'Conaway','Willie',46,3,120000.00,0),(6,'James','Calvin',47,7,84000.00,0),(7,'Lloyd','Tyler',50,1,110000.00,0),(8,'Oatway','Amelia',44,1,110000.00,0),(9,'Farmer','Nate',27,6,50000.00,157),(10,'Bentley','Kurt',59,3,120000.00,0),(11,'Garner','Livia',18,5,70000.00,0),(12,'Dowson','Angel',43,4,95000.00,0),(13,'Adams','Florence',49,6,50000.00,157),(14,'Riley','Lauren',64,4,95000.00,0),(15,'Judd','Faith',18,6,50000.00,157),(16,'Hunter','Noah',33,3,120000.00,0),(17,'Collins','Anabelle',46,4,95000.00,0),(18,'Mcleod','Bart',24,1,110000.00,0),(19,'Ianson','Kieth',24,2,70000.00,0),(20,'Stevens','Ron',35,2,70000.00,0),(21,'Aldridge','Erick',37,2,70000.00,0),(22,'Owens','David',28,2,70000.00,0),(23,'Mason','Freya',27,7,84000.00,0),(24,'Talbot','Matthew',26,3,120000.00,0),(25,'Clifton','Teagan',60,7,84000.00,0),(26,'Gray','Stacy',54,5,70000.00,0),(27,'Archer','Jacqueline',24,3,120000.00,0),(28,'Butler','Alexa',37,4,95000.00,0),(29,'Talbot','Elly',62,5,70000.00,0),(30,'Wild','Eve',28,4,95000.00,0),(31,'Widdows','Rufus',64,1,110000.00,0),(32,'Lindsay','Cedrick',39,2,70000.00,0),(33,'Dempsey','Bryon',43,4,95000.00,0),(34,'Funnell','Elijah',54,1,110000.00,0),(35,'Steer','Johnny',48,1,110000.00,0),(36,'Simpson','Mason',27,5,70000.00,0),(37,'Bailey','Henry',33,7,84000.00,0),(38,'Shields','Meredith',22,2,70000.00,0),(39,'Whittle','Mavis',28,7,84000.00,0),(40,'Windsor','Parker',39,3,120000.00,0),(41,'Funnell','Matt',25,6,50000.00,157),(42,'Gosling','Manuel',62,2,70000.00,0),(43,'Warner','Johnathan',55,1,110000.00,0),(44,'Whitmore','Kieth',48,6,50000.00,157),(45,'Harrington','Penelope',44,2,70000.00,0),(46,'Middleton','Margot',51,5,70000.00,0),(47,'Uttridge','Barry',60,7,84000.00,0),(48,'Robinson','Emma',41,2,70000.00,0),(49,'Purvis','Willow',58,7,84000.00,0),(50,'Rogers','Chuck',25,7,84000.00,0),(51,'Vallins','Owen',51,3,120000.00,0),(52,'West','Chad',59,4,95000.00,0),(53,'Kent','Kenzie',34,3,120000.00,0),(54,'Lowe','Mike',55,5,70000.00,0),(55,'Thatcher','Aiden',38,5,70000.00,0),(56,'Malone','Alan',49,7,84000.00,0),(57,'Stone ','Iris',54,7,84000.00,0),(58,'Mackenzie','Aiden',47,4,95000.00,0),(59,'Blythe','Bart',64,6,50000.00,157),(60,'Tate','Megan',39,2,70000.00,0),(61,'Gallacher','Hank',44,4,95000.00,0),(62,'Mccormick','Jocelyn',23,7,84000.00,0),(63,'Flett','Enoch',18,6,50000.00,157),(64,'Olson','Mina',40,5,70000.00,0),(65,'Stewart','Gwenyth',34,5,70000.00,0),(66,'Gallacher','Emely',44,7,84000.00,0),(67,'Emmott','Enoch',39,5,70000.00,0),(68,'Ralph','Tara',31,1,110000.00,0),(69,'Oakley','Paige',53,4,95000.00,0),(70,'Denton','Rosalie',27,6,50000.00,157),(71,'Vaughn','Beatrice',58,4,95000.00,0),(72,'Sherry','Felicity',60,2,70000.00,0),(73,'Noach','Owen',24,6,50000.00,157),(74,'Butler','Aisha',34,6,50000.00,157),(75,'Booth','Roger',39,2,70000.00,0),(76,'Richardson','Phoebe',60,1,110000.00,0),(77,'Holmes','Dani',52,7,84000.00,0),(78,'Thomson','Daniel',62,1,110000.00,0),(79,'Phillips','Russel',24,7,84000.00,0),(80,'Dwyer','Alan',60,5,70000.00,0),(81,'Harris','Cynthia',34,7,84000.00,0),(82,'Downing','Adalind',45,4,95000.00,0),(83,'Ventura','Eduardo',58,2,70000.00,0),(84,'Rixon','Daniel',27,7,84000.00,0),(85,'Reid','Sylvia',29,4,95000.00,0),(86,'Bell','Anthony',41,7,84000.00,0),(87,'Price','Michelle',27,7,84000.00,0),(88,'Pierce','Davina',52,1,110000.00,0),(89,'Ventura','Carmen',37,7,84000.00,0),(90,'Brown','Naomi',64,5,70000.00,0),(91,'Goldsmith','William',18,4,95000.00,0),(92,'Olivier','Marissa',55,4,95000.00,0),(93,'Walsh','Erick',48,5,70000.00,0),(94,'Harris','Julian',59,2,70000.00,0),(95,'Roscoe','Ethan',20,7,84000.00,0),(96,'Rothwell','Doug',35,4,95000.00,0),(97,'Dickson','Ellen',57,3,120000.00,0),(98,'Watson','Claire',52,4,95000.00,0),(99,'Matthews','Daphne',30,1,110000.00,0),(100,'Overson','Angel',50,6,50000.00,157),(101,'Wilde','Mayleen',56,4,95000.00,0),(102,'Hastings','Ellen',24,4,95000.00,0),(103,'Wilde','Alba',33,3,120000.00,0),(104,'Stevens','Nancy',33,1,110000.00,0),(105,'Nayler','Angela',35,6,50000.00,157),(106,'Purvis','Daniel',63,7,84000.00,0),(107,'Scott','Brad',47,1,110000.00,0),(108,'Ebbs','Marilyn',37,3,120000.00,0),(109,'Latham','Nate',28,3,120000.00,0),(110,'Speed','Judith',61,2,70000.00,0),(111,'Edmonds','Denny',47,5,70000.00,0),(112,'Appleton','Ada',18,6,50000.00,157),(113,'Drummond','Matt',31,7,84000.00,0),(114,'James','Isabel',27,7,84000.00,0),(115,'Reid','Michael',59,4,95000.00,0),(116,'Simpson','Stephanie',18,1,110000.00,0),(117,'Reese','Wendy',53,7,84000.00,0),(118,'Wilson','Margaret',64,1,110000.00,0),(119,'Seymour','Cherish',44,1,110000.00,0),(120,'Wren','Gina',31,6,50000.00,157),(121,'Robertson','Martin',21,6,50000.00,157),(122,'Preston','Nick',25,5,70000.00,0),(123,'Hilton','Jaylene',60,6,50000.00,157),(124,'Carpenter','Sasha',36,6,50000.00,157),(125,'Yates','Russel',27,1,110000.00,0),(126,'Vane','Ramon',55,7,84000.00,0),(127,'Whatson','Rowan',26,6,50000.00,157),(128,'Bloom','Carter',61,6,50000.00,157),(129,'Gallacher','Elise',36,6,50000.00,157),(130,'Allwood','Sebastian',52,4,95000.00,0),(131,'Veale','Carmella',38,4,95000.00,0),(132,'Flynn','Leanne',18,4,95000.00,0),(133,'Archer','Ron',27,5,70000.00,0),(134,'Addley','Carl',22,7,84000.00,0),(135,'Norman','Bryon',48,5,70000.00,0),(136,'Coates','Gil',36,1,110000.00,0),(137,'Rixon','Leroy',31,5,70000.00,0),(138,'Eastwood','Angelique',47,2,70000.00,0),(139,'Wright','Noah',35,3,120000.00,0),(140,'Herbert','Brad',53,3,120000.00,0),(141,'Shields','Marvin',54,7,84000.00,0),(142,'Zaoui','Gabriel',54,1,110000.00,0),(143,'Neal','Rosalie',59,1,110000.00,0),(144,'Burnley','Nina',47,4,95000.00,0),(145,'Thornton','Camila',57,6,50000.00,157),(146,'Stevenson','Anthony',31,3,120000.00,0),(147,'Jacobs','Nicholas',64,5,70000.00,0),(148,'Edwards','Rowan',31,3,120000.00,0),(149,'Johnson','Harmony',43,7,84000.00,0),(150,'Hancock','Agnes',30,3,120000.00,0),(151,'Dixon','Phillip',31,2,70000.00,0),(152,'Hall','Mark',19,1,110000.00,0),(153,'Morris','Lauren',35,6,50000.00,157),(154,'Stevenson','Regina',31,3,120000.00,0),(155,'Driscoll','Barney',27,6,50000.00,157),(156,'Campbell','Anthony',58,2,70000.00,0),(157,'Pope','Isla',59,6,50000.00,0),(158,'Jarvis','Agnes',55,4,95000.00,0),(159,'Rodgers','Nick',25,4,95000.00,0),(160,'Woodley','Vicky',55,6,50000.00,157),(161,'Nash','Dakota',61,6,50000.00,157),(162,'Davies','Chad',44,1,110000.00,0),(163,'Victor','Tyson',58,7,84000.00,0),(164,'Shaw','Manuel',42,2,70000.00,0),(165,'Ainsworth','Daria',57,6,50000.00,157),(166,'Bailey','Iris',50,4,95000.00,0),(167,'Eagle','Chester',24,6,50000.00,157),(168,'Malone','Abdul',21,4,95000.00,0),(169,'Preston','Russel',49,3,120000.00,0),(170,'Rossi','Harry',31,7,84000.00,0),(171,'Simpson','Jacob',48,6,50000.00,157),(172,'Swan','Noah',24,2,70000.00,0),(173,'Vane','Matthew',20,4,95000.00,0),(174,'Kirby','Adela',19,2,70000.00,0),(175,'Hardwick','Mike',20,2,70000.00,0),(176,'Kidd','Logan',39,4,95000.00,0),(177,'Alldridge','Carla',56,1,110000.00,0),(178,'Abbot','Camila',32,6,50000.00,157),(179,'James','Rick',57,6,50000.00,157),(180,'Furnell','Lucas',27,4,95000.00,0),(181,'Flett','Benny',22,6,50000.00,157),(182,'Oakley','Anais',39,6,50000.00,157),(183,'Vane','Alice',50,2,70000.00,0),(184,'Mccall','Eduardo',62,3,120000.00,0),(185,'Mason','Doug',28,6,50000.00,157),(186,'Mcleod','Tom',29,7,84000.00,0),(187,'Wood','Nathan',61,2,70000.00,0),(188,'Nash','George',19,6,50000.00,157),(189,'Payne','Regina',40,4,95000.00,0),(190,'Lynch','Carter',45,2,70000.00,0),(191,'Rees','Rosalyn',57,4,95000.00,0),(192,'Devonport','Ada',33,3,120000.00,0),(193,'Moore','Henry',40,1,110000.00,0),(194,'Middleton','Maya',40,5,70000.00,0),(195,'Gordon','Noah',27,7,84000.00,0),(196,'Marshall','Melinda',49,1,110000.00,0),(197,'Flanders','Freya',64,6,50000.00,157),(198,'Strong','Bob',37,4,95000.00,0),(199,'Boden','Sonya',52,6,50000.00,157),(200,'Carter','Ryan',38,6,50000.00,157),(201,'Welsch','Isabel',64,2,70000.00,0),(202,'Yoman','Alessandra',58,7,84000.00,0),(203,'Egerton','Mason',29,7,84000.00,0),(204,'Yang','Henry',49,4,95000.00,0),(205,'Neville','Aeris',61,2,70000.00,0),(206,'Wilson','Ethan',35,4,95000.00,0),(207,'Horton','Tyler',61,6,50000.00,157),(208,'Milner','Denny',52,1,110000.00,0),(209,'Jackson','Julius',38,4,95000.00,0),(210,'Nash','Kieth',54,3,120000.00,0),(211,'Wheeler','Piper',63,6,50000.00,157),(212,'Donnelly','Clint',51,4,95000.00,0),(213,'Ralph','Vicky',37,7,84000.00,0),(214,'Rigg','Boris',41,2,70000.00,0),(215,'Forth','Bryon',43,2,70000.00,0),(216,'Drummond','Mason',40,6,50000.00,157),(217,'Vinton','Lorraine',64,3,120000.00,0),(218,'Wren','Barney',22,2,70000.00,0),(219,'Simpson','Martin',29,5,70000.00,0),(220,'Stone','Brad',43,3,120000.00,0),(221,'Locke','Aiden',42,1,110000.00,0),(222,'Wade','Summer',51,5,70000.00,0),(223,'Tanner','Angelique',60,2,70000.00,0),(224,'Moran','Noah',20,2,70000.00,0),(225,'Rose','Owen',33,1,110000.00,0),(226,'Farrell','Margot',57,2,70000.00,0),(227,'Dempsey','Tony',25,2,70000.00,0),(228,'Evans','Jackeline',62,3,120000.00,0),(229,'Bayliss','Lara',40,5,70000.00,0),(230,'Mccormick','Mya',62,4,95000.00,0),(231,'Ulyatt','Bristol',34,2,70000.00,0),(232,'Furnell','Chester',38,2,70000.00,0),(233,'Dixon','Kassandra',42,2,70000.00,0),(234,'Heaton','Maria',53,7,84000.00,0),(235,'Vollans','Anthony',51,4,95000.00,0),(236,'Flett','Ethan',47,6,50000.00,157),(237,'Collingwood','Bridget',30,7,84000.00,0),(238,'Chapman','Enoch',62,2,70000.00,0),(239,'Gardner','Victoria',52,6,50000.00,157),(240,'Varndell','Candace',32,1,110000.00,0),(241,'Sherry','Stella',21,2,70000.00,0),(242,'Daniells','Rufus',58,6,50000.00,157),(243,'Chester','Bob',50,7,84000.00,0),(244,'Lucas','Sasha',47,5,70000.00,0),(245,'Tait','Jade',44,5,70000.00,0),(246,'Woods','Barry',59,5,70000.00,0),(247,'Todd','Michaela',42,1,110000.00,0),(248,'Potter','Rhea',21,4,95000.00,0),(249,'Lyon','Noah',23,4,95000.00,0),(250,'Gregory','Sydney',57,1,110000.00,0),(251,'Holmes','Lexi',51,1,110000.00,0),(252,'Haines','Domenic',36,4,95000.00,0),(253,'Rose','Rick',25,5,70000.00,0),(254,'Lyon','Matt',44,2,70000.00,0),(255,'Graham','Maxwell',25,7,84000.00,0),(256,'Gates','Erick',19,4,95000.00,0),(257,'Paterson','Jacob',58,6,50000.00,157),(258,'Pitt','Rylee',36,4,95000.00,0),(259,'Lindop','Georgia',46,4,95000.00,0),(260,'Nelson','Matthew',41,3,120000.00,0),(261,'Rowlands','Hank',46,7,84000.00,0),(262,'Connor','Henry',55,2,70000.00,0),(263,'Simpson','Chadwick',61,6,50000.00,157),(264,'Edwards','Beatrice',38,3,120000.00,0),(265,'Williams','Danielle',22,2,70000.00,0),(266,'Taylor','Maribel',50,7,84000.00,0),(267,'Cattell','Joyce',50,3,120000.00,0),(268,'Osmond','Shelby',58,4,95000.00,0),(269,'Herbert','Denny',23,6,50000.00,157),(270,'Baker','Angelina',56,1,110000.00,0),(271,'Yates','Dani',27,3,120000.00,0),(272,'Parsons','Roger',34,3,120000.00,0),(273,'Alldridge','Mina',57,7,84000.00,0),(274,'Higgs','Caydence',44,2,70000.00,0),(275,'Pearson','Vicky',18,5,70000.00,0),(276,'Reid','Rufus',30,2,70000.00,0),(277,'Hale','Mavis',45,3,120000.00,0),(278,'Saunders','David',34,2,70000.00,0),(279,'Wilton','Francesca',42,2,70000.00,0),(280,'Bingham','Clint',26,4,95000.00,0),(281,'Keys','Alexia',47,2,70000.00,0),(282,'Carson','Sloane',41,4,95000.00,0),(283,'Dobson','Harvey',26,5,70000.00,0),(284,'Janes','Erick',42,3,120000.00,0),(285,'Giles','Carmen',32,1,110000.00,0),(286,'Burge','Jacob',58,2,70000.00,0),(287,'Huggins','Aisha',54,5,70000.00,0),(288,'Spencer','Leah',32,2,70000.00,0),(289,'Stevens','Harry',58,6,50000.00,157),(290,'Walker','Alan',56,2,70000.00,0),(291,'Miller','Chuck',56,1,110000.00,0),(292,'Chadwick','Josh',45,6,50000.00,157),(293,'Vaughan','Leanne',31,3,120000.00,0),(294,'Irving','Estrella',39,3,120000.00,0),(295,'Goldsmith','Melinda',31,5,70000.00,0),(296,'Warren','Russel',42,6,50000.00,157),(297,'Waterson','Scarlett',50,1,110000.00,0),(298,'Ross','Clint',47,6,50000.00,157),(299,'Bennett','Carrie',41,3,120000.00,0),(300,'Little','Ciara',41,3,120000.00,0),(301,'Cameron','Amy',37,2,70000.00,0),(302,'Thomas','Julius',26,4,95000.00,0),(303,'Stark','Denny',53,7,84000.00,0),(304,'Wilson','Joseph',27,2,70000.00,0),(305,'Lewis','Domenic',52,1,110000.00,0),(306,'Lee','Wendy',64,3,120000.00,0),(307,'Price','Tom',24,2,70000.00,0),(308,'Tailor','Marvin',39,2,70000.00,0),(309,'Darcy','Penny',25,5,70000.00,0),(310,'Broomfield','Harvey',45,2,70000.00,0),(311,'Roberts','Carissa',32,2,70000.00,0),(312,'Hepburn','Zoe',30,4,95000.00,0),(313,'Edmonds','Julius',54,1,110000.00,0),(314,'Townend','Wade',41,5,70000.00,0),(315,'Irwin','Daron',19,4,95000.00,0),(316,'Oakley','Lexi',22,4,95000.00,0),(317,'Mitchell','Luke',51,1,110000.00,0),(318,'Partridge','Benjamin',64,6,50000.00,157),(319,'Wright','Bree',61,7,84000.00,0),(320,'Stewart','Ryan',22,1,110000.00,0),(321,'Fleming','Janice',63,3,120000.00,0),(322,'Nicholls','Roger',57,3,120000.00,0),(323,'Tyrrell','Brooklyn',56,5,70000.00,0),(324,'Verdon','Chuck',48,1,110000.00,0),(325,'Dann','Fiona',54,4,95000.00,0),(326,'Waterson','Nina',25,2,70000.00,0),(327,'Logan','Bridget',63,3,120000.00,0),(328,'King','Chad',32,5,70000.00,0),(329,'Gavin','Mike',47,1,110000.00,0),(330,'Lowe','Tyler',29,3,120000.00,0),(331,'Whinter','Celia',63,1,110000.00,0),(332,'Chappell','Michael',43,5,70000.00,0),(333,'May','Helen',46,3,120000.00,0),(334,'Forester','Maggie',39,3,120000.00,0),(335,'Hunter','Marla',20,3,120000.00,0),(336,'Booth','Oliver',54,2,70000.00,0),(337,'Carson','Rachael',52,1,110000.00,0),(338,'Vinton','Ethan',58,3,120000.00,0),(339,'Morrison','Mabel',50,1,110000.00,0),(340,'Murphy','Gwen',32,4,95000.00,0),(341,'Johnson','Rae',56,4,95000.00,0),(342,'Alldridge','Manuel',45,4,95000.00,0),(343,'Irwin','Enoch',35,1,110000.00,0),(344,'Trent','Celina',45,1,110000.00,0),(345,'Shaw','Percy',25,5,70000.00,0),(346,'Vane','Elle',20,4,95000.00,0),(347,'Brett','Jayden',33,5,70000.00,0),(348,'Wright','Daron',31,4,95000.00,0),(349,'Andrews','Harry',37,4,95000.00,0),(350,'Harrison','Clint',48,2,70000.00,0),(351,'Vangness','Harry',29,2,70000.00,0),(352,'Lewis','Makena',29,4,95000.00,0),(353,'Fall','Erick',24,2,70000.00,0),(354,'Mccormick','Russel',51,5,70000.00,0),(355,'Shepherd','Cedrick',23,7,84000.00,0),(356,'Dann','Adelaide',51,4,95000.00,0),(357,'Martin','Johnny',54,2,70000.00,0),(358,'Brown','Angelique',25,6,50000.00,157),(359,'Norris','Deborah',57,5,70000.00,0),(360,'Rossi','Nick',27,5,70000.00,0),(361,'Baldwin','Logan',18,6,50000.00,157),(362,'Janes','Allison',31,2,70000.00,0),(363,'Wood','Adelaide',52,5,70000.00,0),(364,'Allwood','Lynn',62,2,70000.00,0),(365,'Farrell','Josephine',61,3,120000.00,0),(366,'Talbot','Tyler',43,7,84000.00,0),(367,'Khan','Shannon',21,7,84000.00,0),(368,'Penn','Daron',64,3,120000.00,0),(369,'Clark','Joseph',59,7,84000.00,0),(370,'Silva','Nicholas',26,7,84000.00,0),(371,'Norton','Caleb',63,3,120000.00,0),(372,'Yang','Kirsten',49,2,70000.00,0),(373,'Smith','Emma',33,1,110000.00,0),(374,'Holmes','Danielle',54,5,70000.00,0),(375,'Nelson','Bart',47,5,70000.00,0),(376,'Notman','Lorraine',20,4,95000.00,0),(377,'Benson','Liam',47,6,50000.00,157),(378,'Leslie','Jacqueline',54,7,84000.00,0),(379,'Young','Owen',54,6,50000.00,157),(380,'Richardson','Mona',59,4,95000.00,0),(381,'Andersson','Caleb',45,5,70000.00,0),(382,'Randall','Jackeline',34,7,84000.00,0),(383,'Hamilton','Rocco',27,6,50000.00,157),(384,'Woods','Jayden',42,3,120000.00,0),(385,'Gavin','Paula',61,7,84000.00,0),(386,'Ballard','Leroy',60,2,70000.00,0),(387,'Coates','Caleb',42,4,95000.00,0),(388,'Woodcock','Jayden',18,2,70000.00,0),(389,'Campbell','Hank',58,4,95000.00,0),(390,'Spencer','Marissa',19,2,70000.00,0),(391,'Matthews','Daniel',44,2,70000.00,0),(392,'Rixon','Oliver',46,6,50000.00,157),(393,'Blackburn','Ramon',21,5,70000.00,0),(394,'Thomson','Daron',51,6,50000.00,157),(395,'Johnson','Monica',34,2,70000.00,0),(396,'Mason','Wendy',38,4,95000.00,0),(397,'Hobbs','Alexa',52,3,120000.00,0),(398,'Wheeler','Nancy',34,7,84000.00,0),(399,'Doherty','Carol',26,3,120000.00,0),(400,'Fall','Kendra',29,3,120000.00,0),(401,'Judd','Winnie',26,1,110000.00,0),(402,'Roberts','Benny',37,7,84000.00,0),(403,'Weldon','Chester',26,6,50000.00,157),(404,'Power','Sebastian',50,1,110000.00,0),(405,'Andrews','Doug',57,5,70000.00,0),(406,'Ellison','Charlotte',64,2,70000.00,0),(407,'Rowlands','Boris',21,3,120000.00,0),(408,'Clifton','William',48,5,70000.00,0),(409,'Pond','Bob',35,4,95000.00,0),(410,'Garcia','Emely',39,1,110000.00,0),(411,'Douglas','Mona',27,5,70000.00,0),(412,'Goodman','Hayden',43,7,84000.00,0),(413,'James','Logan',25,7,84000.00,0),(414,'Horton','Bernadette',54,7,84000.00,0),(416,'Darcy','Carrie',61,7,84000.00,0),(417,'Lane','Javier',58,5,70000.00,0),(418,'Bradley','Aurelia',20,7,84000.00,0),(419,'Briggs','Noah',33,1,110000.00,0),(420,'Woodcock','Caleb',56,3,120000.00,0),(421,'Grady','Havana',61,4,95000.00,0),(422,'Curtis','Johnny',61,3,120000.00,0),(423,'Thompson','Nathan',54,6,50000.00,157),(424,'Ianson','Crystal',51,6,50000.00,157),(425,'Robertson','Rick',58,7,84000.00,0),(426,'Spencer','Logan',51,2,70000.00,0),(427,'Kelly','Raquel',42,6,50000.00,157),(428,'Little','Leroy',36,6,50000.00,157),(429,'Marshall','Javier',49,4,95000.00,0),(430,'Oakley','Marvin',45,2,70000.00,0),(431,'Palmer','Erick',63,1,110000.00,0),(432,'Gray','Destiny',63,4,95000.00,0),(433,'Dixon','Oliver',49,5,70000.00,0),(434,'Mackenzie','Marigold',61,7,84000.00,0),(435,'Exton','Harvey',62,1,110000.00,0),(436,'Tobin','Greta',37,2,70000.00,0),(437,'Emmett','Ronald',38,1,110000.00,0),(438,'Herbert','Mike',39,2,70000.00,0),(439,'Burnley','Jayden',59,1,110000.00,0),(440,'Aldridge','Chris',19,7,84000.00,0),(441,'Vincent','Barry',47,5,70000.00,0),(442,'Ebbs','Jane',60,1,110000.00,0),(443,'Mcleod','Leah',51,3,120000.00,0),(444,'Wallace','Marilyn',46,1,110000.00,0),(445,'Cunningham','Domenic',51,4,95000.00,0),(446,'Stewart','Brooklyn',60,1,110000.00,0),(447,'Yarwood','Noah',40,4,95000.00,0),(448,'Roscoe','Nathan',54,7,84000.00,0),(449,'Vinton','Hannah',38,7,84000.00,0),(450,'Williams','Destiny',46,2,70000.00,0),(451,'Payne','Josh',60,5,70000.00,0),(452,'Young','Rowan',20,6,50000.00,157),(453,'Oswald','Greta',59,5,70000.00,0),(454,'Donnelly','Carmella',27,7,84000.00,0),(455,'Cox','Jacob',51,1,110000.00,0),(456,'Mills','Nancy',56,5,70000.00,0),(457,'Rogan','Bryon',49,6,50000.00,157),(458,'Howard','Ronald',60,7,84000.00,0),(459,'Rees','Johnny',20,3,120000.00,0),(460,'Talbot','Ronald',56,4,95000.00,0),(461,'Norris','Sylvia',46,2,70000.00,0),(462,'Ross','Javier',55,4,95000.00,0),(463,'Ryan','Cynthia',40,3,120000.00,0),(464,'Pitt','Monica',25,6,50000.00,157),(465,'Rogers','Abdul',27,2,70000.00,0),(466,'Rodgers','Nicholas',34,5,70000.00,0),(467,'Mills','Bridget',33,1,110000.00,0),(468,'Kennedy','Fred',41,6,50000.00,157),(469,'May','Barry',38,6,50000.00,157),(470,'Abbey','Denis',52,7,84000.00,0),(471,'Brett','Susan',21,1,110000.00,0),(472,'Flack','Javier',38,3,120000.00,0),(473,'Samuel','Logan',25,5,70000.00,0),(474,'Addley','Nate',34,6,50000.00,157),(475,'Whitehouse','Emerald',36,7,84000.00,0),(476,'Smith','Jennifer',39,7,84000.00,0),(477,'Poulton','Logan',36,3,120000.00,0),(478,'Ripley','Leilani',32,2,70000.00,0),(479,'Stark','Katelyn',25,7,84000.00,0),(480,'Collins','Ally',52,6,50000.00,157),(481,'Mullins','Rufus',63,3,120000.00,0),(482,'Coates','Chad',21,3,120000.00,0),(484,'Willson','Hazel',55,7,84000.00,0),(485,'Curtis','Zoe',25,3,120000.00,0),(486,'Johnson','Oliver',43,1,110000.00,0),(487,'Snow','Rick',47,1,110000.00,0),(488,'Wright','Rick',21,5,70000.00,0),(489,'Hastings','Liv',63,4,95000.00,0),(490,'Yarwood','Raquel',21,1,110000.00,0),(491,'Abbey','Quinn',53,3,120000.00,0),(492,'Logan','Jennifer',48,2,70000.00,0),(493,'Barclay','Marina',18,5,70000.00,0),(494,'Armstrong','Gloria',40,1,110000.00,0),(495,'James','Denny',28,4,95000.00,0),(496,'Jackson','Gil',47,5,70000.00,0),(497,'Allcott','Amelia',37,3,120000.00,0),(498,'Wilkinson','Denis',29,4,95000.00,0),(499,'Isaac','Chuck',58,7,84000.00,0),(500,'Harrington','Rosalee',30,1,110000.00,0),(501,'Whitmore','Monica',20,1,110000.00,0),(502,'Jenkins','Tyler',29,7,84000.00,0),(503,'Harrington','Olivia',18,7,84000.00,0),(504,'Hepburn','Michelle',48,5,70000.00,0),(505,'Smith','Alexander',63,2,70000.00,0),(506,'Collins','Aiden',28,6,50000.00,157),(507,'Edwards','Kurt',41,1,110000.00,0),(508,'Logan','Chris',33,2,70000.00,0),(509,'Umney','Blake',32,3,120000.00,0),(510,'Olivier','Anthony',59,7,84000.00,0),(511,'Myatt','Denny',50,5,70000.00,0),(512,'Strong','Janice',58,3,120000.00,0),(513,'Clifton','Alexander',41,5,70000.00,0),(514,'Curtis','Elijah',62,4,95000.00,0),(515,'Spencer','Gwen',34,5,70000.00,0),(516,'Walter','Joy',49,3,120000.00,0),(517,'Barclay','Chloe',34,1,110000.00,0),(518,'Mackenzie','Margot',57,6,50000.00,157),(519,'Boyle','Rick',62,6,50000.00,157),(520,'Lloyd','Savannah',49,3,120000.00,0),(521,'Shields','Ronald',34,7,84000.00,0),(522,'Long','Aileen',18,1,110000.00,0),(523,'Gordon','Owen',38,3,120000.00,0),(524,'Steer','Jamie',36,7,84000.00,0),(525,'Brooks','Florence',24,7,84000.00,0),(526,'Wren','Rebecca',42,4,95000.00,0),(527,'Stanton','Denis',29,1,110000.00,0),(528,'Spencer','Brad',36,2,70000.00,0),(529,'Simpson','Margot',53,2,70000.00,0),(530,'Plant','Abbey',48,1,110000.00,0),(531,'Stanton','Anne',52,4,95000.00,0),(532,'Duvall','Kimberly',34,7,84000.00,0),(533,'Everett','Rosalyn',40,5,70000.00,0),(534,'Bryant','Molly',38,5,70000.00,0),(535,'Abbot','Aurelia',28,5,70000.00,0),(536,'Herbert','Blake',60,7,84000.00,0),(537,'Mould','Renee',39,4,95000.00,0),(538,'Vollans','Penelope',53,6,50000.00,157),(539,'Clarke','Celia',42,2,70000.00,0),(540,'Sinclair','Rose',24,2,70000.00,0),(541,'Waterhouse','Jules',64,7,84000.00,0),(542,'Payne','Rufus',20,4,95000.00,0),(543,'Ellison','Anthony',40,1,110000.00,0),(544,'Adler','Kieth',19,6,50000.00,157),(545,'Rixon','Owen',47,1,110000.00,0),(546,'Camden','Renee',61,5,70000.00,0),(547,'Rogers','Elise',48,3,120000.00,0),(548,'Saunders','Eden',41,2,70000.00,0),(549,'Shepherd','Bart',26,6,50000.00,157),(550,'Harvey','Chad',39,2,70000.00,0),(551,'Donnelly','Ruth',37,2,70000.00,0),(552,'Nicholls','Percy',61,5,70000.00,0),(553,'Tait','Benny',36,2,70000.00,0),(554,'Roberts','Mara',23,1,110000.00,0),(555,'Forth','Aiden',57,3,120000.00,0),(556,'Woods','Rosalyn',59,7,84000.00,0),(557,'Ripley','Barney',48,2,70000.00,0),(558,'Strong','Makenzie',40,2,70000.00,0),(559,'Watson','Owen',57,7,84000.00,0),(560,'Casey','Owen',19,2,70000.00,0),(561,'Leigh','Aisha',37,4,95000.00,0),(562,'Wade','Mandy',21,3,120000.00,0),(563,'Thompson','Alan',62,2,70000.00,0),(564,'Hunt','Piper',23,2,70000.00,0),(565,'Strong','Rosa',57,2,70000.00,0),(566,'Darcy','Mason',63,7,84000.00,0),(567,'Gonzales','Marissa',49,7,84000.00,0),(568,'Johnson','Cynthia',28,1,110000.00,0),(569,'Martin','Grace',21,5,70000.00,0),(570,'Potts','Danny',46,1,110000.00,0),(571,'Douglas','Kassandra',53,5,70000.00,0),(572,'Weldon','Melinda',26,5,70000.00,0),(573,'Cox','Enoch',27,4,95000.00,0),(574,'Stevenson','George',21,3,120000.00,0),(575,'Eastwood','Cynthia',23,3,120000.00,0),(576,'Horton','Emerald',27,2,70000.00,0),(577,'Bowen','Gina',62,3,120000.00,0),(578,'Ebden','Carol',22,5,70000.00,0),(579,'Wellington','Vera',46,2,70000.00,0),(580,'Tate','Stephanie',45,6,50000.00,157),(581,'Reynolds','Chloe',31,3,120000.00,0),(582,'Donovan','Luke',35,2,70000.00,0),(583,'Strong','Adalind',18,5,70000.00,0),(584,'Smith','Susan',60,4,95000.00,0),(585,'James','Sadie',36,1,110000.00,0),(586,'Adler','Roger',61,7,84000.00,0),(587,'Mason','Macy',37,3,120000.00,0),(588,'Robertson','Enoch',48,7,84000.00,0),(589,'Whatson','Emery',61,4,95000.00,0),(590,'Jenkin','Martha',63,1,110000.00,0),(591,'Rogers','Maria',24,2,70000.00,0),(592,'Whinter','Barry',26,2,70000.00,0),(593,'Owens','Chris',41,2,70000.00,0),(594,'Dale','Josh',48,7,84000.00,0),(595,'Donnelly','Maxwell',19,5,70000.00,0),(596,'Ellis','Caleb',61,6,50000.00,157),(597,'Morris','Britney',56,5,70000.00,0),(598,'Flett','Alison',30,2,70000.00,0),(599,'Waterson','Maribel',36,1,110000.00,0),(600,'Watt','Harvey',53,4,95000.00,0),(601,'Ripley','Manuel',20,2,70000.00,0),(602,'Warner','Melanie',41,3,120000.00,0),(603,'Brennan','Stacy',34,4,95000.00,0),(604,'Cooper','Ron',57,6,50000.00,157),(605,'Ramsey','Rick',39,7,84000.00,0),(606,'Kelly','Eve',61,7,84000.00,0),(607,'Ingham','Emerald',40,3,120000.00,0),(608,'Mills','Gil',48,7,84000.00,0),(609,'Connell','Gemma',59,3,120000.00,0),(610,'Gosling','Sonya',58,4,95000.00,0),(611,'Barclay','Ellen',18,6,50000.00,157),(612,'Hobson','Domenic',23,1,110000.00,0),(613,'Higgs','Noah',43,7,84000.00,0),(614,'Giles','Norah',20,3,120000.00,0),(615,'Tait','Payton',59,6,50000.00,157),(616,'Briggs','Sofia',24,2,70000.00,0),(617,'Bayliss','Brooklyn',38,2,70000.00,0),(618,'Kent','Cristal',52,4,95000.00,0),(619,'Holmes','Adalie',42,2,70000.00,0),(620,'Stark','Ronald',62,7,84000.00,0),(621,'Salt','Hank',45,2,70000.00,0),(622,'Atkinson','Savannah',30,4,95000.00,0),(623,'Carter','Leroy',58,6,50000.00,157),(624,'Paterson','Allison',31,2,70000.00,0),(625,'Kennedy','Alba',44,7,84000.00,0),(626,'Robe','Camila',50,3,120000.00,0),(627,'Owens','Mike',27,1,110000.00,0),(628,'Rogers','Erin',29,4,95000.00,0),(629,'Simmons','Jamie',29,6,50000.00,157),(630,'Wellington','Leilani',55,1,110000.00,0),(631,'Corbett','Sara',54,1,110000.00,0),(632,'Upsdell','Rick',50,6,50000.00,157),(633,'Morris','Makena',62,6,50000.00,157),(634,'Morley','Moira',56,1,110000.00,0),(635,'Talbot','Sonya',53,1,110000.00,0),(636,'Hudson','Melanie',54,5,70000.00,0),(637,'Ward','Johnathan',44,4,95000.00,0),(638,'Fulton','Janelle',22,5,70000.00,0),(639,'Douglas','Esmeralda',38,6,50000.00,157),(640,'Walsh','Jacqueline',36,2,70000.00,0),(641,'Mason','Daria',50,4,95000.00,0),(642,'Ballard','Maggie',50,5,70000.00,0),(643,'Warren','Manuel',21,1,110000.00,0),(644,'Ebbs','Holly',36,2,70000.00,0),(645,'Middleton','Carolyn',29,2,70000.00,0),(646,'Wilde','Erick',62,2,70000.00,0),(647,'Clifton','Hope',42,5,70000.00,0),(648,'Bristow','Wendy',18,1,110000.00,0),(649,'Wills','Johnny',39,3,120000.00,0),(650,'Quinton','Maribel',35,7,84000.00,0),(651,'Burge','Elena',23,1,110000.00,0),(652,'Collins','Matt',40,7,84000.00,0),(653,'Latham','Colleen',43,2,70000.00,0),(654,'Darcy','Bryon',36,7,84000.00,0),(655,'Griffiths','Denis',30,5,70000.00,0),(656,'Grant','Emely',58,2,70000.00,0),(657,'Lloyd','Jack',63,5,70000.00,0),(658,'Morgan','Bryon',37,1,110000.00,0),(659,'Weston','Cassidy',23,3,120000.00,0),(660,'Mcleod','Stephanie',28,7,84000.00,0),(661,'Hunter','Elijah',39,6,50000.00,157),(662,'Holt','Maria',41,3,120000.00,0),(663,'Lyon','Chester',28,2,70000.00,0),(664,'Olivier','Angelique',59,7,84000.00,0),(665,'Farrow','Carter',32,3,120000.00,0),(666,'Adams','Julian',61,7,84000.00,0),(667,'Snow','Jayden',63,6,50000.00,157),(668,'Ballard','Aleksandra',23,5,70000.00,0),(669,'Knight','Clarissa',64,4,95000.00,0),(670,'Gordon','Mark',57,5,70000.00,0),(671,'Martin','Noah',31,7,84000.00,0),(672,'Healy','Irene',20,3,120000.00,0),(673,'Morgan','Carolyn',42,2,70000.00,0),(674,'Hunt','Celina',41,3,120000.00,0),(675,'Turner','Daniel',27,7,84000.00,0),(676,'Blackburn','Eduardo',56,1,110000.00,0),(677,'Jackson','Josh',30,7,84000.00,0),(678,'Curtis','Kieth',64,3,120000.00,0),(679,'Cobb','Eduardo',53,5,70000.00,0),(680,'Yates','Adalind',57,1,110000.00,0),(681,'Mills','Hayden',40,6,50000.00,157),(682,'Stuart','Olivia',33,6,50000.00,157),(683,'Tanner','Rhea',19,3,120000.00,0),(684,'Rixon','Johnathan',43,2,70000.00,0),(685,'Hobson','Elijah',27,2,70000.00,0),(686,'Hunter','Rylee',43,4,95000.00,0),(687,'Simpson','Aurelia',51,4,95000.00,0),(688,'Faulkner','Lucas',38,5,70000.00,0),(689,'Irving','Ivy',27,2,70000.00,0),(690,'Clayton','Karen',36,2,70000.00,0),(691,'Hewitt','Abdul',45,1,110000.00,0),(692,'Gilmour','Harry',29,7,84000.00,0),(693,'Hunt','Javier',53,3,120000.00,0),(694,'Whitmore','Freya',43,5,70000.00,0),(695,'Whittle','Leroy',59,6,50000.00,157),(696,'Swift','Wendy',18,7,84000.00,0),(697,'Clarke','Abdul',30,6,50000.00,157),(698,'Booth','Aiden',48,6,50000.00,157),(699,'Blackburn','Marilyn',40,1,110000.00,0),(700,'Parsons','Bethany',59,1,110000.00,0),(701,'Butler','Denny',51,6,50000.00,157),(702,'Moore','Liam',52,5,70000.00,0),(703,'Blythe','Ryan',31,1,110000.00,0),(704,'James','Daniel',60,7,84000.00,0),(705,'Marshall','Danny',53,1,110000.00,0),(706,'King','Enoch',58,6,50000.00,157),(707,'Wilson','David',64,4,95000.00,0),(708,'Darcy','Tyler',39,4,95000.00,0),(709,'Vince','Emerald',19,3,120000.00,0),(710,'Knight','Liam',40,2,70000.00,0),(711,'Butler','Ronald',62,1,110000.00,0),(712,'Ingram','Teagan',45,5,70000.00,0),(713,'Pickard','Agnes',64,5,70000.00,0),(714,'Cooper','Madelyn',57,5,70000.00,0),(715,'Knight','Russel',40,3,120000.00,0),(716,'Mccormick','Julius',39,5,70000.00,0),(717,'Edler','Emery',48,2,70000.00,0),(718,'Brennan','Cara',60,2,70000.00,0),(719,'Dempsey','Allison',58,1,110000.00,0),(720,'Talbot','Mike',35,1,110000.00,0),(721,'Robertson','Andie',60,6,50000.00,157),(722,'Niles','Maya',45,4,95000.00,0),(723,'Nobbs','Chester',62,1,110000.00,0),(724,'Garcia','Jacob',54,2,70000.00,0),(725,'Tanner','Ron',47,7,84000.00,0),(727,'Heaton','Daron',36,2,70000.00,0),(728,'Mullins','Lucas',56,2,70000.00,0),(729,'Garcia','Benny',36,4,95000.00,0),(730,'Phillips','Amelia',53,1,110000.00,0),(731,'Jarrett','Marie',26,1,110000.00,0),(732,'Thomas','Luke',61,3,120000.00,0),(733,'Vaughan','Camden',54,2,70000.00,0),(734,'Hooper','Abdul',53,6,50000.00,157),(735,'Quinn','George',47,6,50000.00,157),(736,'Emmott','Monica',24,4,95000.00,0),(737,'Owen','Alexander',29,1,110000.00,0),(738,'Vane','Kendra',32,5,70000.00,0),(739,'Wise','Rowan',41,1,110000.00,0),(740,'Buckley','Drew',25,4,95000.00,0),(741,'Preston','Enoch',19,2,70000.00,0),(742,'Warner','Mina',34,6,50000.00,157),(743,'Crawford','Adela',36,4,95000.00,0),(744,'Lewin','Greta',54,7,84000.00,0),(745,'Heaton','Hope',25,6,50000.00,157),(746,'Sloan','Alison',42,7,84000.00,0),(747,'Whitehouse','Livia',48,7,84000.00,0),(748,'Harris','Erick',64,4,95000.00,0),(749,'Morley','Joseph',41,2,70000.00,0),(750,'Payne','Maddison',19,5,70000.00,0),(751,'Walker','Gabriel',29,2,70000.00,0),(752,'Rixon','Rick',27,2,70000.00,0),(753,'White','Hayden',37,1,110000.00,0),(754,'Rowlands','Martin',40,4,95000.00,0),(755,'Broomfield','Cassandra',30,7,84000.00,0),(756,'Adams','Carolyn',59,1,110000.00,0),(757,'Thorne','Gabriel',61,6,50000.00,157),(758,'Ellison','Michaela',39,1,110000.00,0),(759,'Terry','Teagan',53,6,50000.00,157),(760,'Gaynor','Nate',36,4,95000.00,0),(761,'Ulyatt','Rick',40,6,50000.00,157),(762,'Parker','Cristal',29,2,70000.00,0),(763,'Addison','Julian',22,5,70000.00,0),(764,'Anderson','Iris',50,7,84000.00,0),(765,'Larsen','Ethan',39,1,110000.00,0),(766,'Victor','Elijah',38,3,120000.00,0),(767,'Gosling','Benny',39,4,95000.00,0),(768,'Carpenter','Kaylee',25,3,120000.00,0),(769,'Connor','Tiffany',28,1,110000.00,0),(770,'Penn','Michelle',20,7,84000.00,0),(771,'Butler','Owen',37,1,110000.00,0),(772,'Knight','Javier',36,1,110000.00,0),(773,'Simmons','Jaylene',57,6,50000.00,157),(774,'Lunt','John',49,1,110000.00,0),(775,'Lucas','Remy',34,4,95000.00,0),(776,'Norton','Melania',34,2,70000.00,0),(777,'Thorne','Marvin',43,1,110000.00,0),(778,'Mackenzie','Marvin',35,7,84000.00,0),(779,'Downing','Chester',22,2,70000.00,0),(780,'Chappell','Shelby',40,6,50000.00,157),(781,'Barrett','Rocco',18,1,110000.00,0),(782,'Kennedy','Mark',63,3,120000.00,0),(783,'Bingham','Skylar',28,6,50000.00,157),(784,'Ainsworth','Mike',51,6,50000.00,157),(785,'Salt','Marina',51,1,110000.00,0),(786,'Kelly','Kamila',24,3,120000.00,0),(787,'Potts','Russel',44,2,70000.00,0),(788,'Cartwright','Charlize',39,5,70000.00,0),(789,'Stewart','Laila',62,1,110000.00,0),(790,'Tailor','Helen',34,6,50000.00,157),(791,'Neal','Tyler',50,4,95000.00,0),(792,'Martin','Livia',62,2,70000.00,0),(793,'Russell','Marvin',45,2,70000.00,0),(794,'Squire','Brad',19,4,95000.00,0),(795,'Owens','Dalia',21,5,70000.00,0),(796,'Gosling','Davina',48,7,84000.00,0),(797,'Walter','Denny',34,4,95000.00,0),(798,'Oakley','Courtney',22,1,110000.00,0),(799,'Ellis','Hadley',28,6,50000.00,157),(800,'Khan','Willow',55,7,84000.00,0),(801,'Thomas','Cedrick',55,3,120000.00,0),(802,'Skinner','Elle',21,6,50000.00,157),(803,'Taylor','Allison',21,4,95000.00,0),(804,'Connor','Drew',20,4,95000.00,0),(805,'Nelson','Javier',19,4,95000.00,0),(806,'Strong','David',31,4,95000.00,0),(807,'Wade','Javier',48,7,84000.00,0),(808,'Neville','Michael',19,6,50000.00,157),(809,'Evans','Danny',31,4,95000.00,0),(810,'Jackson','Percy',52,5,70000.00,0),(811,'Alexander','Michael',31,5,70000.00,0),(812,'Sherwood','Candace',31,5,70000.00,0),(813,'Dickson','Cadence',45,5,70000.00,0),(814,'Michael','Norah',24,5,70000.00,0),(815,'Yard','Joseph',27,1,110000.00,0),(816,'Casey','Liam',45,6,50000.00,157),(817,'Locke','Jacob',50,1,110000.00,0),(818,'Osmond','Liam',64,4,95000.00,0),(819,'Santos','Daria',38,1,110000.00,0),(820,'Kirby','Percy',45,7,84000.00,0),(821,'Allen','Eileen',21,2,70000.00,0),(822,'Collins','Penny',26,1,110000.00,0),(823,'Coll','Josephine',44,2,70000.00,0),(824,'Veale','Liv',43,3,120000.00,0),(825,'Hall','Logan',47,4,95000.00,0),(826,'Tyrrell','Nicholas',23,7,84000.00,0),(827,'Stevens','Josephine',49,1,110000.00,0),(828,'Hunt','Mara',39,6,50000.00,157),(829,'Seymour','Tess',59,7,84000.00,0),(830,'Chapman','Chanelle',28,2,70000.00,0),(831,'Anderson','Christy',29,6,50000.00,157),(832,'Powell','Nate',43,6,50000.00,157),(833,'Flynn','Alan',30,5,70000.00,0),(835,'Osmond','Michael',52,7,84000.00,0),(836,'Roberts','Helen',51,2,70000.00,0),(837,'Mullins','Barney',62,4,95000.00,0),(838,'Gilmour','Sabrina',56,4,95000.00,0),(839,'Payne','Remy',50,4,95000.00,0),(840,'Cartwright','Ivette',28,7,84000.00,0),(841,'Taylor','Javier',58,1,110000.00,0),(842,'Marshall','Holly',31,7,84000.00,0),(843,'Riley','Danielle',31,7,84000.00,0),(844,'Cooper','Katelyn',54,2,70000.00,0),(845,'Donnelly','Gladys',19,2,70000.00,0),(846,'Bayliss','Paula',31,2,70000.00,0),(847,'Lindsay','Olivia',52,4,95000.00,0),(848,'Hamilton','Wade',59,4,95000.00,0),(849,'Lee','Dakota',59,4,95000.00,0),(850,'Doherty','Claire',53,3,120000.00,0),(851,'Townend','Carmella',62,2,70000.00,0),(852,'Mullins','Tony',50,4,95000.00,0),(853,'Powell','Keira',18,7,84000.00,0),(854,'Hardwick','Leslie',55,1,110000.00,0),(855,'Jarvis','Domenic',27,4,95000.00,0),(856,'Gonzales','Carter',44,6,50000.00,157),(857,'Jennson','Gloria',62,2,70000.00,0),(858,'Evans','Enoch',44,2,70000.00,0),(859,'Dallas','Amelia',36,3,120000.00,0),(860,'Button','Sara',62,4,95000.00,0),(861,'Mitchell','Julius',47,2,70000.00,0),(862,'Farrant','Rosalyn',40,5,70000.00,0),(863,'Cann','Ryan',62,6,50000.00,157),(864,'Neal','Rick',58,4,95000.00,0),(865,'Walsh','Nicholas',42,4,95000.00,0),(866,'Whatson','Ronald',58,3,120000.00,0),(867,'Mccall','Ramon',20,3,120000.00,0),(868,'Eaton','Alice',51,3,120000.00,0),(869,'Uddin','Josephine',63,6,50000.00,157),(870,'Isaac','Logan',45,3,120000.00,0),(871,'Milner','Manuel',37,7,84000.00,0),(872,'Barclay','Marilyn',22,1,110000.00,0),(873,'Brooks','Naomi',25,6,50000.00,157),(874,'Holt','Erica',43,1,110000.00,0),(875,'Bryson','Piper',39,3,120000.00,0),(876,'Windsor','Erin',50,2,70000.00,0),(877,'Hudson','Makena',44,6,50000.00,157),(878,'Martin','Ryan',24,3,120000.00,0),(879,'Rycroft','Chadwick',47,4,95000.00,0),(880,'Pratt','Percy',30,4,95000.00,0),(881,'Wilcox','Zoe',41,6,50000.00,157),(882,'Truscott','Jasmine',18,2,70000.00,0),(883,'Hill','Nick',58,2,70000.00,0),(884,'Kidd','Gabriel',35,7,84000.00,0),(885,'Roscoe','Melody',29,1,110000.00,0),(886,'Whinter','John',64,4,95000.00,0),(887,'Vollans','Barney',29,2,70000.00,0),(888,'Ventura','Carter',53,3,120000.00,0),(889,'Clarke','George',59,2,70000.00,0),(890,'Warren','Emely',35,6,50000.00,157),(891,'Mills','Jules',35,2,70000.00,0),(892,'Partridge','Enoch',37,5,70000.00,0),(893,'Doherty','Lucas',43,7,84000.00,0),(894,'Victor','Barry',47,2,70000.00,0),(895,'Reyes','John',63,2,70000.00,0),(896,'Furnell','Chris',20,3,120000.00,0),(897,'Blackburn','Irene',25,3,120000.00,0),(898,'Tailor','Jenna',18,7,84000.00,0),(899,'Weatcroft','Rufus',21,6,50000.00,157),(900,'Addley','Ronald',62,7,84000.00,0),(901,'Sylvester','Kirsten',22,3,120000.00,0),(902,'London','Abdul',24,7,84000.00,0),(903,'Mackenzie','Fred',19,4,95000.00,0),(904,'Simpson','Sebastian',27,7,84000.00,0),(905,'Allen','Jocelyn',48,6,50000.00,157),(906,'Richards','Rihanna',25,4,95000.00,0),(907,'Varndell','Michael',22,7,84000.00,0),(908,'Bentley','Morgan',55,1,110000.00,0),(909,'Ashley','Harry',24,7,84000.00,0),(910,'Reese','Peter',46,4,95000.00,0),(911,'Lynch','Gladys',18,7,84000.00,0),(912,'Farrell','Wade',34,3,120000.00,0),(913,'Gordon','Rick',50,7,84000.00,0),(914,'Shields','Mary',23,7,84000.00,0),(915,'Poulton','Russel',21,7,84000.00,0),(916,'Camden','Rhea',54,2,70000.00,0),(917,'Tyrrell','Harry',47,5,70000.00,0),(918,'Becker','Bob',28,7,84000.00,0),(919,'Swift','Chad',37,2,70000.00,0),(920,'Moran','Marina',30,7,84000.00,0),(921,'Corbett','Chadwick',51,5,70000.00,0),(922,'Vallory','Mya',21,2,70000.00,0),(923,'Martin','Chad',25,1,110000.00,0),(924,'Willson','Ellen',19,1,110000.00,0),(925,'Warren','Lillian',23,6,50000.00,157),(926,'Roscoe','Bart',55,6,50000.00,157),(927,'Cooper','Elly',56,1,110000.00,0),(928,'Pearce','Kirsten',19,1,110000.00,0),(929,'Lee','Russel',20,7,84000.00,0),(930,'Garcia','Mark',31,3,120000.00,0),(931,'Slater','Liam',27,3,120000.00,0),(932,'Walter','Alan',60,7,84000.00,0),(933,'Greenwood','Carter',31,2,70000.00,0),(934,'Styles','Adina',21,7,84000.00,0),(935,'Stewart','Tom',18,7,84000.00,0),(936,'Clarkson','Summer',25,1,110000.00,0),(937,'Poole','Joseph',39,7,84000.00,0),(938,'Vass','Rick',37,6,50000.00,157),(939,'Hunt','Ramon',25,2,70000.00,0),(940,'Vernon','Chester',57,7,84000.00,0),(941,'Forth','Analise',33,7,84000.00,0),(942,'Thomson','Candace',30,4,95000.00,0),(943,'Turner','Gil',54,7,84000.00,0),(944,'Oatway','Juliette',38,1,110000.00,0),(945,'Lunt','Barry',28,4,95000.00,0),(946,'Mcgregor','Eve',58,4,95000.00,0),(947,'Emmott','Clint',28,7,84000.00,0),(948,'Moss','Jack',41,3,120000.00,0),(949,'Vinton','Nate',61,1,110000.00,0),(950,'Collis','Valerie',30,5,70000.00,0),(951,'Parr','Julian',55,1,110000.00,0),(952,'Thomas','Ronald',57,7,84000.00,0),(953,'Quinton','Matt',55,3,120000.00,0),(954,'Tyler','Melanie',56,7,84000.00,0),(955,'Stuart','Cassandra',25,6,50000.00,157),(956,'Cadman','Sloane',25,3,120000.00,0),(957,'Eastwood','Caleb',25,7,84000.00,0),(958,'Mcneill','Winnie',26,6,50000.00,157),(959,'Craig','Harry',47,1,110000.00,0),(960,'Oldfield','Bob',47,5,70000.00,0),(961,'Woodley','Nathan',32,4,95000.00,0),(962,'Palmer','Destiny',21,4,95000.00,0),(963,'Morgan','Juliet',40,1,110000.00,0),(964,'Donnelly','Juliet',60,3,120000.00,0),(965,'Steer','Carla',19,7,84000.00,0),(966,'Vollans','Erin',21,4,95000.00,0),(967,'Latham','Marla',45,1,110000.00,0),(968,'Dubois','Wade',50,6,50000.00,157),(969,'Collins','Adina',52,2,70000.00,0),(970,'Murray','David',44,1,110000.00,0),(971,'Bentley','Owen',32,5,70000.00,0),(972,'Dixon','Denny',34,3,120000.00,0),(973,'Strong','Rufus',48,1,110000.00,0),(974,'Daniells','John',39,5,70000.00,0),(975,'Wigley','Rylee',22,5,70000.00,0),(976,'Stuart','Carter',56,4,95000.00,0),(977,'Bell','Bryce',18,5,70000.00,0),(978,'Shields','Freya',61,6,50000.00,157),(979,'Woods','Kimberly',30,5,70000.00,0),(980,'Vaughan','Priscilla',48,5,70000.00,0),(981,'Pierce','Selena',61,6,50000.00,157),(982,'Parr','Michael',48,5,70000.00,0),(983,'Samuel','Michael',58,6,50000.00,157),(984,'Bryson','Chris',63,1,110000.00,0),(985,'Garner','Nate',49,7,84000.00,0),(986,'Ellwood','Josh',41,7,84000.00,0),(987,'Patel','John',23,7,84000.00,0),(988,'Carpenter','Hayden',28,2,70000.00,0),(989,'Faulkner','Fred',29,1,110000.00,0);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `log_after_employee_insert` AFTER INSERT ON `employee` FOR EACH ROW BEGIN
	INSERT INTO `drivenowdb`.`employee_log`
	(`action`,
	`data`,
	`current_user`,
	`action_date`)
	VALUES
	('INSERT',
	CONCAT('{ emp_id=', NEW.emp_id,
			', last_name=', NEW.last_name,
            ', first_name=', NEW.first_name,
            ', age=', NEW.age,
            ', dept_id=', NEW.dept_id,
            ', salary=', NEW.salary,
            ', manager_id=', NEW.manager_id, ' }'),
	CURRENT_USER,
	CURRENT_TIMESTAMP);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `log_after_employee_update` AFTER UPDATE ON `employee` FOR EACH ROW BEGIN
	SET @changes = '{ ';
	IF OLD.last_name != NEW.last_name
		THEN SET @changes = CONCAT(@changes, 'last_name=', OLD.last_name, '->', NEW.last_name, ', ');
	END IF;
	IF OLD.first_name != NEW.first_name
		THEN SET @changes = CONCAT(@changes,'first_name=', OLD.first_name, '->', NEW.first_name, ', ');
	END IF;
    IF OLD.age != NEW.age
		THEN SET @changes = CONCAT(@changes,'age=', OLD.age, '->', NEW.age, ', ');
	END IF;
    IF OLD.dept_id != NEW.dept_id
		THEN SET @changes = CONCAT(@changes,'dept_id=', OLD.dept_id, '->', NEW.dept_id, ', ');
	END IF;
    IF OLD.salary != NEW.salary
		THEN SET @changes = CONCAT(@changes,'salary=', OLD.salary, '->', NEW.salary, ', ');
	END IF;
        IF OLD.manager_id != NEW.manager_id
		THEN SET @changes = CONCAT(@changes,'manager_id=', OLD.manager_id, '->', NEW.manager_id, ', ');
	END IF;
    
    SET @changes = CONCAT(@changes, ' }');
    
	INSERT INTO `drivenowdb`.`employee_log`
	(`action`,
	`data`,
	`current_user`,
	`action_date`)
	VALUES
	('UPDATE',
	@changes,
	CURRENT_USER,
	CURRENT_TIMESTAMP);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `log_after_employee_delete` AFTER DELETE ON `employee` FOR EACH ROW BEGIN
	INSERT INTO `drivenowdb`.`employee_log`
	(`action`,
	`data`,
	`current_user`,
	`action_date`)
	VALUES
	('DELETE',
	CONCAT('INSERT INTO employee (first_name, last_name, age, dept_id, salary, manager_id) VALUES (', 
			'''', OLD.first_name, ''', ', 
            '''', OLD.last_name, ''', ',            
            OLD.age,', ',
            OLD.dept_id,', ',
            OLD.salary,', ',
            OLD.manager_id,');'),
	CURRENT_USER,
	CURRENT_TIMESTAMP);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `employee_log`
--

DROP TABLE IF EXISTS `employee_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee_log` (
  `id` int NOT NULL AUTO_INCREMENT,
  `action` varchar(6) NOT NULL,
  `data` text,
  `current_user` varchar(255) DEFAULT NULL,
  `action_date` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_log`
--

LOCK TABLES `employee_log` WRITE;
/*!40000 ALTER TABLE `employee_log` DISABLE KEYS */;
INSERT INTO `employee_log` VALUES (1,'INSERT','{ emp_id=990, last_name=Clossman, first_name=James, age=18, dept_id=8, salary=120000.00, manager_id=1 }','root@localhost','2024-08-02 09:42:49'),(2,'UPDATE','{ age=18->19,  }','root@localhost','2024-08-02 09:59:33'),(3,'UPDATE','{ first_name=James->Charlotte, age=19->21, salary=120000.00->150000.00,  }','root@localhost','2024-08-02 10:01:50'),(4,'DELETE','INSERT INTO employee (first_name, last_name, age, dept_id, salary, manager_id) VALUES (\'Charlotte\'\'Clossman\'\'21\'\'8\'\'150000.00\'\'1\');','root@localhost','2024-08-02 10:11:14'),(5,'INSERT','{ emp_id=991, last_name=Clossman, first_name=Charlotte, age=21, dept_id=8, salary=150000.00, manager_id=1 }','root@localhost','2024-08-02 10:15:48'),(6,'DELETE','INSERT INTO employee (first_name, last_name, age, dept_id, salary, manager_id) VALUES (\'Charlotte\', \'Clossman\', 21, 8, 150000.00, 1);','root@localhost','2024-08-02 10:16:16');
/*!40000 ALTER TABLE `employee_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inventory`
--

DROP TABLE IF EXISTS `inventory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inventory` (
  `item_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `price` double NOT NULL DEFAULT '0',
  `price_metric` varchar(255) NOT NULL DEFAULT 'lbs',
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventory`
--

LOCK TABLES `inventory` WRITE;
/*!40000 ALTER TABLE `inventory` DISABLE KEYS */;
INSERT INTO `inventory` VALUES (1,'apples',2.99,'lbs'),(2,'oranges',1.99,'lbs'),(3,'bananas',0.19,'each'),(4,'Tomatoes',1.99,'lbs');
/*!40000 ALTER TABLE `inventory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `location`
--

DROP TABLE IF EXISTS `location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `location` (
  `id` binary(16) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `state_or_province` varchar(255) DEFAULT NULL,
  `timezone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location`
--

LOCK TABLES `location` WRITE;
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
INSERT INTO `location` VALUES (_binary '	m\═P▒Fèæ\φ\╤°gK\ε','Aberavon  Avenue, 5816','San Jose','United States Of America','Coca-Cola Company','Oregon','America/New_York'),(_binary '	°D,?LDí░:[Q²Y\═','Sheffield Vale, 7056','Innsbruck','United States Of America','Carrefour','Massachusetts','America/New_York'),(_binary ',\▌\\ôRI▄àⁿ\▌─╖¡ƒP','Thrale   Avenue, 6992','Boston','United States Of America','Leadertech Consulting','Idaho','America/New_York'),(_binary 'G\╚\'BD/M╪░┐\╔\≡VY\═∙','Parkfield  Rue, 5746','Bellevue','United States Of America','ENEL','Florida','America/New_York'),(_binary 'O╗\ΦzI-å∙\'╦¿\"\╦\╦','Carpenter Hill, 7399','Quebec','United States Of America','Metro Cash&Carry','Arkansas','America/New_York'),(_binary 'V+{z#B@|┤\ZW└R▀ì','Virginia Grove, 3698','Laredo','United States Of America','BuzzFeed','Kansas','America/New_York'),(_binary 'uKì┬ö╗DcæKù\Ω\┌\╤·','Birkin   Grove, 7434','Louisville','United States Of America','Boeing','New Mexico','America/New_York'),(_binary 'ÜÖ∙═àA¿¬w(╢l','Buttonwood Boulevard, 4891','Lancaster','United States Of America','DynCorp','Connecticut','America/New_York'),(_binary '¢AùöO?Hï2\π╛\┬L','Thorndike   Tunnel, 7593','Orlando','United States Of America','Coca-Cola Company','Virginia','America/New_York'),(_binary 'ƒ╜æGⁿBÖùùc+M╥ïû','Beatty  Walk, 2118','Valetta','United States Of America','Erickson','Rhode Island','America/New_York'),(_binary '╡╗&6yNα¿¼\Θ\╤\┘K','King Way, 2158','Huntsville','United States Of America','Telekom','Arkansas','America/New_York'),(_binary '╕JÆ\╓°M┤ò\╙\φ!\╧ä','Coleman  Alley, 5309','Santa Ana','United States Of America','DynCorp','Nebraska','America/New_York'),(_binary '┴f░ⁿL4K╩ï\╥[ê','Pine Rue, 8362','Denver','United States Of America','Boeing','Nevada','America/New_York'),(_binary '\∞)ê\┼zF\⌡╜]k\▀	╖','Collingwood  Route, 3281','Oakland','United States Of America','Amazon.com','Louisiana','America/New_York'),(_binary '√]ì$Dp»ⁿ\∞Xq`é√','Arlington  Road, 578','Cincinnati','United States Of America','21st Century Fox','New Mexico','America/New_York');
/*!40000 ALTER TABLE `location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order` (
  `order_id` int NOT NULL AUTO_INCREMENT,
  `order_date` timestamp NULL DEFAULT NULL,
  `customer_name` varchar(255) DEFAULT NULL,
  `items` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
INSERT INTO `order` VALUES (1,'2024-07-30 15:47:58','Sean Carter','apples, oranges, bananas'),(2,'2024-07-30 15:47:58','Sean Carter','apples, oranges'),(3,'2024-07-30 15:47:58','Seth Clossman','apples, oranges'),(4,'2024-07-30 15:47:58','Erica Hicks','apples, oranges, bananas');
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_1nf`
--

DROP TABLE IF EXISTS `order_1nf`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_1nf` (
  `order_id` int NOT NULL,
  `line_id` int NOT NULL,
  `order_date` date DEFAULT NULL,
  `customer_name` varchar(255) DEFAULT NULL,
  `item` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`order_id`,`line_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_1nf`
--

LOCK TABLES `order_1nf` WRITE;
/*!40000 ALTER TABLE `order_1nf` DISABLE KEYS */;
INSERT INTO `order_1nf` VALUES (1,1,'2024-07-29','Sean Carter','apples'),(1,2,'2024-07-29','Sean Carter','oranges'),(1,3,'2024-07-29','Sean Carter','bananas'),(2,1,'2024-07-30','Sean Carter','apples'),(2,2,'2024-07-30','Sean Carter','oranges'),(3,1,'2024-07-18','Seth Clossman','apples'),(3,2,'2024-07-18','Seth Clossman','oranges'),(4,1,'2024-07-25','Erica Hicks','apples'),(4,2,'2024-07-25','Erica Hicks','oranges'),(4,3,'2024-07-25','Erica Hicks','bananas');
/*!40000 ALTER TABLE `order_1nf` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_2nf`
--

DROP TABLE IF EXISTS `order_2nf`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_2nf` (
  `order_id` int NOT NULL AUTO_INCREMENT,
  `order_date` date DEFAULT NULL,
  `customer_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_2nf`
--

LOCK TABLES `order_2nf` WRITE;
/*!40000 ALTER TABLE `order_2nf` DISABLE KEYS */;
INSERT INTO `order_2nf` VALUES (1,'2024-07-25','Erica Hicks'),(2,'2024-07-18','Seth Clossman'),(3,'2024-07-30','Sean Carter'),(4,'2024-07-29','Sean Carter');
/*!40000 ALTER TABLE `order_2nf` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_item`
--

DROP TABLE IF EXISTS `order_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_item` (
  `line_id` int NOT NULL AUTO_INCREMENT,
  `item` varchar(255) DEFAULT NULL,
  `order_id` int NOT NULL,
  `item_price` double NOT NULL DEFAULT '0',
  `item_price_metric` varchar(45) NOT NULL DEFAULT 'lbs',
  PRIMARY KEY (`line_id`),
  KEY `order_id` (`order_id`),
  CONSTRAINT `order_item_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `order_2nf` (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_item`
--

LOCK TABLES `order_item` WRITE;
/*!40000 ALTER TABLE `order_item` DISABLE KEYS */;
INSERT INTO `order_item` VALUES (1,'apples',1,2.99,'lbs'),(2,'oranges',1,1.99,'lbs'),(3,'bananas',1,0.19,'each'),(4,'apples',2,2.99,'lbs'),(5,'oranges',2,1.99,'lbs'),(6,'apples',3,2.99,'lbs'),(7,'oranges',3,1.99,'lbs'),(8,'apples',4,2.99,'lbs'),(9,'oranges',4,1.99,'lbs'),(10,'bananas',4,0.19,'each');
/*!40000 ALTER TABLE `order_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_items_3nf`
--

DROP TABLE IF EXISTS `order_items_3nf`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_items_3nf` (
  `line_id` int NOT NULL AUTO_INCREMENT,
  `order_id` int NOT NULL,
  `item_id` int NOT NULL,
  PRIMARY KEY (`line_id`),
  KEY `order_id` (`order_id`),
  KEY `item_id` (`item_id`),
  CONSTRAINT `order_items_3nf_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `order_2nf` (`order_id`),
  CONSTRAINT `order_items_3nf_ibfk_2` FOREIGN KEY (`item_id`) REFERENCES `inventory` (`item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_items_3nf`
--

LOCK TABLES `order_items_3nf` WRITE;
/*!40000 ALTER TABLE `order_items_3nf` DISABLE KEYS */;
INSERT INTO `order_items_3nf` VALUES (1,1,1),(2,1,2),(3,1,3),(4,2,1),(5,2,2),(6,3,1),(7,3,2),(8,4,1),(9,4,2),(10,4,3);
/*!40000 ALTER TABLE `order_items_3nf` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservation` (
  `created` datetime(6) NOT NULL,
  `end_date` datetime(6) DEFAULT NULL,
  `modified` datetime(6) NOT NULL,
  `start_date` datetime(6) DEFAULT NULL,
  `end_location_id` binary(16) DEFAULT NULL,
  `id` binary(16) NOT NULL,
  `start_location_id` binary(16) DEFAULT NULL,
  `user_id` binary(16) DEFAULT NULL,
  `vehicle_id` binary(16) DEFAULT NULL,
  `timezone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_recqnfjcp370rygd9hjjxjtg` (`user_id`),
  UNIQUE KEY `UK_8dxn1a4ouvv2w9p2jx0o2jhp2` (`vehicle_id`),
  KEY `FK9eyum1rt9qwejy12b353apnfq` (`end_location_id`),
  KEY `FK3tqncwf297bevg7egd37r5e1w` (`start_location_id`),
  CONSTRAINT `FK3tqncwf297bevg7egd37r5e1w` FOREIGN KEY (`start_location_id`) REFERENCES `location` (`id`),
  CONSTRAINT `FK9eyum1rt9qwejy12b353apnfq` FOREIGN KEY (`end_location_id`) REFERENCES `location` (`id`),
  CONSTRAINT `FKm4oimk0l1757o9pwavorj6ljg` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKrm327sr0rb11mme0kbsm37od5` FOREIGN KEY (`vehicle_id`) REFERENCES `vehicle` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservation`
--

LOCK TABLES `reservation` WRITE;
/*!40000 ALTER TABLE `reservation` DISABLE KEYS */;
INSERT INTO `reservation` VALUES ('2023-10-12 14:53:58.470000','2023-10-17 00:00:00.000000','2023-10-12 14:53:58.470000','2023-10-12 00:00:00.000000',_binary 'G\╚\'BD/M╪░┐\╔\≡VY\═∙',_binary 'm10\εT@\≥ö\╒=æM»\═{',_binary 'G\╚\'BD/M╪░┐\╔\≡VY\═∙',NULL,_binary 'àj8hv\ε╜p\0╛CD■','America/New_York'),('2023-10-12 15:32:24.456000','2023-10-16 00:00:00.000000','2023-10-12 15:32:24.456000','2023-10-12 00:00:00.000000',_binary '	m\═P▒Fèæ\φ\╤°gK\ε',_binary '5\Γ+]TB°è\∩\╬├Æ&═á',_binary '	m\═P▒Fèæ\φ\╤°gK\ε',NULL,_binary 'à\⌠Yhv\ε╜p\0╛CD■','America/New_York'),('2023-10-12 15:49:02.641000','2023-10-17 00:00:00.000000','2023-10-12 15:49:02.641000','2023-10-12 00:00:00.000000',_binary '	m\═P▒Fèæ\φ\╤°gK\ε',_binary '?\Γ7Q₧\█A@í5╫£?à',_binary '	m\═P▒Fèæ\φ\╤°gK\ε',NULL,_binary 'àwhv\ε╜p\0╛CD■','America/New_York'),('2023-10-12 15:21:20.423000','2023-10-17 00:00:00.000000','2023-10-12 15:21:20.423000','2023-10-12 00:00:00.000000',_binary '	°D,?LDí░:[Q²Y\═',_binary 'ZblX*╜@1╢█ì09.â╜',_binary '	°D,?LDí░:[Q²Y\═',NULL,_binary 'à└hv\ε╜p\0╛CD■','America/New_York'),('2023-10-12 15:41:16.724000','2023-10-17 00:00:00.000000','2023-10-12 15:41:16.724000','2023-10-12 00:00:00.000000',_binary '	m\═P▒Fèæ\φ\╤°gK\ε',_binary 'ñ9_âà I╚╖\╔\÷╜╛&>\╘',_binary '	m\═P▒Fèæ\φ\╤°gK\ε',NULL,_binary 'àChv\ε╜p\0╛CD■','America/New_York'),('2023-10-12 15:52:50.860000','2023-10-18 00:00:00.000000','2023-10-12 15:52:50.860000','2023-10-12 00:00:00.000000',_binary ',\▌\\ôRI▄àⁿ\▌─╖¡ƒP',_binary 'ÑW\ΦL╛\┌A7░e\Zj\≡\ΦÖ\⌠',_binary ',\▌\\ôRI▄àⁿ\▌─╖¡ƒP',NULL,_binary 'àd\█hv\ε╜p\0╛CD■','America/New_York'),('2023-10-12 16:08:24.608000','2023-10-16 00:00:00.000000','2023-10-12 16:08:24.608000','2023-10-13 00:00:00.000000',_binary '	°D,?LDí░:[Q²Y\═',_binary '╬┐\╓\≥\ε┤@Sö╝è9 Bcg',_binary '	°D,?LDí░:[Q²Y\═',_binary 'K\├%?ò¡Lⁿùp╩╜iúYW',_binary 'à├╝hv\ε╜p\0╛CD■','America/New_York'),('2023-10-12 15:43:08.313000','2023-10-17 00:00:00.000000','2023-10-12 15:43:08.313000','2023-10-12 00:00:00.000000',_binary '	m\═P▒Fèæ\φ\╤°gK\ε',_binary '\±úüE6ÉC\ß¡	└\Z\r\rY',_binary '	m\═P▒Fèæ\φ\╤°gK\ε',NULL,_binary 'à;Æhv\ε╜p\0╛CD■','America/New_York');
/*!40000 ALTER TABLE `reservation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `account_non_expired` bit(1) DEFAULT NULL,
  `account_non_locked` bit(1) DEFAULT NULL,
  `credentials_non_expired` bit(1) DEFAULT NULL,
  `email_verified` bit(1) DEFAULT NULL,
  `enabled` bit(1) DEFAULT NULL,
  `role` varchar(10) DEFAULT NULL,
  `id` binary(16) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (_binary '',_binary '',_binary '',_binary '',_binary '','ROLE_ADMIN',_binary 'K\├%?ò¡Lⁿùp╩╜iúYW','clossmans2@gmail.com','Seth','Clossman','$2a$10$STRAuwlDenVbtDC9SVDdbOJMSoOjMjZoigFMRN0VZlli5EpH0g0/i','clossmans2');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehicle`
--

DROP TABLE IF EXISTS `vehicle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vehicle` (
  `number_of_passengers` int NOT NULL,
  `vehicle_type` tinyint DEFAULT NULL,
  `current_location_id` binary(16) DEFAULT NULL,
  `id` binary(16) NOT NULL,
  `reservation_id` binary(16) DEFAULT NULL,
  `features` varchar(255) DEFAULT NULL,
  `model` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1s5nqkgw80oaoga3op3ayaxnp` (`current_location_id`),
  KEY `FK5sfpcqnsous1gd3sawy9ga0wd` (`reservation_id`),
  CONSTRAINT `FK1s5nqkgw80oaoga3op3ayaxnp` FOREIGN KEY (`current_location_id`) REFERENCES `location` (`id`),
  CONSTRAINT `FK5sfpcqnsous1gd3sawy9ga0wd` FOREIGN KEY (`reservation_id`) REFERENCES `reservation` (`id`),
  CONSTRAINT `vehicle_chk_1` CHECK ((`vehicle_type` between 0 and 3))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehicle`
--

LOCK TABLES `vehicle` WRITE;
/*!40000 ALTER TABLE `vehicle` DISABLE KEYS */;
INSERT INTO `vehicle` VALUES (3,2,NULL,_binary 'à\╟\┼hv\ε╜p\0╛CD■',NULL,'Automatic Emergency Braking','Kia Forte','kia_forte.jpg'),(7,2,NULL,_binary 'àj8hv\ε╜p\0╛CD■',NULL,'Leather Upholstery','Nissan Sentra','nissan_sentra.jpg'),(6,1,_binary '	m\═P▒Fèæ\φ\╤°gK\ε',_binary 'à┐èhv\ε╜p\0╛CD■',NULL,'Heads-up Display','Toyota Corolla','toyota_corolla.jpg'),(5,1,_binary '	m\═P▒Fèæ\φ\╤°gK\ε',_binary 'à\⌠Yhv\ε╜p\0╛CD■',NULL,'Moonroof','Toyota Prius','toyota_prius.jpg'),(4,1,_binary '	m\═P▒Fèæ\φ\╤°gK\ε',_binary 'à;Æhv\ε╜p\0╛CD■',NULL,'Heated Seats','Mercedes-Benz E-Class','mercedes-benz_e-class.jpg'),(3,2,NULL,_binary 'àâ:hv\ε╜p\0╛CD■',NULL,'Blind Spot Monitoring','Kia Forte','kia_forte.jpg'),(7,1,_binary '	m\═P▒Fèæ\φ\╤°gK\ε',_binary 'à└hv\ε╜p\0╛CD■',NULL,'Android Auto/Apple CarPlay','Nissan Sentra','nissan_sentra.jpg'),(7,0,_binary '¢AùöO?Hï2\π╛\┬L',_binary 'à\0Qhv\ε╜p\0╛CD■',NULL,'LED Headlights','Hyundai Elantra','hyundai_elantra.jpg'),(3,2,NULL,_binary 'àC(hv\ε╜p\0╛CD■',NULL,'Remote Start','Lexus ES','lexus_es.jpg'),(6,0,_binary '¢AùöO?Hï2\π╛\┬L',_binary 'àghv\ε╜p\0╛CD■',NULL,'Blind Spot Monitoring','Hyundai Elantra','hyundai_elantra.jpg'),(2,2,NULL,_binary 'à\┬rhv\ε╜p\0╛CD■',NULL,'Moonroof','Toyota Corolla','toyota_corolla.jpg'),(5,2,NULL,_binary 'à\≈3hv\ε╜p\0╛CD■',NULL,'LED Headlights','Volkswagen Golf','volkswagen_golf.jpg'),(4,1,_binary '	m\═P▒Fèæ\φ\╤°gK\ε',_binary 'àChv\ε╜p\0╛CD■',NULL,'Android Auto/Apple CarPlay','Chevrolet Cruze','chevrolet_cruze.jpg'),(5,1,_binary '	m\═P▒Fèæ\φ\╤°gK\ε',_binary 'àwhv\ε╜p\0╛CD■',NULL,'Remote Start','Lexus ES','lexus_es.jpg'),(3,1,_binary '	m\═P▒Fèæ\φ\╤°gK\ε',_binary 'à│]hv\ε╜p\0╛CD■',NULL,'Automatic Emergency Braking','Toyota Camry','toyota_camry.jpg'),(6,2,NULL,_binary 'à\▐mhv\ε╜p\0╛CD■',NULL,'ABS (Anti-Lock Brakes)','Toyota Corolla','toyota_corolla.jpg'),(8,2,NULL,_binary 'àahv\ε╜p\0╛CD■',NULL,'Dual-zone Climate Control','Lexus ES','lexus_es.jpg'),(5,1,NULL,_binary 'àCähv\ε╜p\0╛CD■',NULL,'Moonroof','Kia Forte','kia_forte.jpg'),(7,2,NULL,_binary 'ànºhv\ε╜p\0╛CD■',NULL,'Dual-zone Climate Control','Hyundai Sonata','hyundai_sonata.jpg'),(2,0,_binary '¢AùöO?Hï2\π╛\┬L',_binary 'à»\αhv\ε╜p\0╛CD■',NULL,'Automatic Emergency Braking','Mercedes-Benz E-Class','mercedes-benz_e-class.jpg'),(2,2,NULL,_binary 'à▌╛hv\ε╜p\0╛CD■',NULL,'Navigation System','Jaguar XE','jaguar_xe.jpg'),(1,1,NULL,_binary 'à	\ßhv\ε╜p\0╛CD■',NULL,'Parking Sensors','Kia Optima','kia_optima.jpg'),(1,3,NULL,_binary 'à	O\╘hv\ε╜p\0╛CD■',NULL,'Parking Sensors','Lexus ES','lexus_es.jpg'),(4,1,NULL,_binary 'à	~\∞hv\ε╜p\0╛CD■',NULL,'Bluetooth Connectivity','Jaguar XE','jaguar_xe.jpg'),(7,2,NULL,_binary 'à	⌐\╒hv\ε╜p\0╛CD■',NULL,'Blind Spot Monitoring','Lexus IS','lexus_is.jpg'),(1,2,NULL,_binary 'à	\╪\╘hv\ε╜p\0╛CD■',NULL,'ABS (Anti-Lock Brakes)','Honda Accord','honda_accord.jpg'),(4,2,NULL,_binary 'à\n\"9hv\ε╜p\0╛CD■',NULL,'Leather Upholstery','Mercedes-Benz E-Class','mercedes-benz_e-class.jpg'),(5,3,NULL,_binary 'à\nPhv\ε╜p\0╛CD■',NULL,'Moonroof','Honda Civic','honda_civic.jpg'),(1,1,NULL,_binary 'à\nÄ\εhv\ε╜p\0╛CD■',NULL,'ABS (Anti-Lock Brakes)','Chevrolet Malibu','chevrolet_malibu.jpg'),(4,0,_binary '¢AùöO?Hï2\π╛\┬L',_binary 'à\n\╟>hv\ε╜p\0╛CD■',NULL,'Bluetooth Connectivity','Jaguar XE','jaguar_xe.jpg'),(3,3,NULL,_binary 'àhv\ε╜p\0╛CD■',NULL,'LED Headlights','Volkswagen Golf','volkswagen_golf.jpg'),(2,0,_binary '¢AùöO?Hï2\π╛\┬L',_binary 'à4Ñhv\ε╜p\0╛CD■',NULL,'Heads-up Display','Mazda6','mazda6.jpg'),(7,3,NULL,_binary 'à`0hv\ε╜p\0╛CD■',NULL,'LED Headlights','Toyota Corolla','toyota_corolla.jpg'),(1,2,NULL,_binary 'àò6hv\ε╜p\0╛CD■',NULL,'Panoramic Sunroof','BMW 5 Series','bmw_5_series.jpg'),(3,2,NULL,_binary 'à\├°hv\ε╜p\0╛CD■',NULL,'Blind Spot Monitoring','Kia Forte','kia_forte.jpg'),(6,2,NULL,_binary 'à\ε\Ωhv\ε╜p\0╛CD■',NULL,'Automatic Emergency Braking','Ford Fusion','ford_fusion.jpg'),(8,2,NULL,_binary 'à!\╟hv\ε╜p\0╛CD■',NULL,'Android Auto/Apple CarPlay','Audi A6','audi_a6.jpg'),(2,3,NULL,_binary 'àL\╞hv\ε╜p\0╛CD■',NULL,'Automatic Emergency Braking','Chevrolet Cruze','chevrolet_cruze.jpg'),(7,1,NULL,_binary 'àìHhv\ε╜p\0╛CD■',NULL,'Parking Sensors','BMW 5 Series','bmw_5_series.jpg'),(5,2,NULL,_binary 'à╖Nhv\ε╜p\0╛CD■',NULL,'LED Headlights','Audi A6','audi_a6.jpg'),(4,2,NULL,_binary 'à\αûhv\ε╜p\0╛CD■',NULL,'Dual-zone Climate Control','Volkswagen Passat','volkswagen_passat.jpg'),(3,1,NULL,_binary 'à\rhv\ε╜p\0╛CD■',NULL,'Blind Spot Monitoring','Jaguar XE','jaguar_xe.jpg'),(8,1,NULL,_binary 'à\r8óhv\ε╜p\0╛CD■',NULL,'LED Headlights','Kia Forte','kia_forte.jpg'),(3,0,_binary '¢AùöO?Hï2\π╛\┬L',_binary 'à\rÖhv\ε╜p\0╛CD■',NULL,'Bluetooth Connectivity','Audi A6','audi_a6.jpg'),(4,2,NULL,_binary 'à\r\┘\┼hv\ε╜p\0╛CD■',NULL,'Heated Seats','Chevrolet Malibu','chevrolet_malibu.jpg'),(5,2,NULL,_binary 'à<\≥hv\ε╜p\0╛CD■',NULL,'ABS (Anti-Lock Brakes)','Lexus IS','lexus_is.jpg'),(3,2,NULL,_binary 'àt-hv\ε╜p\0╛CD■',NULL,'Remote Start','Jaguar XE','jaguar_xe.jpg'),(2,1,NULL,_binary 'à⌐ëhv\ε╜p\0╛CD■',NULL,'Blind Spot Monitoring','Chevrolet Camaro','chevrolet_camaro.jpg'),(7,0,_binary '¢AùöO?Hï2\π╛\┬L',_binary 'à\┌fhv\ε╜p\0╛CD■',NULL,'Leather Upholstery','Subaru Legacy','subaru_legacy.jpg'),(3,1,NULL,_binary 'àhv\ε╜p\0╛CD■',NULL,'Blind Spot Monitoring','BMW 5 Series','bmw_5_series.jpg'),(4,3,NULL,_binary 'à:░hv\ε╜p\0╛CD■',NULL,'Leather Upholstery','Jaguar XE','jaguar_xe.jpg'),(3,3,NULL,_binary 'àr?hv\ε╜p\0╛CD■',NULL,'Moonroof','Lexus IS','lexus_is.jpg'),(5,1,NULL,_binary 'à½ähv\ε╜p\0╛CD■',NULL,'Dual-zone Climate Control','Ford Mustang','ford_mustang.jpg'),(7,3,NULL,_binary 'à\∞Shv\ε╜p\0╛CD■',NULL,'ABS (Anti-Lock Brakes)','Honda Civic','honda_civic.jpg'),(1,3,NULL,_binary 'à(zhv\ε╜p\0╛CD■',NULL,'Blind Spot Monitoring','Hyundai Elantra','hyundai_elantra.jpg'),(8,2,NULL,_binary 'àthv\ε╜p\0╛CD■',NULL,'Leather Upholstery','Hyundai Elantra','hyundai_elantra.jpg'),(7,1,NULL,_binary 'à╥¬hv\ε╜p\0╛CD■',NULL,'Heads-up Display','Mercedes-Benz E-Class','mercedes-benz_e-class.jpg'),(3,2,NULL,_binary 'àWhv\ε╜p\0╛CD■',NULL,'Dual-zone Climate Control','BMW 3 Series','bmw_3_series.jpg'),(5,3,NULL,_binary 'àKChv\ε╜p\0╛CD■',NULL,'Dual-zone Climate Control','Dodge Challenger','dodge_challenger.jpg'),(2,2,NULL,_binary 'àäàhv\ε╜p\0╛CD■',NULL,'Bluetooth Connectivity','Kia Optima','kia_optima.jpg'),(5,0,_binary '¢AùöO?Hï2\π╛\┬L',_binary 'à╕»hv\ε╜p\0╛CD■',NULL,'Remote Start','Kia Forte','kia_forte.jpg'),(7,1,NULL,_binary 'àéhv\ε╜p\0╛CD■',NULL,'Remote Start','Lexus IS','lexus_is.jpg'),(7,1,NULL,_binary 'àQ%hv\ε╜p\0╛CD■',NULL,'Automatic Emergency Braking','Subaru Impreza','subaru_impreza.jpg'),(6,0,_binary '¢AùöO?Hï2\π╛\┬L',_binary 'àÄ\δhv\ε╜p\0╛CD■',NULL,'Wireless Charging','Honda Accord','honda_accord.jpg'),(7,1,NULL,_binary 'à\┼\═hv\ε╜p\0╛CD■',NULL,'Heated Seats','Lexus IS','lexus_is.jpg'),(7,3,NULL,_binary 'àzhv\ε╜p\0╛CD■',NULL,'Panoramic Sunroof','Toyota Camry','toyota_camry.jpg'),(5,1,NULL,_binary 'àC4hv\ε╜p\0╛CD■',NULL,'Automatic Emergency Braking','Mercedes-Benz C-Class','mercedes-benz_c-class.jpg'),(4,2,NULL,_binary 'àëphv\ε╜p\0╛CD■',NULL,'Moonroof','Audi A4','audi_a4.jpg'),(4,1,NULL,_binary 'à╦ühv\ε╜p\0╛CD■',NULL,'LED Headlights','Toyota Corolla','toyota_corolla.jpg'),(4,1,NULL,_binary 'à²hv\ε╜p\0╛CD■',NULL,'Parking Sensors','Subaru Legacy','subaru_legacy.jpg'),(5,1,NULL,_binary 'à3áhv\ε╜p\0╛CD■',NULL,'Automatic Emergency Braking','Nissan Sentra','nissan_sentra.jpg'),(4,1,NULL,_binary 'àrchv\ε╜p\0╛CD■',NULL,'Navigation System','Chevrolet Camaro','chevrolet_camaro.jpg'),(4,1,NULL,_binary 'à¬(hv\ε╜p\0╛CD■',NULL,'Lane Departure Warning','Mercedes-Benz E-Class','mercedes-benz_e-class.jpg'),(1,1,NULL,_binary 'à▐░hv\ε╜p\0╛CD■',NULL,'Blind Spot Monitoring','Lexus IS','lexus_is.jpg'),(7,3,NULL,_binary 'à▓hv\ε╜p\0╛CD■',NULL,'Heads-up Display','Mercedes-Benz E-Class','mercedes-benz_e-class.jpg'),(8,3,NULL,_binary 'àB╡hv\ε╜p\0╛CD■',NULL,'Lane Departure Warning','Hyundai Elantra','hyundai_elantra.jpg'),(7,1,NULL,_binary 'àtthv\ε╜p\0╛CD■',NULL,'Moonroof','Toyota Camry','toyota_camry.jpg'),(7,0,_binary '¢AùöO?Hï2\π╛\┬L',_binary 'à│Hhv\ε╜p\0╛CD■',NULL,'Remote Start','Hyundai Elantra','hyundai_elantra.jpg'),(7,1,NULL,_binary 'à√\▀hv\ε╜p\0╛CD■',NULL,'Remote Start','Ford Mustang','ford_mustang.jpg'),(6,2,NULL,_binary 'à3Ahv\ε╜p\0╛CD■',NULL,'Android Auto/Apple CarPlay','Subaru Legacy','subaru_legacy.jpg'),(2,0,_binary '	m\═P▒Fèæ\φ\╤°gK\ε',_binary 'àd\█hv\ε╜p\0╛CD■',NULL,'Blind Spot Monitoring','Kia Optima','kia_optima.jpg'),(7,3,NULL,_binary 'àÆ╗hv\ε╜p\0╛CD■',NULL,'Wireless Charging','Subaru Impreza','subaru_impreza.jpg'),(3,2,NULL,_binary 'à\╦hv\ε╜p\0╛CD■',NULL,'Parking Sensors','Nissan Sentra','nissan_sentra.jpg'),(3,3,NULL,_binary 'à\0)hv\ε╜p\0╛CD■',NULL,'Navigation System','Chevrolet Malibu','chevrolet_malibu.jpg'),(7,3,NULL,_binary 'à-\╫hv\ε╜p\0╛CD■',NULL,'Dual-zone Climate Control','Volkswagen Golf','volkswagen_golf.jpg'),(4,2,NULL,_binary 'à[\Zhv\ε╜p\0╛CD■',NULL,'Heated Seats','Toyota Camry','toyota_camry.jpg'),(3,2,NULL,_binary 'àÉ\≡hv\ε╜p\0╛CD■',NULL,'Wireless Charging','Tesla Model S','tesla_model_s.jpg'),(8,0,_binary '	m\═P▒Fèæ\φ\╤°gK\ε',_binary 'à╛-hv\ε╜p\0╛CD■',NULL,'Parking Sensors','BMW 3 Series','bmw_3_series.jpg'),(6,1,NULL,_binary 'à\Θ\ßhv\ε╜p\0╛CD■',NULL,'LED Headlights','Kia Optima','kia_optima.jpg'),(3,1,NULL,_binary 'à \≡hv\ε╜p\0╛CD■',NULL,'Leather Upholstery','Hyundai Elantra','hyundai_elantra.jpg'),(2,2,NULL,_binary 'àU\╚hv\ε╜p\0╛CD■',NULL,'Android Auto/Apple CarPlay','Volkswagen Golf','volkswagen_golf.jpg'),(4,1,NULL,_binary 'àôRhv\ε╜p\0╛CD■',NULL,'Bluetooth Connectivity','Hyundai Elantra','hyundai_elantra.jpg'),(8,0,_binary '	m\═P▒Fèæ\φ\╤°gK\ε',_binary 'à├╝hv\ε╜p\0╛CD■',NULL,'Heated Seats','Mazda6','mazda6.jpg'),(4,1,NULL,_binary 'à\±ahv\ε╜p\0╛CD■',NULL,'Blind Spot Monitoring','BMW 3 Series','bmw_3_series.jpg'),(5,1,NULL,_binary 'à&ühv\ε╜p\0╛CD■',NULL,'Heads-up Display','Kia Optima','kia_optima.jpg'),(4,1,NULL,_binary 'àZhv\ε╜p\0╛CD■',NULL,'Moonroof','Audi A4','audi_a4.jpg'),(5,2,NULL,_binary 'àëWhv\ε╜p\0╛CD■',NULL,'Heated Seats','Kia Forte','kia_forte.jpg'),(1,2,NULL,_binary 'à╢+hv\ε╜p\0╛CD■',NULL,'Android Auto/Apple CarPlay','Lexus IS','lexus_is.jpg'),(6,2,NULL,_binary 'à\Σ\\hv\ε╜p\0╛CD■',NULL,'Dual-zone Climate Control','Lexus IS','lexus_is.jpg'),(3,3,NULL,_binary 'à\Zuhv\ε╜p\0╛CD■',NULL,'Blind Spot Monitoring','Subaru Legacy','subaru_legacy.jpg');
/*!40000 ALTER TABLE `vehicle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `verification_token`
--

DROP TABLE IF EXISTS `verification_token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `verification_token` (
  `expiry_date` datetime(6) DEFAULT NULL,
  `id` bigint NOT NULL,
  `user_id` binary(16) NOT NULL,
  `token` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_q6jibbenp7o9v6tq178xg88hg` (`user_id`),
  CONSTRAINT `FKrdn0mss276m9jdobfhhn2qogw` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `verification_token`
--

LOCK TABLES `verification_token` WRITE;
/*!40000 ALTER TABLE `verification_token` DISABLE KEYS */;
/*!40000 ALTER TABLE `verification_token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `verification_token_seq`
--

DROP TABLE IF EXISTS `verification_token_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `verification_token_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `verification_token_seq`
--

LOCK TABLES `verification_token_seq` WRITE;
/*!40000 ALTER TABLE `verification_token_seq` DISABLE KEYS */;
INSERT INTO `verification_token_seq` VALUES (1);
/*!40000 ALTER TABLE `verification_token_seq` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-08-02 13:40:38

-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: bdtechsalesatual
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.25-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categoria` (
  `catCodigo` int(11) NOT NULL AUTO_INCREMENT,
  `catNome` text NOT NULL,
  PRIMARY KEY (`catCodigo`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (1,'FPS'),(2,'Sandbox'),(3,'RPG'),(4,'Terror'),(5,'Corrida'),(6,'Luta'),(7,'Aventura'),(8,'Esporte'),(9,'Simulação');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `cliCodigo` int(11) NOT NULL AUTO_INCREMENT,
  `cliNome` text NOT NULL,
  `cliIdade` int(11) NOT NULL,
  `cliCPF` text NOT NULL,
  `cliEndereco` text NOT NULL,
  `cliTelefone` varchar(15) NOT NULL,
  PRIMARY KEY (`cliCodigo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Alef Faria Silva',18,'140.399.796-99','Isolina Candida de Souza','(37)9 9986-3027'),(2,'Iago Brayham',17,'00000000000000','000000000000000','00000000000'),(3,'Maycon',17,'0','0','0');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `con_jogo`
--

DROP TABLE IF EXISTS `con_jogo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `con_jogo` (
  `cjg_joCodigo` int(11) NOT NULL AUTO_INCREMENT,
  `cjg_conCodigo` int(11) NOT NULL,
  PRIMARY KEY (`cjg_joCodigo`,`cjg_conCodigo`),
  KEY `fk_jogo_has_console_console1_idx` (`cjg_conCodigo`),
  KEY `fk_jogo_has_console_jogo1_idx` (`cjg_joCodigo`),
  CONSTRAINT `fk_jogo_has_console_console1` FOREIGN KEY (`cjg_conCodigo`) REFERENCES `console` (`conCodigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_jogo_has_console_jogo1` FOREIGN KEY (`cjg_joCodigo`) REFERENCES `jogo` (`joCodigo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `con_jogo`
--

LOCK TABLES `con_jogo` WRITE;
/*!40000 ALTER TABLE `con_jogo` DISABLE KEYS */;
INSERT INTO `con_jogo` VALUES (1,1),(1,2),(2,1),(4,1),(5,1),(6,1),(7,1),(8,1),(12,1),(14,2),(15,3),(16,3);
/*!40000 ALTER TABLE `con_jogo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `console`
--

DROP TABLE IF EXISTS `console`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `console` (
  `conCodigo` int(11) NOT NULL AUTO_INCREMENT,
  `conNome` text NOT NULL,
  `conMarca` text NOT NULL,
  PRIMARY KEY (`conCodigo`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `console`
--

LOCK TABLES `console` WRITE;
/*!40000 ALTER TABLE `console` DISABLE KEYS */;
INSERT INTO `console` VALUES (1,'Playstation 4 ','Sony'),(2,'Wii U','Nintendo'),(3,'Xbox One','Microsoft'),(4,'PC','---'),(5,'Smartphone','---');
/*!40000 ALTER TABLE `console` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `devolucao`
--

DROP TABLE IF EXISTS `devolucao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `devolucao` (
  `devCodigo` int(11) NOT NULL AUTO_INCREMENT,
  `dev_funCodigo` int(11) NOT NULL,
  `dev_loCodigo` int(11) NOT NULL,
  `devPreco` float NOT NULL,
  `devMulta` float NOT NULL,
  `devDataDevolucao` date NOT NULL,
  `dev_cliCodigo` int(11) NOT NULL,
  `dev_NotaFiscal` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`devCodigo`),
  KEY `fk_devolução_funcionario1_idx` (`dev_funCodigo`),
  KEY `fk_devolução_locação1_idx` (`dev_loCodigo`),
  KEY `fk_devolucao_cliente1_idx` (`dev_cliCodigo`),
  CONSTRAINT `fk_devolucao_cliente1` FOREIGN KEY (`dev_cliCodigo`) REFERENCES `cliente` (`cliCodigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_devolução_funcionario1` FOREIGN KEY (`dev_funCodigo`) REFERENCES `funcionario` (`funCodigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_devolução_locação1` FOREIGN KEY (`dev_loCodigo`) REFERENCES `locacao` (`loCodigo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `devolucao`
--

LOCK TABLES `devolucao` WRITE;
/*!40000 ALTER TABLE `devolucao` DISABLE KEYS */;
INSERT INTO `devolucao` VALUES (1,1,1,33,20,'2017-11-30',1,'>1XkB20]He'),(2,1,2,15,2,'2017-11-30',3,'E^B.3i>O\"8'),(3,2,3,7,4,'2017-11-30',1,'UZ&F/ZU@b`'),(4,2,4,8,3,'2017-11-30',3,'GLNw7Ij\'f-'),(5,2,5,20,3,'2017-11-30',2,';32^-H$Qk3');
/*!40000 ALTER TABLE `devolucao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `funcionario` (
  `funCodigo` int(11) NOT NULL AUTO_INCREMENT,
  `funNome` text NOT NULL,
  `funIdade` int(11) NOT NULL,
  `funEndereco` text NOT NULL,
  `funCPF` text NOT NULL,
  `funNomeUsuario` varchar(9) NOT NULL,
  `funUsuarioSenha` varchar(9) NOT NULL,
  `funTelefone` varchar(15) NOT NULL,
  `funNisPis` text NOT NULL,
  PRIMARY KEY (`funCodigo`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` VALUES (1,'Alef',19,'104','399.999.999-99','Alef91','123456','(37)9 9999-9999','123456'),(2,'Iago',18,'102','45.837.746-64','ibcs','14fairy','(37)8 8888888','901209');
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_venda`
--

DROP TABLE IF EXISTS `item_venda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item_venda` (
  `iv_venCodigo` int(11) NOT NULL,
  `iv_joCodigo` int(11) NOT NULL,
  `ivQtd` int(11) NOT NULL,
  `ivPrecoUnitReal` float NOT NULL,
  PRIMARY KEY (`iv_venCodigo`,`iv_joCodigo`),
  KEY `fk_Compra_has_Jogo_Jogo1_idx` (`iv_joCodigo`),
  KEY `fk_Compra_has_Jogo_Compra_idx` (`iv_venCodigo`),
  CONSTRAINT `fk_Compra_has_Jogo_Compra` FOREIGN KEY (`iv_venCodigo`) REFERENCES `venda` (`venCodigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Compra_has_Jogo_Jogo1` FOREIGN KEY (`iv_joCodigo`) REFERENCES `jogo` (`joCodigo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_venda`
--

LOCK TABLES `item_venda` WRITE;
/*!40000 ALTER TABLE `item_venda` DISABLE KEYS */;
INSERT INTO `item_venda` VALUES (1,1,1,1),(2,4,1,1),(3,2,1,1),(4,6,1,1),(6,1,1,1),(7,2,1,1),(8,3,1,1),(10,2,1,1),(12,4,1,1),(12,13,1,1),(13,6,2,2),(14,4,1,1),(15,4,1,1),(16,7,2,4),(16,15,2,2);
/*!40000 ALTER TABLE `item_venda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jogo`
--

DROP TABLE IF EXISTS `jogo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jogo` (
  `joCodigo` int(11) NOT NULL AUTO_INCREMENT,
  `joNome` text NOT NULL,
  `joFaixaEtaria` text NOT NULL,
  `joPrecoPadrao` double NOT NULL,
  `joTipo` text NOT NULL,
  `joQtd` int(11) NOT NULL,
  `joLote` text NOT NULL,
  `jo_catCodigo` int(11) NOT NULL,
  `joDisponibilidade` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`joCodigo`),
  KEY `fk_jogo_categoria1_idx` (`jo_catCodigo`),
  CONSTRAINT `fk_jogo_categoria1` FOREIGN KEY (`jo_catCodigo`) REFERENCES `categoria` (`catCodigo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jogo`
--

LOCK TABLES `jogo` WRITE;
/*!40000 ALTER TABLE `jogo` DISABLE KEYS */;
INSERT INTO `jogo` VALUES (1,'Alef','+(18)',321,'Venda',0,'asdf',1,0),(2,'Alef','+(18)',321,'Venda',5,'asdfs',1,0),(3,'Alef','+(18)',321,'Venda',5,'ddd',3,0),(4,'God Of War 4','+(18)',170.91,'Venda',0,'12df',7,1),(5,'Crash Bandicoot','+(12)',149,'Venda',5,'452878',7,0),(6,'Crash Bandicoot','+(12)',149,'Venda',3,'4528787',7,1),(7,'Crash Bandicoot','+(12)',149,'Venda',3,'45287',7,0),(8,'GTA 5','+(18)',134,'Venda',5,'452',2,0),(12,'GTA 5','+(18)',134,'Venda',0,'9452576',2,0),(13,'asda','+(11)',1,'Venda',1,'gxdh',3,0),(14,'12','+(12)',12,'Aluguel',12,'12',2,0),(15,'Origins','+(13)',14,'Aluguel',0,'33',2,0),(16,'Origins','+(13)',15,'Venda',14,'22',2,0);
/*!40000 ALTER TABLE `jogo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `locacao`
--

DROP TABLE IF EXISTS `locacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `locacao` (
  `loCodigo` int(11) NOT NULL AUTO_INCREMENT,
  `loDataAluguel` date NOT NULL,
  `loPrecoPratico` float NOT NULL,
  `loc_cliCodigo` int(11) NOT NULL,
  `loc_funCodigo` int(11) NOT NULL,
  `loc_joCodigo` int(11) NOT NULL,
  `loSit` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`loCodigo`),
  KEY `fk_locação_cliente1_idx` (`loc_cliCodigo`),
  KEY `fk_locação_funcionario1_idx` (`loc_funCodigo`),
  KEY `fk_locação_jogo1_idx` (`loc_joCodigo`),
  CONSTRAINT `fk_locação_cliente1` FOREIGN KEY (`loc_cliCodigo`) REFERENCES `cliente` (`cliCodigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_locação_funcionario1` FOREIGN KEY (`loc_funCodigo`) REFERENCES `funcionario` (`funCodigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_locação_jogo1` FOREIGN KEY (`loc_joCodigo`) REFERENCES `jogo` (`joCodigo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locacao`
--

LOCK TABLES `locacao` WRITE;
/*!40000 ALTER TABLE `locacao` DISABLE KEYS */;
INSERT INTO `locacao` VALUES (1,'2017-11-30',13,1,1,4,0),(2,'2017-11-30',13,3,1,1,0),(3,'2017-11-30',3,1,1,4,0),(4,'2017-11-30',5,3,1,4,0),(5,'2017-11-30',17,2,2,4,0);
/*!40000 ALTER TABLE `locacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venda`
--

DROP TABLE IF EXISTS `venda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `venda` (
  `venCodigo` int(11) NOT NULL AUTO_INCREMENT,
  `venNNF` text NOT NULL,
  `venData` date NOT NULL,
  `ven_funCodigo` int(11) NOT NULL,
  `cliente_cliCodigo` int(11) NOT NULL,
  PRIMARY KEY (`venCodigo`),
  KEY `fk_compra_funcionario1_idx` (`ven_funCodigo`),
  KEY `fk_venda_cliente1_idx` (`cliente_cliCodigo`),
  CONSTRAINT `fk_compra_funcionario1` FOREIGN KEY (`ven_funCodigo`) REFERENCES `funcionario` (`funCodigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_venda_cliente1` FOREIGN KEY (`cliente_cliCodigo`) REFERENCES `cliente` (`cliCodigo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venda`
--

LOCK TABLES `venda` WRITE;
/*!40000 ALTER TABLE `venda` DISABLE KEYS */;
INSERT INTO `venda` VALUES (1,'1','2015-10-10',1,1),(2,'1','2017-08-31',1,2),(3,'1','2017-02-02',1,3),(4,'1','2017-07-31',1,3),(6,' 123456','2017-11-09',1,2),(7,' 333','2017-11-09',1,2),(8,' 66','2017-11-09',1,3),(10,'3333','2017-11-09',1,3),(12,' 122323','2016-11-16',1,1),(13,' csdfvere','2017-11-30',1,1),(14,' ghkvkhg','2017-11-30',1,1),(15,' by8','2017-11-30',1,1),(16,' dghgnfj','2017-11-30',1,1);
/*!40000 ALTER TABLE `venda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'bdtechsalesatual'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-30 12:21:52

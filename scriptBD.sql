-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: bdtechsales
-- ------------------------------------------------------
-- Server version	5.6.16

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `con_jogo`
--

DROP TABLE IF EXISTS `con_jogo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `con_jogo` (
  `cjg_joCodigo` int(11) NOT NULL,
  `cjg_conCodigo` int(11) NOT NULL,
  PRIMARY KEY (`cjg_joCodigo`,`cjg_conCodigo`),
  KEY `fk_jogo_has_console_console1_idx` (`cjg_conCodigo`),
  KEY `fk_jogo_has_console_jogo1_idx` (`cjg_joCodigo`),
  CONSTRAINT `fk_jogo_has_console_jogo1` FOREIGN KEY (`cjg_joCodigo`) REFERENCES `jogo` (`joCodigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_jogo_has_console_console1` FOREIGN KEY (`cjg_conCodigo`) REFERENCES `console` (`conCodigo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `con_jogo`
--

LOCK TABLES `con_jogo` WRITE;
/*!40000 ALTER TABLE `con_jogo` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `console`
--

LOCK TABLES `console` WRITE;
/*!40000 ALTER TABLE `console` DISABLE KEYS */;
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
  `cliente_cliCodigo` int(11) NOT NULL,
  PRIMARY KEY (`devCodigo`),
  KEY `fk_devolução_funcionario1_idx` (`dev_funCodigo`),
  KEY `fk_devolução_locação1_idx` (`dev_loCodigo`),
  KEY `fk_devolucao_cliente1_idx` (`cliente_cliCodigo`),
  CONSTRAINT `fk_devolução_funcionario1` FOREIGN KEY (`dev_funCodigo`) REFERENCES `funcionario` (`funCodigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_devolução_locação1` FOREIGN KEY (`dev_loCodigo`) REFERENCES `locacao` (`loCodigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_devolucao_cliente1` FOREIGN KEY (`cliente_cliCodigo`) REFERENCES `cliente` (`cliCodigo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `devolucao`
--

LOCK TABLES `devolucao` WRITE;
/*!40000 ALTER TABLE `devolucao` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
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
  `ivPrecoUnitReal` float unsigned NOT NULL,
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
  `joPrecoPadrao` float NOT NULL,
  `jo_catCodigo` int(11) NOT NULL,
  `joTipo` text NOT NULL,
  PRIMARY KEY (`joCodigo`),
  KEY `fk_jogo_categoria1_idx` (`jo_catCodigo`),
  CONSTRAINT `fk_jogo_categoria1` FOREIGN KEY (`jo_catCodigo`) REFERENCES `categoria` (`catCodigo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jogo`
--

LOCK TABLES `jogo` WRITE;
/*!40000 ALTER TABLE `jogo` DISABLE KEYS */;
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
  PRIMARY KEY (`loCodigo`),
  KEY `fk_locação_cliente1_idx` (`loc_cliCodigo`),
  KEY `fk_locação_funcionario1_idx` (`loc_funCodigo`),
  KEY `fk_locação_jogo1_idx` (`loc_joCodigo`),
  CONSTRAINT `fk_locação_cliente1` FOREIGN KEY (`loc_cliCodigo`) REFERENCES `cliente` (`cliCodigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_locação_funcionario1` FOREIGN KEY (`loc_funCodigo`) REFERENCES `funcionario` (`funCodigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_locação_jogo1` FOREIGN KEY (`loc_joCodigo`) REFERENCES `jogo` (`joCodigo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locacao`
--

LOCK TABLES `locacao` WRITE;
/*!40000 ALTER TABLE `locacao` DISABLE KEYS */;
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
  `venDataEHora` datetime NOT NULL,
  `ven_funCodigo` int(11) NOT NULL,
  `cliente_cliCodigo` int(11) NOT NULL,
  PRIMARY KEY (`venCodigo`),
  KEY `fk_compra_funcionario1_idx` (`ven_funCodigo`),
  KEY `fk_venda_cliente1_idx` (`cliente_cliCodigo`),
  CONSTRAINT `fk_compra_funcionario1` FOREIGN KEY (`ven_funCodigo`) REFERENCES `funcionario` (`funCodigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_venda_cliente1` FOREIGN KEY (`cliente_cliCodigo`) REFERENCES `cliente` (`cliCodigo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venda`
--

LOCK TABLES `venda` WRITE;
/*!40000 ALTER TABLE `venda` DISABLE KEYS */;
/*!40000 ALTER TABLE `venda` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-09 11:46:32

-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: universalyazilim
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `kategori`
--

DROP TABLE IF EXISTS `kategori`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kategori` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ad` varchar(45) CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=145 DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kategori`
--

LOCK TABLES `kategori` WRITE;
/*!40000 ALTER TABLE `kategori` DISABLE KEYS */;
INSERT INTO `kategori` VALUES (1,'Mobilya'),(2,'Kırtasiye'),(3,'Temizlik'),(4,'Beyaz Esya'),(5,'Elektronik'),(6,'Kozmetik'),(144,'test');
/*!40000 ALTER TABLE `kategori` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `menu` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ad` varchar(70) CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `classdirectory` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES (1,'Kategori Ekle','KategoriAddPage'),(2,'Kategori Sil','KategoriDeletePage'),(3,'Urun Ekle','UrunAddUpdatePage'),(4,'Urunleri Listele','UrunListingPage');
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `urun`
--

DROP TABLE IF EXISTS `urun`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `urun` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_kategori` int NOT NULL,
  `ad` varchar(80) COLLATE utf8_turkish_ci NOT NULL,
  `aciklama` text COLLATE utf8_turkish_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=85 DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `urun`
--

LOCK TABLES `urun` WRITE;
/*!40000 ALTER TABLE `urun` DISABLE KEYS */;
INSERT INTO `urun` VALUES (1,1,'8 Raflı Dolap Beyaz','8 Raflı Dolap Beyaz, odalarınızda şık, sade ve modern bir görünüm yaratmak üzere tasarlanmıştır.'),(2,1,'Zigon Sehpa Ceviz','Ayaklar ahşap malzemeden (Kayın Ağacından) üretilmiştir.'),(3,2,'Fotokopi Kağıdı A4 5li Paket','Colorlok teknolojisi ile renkli çıktılarda yüksek performans'),(4,2,'Masaüstü Kalemlik Organizer','Ahşap 23 x 15 x 25 cm Ürün demonte olarak gönderilmektedir yapması ve birleştirmesi hem kolay hem çok eğlenceilidir.'),(5,3,'Vim Mutfak Yağ Çözücü Sprey 750 ML','Vim Mutfak Yağ Çözücü; yılların deneyimiyle bütçe dostu ve güçlü temizlik performansını evinize getiriyor.'),(6,3,'Finish Bulaşık Makinesi Deterjanı','Finish Bulaşık Makinesi Deterjanı Makine Temizleyici Sıvı 2x250 ml'),(8,2,'rotring 501 versatil kalem','mimari çizimler için harika sonuçlar üreten 0.7 kalemdir.'),(47,2,'Kursun Kalem','faber castel 2b çizim kalemi'),(48,1,'Çalışma masası','bambu ağacaından'),(49,3,'Prill','5 litre prill'),(50,5,'Lenovo','model 500 12 gb ram'),(51,4,'Bosch buzdolabı','a++ enerji sınıfı'),(52,6,'JB deodarant4','leke bırakmayan formül'),(78,3,'111','111');
/*!40000 ALTER TABLE `urun` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-30 10:35:36

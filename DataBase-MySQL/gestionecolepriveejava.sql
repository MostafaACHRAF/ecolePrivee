-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 17, 2017 at 02:41 PM
-- Server version: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gestionecolepriveejava`
--

-- --------------------------------------------------------

--
-- Table structure for table `affectation`
--

CREATE TABLE `affectation` (
  `idA` int(11) NOT NULL,
  `idI` int(11) NOT NULL,
  `idG` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Dumping data for table `affectation`
--

INSERT INTO `affectation` (`idA`, `idI`, `idG`) VALUES
(1, 2, 1),
(5, 6, 1),
(4, 5, 1),
(9, 9, 1),
(7, 7, 2),
(8, 8, 1),
(10, 22, 2),
(11, 23, 1),
(12, 20, 1),
(14, 40, 9),
(15, 41, 9),
(16, 42, 9),
(17, 43, 9),
(18, 44, 9),
(19, 45, 9),
(20, 46, 9),
(21, 47, 9),
(22, 48, 9),
(23, 49, 9),
(24, 50, 9),
(25, 51, 9),
(26, 52, 9),
(27, 53, 9),
(28, 54, 9),
(29, 55, 91),
(30, 56, 10),
(31, 57, 10),
(32, 58, 10),
(33, 59, 10),
(34, 60, 10),
(35, 61, 10),
(36, 62, 10),
(37, 63, 10),
(38, 64, 10),
(39, 65, 10),
(40, 66, 10),
(41, 67, 10),
(42, 68, 10),
(43, 69, 10),
(44, 70, 10),
(45, 71, 10),
(48, 80, 9),
(49, 81, 9),
(50, 82, 10),
(51, 83, 2),
(52, 84, 1),
(53, 85, 2),
(54, 86, 1),
(55, 87, 9),
(56, 88, 9),
(57, 89, 9),
(58, 90, 9),
(59, 91, 9),
(60, 92, 9),
(61, 93, 9),
(62, 94, 9),
(63, 95, 9),
(64, 96, 9),
(65, 97, 10),
(66, 98, 2),
(67, 99, 9),
(68, 100, 9),
(69, 101, 9),
(70, 102, 9),
(71, 103, 9),
(72, 104, 9),
(73, 105, 10),
(74, 106, 9),
(75, 107, 9),
(76, 108, 10);

-- --------------------------------------------------------

--
-- Table structure for table `client`
--

CREATE TABLE `client` (
  `idClient` int(11) NOT NULL,
  `nom` varchar(30) COLLATE utf8mb4_bin NOT NULL,
  `prenom` varchar(30) COLLATE utf8mb4_bin NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- --------------------------------------------------------

--
-- Table structure for table `eleve`
--

CREATE TABLE `eleve` (
  `idE` int(11) NOT NULL,
  `cne` varchar(12) COLLATE utf8mb4_bin NOT NULL,
  `nom` varchar(30) COLLATE utf8mb4_bin NOT NULL,
  `prenom` varchar(30) COLLATE utf8mb4_bin NOT NULL,
  `adresse` varchar(100) COLLATE utf8mb4_bin NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Dumping data for table `eleve`
--

INSERT INTO `eleve` (`idE`, `cne`, `nom`, `prenom`, `adresse`) VALUES
(88, '1210370315', 'Mostafa', 'ASHARF', 'BOUZNIKA'),
(7, '122222258', 'sasa', 'sosito', 'bouznika'),
(3, '1415191825', 'fatima', 'rachad', 'mohammedia'),
(6, '1210370315', 'mostafa', 'achraf', 'bouznika'),
(9, '1427529461', 'achraf', 'rahaf', 'bouznika'),
(10, '4598163287', 'rachad', 'nadia', 'italy'),
(11, '145687598', 'rachad', 'salma', 'bensliman'),
(12, '786532919', 'akhal', 'abdo', 'naodr'),
(13, '785263194', 'teste', 'teste', 'teste'),
(33, '78963214', 'ahmed', 'saleh', 'rabat'),
(15, '7894561239', 'anasse', 'nazih', 'laayoune'),
(48, '888888', 'bbbbb', 'bbbbb', 'bbbbb'),
(32, '1235498', 'salah', 'abosaid', 'casa'),
(103, '1210470314', 'etudiant', 'etudiant', 'etudiant'),
(19, '47858695', 'mostafa', 'achraf', 'mohammedia'),
(20, '456398712', 'mostafa', 'achraf', 'bouznika'),
(47, '7777777', 'sosito', 'sosito', 'sosito'),
(22, '7894561237', 'messi', 'messi', 'messi'),
(23, '7418529637', 'ronaldo', 'ronaldo', 'ronaldo'),
(24, '7539518462', 'riri', 'riri', 'riri'),
(26, '222222222', 'teste', 'teste', 'teste'),
(30, '12345678910', 'rahaf', 'achraf', 'casablanca'),
(28, '485691235', 'sasa', 'sasa', 'sasa'),
(29, 'aaaaa', 'aaaaa', 'aaaaaa', 'aaaaaa'),
(49, '999999', 'ccccccc', 'ccccccc', 'ccccccc'),
(50, '4444444', 'dddddd', 'dddddd', 'dddddd'),
(51, '5555555', 'eeeeeeee', 'eeeeeeee', 'eeeeeeee'),
(53, '1111111', 'gggggg', 'gggggg', 'gggggg'),
(54, '33333333', 'hhhhhhh', 'hhhhhhh', 'hhhhhhh'),
(55, '789789', 'iiiiiiiiii', 'iiiiiiiiii', 'iiiiiiiiii'),
(56, '9459549', 'jjjjjjjjjjjj', 'jjjjjjjjjjjj', 'jjjjjjjjjjjj'),
(57, '963963', 'kkkkkkk', 'kkkkkkk', 'kkkkkkk'),
(58, '1471471', 'llllllllllll', 'llllllllllll', 'llllllllllll'),
(59, '2582582', 'mmmmmmm', 'mmmmmmm', 'mmmmmmm'),
(60, '369369', 'nnnnnnn', 'nnnnnnn', 'nnnnnnn'),
(61, '151515', 'ooooooo', 'ooooooo', 'ooooooo'),
(62, '1616161', 'ppppppp', 'ppppppp', 'ppppppp'),
(63, '665544', 'qqqqqqq', 'qqqqqqq', 'qqqqqqq'),
(64, '171717', 'rrrrrrrr', 'rrrrrrrr', 'rrrrrrrr'),
(65, '18181818', 'sssssssss', 'sssssssss', 'sssssssss'),
(66, '2020202', 'tttttttttt', 'tttttttttt', 'tttttttttt'),
(67, '21212112', 'uuuuuuu', 'uuuuuuu', 'uuuuuuu'),
(68, '2222221', 'vvvvvvv', 'vvvvvvv', 'vvvvvvv'),
(69, '23233232', 'wwwwww', 'wwwwww', 'wwwwww'),
(70, '24242424', 'xxxxxxxxxx', 'xxxxxxxxxx', 'xxxxxxxxxx'),
(71, '25252525', 'yyyyyy', 'yyyyyy', 'yyyyyy'),
(72, '26262626', 'zzzzzzzz', 'zzzzzzzz', 'zzzzzzzz'),
(73, '27272727', 'aaaaaaaaa', 'aaaaaaaaa', 'aaaaaaaaa'),
(74, '282828', 'azerty', 'azerty', 'azerty'),
(75, '29292929', 'pop', 'pop', 'pop'),
(76, '303033030', 'tree', 'tree', 'tree'),
(77, '31313131', 'lolo', 'lolo', 'lolo'),
(78, '32323232', 'yayyaya', 'yayyaya', 'yayyaya'),
(82, '33333332', 'bess', 'bess', 'bess'),
(83, '858585825', 'oui', 'oui', 'oui'),
(84, '78458475', 'achach', 'achach', 'achach'),
(85, '753753357', 'ricko', 'ricko', 'ricko'),
(86, '74196380', 'john', 'john', 'john'),
(87, '1210370315', 'Mostafa', 'ASHARF', 'BOUZNIKA'),
(89, '1526354855', 'Rahaf', 'ASHARF', 'BOUZNIKA'),
(90, '785', 'aze', 'aze', 'aze'),
(91, '1235465', 'mostafa', 'mostafa', 'mostafa'),
(92, '152674', 'asdf', 'asdf', 'asdf'),
(93, '152647', 'azzzz', 'azzzz', 'azzzz'),
(94, '123456', 'ooooooo', 'ooooooo', 'ooooooo'),
(95, '45668665', 'ererere', 'ererere', 'ererere'),
(97, '78589', 'darifggg', 'hamid', 'casablanca'),
(98, '1212321', 'teste', 'teste', 'teste'),
(99, '125355', 'marwane', 'karime', 'khouribga'),
(100, '4125', 'karime', 'khalil', 'oudzem'),
(102, '123047', 'asdcvx', 'asdcvx', 'asdcvx'),
(104, '789654', 'achraf', 'ali', 'maroc'),
(111, '48457', 'hichamùù', 'rachad', 'benslimane'),
(108, '125364', 'salma', 'rachad', 'benslimane'),
(109, '58653', 'zakaria', 'ziko', 'ourzazat'),
(110, '777777', 'stof', 'achraf', 'mohamedia'),
(114, '1524978', 'mostafa', 'achraf', 'mohammedia');

-- --------------------------------------------------------

--
-- Table structure for table `groupe`
--

CREATE TABLE `groupe` (
  `idG` int(11) NOT NULL,
  `libelleG` varchar(30) COLLATE utf8mb4_bin NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Dumping data for table `groupe`
--

INSERT INTO `groupe` (`idG`, `libelleG`) VALUES
(1, 'groupe 1'),
(2, 'groupe 2'),
(9, 'groupe 11'),
(10, 'groupe 112'),
(11, 'groupe 11'),
(12, 'groupe 112'),
(13, 'groupe 112'),
(14, 'groupe 112'),
(15, 'groupe 11');

-- --------------------------------------------------------

--
-- Table structure for table `inscription`
--

CREATE TABLE `inscription` (
  `idI` int(11) NOT NULL,
  `date_insc` datetime NOT NULL,
  `etat` varchar(30) COLLATE utf8mb4_bin NOT NULL,
  `idN` int(11) NOT NULL,
  `idE` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Dumping data for table `inscription`
--

INSERT INTO `inscription` (`idI`, `date_insc`, `etat`, `idN`, `idE`) VALUES
(26, '2016-12-16 00:00:00', 'non affectee', 2, 33),
(41, '2016-12-16 00:00:00', 'non affectee', 3, 48),
(11, '2016-12-14 00:00:00', 'non affectee', 1, 15),
(42, '2016-12-16 00:00:00', 'non affectee', 3, 49),
(25, '2016-12-16 00:00:00', 'non affectee', 1, 32),
(97, '2016-12-23 00:00:00', 'affectee', 3, 103),
(15, '2016-12-14 00:00:00', 'non affectee', 2, 19),
(16, '2016-12-14 00:00:00', 'non affectee', 1, 20),
(40, '2016-12-16 00:00:00', 'non affectee', 3, 47),
(18, '2016-12-17 00:00:00', 'non affectee', 1, 24),
(20, '2016-12-14 00:00:00', 'non affectee', 2, 26),
(23, '2016-12-16 00:00:00', 'non affectee', 2, 30),
(22, '2016-12-14 00:00:00', 'non affectee', 2, 28),
(43, '2016-12-16 00:00:00', 'non affectee', 3, 50),
(44, '2016-12-16 00:00:00', 'non affectee', 3, 51),
(46, '2016-12-17 00:00:00', 'non affectee', 3, 53),
(47, '2016-12-16 00:00:00', 'non affectee', 3, 54),
(48, '2016-12-15 00:00:00', 'non affectee', 3, 55),
(49, '2016-12-14 00:00:00', 'non affectee', 3, 56),
(50, '2016-12-17 00:00:00', 'non affectee', 3, 57),
(51, '2016-12-15 00:00:00', 'non affectee', 3, 58),
(52, '2016-12-16 00:00:00', 'non affectee', 3, 59),
(53, '2016-12-17 00:00:00', 'non affectee', 3, 60),
(54, '2016-12-16 00:00:00', 'non affectee', 3, 61),
(55, '2016-12-17 00:00:00', 'non affectee', 3, 62),
(56, '2016-12-16 00:00:00', 'non affectee', 3, 63),
(57, '2016-12-17 00:00:00', 'non affectee', 3, 64),
(58, '2016-12-16 00:00:00', 'non affectee', 3, 65),
(59, '2016-12-15 00:00:00', 'non affectee', 3, 66),
(60, '2016-12-16 00:00:00', 'non affectee', 3, 67),
(61, '2016-12-17 00:00:00', 'non affectee', 3, 68),
(62, '2016-12-16 00:00:00', 'non affectee', 3, 69),
(63, '2016-12-17 00:00:00', 'non affectee', 3, 70),
(64, '2016-12-16 00:00:00', 'non affectee', 3, 71),
(65, '2016-12-17 00:00:00', 'non affectee', 3, 72),
(66, '2016-12-16 00:00:00', 'non affectee', 3, 73),
(67, '2016-12-15 00:00:00', 'non affectee', 3, 74),
(68, '2016-12-16 00:00:00', 'non affectee', 3, 75),
(69, '2016-12-16 00:00:00', 'non affectee', 3, 76),
(70, '2016-12-15 00:00:00', 'non affectee', 3, 77),
(71, '2016-12-16 00:00:00', 'non affectee', 3, 78),
(75, '2016-12-16 00:00:00', 'non affectee', 1, 82),
(76, '2016-12-17 00:00:00', 'non affectee', 3, 83),
(77, '2016-12-17 00:00:00', 'non affectee', 3, 84),
(78, '2016-12-17 00:00:00', 'non affectee', 3, 85),
(79, '2016-12-17 00:00:00', 'non affectee', 3, 86),
(81, '2016-12-17 00:00:00', 'affectee', 3, 88),
(82, '2016-12-17 00:00:00', 'affectee', 3, 89),
(83, '2016-12-21 00:00:00', 'affectee', 2, 90),
(84, '2016-12-23 00:00:00', 'affectee', 2, 91),
(85, '2016-12-24 00:00:00', 'affectee', 2, 92),
(86, '2016-12-23 00:00:00', 'affectee', 2, 93),
(87, '2016-12-22 00:00:00', 'affectee', 1, 94),
(88, '2016-12-23 00:00:00', 'non affectee', 1, 95),
(90, '2016-12-22 00:00:00', 'non affectee', 1, 97),
(91, '2016-12-22 00:00:00', 'affectee', 1, 98),
(92, '2016-12-22 00:00:00', 'non affectee', 1, 0),
(93, '2016-12-06 00:00:00', 'affectee', 1, 99),
(94, '2016-11-08 00:00:00', 'affectee', 1, 100),
(96, '2016-12-23 00:00:00', 'affectee', 1, 102),
(98, '2016-12-20 00:00:00', 'affectee', 2, 104),
(108, '2017-01-06 00:00:00', 'affectee', 3, 114),
(105, '2017-01-01 00:00:00', 'affectee', 3, 111),
(102, '2016-12-28 00:00:00', 'affectee', 1, 108),
(103, '2016-12-28 00:00:00', 'affectee', 1, 109),
(104, '2016-12-28 00:00:00', 'affectee', 1, 110);

-- --------------------------------------------------------

--
-- Table structure for table `matiere`
--

CREATE TABLE `matiere` (
  `idMat` int(11) NOT NULL,
  `nom` varchar(30) COLLATE utf8mb4_bin NOT NULL,
  `seuil` double NOT NULL,
  `idM` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Dumping data for table `matiere`
--

INSERT INTO `matiere` (`idMat`, `nom`, `seuil`, `idM`) VALUES
(1, 'Analyse(3)', 10, 1),
(2, 'Communication', 10, 5),
(3, 'Projet Personnel', 10, 8),
(4, 'Algorithmique', 10, 10),
(5, 'C/C++', 10, 13),
(6, 'Statistique et probabilité', 10, 14),
(7, 'Télecommunication', 10, 15),
(8, 'XML', 10, 16),
(9, 'Framework & CMS', 10, 16),
(10, 'Réseaux informatique', 10, 17),
(11, 'Java', 10, 18),
(12, 'Génie Logiciel', 10, 20),
(13, 'Stage de fin D\'étude', 10, 21),
(14, 'Projet de fin d\'Etude', 10, 22),
(15, 'Modélisation UML', 10, 19);

-- --------------------------------------------------------

--
-- Table structure for table `module`
--

CREATE TABLE `module` (
  `idM` int(11) NOT NULL,
  `libelleM` varchar(30) COLLATE utf8mb4_bin NOT NULL,
  `idN` int(11) NOT NULL,
  `idS` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Dumping data for table `module`
--

INSERT INTO `module` (`idM`, `libelleM`, `idN`, `idS`) VALUES
(1, 'Analyse(3)', 3, 1),
(5, 'Communication', 3, 1),
(8, 'Projet personnel(2)', 3, 1),
(10, 'Algorithmique', 3, 1),
(13, 'C/C++', 3, 1),
(14, 'Propabilité', 3, 1),
(15, 'Télecommunication', 3, 1),
(16, 'Développement web', 3, 2),
(17, 'Réseaux Informatique', 3, 2),
(18, 'Programmation Java', 3, 2),
(19, 'UML', 3, 2),
(20, 'Génie Logiciel', 3, 2),
(21, 'Stage de fin d\'étude', 3, 2),
(22, 'Projet de fin d\'étude', 3, 2);

-- --------------------------------------------------------

--
-- Table structure for table `montant`
--

CREATE TABLE `montant` (
  `idMontant` int(11) NOT NULL,
  `montant` double NOT NULL,
  `annee_univ` int(11) NOT NULL,
  `idN` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Dumping data for table `montant`
--

INSERT INTO `montant` (`idMontant`, `montant`, `annee_univ`, `idN`) VALUES
(1, 1000, 2016, 1),
(2, 1200, 2016, 2),
(3, 1400, 2016, 3);

-- --------------------------------------------------------

--
-- Table structure for table `niveau`
--

CREATE TABLE `niveau` (
  `idN` int(11) NOT NULL,
  `libelleN` varchar(30) COLLATE utf8mb4_bin NOT NULL,
  `idMontant` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Dumping data for table `niveau`
--

INSERT INTO `niveau` (`idN`, `libelleN`, `idMontant`) VALUES
(1, 'Niveau 1', 1),
(2, 'Niveau 2', 2),
(3, 'Niveau 3', 3);

-- --------------------------------------------------------

--
-- Table structure for table `note_matiere`
--

CREATE TABLE `note_matiere` (
  `idNoteMat` int(11) NOT NULL,
  `note` double DEFAULT NULL,
  `valider` varchar(3) COLLATE utf8mb4_bin DEFAULT NULL,
  `idE` int(11) NOT NULL,
  `idMat` int(11) NOT NULL,
  `annee_univ` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Dumping data for table `note_matiere`
--

INSERT INTO `note_matiere` (`idNoteMat`, `note`, `valider`, `idE`, `idMat`, `annee_univ`) VALUES
(1, 15.5, 'V', 88, 1, 2016),
(2, 15.5, 'V', 88, 2, 2016),
(3, 14, 'V', 89, 1, 2016),
(4, 13.75, 'oui', 90, 1, 2016),
(5, 12.25, 'V', 60, 1, 2016),
(6, 17.5, 'V', 103, 1, 2016),
(7, 18.5, 'oui', 103, 2, 2016),
(21, 13.25, 'V', 56, 1, 2016),
(19, 13.5, 'V', 55, 1, 2016),
(55, 14, 'V', 89, 4, 2016),
(8, 17, 'V', 47, 1, 2016),
(9, 15.75, 'V', 48, 1, 2016),
(10, 16, 'V', 49, 1, 2016),
(11, 14, 'V', 50, 1, 2016),
(12, 14.5, 'V', 51, 1, 2016),
(13, 13.5, 'V', 52, 1, 2016),
(14, 14.5, 'V', 61, 1, 2016),
(15, 10.25, 'V', 57, 1, 2016),
(16, 10, 'V', 54, 1, 2016),
(17, 9.75, 'NV', 59, 1, 2016),
(18, 9, 'NV', 53, 1, 2016),
(20, 8.75, 'NV', 58, 1, 2016),
(22, 14, 'V', 47, 6, 2016),
(23, 16.5, 'V', 47, 2, 2016),
(24, 15, 'V', 47, 3, 2016),
(25, 19, 'V', 47, 4, 2016),
(26, 19.5, 'V', 47, 5, 2016),
(27, 15.25, 'V', 47, 7, 2016),
(28, 13.5, 'V', 55, 3, 2016),
(29, 15.75, 'V', 48, 3, 2016),
(30, 13.5, 'V', 49, 8, 2016),
(31, 16.5, 'V', 47, 8, 2016),
(32, 15.75, 'V', 48, 8, 2016),
(33, 17, 'V', 47, 9, 2016),
(34, 15.75, 'V', 48, 9, 2016),
(35, 13.5, 'V', 47, 10, 2016),
(36, 19.5, 'V', 47, 11, 2016),
(37, 16, 'V', 47, 15, 2016),
(38, 14.75, 'V', 47, 12, 2016),
(39, 17.25, 'V', 47, 13, 2016),
(40, 16.75, 'V', 47, 14, 2016),
(41, 0, 'NV', 50, 4, 2016),
(42, 0, 'NV', 49, 4, 2016),
(43, 0, 'NV', 51, 4, 2016),
(44, 14.2, 'V', 48, 4, 2016),
(45, 12.25, 'V', 52, 4, 2016),
(46, 12, 'V', 50, 3, 2016),
(47, 14, 'V', 49, 3, 2016),
(48, 15, 'V', 111, 1, 2016),
(49, 14, 'V', 78, 1, 2016),
(50, 15, 'V', 114, 1, 2016),
(51, 15, 'V', 111, 1, 2016),
(52, 14, 'V', 78, 1, 2017),
(53, 15, 'V', 114, 1, 2016),
(54, 17.25, 'V', 114, 2, 2016),
(56, 17.5, 'V', 103, 4, 2016),
(57, 11.93, 'V', 114, 4, 2016);

-- --------------------------------------------------------

--
-- Table structure for table `note_module`
--

CREATE TABLE `note_module` (
  `idNoteMod` int(11) NOT NULL,
  `note` double DEFAULT NULL,
  `valider` varchar(3) COLLATE utf8mb4_bin DEFAULT NULL,
  `annee_univ` int(11) NOT NULL,
  `idE` int(11) NOT NULL,
  `idM` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- --------------------------------------------------------

--
-- Table structure for table `note_niveau`
--

CREATE TABLE `note_niveau` (
  `idNoteN` int(11) NOT NULL,
  `note` double DEFAULT NULL,
  `reussi` varchar(3) COLLATE utf8mb4_bin DEFAULT NULL,
  `annee_univ` int(11) NOT NULL,
  `idE` int(11) NOT NULL,
  `idN` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- --------------------------------------------------------

--
-- Table structure for table `note_semester`
--

CREATE TABLE `note_semester` (
  `idNoteS` int(11) NOT NULL,
  `note` double DEFAULT NULL,
  `valider` varchar(3) COLLATE utf8mb4_bin DEFAULT NULL,
  `annee_univ` int(11) NOT NULL,
  `idE` int(11) NOT NULL,
  `idS` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- --------------------------------------------------------

--
-- Table structure for table `paiment`
--

CREATE TABLE `paiment` (
  `idP` int(11) NOT NULL,
  `mode` varchar(30) COLLATE utf8mb4_bin NOT NULL,
  `montant` double NOT NULL,
  `mois` int(11) NOT NULL,
  `annee` int(11) NOT NULL,
  `idE` int(11) NOT NULL,
  `idN` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Dumping data for table `paiment`
--

INSERT INTO `paiment` (`idP`, `mode`, `montant`, `mois`, `annee`, `idE`, `idN`) VALUES
(1, 'cheque', 1000, 12, 2016, 98, 1),
(2, 'cheque', 1200, 12, 2016, 93, 2),
(3, 'cheque', 1400, 12, 2016, 103, 3);

-- --------------------------------------------------------

--
-- Table structure for table `reservation`
--

CREATE TABLE `reservation` (
  `idReservation` int(11) NOT NULL,
  `salle` int(11) NOT NULL,
  `client` int(11) NOT NULL,
  `dateDebut` datetime NOT NULL,
  `dateFin` datetime NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Dumping data for table `reservation`
--

INSERT INTO `reservation` (`idReservation`, `salle`, `client`, `dateDebut`, `dateFin`) VALUES
(1, 2, 1, '2014-01-17 08:00:00', '2014-02-18 09:00:00'),
(2, 2, 2, '2014-01-17 08:00:00', '2014-02-18 09:00:00'),
(3, 2, 2, '2014-01-17 08:00:00', '2014-02-18 09:00:00'),
(4, 2, 1, '2014-01-17 08:00:00', '2014-02-18 09:00:00'),
(5, 2, 1, '2014-01-17 08:00:00', '2014-02-18 09:00:00'),
(6, 2, 2, '2014-01-17 08:00:00', '2014-02-18 09:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `salle`
--

CREATE TABLE `salle` (
  `idSalle` int(11) NOT NULL,
  `nomSalle` varchar(30) COLLATE utf8mb4_bin NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- --------------------------------------------------------

--
-- Table structure for table `semester`
--

CREATE TABLE `semester` (
  `idS` int(11) NOT NULL,
  `libelleS` varchar(30) COLLATE utf8mb4_bin NOT NULL,
  `annee_univ` int(11) NOT NULL,
  `idN` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Dumping data for table `semester`
--

INSERT INTO `semester` (`idS`, `libelleS`, `annee_univ`, `idN`) VALUES
(1, 'S1', 2016, 3),
(2, 'S2', 2016, 3),
(5, 'S1', 2016, 2),
(6, 'S2', 2016, 2),
(8, 'S1', 2016, 1),
(9, 'S2', 2016, 1);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `idU` int(11) NOT NULL,
  `login` varchar(30) COLLATE utf8mb4_bin NOT NULL,
  `password` varchar(30) COLLATE utf8mb4_bin NOT NULL,
  `role` varchar(30) COLLATE utf8mb4_bin DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`idU`, `login`, `password`, `role`) VALUES
(1, 'mostafa', 'achraf', 'agent de saisie');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `affectation`
--
ALTER TABLE `affectation`
  ADD PRIMARY KEY (`idA`);

--
-- Indexes for table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`idClient`);

--
-- Indexes for table `eleve`
--
ALTER TABLE `eleve`
  ADD PRIMARY KEY (`idE`);

--
-- Indexes for table `groupe`
--
ALTER TABLE `groupe`
  ADD PRIMARY KEY (`idG`);

--
-- Indexes for table `inscription`
--
ALTER TABLE `inscription`
  ADD PRIMARY KEY (`idI`);

--
-- Indexes for table `matiere`
--
ALTER TABLE `matiere`
  ADD PRIMARY KEY (`idMat`);

--
-- Indexes for table `module`
--
ALTER TABLE `module`
  ADD PRIMARY KEY (`idM`);

--
-- Indexes for table `montant`
--
ALTER TABLE `montant`
  ADD PRIMARY KEY (`idMontant`);

--
-- Indexes for table `niveau`
--
ALTER TABLE `niveau`
  ADD PRIMARY KEY (`idN`);

--
-- Indexes for table `note_matiere`
--
ALTER TABLE `note_matiere`
  ADD PRIMARY KEY (`idNoteMat`);

--
-- Indexes for table `note_module`
--
ALTER TABLE `note_module`
  ADD PRIMARY KEY (`idNoteMod`);

--
-- Indexes for table `paiment`
--
ALTER TABLE `paiment`
  ADD PRIMARY KEY (`idP`);

--
-- Indexes for table `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`idReservation`);

--
-- Indexes for table `salle`
--
ALTER TABLE `salle`
  ADD PRIMARY KEY (`idSalle`);

--
-- Indexes for table `semester`
--
ALTER TABLE `semester`
  ADD PRIMARY KEY (`idS`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`idU`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `affectation`
--
ALTER TABLE `affectation`
  MODIFY `idA` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=77;
--
-- AUTO_INCREMENT for table `client`
--
ALTER TABLE `client`
  MODIFY `idClient` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `eleve`
--
ALTER TABLE `eleve`
  MODIFY `idE` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=115;
--
-- AUTO_INCREMENT for table `groupe`
--
ALTER TABLE `groupe`
  MODIFY `idG` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT for table `inscription`
--
ALTER TABLE `inscription`
  MODIFY `idI` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=109;
--
-- AUTO_INCREMENT for table `matiere`
--
ALTER TABLE `matiere`
  MODIFY `idMat` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT for table `module`
--
ALTER TABLE `module`
  MODIFY `idM` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;
--
-- AUTO_INCREMENT for table `montant`
--
ALTER TABLE `montant`
  MODIFY `idMontant` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `niveau`
--
ALTER TABLE `niveau`
  MODIFY `idN` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `note_matiere`
--
ALTER TABLE `note_matiere`
  MODIFY `idNoteMat` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=58;
--
-- AUTO_INCREMENT for table `note_module`
--
ALTER TABLE `note_module`
  MODIFY `idNoteMod` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `paiment`
--
ALTER TABLE `paiment`
  MODIFY `idP` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `reservation`
--
ALTER TABLE `reservation`
  MODIFY `idReservation` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `salle`
--
ALTER TABLE `salle`
  MODIFY `idSalle` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `semester`
--
ALTER TABLE `semester`
  MODIFY `idS` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `idU` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

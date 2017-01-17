-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 22, 2016 at 08:55 PM
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
(63, 95, 9);

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
(18, '456389712', 'zeyane', 'aya', 'italia'),
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
(52, '6666666', 'ffffffffffff', 'ffffffffffff', 'ffffffffffff'),
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
(96, '152', 'sssss', 'sssss', 'sssss'),
(97, '78589', 'dffff', 'dffff', 'dffff'),
(98, '1212321', 'teste', 'teste', 'teste'),
(99, '1253', 'pppp', 'pppp', 'pppp'),
(100, '4125', 'swq', 'swq', 'swq');

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
(14, '2016-12-14 00:00:00', 'non affectee', 1, 18),
(15, '2016-12-14 00:00:00', 'non affectee', 2, 19),
(16, '2016-12-14 00:00:00', 'non affectee', 1, 20),
(40, '2016-12-16 00:00:00', 'non affectee', 3, 47),
(18, '2016-12-17 00:00:00', 'non affectee', 1, 24),
(20, '2016-12-14 00:00:00', 'non affectee', 2, 26),
(23, '2016-12-16 00:00:00', 'non affectee', 2, 30),
(22, '2016-12-14 00:00:00', 'non affectee', 2, 28),
(43, '2016-12-16 00:00:00', 'non affectee', 3, 50),
(44, '2016-12-16 00:00:00', 'non affectee', 3, 51),
(45, '2016-12-16 00:00:00', 'non affectee', 3, 52),
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
(89, '2016-12-23 00:00:00', 'non affectee', 1, 96),
(90, '2016-12-22 00:00:00', 'non affectee', 1, 97),
(91, '2016-12-22 00:00:00', 'affectee', 1, 98),
(92, '2016-12-22 00:00:00', 'non affectee', 1, 0),
(93, '2016-12-06 00:00:00', 'affectee', 1, 99),
(94, '2016-11-08 00:00:00', 'affectee', 1, 100);

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
(1, 'mathematique', 10, 1),
(2, 'physique', 10, 1),
(3, 'français', 10, 5),
(4, 'anglais', 10, 5),
(5, 'science', 10, 1),
(6, 'arabe', 10, 5),
(7, 'education islamique', 10, 10),
(8, 'informatique', 10, 1),
(9, 'sport', 10, 8),
(10, 'histoire et géograohie', 10, 10),
(11, 'philosophie', 10, 10),
(12, 'dessin', 10, 8);

-- --------------------------------------------------------

--
-- Table structure for table `module`
--

CREATE TABLE `module` (
  `idM` int(11) NOT NULL,
  `libelleM` varchar(30) COLLATE utf8mb4_bin NOT NULL,
  `validee` varchar(3) COLLATE utf8mb4_bin DEFAULT NULL,
  `moyenne` double DEFAULT NULL,
  `semester` varchar(11) COLLATE utf8mb4_bin NOT NULL,
  `idN` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Dumping data for table `module`
--

INSERT INTO `module` (`idM`, `libelleM`, `validee`, `moyenne`, `semester`, `idN`) VALUES
(1, 'scientifique', NULL, NULL, 'S1', 3),
(5, 'langues', NULL, NULL, 'S1', 3),
(8, 'activités scolaires', NULL, NULL, 'S1', 3),
(10, 'lettre', NULL, NULL, 'S1', 3),
(13, 'Analyse', NULL, NULL, 'S2', 3),
(14, 'Propabilité', NULL, NULL, 'S2', 3),
(15, 'Télecommunication', NULL, NULL, 'S2', 3),
(16, 'Developpement web', NULL, NULL, 'S2', 3);

-- --------------------------------------------------------

--
-- Table structure for table `niveau`
--

CREATE TABLE `niveau` (
  `idN` int(11) NOT NULL,
  `libelleN` varchar(30) COLLATE utf8mb4_bin NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Dumping data for table `niveau`
--

INSERT INTO `niveau` (`idN`, `libelleN`) VALUES
(1, 'Niveau 1'),
(2, 'Niveau 2'),
(3, 'Niveau 3');

-- --------------------------------------------------------

--
-- Table structure for table `note`
--

CREATE TABLE `note` (
  `idNote` int(11) NOT NULL,
  `note` double NOT NULL,
  `valider` varchar(3) COLLATE utf8mb4_bin NOT NULL,
  `idE` int(11) NOT NULL,
  `idMat` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Dumping data for table `note`
--

INSERT INTO `note` (`idNote`, `note`, `valider`, `idE`, `idMat`) VALUES
(1, 15.5, 'oui', 88, 1),
(2, 16.75, 'oui', 88, 2),
(3, 14, 'oui', 89, 1),
(4, 13.75, 'oui', 90, 1),
(5, 12.25, 'oui', 60, 1);

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
-- Indexes for table `niveau`
--
ALTER TABLE `niveau`
  ADD PRIMARY KEY (`idN`);

--
-- Indexes for table `note`
--
ALTER TABLE `note`
  ADD PRIMARY KEY (`idNote`);

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
  MODIFY `idA` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=64;
--
-- AUTO_INCREMENT for table `eleve`
--
ALTER TABLE `eleve`
  MODIFY `idE` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=102;
--
-- AUTO_INCREMENT for table `groupe`
--
ALTER TABLE `groupe`
  MODIFY `idG` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT for table `inscription`
--
ALTER TABLE `inscription`
  MODIFY `idI` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=96;
--
-- AUTO_INCREMENT for table `matiere`
--
ALTER TABLE `matiere`
  MODIFY `idMat` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `module`
--
ALTER TABLE `module`
  MODIFY `idM` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT for table `niveau`
--
ALTER TABLE `niveau`
  MODIFY `idN` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `note`
--
ALTER TABLE `note`
  MODIFY `idNote` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `idU` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

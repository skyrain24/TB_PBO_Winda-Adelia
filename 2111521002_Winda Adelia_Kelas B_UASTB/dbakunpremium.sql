-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 29, 2022 at 01:15 AM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbakunpremium`
--

-- --------------------------------------------------------

--
-- Table structure for table `tblbeliakun`
--

CREATE TABLE `tblbeliakun` (
  `id` int(11) NOT NULL,
  `nama` varchar(20) NOT NULL,
  `layanan` varchar(10) NOT NULL,
  `tarif` int(11) NOT NULL,
  `jangkawaktu` int(11) NOT NULL,
  `total` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tblbeliakun`
--

INSERT INTO `tblbeliakun` (`id`, `nama`, `layanan`, `tarif`, `jangkawaktu`, `total`) VALUES
(111, 'Winda', 'Spotify', 55000, 3, 165000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tblbeliakun`
--
ALTER TABLE `tblbeliakun`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

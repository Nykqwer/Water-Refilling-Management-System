-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Feb 22, 2024 at 08:53 AM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `fhs_station1`
--

-- --------------------------------------------------------

--
-- Table structure for table `credit`
--

CREATE TABLE `credit` (
  `id` int(255) NOT NULL,
  `number_id` varchar(255) CHARACTER SET latin1 NOT NULL,
  `name` char(255) CHARACTER SET latin1 NOT NULL,
  `address` varchar(255) CHARACTER SET latin1 NOT NULL,
  `contact` varchar(255) CHARACTER SET latin1 NOT NULL,
  `no_gallon` varchar(255) CHARACTER SET latin1 NOT NULL,
  `balance` varchar(255) CHARACTER SET latin1 NOT NULL,
  `date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `credit`
--

INSERT INTO `credit` (`id`, `number_id`, `name`, `address`, `contact`, `no_gallon`, `balance`, `date`) VALUES
(418, '1000', 'Mark Secret Shop', 'Prk 11-A poblacion', '09092123412', '4', '80', '2023-07-03'),
(420, '1001', 'Jayvee Gonzales', 'Prk3-A, poblacion', '09242423321', '3', '0', '2023-07-03'),
(421, '1000', 'Mark Secret Shop', 'Prk 11-A poblacion', '09092123412', '4', '80', '2023-07-04'),
(422, '1000', 'Mark Secret Shop', 'Prk 11-A poblacion', '09092123412', '4', '0', '2023-07-04'),
(423, '1000', 'Mark Secret Shop', 'Prk 11-A poblacion', '09092123412', '4', '', '2023-07-14'),
(424, '1000', 'Mark Secret Shop', 'Prk 11-A poblacion', '09092123412', '4', '80', '2023-07-14'),
(425, '1000', 'Mark Secret Shop', 'Prk 11-A poblacion', '09092123412', '4', '0', '2023-07-14');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `id` int(255) NOT NULL,
  `id_number` varchar(255) CHARACTER SET latin1 NOT NULL,
  `customer_name` varchar(255) CHARACTER SET latin1 NOT NULL,
  `address` varchar(255) CHARACTER SET latin1 NOT NULL,
  `contact` varchar(255) CHARACTER SET latin1 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`id`, `id_number`, `customer_name`, `address`, `contact`) VALUES
(16, '1000', 'Mark Secret Shop', 'Prk 11-A poblacion', '09092123412'),
(18, '1001', 'Jayvee Gonzales', 'Prk3-A, poblacion', '09242423321'),
(19, '1002', 'nyko1', 'prk12', '01234913');

-- --------------------------------------------------------

--
-- Table structure for table `dashboard`
--

CREATE TABLE `dashboard` (
  `id` int(255) NOT NULL,
  `sales` varchar(255) NOT NULL,
  `stocks` varchar(255) NOT NULL,
  `balance` varchar(255) NOT NULL,
  `delivered_gallons` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `delivery`
--

CREATE TABLE `delivery` (
  `id` int(255) NOT NULL,
  `id_number` varchar(255) CHARACTER SET latin1 NOT NULL,
  `customer_name` varchar(255) CHARACTER SET latin1 NOT NULL,
  `type` varchar(255) CHARACTER SET latin1 NOT NULL,
  `no_gallon` varchar(255) CHARACTER SET latin1 NOT NULL,
  `price` varchar(255) CHARACTER SET latin1 NOT NULL,
  `status` varchar(255) CHARACTER SET latin1 NOT NULL,
  `date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `delivery`
--

INSERT INTO `delivery` (`id`, `id_number`, `customer_name`, `type`, `no_gallon`, `price`, `status`, `date`) VALUES
(110, '1000', 'Mark Secret Shop', 'Delivery', '4', '80', 'Pending', '2023-07-04'),
(111, '1000', 'Mark Secret Shop', 'Delivery', '4', '80', 'Delivered', '2023-07-04'),
(112, '1000', 'Mark Secret Shop', 'Delivery', '4', '80', 'Pending', '2023-07-14'),
(113, '1000', 'Mark Secret Shop', 'Delivery', '4', '80', 'Delivered', '2023-07-14');

-- --------------------------------------------------------

--
-- Table structure for table `gallon`
--

CREATE TABLE `gallon` (
  `id` int(11) NOT NULL,
  `gallon_slim` varchar(255) NOT NULL,
  `gallon_round` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `gallon`
--

INSERT INTO `gallon` (`id`, `gallon_slim`, `gallon_round`) VALUES
(310, '2', '2'),
(311, '2', '2'),
(312, '1', '1'),
(313, '2', '2'),
(314, '0', '0'),
(315, '1', '0'),
(316, '2', '2'),
(317, '2', '2'),
(318, '2', '2'),
(319, '0', '0'),
(320, '0', '0'),
(321, '2', '2'),
(322, '1', '1'),
(323, '2', '2'),
(324, '1', '0'),
(325, '2', '2'),
(326, '2', '100'),
(327, '2', '2'),
(328, '2', '2'),
(329, '1', '2'),
(330, '2', '2'),
(331, '0', '0'),
(332, '2', '2'),
(333, '2', '2'),
(334, '2', '1'),
(335, '2', '1'),
(336, '2', '2'),
(337, '2', '2'),
(338, '0', '0'),
(339, '2', '2'),
(340, '2', '2'),
(341, '2', '2'),
(342, '2', '2'),
(343, '0', '0'),
(344, '2', '2'),
(345, '1', '1'),
(346, '2', '2'),
(347, '2', '2'),
(348, '2', '2'),
(349, '2', '10'),
(350, '2', '5'),
(351, '2', '2'),
(352, '2', '1'),
(353, '2', '1'),
(354, '0', '0'),
(355, '2', '2'),
(356, '2', '2'),
(357, '2', '1'),
(358, '2', '2'),
(359, '0', '0'),
(360, '2', '1'),
(361, '0', '0'),
(362, '2', '2'),
(363, '0', '0'),
(364, '2', '2'),
(365, '0', '0'),
(366, '2', '1'),
(367, '10', '0'),
(368, '2', '0'),
(369, '2', '1'),
(370, '1', '1'),
(371, '0', '0'),
(372, '2', '2'),
(373, '2', '2'),
(374, '0', '0'),
(375, '2', '2'),
(376, '1', '1'),
(377, '2', '2'),
(378, '2', '2'),
(379, '2', '2'),
(380, '2', '2'),
(381, '0', '0'),
(382, '2', '10'),
(383, '2', '5'),
(384, '0', '0'),
(385, '10', '10'),
(386, '0', '5'),
(387, '0', '0'),
(388, '1', '2'),
(389, '1', '1'),
(390, '0', '0'),
(391, '2', '2'),
(392, '0', '0'),
(393, '1', '1'),
(394, '2', '2'),
(395, '2', '2'),
(396, '0', '0'),
(397, '1', '1'),
(398, '2', '2'),
(399, '3', '3'),
(400, '3', '5'),
(401, '2', '2'),
(402, '2', '1'),
(403, '0', '0'),
(404, '2', '2'),
(405, '0', '0'),
(406, '2', '2'),
(407, '2', '2'),
(408, '0', '0');

-- --------------------------------------------------------

--
-- Table structure for table `inventory`
--

CREATE TABLE `inventory` (
  `id` int(255) NOT NULL,
  `item_name` varchar(255) CHARACTER SET latin1 NOT NULL,
  `quantity` varchar(255) CHARACTER SET latin1 NOT NULL,
  `worth` text NOT NULL,
  `return_gallon` int(255) NOT NULL,
  `fhs_gallon` int(255) NOT NULL,
  `date` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `inventory`
--

INSERT INTO `inventory` (`id`, `item_name`, `quantity`, `worth`, `return_gallon`, `fhs_gallon`, `date`) VALUES
(44, 'gallon-slim', '0', '0', 20, 1000, '2023-07-14 11:02:28'),
(45, 'gallon-round', '126', '3390', 30, 2000, '2023-07-03 06:49:14');

-- --------------------------------------------------------

--
-- Table structure for table `overstock_inventory`
--

CREATE TABLE `overstock_inventory` (
  `id` int(255) NOT NULL,
  `item_name` varchar(255) CHARACTER SET latin1 NOT NULL,
  `return_gallon` int(255) NOT NULL,
  `fhs_gallon` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `overstock_inventory`
--

INSERT INTO `overstock_inventory` (`id`, `item_name`, `return_gallon`, `fhs_gallon`) VALUES
(1, 'gallon-round', 15, 1000),
(2, 'gallon-slim', 130, 1000);

-- --------------------------------------------------------

--
-- Table structure for table `paid`
--

CREATE TABLE `paid` (
  `id` int(255) NOT NULL,
  `id_number` varchar(255) CHARACTER SET latin1 NOT NULL,
  `name` char(255) CHARACTER SET latin1 NOT NULL,
  `address` varchar(255) CHARACTER SET latin1 NOT NULL,
  `type` char(255) CHARACTER SET latin1 NOT NULL,
  `contact` varchar(255) CHARACTER SET latin1 NOT NULL,
  `no_gallon` varchar(255) CHARACTER SET latin1 NOT NULL,
  `price` varchar(255) CHARACTER SET latin1 NOT NULL,
  `balance` varchar(255) CHARACTER SET latin1 NOT NULL,
  `date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `paid`
--

INSERT INTO `paid` (`id`, `id_number`, `name`, `address`, `type`, `contact`, `no_gallon`, `price`, `balance`, `date`) VALUES
(250, '1000', 'Mark Secret Shop', 'Prk 11-A poblacion', 'Walk-in', '09092123412', '4', '60', 'Paid', '2023-07-02'),
(251, '1000', 'Mark Secret Shop', 'Prk 11-A poblacion', 'Walk-in', '09092123412', '2', '30', 'Paid', '2023-07-02'),
(252, '1000', 'Mark Secret Shop', 'Prk 11-A poblacion', 'Walk-in', '09092123412', '4', '60', 'Paid', '2023-07-02'),
(253, '1000', 'Mark Secret Shop', 'Prk 11-A poblacion', 'Walk-in', '09092123412', '4', '60', 'Paid', '2023-07-02'),
(254, '1000', 'Mark Secret Shop', 'Prk 11-A poblacion', 'Walk-in', '09092123412', '4', '60', 'Paid', '2023-07-02'),
(255, '1001', 'Jayvee Gonzales', 'Prk3-A, poblacion', 'Walk-in', '09242423321', '12', '180', 'Paid', '2023-07-02'),
(256, '1000', 'Mark Secret Shop', 'Prk 11-A poblacion', 'Delivery', '09092123412', '3', '60', 'Paid', '2023-07-10'),
(257, '1000', 'Mark Secret Shop', 'Prk 11-A poblacion', 'Delivery', '09092123412', '3', '60', 'Paid', '2023-07-02'),
(258, '1000', 'Mark Secret Shop', 'Prk 11-A poblacion', 'Delivery', '09092123412', '4', '80', 'Paid', '2023-07-02'),
(259, '1002', 'nyko', 'prk12', 'Delivery', '01234913', '3', '60', 'Paid', '2023-07-02'),
(260, '1002', 'nyko', 'prk12', 'Delivery', '01234913', '4', '80', 'Paid', '2023-07-02'),
(261, '1002', 'nyko', 'prk12', 'Delivery', '01234913', '4', '80', 'Paid', '2023-07-02'),
(262, '1000', 'Mark Secret Shop', 'Prk 11-A poblacion', 'Walk-in', '09092123412', '3', '45', 'Paid', '2023-07-02'),
(263, '1002', 'nyko', 'prk12', 'Walk-in', '01234913', '10', '150', 'Paid', '2023-07-02'),
(264, '1002', 'nyko', 'prk12', 'Walk-in', '01234913', '2', '30', 'Paid', '2023-07-02'),
(265, '1000', 'Mark Secret Shop', 'Prk 11-A poblacion', 'Walk-in', '09092123412', '3', '45', 'Paid', '2023-07-02'),
(266, '1000', 'Mark Secret Shop', 'Prk 11-A poblacion', 'Delivery', '09092123412', '2', '40', 'Paid', '2023-07-02'),
(267, '1001', 'Jayvee Gonzales', 'Prk3-A, poblacion', 'Delivery', '09242423321', '4', '80', 'Paid', '2023-07-02'),
(268, '1000', 'Mark Secret Shop', 'Prk 11-A poblacion', 'Walk-in', '09092123412', '4', '60', 'Paid', '2023-07-02'),
(269, '1000', 'Mark Secret Shop', 'Prk 11-A poblacion', 'Walk-in', '09092123412', '4', '60', 'Paid', '2023-07-02'),
(270, '1000', 'Mark Secret Shop', 'Prk 11-A poblacion', 'Walk-in', '09092123412', '4', '60', 'Paid', '2023-07-03'),
(271, '1000', 'Mark Secret Shop', 'Prk 11-A poblacion', 'Delivery', '09092123412', '4', '80', 'Paid', '2023-07-03'),
(272, '1000', 'Mark Secret Shop', 'Prk 11-A poblacion', 'Walk-in', '09092123412', '12', '180', 'Paid', '2023-07-03'),
(273, '1000', 'Mark Secret Shop', 'Prk 11-A poblacion', 'Delivery', '09092123412', '7', '140', 'Paid', '2023-07-03'),
(274, '1000', 'Mark Secret Shop', 'Prk 11-A poblacion', 'Walk-in', '09092123412', '20', '300', 'Paid', '2023-07-03'),
(275, '1000', 'Mark Secret Shop', 'Prk 11-A poblacion', 'Delivery', '09092123412', '5', '100', 'Paid', '2023-07-03'),
(276, '1000', 'Mark Secret Shop', 'Prk 11-A poblacion', 'Walk-in', '09092123412', '3', '45', 'Paid', '2023-07-03'),
(277, '1000', 'Mark Secret Shop', 'Prk 11-A poblacion', 'Delivery', '09092123412', '2', '40', 'Paid', '2023-07-03'),
(278, '1000', 'Mark Secret Shop', 'Prk 11-A poblacion', 'Delivery', '09092123412', '4', '80', 'Paid', '2023-07-03'),
(279, '1000', 'Mark Secret Shop', 'Prk 11-A poblacion', 'Walk-in', '09092123412', '2', '30', 'Paid', '2023-07-03'),
(280, '1000', 'Mark Secret Shop', 'Prk 11-A poblacion', 'Walk-in', '09092123412', '4', '60', 'Paid', '2023-07-03'),
(281, '1000', 'Mark Secret Shop', 'Prk 11-A poblacion', 'Delivery', '09092123412', '4', '80', 'Paid', '2023-07-03'),
(282, '1001', 'Jayvee Gonzales', 'Prk3-A, poblacion', 'Delivery', '09242423321', '3', '60', 'Paid', '2023-07-03'),
(283, '1000', 'Mark Secret Shop', 'Prk 11-A poblacion', 'Delivery', '09092123412', '4', '80', 'Paid', '2023-07-04'),
(284, '1000', 'Mark Secret Shop', 'Prk 11-A poblacion', 'Walk-in', '09092123412', '4', '60', 'Paid', '2023-07-14'),
(285, '1000', 'Mark Secret Shop', 'Prk 11-A poblacion', 'Delivery', '09092123412', '4', '80', 'Paid', '2023-07-14');

-- --------------------------------------------------------

--
-- Table structure for table `pos`
--

CREATE TABLE `pos` (
  `id` int(255) NOT NULL,
  `id_number` varchar(255) CHARACTER SET latin1 NOT NULL,
  `customer_name` char(255) CHARACTER SET latin1 NOT NULL,
  `address` varchar(255) CHARACTER SET latin1 NOT NULL,
  `type` char(255) CHARACTER SET latin1 NOT NULL,
  `contact` varchar(255) CHARACTER SET latin1 NOT NULL,
  `no_gallon` varchar(255) CHARACTER SET latin1 NOT NULL,
  `price` varchar(255) CHARACTER SET latin1 NOT NULL,
  `balance` varchar(255) CHARACTER SET latin1 NOT NULL,
  `date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `sched_delivery`
--

CREATE TABLE `sched_delivery` (
  `id` int(255) NOT NULL,
  `date` date DEFAULT NULL,
  `description` varchar(255) CHARACTER SET latin1 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sched_delivery`
--

INSERT INTO `sched_delivery` (`id`, `date`, `description`) VALUES
(13, '2023-06-28', 'TOMAS\nJV\nNYKO'),
(14, '2023-06-27', 'mark james\njv');

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

CREATE TABLE `transaction` (
  `id` int(255) NOT NULL,
  `id_number` varchar(200) CHARACTER SET latin1 NOT NULL,
  `customer_name` varchar(255) CHARACTER SET latin1 NOT NULL,
  `address` varchar(255) CHARACTER SET latin1 NOT NULL,
  `contact` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `transaction`
--

INSERT INTO `transaction` (`id`, `id_number`, `customer_name`, `address`, `contact`) VALUES
(81, '231', 'nyko', 'prk11-a', '09090909'),
(82, '431241', 'hrllo', '1231', '131231');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `username`, `password`) VALUES
(1, 'admin', 'admin123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `credit`
--
ALTER TABLE `credit`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `dashboard`
--
ALTER TABLE `dashboard`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `delivery`
--
ALTER TABLE `delivery`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `gallon`
--
ALTER TABLE `gallon`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `inventory`
--
ALTER TABLE `inventory`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `overstock_inventory`
--
ALTER TABLE `overstock_inventory`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `paid`
--
ALTER TABLE `paid`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pos`
--
ALTER TABLE `pos`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sched_delivery`
--
ALTER TABLE `sched_delivery`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `transaction`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `credit`
--
ALTER TABLE `credit`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=426;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `dashboard`
--
ALTER TABLE `dashboard`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `delivery`
--
ALTER TABLE `delivery`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=114;

--
-- AUTO_INCREMENT for table `gallon`
--
ALTER TABLE `gallon`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=409;

--
-- AUTO_INCREMENT for table `inventory`
--
ALTER TABLE `inventory`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=46;

--
-- AUTO_INCREMENT for table `overstock_inventory`
--
ALTER TABLE `overstock_inventory`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `paid`
--
ALTER TABLE `paid`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=286;

--
-- AUTO_INCREMENT for table `pos`
--
ALTER TABLE `pos`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=214;

--
-- AUTO_INCREMENT for table `sched_delivery`
--
ALTER TABLE `sched_delivery`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `transaction`
--
ALTER TABLE `transaction`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=83;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 17, 2013 at 12:15 PM
-- Server version: 5.5.32
-- PHP Version: 5.4.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `proekt1`
--
CREATE DATABASE IF NOT EXISTS `proekt1` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `proekt1`;

-- --------------------------------------------------------

--
-- Table structure for table `accounts`
--

CREATE TABLE IF NOT EXISTS `accounts` (
  `account_id` int(10) NOT NULL,
  `iban` varchar(255) NOT NULL,
  `user_id` int(10) NOT NULL,
  `amount` float NOT NULL,
  `currency` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `currencies`
--

CREATE TABLE IF NOT EXISTS `currencies` (
  `name` varchar(255) NOT NULL,
  `rate` double NOT NULL,
  `code` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `transactions`
--

CREATE TABLE IF NOT EXISTS `transactions` (
  `transaction_id` int(10) NOT NULL,
  `accound_id` int(10) NOT NULL,
  `iban` varchar(255) NOT NULL,
  `toiban` varchar(255) NOT NULL,
  `ammount` double NOT NULL,
  `currency` varchar(5) NOT NULL,
  `timestamp` int(11) NOT NULL,
  KEY `transaction_id` (`transaction_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `user_id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'Unic interlan identification',
  `username` varchar(255) NOT NULL COMMENT 'username',
  `password` varchar(255) NOT NULL COMMENT 'password, md5 + salt',
  `name` varchar(255) NOT NULL COMMENT 'First name ',
  `sirname` varchar(255) NOT NULL COMMENT 'Second name',
  `familyname` varchar(255) NOT NULL COMMENT 'Family name',
  `egn` int(10) NOT NULL COMMENT 'EGN',
  `address` varchar(255) NOT NULL COMMENT 'Home address',
  `phone` varchar(255) NOT NULL COMMENT 'Telephone number',
  `email` varchar(50) NOT NULL COMMENT 'Email',
  `usertype` int(1) NOT NULL COMMENT 'Type of the user, admin or normal',
  `pin_code` int(4) NOT NULL COMMENT 'PIN Code',
  `isactive` int(1) NOT NULL COMMENT 'Is the user activated',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `id` (`user_id`),
  KEY `id_2` (`user_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `username`, `password`, `name`, `sirname`, `familyname`, `egn`, `address`, `phone`, `email`, `usertype`, `pin_code`, `isactive`) VALUES
(1, 'test', '74a787a842a6f098abd883cb39dce1a', '', '', '', 0, '', '', '', 0, 0, 1),
(4, 'test2', '3c2131bd3826358a02762f7990da4903', 'Pesho', 'Petrov', 'Kirilov', 1234567890, 'Sofia, 1000', '+359 12345', 'pesho@elubank.com', 0, 1234, 0),
(5, 'test2', '3c2131bd3826358a02762f7990da4903', 'Pesho', 'Petrov', 'Kirilov', 1234567890, 'Sofia, 1000', '+359 12345', 'pesho@elubank.com', 0, 1234, 0),
(6, 'test2', '3c2131bd3826358a02762f7990da4903', 'Pesho', 'Petrov', 'Kirilov', 1234567890, 'Sofia, 1000', '+359 12345', 'pesho@elubank.com', 0, 1234, 0);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- --------------------------------------------------------
-- Хост:                         127.0.0.1
-- Версия сервера:               5.5.37 - MySQL Community Server (GPL)
-- ОС Сервера:                   Win64
-- HeidiSQL Версия:              8.3.0.4694
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Дамп структуры базы данных hospital
DROP DATABASE IF EXISTS `hospital`;
CREATE DATABASE IF NOT EXISTS `hospital` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `hospital`;


-- Дамп структуры для таблица hospital.admissions
DROP TABLE IF EXISTS `admissions`;
CREATE TABLE IF NOT EXISTS `admissions` (
  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `patient_id` smallint(5) unsigned NOT NULL,
  `doctor_id` smallint(5) unsigned NOT NULL,
  `date_of_admission` date NOT NULL,
  `date_of_discharge` date DEFAULT NULL,
  `diagnosis` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_admissions_patients` (`patient_id`),
  KEY `FK_admissions_staff` (`doctor_id`),
  CONSTRAINT `FK_admissions_users` FOREIGN KEY (`patient_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_admissions_users_2` FOREIGN KEY (`doctor_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы hospital.admissions: ~6 rows (приблизительно)
DELETE FROM `admissions`;
/*!40000 ALTER TABLE `admissions` DISABLE KEYS */;
INSERT INTO `admissions` (`id`, `patient_id`, `doctor_id`, `date_of_admission`, `date_of_discharge`, `diagnosis`) VALUES
	(1, 4, 1, '2013-07-05', '2013-07-25', 'ГРЗ'),
	(2, 6, 2, '2013-02-02', '2013-02-12', 'Апендицит'),
	(3, 5, 1, '2014-01-14', '2014-01-24', 'Ангіна'),
	(4, 6, 2, '2014-06-14', NULL, 'Вітрянка'),
	(5, 4, 1, '2014-06-14', NULL, 'Перелом'),
	(6, 5, 1, '2014-06-14', NULL, 'Кір');
/*!40000 ALTER TABLE `admissions` ENABLE KEYS */;


-- Дамп структуры для таблица hospital.assignments
DROP TABLE IF EXISTS `assignments`;
CREATE TABLE IF NOT EXISTS `assignments` (
  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `admission_id` mediumint(8) unsigned NOT NULL,
  `name` varchar(50) NOT NULL,
  `type` enum('medicament','procedure','surgery') NOT NULL,
  `date_of_execution` datetime NOT NULL,
  `performer_id` smallint(5) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_assignments_admissions` (`admission_id`),
  KEY `FK_assignments_users` (`performer_id`),
  CONSTRAINT `FK_assignments_admissions` FOREIGN KEY (`admission_id`) REFERENCES `admissions` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_assignments_users` FOREIGN KEY (`performer_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы hospital.assignments: ~19 rows (приблизительно)
DELETE FROM `assignments`;
/*!40000 ALTER TABLE `assignments` DISABLE KEYS */;
INSERT INTO `assignments` (`id`, `admission_id`, `name`, `type`, `date_of_execution`, `performer_id`) VALUES
	(1, 1, 'Кварц', 'procedure', '2013-06-14 16:00:00', 3),
	(2, 1, 'Антибіотик', 'medicament', '2013-07-15 08:00:00', 3),
	(3, 2, 'Резекція', 'surgery', '2013-02-02 14:00:00', 2),
	(4, 2, 'Тетрациклін', 'medicament', '2014-02-02 20:00:00', 3),
	(5, 3, 'Аспаркам', 'medicament', '2014-06-20 00:00:00', 1),
	(6, 3, 'Магніт', 'procedure', '2014-01-15 10:30:00', 3),
	(7, 4, 'Омосоциклін', 'medicament', '2014-06-15 15:30:00', 2),
	(8, 4, 'Глюкоза', 'medicament', '2014-06-21 15:00:00', NULL),
	(9, 5, 'Лоратадін', 'medicament', '2014-06-20 08:00:00', 1),
	(10, 5, 'Диклофенак', 'medicament', '2014-06-20 10:00:00', 1),
	(11, 6, 'Корвалол', 'medicament', '2014-06-14 10:00:00', 3),
	(12, 6, 'Омокс', 'medicament', '2014-06-19 10:00:00', 1),
	(13, 6, 'Ампицилін', 'medicament', '2014-06-21 12:00:00', NULL),
	(14, 4, 'Хьюмер', 'medicament', '2014-06-20 14:00:00', NULL),
	(15, 5, 'Гепабене', 'medicament', '2014-06-20 15:00:00', 1),
	(16, 4, 'Операція', 'surgery', '2014-06-22 14:00:00', NULL),
	(17, 5, 'Колдфлю', 'medicament', '2014-06-21 14:00:00', NULL),
	(18, 5, 'Гірчичники', 'procedure', '2014-06-22 00:00:00', 3),
	(19, 6, 'Резекція', 'surgery', '2014-06-22 00:00:00', NULL);
/*!40000 ALTER TABLE `assignments` ENABLE KEYS */;


-- Дамп структуры для таблица hospital.roles
DROP TABLE IF EXISTS `roles`;
CREATE TABLE IF NOT EXISTS `roles` (
  `id` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `name` enum('doctor','nurse','patient') NOT NULL,
  `make_an_appointment` enum('Y','N') NOT NULL,
  `do_surgery` enum('Y','N') NOT NULL,
  `give_medicine` enum('Y','N') NOT NULL,
  `carry_out_the_procedure` enum('Y','N') NOT NULL,
  `define_the_diagnosis` enum('Y','N') NOT NULL,
  `take_the_patient` enum('Y','N') NOT NULL,
  `discharged_patients` enum('Y','N') NOT NULL,
  `add_employee` enum('Y','N') NOT NULL,
  `remove_the_employee` enum('Y','N') NOT NULL,
  `view_information_about_yourself` enum('Y','N') NOT NULL,
  `view_information_about_patients` enum('Y','N') NOT NULL,
  `view_information_about_the_staff` enum('Y','N') NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы hospital.roles: ~3 rows (приблизительно)
DELETE FROM `roles`;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` (`id`, `name`, `make_an_appointment`, `do_surgery`, `give_medicine`, `carry_out_the_procedure`, `define_the_diagnosis`, `take_the_patient`, `discharged_patients`, `add_employee`, `remove_the_employee`, `view_information_about_yourself`, `view_information_about_patients`, `view_information_about_the_staff`) VALUES
	(1, 'patient', '', '', '', '', '', '', '', '', '', 'Y', '', 'Y'),
	(2, 'doctor', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', '', '', 'Y', 'Y', 'Y'),
	(3, 'nurse', '', '', 'Y', 'Y', '', 'Y', 'Y', '', '', 'Y', 'Y', 'Y');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;


-- Дамп структуры для таблица hospital.users
DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `surname` varchar(15) NOT NULL,
  `first_name` varchar(15) NOT NULL,
  `patronymic` varchar(15) NOT NULL,
  `date_of_birth` date NOT NULL,
  `address` varchar(30) NOT NULL,
  `phone_number` varchar(15) DEFAULT NULL,
  `role_id` tinyint(3) unsigned NOT NULL,
  `login` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_users_roles` (`role_id`),
  CONSTRAINT `FK_users_roles` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы hospital.users: ~8 rows (приблизительно)
DELETE FROM `users`;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`, `surname`, `first_name`, `patronymic`, `date_of_birth`, `address`, `phone_number`, `role_id`, `login`, `password`) VALUES
	(1, 'Заболотна', 'Аліна', 'Миколаївна', '1977-05-30', 'вул.Квятека,25', '0975853388', 2, 'log1', 'pas1'),
	(2, 'Китюк', 'Григорій', 'Іванович', '1989-10-04', 'вул.Маркіросяна,15', '0553223322', 2, 'log2', 'pas2'),
	(3, 'Панда', 'Аріна', 'Юріївна', '1969-07-11', 'вул.Медвежа,10', '0504338832', 3, 'log3', 'pas3'),
	(4, 'Ковалюк', 'Петро', 'Петрович', '1985-10-22', 'вул.Ільченка,45', '0957473366', 1, 'log4', 'pas4'),
	(5, 'Яворський', 'Антон', 'Іванович', '1990-03-09', 'вул.Петренка,12', '0507473323', 1, 'log5', 'pas5'),
	(6, 'Коровай', 'Ольга', 'Віталіївна', '1965-06-18', 'вул.Гоголя,34', '0934564473', 1, 'log6', 'pas6'),
	(7, 'Кубіков', 'Антон', 'Олегович', '1970-06-05', 'вул.Капіталістів,9', '0987654567', 1, 'log7', 'pas7'),
	(8, 'fefs', 'Леонід', 'fefe', '2014-05-28', 'вул.Капіталістів,9', '0987654567', 1, 'log52', '32323');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

create database api;

CREATE TABLE `api`.`products` (
  `id` INT NOT NULL,
  `description` VARCHAR(50) NOT NULL,
  `price` DOUBLE(12,2) NOT NULL,
  PRIMARY KEY (`id`));
CREATE TABLE `portal`.`user` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `enabled`  BIT NULL DEFAULT 1 ;
  PRIMARY KEY (`user_id`));

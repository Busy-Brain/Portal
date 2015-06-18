CREATE TABLE `portal`.`sites` (
  `site_id` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NULL,
  `title` VARCHAR(60) NULL,
  `enabled` BIT NULL,
  `template_id` VARCHAR(45) NULL,
  PRIMARY KEY (`site_id`));

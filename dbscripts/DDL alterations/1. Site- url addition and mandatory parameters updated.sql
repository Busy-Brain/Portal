ALTER TABLE `portal`.`sites` 
CHANGE COLUMN `name` `name` VARCHAR(45) NOT NULL ,
CHANGE COLUMN `enabled` `enabled` BIT(1) NOT NULL DEFAULT 1 ,
ADD COLUMN `site_url` VARCHAR(45) NOT NULL AFTER `template_id`;


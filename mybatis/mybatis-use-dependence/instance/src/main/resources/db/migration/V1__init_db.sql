

CREATE TABLE IF NOT EXISTS `username_account` (
  `user_id` BIGINT(20) UNSIGNED NOT NULL,
  `username` VARCHAR(256) NOT NULL,
  `password` VARCHAR(256) NOT NULL,
  `create_time` DATETIME NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY username_account_username (`username`)
);
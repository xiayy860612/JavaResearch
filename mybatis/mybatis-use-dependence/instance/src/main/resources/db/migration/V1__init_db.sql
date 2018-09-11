

CREATE TABLE IF NOT EXISTS `username_account` (
  `userId` BIGINT(20) UNSIGNED NOT NULL,
  `userName` VARCHAR(256) NOT NULL,
  `password` VARCHAR(256) NOT NULL,
  `createTime` DATETIME NOT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE KEY username_account_username (`userName`)
);
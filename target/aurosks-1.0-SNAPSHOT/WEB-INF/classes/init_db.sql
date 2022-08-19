CREATE SCHEMA IF NOT EXISTS `auros` DEFAULT CHARACTER SET utf8;
USE
`auros`;
SET NAMES utf8mb4;
SET
FOREIGN_KEY_CHECKS = 0;

CREATE TABLE `knowledge_packages`
(
    `id`          bigint        NOT NULL AUTO_INCREMENT,
    `title`       varchar(250) DEFAULT NULL,
    `description` varchar(2000) NOT NULL,
    `date`        varchar(10)   NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `knowledge_package_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `knowledge_package_sets`
(
    `id`     bigint       NOT NULL AUTO_INCREMENT,
    `title` varchar(250) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `knowledge_package_sets_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `auros`.`k_pac_k_pac_sets`
(
    `knowledge_package_id`     bigint NOT NULL,
    `knowledge_package_set_id` bigint NOT NULL,
    KEY                        `foreign_kpac_set_idx` (`knowledge_package_set_id`),
    KEY                        `foreign_kpac_idx` (`knowledge_package_id`),
    CONSTRAINT `foreign_kpac` FOREIGN KEY (`knowledge_package_id`) REFERENCES `k_pacs` (`id`) ON DELETE CASCADE,
    CONSTRAINT `foreign_kpac_set` FOREIGN KEY (`knowledge_package_set_id`) REFERENCES `k_pac_sets` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3
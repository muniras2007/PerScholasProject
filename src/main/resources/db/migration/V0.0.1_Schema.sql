CREATE TABLE `user` (
                        `first_name` varchar(50) COLLATE utf8mb4_bin NOT NULL,
                        `id` int NOT NULL AUTO_INCREMENT,
                        `username` varchar(45) COLLATE utf8mb4_bin NOT NULL,
                        `password` varchar(250) COLLATE utf8mb4_bin NOT NULL,
                        `email` varchar(45) COLLATE utf8mb4_bin NOT NULL,
                        `last_name` varchar(45) COLLATE utf8mb4_bin NOT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

CREATE TABLE `user_roles` (
                              `id` int NOT NULL AUTO_INCREMENT,
                              `user_role` varchar(45) NOT NULL,
                              `user_id` int NOT NULL,
                              PRIMARY KEY (`id`),
                              KEY `FKuserid_idx` (`user_id`),
                              CONSTRAINT `FKuserid` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `product` (
                           `product_name` varchar(50) NOT NULL,
                           `id` int NOT NULL AUTO_INCREMENT,
                           `price` int NOT NULL,
                           `product_description` varchar(100) DEFAULT NULL,
                           `image_url` varchar(350) DEFAULT NULL,
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `orders` (
                          `id` int NOT NULL AUTO_INCREMENT,
                          `order_date` date DEFAULT NULL,
                          `shipped_date` date DEFAULT NULL,
                          `status` varchar(45) COLLATE utf8mb4_bin DEFAULT NULL,
                          `user_id` int DEFAULT NULL,
                          PRIMARY KEY (`id`),
                          KEY `FK_userid_idx` (`user_id`),
                          CONSTRAINT `FK_userid` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

CREATE TABLE `order_products` (
                                  `id` int NOT NULL AUTO_INCREMENT,
                                  `quantity` int DEFAULT NULL,
                                  `product_id` int NOT NULL,
                                  `order_id` int NOT NULL,
                                  PRIMARY KEY (`id`),
                                  KEY `FK_productid_idx` (`product_id`),
                                  KEY `FK_orderid_idx` (`order_id`),
                                  CONSTRAINT `FK_orderid` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`),
                                  CONSTRAINT `FK_productid` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin




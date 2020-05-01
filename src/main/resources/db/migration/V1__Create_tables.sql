CREATE TABLE `product` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`title` varchar(25) NOT NULL,
`description` text NOT NULL,
`price` decimal(10,2) NOT NULL,
`created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
`updated_at` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP,
`category_id` int(11) NOT NULL,
PRIMARY KEY (`id`)
);
CREATE TABLE `category` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`title` varchar(50) NOT NULL,
PRIMARY KEY (`id`)
);

ALTER TABLE `product` ADD CONSTRAINT `fk_product_category` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`);
CREATE SEQUENCE seq_product_id;

CREATE TABLE products (
	product_id INT DEFAULT NEXTVAL('seq_product_id') PRIMARY KEY,
	name VARCHAR(256) NOT NULL,
	description TEXT NOT NULL,
	price NUMERIC (4,2) NOT NULL,
	image_name VARCHAR(128) NOT NULL
);

CREATE SEQUENCE seq_order_id;

CREATE TABLE orders (
	order_id INT DEFAULT NEXTVAL('seq_order_id') PRIMARY KEY,
	customer_name VARCHAR(128) NOT NULL,
	street_address1 VARCHAR(128) NOT NULL,
	street_address2 VARCHAR(128),
	city VARCHAR(64) NOT NULL,
	state CHAR(2) NOT NULL,
	zip_code INT NOT NULL
);

CREATE TABLE order_items (
	order_id INT NOT NULL,
	product_id INT NOT NULL,
	quantity INT NOT NULL,
	CONSTRAINT fk_order_item_order_id FOREIGN KEY(order_id) REFERENCES orders(order_id),
	CONSTRAINT fk_order_item_product_id FOREIGN KEY(product_id) REFERENCES products(product_id)
);

INSERT INTO products (name, description, price, image_name) VALUES ('Cat', 'This one of a kind cat comes complete with fur, whiskers, and claws. For a limited time it meows when hungry!', 49.99, 'cat.png'); 
INSERT INTO products (name, description, price, image_name) VALUES ('Dog', 'Bark, Woof, Scratch, Lick. These are just a few things you can expect when you order this rare good boy!', 79.49, 'dog.png'); 
INSERT INTO products (name, description, price, image_name) VALUES ('Chicken', 'WARNING: DO NOT EAT! This little guy is meant for pets, clucks, and good times. You will not regret your purchase!', 15.00, 'chicken.png');
INSERT INTO products (name, description, price, image_name) VALUES ('Lizard', 'The new, not slimy edition is jam packed with scales and extra long tongues. For best results keep warm.', 99.99, 'lizard.png');  

ALTER TABLE products 
ADD COLUMN avg_rating NUMERIC (3,2);

UPDATE products
SET avg_rating = 5
WHERE product_id = 1;

UPDATE products
SET avg_rating = 3.5
WHERE product_id = 2;

UPDATE products
SET avg_rating = 4.2
WHERE product_id = 3;

UPDATE products
SET avg_rating = 2.7
WHERE product_id = 4;

ALTER TABLE products
ALTER COLUMN avg_rating SET NOT NULL;

ALTER TABLE orders
ALTER COLUMN zip_code TYPE VARCHAR;

ALTER TABLE orders
ALTER COLUMN zip_code SET NOT NULL;
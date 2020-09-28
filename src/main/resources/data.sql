-- 
-- Creata table prices and fields
--
DROP TABLE IF EXISTS Prices;
	 
CREATE TABLE Prices (
	ID Number NOT NULL,
	BRAND_ID VARCHAR(1) NOT NULL,
	START_DATE Timestamp NOT NULL,
	END_DATE Timestamp NOT NULL,
	PRICE_LIST VARCHAR(1) NOT NULL,
	PRODUCT_ID VARCHAR(5) NOT NULL,
	PRIORITY Int NOT NULL,
	PRICE Decimal NOT NULL,
	CURR VARCHAR(3) NOT NULL
);	 
	 
INSERT INTO Prices (ID, BRAND_ID, START_DATE, END_DATE, PRICE_LIST, PRODUCT_ID, PRIORITY, PRICE, CURR) VALUES
(1, '1', {ts '2020-06-14 00:00:00'}, {ts '2020-12-31 23:59:59'}, '1', '35455', 0, 35.50, 'EUR'),
(2, '1', {ts '2020-06-14 15.00.00'}, {ts '2020-06-14 18.30.00'}, '2', '35455', 1, 25.45, 'EUR'),
(3, '1', {ts '2020-06-15 00.00.00'}, {ts '2020-06-15 11.00.00'}, '3', '35455', 1, 35.50, 'EUR'),
(4, '1', {ts '2020-06-15 16.00.00'}, {ts '2020-12-31 23.59.59'}, '4', '35455', 1, 38.95, 'EUR');

/**
* Name: AddInventoryItems
* Author: Seth Clossman
* Desc: Adds items to the inventory table
* Inputs:
* - Name: The name of the item
* - Price: Price in double format of the itme
* - PriceMetric: By default, lbs, otherwise how each item is priced
**/

DELIMITER //

CREATE PROCEDURE AddInventoryItem(
	IN Name VARCHAR(255),
    IN Price DOUBLE,
    IN PriceMetric VARCHAR(255)
)
BEGIN
	INSERT INTO drivenowdb.inventory (name, price, price_metric)
    VALUES (Name, Price, PriceMetric);
END //

DELIMITER ;
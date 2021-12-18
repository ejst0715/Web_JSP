CREATE TABLE TB_COIN(
	MARKETNAME VARCHAR(20) NOT NULL,
	COINPRICEKOR INT NOT NULL,
	COINPRICEENG INT NOT NULL,
	COINRATE INT,
	COINRATEPCT FLOAT,
	COINPREMIUM FLOAT,
	COINDEAL INT
);

SELECT * FROM TB_COIN;

drop table TB_COIN;
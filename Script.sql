--<ScriptOptions statementTerminator=";"/>

ALTER TABLE `database`.`purchaseinfo` DROP INDEX `database`.`Srnomaster_idx`;

DROP TABLE `database`.`purchaseinfo`;

CREATE TABLE `database`.`purchaseinfo` (
	`Srnomaster` INT,
	`Srno` INT,
	`DealerName` VARCHAR(45) DEFAULT Transfort Charge,
	`MobileNO` VARCHAR(45),
	`EmailId` VARCHAR(45),
	`Date` VARCHAR(45),
	`Category` VARCHAR(45),
	`Brand` VARCHAR(45),
	`ProductName` VARCHAR(45),
	`MRPPrice` DOUBLE,
	`FreeItem` VARCHAR(50),
	`FreeItemAmt` DOUBLE,
	`FreeItemQty` DOUBLE,
	`FreeItemTotalAmt` DOUBLE,
	`Qty` VARCHAR(50),
	`Qty Type` VARCHAR(45),
	`RateUnit` DOUBLE,
	`SchPer` DOUBLE,
	`SchAmt` DOUBLE,
	`VatPer` DOUBLE,
	`VAtAmount` DOUBLE,
	`NetAmtTotal` DOUBLE
) ENGINE=InnoDB;

CREATE INDEX `Srnomaster_idx` ON `database`.`purchaseinfo` (`Srnomaster` ASC);


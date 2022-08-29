USE master
GO

DROP DATABASE IF EXISTS Demo
GO

CREATE DATABASE Demo
GO 

USE Demo
GO

CREATE TABLE PRODUCTO (
    CODPRO varchar(10)  NOT NULL,
    NOMPRO varchar(40)  NULL,
    DESPRO varchar(60)  NULL,
    PREPRO decimal(8,2)  NULL,
	IMAPRO varchar(60) NULL,
	STOCPRO int NOT NULL,
	CATPRO varchar(10) NULL,
    ESTPRO char(1)  NULL,
    CONSTRAINT PRODUCTO_pk PRIMARY KEY  (CODPRO)
);

INSERT INTO PRODUCTO
(CODPRO,NOMPRO,DESPRO,PREPRO,IMAPRO,STOCPRO,CATPRO,ESTPRO)
VALUES
('C0101','HAWAIANA','¡El paraiso en la mesa',16.00,'Imagen1.PC',10,'Personal','A'),
('C0102','HAWAIANA','¡El paraiso en la mesa',45.00,'Imagen1.PC',10,'Mediana','A'),
('C0103','HAWAIANA','¡El paraiso en la mesa',65.00,'Imagen1.PC',10,'Familiar','A'),
('C0104','HAWAIANA','¡El paraiso en la mesa',55.00,'Imagen1.PC',10,'Grande','A'),
('C0105','CHICKEN BBQ','Exquisita combinacion de pollo',16.00,'descarga.PC',10,'Personal','A'),
('C0106','CHICKEN BBQ','Exquisita combinacion de pollo',45.00,'descarga.PC',10,'Mediana','A'),
('C0107','CHICKEN BBQ','Exquisita combinacion de pollo',65.00,'descarga.PC',10,'Familiar','A'),
('C0108','CHICKEN BBQ','Exquisita combinacion de pollo',55.00,'descarga.PC',10,'Grande','A'),
('C0109','La CHILI HUT','Deliciosa combinacion de piña',16.00,'Imagen2.PC',8,'Personal','A'),
('C0110','La CHILI HUT','Deliciosa combinacion de piña',45.00,'Imagen2.PC',8,'Mediana','A'),
('C0111','La CHILI HUT','Deliciosa combinacion de piña',65.00,'Imagen2.PC',8,'Familiar','A'),
('C0112','La CHILI HUT','Deliciosa combinacion de piña',55.00,'Imagen2.PC',8,'Grande','A');
GO

UPDATE PRODUCTO SET NOMPRO =?,DESPRO=?,PREPRO=?,IMAPRO=?,STOCPRO=?,CATPRO=?,ESTPRO=? WHERE CODPRO = ?

select * from PRODUCTO
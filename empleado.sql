DROP TABLE EMPLEADO;

CREATE TABLE empleado (
    numero    		INTEGER primary key,
    nombre	    	VARCHAR(20),
    apellido    	VARCHAR(20),
    foto  	        VARCHAR(20),
    sueldo	    	NUMERIC(6,2), 
    sueldoMaximo  	NUMERIC(6,2), 
    fechaAlta  		DATE 
);

INSERT INTO empleado VALUES (1001,'Manuel','PEREZ','1001.jpg',1500,2900,TO_DATE('2018-10-17', '%Y-%m-%d'));
INSERT INTO empleado VALUES (1002,'Antonio','PRADO','1002.jpg',1000,2500,TO_DATE('2019-11-01', '%Y-%m-%d'));
INSERT INTO empleado VALUES (1003,'Gonzalo','GONZALEZ','default.jpg',900,1300,TO_DATE('2019-01-05', '%Y-%m-%d'));
INSERT INTO empleado VALUES (1004,'Sebastian','SASTRE','1004.jpg',1200,2000,TO_DATE('2019-08-14', '%Y-%m-%d'));
INSERT INTO empleado VALUES (1005,'Amalia','PAZ','1005.jpg',1100,1700,TO_DATE('2021-06-20', '%Y-%m-%d'));
INSERT INTO empleado VALUES (1006,'Manuel','DOMINGUEZ','default.jpg',1900,2300,TO_DATE('2021-05-28', '%Y-%m-%d'));
INSERT INTO empleado VALUES (1007,'Sabrina','GARCIA','1007.jpg',800,1900,TO_DATE('2019-03-10', '%Y-%m-%d'));
INSERT INTO empleado VALUES (1008,'Pascual','LOPEZ','1008.jpg',1200,1900,TO_DATE('2020-07-11', '%Y-%m-%d'));
INSERT INTO empleado VALUES (1009,'Luna','RUANO','1009.jpg',1500,2100,TO_DATE('2020-06-12', '%Y-%m-%d'));
INSERT INTO empleado VALUES (1010,'Maria','SALAZAR','1010.jpg',600,1500,TO_DATE('2021-11-21', '%Y-%m-%d'));
INSERT INTO empleado VALUES (1011,'Sara','SANCHEZ','1011.jpg',900,1800,TO_DATE('2021-10-27', '%Y-%m-%d'));
INSERT INTO empleado VALUES (1012,'Marcos','MORENO','1012.jpg',1200,2500,TO_DATE('2017-10-03', '%Y-%m-%d'));
INSERT INTO empleado VALUES (1013,'Juan','PEREZ','1013.jpg',950,1600,TO_DATE('2014-02-01', '%Y-%m-%d'));
INSERT INTO empleado VALUES (1014,'Alfonso','RUIZ','default.jpg',1600,2000,TO_DATE('2019-03-24', '%Y-%m-%d'));
INSERT INTO empleado VALUES (1015,'Ana','HERNANDEZ','1015.jpg',1700,1800,TO_DATE('2021-04-10', '%Y-%m-%d'));
INSERT INTO empleado VALUES (1016,'Teo','GOMEZ','default.jpg',1550,2400,TO_DATE('2021-03-18', '%Y-%m-%d'));
INSERT INTO empleado VALUES (1017,'Marta','GARCIA','1017.jpg',950,1200,TO_DATE('2019-08-20', '%Y-%m-%d'));
INSERT INTO empleado VALUES (1018,'Francisco','LOPEZ','1018.jpg',1300,1500,TO_DATE('2020-09-21', '%Y-%m-%d'));
INSERT INTO empleado VALUES (1019,'Mar','GARCIA','1019.jpg',1300,2100,TO_DATE('2020-07-11', '%Y-%m-%d'));
INSERT INTO empleado VALUES (1020,'Julia','MORENO','1020.jpg',1600,2500,TO_DATE('2021-10-11', '%Y-%m-%d'));
INSERT INTO empleado VALUES (1021,'Maria','SANCHEZ','1021.jpg',900,1800,TO_DATE('2021-11-23', '%Y-%m-%d'));
INSERT INTO empleado VALUES (1022,'Marcos','MORENO','1022.jpg',1200,2500,TO_DATE('2017-09-04', '%Y-%m-%d'));
INSERT INTO empleado VALUES (1023,'Amalia','GONZALEZ','default.jpg',950,1600,TO_DATE('2018-02-02', '%Y-%m-%d'));
INSERT INTO empleado VALUES (1024,'Manuel','GARCIA','default.jpg',1600,2000,TO_DATE('2019-04-25', '%Y-%m-%d'));
INSERT INTO empleado VALUES (1025,'Ana','GONZALEZ','1025.jpg',1700,1800,TO_DATE('2021-09-11', '%Y-%m-%d'));
INSERT INTO empleado VALUES (1026,'Amalia','GOMEZ','default.jpg',1550,2400,TO_DATE('2021-10-15', '%Y-%m-%d'));
INSERT INTO empleado VALUES (1027,'Manuel','GARCIA','default.jpg',950,1200,TO_DATE('2019-07-25', '%Y-%m-%d'));
INSERT INTO empleado VALUES (1028,'Francisco','LOPEZ','1028.jpg',1300,1500,TO_DATE('2020-06-29', '%Y-%m-%d'));
INSERT INTO empleado VALUES (1029,'Maria','GARCIA','1029.jpg',1300,2100,TO_DATE('2020-07-15', '%Y-%m-%d'));
INSERT INTO empleado VALUES (1030,'Sara','MORENO','1030.jpg',1600,2500,TO_DATE('2021-10-15', '%Y-%m-%d'));

SELECT *
FROM empleado;

SELECT *
FROM empleado
WHERE sueldo+500 > sueldoMaximo;

SELECT *
FROM empleado
WHERE apellido = 'GARCIA';

SELECT sum (sueldo)
FROM empleado
WHERE apellido = 'GARCIA';

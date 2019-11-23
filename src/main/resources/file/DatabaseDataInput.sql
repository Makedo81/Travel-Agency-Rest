
INSERT INTO CITIES (CITY_ID,CITY)
VALUES (1,'Warsaw');
INSERT INTO CITIES (CITY_ID, CITY)
VALUES (2,'Danzig');
INSERT INTO CITIES (CITY_ID, CITY)
VALUES (3,'Breslau');
INSERT INTO CITIES (CITY_ID, CITY)
VALUES (4,'Krakow');

INSERT INTO CITIES (CITY_ID, CITY)
VALUES (5,'Rome');
INSERT INTO CITIES (CITY_ID, CITY)
VALUES (6,'Venezia');
INSERT INTO CITIES (CITY_ID, CITY)
VALUES (7,'Verona');
INSERT INTO CITIES (CITY_ID, CITY)
VALUES (8,'Parma');

INSERT INTO CITIES (CITY_ID, CITY)
VALUES (9,'New York');
INSERT INTO CITIES (CITY_ID, CITY)
VALUES (10,'Las Vegas');
INSERT INTO CITIES (CITY_ID, CITY)
VALUES (11,'California');
INSERT INTO CITIES (CITY_ID, CITY)
VALUES (12,'San Franciso');

INSERT INTO CITIES (CITY_ID, CITY)
VALUES (13,'Berlin');
INSERT INTO CITIES (CITY_ID, CITY)
VALUES (14,'Cologne');
INSERT INTO CITIES (CITY_ID, CITY)
VALUES (15,'Hamburg');
INSERT INTO CITIES (CITY_ID, CITY)
VALUES (16,'Dresden');

INSERT INTO COUNTRIES (COUNTRY_ID,COUNTRY)
VALUES (1,'Poland');
INSERT INTO COUNTRIES (COUNTRY_ID,COUNTRY)
VALUES (2,'Italy');
INSERT INTO COUNTRIES (COUNTRY_ID,COUNTRY)
VALUES (3,'USA');
INSERT INTO COUNTRIES (COUNTRY_ID,COUNTRY)
VALUES (4,'Germany');

INSERT INTO country_city (COUNTRY_ID,CITY_ID)
VALUES (1,1);
INSERT INTO country_city (COUNTRY_ID,CITY_ID)
VALUES (1,2);
INSERT INTO country_city (COUNTRY_ID,CITY_ID)
VALUES (1,3);
INSERT INTO country_city (COUNTRY_ID,CITY_ID)
VALUES (1,4);

INSERT INTO country_city (COUNTRY_ID,CITY_ID)
VALUES (2,5);
INSERT INTO country_city (COUNTRY_ID,CITY_ID)
VALUES (2,6);
INSERT INTO country_city (COUNTRY_ID,CITY_ID)
VALUES (2,7);
INSERT INTO country_city (COUNTRY_ID,CITY_ID)
VALUES (2,8);

INSERT INTO country_city (COUNTRY_ID,CITY_ID)
VALUES (3,9);
INSERT INTO country_city (COUNTRY_ID,CITY_ID)
VALUES (3,10);
INSERT INTO country_city (COUNTRY_ID,CITY_ID)
VALUES (3,11);
INSERT INTO country_city (COUNTRY_ID,CITY_ID)
VALUES (3,12);

INSERT INTO country_city (COUNTRY_ID,CITY_ID)
VALUES (4,13);
INSERT INTO country_city (COUNTRY_ID,CITY_ID)
VALUES (4,14);
INSERT INTO country_city (COUNTRY_ID,CITY_ID)
VALUES (4,15);
INSERT INTO country_city (COUNTRY_ID,CITY_ID)
VALUES (4,16);

insert into meal_type (meal_id,meal_type)
values (1,'ONLY_BREAKFAST');
insert into meal_type(meal_id,meal_type)
values (2,'ONLY_DINNER');
insert into meal_type (meal_id,meal_type)
values (3,'BREAKFAST_LUNCH_DINNER');
insert into meal_type (meal_id,meal_type)
values (4,'NO_MEAL');

insert into hotels (hotel_id,hotel_name,country_id,city_id)
values (1,'Mariott',1,1);
insert into hotels (hotel_id,hotel_name,country_id,city_id)
values (2,'Mariott',1,2);
insert into hotels (hotel_id,hotel_name,country_id,city_id)
values (3,'Mariott',1,3);
insert into hotels (hotel_id,hotel_name,country_id,city_id)

values (4,'Sobieski',1,3);
insert into hotels (hotel_id,hotel_name,country_id,city_id)
values (5,'Sobieski',1,4);
insert into hotels (hotel_id,hotel_name,country_id,city_id)
values (6,'Sobieski',1,1);

insert into hotels (hotel_id,hotel_name,country_id,city_id)
values (7,'LaRoma',2,5);
insert into hotels (hotel_id,hotel_name,country_id,city_id)
values (8,'IlSole',2,6);
insert into hotels (hotel_id,hotel_name,country_id,city_id)
values (9,'ParkInn',2,7);
insert into hotels (hotel_id,hotel_name,country_id,city_id)
values (10,'ParkInn',2,8);

insert into hotels (hotel_id,hotel_name,country_id,city_id)
values (11,'Hilton',2,9);
insert into hotels (hotel_id,hotel_name,country_id,city_id)
values (12,'LaRoma',2,10);
insert into hotels (hotel_id,hotel_name,country_id,city_id)
values (13,'LaTrevi',2,11);
insert into hotels (hotel_id,hotel_name,country_id,city_id)
values (14,'VeronaHotel',2,12);

insert into hotels (hotel_id,hotel_name,country_id,city_id)
values (15,'MotelOne',3,13);
insert into hotels (hotel_id,hotel_name,country_id,city_id)
values (16,'Quinn',3,14);
insert into hotels (hotel_id,hotel_name,country_id,city_id)
values (17,'Avenue Inn',3,15);
insert into hotels (hotel_id,hotel_Name,country_id,city_id)
values (18,'ParkInn',3,16);
insert into hotels (hotel_id,hotel_name,country_id,city_id)
values (19,'Carlton',4,16);
insert into hotels (hotel_id,hotel_name,country_id,city_id)
values (20,'Hotel Polski',1,4);
insert into hotels (hotel_id,hotel_name,country_id,city_id)
values (21,'NH Hotel',4,15);
insert into hotels (hotel_id,hotel_name,country_id,city_id)
values (22,'ParkInn',4,15);
insert into hotels (hotel_id,hotel_name,country_id,city_id)
values (23,'Hilton-NewYork',3,15);

insert into hotels (hotel_id,hotel_name,country_id,city_id)
values (24,'MotelOne',3,11);
insert into hotels (hotel_id,hotel_name,country_id,city_id)
values (25,'Quinn',3,11);
insert into hotels (hotel_id,hotel_name,country_id,city_id)
values (26,'Avenue Inn',3,11);
insert into hotels (hotel_id,hotel_Name,country_id,city_id)
values (27,'ParkInn',3,11);
insert into hotels (hotel_id,hotel_name,country_id,city_id)
values (28,'Carlton',3,12);
insert into hotels (hotel_id,hotel_name,country_id,city_id)
values (29,'Hotel Polski',3,4);
insert into hotels (hotel_id,hotel_name,country_id,city_id)
values (30,'NH Hotel',3,12);
insert into hotels (hotel_id,hotel_name,country_id,city_id)
values (31,'ParkInn',3,12);
insert into hotels (hotel_id,hotel_name,country_id,city_id)
values (32,'Hilton-NewYork',3,12);

insert into meals_prices (price,hotel_id,meal_type_id)
values (8,1,1);
insert into meals_prices (price,hotel_id,meal_type_id)
values (10,1,2);
insert into meals_prices (price,hotel_id,meal_type_id)
values (15,1,3);
insert into meals_prices (price,hotel_id,meal_type_id)
values (0,1,4);

insert into meals_prices (price,hotel_id,meal_type_id)
values (10,2,1);
insert into meals_prices (price,hotel_id,meal_type_id)
values (12,2,2);
insert into meals_prices (price,hotel_id,meal_type_id)
values (18,2,3);
insert into meals_prices (price,hotel_id,meal_type_id)
values (0,2,4);


insert into meals_prices (price,hotel_id,meal_type_id)
values (7,3,1);
insert into meals_prices (price,hotel_id,meal_type_id)
values (10,3,2);
insert into meals_prices (price,hotel_id,meal_type_id)
values (14,3,3);
insert into meals_prices (price,hotel_id,meal_type_id)
values (0,3,4);


insert into meals_prices (price,hotel_id,meal_type_id)
values (8,4,1);
insert into meals_prices (price,hotel_id,meal_type_id)
values (11,4,2);
insert into meals_prices (price,hotel_id,meal_type_id)
values (24,4,3);
insert into meals_prices (price,hotel_id,meal_type_id)
values (0,4,4);

insert into meals_prices (price,hotel_id,meal_type_id)
values (9,5,1);
insert into meals_prices (price,hotel_id,meal_type_id)
values (10,5,2);
insert into meals_prices (price,hotel_id,meal_type_id)
values (28,5,3);
insert into meals_prices (price,hotel_id,meal_type_id)
values (0,5,4);

insert into meals_prices (price,hotel_id,meal_type_id)
values (8,6,1);
insert into meals_prices (price,hotel_id,meal_type_id)
values (10,6,2);
insert into meals_prices (price,hotel_id,meal_type_id)
values (35,6,3);
insert into meals_prices (price,hotel_id,meal_type_id)
values (0,6,4);

insert into meals_prices (price,hotel_id,meal_type_id)
values (8,7,1);
insert into meals_prices (price,hotel_id,meal_type_id)
values (12,7,2);
insert into meals_prices (price,hotel_id,meal_type_id)
values (19,7,3);
insert into meals_prices (price,hotel_id,meal_type_id)
values (0,7,4);


insert into meals_prices (price,hotel_id,meal_type_id)
values (12,8,1);
insert into meals_prices (price,hotel_id,meal_type_id)
values (18,8,2);
insert into meals_prices (price,hotel_id,meal_type_id)
values (23,8,3);
insert into meals_prices (price,hotel_id,meal_type_id)
values (0,8,4);


insert into meals_prices (price,hotel_id,meal_type_id)
values (10,9,1);
insert into meals_prices (price,hotel_id,meal_type_id)
values (15,9,2);
insert into meals_prices (price,hotel_id,meal_type_id)
values (30,9,3);
insert into meals_prices (price,hotel_id,meal_type_id)
values (0,9,4);


insert into meals_prices (price,hotel_id,meal_type_id)
values (13,10,1);
insert into meals_prices (price,hotel_id,meal_type_id)
values (16,10,2);
insert into meals_prices (price,hotel_id,meal_type_id)
values (25,10,3);
insert into meals_prices (price,hotel_id,meal_type_id)
values (0,10,4);


insert into meals_prices (price,hotel_id,meal_type_id)
values (10,11,1);
insert into meals_prices (price,hotel_id,meal_type_id)
values (16,11,2);
insert into meals_prices (price,hotel_id,meal_type_id)
values (19,11,3);
insert into meals_prices (price,hotel_id,meal_type_id)
values (0,11,4);


insert into meals_prices (price,hotel_id,meal_type_id)
values (7,12,1);
insert into meals_prices (price,hotel_id,meal_type_id)
values (10,12,2);
insert into meals_prices (price,hotel_id,meal_type_id)
values (30,12,3);
insert into meals_prices (price,hotel_id,meal_type_id)
values (0,12,4);

insert into meals_prices (price,hotel_id,meal_type_id)
values (7,13,1);
insert into meals_prices (price,hotel_id,meal_type_id)
values (10,13,2);
insert into meals_prices (price,hotel_id,meal_type_id)
values (30,13,3);
insert into meals_prices (price,hotel_id,meal_type_id)
values (0,13,4);

insert into meals_prices (price,hotel_id,meal_type_id)
values (7,14,1);
insert into meals_prices (price,hotel_id,meal_type_id)
values (10,14,2);
insert into meals_prices (price,hotel_id,meal_type_id)
values (30,14,3);
insert into meals_prices (price,hotel_id,meal_type_id)
values (0,14,4);

insert into meals_prices (price,hotel_id,meal_type_id)
values (7,15,1);
insert into meals_prices (price,hotel_id,meal_type_id)
values (10,15,2);
insert into meals_prices (price,hotel_id,meal_type_id)
values (30,15,3);
insert into meals_prices (price,hotel_id,meal_type_id)
values (0,15,4);

insert into meals_prices (price,hotel_id,meal_type_id)
values (10,16,1);
insert into meals_prices (price,hotel_id,meal_type_id)
values (10,16,2);
insert into meals_prices (price,hotel_id,meal_type_id)
values (30,16,3);
insert into meals_prices (price,hotel_id,meal_type_id)
values (0,16,4);

insert into meals_prices (price,hotel_id,meal_type_id)
values (8,17,1);
insert into meals_prices (price,hotel_id,meal_type_id)
values (12,17,2);
insert into meals_prices (price,hotel_id,meal_type_id)
values (19,17,3);
insert into meals_prices (price,hotel_id,meal_type_id)
values (0,17,4);

insert into meals_prices (price,hotel_id,meal_type_id)
values (8,18,1);
insert into meals_prices (price,hotel_id,meal_type_id)
values (12,18,2);
insert into meals_prices (price,hotel_id,meal_type_id)
values (19,18,3);
insert into meals_prices (price,hotel_id,meal_type_id)
values (0,18,4);

insert into meals_prices (price,hotel_id,meal_type_id)
values (8,19,1);
insert into meals_prices (price,hotel_id,meal_type_id)
values (12,19,2);
insert into meals_prices (price,hotel_id,meal_type_id)
values (19,19,3);
insert into meals_prices (price,hotel_id,meal_type_id)
values (0,19,4);

insert into meals_prices (price,hotel_id,meal_type_id)
values (8,20,1);
insert into meals_prices (price,hotel_id,meal_type_id)
values (12,20,2);
insert into meals_prices (price,hotel_id,meal_type_id)
values (19,20,3);
insert into meals_prices (price,hotel_id,meal_type_id)
values (0,20,4);

insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-11-10','2019-12-20',1,1,120);
insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-11-20','2019-11-25',1,1,200);
insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-11-12','2019-11-30',2,2,90);
insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-11-05','2019-11-25',2,1,105);
insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-12-15','2019-12-25',2,2,140);
insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-11-20','2019-11-25',3,2,110);
insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-11-18','2019-12-30',3,2,95);
insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-11-25','2019-11-30',3,2,120);
insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-12-23','2019-12-30',4,2,140);
insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-11-20','2019-11-30',4,2,180);
insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-12-10','2019-12-20',4,1,250);
insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-11-20','2019-11-25',5,1,190);
insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-11-12','2019-11-30',5,2,164);
insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-11-05','2019-11-25',5,1,158);
insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-02-15','2019-02-25',5,2,240);
insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-11-18','2019-11-30',6,2,350);
insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-01-25','2019-01-30',6,2,286);
insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-01-23','2019-01-31',6,2,305);
insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-01-20','2019-01-30',7,2,280);
insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-01-10','2019-01-20',7,1,275);
insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-11-20','2019-11-25',7,1,269);
insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-01-12','2019-01-18',8,2,305);
insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-11-17','2019-11-22',8,1,296);
insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-12-15','2019-12-25',8,2,304);
insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-11-20','2019-11-25',8,2,204);
insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-11-18','2019-12-30',9,2,260);
insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-11-25','2019-11-30',9,2,320);
insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-12-23','2019-12-30',9,2,190);
insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-12-23','2019-12-30',10,2,180);
insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-11-10','2019-12-20',10,1,150);
insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-11-20','2019-11-25',10,1,165);
insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-11-12','2019-11-30',11,2,450);
insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-11-05','2019-11-12',11,1,125);
insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-12-16','2019-12-25',11,2,350);
insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-11-20','2019-11-25',12,2,156);
insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-11-28','2019-12-1',12,2,320);
insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-11-25','2019-11-30',12,2,180);
insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-12-25','2019-12-30',13,2,280);
insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-12-23','2019-12-30',14,2,250);
insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-12-10','2019-12-20',14,1,350);
insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-11-20','2019-11-25',14,1,420);
insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-11-12','2019-11-30',15,2,240);
insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-11-05','2019-11-25',15,1,285);
insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-12-15','2019-12-25',15,2,390);
insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-11-20','2019-11-25',16,2,400);
insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-11-25','2019-11-30',16,2,560);
insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-12-23','2019-12-30',16,2,660);

values ('2019-11-20','2019-11-25',17,1,420);
insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-11-12','2019-11-30',17,2,240);
insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-11-05','2019-11-25',17,1,285);
insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-12-15','2019-12-25',17,2,390);
insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-11-20','2019-11-25',17,2,400);
insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-11-25','2019-11-30',17,2,560);
insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-12-23','2019-12-30',17,1,660);

values ('2019-11-20','2019-11-25',18,1,420);
insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-11-12','2019-11-30',18,2,240);
insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-11-05','2019-11-25',18,1,285);
insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-12-15','2019-12-25',18,2,390);
insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-11-20','2019-11-25',18,2,400);
insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-11-25','2019-11-30',18,2,560);
insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-12-23','2019-12-30',18,1,660);

values ('2019-11-20','2019-11-25',19,1,420);
insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-11-12','2019-11-30',19,2,240);
insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-11-05','2019-11-25',19,1,285);
insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-12-15','2019-12-25',19,2,390);
insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-11-20','2019-11-25',19,2,400);
insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-11-25','2019-11-30',19,2,560);
insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-12-23','2019-12-30',19,1,660);

values ('2019-11-20','2019-11-25',20,1,420);
insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-11-12','2019-11-30',20,2,240);
insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-11-05','2019-11-25',20,1,285);
insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-12-15','2019-12-25',20,2,390);
insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-11-20','2019-11-25',20,2,400);
insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-11-25','2019-11-30',20,2,560);
insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-12-23','2019-12-30',20,1,660);


values ('2019-11-20','2019-11-25',24,1,420);
insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-11-12','2019-11-30',24,2,240);
insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-11-05','2019-11-25',24,1,285);
insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-12-15','2019-12-25',25,2,390);
insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-11-20','2019-11-25',25,2,400);
insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-11-25','2019-11-30',25,2,560);
insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-12-23','2019-12-30',25,1,660);

values ('2019-11-20','2019-11-25',26,1,420);
insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-11-12','2019-11-30',26,2,240);
insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-11-05','2019-11-25',26,1,285);
insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-12-15','2019-12-25',26,2,390);
insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-11-20','2019-11-25',27,2,400);
insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-11-25','2019-11-30',27,2,560);
insert into deals(date_from,date_to,hotel_id,offerts_number,price_excl_meal)
values ('2019-12-23','2019-12-30',27,1,660);

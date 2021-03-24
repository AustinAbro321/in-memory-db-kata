delete from kata.sales;
delete from kata.stellantis_cars;
delete from kata.people;
delete from kata.countries;



insert into kata.countries (id,abbreviation,name) 
values(1,'USA','United States of America'),
(2,'NOR','Norway'),
(3,'SWE','Sweden');
insert into kata.stellantis_cars(id,car_name,year) values
(1,'Jeep Cherokee',2018),
(2,'Jeep Cherokee',2017),
(3,'Jeep Cherokee',2000),
(4,'Dodge Challenger',1985),
(5,'FIAT 124 Spider',2100),
(6,'Chrysler 300',2003),
(7,'Alfa Romeo Giulia',2021);
insert into kata.people(ID,full_name,email,country_id) values
(1,'Austin Abro','Austin.Abro@stellantis.com',1),
(2,'Chris Gallivan','Chris.Gallivan@stellantis.com',1),
(3,'Jackie Chan',null,1),
(4,'Barry Bonds',null,2),
(5,'Bjarne Stroustrup',null,3);
insert into kata.sales(VIN,person_id,car_id,sale_date) VALUES
(1,3,1,'2001-09-28'),
(2,1,1,'2001-09-28'),
(5,5,4,'2001-09-28'),
(3,1,1,'2010-11-28'),
(100,4,1,'2020-03-26'),
(101,4,2,'2020-03-26'),
(102,4,7,'2020-03-26'),
(103,4,5,'2020-03-26'),
(4,3,4,'2020-10-15');
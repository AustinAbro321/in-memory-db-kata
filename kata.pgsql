create schema kata
create table if not exists kata.countries(
    ID int PRIMARY KEY,
    abbreviation varchar(5),
    name varchar(100)
);
create table if not exists kata.people(
    ID int PRIMARY KEY,
    full_name varchar(100) not NULL,
    email varchar(100),
    country_id int,
    foreign key (country_id) references kata.countries(id)
    on delete CASCADE
);
create table if not exists kata.stellantis_cars(
    ID int primary KEY,
    car_name varchar (100) not NULL,
    year INT not null
);
create table if not exists kata.sales(
    VIN INT primary KEY,
    person_id int not null,
    car_id int not null,
    sale_date DATE not null,
    foreign key (person_id) references kata.people(id) 
    on delete CASCADE,
    foreign key (car_id) REFERENCES kata.stellantis_cars(id)
    on delete CASCADE
);
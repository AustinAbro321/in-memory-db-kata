select car_name from kata.stellantis_cars where id = 1;

select email from kata.people where email is not null;

select full_name from kata.sales s inner join 
kata.people p on s.person_id = p.id where vin = 1;

select count(*) from kata.sales sa inner join kata.stellantis_cars sc 
on sa.car_id = sc.id where car_name = 'Jeep Cherokee';

select count(*) from kata.sales sa 
inner join kata.people pe  on sa.person_id = pe.id
where sa.sale_date = '2020-03-26' and country_id = 2; 

select count(*),co.name from kata.sales sa
inner join kata.people pe  on sa.person_id = pe.id
inner join kata.countries co on pe.country_id = co.id
group by pe.country_id,co.name;

select pe.id,country_id,full_name,email from kata.people pe
inner join kata.sales sa on sa.person_id = pe.id 
inner join kata.stellantis_cars st on sa.car_id = st.id
where st.id = 4
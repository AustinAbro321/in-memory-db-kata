select car_name from stellantis_cars where id = 1;

select email from people where email is not null;

select full_name from sales s inner join 
people p on s.person_id = p.id where vin = 1;

select count(*) from sales sa inner join stellantis_cars sc 
on sa.car_id = sc.id where car_name = 'Jeep Cherokee';

select count(*) from sales sa 
inner join people pe  on sa.person_id = pe.id
where sa.sale_date = '2020-03-26' and country_id = 2; 

select count(*),co.name from sales sa
inner join people pe  on sa.person_id = pe.id
inner join countries co on pe.country_id = co.id
group by pe.country_id,co.name;

select pe.id,country_id,full_name,email from people pe
inner join sales sa on sa.person_id = pe.id 
inner join stellantis_cars st on sa.car_id = st.id
where st.id = 4
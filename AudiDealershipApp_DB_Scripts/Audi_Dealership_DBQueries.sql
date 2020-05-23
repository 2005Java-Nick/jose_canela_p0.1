/********************************************************************************
 * FUNCTIONS 
 ********************************************************************************/
--------------------------------------------------------------------------------
-- Get all cars on car lot
drop function all_cars_on_lot;
create or replace function all_cars_on_lot()
returns table (id int,model varchar,caryear varchar,price numeric,vin varchar,now_owned bool) as $$
begin 
	return query (select * from car where bought = false);
end;
$$ language plpgsql;
select * from all_cars_on_lot();
--------------------------------------------------------------------------------
-- Get my (owned) cars
drop function all_my_cars;
create or replace function all_my_cars(customer_id bigint)
returns table (cust_car_id int, carId bigint, cust_id bigint) as $$
begin 
	return query (select * from customer_car cc where cc.customer_car_customer_id  = customer_id);
end;
$$ language plpgsql;
select * from all_my_cars(1);
--------------------------------------------------------------------------------
-- Get car by car_vin
drop function car_by_vin;
create or replace function car_by_vin(vin varchar)
returns table (id int,model varchar,caryear varchar,price numeric,vinNum varchar,now_owned bool) as $$
begin 
	return query (select * from car c where c.car_vin  = vin);
end;
$$ language plpgsql;
select * from car_by_vin('2G1WL52M4W9218917');
--------------------------------------------------------------------------------
-- Get car by car_id
drop function car_by_id;
create or replace function car_by_id(id bigint)
returns table (carid int,model varchar,caryear varchar,price numeric,vinNum varchar,now_owned bool) as $$
begin 
	return query (select * from car c where c.car_id  = id);
end;
$$ language plpgsql;
select * from car_by_id(1);
--------------------------------------------------------------------------------
-- Get all customer payments
drop function all_customer_payments;
create or replace function all_customer_payments()
returns table (id int, customer_id bigint, car_id bigint, amount numeric, ts timestamp) as $$
begin 
	return query (select * from payment);
end;
$$ language plpgsql;
select * from all_customer_payments();
--------------------------------------------------------------------------------
-- Get my (one customer's) payments
drop function all_my_payments;
create or replace function all_my_payments(cust_id bigint)
returns table (id int, customer_id bigint, car_id bigint, amount numeric, ts timestamp) as $$
begin 
	return query (select * from payment p where p.payment_customer_id  = cust_id);
end;
$$ language plpgsql;
select * from all_my_payments(1);
--------------------------------------------------------------------------------
-- Get all customers
drop function all_customers;
create or replace function all_customers()
returns table (id int, username varchar, pw varchar, monthly_installment numeric, total_balance numeric) as $$
begin 
	return query (select * from customer);
end;
$$ language plpgsql;
select * from all_customers();
--------------------------------------------------------------------------------
-- Get all employees
drop function all_employees;
create or replace function all_employees()
returns table (id int, username varchar, pw varchar) as $$
begin 
	return query (select * from employee);
end;
$$ language plpgsql;
select * from all_employees();
--------------------------------------------------------------------------------
-- Get all offers
drop function all_offers;
create or replace function all_offers()
returns table (id int, cust_id bigint, carId bigint, amount numeric, accepted bool) as $$
begin 
	return query (select * from offer);
end;
$$ language plpgsql;
select * from all_offers();
--------------------------------------------------------------------------------

/********************************************************************************
 * STORED PROCEDURES 
 ********************************************************************************/
--------------------------------------------------------------------------------
-- Accept offer (UPDATE)
create or replace procedure accept_offer(customer_id bigint)
language plpgsql as $$
begin
    update offer set offer_accepted = true
        where offer_customer_id = customer_id;
end;
$$;
--call accept_offer(offer_id);
--------------------------------------------------------------------------------
-- Delete a car from the lot (DELETE)
create or replace procedure delete_car_from_lot(vin varchar)
language plpgsql as $$
begin
delete from car where car_vin = vin;
commit;
end
$$;
--call delete_car_from_lot('vin'::varchar);
--------------------------------------------------------------------------------
-- Register an Audi (INSERT)
create or replace procedure register_car(model varchar, car_year varchar, price numeric, vin varchar, car_bought bool)
language plpgsql as $$
begin
    insert into car (car_model, car_year, car_price, car_vin, bought)
        values (model, car_year, price, vin, car_bought);
commit;
end
$$;
--call register_car(model::varchar,year::varchar,price::numeric,vin::varchar);
--------------------------------------------------------------------------------
-- Make an offer (INSERT)
create or replace procedure make_offer(customer_id bigint, car_id bigint, amount numeric, accepted bool)
language plpgsql as $$
begin
    insert into offer (offer_customer_id , offer_car_id, offer_amount, offer_accepted)
        values (customer_id, car_id, amount, accepted);
commit;
end
$$;
--call make_offer(customer_id, car_id, amount::numeric, accepted);
--------------------------------------------------------------------------------
-- Delete a Customer (DELETE)
create or replace procedure delete_customer(username varchar)
language plpgsql as $$
begin
delete from customer where customer_username = username;
commit;
end
$$;
--call delete_customer('username'::varchar);
--------------------------------------------------------------------------------
-- Register Customer (INSERT)
create or replace procedure register_customer(username varchar, cust_password varchar, monthly_installment numeric, total_balance numeric)
language plpgsql as $$
begin
    insert into customer (customer_username , customer_password, customer_monthly_installment, customer_total_balance)
        values (username, cust_password, monthly_installment, total_balance);
commit;
end
$$;
--call register_customer('username'::varchar,'password'::varchar,monthly_installment::numeric,total_balance::numeric);
--------------------------------------------------------------------------------
-- Register Employee (INSERT)
create or replace procedure register_employee(username varchar, pw varchar)
language plpgsql as $$
begin
    insert into employee (employee_username, employee_password)
        values (username, pw);
commit;
end
$$;
--call register_employee('username'::varchar, 'pw'::varchar);
--------------------------------------------------------------------------------
-- Make a payment (INSERT)
create or replace procedure make_payment(cust_id bigint,car_id bigint, amount numeric)
language plpgsql as $$
begin
    insert into payment (payment_customer_id, payment_car_id, payment_amount, payment_timestamp)
        values (cust_id, car_id, amount, current_timestamp);
commit;
end
$$;
--call make_payment(cust_id, car_id,amount::numeric,current_timestamp()); 

--------------------------------------------------------------------------------
-- Delete an offer (DELETE)
create or replace procedure delete_offer_by_id(id bigint)
language plpgsql as $$
begin
delete from offer where offer_id = id;
commit;
end
$$;
-- call delete_offer_by_id(id);

create or replace procedure delete_offer_by_cust(cust_id bigint)
language plpgsql as $$
begin
delete from offer where offer_customer_id = cust_id;
commit;
end
$$;
-- call delete_offer_by_cust(cust_id);

--------------------------------------------------------------------------------

/********************************************************************************
 * TRIGGERS 
 ********************************************************************************/
--------------------------------------------------------------------------------
-- Delete all offers AFTER a particular offer is accepted

--FUNCTION---
create or replace function delete_all_other_offers()
returns trigger as $$
begin
	if old.accepted <> new.accepted then
		delete from offer where offer_customer_id <> new.offer_customer_id and offer_car_id = new.offer_car_id;
	end if;
return new;
end;
$$ language plpgsql;

--TRIGGER--
drop trigger if exists delete_unaccepted_offers on offer;
create trigger delete_unaccepted_offers
    before update on offer
    for each row
    execute procedure delete_all_other_offers();
--------------------------------------------------------------------------------
-- Insert a customer's car into customer_car AFTER a particular offer is accepted

   

--FUNCTION---
create or replace function add_customer_car()
returns trigger as $$
begin
	if old.accepted <> new.accepted then
    	insert into customer_car (customer_car_car_id , customer_car_customer_id)
   		values (new.customer_car_car_id, new.customer_car_customer_id);
   	end if;
return new;
end;
$$ language plpgsql;

--TRIGGER--
drop trigger if exists add_customer_cars on offer;
create trigger add_customer_cars
    after update on offer
    for each row
    execute procedure add_customer_car();

--------------------------------------------------------------------------------
-- Update a customer's monthly installment and total balance AFTER offer accepted

--FUNCTION---
create or replace function set_customer_balance()
returns trigger as $$
begin
	if old.accepted <> new.accepted then
		update customer set customer_monthly_installment = (select (offer_amount/24) from offer where offer_customer_id = new.offer_customer_id)
		where customer_id = new.offer_customer_id;
	
		update customer set customer_total_balance = (select offer_amount from offer where offer_customer_id = new.offer_customer_id)
		where customer_id = new.offer_customer_id;
	end if;
return new;
end;
$$ language plpgsql;

--TRIGGER--create trigger 
drop trigger if exists set_customer_balance on offer;
create trigger set_customer_balance
	after update on offer
    for each row
    execute procedure set_customer_balance();


--------------------------------------------------------------------------------
-- Update a customer's total balance AFTER payment 
-------------------------------------------------------------------------------- 
--FUNCTION---
create or replace function update_customer_balance()
returns trigger as $$
begin
	update customer set customer_total_balance = (customer_total_balance - customer_monthly_installment)
	where customer_id = new.payment_customer_id;
return new;
end;
$$ language plpgsql;

--TRIGGER--
drop trigger if exists update_customer_balance on payment;
create trigger update_customer_balance
    after insert on payment 
    for each row
    execute procedure update_customer_balance();

--------------------------------------------------------------------------------
/********************************************************************************
 * INITIALIZING DATABASE 
 ********************************************************************************/
 
-- Create 5 Audis
call register_car('A3'::varchar,'2019'::varchar,32500::numeric,'2G1WL52M4W9218917'::varchar, false);
call register_car('A4'::varchar,'2019'::varchar,37400::numeric,'3GCPKSE33BG297836'::varchar, false);
call register_car('A6'::varchar,'2020'::varchar,54900::numeric,'1GKER33737J169430'::varchar, false);
call register_car('S4'::varchar,'2020'::varchar,49900::numeric,'WVWMP7AN5AE505343'::varchar, false);
call register_car('R8'::varchar,'2020'::varchar,169900::numeric,'1NXBR30E55Z334757'::varchar, false);
--------------------------------------------------------------------------------
 
-- Create 5 customers
call register_customer('anastasia'::varchar,'1'::varchar,0::numeric,0::numeric);
call register_customer('andres'::varchar,'2'::varchar,0::numeric,0::numeric);
call register_customer('angelo'::varchar,'3'::varchar,0::numeric,0::numeric);
call register_customer('zack'::varchar,'4'::varchar,0::numeric,0::numeric);
call register_customer('wei'::varchar,'5'::varchar,0::numeric,0::numeric);
--------------------------------------------------------------------------------
 
--Create 2 employees
call register_employee('jose'::varchar, '1'::varchar);
call register_employee('nick'::varchar, '2'::varchar);








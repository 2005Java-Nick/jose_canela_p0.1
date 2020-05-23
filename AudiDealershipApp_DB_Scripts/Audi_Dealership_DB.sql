/* CREATING POSSIBLE TEST TABLES
create table test_employee (
	test_employee_id serial, --PK
	test_employee_username varchar unique not null,
	test_employee_password varchar not null,
	constraint PK_employee primary key (test_employee_id)
);

create table test_customer (
	test_customer_id serial, --PK
	test_customer_username varchar unique not null,
	test_customer_password varchar not null,
	test_customer_monthly_installment numeric,
	test_customer_total_balance numeric,
	constraint PK_customer primary key (test_customer_id)
);

create table test_car (
	test_car_id serial, --PK
	test_car_model varchar,
	test_car_year varchar,
	test_car_price numeric(10,2),
	constraint PK_car primary key (test_car_id)
);

create table test_customer_car (
	test_customer_car_id serial, --PK
	test_customer_car_car_id bigint, --FK
	test_customer_car_customer_id bigint, --FK
	constraint PK_customer_car primary key (test_customer_car_id)
);

create table test_offer (
	test_offer_id serial, --PK
	test_offer_customer_id bigint, --FK
	test_offer_car_id bigint, --FK
	test_offer_amount numeric(10,2),
	test_offer_accepted boolean,
	constraint PK_offer primary key (test_offer_id)
);

create table test_payment (
	test_payment_id serial, --PK
	test_payment_customer_id bigint, --FK
	test_payment_car_id bigint, --FK
	test_payment_amount numeric(10,2),
	test_payment_timestamp timestamp,
	constraint PK_payment primary key (test_payment_id)
);

alter table test_customer_car add constraint FK_test_customer_car_customer_id
	foreign key (test_customer_car_customer_id) references test_customer (test_customer_id) on delete cascade on update cascade;
create index i_FK_test_customer_car_customer_id on test_customer_car (test_customer_car_customer_id);

alter table test_customer_car add constraint FK_test_customer_car_car_id
	foreign key (test_customer_car_car_id) references test_car (test_car_id) on delete cascade on update cascade;
create index i_FK_test_customer_car_car_id on test_customer_car (test_customer_car_car_id);

alter table test_offer add constraint FK_test_offer_customer_id
	foreign key (test_offer_customer_id) references test_customer (test_customer_id) on delete cascade on update cascade;
create index i_FK_test_offer_customer_id on test_offer (test_offer_customer_id);

alter table test_offer add constraint FK_test_offer_car_id
	foreign key (test_offer_car_id) references test_car (test_car_id) on delete cascade on update cascade;
create index i_FK_test_offer_car_id on test_offer (test_offer_car_id);

alter table test_payment add constraint FK_test_payment_customer_id
	foreign key (test_payment_customer_id) references test_customer (test_customer_id) on delete cascade on update cascade;
create index i_FK_test_payment_customer_id on test_payment (test_payment_customer_id);

alter table test_payment add constraint FK_test_payment_car_id
	foreign key (test_payment_car_id) references car (test_car_id) on delete cascade on update cascade;
create index i_FK_test_payment_car_id on test_payment (test_payment_car_id);

*/

-- CREATING APPLICATION TABLES
create table employee (
	employee_id serial, --PK
	employee_username varchar unique not null,
	employee_password varchar not null,
	constraint PK_employee primary key (employee_id)
);

create table customer (
	customer_id serial, --PK
	customer_username varchar unique not null,
	customer_password varchar not null,
	customer_monthly_installment numeric,
	customer_total_balance numeric,
	constraint PK_customer primary key (customer_id)
);

create table car (
	car_id serial, --PK
	car_model varchar,
	car_year varchar,
	car_price numeric(10,2),
	constraint PK_car primary key (car_id)
);

create table customer_car (
	customer_car_id serial, --PK
	customer_car_car_id bigint, --FK
	customer_car_customer_id bigint, --FK
	constraint PK_customer_car primary key (customer_car_id)
);

create table offer (
	offer_id serial, --PK
	offer_customer_id bigint, --FK
	offer_car_id bigint, --FK
	offer_amount numeric(10,2),
	offer_accepted boolean,
	constraint PK_offer primary key (offer_id)
);

create table payment (
	payment_id serial, --PK
	payment_customer_id bigint, --FK
	payment_car_id bigint, --FK
	payment_amount numeric(10,2),
	payment_timestamp timestamp,
	constraint PK_payment primary key (payment_id)
);

alter table customer_car add constraint FK_customer_car_customer_id
	foreign key (customer_car_customer_id) references customer (customer_id) on delete cascade on update cascade;
create index i_FK_customer_car_customer_id on customer_car (customer_car_customer_id);

alter table customer_car add constraint FK_customer_car_car_id
	foreign key (customer_car_car_id) references car (car_id) on delete cascade on update cascade;
create index i_FK_customer_car_car_id on customer_car (customer_car_car_id);

alter table offer add constraint FK_offer_customer_id
	foreign key (offer_customer_id) references customer (customer_id) on delete cascade on update cascade;
create index i_FK_offer_customer_id on offer (offer_customer_id);

alter table offer add constraint FK_offer_car_id
	foreign key (offer_car_id) references car (car_id) on delete cascade on update cascade;
create index i_FK_offer_car_id on offer (offer_car_id);

alter table payment add constraint FK_payment_customer_id
	foreign key (payment_customer_id) references customer (customer_id) on delete cascade on update cascade;
create index i_FK_payment_customer_id on payment (payment_customer_id);

alter table payment add constraint FK_payment_car_id
	foreign key (payment_car_id) references car (car_id) on delete cascade on update cascade;
create index i_FK_payment_car_id on payment (payment_car_id);

alter table car add column car_vin varchar unique not null; 
alter table car add column bought boolean not null;


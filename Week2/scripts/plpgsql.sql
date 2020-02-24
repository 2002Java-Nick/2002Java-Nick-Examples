create sequence employee_id_seq start 16;

insert into employee (employeeid, firstname, lastname) values((select nextval('employee_id_seq')), 'Wezley', 'S');

select * from employee order by employeeid desc;

create or replace function insert_into_employee()
	returns trigger as $$
	begin
		if(TG_OP = 'INSERT') then
			new.employeeid = (select nextval('employee_id_seq'));
		end if;
		return new;
	end;
	$$ language plpgsql;
	
create trigger employee_select
	before select on employee
	for each row
		execute procedure insert_into_employee();
	
insert into employee(employeeid,firstname, lastname) values (-1, 'Robert', 'C');

create or replace function my_sum(val_a bigint, val_b bigint)
returns integer as $$
begin
	return val_a + val_b;
end;
$$ language plpgsql;

select my_sum(4, 7);

create or replace function employee_count()
returns integer as $$
declare 
	total integer;
begin
	select count(employeeid) into total from employee;
	return total;
end; $$ language plpgsql;

select employee_count();

create or replace procedure single_item_purchase(in customerid int4, in my_track int4, in quantity int4)
as $$
declare
	total numeric(10, 2);
	invoiceid int4;
	unitprice numeric(10, 2);
	invoicelineid int4;
begin
	select max(invoice.invoiceid) into invoiceid from invoice;
	invoiceid := invoiceid +1;
	select track.unitprice into unitprice from track where track.trackid = my_track;
	total := unitprice * quantity;
	insert into invoice(invoiceid, customerid, total, invoicedate) values(invoiceid, customerid, total, current_timestamp);
	select max(invoiceline.invoicelineid) into invoicelineid from invoiceline;
	invoicelineid := invoicelineid + 1;
	insert into invoiceline(invoiceid, invoicelineid, trackid, quantity, unitprice) 
		values(invoiceid, invoicelineid, my_track, quantity, unitprice);
end; $$ language plpgsql;

call single_item_purchase(3, 79, 8);

select * from invoice order by invoiceid desc;

--cursor works like a pointer to values in a table

select * from track order by unitprice desc;

create or replace procedure expensive_tracks(in cost double precision, inout curs refcursor)
as $$
begin
	open curs for select name, unitprice from track where unitprice > cost;
end; $$ language plpgsql;


do $$
declare
	curs refcursor;
	cost numeric(10, 2);
	title varchar(200);
	price numeric(10, 2);
begin
	cost := 3.50;
	call expensive_tracks(cost, curs);
	loop
		fetch curs into title, price;
		exit when not found;
	
		insert into proc_table (title, price) values(title, price);
	end loop;
end; $$ language plpgsql;
create table proc_table (
	title varchar(200),
	price numeric(10, 2)
);

truncate table proc_table;

select * from proc_table;
select * from track;
select * from customer;
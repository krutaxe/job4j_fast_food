create table if not exists orders (
    id serial primary key not null,
    customer_id int,
    dish_id int,
    total_price int,
    is_Paid boolean
);
create table if not exists orders (
    id serial primary key not null,
    dish_id int references dish(id),
    total_price int,
    status_order text,
    is_Paid boolean
);
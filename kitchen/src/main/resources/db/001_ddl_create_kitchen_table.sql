create table if not exists kitchen (
    id serial primary key not null,
    order_id int,
    status_order int,
    is_paid_order boolean
);
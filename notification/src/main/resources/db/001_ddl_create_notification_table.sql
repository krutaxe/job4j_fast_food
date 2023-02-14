create table if not exists notification (
    id serial primary key not null,
    order_id int,
    total_price_order int,
    is_paid_order boolean
);
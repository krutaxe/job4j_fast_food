create table if not exists customer (
    id serial primary key not null,
    name text,
    surname text,
    age int,
    phone_number int,
    address_id refereces
);
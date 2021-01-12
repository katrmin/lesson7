-- Создать сущность «Товар» (id, название, стоимость) и соответствующую таблицу в БД.
-- --  Заполнить таблицу тестовыми данными (20 записей).
create table Product(id bigserial primary key, name varchar(255), price int);
insert into Product (name, price) values
('Product 1', 10),
('Product 2', 20),
('Product 3', 30),
('Product 4', 40),
('Product 5', 50),
('Product 6', 60),
('Product 7', 80),
('Product 8', 70),
('Product 9', 80),
('Product 10', 70),
('Product 11', 80),
('Product 12', 70),
('Product 13', 80),
('Product 14', 70),
('Product 15', 80),
('Product 16', 70),
('Product 17', 80),
('Product 18', 70),
('Product 19', 80),
('Product 20', 100)
;

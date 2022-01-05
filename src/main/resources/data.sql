insert into client(client_id,name) values(1,'Jesus Martinez');
insert into client(client_id,name) values(2,'Jesica Torres');

insert into user(user_id,email, name) values(1,'user1@parrot.com.mx','User ventas');
insert into user(user_id,email, name) values(2,'user2@parrot.com.mx','User ventas2');

insert into product(product_id,name, price, stock) values(1,'goma', 5.00, 45);
insert into product(product_id,name, price, stock) values(2,'lapiz', 6.00, 35);
insert into product(product_id,name, price, stock) values(3,'regla', 4.00, 45);
insert into product(product_id,name, price, stock) values(4,'pluma', 5.00, 145);
insert into product(product_id,name, price, stock) values(5,'sacapuntas', 5.00, 245);

insert into orders(order_id,total, client_id, transaction_date) values(1,589.21, 1, CURRENT_DATE);
insert into orders(order_id,total, client_id, transaction_date) values(2,389.21, 2, CURRENT_DATE);

insert into order_item(id,quantity,order_id,product_id) values(1, 3, 1, 1);
insert into order_item(id,quantity,order_id,product_id) values(2, 10, 1, 2);
insert into order_item(id,quantity,order_id,product_id) values(3, 4, 1, 3);
insert into order_item(id,quantity,order_id,product_id) values(4, 8, 1, 4);
insert into order_item(id,quantity,order_id,product_id) values(5, 6, 1, 5);

insert into order_item(id,quantity,order_id,product_id) values(6, 3, 2, 1);
insert into order_item(id,quantity,order_id,product_id) values(7, 10, 2, 2);
insert into order_item(id,quantity,order_id,product_id) values(8, 4, 2, 3);
insert into order_item(id,quantity,order_id,product_id) values(9, 8, 2, 4);
insert into order_item(id,quantity,order_id,product_id) values(10, 6, 2, 5);
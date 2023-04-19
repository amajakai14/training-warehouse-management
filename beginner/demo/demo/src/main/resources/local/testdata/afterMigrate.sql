DELETE FROM example_user;
DELETE FROM example_stock;
DELETE FROM example_order;
DELETE FROM example_menu;

INSERT INTO example_user (user_id, password) VALUES ('user1', 'password1');
INSERT INTO example_stock (item_id, amount) VALUES (1, 3);
INSERT INTO example_order (id, item_id, name, amount, order_status, order_date)
VALUES
(1, 1, 'PO-001', 3, 'PENDING', '2019-01-01')
,(2, 2, 'PO-002', 2, 'PENDING', '2022-01-01')
,(3, 3, 'PO-003', 3, 'PENDING', '2022-01-01')
;
INSERT INTO example_menu (id, name) VALUES
(1,'carrot')
,(2,'玉ねぎ')
,(3,'和牛')
;

select setval('example_user_id_seq', 2);
select setval('example_order_id_seq', 3);
select setval('example_menu_id_seq', 3);


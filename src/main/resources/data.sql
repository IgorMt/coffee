
INSERT INTO orders (id, status, created, updated) values(1, 'awaiting', {ts '2018-05-07 18:47:52.69'}, {ts '2018-05-07 19:47:52.69'});
INSERT INTO orders (id, status, created, updated) values(2, 'preparing',{ts '2018-05-08 18:37:52.69'}, {ts '2018-05-08 19:44:52.69'});
INSERT INTO orders (id, status, created, updated) values(3, 'ready',{ts '2018-05-08 17:37:52.69'}, {ts '2018-05-08 17:44:52.69'});

INSERT INTO coffees (type, created, updated, order_id) values('flatwhite', {ts '2018-05-07 18:47:52.69'}, {ts '2018-05-07 18:57:52.69'}, 1);
INSERT INTO coffees (type, created, updated, order_id) values('piccolo', {ts '2018-05-07 18:47:52.69'}, {ts '2018-05-07 18:55:52.69'}, 1);
INSERT INTO coffees (type, created, updated, order_id) values('macchiato', {ts '2018-05-07 18:47:52.69'}, {ts '2018-05-07 18:49:52.69'}, 1);
INSERT INTO coffees (type, created, updated, order_id) values('latte', {ts '2018-05-07 18:47:52.69'}, CURRENT_TIMESTAMP(), 1);

INSERT INTO coffees (type, created, updated, order_id) values('flatwhite', {ts '2018-05-08 18:47:52.69'}, CURRENT_TIMESTAMP(), 2);
INSERT INTO coffees (type, created, updated, order_id) values('piccolo', {ts '2018-05-08 18:37:52.69'}, CURRENT_TIMESTAMP(), 2);

INSERT INTO coffees (type, created, updated, order_id) values('cappuchino', {ts '2018-05-07 17:47:52.69'}, {ts '2017-05-07 18:57:52.69'}, 3);
INSERT INTO coffees (type, created, updated, order_id) values('piccolo', {ts '2018-05-07 17:47:52.69'}, {ts '2017-05-07 18:55:52.69'}, 3);
INSERT INTO coffees (type, created, updated, order_id) values('longblack', {ts '2018-05-07 17:47:52.69'}, {ts '2017-05-07 18:49:52.69'}, 3);

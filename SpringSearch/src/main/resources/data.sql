-- data.sql
ALTER TABLE student
CHANGE COLUMN id id int(11) NOT NULL AUTO_INCREMENT;
ALTER TABLE student AUTO_INCREMENT=1;

INSERT INTO student (item_id,description,last_sold,shelf_life,department,price,unit,x_for,cost) VALUES (
'753542','banana','9/5/2017','4d','Produce',' $2.99 ','lb','1','$0.44');
INSERT INTO student (item_id,description,last_sold,shelf_life,department,price,unit,x_for,cost) VALUES (
'321654','apples','9/6/2017','7d','Produce',' $1.49 ','lb','1',' $0.20');
INSERT INTO student (item_id,description,last_sold,shelf_life,department,price,unit,x_for,cost) VALUES (
'95175','Strawberry','9/7/2017','3d','Produce',' $2.49 ','lb','1',' $0.10');
INSERT INTO student (item_id,description,last_sold,shelf_life,department,price,unit,x_for,cost) VALUES (
'321753','onion','9/8/2017','9d','Produce',' $1.00 ','Each','1',' $0.05');
INSERT INTO student (item_id,description,last_sold,shelf_life,department,price,unit,x_for,cost) VALUES (
'987654','Tomato','9/9/2017','4d','Produce',' $2.35 ','lb','1',' $0.20');
INSERT INTO student (item_id,description,last_sold,shelf_life,department,price,unit,x_for,cost) VALUES (
'11122','grapes','9/10/2017','7d','Produce',' $4.00 ','lb','1',' $1.20');
INSERT INTO student (item_id,description,last_sold,shelf_life,department,price,unit,x_for,cost) VALUES (
'124872','Lettuce','9/11/2017','5d','Produce',' $0.79 ','lb','1',' $0.10');
INSERT INTO student (item_id,description,last_sold,shelf_life,department,price,unit,x_for,cost) VALUES (
'113','bread','9/12/2017','14d','Grocery',' $1.50 ','Each','1',' $0.12');
INSERT INTO student (item_id,description,last_sold,shelf_life,department,price,unit,x_for,cost) VALUES (
'1189','hamburger buns','9/13/2017','14d','Grocery',' $1.75 ','Each','1',' $0.14');
INSERT INTO student (item_id,description,last_sold,shelf_life,department,price,unit,x_for,cost) VALUES (
'12221','pasta sauce','9/14/2017','23d','Grocery',' $3.75 ','Each','1',' $1.00');
INSERT INTO student (item_id,description,last_sold,shelf_life,department,price,unit,x_for,cost) VALUES (
'1111','cheese slices','9/15/2017','20d','Grocery',' $2.68 ','Each','1',' $0.40');
INSERT INTO student (item_id,description,last_sold,shelf_life,department,price,unit,x_for,cost) VALUES (
'18939','sliced turkey','9/16/2017','20d','Grocery',' $3.29 ','Each','1',' $0.67');
INSERT INTO student (item_id,description,last_sold,shelf_life,department,price,unit,x_for,cost) VALUES (
'90879','tortilla chips','9/17/2017','45d','Grocery',' $1.99 ','Each','1',' $0.14');
INSERT INTO student (item_id,description,last_sold,shelf_life,department,price,unit,x_for,cost) VALUES (
'119290','cereal','9/18/2017','40d','Grocery',' $3.19 ','Each','1',' $0.19');
INSERT INTO student (item_id,description,last_sold,shelf_life,department,price,unit,x_for,cost) VALUES (
'4629464','canned vegtables','9/19/2017','200d','Grocery',' $1.89 ','Each','1',' $0.19');
INSERT INTO student (item_id,description,last_sold,shelf_life,department,price,unit,x_for,cost) VALUES (
'9000001','headache medicine','9/20/2017','365d','Pharmacy',' $4.89 ','Each','1',' $1.90');
INSERT INTO student (item_id,description,last_sold,shelf_life,department,price,unit,x_for,cost) VALUES (
'9000002','Migraine Medicine','9/21/2017','365d','Pharmacy',' $5.89 ','Each','1',' $1.90');
INSERT INTO student (item_id,description,last_sold,shelf_life,department,price,unit,x_for,cost) VALUES (
'9000003','Cold and Flu','9/22/2017','365d','Pharmacy',' $3.29 ','Each','1',' $1.90');
INSERT INTO student (item_id,description,last_sold,shelf_life,department,price,unit,x_for,cost) VALUES (
'9000004','Allegry Medicine','9/23/2017','365d','Pharmacy',' $3.00 ','Each','1',' $1.25');
INSERT INTO student (item_id,description,last_sold,shelf_life,department,price,unit,x_for,cost) VALUES (
'9000005','Pain','9/24/2017','365d','Pharmacy',' $2.89 ','Each','1',' $1.00');


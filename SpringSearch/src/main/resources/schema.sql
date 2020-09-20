-- schema.sql
CREATE TABLE Student(
  id      INT PRIMARY KEY AUTO_INCREMENT,
  item_id   VARCHAR(50),
  description   VARCHAR(50),
  lastSold   VARCHAR(50),
  shelfLife   VARCHAR(50),
  department   VARCHAR(50), 
  price   VARCHAR(50), 
  unit   VARCHAR(50),
  xFor   VARCHAR(50),
  cost   VARCHAR(50)
);
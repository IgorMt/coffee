CREATE TABLE IF NOT EXISTS orders (
  id      INTEGER      NOT NULL AUTO_INCREMENT,
  status  VARCHAR(40) NOT NULL,
  created DATETIME NOT NULL,
  updated DATETIME,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS coffees (
  id       INTEGER      NOT NULL AUTO_INCREMENT,
  type     VARCHAR(255) NOT NULL,
  created  DATETIME     NOT NULL,
  updated  DATETIME              DEFAULT NULL,
  order_id INTEGER,
  PRIMARY KEY (id),
  FOREIGN KEY (order_id) REFERENCES orders (id)
);


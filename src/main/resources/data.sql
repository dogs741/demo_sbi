-- DROP SEQUENCE IF exists company_seq;
-- DROP SEQUENCE IF exists client_seq;
-- CREATE SEQUENCE company_seq;
-- CREATE SEQUENCE client_seq;

CREATE TABLE IF NOT EXISTS Company (
  id INTEGER AUTO_INCREMENT,
  name VARCHAR(250) NOT NULL,
  address VARCHAR(250) NOT NULL,
  created_by VARCHAR(250) NOT NULL,
  created_at Timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_by VARCHAR(250) NOT NULL,
  updated_at Timestamp NOT NULL,
  PRIMARY KEY (id)
);
 
CREATE TABLE IF NOT EXISTS  Client (
  id INTEGER AUTO_INCREMENT,
  company_id INTEGER NOT NULL,
  name VARCHAR(250) NOT NULL,
  email VARCHAR(250) NOT NULL,
  phone VARCHAR(250) NOT NULL,
  created_by VARCHAR(250) NOT NULL,
  created_at Timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_by VARCHAR(250) NOT NULL,
  updated_at Timestamp NOT NULL,
  PRIMARY KEY (id)
);
CREATE DATABASE cabstats;

CREATE TABLE cabstats.customer
(
  id      SERIAL PRIMARY KEY,
  name    VARCHAR(50),
  msisdn  BIGINT,
  area    VARCHAR(50),
  street  VARCHAR(50),
  pincode VARCHAR(6)
)
DROP TABLE IF EXISTS account;
CREATE TABLE account (
                           account_id varchar(30) PRIMARY KEY,
                           account_name varchar(30),
                           balance decimal(20,2)
);
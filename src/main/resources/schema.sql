DROP TABLE IF EXISTS account;
CREATE TABLE account
(
    account_id   varchar(30) PRIMARY KEY,
    account_name varchar(30),
    balance      decimal(20, 2)
);

DROP TABLE IF EXISTS account_transaction;
CREATE TABLE account_transaction
(
    transaction_id varchar(30) PRIMARY KEY,
    account_id     varchar(30),
    amount         decimal(20, 2)
);

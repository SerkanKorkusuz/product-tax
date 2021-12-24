CREATE DATABASE IF NOT EXISTS users_products;

CREATE TABLE IF NOT EXISTS users_products.users
(
    id    int          NOT NULL AUTO_INCREMENT primary key,
    token varchar(100) NOT NULL,
    UNIQUE (token)
);

CREATE TABLE IF NOT EXISTS users_products.products
(
    id             int         NOT NULL AUTO_INCREMENT primary key,
    code           varchar(50) NOT NULL,
    name           varchar(50) NOT NULL,
    vendor         varchar(50) NOT NULL,
    price          float       NOT NULL,
    price_currency varchar(50) NOT NULL DEFAULT 'TRY',
    user_id        int         NOT NULL,
    tax_category   int         NOT NULL,
    create_date    timestamp            DEFAULT current_timestamp,
    update_date    timestamp            DEFAULT current_timestamp,
    UNIQUE (code)
);

INSERT INTO users_products.users (token)
VALUES ('hahkdw0z90agci7natoxb63mynvikbyk')
ON DUPLICATE KEY UPDATE token='hahkdw0z90agci7natoxb63mynvikbyk';

INSERT INTO users_products.users (token)
VALUES ('iyoek7hlw1jnp9xrsb5u1q6gs62l7qsq')
ON DUPLICATE KEY UPDATE token='iyoek7hlw1jnp9xrsb5u1q6gs62l7qsq';

INSERT INTO users_products.users (token)
VALUES ('z9qvoqdww8gm2wxiazwet4jj0xh5mp5e')
ON DUPLICATE KEY UPDATE token='z9qvoqdww8gm2wxiazwet4jj0xh5mp5e';

INSERT INTO users_products.products (code, name, vendor, price, price_currency, user_id, tax_category)
VALUES ('AX789', 'sapphire', 'DELL EMC', 114.8, 'USD', 0, 0)
ON DUPLICATE KEY UPDATE code='AX789';

INSERT INTO users_products.products (code, name, vendor, price, price_currency, user_id, tax_category)
VALUES ('BZ761', 'rosan', 'VERITAS', 71.99, 'USD', 1, 0)
ON DUPLICATE KEY UPDATE code='BZ761';

INSERT INTO users_products.products (code, name, vendor, price, price_currency, user_id, tax_category)
VALUES ('CD541', 'tersan', 'CISCO', 1019.6, 'TRY', 2, 1)
ON DUPLICATE KEY UPDATE code='CD541';

INSERT INTO users_products.products (code, name, vendor, price, price_currency, user_id, tax_category)
VALUES ('KU993', 'herma', 'BROCADE', 77.02, 'GBP', 1, 2)
ON DUPLICATE KEY UPDATE code='KU993';

INSERT INTO users_products.products (code, name, vendor, price, price_currency, user_id, tax_category)
VALUES ('TU998', 'lertak', 'CASPER', 10189.8, 'TRY', 0, 1)
ON DUPLICATE KEY UPDATE code='TU998';

INSERT INTO users_products.products (code, name, vendor, price, price_currency, user_id, tax_category)
VALUES ('LM431', 'lutgur', 'INVESTY', 439.2, 'USD', 1, 2)
ON DUPLICATE KEY UPDATE code='LM431';

INSERT INTO users_products.products (code, name, vendor, price, price_currency, user_id, tax_category)
VALUES ('AC559', 'karca', 'DINFO', 9032.83, 'TRY', 2, 0)
ON DUPLICATE KEY UPDATE code='AC559';

INSERT INTO users_products.products (code, name, vendor, price, price_currency, user_id, tax_category)
VALUES ('ZE887', 'mastero', 'CASPER', 10189.8, 'TRY', 0, 1)
ON DUPLICATE KEY UPDATE code='ZE887';

INSERT INTO users_products.products (code, name, vendor, price, price_currency, user_id, tax_category)
VALUES ('UT091', 'konnox', 'CLOUDERA', 439.2, 'USD', 1, 2)
ON DUPLICATE KEY UPDATE code='UT091';

INSERT INTO users_products.products (code, name, vendor, price, price_currency, user_id, tax_category)
VALUES ('FL677', 'worton', 'DELL EMC', 9032.83, 'TRY', 2, 0)
ON DUPLICATE KEY UPDATE code='FL677';

INSERT INTO users_products.products (code, name, vendor, price, price_currency, user_id, tax_category)
VALUES ('OK669', 'venro', 'VMWARE', 1012.0, 'GBP', 1, 0)
ON DUPLICATE KEY UPDATE code='OK669';

INSERT INTO users_products.products (code, name, vendor, price, price_currency, user_id, tax_category)
VALUES ('PL103', 'tenur', 'ISILON', 8091.2, 'USD', 2, 1)
ON DUPLICATE KEY UPDATE code='PL103';

INSERT INTO users_products.products (code, name, vendor, price, price_currency, user_id, tax_category)
VALUES ('SK859', 'yulonna', 'KAMIQ', 7620.88, 'TRY', 0, 2)
ON DUPLICATE KEY UPDATE code='SK859';
ALTER TABLE transactions
ADD COLUMN payment_status INT NOT NULL DEFAULT 1 AFTER transaction_type;
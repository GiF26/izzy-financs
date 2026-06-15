-- ==========================================
-- V1__create_initial_tables.sql
-- ==========================================

-- 1. ENTIDADE: USERS
CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 2. ENTIDADE: ACCOUNTS
CREATE TABLE accounts (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    description VARCHAR(255) NOT NULL,
    account_type INT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_accounts_user FOREIGN KEY (user_id) REFERENCES users(id)
);

-- 3. ENTIDADE: CATEGORIES
CREATE TABLE categories (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NULL,
    sequence_id BIGINT NOT NULL,
    description VARCHAR(255) NOT NULL,
    visible BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_categories_user FOREIGN KEY (user_id) REFERENCES users(id)
);

-- 4. ENTIDADE: RECURRING_TRANSACTIONS
CREATE TABLE recurring_transactions (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    account_id BIGINT NOT NULL,
    category_id BIGINT NOT NULL,
    transaction_type INT NOT NULL,
    description VARCHAR(255) NOT NULL,
    amount DECIMAL(10,2) NOT NULL,
    due_day INT NOT NULL,
    current_installment INT NULL,
    total_installments INT NULL,
    frequency INT NOT NULL,
    is_active BOOLEAN DEFAULT TRUE,
    start_date DATE NOT NULL,
    end_date DATE NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_recurring_account FOREIGN KEY (account_id) REFERENCES accounts(id),
    CONSTRAINT fk_recurring_category FOREIGN KEY (category_id) REFERENCES categories(id)
);

-- 5. ENTIDADE: TRANSACTIONS (Sem payment_status para teste no V2)
CREATE TABLE transactions (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    transaction_date DATE NOT NULL,
    account_id BIGINT NOT NULL,
    category_id BIGINT NOT NULL,
    transaction_type INT NOT NULL,
    description VARCHAR(255) NOT NULL,
    amount DECIMAL(10,2) NOT NULL,
    recurring_transaction_id BIGINT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_transactions_account FOREIGN KEY (account_id) REFERENCES accounts(id),
    CONSTRAINT fk_transactions_category FOREIGN KEY (category_id) REFERENCES categories(id),
    CONSTRAINT fk_transactions_recurring FOREIGN KEY (recurring_transaction_id) REFERENCES recurring_transactions(id)
);

-- 6. ENTIDADE: USER_PARAMS
CREATE TABLE user_params (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    description VARCHAR(255) NOT NULL,
    vlr_param VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_user_params_user FOREIGN KEY (user_id) REFERENCES users(id)
);
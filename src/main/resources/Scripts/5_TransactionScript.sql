-- ==========================================
-- ENTIDADE: TRANSACTIONS
-- ==========================================

-- 1. Cria a tabela de transações apenas se não existir
CREATE TABLE IF NOT EXISTS transactions (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    transaction_date DATE NOT NULL,
    account_id BIGINT NOT NULL,
    category_id BIGINT NOT NULL,
    transaction_type INT NOT NULL,
    description VARCHAR(255) NOT NULL,
    amount DECIMAL(10,2) NOT NULL,
    recurring_transaction_id BIGINT NULL, -- NULL para gastos avulsos/comuns
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- ==========================================
-- ATUALIZAÇÃO DE RELACIONAMENTOS (CHAVES ESTRANGEIRAS)
-- ==========================================

ALTER TABLE transactions ADD CONSTRAINT fk_transactions_account FOREIGN KEY (account_id) REFERENCES accounts(id);
ALTER TABLE transactions ADD CONSTRAINT fk_transactions_category FOREIGN KEY (category_id) REFERENCES categories(id);
ALTER TABLE transactions ADD CONSTRAINT fk_transactions_recurring FOREIGN KEY (recurring_transaction_id) REFERENCES recurring_transactions(id);
-- ==========================================
-- ENTIDADE: RECURRING_TRANSACTIONS
-- ==========================================

-- 1. Cria a tabela de recorrências apenas se não existir
CREATE TABLE IF NOT EXISTS recurring_transactions (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    account_id BIGINT NOT NULL,
    category_id BIGINT NOT NULL,
    transaction_type INT NOT NULL,
    description VARCHAR(255) NOT NULL,
    amount DECIMAL(10,2) NOT NULL,
    due_day INT NOT NULL,
    current_installment INT NULL, -- NULL para despesas fixas (ex: Netflix)
    total_installments INT NULL,   -- NULL para despesas fixas (ex: Netflix)
    frequency INT NOT NULL,        -- Mapeado via Enum no Java
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- ==========================================
-- ATUALIZAÇÃO DE RELACIONAMENTOS (CHAVES ESTRANGEIRAS)
-- ==========================================

-- 2. Vincula a tabela RECURRING_TRANSACTIONS às suas tabelas pai
ALTER TABLE recurring_transactions ADD CONSTRAINT fk_recurring_account FOREIGN KEY (account_id) REFERENCES accounts(id);
ALTER TABLE recurring_transactions ADD CONSTRAINT fk_recurring_category FOREIGN KEY (category_id) REFERENCES categories(id);
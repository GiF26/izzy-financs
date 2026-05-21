-- ==========================================
-- ENTIDADE: ACCOUNTS
-- ==========================================

CREATE TABLE IF NOT EXISTS accounts (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    description VARCHAR(255) NOT NULL,
    account_type INT NOT NULL, -- Mapeado via Enum/Ordinal no Java
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- ==========================================
-- ATUALIZAÇÃO DE RELACIONAMENTOS (CHAVES ESTRANGEIRAS)
-- ==========================================

ALTER TABLE accounts ADD CONSTRAINT fk_accounts_user FOREIGN KEY (user_id) REFERENCES users(id);
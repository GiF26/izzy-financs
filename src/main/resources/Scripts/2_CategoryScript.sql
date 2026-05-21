-- ==========================================
-- ENTIDADE: CATEGORIES
-- ==========================================

CREATE TABLE IF NOT EXISTS categories (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NULL, -- NULL para categorias globais do sistema
    sequence_id BIGINT NOT NULL,
    description VARCHAR(255) NOT NULL,
    visible BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- ==========================================
-- ATUALIZAÇÃO DE RELACIONAMENTOS (CHAVES ESTRANGEIRAS)
-- ==========================================

ALTER TABLE categories ADD CONSTRAINT fk_categories_user FOREIGN KEY (user_id) REFERENCES users(id);
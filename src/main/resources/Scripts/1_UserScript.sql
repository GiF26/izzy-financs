-- ==========================================
-- ENTIDADE: USERS
-- ==========================================

CREATE TABLE IF NOT EXISTS users (
                                     id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                     name VARCHAR(255) NOT NULL,
                                     username VARCHAR(255) NOT NULL,
                                     password VARCHAR(255) NOT NULL,
                                     created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- ==========================================
-- ATUALIZAÇÃO DE RELACIONAMENTOS (CHAVES ESTRANGEIRAS)
-- ==========================================

ALTER TABLE accounts DROP FOREIGN KEY IF EXISTS fk_accounts_user;
ALTER TABLE accounts ADD CONSTRAINT fk_accounts_user FOREIGN KEY (user_id) REFERENCES users(id);

ALTER TABLE categories DROP FOREIGN KEY IF EXISTS fk_categories_user;
ALTER TABLE categories ADD CONSTRAINT fk_categories_user FOREIGN KEY (user_id) REFERENCES users(id);

-- 4. Vincula a tabela USER_PARAMS ao USER_ID com segurança
-- ALTER TABLE user_params DROP FOREIGN KEY IF EXISTS fk_user_params_user;
-- ALTER TABLE user_params ADD CONSTRAINT fk_user_params_user FOREIGN KEY (user_id) REFERENCES users(id);
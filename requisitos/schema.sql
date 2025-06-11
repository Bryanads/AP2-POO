-- Apaga e recria o schema
DROP SCHEMA IF EXISTS `cidademais`;
CREATE SCHEMA IF NOT EXISTS `cidademais` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
USE `cidademais`;

-- Tabela de usuários (substitui a tabela cidadaos)
CREATE TABLE `usuarios` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `tipo` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE = InnoDB;

-- Tabela de problemas (1 usuário reporta N problemas)
CREATE TABLE `problemas` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(200) NOT NULL,
  `descricao` TEXT NOT NULL,
  `classificacao` VARCHAR(100) NOT NULL,
  `status` VARCHAR(50) NOT NULL,
  `data_reportado` DATETIME NOT NULL,
  `id_usuario_reportante` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_problema_reportante`
    FOREIGN KEY (`id_usuario_reportante`)
    REFERENCES `usuarios`(`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
) ENGINE = InnoDB;

-- Restante das tabelas com ajustes nas foreign keys
CREATE TABLE `localizacoes` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `uf` CHAR(2) NOT NULL,
  `cidade` VARCHAR(100) NOT NULL,
  `bairro` VARCHAR(100) NOT NULL,
  `rua` VARCHAR(100) NOT NULL,
  `numero` VARCHAR(20) NOT NULL,
  `latitude` DECIMAL(10,8) NOT NULL,
  `longitude` DECIMAL(11,8) NOT NULL,
  `id_problema` INT NOT NULL UNIQUE,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_localizacao_problema`
    FOREIGN KEY (`id_problema`)
    REFERENCES `problemas`(`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
) ENGINE = InnoDB;

CREATE TABLE `comentarios` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `texto` TEXT NOT NULL,
  `data_hora` DATETIME NOT NULL,
  `id_usuario_autor` INT NOT NULL,
  `id_problema` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_comentario_autor`
    FOREIGN KEY (`id_usuario_autor`)
    REFERENCES `usuarios`(`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_comentario_problema`
    FOREIGN KEY (`id_problema`)
    REFERENCES `problemas`(`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
) ENGINE = InnoDB;

CREATE TABLE `contribuicoes` (
  `id_usuario` INT NOT NULL,
  `id_problema` INT NOT NULL,
  `data_contribuicao` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_usuario`, `id_problema`),
  CONSTRAINT `fk_contribuicao_usuario`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `usuarios`(`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_contribuicao_problema`
    FOREIGN KEY (`id_problema`)
    REFERENCES `problemas`(`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
) ENGINE = InnoDB;
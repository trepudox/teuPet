CREATE SCHEMA IF NOT EXISTS `teupet` DEFAULT CHARACTER SET utf8 ;
USE `teupet` ;

-- -----------------------------------------------------
-- Table `teupet`.`pessoa`
-- -----------------------------------------------------
-- DROP TABLE IF EXISTS `teupet`.`pessoa` ;

CREATE TABLE IF NOT EXISTS `teupet`.`pessoa` (
  `pessoa_id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(255) NOT NULL,
  `data_nascimento` DATE NOT NULL,
  `telefone` VARCHAR(255) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `cpf` VARCHAR(11) NOT NULL,
  PRIMARY KEY (`pessoa_id`),
  UNIQUE INDEX `id_UNIQUE` (`pessoa_id` ASC) VISIBLE,
  UNIQUE INDEX `telefone_UNIQUE` (`telefone` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  UNIQUE INDEX `documento_UNIQUE` (`cpf` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `teupet`.`especie_animal`
-- -----------------------------------------------------
-- DROP TABLE IF EXISTS `teupet`.`especie_animal` ;

CREATE TABLE IF NOT EXISTS `teupet`.`especie_animal` (
  `especie_animal_id` INT NOT NULL,
  `especie` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`especie_animal_id`),
  UNIQUE INDEX `id_UNIQUE` (`especie_animal_id` ASC) VISIBLE,
  UNIQUE INDEX `nome_UNIQUE` (`especie` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `teupet`.`sexo_animal`
-- -----------------------------------------------------
-- DROP TABLE IF EXISTS `teupet`.`sexo_animal` ;

CREATE TABLE IF NOT EXISTS `teupet`.`sexo_animal` (
  `sexo_animal_id` INT NOT NULL,
  `sexo` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`sexo_animal_id`),
  UNIQUE INDEX `id_UNIQUE` (`sexo_animal_id` ASC) VISIBLE,
  UNIQUE INDEX `sexo_UNIQUE` (`sexo` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `teupet`.`porte_animal`
-- -----------------------------------------------------
-- DROP TABLE IF EXISTS `teupet`.`porte_animal` ;

CREATE TABLE IF NOT EXISTS `teupet`.`porte_animal` (
  `porte_animal_id` INT NOT NULL,
  `porte` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`porte_animal_id`),
  UNIQUE INDEX `id_UNIQUE` (`porte_animal_id` ASC) VISIBLE,
  UNIQUE INDEX `nome_UNIQUE` (`porte` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `teupet`.`plano_saude`
-- -----------------------------------------------------
-- DROP TABLE IF EXISTS `teupet`.`plano_saude` ;

CREATE TABLE IF NOT EXISTS `teupet`.`plano_saude` (
  `plano_saude_id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(255) NOT NULL,
  `preco` FLOAT NOT NULL,
  `carencia` INT NOT NULL,
  PRIMARY KEY (`plano_saude_id`),
  UNIQUE INDEX `convenio_id_UNIQUE` (`plano_saude_id` ASC) VISIBLE,
  UNIQUE INDEX `nome_UNIQUE` (`nome` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `teupet`.`animal`
-- -----------------------------------------------------
-- DROP TABLE IF EXISTS `teupet`.`animal` ;

CREATE TABLE IF NOT EXISTS `teupet`.`animal` (
  `animal_id` INT NOT NULL AUTO_INCREMENT,
  `pessoa_id` INT NOT NULL,
  `especie_animal_id` INT NOT NULL,
  `sexo_animal_id` INT NOT NULL,
  `porte_animal_id` INT,
  `plano_saude_id` INT NOT NULL,
  `nome` VARCHAR(255) NOT NULL,
  `peso` FLOAT NOT NULL,
  `data_nascimento` DATE NOT NULL,
  PRIMARY KEY (`animal_id`),
  UNIQUE INDEX `id_UNIQUE` (`animal_id` ASC) VISIBLE,
  INDEX `fk_animal_pessoa_idx` (`pessoa_id` ASC) VISIBLE,
  INDEX `fk_animal_especie_animal1_idx` (`especie_animal_id` ASC) VISIBLE,
  INDEX `fk_animal_sexo_animal1_idx` (`sexo_animal_id` ASC) VISIBLE,
  INDEX `fk_animal_porte_animal1_idx` (`porte_animal_id` ASC) VISIBLE,
  INDEX `fk_animal_plano_saude1_idx` (`plano_saude_id` ASC) VISIBLE,
  CONSTRAINT `fk_animal_pessoa`
    FOREIGN KEY (`pessoa_id`)
    REFERENCES `teupet`.`pessoa` (`pessoa_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_animal_especie_animal1`
    FOREIGN KEY (`especie_animal_id`)
    REFERENCES `teupet`.`especie_animal` (`especie_animal_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_animal_sexo_animal1`
    FOREIGN KEY (`sexo_animal_id`)
    REFERENCES `teupet`.`sexo_animal` (`sexo_animal_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_animal_porte_animal1`
    FOREIGN KEY (`porte_animal_id`)
    REFERENCES `teupet`.`porte_animal` (`porte_animal_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_animal_plano_saude1`
    FOREIGN KEY (`plano_saude_id`)
    REFERENCES `teupet`.`plano_saude` (`plano_saude_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `teupet`.`endereco_pessoa`
-- -----------------------------------------------------
-- DROP TABLE IF EXISTS `teupet`.`endereco_pessoa` ;

CREATE TABLE IF NOT EXISTS `teupet`.`endereco_pessoa` (
  `endereco_pessoa_id` INT NOT NULL AUTO_INCREMENT,
  `pessoa_id` INT NOT NULL,
  `cep` VARCHAR(8) NOT NULL,
  `logradouro` VARCHAR(255) NOT NULL,
  `numero` VARCHAR(255) NOT NULL,
  `complemento` VARCHAR(255) NULL,
  PRIMARY KEY (`endereco_pessoa_id`),
  INDEX `fk_endereco_pessoa1_idx` (`pessoa_id` ASC) VISIBLE,
  UNIQUE INDEX `endereco_id_UNIQUE` (`endereco_pessoa_id` ASC) VISIBLE,
  CONSTRAINT `fk_endereco_pessoa1`
    FOREIGN KEY (`pessoa_id`)
    REFERENCES `teupet`.`pessoa` (`pessoa_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `teupet`.`tipo_estabelecimento_associado`
-- -----------------------------------------------------
-- DROP TABLE IF EXISTS `teupet`.`tipo_estabelecimento_associado` ;

CREATE TABLE IF NOT EXISTS `teupet`.`tipo_estabelecimento_associado` (
  `tipo_estabelecimento_associado_id` INT NOT NULL AUTO_INCREMENT,
  `tipo_estabelecimento_associado` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`tipo_estabelecimento_associado_id`),
  UNIQUE INDEX `estabelecimento_associado_id_UNIQUE` (`tipo_estabelecimento_associado_id` ASC) VISIBLE,
  UNIQUE INDEX `tipo_estabelecimento_associado_UNIQUE` (`tipo_estabelecimento_associado` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `teupet`.`estabelecimento_associado`
-- -----------------------------------------------------
-- DROP TABLE IF EXISTS `teupet`.`estabelecimento_associado` ;

CREATE TABLE IF NOT EXISTS `teupet`.`estabelecimento_associado` (
  `estabelecimento_associado_id` INT NOT NULL AUTO_INCREMENT,
  `tipo_estabelecimento_associado_id` INT NOT NULL,
  `nome_fantasia` VARCHAR(255) NOT NULL,
  `cnpj` VARCHAR(14) NOT NULL,
  `descricao` VARCHAR(255) NOT NULL,
  `data_cadastro` DATE NOT NULL,
  `taxa_entrega` VARCHAR(45) NULL,
  PRIMARY KEY (`estabelecimento_associado_id`),
  UNIQUE INDEX `estabelecimento_associado_id_UNIQUE` (`estabelecimento_associado_id` ASC) VISIBLE,
  INDEX `fk_estabelecimento_associado_tipo_estabelecimento_associado_idx` (`tipo_estabelecimento_associado_id` ASC) VISIBLE,
  CONSTRAINT `fk_estabelecimento_associado_tipo_estabelecimento_associado1`
    FOREIGN KEY (`tipo_estabelecimento_associado_id`)
    REFERENCES `teupet`.`tipo_estabelecimento_associado` (`tipo_estabelecimento_associado_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `teupet`.`endereco_estabelecimento_associado`
-- -----------------------------------------------------
-- DROP TABLE IF EXISTS `teupet`.`endereco_estabelecimento_associado` ;

CREATE TABLE IF NOT EXISTS `teupet`.`endereco_estabelecimento_associado` (
  `endereco_estabelecimento_associado_id` INT NOT NULL AUTO_INCREMENT,
  `estabelecimento_associado_estabelecimento_associado_id` INT NOT NULL,
  `cep` VARCHAR(255) NOT NULL,
  `logradouro` VARCHAR(255) NOT NULL,
  `numero` VARCHAR(255) NOT NULL,
  `complemento` VARCHAR(255) NULL,
  PRIMARY KEY (`endereco_estabelecimento_associado_id`),
  UNIQUE INDEX `endereco_id_UNIQUE` (`endereco_estabelecimento_associado_id` ASC) VISIBLE,
  INDEX `fk_endereco_estabelecimento_associado_estabelecimento_assoc_idx` (`estabelecimento_associado_estabelecimento_associado_id` ASC) VISIBLE,
  CONSTRAINT `fk_endereco_estabelecimento_associado_estabelecimento_associa1`
    FOREIGN KEY (`estabelecimento_associado_estabelecimento_associado_id`)
    REFERENCES `teupet`.`estabelecimento_associado` (`estabelecimento_associado_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `teupet`.`produto`
-- -----------------------------------------------------
-- DROP TABLE IF EXISTS `teupet`.`produto` ;

CREATE TABLE IF NOT EXISTS `teupet`.`produto` (
  `produto_id` INT NOT NULL AUTO_INCREMENT,
  `estabelecimento_associado_id` INT NOT NULL,
  `nome` VARCHAR(255) NOT NULL,
  `descricao` VARCHAR(255) NOT NULL,
  `preco` FLOAT NOT NULL,
  `desconto` INT NOT NULL,
  `imagem` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`produto_id`),
  UNIQUE INDEX `produto_id_UNIQUE` (`produto_id` ASC) VISIBLE,
  INDEX `fk_produto_estabelecimento_associado1_idx` (`estabelecimento_associado_id` ASC) VISIBLE,
  CONSTRAINT `fk_produto_estabelecimento_associado1`
    FOREIGN KEY (`estabelecimento_associado_id`)
    REFERENCES `teupet`.`estabelecimento_associado` (`estabelecimento_associado_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `teupet`.`pedido`
-- -----------------------------------------------------
-- DROP TABLE IF EXISTS `teupet`.`pedido` ;

CREATE TABLE IF NOT EXISTS `teupet`.`pedido` (
  `pedido_id` INT NOT NULL AUTO_INCREMENT,
  `estabelecimento_associado_id` INT NOT NULL,
  `pessoa_id` INT NOT NULL,
  `data_pedido` DATE NOT NULL,
  `valor_total` DOUBLE NOT NULL,
  `cep_entrega` VARCHAR(8) NOT NULL,
  `logradouro_entrega` VARCHAR(255) NOT NULL,
  `numero_entrega` VARCHAR(255) NOT NULL,
  `complemento_entrega` VARCHAR(255) NULL,
  PRIMARY KEY (`pedido_id`),
  UNIQUE INDEX `pedido_id_UNIQUE` (`pedido_id` ASC) VISIBLE,
  INDEX `fk_pedido_estabelecimento_associado1_idx` (`estabelecimento_associado_id` ASC) VISIBLE,
  INDEX `fk_pedido_pessoa1_idx` (`pessoa_id` ASC) VISIBLE,
  CONSTRAINT `fk_pedido_estabelecimento_associado1`
    FOREIGN KEY (`estabelecimento_associado_id`)
    REFERENCES `teupet`.`estabelecimento_associado` (`estabelecimento_associado_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pedido_pessoa1`
    FOREIGN KEY (`pessoa_id`)
    REFERENCES `teupet`.`pessoa` (`pessoa_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `teupet`.`pedido_produto`
-- -----------------------------------------------------
-- DROP TABLE IF EXISTS `teupet`.`pedido_produto` ;

CREATE TABLE IF NOT EXISTS `teupet`.`pedido_produto` (
  `pedido_id` INT NOT NULL,
  `produto_id` INT NOT NULL,
  `quantidade` INT NOT NULL,
  PRIMARY KEY (`pedido_id`, `produto_id`),
  INDEX `fk_pedido_has_produto_produto1_idx` (`produto_id` ASC) VISIBLE,
  INDEX `fk_pedido_has_produto_pedido1_idx` (`pedido_id` ASC) VISIBLE,
  CONSTRAINT `fk_pedido_has_produto_pedido1`
    FOREIGN KEY (`pedido_id`)
    REFERENCES `teupet`.`pedido` (`pedido_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pedido_has_produto_produto1`
    FOREIGN KEY (`produto_id`)
    REFERENCES `teupet`.`produto` (`produto_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `teupet`.`tipo_cobertura_procedimento`
-- -----------------------------------------------------
-- DROP TABLE IF EXISTS `teupet`.`tipo_cobertura_procedimento` ;

CREATE TABLE IF NOT EXISTS `teupet`.`tipo_cobertura_procedimento` (
  `tipo_cobertura_procedimento_id` INT NOT NULL AUTO_INCREMENT,
  `tipo_cobertura_procedimento` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`tipo_cobertura_procedimento_id`),
  UNIQUE INDEX `tipo_cobertura_plano_saude_id_UNIQUE` (`tipo_cobertura_procedimento_id` ASC) VISIBLE,
  UNIQUE INDEX `tipo_cobertura_plano_saude_UNIQUE` (`tipo_cobertura_procedimento` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `teupet`.`cobertura_procedimento`
-- -----------------------------------------------------
-- DROP TABLE IF EXISTS `teupet`.`cobertura_procedimento` ;

CREATE TABLE IF NOT EXISTS `teupet`.`cobertura_procedimento` (
  `cobertura_procedimento_id` INT NOT NULL AUTO_INCREMENT,
  `tipo_cobertura_procedimento_id` INT NOT NULL,
  `nome_procedimento` VARCHAR(255) NOT NULL,
  `coparticipacao` FLOAT NOT NULL,
  PRIMARY KEY (`cobertura_procedimento_id`),
  UNIQUE INDEX `nome_procedimento_UNIQUE` (`nome_procedimento` ASC) VISIBLE,
  INDEX `fk_cobertura_plano_saude_tipo_cobertura_plano_saude1_idx` (`tipo_cobertura_procedimento_id` ASC) VISIBLE,
  CONSTRAINT `fk_cobertura_plano_saude_tipo_cobertura_plano_saude1`
    FOREIGN KEY (`tipo_cobertura_procedimento_id`)
    REFERENCES `teupet`.`tipo_cobertura_procedimento` (`tipo_cobertura_procedimento_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `teupet`.`plano_saude_procedimentos_cobertos`
-- -----------------------------------------------------
-- DROP TABLE IF EXISTS `teupet`.`plano_saude_procedimentos_cobertos` ;

CREATE TABLE IF NOT EXISTS `teupet`.`plano_saude_procedimentos_cobertos` (
  `plano_saude_id` INT NOT NULL,
  `cobertura_procedimento_id` INT NOT NULL,
  PRIMARY KEY (`plano_saude_id`, `cobertura_procedimento_id`),
  INDEX `fk_plano_saude_has_cobertura_plano_saude_cobertura_plano_sa_idx` (`cobertura_procedimento_id` ASC) VISIBLE,
  INDEX `fk_plano_saude_has_cobertura_plano_saude_plano_saude1_idx` (`plano_saude_id` ASC) VISIBLE,
  CONSTRAINT `fk_plano_saude_has_cobertura_plano_saude_plano_saude1`
    FOREIGN KEY (`plano_saude_id`)
    REFERENCES `teupet`.`plano_saude` (`plano_saude_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_plano_saude_has_cobertura_plano_saude_cobertura_plano_saude1`
    FOREIGN KEY (`cobertura_procedimento_id`)
    REFERENCES `teupet`.`cobertura_procedimento` (`cobertura_procedimento_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- DML pessoa
INSERT INTO pessoa VALUES 
(1, 'Marco', STR_TO_DATE('01-07-2002', '%d-%m-%Y'), '11999999999', 'teoaa2@gmail.com', '11111111111'),
(2, 'Ana', STR_TO_DATE('22-04-2000', '%d-%m-%Y'), '11999999998', 'ana@hotmail.com', '22222222222'),
(3, 'João', STR_TO_DATE('03-12-1999', '%d-%m-%Y'), '11999999997', 'joao@hotmail.com', '33333333333');


-- DML especie_animal
INSERT INTO especie_animal VALUES 
(1, 'Cachorro'),
(2, 'Gato');


-- DML porte_animal
INSERT INTO porte_animal VALUES 
(1, 'Pequeno'),
(2, 'Médio'),
(3, 'Grande'),
(4, 'Não se aplica');


-- DML sexo_animal
INSERT INTO sexo_animal VALUES 
(1, 'Macho'),
(2, 'Fêmea');


-- DML plano_saude
INSERT INTO plano_saude VALUES
(1, 'Nenhum', 0, 0),
(2, 'Básico', 24.99, 30),
(3, 'Premium', 49.99, 15);
CREATE DATABASE IF NOT EXISTS torneadora;
USE torneadora;
CREATE TABLE IF NOT EXISTS cliente(
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255),
    genero VARCHAR(255),
    dt_nasc DATE,
    endereco VARCHAR(255),
    celular VARCHAR(255),
    email VARCHAR(255),
    observacao VARCHAR(255)
);




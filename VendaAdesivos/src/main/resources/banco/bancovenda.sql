CREATE TABLE administrador(
    email VARCHAR(100) UNIQUE NOT NULL,
    senha VARCHAR (100) NOT NULL,
    PRIMARY KEY (email)
);
CREATE TABLE cliente(
    email VARCHAR(100) NOT NULL,
    senha VARCHAR(50) UNIQUE NOT NULL,
    PRIMARY KEY(email)
);
CREATE TABLE adesivo(
    id SERIAL NOT NULL, 
    nome VARCHAR(100) NOT NULL,
    categoria VARCHAR(100) NOT NULL,
    precoUnid DOUBLE PRECISION DEFAULT 0 NOT NULL,
    qtdDisponivel INTEGER NOT NULL,
    disponivel BOOLEAN DEFAULT FALSE,
    imagem VARCHAR(100),
    PRIMARY KEY(id)
);
CREATE TABLE carrinho(
    id SERIAL NOT NULL,
    idproduto INTEGER NOT NULL,
    precounid DOUBLE PRECISION DEFAULT 0 NOT NULL,
    qtdprodutos INTEGER NOT NULL,
    PRIMARY KEY(id)
);
CREATE TABLE categoria(
    id SERIAL NOT NULL,
    descricao varchar(100) NOT NULL,
    idAdesivo INTEGER NOT NULL,
    FOREIGN KEY (idAdesivo) REFERENCES adesivo(id) ON DELETE CASCADE,
    PRIMARY KEY(id, idAdesivo)
);
CREATE TABLE compra(
    id SERIAL NOT NULL,
    codigo VARCHAR(8) NOT NULL,
    idcarrinho INTEGER NOT NULL,
    emailcliente VARCHAR(50) NOT NULL,
    idadesivo INTEGER NOT NULL,
    datacompra DATE NOT NULL,
    valorcompra DOUBLE PRECISION DEFAULT 0 NOT NULL,
    PRIMARY KEY (id)    
);
CREATE TABLE maisvendido(
    id SERIAL NOT NULL,
    idadesivo SERIAL NOT NULL,
    emailcliente VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE promocao(
    id SERIAL NOT NULL,
    nome VARCHAR(100) NOT NULL,
    idAdesivo INTEGER NOT NULL,
    dataInicio DATE NOT NULL,
    dataFinal DATE NOT NULL,
    desconto DOUBLE PRECISION NOT NULL,
    PRIMARY KEY (id)
);
INSERT INTO administrador (email, senha) VALUES ('admin@gmail.com', 'admin');


INSERT INTO adesivo (id, nome, categoria, precoUnid, qtdDisponivel, disponivel, imagem) VALUES (1, 'bower', 'navegador', '3', 2,'true', 'acessor/img/bower.png');
INSERT INTO adesivo (id, nome, categoria, precoUnid, qtdDisponivel, disponivel, imagem) VALUES (2, 'cassandra', 'navegador', '2.20', 4,'true', 'acessor/img/cassandra.png');
INSERT INTO adesivo (id, nome, categoria, precoUnid, qtdDisponivel, disponivel, imagem) VALUES (3, 'css3', 'web', '3.50', 6,'true', 'acessor/img/css3.png');
INSERT INTO adesivo (id, nome, categoria, precoUnid, qtdDisponivel, disponivel, imagem) VALUES (4, 'chrome', 'navegador', '2.50', 5,'true', 'acessor/img/chrome.png');
INSERT INTO adesivo (id, nome, categoria, precoUnid, qtdDisponivel, disponivel, imagem) VALUES (5, 'codepen', 'programacao', '4', 3,'true', 'acessor/img/codepen.png');

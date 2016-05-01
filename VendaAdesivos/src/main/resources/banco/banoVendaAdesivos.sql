CREATE TABLE cliente(
    id SERIAL NOT NULL, 
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(50) UNIQUE NOT NULL,
    PRIMARY KEY(id)
);
CREATE TABLE produto(
    id SERIAL NOT NULL, 
    nome VARCHAR(100) NOT NULL,
    categoria VARCHAR(100) NOT NULL,
    precoUnid DOUBLE PRECISION DEFAULT 0 NOT NULL,
    qtdDisponivel INTEGER NOT NULL,
    imagem VARCHAR(100),
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
    idCarrinho INTEGER NOT NULL,
    idCliente INTEGER NOT NULL,
    idAdesivo INTEGER NOT NULL,
    dataCompra DATE NOT NULL,
    valorCompra DOUBLE PRECISION DEFAULT 0 NOT NULL,
    PRIMARY KEY (id)    
);


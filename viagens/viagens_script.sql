
drop database if exists viagens;
create database viagens;

use viagens;

CREATE TABLE Aviao (
    id INT AUTO_INCREMENT PRIMARY KEY,
    modelo VARCHAR(255),
    empresa VARCHAR(255),
    emViagem BOOLEAN
);

CREATE TABLE Viagem (
    id INT AUTO_INCREMENT PRIMARY KEY,
    aviaoID INT,
    origem VARCHAR(255) ,
    destino VARCHAR(255),
    data DATE,
    totalPassageiros INT,
    FOREIGN KEY (aviaoID) REFERENCES Aviao(ID)
);

CREATE TABLE Passageiro (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    passaporte VARCHAR(255),
    idViagem INT,
    FOREIGN KEY (idViagem) REFERENCES Viagem(ID)
);

INSERT INTO Aviao (modelo, empresa, emViagem) VALUES
    ('Boeing 737', 'GOL', true),
    ('Airbus A320', 'LATAM', true),
    ('Embraer E190', 'AZUL', true),
	('ATR 72', 'jet Smart', false),
    ('Airbus A319', 'sky airlines', false),
    ('Vickers vc10', 'vueling', false);
    
INSERT INTO Viagem (aviaoID, origem, destino, data, totalPassageiros) VALUES
    (1, 'São Paulo', 'Rio de Janeiro', '2023-10-10', 0),
    (2, 'Rio de Janeiro', 'Salvador', '2023-10-15', 0),
    (3, 'Brasília', 'Porto Alegre', '2023-10-20', 0);

INSERT INTO Passageiro (nome, passaporte) VALUES
    ('Maria Silva', 'AB123456'),
    ('José Santos', 'CD789012'),
    ('Ana Oliveira', 'EF345678'),
    ('Carlos Pereira', 'GH901234'),
    ('Patricia Ferreira', 'IJ567890'),
    ('Rafael Souza', 'KL123456');
    


select * from passageiro;
select * from aviao;
select * from viagem;




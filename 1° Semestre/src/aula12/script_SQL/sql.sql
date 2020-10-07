CREATE DATABASE dpbd;

USE dpbd;

CREATE TABLE cargo (
	IdCargo int not null auto_increment primary key,
    Descricao varchar(40) not null,
    Departamento varchar(40) not null
);

CREATE TABLE funcionario (
	IdFuncionario int not null auto_increment primary key,
    Nome varchar(60) not null,
    Sexo char(1) not null,
    Salario float not null,
    PlanoSaude bool default true, 
    IdCargo int not null,
    foreign key (IdCargo) references cargo(IdCargo)
);

INSERT INTO cargo VALUES (null, 'Analista de negócios', 'Gerencia de negócios');
INSERT INTO cargo VALUES (null, 'Analista de requisitos', 'Gerencia de requisitos');
INSERT INTO cargo VALUES (null, 'Analista de sistemas', 'Gerencia de desenvolvimento');
INSERT INTO cargo VALUES (null, 'Analista de banco de dados', 'Gerencia de desenvolvimento');
INSERT INTO cargo VALUES (null, 'Analista de testes', 'Gerencia de qualidade');

SELECT * FROM cargo;
select * from funcionario;
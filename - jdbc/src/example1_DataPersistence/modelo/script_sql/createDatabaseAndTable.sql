create database testepgdb;

create table pessoas (
	id serial,
	nome varchar(255) not null,
	endereco varchar(255),
	cep bigint,
	telefone varchar(17),
	renda double precision,
	situacao int,
	primary key(id)
);
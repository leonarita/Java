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

create table pessoafisica (
	cpf char(11),
	rg char(9),
	idade int
) inherits (pessoas);

create table pessoajuridica (
	cnpj char(14)
) inherits (pessoas);

create table contaespecial (
	limiteConta double precision
) inherits (contascomuns);

create table contapoupanca (
	aniversarioConta date
) inherits (contascomuns);

create table pessoaconta (
	idPessoa bigint,
	idConta bigint,
	
	primary key(idPessoa, idConta)
);
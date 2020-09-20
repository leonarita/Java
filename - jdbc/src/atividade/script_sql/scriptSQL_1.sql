create database controlebancariobd;

-- \c controlebancariobd;

create table contascomuns (
	numeroconta serial,
	aberturaconta date,
	fechamentoconta date,
	situacaoconta int,
	senhaconta int,
	saldoconta float,
	primary key (numeroconta)
);

create table movimentos (
	id serial,
	tipo int,
	datahora timestamp,
	valor float,
	numerocontacomum bigint,
	primary key (id)
	-- , constraint fk_mov_cc foreign key(numerocontacomum) references contascomuns(numeroconta)
);

-- alter table movimento drop constraint fk_mov_cc;
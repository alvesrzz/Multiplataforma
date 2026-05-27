create database exercicio1;

use exercicio1;

create table funcionario (
	id int auto_increment primary key,
    nome varchar(100),
    data_nascimento date,
    cod_emp int,
    foreign key (cod_emp) references empresa(id)
    );
    
create table empresa (
	id int auto_increment primary key,
    nome varchar(100),
    qtd_func int,
    endereco varchar(100)
);
    
use carteira;

drop database carteira;
create database carteira;

select * from transacoes;

select * from usuarios;

use carteira;

create table transacoes(
id bigint not null auto_increment,
ticker varchar(10) not null,
preco decimal(18,2) not null,
quantidade int not null,
tipo varchar(50) not null,
data date not null,
primary key(id)
);

describe transacoes;

use carteira;



create table usuarios(
id bigint not null auto_increment,
nome varchar(255) not null,
login varchar(100) not null,
senha varchar(100) not null,
primary key(id)
);

desc usuarios;
desc transacoes;

drop table  transacoes;
drop table usuarios;

alter table transacoes add column usuario_id bigint not null;
alter table transacoes add foreign key(usuario_id) references usuarios(id);


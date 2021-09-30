create table transacoes(
id bigint not null auto_increment,
ticker varchar(10) not null,
preco decimal(18,2) not null,
quantidade int not null,
tipo varchar(50) not null,
data date not null,
primary key(id)
);
create table posts (
    id_post int not null primary key auto_increment,
    titulo varchar(100),
    conteudo varchar(100),
    data_criacao date,
    id_usuario int,
    foreign key (id_usuario) references users(id_usuario)
);
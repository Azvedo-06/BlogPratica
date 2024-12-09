create table users (
    id_usuario int not null primary key auto_increment,
    username varchar(100),
    email varchar(100),
    senha varchar(100),
    data_criacao date
);
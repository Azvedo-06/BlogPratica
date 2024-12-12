create table comments (
    id_comments int not null primary key auto_increment,
    conteudo varchar(200),
    data_criacao date,
    id_post int,
    id_usuario int,
    foreign key (id_post) references posts(id_post),
    foreign key (id_usuario) references users(id_usuario)
);
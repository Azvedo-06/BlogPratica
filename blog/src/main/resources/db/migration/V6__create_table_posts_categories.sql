create table posts_categories (
    id_post int not null,
    id_categories int not null,
    -- chave estrangeiras
    foreign key (id_post) references posts(id_post),
    foreign key (id_categories) references categories(id_categories),
    -- chave composta
    primary key (id_post, id_categories)
);
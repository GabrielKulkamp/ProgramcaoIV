create table projeto (
    id numeric not null primary key,
    nome text not null
);


create table tarefa (
    id numeric not null primary key,
    titulo text not null,
    isFinalizado boolean not null default false,
	CONSTRAINT fk_projeto 
		FOREIGN KEY (id_projeto) 
		REFERENCES projeto (id)
);

CREATE SEQUENCE seq_tarefa INCREMENT 1 START 1;
CREATE SEQUENCE seq_projeto INCREMENT 1 START 1;


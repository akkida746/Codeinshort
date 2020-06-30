drop table if exists VIDEO_SERIES;  
  
create table VIDEO_SERIES  
(  
    ID         bigint auto_increment primary key not null,  
    NAME       varchar(100)                      not null,  
    VOLUMES    int                               not null,  
    CASH_VALUE decimal                           not null,  
    GENRE      varchar(100)                      not null  
);

insert into VIDEO_SERIES (NAME, VOLUMES, CASH_VALUE, GENRE) values ('Modern Family', 12, 12.3, 'SITCOM');
insert into VIDEO_SERIES (NAME, VOLUMES, CASH_VALUE, GENRE) values ('Six Feet Under', 10, 34.3, 'DRAMA');
insert into VIDEO_SERIES (NAME, VOLUMES, CASH_VALUE, GENRE) values ('Queer as Folk', 24, 55.3, 'DRAMA');
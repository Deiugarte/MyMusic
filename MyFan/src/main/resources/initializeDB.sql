-- Inserting default user roles
insert into users_roles(usersrolesid, rolename) values (10, 'System administrator')
insert into users_roles(usersrolesid, rolename) values (11,'Band')
insert into users_roles(usersrolesid, rolename) values (12, 'Fanatic')
insert into users_roles(usersrolesid, rolename) values (13, 'Disable')

insert into ubications(ubicationid,name) values (10, 'Costa Rica')
insert into ubications(ubicationid,name) values (11, 'Panama')


insert into genres(genreid,name) values (17, 'Pop')
insert into genres(genreid,name) values (11, 'Rock')



insert into users(userid,Username,password,ubication,role,name,creationDate,birthday) values (11, 'javesp','123',10,10,'Javier Espinoza','2016-06-12','1991-04-05')
insert into users(userid,Username,password,ubication,role,name,creationDate,birthday) values (10, 'Blaken','asd',10,12,'Deivid Ugarte','2016-02-02','1993-09-29')

insert into artists(userid,followers) values (10,900)

insert into users_genres(idgenre,iduser) values (17,11)
insert into users_genres(idgenre,iduser) values (11,11)

insert into news(artist,tittle,content,date) values (1,'title1', 'HOLA','2016-02-02')
insert into news(artist,tittle,content,date) values (1,'title2', 'HOLA','2016-04-02')

insert into events(artist,ubication,tittle,eventdate,content,type) values (1,10,'title3','2016-07-02','escriba aqui','true')




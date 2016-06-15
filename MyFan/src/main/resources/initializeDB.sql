-- Inserting default user roles
insert into users_roles(usersrolesid, rolename) values (10, 'System administrator')
insert into users_roles(usersrolesid, rolename) values (11,'Band')
insert into users_roles(usersrolesid, rolename) values (12, 'Fanatic')

insert into ubications(ubicationid,name) values (10, 'Costa Rica')
insert into ubications(ubicationid,name) values (11, 'Panama')


insert into genres(genreid,name) values (1789, 'Pop')
insert into genres(genreid,name) values (11, 'Rock')


insert into users(userid,Username,password,ubication,role,name,creationDate,birthday) values (11, 'javesp','123',10,10,'Javier Espinoza','2016-06-12','1991-04-05')
insert into users(userid,Username,password,ubication,role,name,creationDate,birthday) values (10, 'Blaken','asd',10,10,'Deivid Ugarte','2016-02-02','1993-09-29')




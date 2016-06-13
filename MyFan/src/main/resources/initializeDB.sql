-- Inserting default user roles
insert into users_roles(usersrolesid, rolename) values (10, 'System administrator')
insert into users_roles(usersrolesid, rolename) values (11,'Band')
insert into users_roles(usersrolesid, rolename) values (12, 'Fanatic')

insert into ubications(ubicationid,name) values (10, 'Costa Rica')
insert into ubications(ubicationid,name) values (11, 'Panama')

insert into users(userid,Username,password,ubication,role,name,creationDate,birthday) values (10, 'Blaken','asd',10,10,'Deivid Ugarte','2016-02-02','1993-09-29')



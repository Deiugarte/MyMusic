-- Inserting default user roles
insert into ArtistsScores(Score,Voters,CommentAmount) values (1, 2, 3)
insert into ArtistsScores(Score,Voters,CommentAmount) values (4, 5, 6)
insert into ArtistsScores(Score,Voters,CommentAmount) values (7, 8, 9)


insert into DiscsScores(Score,Voters,CommentAmount) values (10, 20, 30)
insert into DiscsScores(Score,Voters,CommentAmount) values (40, 50, 60)
insert into DiscsScores(Score,Voters,CommentAmount) values (70, 80, 90)


insert into ConcertsScores(Score,Voters,CommentAmount) values (100, 200, 300)
insert into ConcertsScores(Score,Voters,CommentAmount) values (400, 500, 600)
insert into ConcertsScores(Score,Voters,CommentAmount) values (700, 800, 900)

insert into Artists (ArtistName, FollowersAmount, Ubication, Image, DiscScoreId, ArtistScore, ConcertScore) values ('WAGNER', 15, 'AB', 'ABC', 1, 1, 1)
insert into Artists (ArtistName, FollowersAmount, Ubication, Image, DiscScoreId, ArtistScore, ConcertScore) values ('wagner', 15, 'BC', 'BCD', 2, 2, 2)
insert into Artists (ArtistName, FollowersAmount, Ubication, Image, DiscScoreId, ArtistScore, ConcertScore) values ('C', 15, 'AB', 'CDE', 3, 3, 3)
insert into Artists (ArtistName, FollowersAmount, Ubication, Image, DiscScoreId, ArtistScore, ConcertScore) values ('WaGnEr', 15, 'AB', 'CDE', 3, 3, 3)

insert into MusicalGenres (GenreName) values ('Bachata')
insert into MusicalGenres (GenreName) values ('Bolero')
insert into MusicalGenres (GenreName) values ('Pop')
insert into MusicalGenres (GenreName) values ('Salsa')

insert into ArtistsGenres (ArtistId, GendeId) values (1, 1)
insert into ArtistsGenres (ArtistId, GendeId) values (1, 2)
insert into ArtistsGenres (ArtistId, GendeId) values (2, 1)
insert into ArtistsGenres (ArtistId, GendeId) values (2, 4)
insert into ArtistsGenres (ArtistId, GendeId) values (3, 3)
insert into ArtistsGenres (ArtistId, GendeId) values (4, 4)
insert into ArtistsGenres (ArtistId, GendeId) values (4, 3)
insert into ArtistsGenres (ArtistId, GendeId) values (4, 2)
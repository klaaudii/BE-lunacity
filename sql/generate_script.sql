
insert into language(name)
VALUES('SK'),('EN'),('FR'),('RU'),
      ('ES'),('PL'),('CZ');

insert into rating(name, explanation)
VALUES('7', 'Nevhodné pre maloletých do 7 rokov, vek je nutné overiť!' ),
      ('12', 'Nevhodné pre maloletých do 12 rokov, vek je nutné overiť!'),
      ('15', 'Nevhodné pre maloletých do 15 rokov, vek je nutné overiť!'),
      ('G', 'Vhodné pre všetky vekové skupiny maloletých.');

insert into subtitles(name)
VALUES('SK'),('CZ'),('EN');

insert into film(title, description, release_year, language_id, subtitles_id, length, rating_id, youtube_path)
VALUES('Shrek', 'Kde bolo, tam bolo, v jednom ďalekom močiari žil zelený obor menom Shrek, ktorého drahocenná samota bola náhle otrasená inváziou otravných rozprávkových postavičiek. V jeho jedle sú myši, v jeho posteli veľký zlý vlk, v dome a v jeho okolí tri prasiatka a ďalší, všetci vyhostení zo svojho kráľovstva zlým lordom Farquaadom. Odhodlaný zachrániť ich domov (nehovoriac o svojom) Shrek uzavrie dohodu s Farquaadom a vydá sa zachrániť z pazúrov zlého draka krásnu princeznú Fionu, aby sa stala Farquaadovou nevestou. Na svojej výprave je sprevádzaný vtipkujúcim somárom, ktorý by pre Shreka urobil všetko, ale ktorý v žiadnom prípade nestíchne. Záchrana princeznej sa zdá byť ten najmenší problém, keď je odhalené temné tajomstvo, ktoré ukrývala'
, 2004, 1, 1, 141, 1, 'https://www.youtube.com/embed/CwXOrWvPBPk'),
      ('Rýchlo a zbesilo 10', 'Počas mnohých misií a napriek neprekonateľným prekážkam Dom Toretto (Vin Diesel) a jeho rodina prekonali, a premohli každého nepriateľa, ktorý sa im postavil do cesty. Teraz čelia protivníkovi, ktorý sa vynára z tieňov minulosti, je poháňaný krvnou pomstou, je odhodlaný rozbiť túto rodinu a navždy zničiť všetko a všetkých, ktorých Dom miluje. Vo filme Fast Five z roku 2011 Dom a jeho partia zlikvidovali zákerného brazílskeho drogového kráľa Hernana Reyesa a na moste v Riu De Janeiro mu sťali hlavu. Nevedeli však, že Reyesov syn Dante (Jason Momoa) bol toho všetkého svedkom a posledných 12 rokov pripravoval plán, ako prinútiť Doma zaplatiť najvyššiu cenu.',
       2007, 1, 1, 120, 2, 'https://www.youtube.com/embed/tE1L3h7w2Yk');

insert into auditorium(name)
VALUES ('Luna'), ('Estrella'), ('Sol');

insert into seat(x,y)
VALUES (1,1), (1,2),(1,3),
       (2,1),(2,2),(2,3),
       (3,1),(3,2),(3,3);

insert into auditorium_seat(auditorium_id, seat_id)
VALUES (1,1),(1,2),(1,3),
       (1,4),(1,5),
       (1,7),(1,9);


insert into screening(date, time, price, film_id, auditorium_id)
VALUES ('2023-06-21', '22:30:00', 10, 1, 1 ), ('2023-06-21', '20:30:00',10, 1, 1);

insert into genre(name)
VALUES ('Komédia'), ('Rozprávka'), ('Horor'), ('Akčný'), ('Dobrodružný'), ('Krimi'), ('Thriller');
insert into film_genre(film_id, genre_id)
VALUES (1,1), (1,2), (2,4), (2,6), (2,7);

insert into reservation(created, user_id, first_name, last_name, email, phone_number)
values (TIMESTAMP '2022-01-20 09:00:00', NULL, 'A', 'B', 'A', '156156');

insert into ticket(screening_id, seat_id)
VALUES (1,1),(1,2),(1,3),
       (1,4),(1,5),
       (1,7),(1,9);

select * from film;
select * from reservation;
select * from ticket;



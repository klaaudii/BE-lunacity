drop table if exists language cascade;
create table language
(
    language_id serial PRIMARY KEY,
    name varchar NOT NULL UNIQUE
);

drop table if exists rating cascade;
create table rating
(
    rating_id serial PRIMARY KEY,
    name varchar NOT NULL UNIQUE,
    explanation varchar NOT NULL
);

drop table if exists subtitles cascade;
create table subtitles
(
    subtitles_id serial PRIMARY KEY,
    name varchar NOT NULL UNIQUE
);



drop table if exists film cascade;
create table film
(
    film_id serial PRIMARY KEY,
    title varchar NOT NULL,
    description varchar NOT NULL,
    release_year integer NOT NULL CHECK (release_year >= 1900),
    language_id integer REFERENCES language,
    subtitles_id integer REFERENCES subtitles,
    length integer NOT NULL CHECK (length > 0),
    rating_id integer REFERENCES rating,
    youtube_path varchar
);



drop table if exists genre cascade;
create table genre
(
    genre_id serial PRIMARY KEY,
    name varchar NOT NULL UNIQUE
);

drop table if exists film_genre cascade;
create table film_genre
(
    film_id integer REFERENCES film ON DELETE CASCADE NOT NULL,
    genre_id integer REFERENCES genre NOT NULL,
    PRIMARY KEY(film_id, genre_id)
);

drop table if exists auditorium cascade;
create table auditorium
(
    auditorium_id serial PRIMARY KEY,
    name varchar NOT NULL UNIQUE
);

drop table if exists seat cascade;
create table seat
(
    seat_id serial PRIMARY KEY,
    x integer NOT NULL CHECK (x >= 0),
    y integer NOT NULL CHECK (y >= 0),
    UNIQUE(x,y)
);

drop table if exists auditorium_seat cascade;
create table auditorium_seat
(
    auditorium_id integer REFERENCES auditorium,
    seat_id integer REFERENCES seat,
    PRIMARY KEY(auditorium_id, seat_id)
);

drop table if exists screening cascade;
create table screening
(
    screening_id serial PRIMARY KEY,
    date date,
    time time,
    price integer,
    film_id integer REFERENCES film,
    auditorium_id integer REFERENCES auditorium,
    UNIQUE(auditorium_id, date, time)
);


drop table if exists ticket_type cascade;
create table ticket_type
(
    type varchar PRIMARY KEY,
    discount integer DEFAULT 0
);

drop table if exists ticket_state cascade;
create table ticket_state
(
    state varchar PRIMARY KEY
);

drop table if exists "user" cascade;
create table "user"
(
    user_id serial PRIMARY KEY,
    first_name varchar NOT NULL,
    last_name varchar NOT NULL,
    email varchar,
    phone_number varchar,
    username varchar NOT NULL,
    password varchar NOT NULL,
    is_admin boolean DEFAULT false NOT NULL
);

drop table if exists reservation cascade;
create table reservation
(
    reservation_id serial PRIMARY KEY,
    created timestamp NOT NULL,
    user_id integer REFERENCES "user",
    first_name varchar,
    last_name varchar,
    email varchar,
    phone_number varchar
);


drop table if exists ticket cascade;
create table ticket
(
    ticket_id serial PRIMARY KEY,
    screening_id integer REFERENCES screening,
    seat_id integer REFERENCES seat,
    type integer DEFAULT 0,
    state integer DEFAULT 0,
    reservation_id integer REFERENCES reservation,
    version integer DEFAULT 0
);
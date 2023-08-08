insert into author (id, name)
values (1, 'Good author');

insert into genre (id, name)
values (1, 'Math');
insert into genre (id, name)
values (2, 'Chemistry');

insert into book (id, name, author_id, genre_id)
values (1, 'Good book', 1, 1);

insert into book (id, name, author_id, genre_id)
values (2, 'Bad book', 1, 2);
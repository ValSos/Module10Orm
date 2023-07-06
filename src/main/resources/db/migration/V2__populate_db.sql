INSERT INTO client (name)
VALUES
	('Petrenko Taras'),
	('Dovhan Maxim'),
	('Skrynnyk Kateryna'),
	('Shevchenko Olha'),
	('Dudnik Natalia'),
	('Ivanenko Petro'),
	('Melnik Dmytro'),
	('Kolomiets Daryna'),
	('Tkach Eygen'),
	('Zubko Vasyl');

INSERT INTO planet (id, name)
VALUES
    ('MARS', 'Mars 1000'),
    ('VENA', 'Venera'),
    ('SOLON', 'Sololand 200'),
    ('URAN', 'Uran'),
    ('SATURN', 'Saturn');

INSERT INTO ticket (client_id, from_planet_id, to_planet_id)
VALUES
    (1, 'MARS', 'VENA'),
    (2, 'VENA', 'MARS'),
    (3, 'URAN', 'SOLON'),
    (4, 'SATURN', 'URAN'),
    (5, 'SOLON', 'SATURN'),
    (6, 'MARS', 'URAN'),
    (7, 'URAN', 'VENA'),
    (8, 'SATURN', 'URAN'),
    (9, 'VENA', 'SATURN'),
    (10, 'SOLON', 'VENA');



INSERT INTO tmv_team(teamname) VALUES ('Cloud Desegregation');

INSERT INTO tmv_person(name, tmv_teamid) VALUES ('Bruce Jacoby',  (select id from tmv_team where teamname = 'Cloud Desegregation'));
INSERT INTO tmv_person(name, tmv_teamid) VALUES ('Charlie Addala',  (select id from tmv_team where teamname = 'Cloud Desegregation'));
INSERT INTO tmv_person(name, tmv_teamid) VALUES ('Mitt Sluyter',  (select id from tmv_team where teamname = 'Cloud Desegregation'));
INSERT INTO tmv_person(name, tmv_teamid) VALUES ('Naomi Kurapati',  (select id from tmv_team where teamname = 'Cloud Desegregation'));
INSERT INTO tmv_person(name, tmv_teamid) VALUES ('Pramode Tiwari',  (select id from tmv_team where teamname = 'Cloud Desegregation')); 
INSERT INTO tmv_person(name, tmv_teamid) VALUES ('Shinta Dewi',  (select id from tmv_team where teamname = 'Cloud Desegregation'));
INSERT INTO tmv_person(name, tmv_teamid) VALUES ('Srikanth Kamalot',  (select id from tmv_team where teamname = 'Cloud Desegregation'));
INSERT INTO tmv_person(name, tmv_teamid) VALUES ('Vinny Lee',  (select id from tmv_team where teamname = 'Cloud Desegregation'));

INSERT INTO tmv_person(name, tmv_teamid) VALUES ('Courtney Love',  (select id from tmv_team where teamname = 'Cloud Desegregation'));
INSERT INTO tmv_person(name, tmv_teamid) VALUES ('Matt Demon',  (select id from tmv_team where teamname = 'Cloud Desegregation'));
INSERT INTO tmv_person(name, tmv_teamid) VALUES ('Shalini Kamar',  (select id from tmv_team where teamname = 'Cloud Desegregation'));

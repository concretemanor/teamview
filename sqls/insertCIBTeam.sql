
INSERT INTO tmv_team(teamname) VALUES ('Cloud Integration Billing');

INSERT INTO tmv_person(name, tmv_teamid) VALUES ('Bob Jacoby',  (select id from tmv_team where teamname = 'Cloud Integration Billing'));
INSERT INTO tmv_person(name, tmv_teamid) VALUES ('Chandra Addala',  (select id from tmv_team where teamname = 'Cloud Integration Billing'));
INSERT INTO tmv_person(name, tmv_teamid) VALUES ('Mike Sluyter',  (select id from tmv_team where teamname = 'Cloud Integration Billing'));
INSERT INTO tmv_person(name, tmv_teamid) VALUES ('Naresh Kurapati',  (select id from tmv_team where teamname = 'Cloud Integration Billing'));
INSERT INTO tmv_person(name, tmv_teamid) VALUES ('Prakash Tiwari',  (select id from tmv_team where teamname = 'Cloud Integration Billing'));
INSERT INTO tmv_person(name, tmv_teamid) VALUES ('Shinta Smith',  (select id from tmv_team where teamname = 'Cloud Integration Billing'));
INSERT INTO tmv_person(name, tmv_teamid) VALUES ('Srikanth Kambhampati',  (select id from tmv_team where teamname = 'Cloud Integration Billing'));
INSERT INTO tmv_person(name, tmv_teamid) VALUES ('Vinny Ly',  (select id from tmv_team where teamname = 'Cloud Integration Billing'));

INSERT INTO tmv_person(name, tmv_teamid) VALUES ('Courtney Taylor',  (select id from tmv_team where teamname = 'Cloud Integration Billing'));
INSERT INTO tmv_person(name, tmv_teamid) VALUES ('Matt Carter',  (select id from tmv_team where teamname = 'Cloud Integration Billing'));
INSERT INTO tmv_person(name, tmv_teamid) VALUES ('Shalini Komarla',  (select id from tmv_team where teamname = 'Cloud Integration Billing'));

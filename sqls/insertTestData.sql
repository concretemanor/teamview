
BEGIN;
INSERT INTO tmv_team(teamname) VALUES ('Cloud Desegregation');
INSERT INTO tmv_team(teamname) VALUES ('Cloud Team 2');

INSERT INTO tmv_person(name) VALUES ('Bruce Jacoby');
INSERT INTO tmv_person(name) VALUES ('Charlie Addala');
INSERT INTO tmv_person(name) VALUES ('Mitt Sluyter');
INSERT INTO tmv_person(name) VALUES ('Naomi Kurapati');
INSERT INTO tmv_person(name) VALUES ('Pramode Tiwari');
INSERT INTO tmv_person(name) VALUES ('Shinta Dewi');
INSERT INTO tmv_person(name) VALUES ('Srikanth Kamalot');
INSERT INTO tmv_person(name) VALUES ('Vinny Lee');
INSERT INTO tmv_person(name) VALUES ('Courtney Love');
INSERT INTO tmv_person(name) VALUES ('Matt Demon');
INSERT INTO tmv_person(name) VALUES ('Shalini Kamar');

INSERT INTO tmv_xref_person_team(tmv_personid, tmv_teamid) 
  SELECT p.id, t.id FROM tmv_team t, tmv_person p WHERE t.teamname = 'Cloud Desegregation'
             AND p.name = 'Bruce Jacoby';
INSERT INTO tmv_xref_person_team(tmv_personid, tmv_teamid) 
  SELECT p.id, t.id FROM tmv_team t, tmv_person p WHERE t.teamname = 'Cloud Desegregation'
             AND p.name = 'Charlie Addala';
INSERT INTO tmv_xref_person_team(tmv_personid, tmv_teamid) 
  SELECT p.id, t.id FROM tmv_team t, tmv_person p WHERE t.teamname = 'Cloud Desegregation'
             AND p.name = 'Mitt Sluyter';
INSERT INTO tmv_xref_person_team(tmv_personid, tmv_teamid) 
  SELECT p.id, t.id FROM tmv_team t, tmv_person p WHERE t.teamname = 'Cloud Desegregation'
             AND p.name = 'Naomi Kurapati';
INSERT INTO tmv_xref_person_team(tmv_personid, tmv_teamid) 
  SELECT p.id, t.id FROM tmv_team t, tmv_person p WHERE t.teamname = 'Cloud Desegregation'
             AND p.name = 'Pramode Tiwari';
INSERT INTO tmv_xref_person_team(tmv_personid, tmv_teamid) 
  SELECT p.id, t.id FROM tmv_team t, tmv_person p WHERE t.teamname = 'Cloud Desegregation'
             AND p.name = 'Shinta Dewi';
INSERT INTO tmv_xref_person_team(tmv_personid, tmv_teamid) 
  SELECT p.id, t.id FROM tmv_team t, tmv_person p WHERE t.teamname = 'Cloud Desegregation'
             AND p.name = 'Srikanth Kamalot';
INSERT INTO tmv_xref_person_team(tmv_personid, tmv_teamid) 
  SELECT p.id, t.id FROM tmv_team t, tmv_person p WHERE t.teamname = 'Cloud Desegregation'
             AND p.name = 'Vinny Lee';
INSERT INTO tmv_xref_person_team(tmv_personid, tmv_teamid) 
  SELECT p.id, t.id FROM tmv_team t, tmv_person p WHERE t.teamname = 'Cloud Desegregation'
             AND p.name = 'Courtney Love';
INSERT INTO tmv_xref_person_team(tmv_personid, tmv_teamid) 
  SELECT p.id, t.id FROM tmv_team t, tmv_person p WHERE t.teamname = 'Cloud Desegregation'
             AND p.name = 'Matt Demon';
INSERT INTO tmv_xref_person_team(tmv_personid, tmv_teamid) 
  SELECT p.id, t.id FROM tmv_team t, tmv_person p WHERE t.teamname = 'Cloud Desegregation'
             AND p.name = 'Shalini Kamar';
INSERT INTO tmv_xref_person_team(tmv_personid, tmv_teamid) 
  SELECT p.id, t.id FROM tmv_team t, tmv_person p WHERE t.teamname = 'Cloud Team 2'
             AND p.name = 'Shalini Kamar';
END;

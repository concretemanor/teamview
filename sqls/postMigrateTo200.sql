BEGIN;

INSERT INTO tmv_xref_person_team(tmv_personid, tmv_teamid)
  SELECT tmv_personid, tmv_teamid
    FROM temporary_xref_person_team;

DROP TABLE temporary_xref_person_team;

ALTER TABLE tmv_person
  DROP COLUMN IF EXISTS tmv_teamid;
  
END;

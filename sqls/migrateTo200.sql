
CREATE TABLE temporary_xref_person_team AS
    select p.id as tmv_personid, p.tmv_teamid as tmv_teamid
        from "tmv_person" p;


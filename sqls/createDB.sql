BEGIN;

CREATE USER teamview WITH PASSWORD 'password';

CREATE DATABASE teamview;

GRANT ALL PRIVILEGES ON DATABASE teamview TO teamview;

ALTER DATABASE teamview OWNER TO teamview;

END;

DROP TABLE IF EXISTS project;

CREATE SEQUENCE project_sequence INCREMENT BY 1;

CREATE TABLE project (
    id int8 NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    logo TEXT,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL
);
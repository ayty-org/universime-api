DROP TABLE IF EXISTS project;

CREATE TABLE Project (
    id INT NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    logo TEXT NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL
);
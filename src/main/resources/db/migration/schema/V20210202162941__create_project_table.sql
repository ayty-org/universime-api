DROP TABLE IF EXISTS project;

CREATE TABLE project (
    id INT NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    logo TEXT,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
);
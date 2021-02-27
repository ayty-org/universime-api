
CREATE SEQUENCE project_sequence INCREMENT BY 1;

CREATE TABLE tb_project (
    id int8 DEFAULT nextval('project_sequence'),
    name VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    logo TEXT,
    start_date DATE ,
    end_date DATE ,
    
    CONSTRAINT tb_project_key PRIMARY KEY (id)
);
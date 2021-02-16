CREATE TABLE course (
    id int8 NOT NULL,
    course_name varchar(255) NOT NULL,
    description varchar NULL,
    CONSTRAINT course_pkey PRIMARY KEY (id)
);

CREATE SEQUENCE course_sequence INCREMENT BY 1;
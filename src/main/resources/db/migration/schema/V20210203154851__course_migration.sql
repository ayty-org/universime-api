CREATE TABLE public.registration_course (
                                            id serial NOT NULL,
                                            course_name varchar(255) NOT NULL,
                                            description varchar NULL,
                                            CONSTRAINT registration_course_pkey PRIMARY KEY (id)
);
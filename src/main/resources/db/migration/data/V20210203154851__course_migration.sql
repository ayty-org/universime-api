CREATE TABLE public.registration_course (
                                            id serial NOT NULL,
                                            course_name varchar(100) NOT NULL,
                                            description varchar NULL,
                                            CONSTRAINT registration_course_pkey PRIMARY KEY (id)
);

INSERT INTO public.registration_course
(course_name, description)
VALUES('Sistemas', 'Description');
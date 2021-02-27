CREATE SEQUENCE user_sequence INCREMENT BY 1;

Create table tb_user(

	id int8 DEFAULT nextval('user_sequence'),
	login varchar (255) not null UNIQUE,
	password varchar(255) not null ,
	email varchar (255) not null UNIQUE,
	fullname varchar(255) not null,
	image varchar (255),
	profile varchar(255),
	
	CONSTRAINT tb_user_key PRIMARY KEY (id)
	
		
);	
	
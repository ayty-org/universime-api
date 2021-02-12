CREATE SEQUENCE user_sequence INCREMENT BY 1;

Create table tb_user(
	id bigint DEFAULT nextval('user_sequence'),
	login varchar (255) not null,
	password varchar(255) not null,
	email varchar (255) not null,
	full_name varchar(255) not null,
	image varchar (255),
	profile varchar(255)
	
	
);	
	
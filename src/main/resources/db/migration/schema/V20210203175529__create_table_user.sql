Create table tb_user(
	id bigint,
	login varchar (50) not null,
	password varchar(50) not null,
	email varchar (50) not null,
	full_name varchar(50) not null,
	image varchar (50),
	admin BOOLEAN,
	perfil varchar(255)
	
	
);	
	CREATE SEQUENCE User_sequence INCREMENT BY 1;
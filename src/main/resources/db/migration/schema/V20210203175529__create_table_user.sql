CREATE SEQUENCE user_sequence INCREMENT BY 1;

Create table tb_user(
	id bigint DEFAULT nextval('user_sequence'),
	login varchar (255) not null,
	password varchar(255) not null,
	email varchar (255) not null,
	full_name varchar(255) not null,
	image varchar (255),
	admin BOOLEAN,
	profile varchar(255)
	/*
	 alter table user_project add CONSTRAINT user_key foreign key (user_id) references tb_user;
	 alter table user_project add CONSTRAINT user_project_key foreign key (user_project) references tb_user;
	 */
);	
	
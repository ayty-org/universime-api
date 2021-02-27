create table user_project(

	user_id int8 not null,
	project_id int8 not null,
	
	FOREIGN KEY (user_id) REFERENCES tb_user (id),
	FOREIGN KEY (project_id) REFERENCES tb_project (id)

);
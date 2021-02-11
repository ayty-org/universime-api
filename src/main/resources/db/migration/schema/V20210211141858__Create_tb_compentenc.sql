CREATE SEQUENCE competence_sequence INCREMENT BY 1;
create table competence(
	id bigint default nextval('competence_sequence') ,
	name varchar(255) not null,
	description varchar(255) not null,
	type_competence varchar(255) not null
)
create schema db_emerg;

create table db_emerg.voluntario(
	id serial primary key unique not null,
	nombre varchar(20) not null,
	disponibilidad bool 
);

create table db_emerg.habilidad(
	id serial primary key unique not null,
	nombre varchar(25) not null
);

create table db_emerg.institucion(
	id serial primary key unique not null,
	nombre varchar(20) not null,
	coordinador varchar(25) not null
);

create table db_emerg.estado_tarea(
	id serial primary key unique not null,
	estado_actual varchar(12) not null
);

create table db_emerg.vol_habilidad(
	id serial primary key unique not null,
	id_vo serial not null,
	id_ha serial not null,
	foreign key(id_vo) references db_emerg.voluntario(id) on delete cascade,
	foreign key(id_ha) references db_emerg.habilidad(id) on delete cascade
);

create table db_emerg.emergencia(
	id serial primary key unique not null,
	nombre varchar(20) not null,
	estado_eme varchar(12) not null,
	detalles varchar(50) not null,
	voluntarios_reg integer not null,
	id_in serial not null,
	foreign key (id_in) references db_emerg.institucion(id) on delete cascade
);

create table db_emerg.tarea(
	id serial primary key unique not null,
	nombre varchar(20) not null,
	id_es serial not null,
	id_em serial not null,
	foreign key(id_es) references db_emerg.estado_tarea(id) on delete cascade,
	foreign key(id_em) references db_emerg.emergencia(id) on delete cascade
);
create table db_emerg.ranking(
	id serial primary key unique not null,
	id_vo serial not null,
	id_ta serial not null,
	foreign key(id_vo) references db_emerg.voluntario(id) on delete cascade,
	foreign key(id_ta) references db_emerg.tarea(id) on delete cascade
);

create table db_emerg.eme_habilidad(
	id serial primary key unique not null,
	id_em serial not null,
	id_ha serial not null,
	foreign key(id_ha) references db_emerg.habilidad(id) on delete cascade,
	foreign key(id_em) references db_emerg.emergencia(id) on delete cascade
);

create table db_emerg.tarea_habilidad(
	id serial primary key unique not null,
	id_ta serial not null,
	id_ha serial not null,
	foreign key(id_ta) references db_emerg.tarea(id) on delete cascade,
	foreign key(id_ha) references db_emerg.habilidad(id) on delete cascade
);

--ALTER TABLE db_emerg.voluntario
--		ADD COLUMN geom
--			geometry(point);
			
SELECT
AddGeometryColumn('db_emerg', 'voluntario', 'geom','4326','point',2);

			
--ALTER TABLE db_emerg.emergencia
--		ADD COLUMN geom
--

SELECT
AddGeometryColumn('db_emerg', 'emergencia', 'geom','4326','point',2);

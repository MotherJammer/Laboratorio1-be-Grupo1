--Tabla voluntario
INSERT INTO db_emerg.voluntario (nombre, disponibilidad)
VALUES
  ('Dorothy Parsons', TRUE),
  ('Lily Bond', TRUE),
  ('Alison Springer', TRUE),
  ('Wendy Duncan', TRUE),
  ('Vanessa Ellison',TRUE),
  ('Amy Slater', TRUE),
  ('Warren Newman', FALSE),
  ('Penelope Walsh',TRUE),
  ('Lisa Mackenzie', FALSE),
  ('Rachel Paige',FALSE);
  
 --Tabla habilidad
 INSERT INTO db_emerg.habilidad (nombre)
 VALUES
  ('Liderazgo'),
  ('Planificacion'),
  ('Gestion de recursos'),
  ('Colaborador'),
  ('Primeros auxilios'),
  ('Fuerza'),
  ('Gestion de emergencias'),
  ('Maquinaria'),
  ('Busqueda'),
  ('Organizacion');
  
--Tabla vol_habilidad
INSERT INTO db_emerg.vol_habilidad (id_vo, id_ha)
VALUES
  ((SELECT id FROM db_emerg.voluntario WHERE nombre = 'Dorothy Parsons'), (SELECT id FROM db_emerg.habilidad WHERE nombre = 'Liderazgo')),
  ((SELECT id FROM db_emerg.voluntario WHERE nombre = 'Lily Bond'), (SELECT id FROM db_emerg.habilidad WHERE nombre = 'Planificacion')),
  ((SELECT id FROM db_emerg.voluntario WHERE nombre = 'Alison Springer'), (SELECT id FROM db_emerg.habilidad WHERE nombre = 'Gestion de recursos')),
  ((SELECT id FROM db_emerg.voluntario WHERE nombre = 'Wendy Duncan'), (SELECT id FROM db_emerg.habilidad WHERE nombre = 'Colaborador')),
  ((SELECT id FROM db_emerg.voluntario WHERE nombre = 'Wendy Duncan'), (SELECT id FROM db_emerg.habilidad WHERE nombre = 'Colaborador')),
  ((SELECT id FROM db_emerg.voluntario WHERE nombre = 'Vanessa Ellison'), (SELECT id FROM db_emerg.habilidad WHERE nombre = 'Colaborador')),
  ((SELECT id FROM db_emerg.voluntario WHERE nombre = 'Vanessa Ellison'), (SELECT id FROM db_emerg.habilidad WHERE nombre = 'Colaborador')),
  ((SELECT id FROM db_emerg.voluntario WHERE nombre = 'Amy Slater'), (SELECT id FROM db_emerg.habilidad WHERE nombre = 'Primeros auxilios')),
  ((SELECT id FROM db_emerg.voluntario WHERE nombre = 'Amy Slater'), (SELECT id FROM db_emerg.habilidad WHERE nombre = 'Maquinaria')),
  ((SELECT id FROM db_emerg.voluntario WHERE nombre = 'Amy Slater'), (SELECT id FROM db_emerg.habilidad WHERE nombre = 'Primeros auxilios'));
  
--Tabla estado_tarea
INSERT INTO db_emerg.estado_tarea (estado_actual)
VALUES
  ('Sin asignar'),
  ('En proceso'),
  ('Finalizada');
  
--Tabla institucion
INSERT INTO db_emerg.institucion (nombre, coordinador)
VALUES
  ('Fowler', 'Heather Rampling'),
  ('Carter', 'Luke Cameron'),
  ('Rose', 'Stewart Newman'),
  ('Moore', 'Faith Lambert'),
  ('Reeds', 'Joseph Sutherland'),
  ('Jammer', 'Matt Watson'),
  ('Eidres', 'Andrea Vance'),
  ('Leams', 'Blake Turner'),
  ('Pleto', 'Zoe Oliver'),
  ('Yiyi', 'Connor Ball');
  
--Tabla emergencia
INSERT INTO db_emerg.emergencia (nombre, estado_eme, detalles, voluntarios_reg, id_in)
VALUES
  ('Avalancha', 'Reclutando', 'Lorem ipsum dolor sit amet', (SELECT COUNT(*) FROM db_emerg.ranking AS R, db_emerg.tarea AS T, db_emerg.emergencia AS E WHERE R.id_ta = T.id AND T.id_em = E.id), (SELECT id FROM db_emerg.institucion WHERE nombre = 'Fowler')),
  ('Ola de calor', 'En proceso', 'Aenean massa. Cum sociis natoque', (SELECT COUNT(*) FROM db_emerg.ranking AS R, db_emerg.tarea AS T, db_emerg.emergencia AS E WHERE R.id_ta = T.id AND T.id_em = E.id), (SELECT id FROM db_emerg.institucion WHERE nombre = 'Carter')),
  ('Granizo', 'En proceso', 'Donec quam felis, ultricies nec, pellentesque eu', (SELECT COUNT(*) FROM db_emerg.ranking AS R, db_emerg.tarea AS T, db_emerg.emergencia AS E WHERE R.id_ta = T.id AND T.id_em = E.id), (SELECT id FROM db_emerg.institucion WHERE nombre = 'Rose')),
  ('Derrumbe', 'En proceso', 'Nulla consequat massa quis enim', (SELECT COUNT(*) FROM db_emerg.ranking AS R, db_emerg.tarea AS T, db_emerg.emergencia AS E WHERE R.id_ta = T.id AND T.id_em = E.id), (SELECT id FROM db_emerg.institucion WHERE nombre = 'Moore')),
  ('Huracan', 'En proceso', 'Donec pede justo, fringilla vel, aliquet nec', (SELECT COUNT(*) FROM db_emerg.ranking AS R, db_emerg.tarea AS T, db_emerg.emergencia AS E WHERE R.id_ta = T.id AND T.id_em = E.id), (SELECT id FROM db_emerg.institucion WHERE nombre = 'Reeds')),
  ('Incendio', 'Reclutando', 'Nullam dictum felis eu pede mollis pretium', (SELECT COUNT(*) FROM db_emerg.ranking AS R, db_emerg.tarea AS T, db_emerg.emergencia AS E WHERE R.id_ta = T.id AND T.id_em = E.id), (SELECT id FROM db_emerg.institucion WHERE nombre = 'Jammer')),
  ('Terremoto', 'Finalizada', 'Vivamus elementum semper nisi. Aenean vulputate', (SELECT COUNT(*) FROM db_emerg.ranking AS R, db_emerg.tarea AS T, db_emerg.emergencia AS E WHERE R.id_ta = T.id AND T.id_em = E.id), (SELECT id FROM db_emerg.institucion WHERE nombre = 'Eidres')),
  ('Tsunami', 'Finalizada', 'Aenean leo ligula, porttitor eu, consequat vitae', (SELECT COUNT(*) FROM db_emerg.ranking AS R, db_emerg.tarea AS T, db_emerg.emergencia AS E WHERE R.id_ta = T.id AND T.id_em = E.id), (SELECT id FROM db_emerg.institucion WHERE nombre = 'Leams')),
  ('Erupcion', 'Reclutando', 'Aliquam lorem ante, dapibus in, viverra quis', (SELECT COUNT(*) FROM db_emerg.ranking AS R, db_emerg.tarea AS T, db_emerg.emergencia AS E WHERE R.id_ta = T.id AND T.id_em = E.id), (SELECT id FROM db_emerg.institucion WHERE nombre = 'Pleto')),
  ('Tormenta', 'Reclutando', 'Curabitur ullamcorper ultricies nisi.', (SELECT COUNT(*) FROM db_emerg.ranking AS R, db_emerg.tarea AS T, db_emerg.emergencia AS E WHERE R.id_ta = T.id AND T.id_em = E.id), (SELECT id FROM db_emerg.institucion WHERE nombre = 'Yiyi'));
  
--Tabla tarea
INSERT INTO db_emerg.tarea (nombre, id_es, id_em)
VALUES
  ('Inspeccion de area', (SELECT id FROM db_emerg.estado_tarea WHERE estado_actual = 'Sin asignar'), (SELECT id FROM db_emerg.emergencia WHERE nombre = 'Avalancha')),
  ('Extincion incendio', (SELECT id FROM db_emerg.estado_tarea WHERE estado_actual = 'En proceso'), (SELECT id FROM db_emerg.emergencia WHERE nombre = 'Ola de calor')),
  ('Transporte', (SELECT id FROM db_emerg.estado_tarea WHERE estado_actual = 'Finalizada'), (SELECT id FROM db_emerg.emergencia WHERE nombre = 'Avalancha')),
  ('Direccion', (SELECT id FROM db_emerg.estado_tarea WHERE estado_actual = 'Finalizada'), (SELECT id FROM db_emerg.emergencia WHERE nombre = 'Tormenta')),
  ('Limpieza', (SELECT id FROM db_emerg.estado_tarea WHERE estado_actual = 'Sin asignar'), (SELECT id FROM db_emerg.emergencia WHERE nombre = 'Derrumbe')),
  ('Rescate', (SELECT id FROM db_emerg.estado_tarea WHERE estado_actual = 'En proceso'), (SELECT id FROM db_emerg.emergencia WHERE nombre = 'Terremoto')),
  ('Resumen danios', (SELECT id FROM db_emerg.estado_tarea WHERE estado_actual = 'En proceso'), (SELECT id FROM db_emerg.emergencia WHERE nombre = 'Tsunami')),
  ('Comunicacion', (SELECT id FROM db_emerg.estado_tarea WHERE estado_actual = 'Finalizada'), (SELECT id FROM db_emerg.emergencia WHERE nombre = 'Huracan')),
  ('Retiro de escombros', (SELECT id FROM db_emerg.estado_tarea WHERE estado_actual = 'Sin asignar'), (SELECT id FROM db_emerg.emergencia WHERE nombre = 'Terremoto')),
  ('Distribucion', (SELECT id FROM db_emerg.estado_tarea WHERE estado_actual = 'En proceso'), (SELECT id FROM db_emerg.emergencia WHERE nombre = 'Granizo'));
  
--Tabla ranking
INSERT INTO db_emerg.ranking (id_vo, id_ta)
VALUES
  ((SELECT id FROM db_emerg.voluntario WHERE nombre = 'Dorothy Parsons'), (SELECT id FROM db_emerg.tarea WHERE nombre = 'Inspeccion de area')),
  ((SELECT id FROM db_emerg.voluntario WHERE nombre = 'Lily Bond'), (SELECT id FROM db_emerg.tarea WHERE nombre = 'Direccion')),
  ((SELECT id FROM db_emerg.voluntario WHERE nombre = 'Alison Springer'), (SELECT id FROM db_emerg.tarea WHERE nombre = 'Transporte')),
  ((SELECT id FROM db_emerg.voluntario WHERE nombre = 'Wendy Duncan'), (SELECT id FROM db_emerg.tarea WHERE nombre = 'Direccion')),
  ((SELECT id FROM db_emerg.voluntario WHERE nombre = 'Wendy Duncan'), (SELECT id FROM db_emerg.tarea WHERE nombre = 'Inspeccion de area')),
  ((SELECT id FROM db_emerg.voluntario WHERE nombre = 'Penelope Walsh'), (SELECT id FROM db_emerg.tarea WHERE nombre = 'Direccion')),
  ((SELECT id FROM db_emerg.voluntario WHERE nombre = 'Vanessa Ellison'), (SELECT id FROM db_emerg.tarea WHERE nombre = 'Extincion incendio')),
  ((SELECT id FROM db_emerg.voluntario WHERE nombre = 'Amy Slater'), (SELECT id FROM db_emerg.tarea WHERE nombre = 'Limpieza')),
  ((SELECT id FROM db_emerg.voluntario WHERE nombre = 'Lisa Mackenzie'), (SELECT id FROM db_emerg.tarea WHERE nombre = 'Limpieza')),
  ((SELECT id FROM db_emerg.voluntario WHERE nombre = 'Amy Slater'), (SELECT id FROM db_emerg.tarea WHERE nombre = 'Direccion'));

--Tabla eme_habilidad
INSERT INTO db_emerg.eme_habilidad (id_em, id_ha)
VALUES
  ((SELECT id FROM db_emerg.emergencia WHERE nombre = 'Avalancha'), (SELECT id FROM db_emerg.habilidad WHERE nombre = 'Liderazgo')),
  ((SELECT id FROM db_emerg.emergencia WHERE nombre = 'Avalancha'), (SELECT id FROM db_emerg.habilidad WHERE nombre = 'Planificacion')),
  ((SELECT id FROM db_emerg.emergencia WHERE nombre = 'Ola de calor'), (SELECT id FROM db_emerg.habilidad WHERE nombre = 'Gestion de recursos')),
  ((SELECT id FROM db_emerg.emergencia WHERE nombre = 'Avalancha'), (SELECT id FROM db_emerg.habilidad WHERE nombre = 'Colaborador')),
  ((SELECT id FROM db_emerg.emergencia WHERE nombre = 'Derrumbe'), (SELECT id FROM db_emerg.habilidad WHERE nombre = 'Organizacion')),
  ((SELECT id FROM db_emerg.emergencia WHERE nombre = 'Huracan'), (SELECT id FROM db_emerg.habilidad WHERE nombre = 'Gestion de emergencias')),
  ((SELECT id FROM db_emerg.emergencia WHERE nombre = 'Incendio'), (SELECT id FROM db_emerg.habilidad WHERE nombre = 'Colaborador')),
  ((SELECT id FROM db_emerg.emergencia WHERE nombre = 'Tormenta'), (SELECT id FROM db_emerg.habilidad WHERE nombre = 'Primeros auxilios')),
  ((SELECT id FROM db_emerg.emergencia WHERE nombre = 'Tormenta'), (SELECT id FROM db_emerg.habilidad WHERE nombre = 'Fuerza')),
  ((SELECT id FROM db_emerg.emergencia WHERE nombre = 'Avalancha'), (SELECT id FROM db_emerg.habilidad WHERE nombre = 'Primeros auxilios'));

--Tabla tarea_habilidad
INSERT INTO db_emerg.tarea_habilidad (id_ta, id_ha)
VALUES
  ((SELECT id FROM db_emerg.tarea WHERE nombre = 'Inspeccion de area'), (SELECT id FROM db_emerg.habilidad WHERE nombre = 'Liderazgo')),
  ((SELECT id FROM db_emerg.tarea WHERE nombre = 'Direccion'), (SELECT id FROM db_emerg.habilidad WHERE nombre = 'Planificacion')),
  ((SELECT id FROM db_emerg.tarea WHERE nombre = 'Transporte'), (SELECT id FROM db_emerg.habilidad WHERE nombre = 'Liderazgo')),
  ((SELECT id FROM db_emerg.tarea WHERE nombre = 'Resumen danios'), (SELECT id FROM db_emerg.habilidad WHERE nombre = 'Liderazgo')),
  ((SELECT id FROM db_emerg.tarea WHERE nombre = 'Limpieza'), (SELECT id FROM db_emerg.habilidad WHERE nombre = 'Colaborador')),
  ((SELECT id FROM db_emerg.tarea WHERE nombre = 'Limpieza'), (SELECT id FROM db_emerg.habilidad WHERE nombre = 'Liderazgo')),
  ((SELECT id FROM db_emerg.tarea WHERE nombre = 'Limpieza'), (SELECT id FROM db_emerg.habilidad WHERE nombre = 'Maquinaria')),
  ((SELECT id FROM db_emerg.tarea WHERE nombre = 'Distribucion'), (SELECT id FROM db_emerg.habilidad WHERE nombre = 'Organizacion')),
  ((SELECT id FROM db_emerg.tarea WHERE nombre = 'Retiro de escombros'), (SELECT id FROM db_emerg.habilidad WHERE nombre = 'Fuerza')),
  ((SELECT id FROM db_emerg.tarea WHERE nombre = 'Retiro de escombros'), (SELECT id FROM db_emerg.habilidad WHERE nombre = 'Primeros auxilios'));



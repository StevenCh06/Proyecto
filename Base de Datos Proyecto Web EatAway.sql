/* CREACIOÓN DE LA BASE DE DATOS */
CREATE SCHEMA proyecto;

/*SE CREA EL USUARIO PROYECTO CON SU RESPECTICA CLAVE */
create user 'usuario_proyecto'@'%' identified by 'Usuari0_Clave.';

/*SE ASIGNAN PRIVILEGIOS AL USUARIO */
grant all privileges on proyecto.* to 'usuario_proyecto'@'%';
flush privileges;

/* SE CREA LA TABLA QUE ALMACENA USUARIOS*/
create table proyecto.usuario (
  id_usuario INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(30) NOT NULL,
  pri_apellido varchar(30),
  seg_apellido varchar(30),
  username varchar(30),
  direccion varchar(60),
  correo varchar(40),
  password varchar(512) NOT NULL,
  presentacion varchar(70),
  foto_perfil varchar(1024),
  activo bool,
  PRIMARY KEY (id_usuario))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


/* SE CREA LA TABLA QUE ALMACENA RESERVACIONES*/
create table proyecto.reserva (
  id_reserva INT NOT NULL AUTO_INCREMENT,
  id_usuario INT NOT NULL, /*Nuevo campo para identificar al usuario que hizo la reserva*/
  lugar VARCHAR(30) NOT NULL,
  cantidad INT NOT NULL,
  fecha date,
  hora varchar(30),
  ocasion varchar(30),
  descripcion varchar(40),
  precio double,
  activo bool,
  PRIMARY KEY (id_reserva),
  FOREIGN KEY (id_usuario) REFERENCES proyecto.usuario(id_usuario))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

/* SE CREA LA TABLA QUE ALMACENA RESTAURANTES BARES ETC*/
create table proyecto.restbar (
  id_local INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(30) NOT NULL,
  ubicacion VARCHAR(60) NOT NULL,
  telefono INT NOT NULL,
  horario VARCHAR(70),
  correo VARCHAR(50),
  foto VARCHAR(1024),
  tipo VARCHAR(30),
  precio VARCHAR (30),
  informacion VARCHAR (70),
  recomendaciones VARCHAR (70),
  PRIMARY KEY (id_local))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

/* SE CREA LA TABLA QUE ALMACENA EVENTOS*/
create table proyecto.evento (
  id_evento INT NOT NULL AUTO_INCREMENT,
  titulo_evento VARCHAR(30) NOT NULL,
  artista VARCHAR(30) NOT NULL,
  ubicacion VARCHAR(60) NOT NULL,
  hora VARCHAR(30),
  precio_entrada double,
  foto VARCHAR(1024),
  descripcion VARCHAR(60),
  restriccion VARCHAR(60),
  PRIMARY KEY (id_evento))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

/* SE CREA TABLA DE RESEÑAS */
create TABLE proyecto.resena (
  id_resena INT NOT NULL AUTO_INCREMENT,
  id_local INT NOT NULL,
  id_usuario INT NOT NULL, /*Nuevo campo para identificar al usuario que hizo la reseña*/
  calificacion INT NOT NULL,
  comentario VARCHAR (120),
  PRIMARY KEY (id_resena),
  FOREIGN KEY (id_local) REFERENCES restbar(id_local),
  FOREIGN KEY (id_usuario) REFERENCES proyecto.usuario(id_usuario)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

/* SE INSERTA LA TABLA QUE ALMACENA LOS USUARIOS */ 
INSERT INTO proyecto.usuario (id_usuario, nombre, pri_apellido, seg_apellido, username, direccion, correo, password, presentacion, foto_perfil, activo) VALUES 
('1', 'Beverly', 'Acuña', 'Peñaranda', 'beverly', 'San Jose, Desamparados', 'beverly@gmail.com', '$2a$10$GkEj.ZzmQa/aEfDmtLIh3udIH5fMphx/35d0EYeqZL5uzgCJ0lQRi', 'Me encanta salir a comer', 'https://www.seoptimer.com/storage/images/2016/05/foto-de-perfil-adecuada.jpg', true),
('2', 'Alan', 'Sagot', 'Cespedes', 'alan', 'Alajuela, Palmares', 'alan@gmail.com', '$2a$10$GkEj.ZzmQa/aEfDmtLIh3udIH5fMphx/35d0EYeqZL5uzgCJ0lQRi', 'Me gusta conocer nuevos lugares', 'https://img.freepik.com/foto-gratis/feliz-joven_1098-20869.jpg', true),
('3', 'Wendy', 'Badilla', 'Carvajal', 'wen', 'Heredia, Mercedes', 'wendy@gmail.com', '$2a$10$GkEj.ZzmQa/aEfDmtLIh3udIH5fMphx/35d0EYeqZL5uzgCJ0lQRi', 'Me gusta la comida mexicana', 'https://img.freepik.com/fotos-premium/mujer-caucasica-joven-aislo-sonrisa-que-senalaba-alegremente-indice-lejos_1187-63522.jpg', true),
('4', 'Steven', 'Chacón', 'Camacho', 'steven', 'Cartago, Oreamuno', 'steven@gmail.com', '$2a$10$GkEj.ZzmQa/aEfDmtLIh3udIH5fMphx/35d0EYeqZL5uzgCJ0lQRi', 'Me encanta visitar restaurantes con temáticas', 'https://img.freepik.com/fotos-premium/retrato-apuesto-hombre-caucasico-complacido-que-ve-buena-oferta-estudiando-gráfico-o-mira-estante-producto-brazos-cruzados-pecho-sonriendo-haciendo-elección-compras-fondo-blanco_176420-52808.jpg', false);

/*SE INSERTA LA TABLA QUE ALMACENA LAS RESERVACIONES */ 
INSERT INTO proyecto.reserva(id_reserva, id_usuario, lugar, cantidad, fecha, hora, ocasion, descripcion, precio, activo) VALUES
('1', '1', 'Calle 33', '4', '2023-10-28', '5:00 pm', 'Cumpleaños', 'Decoración temática mexicana', '1000', true),
('2', '2', 'La Destilería', '2', '2023-11-02', '8:00 pm', 'Fiesta', 'Fiesta neon', '20000', true),
('3', '3', 'The Yard', '6', '2023-11-10', '9:00 pm', 'Celebración', 'Ninguna especial', '30000', true),
('4', '4', 'Gravity', '20', '2023-11-25', '7:00 pm', 'Cumpleaños', 'Dj especial', '50000', true),
('5', '2', 'Zuntra', '2', '2023-10-3', '5:00 pm', 'Cena especial', 'Luces', '1000', true),
('6', '4', 'Holly Cow', '3', '2023-11-15', '4:00 pm', 'Cena', 'Mesa para cena', '1500', true);

/* SE INSERTA TABLA QUE ALMACENA RESTAURANTES Y BARES */ 

INSERT INTO proyecto.restbar(id_local, nombre, ubicacion, telefono, horario, correo, foto, tipo, precio, recomendaciones)
VALUES
(1, 'La destilería', 'La california, San José', '22729087', 'Lunes a Viernes: 12:00 PM - 10:00 PM', 'destilería@gmail.com', 'https://mir-s3-cdn-cf.behance.net/projects/404/8090d886796175.Y3JvcCwyNTAwLDE5NTUsMCwyNzI.jpg', 'Bar', 'Gama media', 'Prueba nuestro platillo especial'),
(2, 'Zuntra', 'Barrio Escalante, San José', '22729087', 'Miércoles a Sábado: 7:00 PM - 2:00 AM', 'Zuntra@gmail.com', 'https://images.otstatic.com/prod1/49130896/4/huge.jpg', 'Restaurante', 'Económico', 'Ambiente relajado y música en vivo los viernes'),
(3, 'Holy Cow', 'San Pedro, San José', '22729087', 'Lunes a Domingo: 11:00 AM - 11:00 PM', 'Holy@gmail.com', 'https://images.pexels.com/photos/5490965/pexels-photo-5490965.jpeg?cs=srgb&dl=pexels-rachel-claire-5490965.jpg&fm=jpg', 'Bar', 'Buena comida', 'Vista panorámica de la ciudad'),
(4, 'Calle 33', 'Barrio Escalante, San José', '22729087', 'Jueves a Sábado: 8:00 PM - 3:00 AM', 'Calle@gmail.com', 'https://fastly.4sqi.net/img/general/600x600/71333836_gSXW5a6ozsggPzULBBvMXyZ-icA5H4i7v_W0c0ZZ-wk.jpg', 'Restaurante', 'Barato', 'Cócteles exclusivos y DJ en vivo los sábados'),
(5, 'The yard', 'Plaza del Sol, Curriabat', '22729087', 'Lunes a Viernes: 11:30 AM - 9:30 PM', 'yard@gmail.com', 'https://tb-static.uber.com/prod/image-proc/processed_images/ed0bf44cb498fd9f37cb1742f225ef5f/3ac2b39ad528f8c8c5dc77c59abb683d.jpeg', 'Bar', 'Buena comida', 'Exquisitas bebidas '),
(6, 'Gravity ', 'San Pedro, San José', '22729087', 'Viernes y Sábado: 9:00 PM - 2:00 AM', 'gravity@gmail.com', 'https://img.freepik.com/fotos-premium/camarero-feliz-usando-tableta-digital-mientras-toma-pedido-clienta-pub_637285-2430.jpg', 'Restaurante', 'Gama media', 'Gran selección de platos ');


/* SE INSERTA TABLA DE EVENTO */ 
INSERT INTO proyecto.evento(id_evento, titulo_evento, artista, ubicacion, hora, precio_entrada, foto, descripcion, restriccion)
VALUES
(1, 'Concierto de Gimario', 'Gimario', 'La Destilería', '8:00 pm','5000', 'https://pbs.twimg.com/profile_images/1529956710764498944/o3Ywk3WL_400x400.jpg', 'Disfruta de una noche llena de música en vivo', 'Mayores de 18 años'),
(2, 'Festival de Dj´s', 'Dj´s', 'The yard', '10:00 pm', '8000', 'https://img.freepik.com/fotos-premium/controlador-musica-dj-mezclador-discoteca-fiesta_118086-3268.jpg', 'Un evento con música en vivo', 'Mayores de 18 años'),
(3, 'Noche de Comedia', 'Pablo Perez', 'Zuntra', '10:00 pm', '4500', 'https://img.freepik.com/vector-gratis/logotipo-comedia-stand-up-microfono_1308-95780.jpg', 'Risas garantizadas con nuestros comediantes locales', 'Mayores de 16 años'),
(4, 'Feria Gastronómica', 'Diversos Chefs', 'Calle 33', '12:00 pm', '6000', 'https://www.correo.ca/wp-content/uploads/2023/03/gallery-image-03.jpeg', 'Prueba deliciosa comida de diferentes chefs', 'Para todas las edades');


/*SE INSERTAN RESEÑAS */
INSERT INTO proyecto.resena (id_resena, id_local, id_usuario, calificacion, comentario) VALUES
(1, 4, 1, '4', 'Buena comida y servicio amable.'),
(2, 5, 2, '5', 'El mejor restaurante de la ciudad. ¡Definitivamente regresaré!'),
(3, 3, 3, '3', 'Comida decente, pero un poco caro.'),
(4, 1, 4, '4', 'Gran ambiente y música en vivo.'),
(5, 2, 1, '1', 'No quedé satisfecha con la comida. No volveré.'),
(6, 5, 2, '5', 'Excelente comida y atención. Altamente recomendado.'),
(7, 2, 3, '5', 'Un lugar encantador para cenas románticas.'),
(8, 6, 3, '2', 'El servicio podría mejorar.'),
(9, 4, 4, '4', 'Me encanta la variedad de platos en el menú.');

/*Se crea tabla de roles*/

create table proyecto.rol (
  id_rol INT NOT NULL AUTO_INCREMENT,
  nombre varchar(20),
  id_usuario int,
  PRIMARY KEY (id_rol),
  foreign key fk_rol_usuario (id_usuario) references proyecto.usuario(id_usuario)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

insert into proyecto.rol (id_rol, nombre, id_usuario) values
 (1,'ROLE_USER',1), (2,'ROLE_USER',2),
 (3,'ROLE_USER',3),
 (4,'ROLE_USER',4);



INSERT INTO perfil (nombre) values
('ADMIN'),('USER'),('INVITED'),('DEVELOPER');

INSERT INTO usuario (nombre, correo_electronico, contrasena) values
('Santiago', 'santiago@gmail.com','$2a$10$sGc1wEXNgpfFVhM/2AkrsOSsFGX6votWv5LxG0VUeOuV52reKrSmi'),
('Maria', 'maria@gmail.com','$2a$10$sGc1wEXNgpfFVhM/2AkrsOSsFGX6votWv5LxG0VUeOuV52reKrSmi'),
('Pepe', 'pepe@gmail.com','$2a$10$sGc1wEXNgpfFVhM/2AkrsOSsFGX6votWv5LxG0VUeOuV52reKrSmi'),
('Ana', 'ana@gmail.com','$2a$10$sGc1wEXNgpfFVhM/2AkrsOSsFGX6votWv5LxG0VUeOuV52reKrSmi');

INSERT INTO usuario_perfil (usuario_id, perfil_id) VALUES
(1,1),(2,2),(3,3),(4,4);

INSERT INTO curso (nombre, categoria) VALUES
("html", "PROGRAMACION"),
("diseño ux/ui","DISENO"),
("control mental","SOFT_SKILLS");

INSERT INTO topico (titulo,mensaje,fecha_creacion,status,autor_id,curso_id,respuestas) VALUES
("Para que sirve la etiqueta script","estoy usando la etiqueta script pero no ocurre nada, ¿porque?","2024-08-10","SOLUCIONADO",1,1,64),
("Como creo un circulo en figma", "Intento crear circulos pero salen cuadrados ayuda","2024-08-10","NO_SOLUCIONADO",2,2,6),
("Mi perro esta hablando","Quise hablarle a mi perro con control mental y ahora no se calla","2024-08-10","NO_RESPONDIDO",4,3,0);


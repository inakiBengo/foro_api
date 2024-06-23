INSERT INTO perfil (nombre) values
('ADMIN'),('USER'),('INVITED'),('DEVELOPER');

INSERT INTO usuario (nombre, correo_electronico, contrasena) values
('Santiago', 'santiago@gmail.com','$2a$10$sGc1wEXNgpfFVhM/2AkrsOSsFGX6votWv5LxG0VUeOuV52reKrSmi'),
('Maria', 'maria@gmail.com','$2a$10$sGc1wEXNgpfFVhM/2AkrsOSsFGX6votWv5LxG0VUeOuV52reKrSmi'),
('Pepe', 'pepe@gmail.com','$2a$10$sGc1wEXNgpfFVhM/2AkrsOSsFGX6votWv5LxG0VUeOuV52reKrSmi'),
('Ana', 'ana@gmail.com','$2a$10$sGc1wEXNgpfFVhM/2AkrsOSsFGX6votWv5LxG0VUeOuV52reKrSmi');

INSERT INTO usuario_perfil (usuario_id, perfil_id) VALUES
(1,1),(2,2),(3,3),(4,4);
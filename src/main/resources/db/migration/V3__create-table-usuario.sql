CREATE TABLE Usuario (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    correoElectronico VARCHAR(255) NOT NULL UNIQUE,
    contrasena VARCHAR(255) NOT NULL,
    perfil_id bigint NOT NULL,
    CONSTRAINT fk_usuario_perfil_id FOREIGN KEY (perfil_id) REFERENCES Perfil(id)
);
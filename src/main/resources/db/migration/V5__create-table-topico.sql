CREATE TABLE Topico (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    mensaje TEXT NOT NULL,
    fecha_creacion DATETIME NOT NULL,
    status VARCHAR(50) NOT NULL,
    autor_id BIGINT NOT NULL,
    curso_id BIGINT NOT NULL,
    respuestas INT,
    CONSTRAINT fk_topico_autor_id FOREIGN KEY (autor_id) REFERENCES Usuario(id),
    CONSTRAINT fk_topico_curso_id FOREIGN KEY (curso_id) REFERENCES Curso(id)
);
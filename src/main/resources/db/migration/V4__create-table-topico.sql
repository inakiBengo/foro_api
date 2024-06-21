CREATE TABLE Topico (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    mensaje TEXT NOT NULL,
    fechaCreacion DATETIME NOT NULL,
    status VARCHAR(50) NOT NULL,
    autor_id INT,
    curso_id INT,
    respuestas INT,
    CONSTRAINT fk_topico_autor_id FOREIGN KEY (autor_id) REFERENCES Usuario(id),
    CONSTRAINT fk_topico_curso_id FOREIGN KEY (curso_id) REFERENCES Curso(id)
);
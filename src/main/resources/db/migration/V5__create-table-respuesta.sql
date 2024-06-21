CREATE TABLE Respuesta (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    mensaje TEXT NOT NULL,
    topico_id INT,
    fechaCreacion DATETIME NOT NULL,
    autor_id INT,
    solucion BOOLEAN,
    CONSTRAINT fk_respuesta_topico_id FOREIGN KEY (topico_id) REFERENCES Topico(id),
    CONSTRAINT fk_respuesta_autor_id FOREIGN KEY (autor_id) REFERENCES Usuario(id)
);
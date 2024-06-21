CREATE TABLE Respuesta (
    id INT AUTO_INCREMENT PRIMARY KEY,
    mensaje TEXT NOT NULL,
    topico_id INT,
    fechaCreacion DATETIME NOT NULL,
    autor_id INT,
    solucion BOOLEAN,
    FOREIGN KEY (topico_id) REFERENCES Tópico(id),
    FOREIGN KEY (autor_id) REFERENCES Usuario(id)
);
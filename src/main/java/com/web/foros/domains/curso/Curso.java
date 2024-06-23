package com.web.foros.domains.curso;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "curso")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    public Curso (DataRegisterCurso data) {
        this.categoria = Categoria.valueOf(data.categoria());
        this.nombre = data.nombre();
    }

    public void update (DataUpdateCurso data) {
        if (data.nombre() != null) {
            this.nombre = data.nombre();
        }
        if (data.categoria() != null) {
            this.categoria = Categoria.valueOf(data.categoria());
        }
    }
}

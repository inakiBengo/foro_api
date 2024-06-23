package com.web.foros.domains.topico;

import com.web.foros.domains.curso.Curso;
import com.web.foros.domains.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Entity(name = "Topico")
@Table(name = "topico")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Enumerated(EnumType.STRING)
    private TopicoStatus status;
    private Integer respuestas;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id")
    private Usuario autor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id")
    private Curso curso;

    public Topico (String titulo, String mensaje, LocalDateTime fechaCreacion,
                   TopicoStatus status, Usuario usuario, Curso curso) {
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.fechaCreacion = fechaCreacion;
        this.status = status;
        this.respuestas = 0;
        this.autor = usuario;
        this.curso = curso;
    }

    public void update (DataTopicoUpdate data) {
        if (data.titulo() != null) {
            this.titulo = data.titulo();
        }
        if (data.mensaje() != null) {
            this.mensaje = data.mensaje();
        }
    }
}

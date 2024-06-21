package domains.topico;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "topico")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fechaCreacion;
    @Enumerated(EnumType.STRING)
    private TopicoStatus status;
    private Integer respuestas;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id")
    private Long autorId;

    private Long cursoId;
}

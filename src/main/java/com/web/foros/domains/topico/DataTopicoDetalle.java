package com.web.foros.domains.topico;

import java.time.LocalDateTime;

public record DataTopicoDetalle(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        TopicoStatus status,
        Integer respuestas,
        Long autor,
        Long curso
) {
    DataTopicoDetalle (Topico topico) {
        this(topico.getId(),
        topico.getTitulo(),
        topico.getMensaje(),
        topico.getFechaCreacion(),
        topico.getStatus(),
        topico.getRespuestas(),
        topico.getAutor().getId(),
        topico.getCurso().getId());
    }
}

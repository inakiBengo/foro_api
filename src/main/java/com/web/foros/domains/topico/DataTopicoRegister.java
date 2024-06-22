package com.web.foros.domains.topico;

import com.web.foros.domains.curso.Curso;
import com.web.foros.domains.usuario.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record DataTopicoRegister(
        @NotBlank
        @Size(min = 3, max = 255)
        String titulo,
        @NotBlank
        String mensaje,
        @NotNull
        Long autorId,
        @NotNull
        Long cursoId
) {
}

package com.web.foros.domains.curso;

import jakarta.validation.constraints.NotNull;

public record DataRegisterCurso(
        @NotNull
        String nombre,
        @NotNull
        String categoria
) {
}

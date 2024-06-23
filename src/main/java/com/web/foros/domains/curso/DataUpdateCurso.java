package com.web.foros.domains.curso;

import jakarta.validation.constraints.NotNull;

public record DataUpdateCurso(
        String nombre,
        String categoria
) {
}

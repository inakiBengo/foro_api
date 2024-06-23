package com.web.foros.domains.usuario;

import jakarta.validation.constraints.NotBlank;

public record DataUserDetalle(
        @NotBlank
        String nombre,
        @NotBlank
        String correoElectronico,
        @NotBlank
        String jwt,
        @NotBlank
        Boolean status
) {
}

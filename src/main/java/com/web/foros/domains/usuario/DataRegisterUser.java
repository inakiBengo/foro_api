package com.web.foros.domains.usuario;

import jakarta.validation.constraints.NotNull;

public record DataRegisterUser(
        @NotNull
        String nombre,
        @NotNull
        String correoElectronico,
        @NotNull
        String contrasena
) {
}

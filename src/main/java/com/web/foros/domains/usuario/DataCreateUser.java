package com.web.foros.domains.usuario;

import com.web.foros.domains.perfil.DataCreatePefil;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public record DataCreateUser(
        @NotBlank
        String nombre,
        @NotBlank
        String contrasena,
        @NotBlank
        String correoElectronico,
        @Valid
        DataCreatePefil perfilId
) {
}

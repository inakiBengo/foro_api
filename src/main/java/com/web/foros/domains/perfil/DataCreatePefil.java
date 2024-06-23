package com.web.foros.domains.perfil;

import jakarta.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public record DataCreatePefil (
    @Size(max=3)
    List<String> perfil
){
}

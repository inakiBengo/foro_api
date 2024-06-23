package com.web.foros.controllers;

import com.web.foros.domains.usuario.DataRegisterUser;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
@PreAuthorize("authenticated()")
public class ControllerUsuario {

    @PostMapping("/sign-up")
    @Transactional
    @PreAuthorize("permitAll()")
    public String createUser (@RequestBody @Valid DataRegisterUser data) {
        return "sign-up";
    }

    @PostMapping("/login")
    @Transactional
    @PreAuthorize("permitAll()")
    public String loginUser (@RequestBody @Valid DataRegisterUser data) {
        return "login";
    }

}

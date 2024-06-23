package com.web.foros.controllers;

import com.web.foros.domains.usuario.DataCreateUser;
import com.web.foros.domains.usuario.DataRegisterUser;
import com.web.foros.domains.usuario.DataUserDetalle;
import com.web.foros.infra.security.SecurityService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
@PreAuthorize("authenticated()")
public class ControllerUsuario {

    @Autowired
    private SecurityService securityService;

    @PostMapping("/login")
    @Transactional
    @PreAuthorize("permitAll()")
    public ResponseEntity<DataUserDetalle> loginUser (@RequestBody @Valid DataRegisterUser data) {
        return ResponseEntity.ok(securityService.loginUser(data));
    }

    @PostMapping("/sign-up")
    @Transactional
    @PreAuthorize("permitAll()")
    public ResponseEntity<DataUserDetalle> createUser (@RequestBody @Valid DataCreateUser data) {
        return ResponseEntity.ok(securityService.createUser(data));
    }

}

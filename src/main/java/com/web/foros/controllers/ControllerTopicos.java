package com.web.foros.controllers;

import com.web.foros.domains.topico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("/topicos")
@PreAuthorize("denyAll()")
public class ControllerTopicos {

    @Autowired
    private ServiceTopico serviceTopico;

    @PostMapping
    @Transactional
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_DEVELOPER')")
    public ResponseEntity<DataTopicoDetalle> postTopico
            (@RequestBody @Valid DataTopicoRegister data, UriComponentsBuilder uriBuilder)
    {
        Topico topico = serviceTopico.registrar(data);

        var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new DataTopicoDetalle(topico));
    }

    @GetMapping
    @PreAuthorize("permitAll()")
    public ResponseEntity<Page<DataTopicoDetalle>> getAllTopicos (@PageableDefault(size = 5) Pageable pagination)
    {
        return ResponseEntity.ok(serviceTopico.getAllTopicos(pagination));
    }

    @GetMapping("/{id}")
    @PreAuthorize("permitAll()")
    public ResponseEntity<DataTopicoDetalle> getTopico (@PathVariable Long id)
    {
        return ResponseEntity.ok(serviceTopico.getTopico(id));
    }

    @PutMapping("/{id}")
    @Transactional
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public ResponseEntity<DataTopicoDetalle> updateTopico
            (@PathVariable Long id, @RequestBody @Valid DataTopicoUpdate data)
    {
        return ResponseEntity.ok( serviceTopico.updateTopico(id,data));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public ResponseEntity deleteTopico (@PathVariable Long id)
    {
        serviceTopico.deleteTopico(id);

        return ResponseEntity.noContent().build();
    }
}

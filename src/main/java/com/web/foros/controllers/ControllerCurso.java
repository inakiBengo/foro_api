package com.web.foros.controllers;

import com.web.foros.domains.curso.*;
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
@RequestMapping("/cursos")
public class ControllerCurso {
    @Autowired
    private ServiceCurso serviceCurso;

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Transactional
    public ResponseEntity<DataCursoDetalle> createCurso
            (@RequestBody @Valid DataRegisterCurso data, UriComponentsBuilder uriBuilder)
    {
        Curso curso = serviceCurso.add(data);
        var uri = uriBuilder.path("/cursos/{id}").buildAndExpand(curso.getId()).toUri();

        return ResponseEntity.created(uri).body(new DataCursoDetalle(curso));
    }

    @GetMapping
    @PreAuthorize("permitAll()")
    public ResponseEntity<Page<DataCursoDetalle>> getAllCursos (@PageableDefault(size=5) Pageable pagination) {

        return ResponseEntity.ok(serviceCurso.getAll(pagination));
    }

    @GetMapping("/{id}")
    @PreAuthorize("permitAll()")
    public ResponseEntity<DataCursoDetalle> getCurso (@PathVariable Long id) {
        return ResponseEntity.ok(serviceCurso.getById(id));
    }

    @PutMapping("/{id}")
    @Transactional
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<DataCursoDetalle> updateCuros
            (@PathVariable Long id, @RequestBody @Valid DataUpdateCurso data)
    {
        return ResponseEntity.ok(serviceCurso.updateById(id, data));
    }

    @DeleteMapping("/{id}")
    @Transactional
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<DataCursoDetalle> deleteCurso (@PathVariable Long id)
    {
        serviceCurso.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

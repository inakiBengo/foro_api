package com.web.foros.controllers;

import com.web.foros.domains.topico.DataTopicoDetalle;
import com.web.foros.domains.topico.DataTopicoRegister;
import com.web.foros.domains.topico.ServiceTopico;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("/topicos")
public class ControllerTopicos {

    @Autowired
    private ServiceTopico serviceTopico;

    @PostMapping
    @Transactional
    public ResponseEntity<DataTopicoDetalle> postTopico
            (@RequestBody @Valid DataTopicoRegister data, UriComponentsBuilder uriBuilder)
    {
        DataTopicoDetalle dataTopicoDetalle = serviceTopico.registrar(data);

        var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(1).toUri();
        return ResponseEntity.created(uri).body(dataTopicoDetalle);
    }

    @GetMapping
    public ResponseEntity<Page<DataTopicoDetalle>> getAllTopicos (@PageableDefault(size = 5) Pageable pagination)
    {
        return ResponseEntity.ok(serviceTopico.getAllTopicos(pagination));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataTopicoDetalle> getTopico (@PathVariable Long id)
    {
        return ResponseEntity.ok(serviceTopico.getTopico(id));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DataTopicoDetalle> updateTopico
            (@PathVariable Long id, @RequestBody @Valid DataTopicoRegister data)
    {
        System.out.println(id);
        System.out.println(data);
        return ResponseEntity.ok( serviceTopico.updateTopico(id,data));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTopico (@PathVariable Long id)
    {
        serviceTopico.deleteTopico(id);

        return ResponseEntity.noContent().build();
    }
}

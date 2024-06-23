package com.web.foros.domains.topico;

import com.web.foros.domains.curso.RepositoryCurso;
import com.web.foros.domains.usuario.RepositoryUsuario;
import com.web.foros.infra.errors.IntegrityValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ServiceTopico {
    @Autowired
    private RepositoryTopico repositoryTopico;
    @Autowired
    private RepositoryUsuario repositoryUsuario;
    @Autowired
    private RepositoryCurso repositoryCurso;

    public Topico registrar (DataTopicoRegister data) {
        var TopicoExists = repositoryTopico.existTopico(data.titulo(), data.mensaje());
        if (TopicoExists != null) {
            throw new IntegrityValidation("Este tópico ya existe y su id es: "+TopicoExists);
        }

        var usuario = repositoryUsuario.findById(data.autorId())
                .orElseThrow(() -> new IntegrityValidation("Este usuario no fue encontrado"));;

        var curso = repositoryCurso.findById(data.cursoId())
                .orElseThrow(() -> new IntegrityValidation("Este curso no fue encontrado"));

        var fechaDeCreacion = LocalDateTime.now();
        var status = TopicoStatus.NO_RESPONDIDO;

        var topico = new Topico(data.titulo(), data.mensaje(), fechaDeCreacion, status, usuario, curso);

        repositoryTopico.save(topico);
        return topico;
    }

    public Page<DataTopicoDetalle> getAllTopicos (Pageable pagination) {
        return repositoryTopico.findAllOrderByFechaCreacion(pagination).map(DataTopicoDetalle::new);
    }

    public DataTopicoDetalle getTopico (Long id) {
        var topico = repositoryTopico.findById(id)
                .orElseThrow(() -> new IntegrityValidation("No se a encontrado el topico con id: "+id));

        return new DataTopicoDetalle(topico);
    }

    public DataTopicoDetalle updateTopico (Long id,DataTopicoUpdate data) {
        Topico topico = repositoryTopico.findById(id)
                .orElseThrow(() -> new IntegrityValidation("No se encontro el topico solicitado"));
        System.out.println(topico);
        topico.update(data);

        return new DataTopicoDetalle(topico);
    }

    public void deleteTopico (Long id) {
        repositoryTopico.findById(id)
                .orElseThrow(()->new IntegrityValidation("No se encontro el topico a eliminar"));

        repositoryTopico.deleteById(id);
    }
}

package com.web.foros.domains.curso;

import com.web.foros.domains.topico.RepositoryTopico;
import com.web.foros.infra.errors.IntegrityValidation;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ServiceCurso {

    @Autowired
    private RepositoryCurso repositoryCurso;
    @Autowired
    private RepositoryTopico repositoryTopico;

    public Curso add (DataRegisterCurso data) {
        var existCurso = repositoryCurso.existsByNombre(data.nombre());
        if (existCurso) {
            throw new IntegrityValidation("Este curso ya existe");
        }

        var curso = new Curso(data);
        repositoryCurso.save(curso);

        return curso;
    }

    public Page<DataCursoDetalle> getAll (Pageable pagination) {
        return repositoryCurso.getAllCursos(pagination).map(DataCursoDetalle::new);
    }

    public DataCursoDetalle getById (Long id) {
        var curso = repositoryCurso.findById(id)
                .orElseThrow(() -> new IntegrityValidation("No se encontro un curso con el id: "+id));

        return new DataCursoDetalle(curso);
    }

    public DataCursoDetalle updateById (Long id, DataUpdateCurso data) {
        Curso curso = repositoryCurso.findById(id)
                .orElseThrow(() -> new IntegrityValidation("No se enontro un curso con el id: "+id));

        curso.update(data);

        return new DataCursoDetalle(curso);
    }

    public void deleteById (Long id) {
        var existsCurso = repositoryCurso.findById(id)
                .orElseThrow(() -> new IntegrityValidation("El curso con id "+id+" no existe"));

        repositoryTopico.deleteTopicoByCursoId(id);
        repositoryCurso.deleteById(id);
    }
}

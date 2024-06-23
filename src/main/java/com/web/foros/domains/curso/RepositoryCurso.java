package com.web.foros.domains.curso;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryCurso extends JpaRepository<Curso, Long> {
     Boolean existsByNombre(String nombre);

     @Query("SELECT c FROM Curso c ORDER BY c.nombre ASC")
     Page<Curso> getAllCursos(Pageable pagination);

}

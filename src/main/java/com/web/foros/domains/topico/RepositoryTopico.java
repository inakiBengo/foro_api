package com.web.foros.domains.topico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RepositoryTopico extends JpaRepository<Topico, Long> {
    @Query("SELECT t.id FROM Topico t WHERE t.titulo=:titulo OR t.mensaje=:mensaje")
    Long existTopico(String titulo, String mensaje);

    @Query("SELECT t FROM Topico t ORDER BY t.fechaCreacion ASC")
    Page<Topico> findAllOrderByFechaCreacion(Pageable pagination);
}

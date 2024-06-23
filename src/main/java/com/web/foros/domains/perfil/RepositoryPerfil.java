package com.web.foros.domains.perfil;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositoryPerfil extends JpaRepository<Perfil,Long> {
    List<Perfil> findPerfilByNombreIn(List<String> nombres);
}

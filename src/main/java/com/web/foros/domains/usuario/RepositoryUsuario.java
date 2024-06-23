package com.web.foros.domains.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface RepositoryUsuario extends JpaRepository<Usuario, Long> {

    UserDetails findUsuarioByNombre(String nombre);
}

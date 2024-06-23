package com.web.foros.infra.security;

import com.web.foros.domains.perfil.Perfil;
import com.web.foros.domains.perfil.RepositoryPerfil;
import com.web.foros.domains.usuario.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SecurityService implements UserDetailsService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JWTUtils jwtUtils;
    @Autowired
    private RepositoryUsuario repositoryUsuario;
    @Autowired
    private RepositoryPerfil repositoryPerfil;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repositoryUsuario.findUsuarioByNombre(username);
    }

    public DataUserDetalle loginUser (DataRegisterUser data) {
        String nombre = data.nombre();
        String mail = data.correoElectronico();
        String contrasena = data.contrasena();

        Authentication authentication = this.authenticate(nombre,contrasena);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String accessToken = jwtUtils.createToken(authentication);

        return new DataUserDetalle(nombre,mail,accessToken,true);
    }

    private Authentication authenticate (String nombre, String contrasena) {
        UserDetails userDetails = this.loadUserByUsername(nombre);

        if (userDetails == null ){
            throw new BadCredentialsException("Nombre o Contraseña invalidos");
        }

        if (!passwordEncoder.matches(contrasena, userDetails.getPassword())) {
            throw new BadCredentialsException("Nombre o Contraseña invalidos");
        }

        return new UsernamePasswordAuthenticationToken(nombre, userDetails.getPassword(), userDetails.getAuthorities());
    }

    public DataUserDetalle createUser (DataCreateUser data) {
        String nombre = data.nombre();
        String contrasena = data.contrasena();
        String correoElectronico = data.correoElectronico();
        List<String> perfilRequest = data.perfilId().perfil();

        Set<Perfil> perfilSet = repositoryPerfil.findPerfilByNombreIn(perfilRequest).stream().collect(Collectors.toSet());
        if (perfilSet.isEmpty()) {
            throw new IllegalArgumentException("Los roles especificados no existen");
        }

        Usuario usuario = Usuario.builder()
                .nombre(nombre)
                .contrasena(passwordEncoder.encode(contrasena))
                .perfilId(perfilSet)
                .correoElectronico(correoElectronico)
                .build();

        Usuario createdUsuario = repositoryUsuario.save(usuario);

        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();
        createdUsuario.getPerfilId().forEach(p -> authorityList.add(
                new SimpleGrantedAuthority("ROLE_".concat(p.getNombre().name()))));

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                createdUsuario.getUsername(),createdUsuario.getPassword(),authorityList);

        String accesToken = jwtUtils.createToken(authentication);

        return new DataUserDetalle(createdUsuario.getUsername(),createdUsuario.getCorreoElectronico(),accesToken,true);
    }
}

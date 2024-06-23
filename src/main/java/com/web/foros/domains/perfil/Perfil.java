package com.web.foros.domains.perfil;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "perfil")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@EqualsAndHashCode(of = "id")
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private PerfilNames nombre;
}

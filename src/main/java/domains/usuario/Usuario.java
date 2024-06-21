package domains.usuario;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String correoElectronico;
    private String contrasena;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Perfil perfil_id;
}

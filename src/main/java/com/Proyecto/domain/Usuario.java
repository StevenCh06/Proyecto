package com.Proyecto.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;
    
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
    @NotEmpty
    private String nombre;
    @NotEmpty
    private String priApellido;
    private String segApellido;
    private String direccion;
    private String correo;
    private String presentacion;
    private String fotoPerfil;
    private boolean activo;

    @OneToMany
    @JoinColumn(name = "id_usuario", insertable = false, updatable = false)
    List<Reserva> reservas;
    
    @OneToMany
    @JoinColumn(name = "id_usuario", insertable = false, updatable = false)
    List<Resena> resenas;
    
    @OneToMany
    @JoinColumn(name = "id_usuario")
    List<Rol> roles;    
}

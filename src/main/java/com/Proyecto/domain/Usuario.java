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
    private String nombre;
    private String priApellido;
    private String segApellido;
    private String nomUsuario;
    private String direccion;
    private String correo;
    private String contrasena;
    private String presentacion;
    private String fotoPerfil;
    private boolean activo;

    @OneToMany
    @JoinColumn(name = "id_usuario", insertable = false, updatable = false)
    List<Reserva> reservas;
    
    @OneToMany
    @JoinColumn(name = "id_usuario", insertable = false, updatable = false)
    List<Resena> resenas;
    
    public Usuario() {
    }

    public Usuario(String nombre, String priApellido, String segApellido, String nomUsuario, String direccion, String correo, String contrasena, String presentacion, String fotoPerfil, boolean activo) {
        this.nombre = nombre;
        this.priApellido = priApellido;
        this.segApellido = segApellido;
        this.nomUsuario = nomUsuario;
        this.direccion = direccion;
        this.correo = correo;
        this.contrasena = contrasena;
        this.presentacion = presentacion;
        this.fotoPerfil = fotoPerfil;
        this.activo = activo;
    }
    
   

}

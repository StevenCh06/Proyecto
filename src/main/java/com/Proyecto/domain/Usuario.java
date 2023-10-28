package com.Proyecto.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
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
    private String fotoPersil;
    private boolean activo;

    public Usuario() {
    }

    public Usuario(String nombre, String priApellido, String segApellido, String nomUsuario, String direccion, String correo, String contrasena, String presentacion, String fotoPersil, boolean activo) {
        this.nombre = nombre;
        this.priApellido = priApellido;
        this.segApellido = segApellido;
        this.nomUsuario = nomUsuario;
        this.direccion = direccion;
        this.correo = correo;
        this.contrasena = contrasena;
        this.presentacion = presentacion;
        this.fotoPersil = fotoPersil;
        this.activo = activo;
    }
    
   

}

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
@Table(name = "restbar")
public class RestBar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_local")
    private Long idLocal;
    private String nombre;
    private String ubicacion;
    private Long telefono;
    private String horario;
    private String correo;
    private String foto;
    private String tipo;
    private String precio;
    private String informacion;
    private String recomendaciones;
    
    public RestBar() {
    }

    public RestBar(String nombre, String ubicacion, Long telefono, String horario, String correo, String foto, String tipo, String precio, String informacion, String recomendaciones) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.telefono = telefono;
        this.horario = horario;
        this.correo = correo;
        this.foto = foto;
        this.tipo = tipo;
        this.precio = precio;
        this.informacion = informacion;
        this.recomendaciones = recomendaciones;
    }

    
    
    
}


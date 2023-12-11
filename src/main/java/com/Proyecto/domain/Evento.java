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
@Table(name = "evento")
public class Evento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_evento")
    private Long idEvento;
    private String tituloEvento;
    private String artista;
    private String ubicacion;
    private String hora;
    private double precioEntrada;
    private String foto;
    private String descripcion;
    private String restriccion;

    public Evento() {
        
    }

    public Evento(String tituloEvento, String artista, String ubicacion, String hora, double precioEntrada, String foto, String descripcion, String restriccion) {
        this.tituloEvento = tituloEvento;
        this.artista = artista;
        this.ubicacion = ubicacion;
        this.hora = hora;
        this.precioEntrada = precioEntrada;
        this.foto = foto;
        this.descripcion = descripcion;
        this.restriccion = restriccion;
    }
    
}

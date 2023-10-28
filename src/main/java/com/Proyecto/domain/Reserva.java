package com.Proyecto.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
@Entity
@Table(name = "reserva")
public class Reserva implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva")
    private Long idReserva;
    private int cantidad;
    private Date fecha;
    private String hora;
    private String ocasion;
    private String descripcion;
    private double precio;
    private boolean activo;
    
    public Reserva() {
    }

    public Reserva(int cantidad, Date fecha, String hora, String ocasion, String descripcion, double precio, boolean activo) {
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.hora = hora;
        this.ocasion = ocasion;
        this.descripcion = descripcion;
        this.precio = precio;
        this.activo = activo;
    }
    
    

}

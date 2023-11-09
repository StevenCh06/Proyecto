package com.Proyecto.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Entity
@Table(name = "reserva")
public class Reserva implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva")
    private Long idReserva;
    private String lugar;
    private int cantidad;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha;
    private String hora;
    private String ocasion;
    private String descripcion;
    private boolean activo;
    
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    
    public Reserva() {
    }

    public Reserva(String lugar, int cantidad, Date fecha, String hora, String ocasion, String descripcion, boolean activo) {
        this.lugar = lugar;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.hora = hora;
        this.ocasion = ocasion;
        this.descripcion = descripcion;
        this.activo = activo;
    }
    
    

}

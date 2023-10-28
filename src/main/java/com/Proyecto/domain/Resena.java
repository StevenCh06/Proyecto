
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
@Table(name = "resena")
public class Resena implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resena")
    private Long idResena;
    private Long idLocal;
    private String nombreCliente;
    private int calificacion;
    private String comentario;
    
    public Resena (){
        
    }

    public Resena(Long idLocal, String nombreCliente, int calificacion, String comentario) {
        this.idLocal = idLocal;
        this.nombreCliente = nombreCliente;
        this.calificacion = calificacion;
        this.comentario = comentario;
    }
    
    
    
    
}

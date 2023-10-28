
package com.Proyecto.dao;

import com.Proyecto.domain.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ReservaDao  extends JpaRepository<Reserva,Long> {
    
}

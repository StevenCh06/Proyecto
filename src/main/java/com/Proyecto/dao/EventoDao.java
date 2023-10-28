
package com.Proyecto.dao;

import com.Proyecto.domain.Evento;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EventoDao  extends JpaRepository<Evento,Long> {
    
}

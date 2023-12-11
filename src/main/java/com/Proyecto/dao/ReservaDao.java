
package com.Proyecto.dao;

import com.Proyecto.domain.Reserva;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ReservaDao  extends JpaRepository<Reserva,Long> {
    
    @Query("SELECT r FROM Reserva r WHERE r.usuario.idUsuario = :idUsuario")
    List<Reserva> findByUsuario(@Param("idUsuario") Long idUsuario);
}

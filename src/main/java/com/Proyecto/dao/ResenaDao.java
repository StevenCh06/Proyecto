
package com.Proyecto.dao;

import com.Proyecto.domain.Resena;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ResenaDao extends JpaRepository<Resena, Long> {

    @Query("SELECT r FROM Resena r JOIN FETCH r.usuario u WHERE r.restBar.idLocal = :idLocal")
    List<Resena> findByRestBar(@Param("idLocal") Long idLocal);
    
    @Query("SELECT r FROM Resena r JOIN FETCH r.usuario u WHERE r.usuario.idUsuario = :idUsuario")
    List<Resena> findByUsuario(@Param("idUsuario") Long idUsuario);
  



}

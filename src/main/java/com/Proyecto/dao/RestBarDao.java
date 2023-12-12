
package com.Proyecto.dao;

import com.Proyecto.domain.RestBar;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RestBarDao  extends JpaRepository<RestBar,Long>{
    
    List<RestBar> findByTipo(String tipo);
}

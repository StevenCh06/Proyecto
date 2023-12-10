
package com.Proyecto.dao;

import com.Proyecto.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDao  extends JpaRepository<Usuario,Long> {
    
    Usuario findByUsername(String username);
    
     //Asi busacamos el usuario de distintas formas

    Usuario findByUsernameAndPassword(String username, String Password);

    Usuario findByUsernameOrCorreo(String username, String correo);

    boolean existsByUsernameOrCorreo(String username, String correo);
    
}
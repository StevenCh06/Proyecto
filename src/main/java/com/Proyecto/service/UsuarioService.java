
package com.Proyecto.service;

import com.Proyecto.domain.Usuario;
import java.util.List;


public interface UsuarioService {
    
    public List<Usuario> getUsuarioes(boolean activos);
    
    public List<Usuario> getUsuarioesInactivos(boolean inactivos);
 
    public Usuario getUsuario(Usuario usuario);
    
    public void save(Usuario usuario);
    
    public void delete(Usuario usuario);
}

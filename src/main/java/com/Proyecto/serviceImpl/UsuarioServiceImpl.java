
package com.Proyecto.serviceImpl;

import com.Proyecto.dao.UsuarioDao;
import com.Proyecto.domain.Rol;
import com.Proyecto.domain.Usuario;
import com.Proyecto.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("UserDetailsService")
public class UsuarioServiceImpl implements UsuarioService, UserDetailsService {
    
    @Autowired
    private UsuarioDao usuarioDao;
    
    @Autowired
    private HttpSession session; 
    
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Buscar el usuario por el username en la base de datos
        Usuario usuario = usuarioDao.findByUsername(username);
        
        // si no existe el usuario lanza una excepcion
        if(usuario == null){
            throw new UsernameNotFoundException(username);
        }
        
        // si llego hasta aqui es porque el usuario existe en la base de datos
        // remover atributos de la sesion
        session.removeAttribute("usuarioImagen");
        session.setAttribute("usuarioImagen", usuario.getFotoPerfil()); 
        session.setAttribute("idU", usuario.getIdUsuario());
        
        // transformar roles a GrantedAuthority
        var roles = new ArrayList<GrantedAuthority>();
        for(Rol item : usuario.getRoles()){
            roles.add(new SimpleGrantedAuthority(item.getNombre()));
        }
        
        // se retorna el User (Clase UserDetails)
        return new User(usuario.getNombre(), usuario.getPassword(), roles);
    }

    @Override
    public Usuario getUsuarioPorUsername(String username) {
        
        return usuarioDao.findByUsername(username);
    }
    
}


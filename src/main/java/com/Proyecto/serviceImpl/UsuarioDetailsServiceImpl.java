package com.Proyecto.serviceImpl;

import com.Proyecto.dao.UsuarioDao;
import com.Proyecto.domain.Rol;
import com.Proyecto.domain.Usuario;
import com.Proyecto.service.UsuarioDetailsService;
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
public class UsuarioDetailsServiceImpl implements UsuarioDetailsService, UserDetailsService {

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private HttpSession session; 

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioDao.findByUsername(username);

        if(usuario == null){
            throw new UsernameNotFoundException(username);
        }

        session.removeAttribute("id_usuario");
        session.setAttribute("id_usuario", usuario.getIdUsuario());
        session.setAttribute("idU", usuario.getIdUsuario());

        var roles = new ArrayList<GrantedAuthority>();
        for(Rol item : usuario.getRoles()){
            roles.add(new SimpleGrantedAuthority(item.getNombre()));
        }

        return new User(usuario.getNombre(), usuario.getPassword(), roles);
    }

    @Override
    public Usuario getUsuarioPorUsername(String username) {

        return usuarioDao.findByUsername(username);
    }

}
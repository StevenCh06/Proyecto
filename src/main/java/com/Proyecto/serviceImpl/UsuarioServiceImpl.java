
package com.Proyecto.serviceImpl;

import com.Proyecto.dao.UsuarioDao;
import com.Proyecto.domain.Usuario;
import com.Proyecto.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioDao usuarioDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Usuario> getUsuarioes(boolean activos) {
        List<Usuario> usuarioes = usuarioDao.findAll();

        if (activos) {
            usuarioes.removeIf(c -> !c.isActivo());
        }

        return usuarioes;
    }
    
    @Override
    public List<Usuario> getUsuarioesInactivos(boolean inactivos) {
        List<Usuario> usuarioes = usuarioDao.findAll();
        if (inactivos) {
            usuarioes.removeIf(c -> c.isActivo());
        }
        return usuarioes;
    }

    @Override
    public Usuario getUsuario(Usuario usuario) {
       return usuarioDao.findById(usuario.getIdUsuario()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Usuario usuario) {
        usuarioDao.save(usuario);
    }

    @Override
    @Transactional
    public void delete(Usuario usuario) {
        usuarioDao.delete(usuario);
    }


}


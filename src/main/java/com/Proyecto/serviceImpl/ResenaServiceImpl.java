
package com.Proyecto.serviceImpl;

import com.Proyecto.dao.ResenaDao;
import com.Proyecto.domain.Resena;
import com.Proyecto.domain.RestBar;
import com.Proyecto.service.ResenaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import jakarta.servlet.http.HttpSession;

@Service
public class ResenaServiceImpl implements ResenaService {
    @Autowired
    private ResenaDao resenaDao;
    
    @Autowired
    private HttpSession session;
    
    @Override
    @Transactional(readOnly = true)
    public List<Resena> getResenas() {
        List<Resena> resenas = resenaDao.findAll();
        
        return resenas;
    }
    
    @Override
    public Resena getResena(Resena resena) {
       return resenaDao.findById(resena.getIdResena()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Resena resena) {
        resenaDao.save(resena);
    }

    @Override
    @Transactional
    public void delete(Resena resena) {
        resenaDao.delete(resena);
    }
    
    @Override
    public List<Resena> getResenasByRestBar(RestBar restbar) {
        return resenaDao.findByRestBar(restbar.getIdLocal());
    }

    @Override
    public List<Resena> getResenaByUsuario() {
        Long userId = (Long) session.getAttribute("idU");
        return resenaDao.findByUsuario(userId);
    }

    
}



package com.Proyecto.serviceImpl;

import com.Proyecto.dao.ResenaDao;
import com.Proyecto.domain.Resena;
import com.Proyecto.service.ResenaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ResenaServiceImpl implements ResenaService {
    @Autowired
    private ResenaDao resenaDao;
    
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
    
}


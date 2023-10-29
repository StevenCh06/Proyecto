
package com.Proyecto.serviceImpl;

import com.Proyecto.dao.ResenaDao;
import com.Proyecto.domain.Resena;
import com.Proyecto.service.ResenaService;
import com.Proyecto.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ResenaServiceImpl implements ResenaService {
    @Autowired
    private ResenaDao resenaDao;
    
    @Override
    public Resena getResena(Resena resena) {
       return resenaDao.findById(resena.getIdLocal()).orElse(null);
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


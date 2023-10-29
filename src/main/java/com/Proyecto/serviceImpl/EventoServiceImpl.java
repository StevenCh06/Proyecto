
package com.Proyecto.serviceImpl;

import com.Proyecto.dao.EventoDao;
import com.Proyecto.domain.Evento;
import com.Proyecto.service.EventoService;
import com.Proyecto.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EventoServiceImpl implements EventoService{
  @Autowired
    private EventoDao eventoDao;
    
    @Override
    public Evento getEvento(Evento evento) {
       return eventoDao.findById(evento.getIdEvento()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Evento evento) {
        eventoDao.save(evento);
    }

    @Override
    @Transactional
    public void delete(Evento evento) {
        eventoDao.delete(evento);
    }
}

package com.Proyecto.service;

import com.Proyecto.domain.Evento;
import java.util.List;

public interface EventoService {
 
    public List<Evento> getEventos();
    
    public Evento getEvento(Evento evento);
    
    public void save(Evento evento);
    
    public void delete(Evento evento);
}

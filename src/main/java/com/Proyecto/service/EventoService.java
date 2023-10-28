
package com.Proyecto.service;

import com.Proyecto.domain.Evento;
import java.util.List;


public interface EventoService {
 
    public Evento getEvento(Evento arbol);
    
    public void save(Evento arbol);
    
    public void delete(Evento arbol);
}

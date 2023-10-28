
package com.Proyecto.service;

import com.Proyecto.domain.Resena;
import java.util.List;


public interface ResenaService {
   
    public Resena getResena(Resena arbol);
    
    public void save(Resena arbol);
    
    public void delete(Resena arbol);
}

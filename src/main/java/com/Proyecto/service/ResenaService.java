
package com.Proyecto.service;

import com.Proyecto.domain.Resena;
import java.util.List;


public interface ResenaService {
   
    public List<Resena> getResenas();    
    
    public Resena getResena(Resena resena);
    
    public void save(Resena resena);
    
    public void delete(Resena resena);
    

}

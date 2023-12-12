
package com.Proyecto.service;

import com.Proyecto.domain.RestBar;
import java.util.List;


public interface RestBarService {
   
    public List<RestBar> getRestBar();
    
    public RestBar getRestBar(RestBar rest);
    
    public void save(RestBar rest);
    
    public void delete(RestBar rest);
    
    public List<RestBar> obtenerLocalesFiltrados(String tipos);
}

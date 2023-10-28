
package com.Proyecto.service;

import com.Proyecto.domain.RestBar;
import java.util.List;


public interface RestBarService {
   
    public RestBar getRestBar(RestBar arbol);
    
    public void save(RestBar arbol);
    
    public void delete(RestBar arbol);
}

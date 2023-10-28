
package com.Proyecto.service;

import com.Proyecto.domain.Reserva;
import java.util.List;


public interface ReservaService {
    public List<Reserva> getReservaes(boolean activos);
    
    public List<Reserva> getReservaesInactivos(boolean inactivos);
 
    public Reserva getReserva(Reserva arbol);
    
    public void save(Reserva arbol);
    
    public void delete(Reserva arbol);
}

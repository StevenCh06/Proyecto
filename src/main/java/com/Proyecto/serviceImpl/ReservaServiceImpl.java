
package com.Proyecto.serviceImpl;

import com.Proyecto.dao.ReservaDao;
import com.Proyecto.domain.Reserva;
import com.Proyecto.service.ReservaService;
import com.Proyecto.service.ReservaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReservaServiceImpl implements ReservaService {
    @Autowired
    private ReservaDao reservaDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Reserva> getReservaes(boolean activos) {
        List<Reserva> reservaes = reservaDao.findAll();

        if (activos) {
            reservaes.removeIf(c -> !c.isActivo());
        }

        return reservaes;
    }
    
    @Override
    public List<Reserva> getReservaesInactivos(boolean inactivos) {
        List<Reserva> reservaes = reservaDao.findAll();
        if (inactivos) {
            reservaes.removeIf(c -> c.isActivo());
        }
        return reservaes;
    }

    @Override
    public Reserva getReserva(Reserva reserva) {
       return reservaDao.findById(reserva.getIdReserva()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Reserva reserva) {
        reservaDao.save(reserva);
    }

    @Override
    @Transactional
    public void delete(Reserva reserva) {
        reservaDao.delete(reserva);
    }
}

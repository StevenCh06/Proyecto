
package com.Proyecto.serviceImpl;

import com.Proyecto.dao.ReservaDao;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Proyecto.domain.Reserva;
import com.Proyecto.domain.Usuario;
import com.Proyecto.service.ReservaService;
import com.Proyecto.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

@Service
public class ReservaServiceImpl implements ReservaService {
    @Autowired
    private ReservaDao reservaDao;
    
    @Autowired
    private UsuarioServiceImpl usuarioService;
    
    @Autowired
    private HttpSession session;
    @Override
    @Transactional(readOnly = true)
    public List<Reserva> getReservas() {
        List<Reserva> resenas = reservaDao.findAll();
        
        return resenas;
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
    
    @Override
    public List<Reserva> getReservaByUsuario() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Obtener el ID del usuario desde la sesión para poder identificar a quien pertenecen las reservas
        Long userId = (Long) session.getAttribute("idU");

        return reservaDao.findByUsuario(userId);
    }
    
    
}

package com.Proyecto.controller;

import com.Proyecto.domain.Reserva;
import com.Proyecto.domain.RestBar;
import com.Proyecto.domain.Usuario;
import com.Proyecto.service.ReservaService;
import com.Proyecto.service.RestBarService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ReservaController {
    
    @Autowired
    private ReservaService reservaService;
    
    @Autowired
    private RestBarService restbarService;
    
    @GetMapping("/reservar/{idLocal}")
    public String resenaCargar(Reserva reserva,RestBar restbar, Model model) {                          
        
        restbar = restbarService.getRestBar(restbar);          
        
        model.addAttribute("restbar", restbar);
        
        return "/reserva/reserva";
    }
    
    @PostMapping("/reservar")
    public String reservaGuardar(Reserva reserva, RestBar restBar,Usuario usuario, Model model) {
                     
        reserva.setIdReserva(Long.MIN_VALUE);
        reserva.setUsuario(usuario);
                
        reservaService.save(reserva);
        
        return "redirect:/";
    }
    
    @GetMapping("/reservas")
    public String reservaHistorial(Usuario usuario, Model model) {
        // Obtener las reservas del usuario autenticado
        List<Reserva> reservas = reservaService.getReservaByUsuario();
        
        model.addAttribute("reservas", reservas);
        
        return "/reserva/historialReservas";
    }
    
    @GetMapping("/reservas/eliminar/{idReserva}")
    public String reservaEliminar(Reserva reserva) {
        reservaService.delete(reserva);
        return "redirect:/reservas";
    }
}
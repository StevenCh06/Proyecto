package com.Proyecto.controller;

import com.Proyecto.domain.Resena;
import com.Proyecto.domain.RestBar;
import com.Proyecto.domain.Usuario;
import com.Proyecto.service.ResenaService;
import com.Proyecto.service.RestBarService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ResenaController {
    
    @Autowired
    private ResenaService resenaService;
    
    @Autowired
    private RestBarService restbarService; 
     
    
    @PostMapping("/enviar")
    public String resenaGuardar(Resena resena, RestBar restBar,Usuario usuario,Model model) {
                     
        resena.setRestBar(restBar);
        resena.setUsuario(usuario);
        resenaService.save(resena);
        
        return "redirect:/";
    }
    
    @GetMapping("/resenar/{idLocal}")
    public String resenaCargar(Resena resena,RestBar restbar, Model model) {                          
        
        restbar = restbarService.getRestBar(restbar);          
        
        model.addAttribute("restbar", restbar);
        
        return "/resena/resena";
    }
    
    @GetMapping("/resenas")
    public String resenas(RestBar restbar, Model model) {
        
        // Obtener las reservas del usuario autenticado
        List<Resena> resena = resenaService.getResenaByUsuario();
        
        model.addAttribute("resenas", resena);
        model.addAttribute("totalResenas", resena.size());
        
        return "/resenas/historialResenas";
    }
    
    @GetMapping("/resenas/eliminar/{idResena}")
    public String reservaEliminar(Resena resena) {
        resenaService.delete(resena);
        return "redirect:/resenas";
    }
}
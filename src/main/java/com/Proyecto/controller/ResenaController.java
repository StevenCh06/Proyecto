package com.Proyecto.controller;

import com.Proyecto.domain.Resena;
import com.Proyecto.domain.RestBar;
import com.Proyecto.domain.Usuario;
import com.Proyecto.service.ResenaService;
import com.Proyecto.service.RestBarService;
import com.Proyecto.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
    
    @Autowired
    private UsuarioService usuarioService;    
    
    @GetMapping("/resenar/{idLocal}")
    public String resenaCargar(Resena resena,RestBar restbar, Model model) {                          
        
        restbar = restbarService.getRestBar(restbar);          
        
        model.addAttribute("restbar", restbar);
        
        return "/resena/resena";
    }
    
    @PostMapping("/enviar")
    public String resenaGuardar(Resena resena, RestBar restBar,Usuario usuario,Model model) {
                     
        resena.setRestBar(restBar);
        resena.setUsuario(usuario);
        resenaService.save(resena);
        
        return "redirect:/";
    }
    
    @GetMapping("/resenas")
    public String resenas(RestBar Restbar, Model model) {


        // Obtener el usuario autenticado
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        
        // Obtener las resenas del local
        List<Resena> resena = resenaService.getResenasByRestBar(Restbar);
        
        model.addAttribute("resenas", resena);
        
        return "/resenas/resena";
    }
    
}
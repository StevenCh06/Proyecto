package com.Proyecto.controller;

import com.Proyecto.domain.Resena;
import com.Proyecto.domain.RestBar;
import com.Proyecto.domain.Usuario;
import com.Proyecto.service.ResenaService;
import com.Proyecto.service.RestBarService;
import com.Proyecto.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ResenaController {
    
    @Autowired
    private ResenaService resenaService;
    
    @Autowired
    private RestBarService restbarService;
    
    @Autowired
    private UsuarioService usuarioService;    
    
    @PostMapping("/enviar")
    public String resenaGuardar(Resena resena, RestBar restBar,Usuario usuario,Model model) {
                     
        resena.setRestBar(restBar);
        resena.setUsuario(usuario);
        resenaService.save(resena);
        
        return "redirect:/";
    }
}
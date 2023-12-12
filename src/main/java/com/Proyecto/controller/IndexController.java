package com.Proyecto.controller;

import com.Proyecto.service.RestBarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {
    
    @RequestMapping("/")
    public String page(Model model) {
        model.addAttribute("attribute", "value");
        return "index";
    }
    
     @GetMapping("/transporte")
    public String transporte(Model model) {
        model.addAttribute("attribute", "value");
        return "/transporte/transporte";
    }
    
    @GetMapping("/centroAyuda")
    public String centroAyuda(Model model) {
        model.addAttribute("attribute", "value");
        return "/centroAyuda/centroAyuda";
    }

}

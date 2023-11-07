
package com.Proyecto.controller;


import com.Proyecto.service.RestBarService;
import com.Proyecto.domain.RestBar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RestBarController {
    
    @Autowired
    private RestBarService restbarService;     
    
    @GetMapping("/login")
    public String inicio(Model model) {
        List<RestBar> listado = restbarService.getRestBar();

        model.addAttribute("restbares", listado);

        return "index";
    }
    
    @GetMapping("locales/detalle/{idLocal}")
    public String restbarDetalle(RestBar restbar, Model model) {
        restbar = restbarService.getRestBar(restbar);
        model.addAttribute("restbar", restbar);
        return "/locales/detalle";
    }
}

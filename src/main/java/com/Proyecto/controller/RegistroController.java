
package com.Proyecto.controller;

import com.Proyecto.domain.Usuario;
import com.Proyecto.service.FirebaseStorageService;
import com.Proyecto.service.RegistroService;
import com.Proyecto.service.UsuarioService;
import jakarta.mail.MessagingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@Slf4j
@RequestMapping("/registro")
public class RegistroController {
    
    @Autowired
    private RegistroService registroService;
    
    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private FirebaseStorageService firebaseStorageService;

    @GetMapping("/nuevo")
    public String nuevo(Model model, Usuario usuario) {
        return "/registro/nuevo";
    }

    @GetMapping("/recordar")
    public String recordar(Model model, Usuario usuario) {
        return "/registro/recordar";
    }

    @PostMapping("/crearUsuario")
    public String crearUsuario(Model model, Usuario usuario) 
            throws MessagingException {
        model = registroService.crearUsuario(model, usuario);
        return "/registro/salida";
    }

    @GetMapping("/activacion/{usuario}/{id}")
    public String activar(Model model, 
            @PathVariable(value = "usuario") String usuario, 
            @PathVariable(value = "id") String id) {
        model = registroService.activar(model, usuario, id);
        if (model.containsAttribute("usuario")) {
            return "/registro/activa";
        } else {
            return "/registro/salida";
        }
    }

    @PostMapping("/activar")
    public String activar(Usuario usuario, @RequestParam("imagenFile") MultipartFile imagenFile) {
        // Primero activa el usuario
        usuario.setActivo(true);

        // Guarda el usuario para obtener su ID
        registroService.activar(usuario, imagenFile);

        // Obtiene el usuario actualizado con el ID asignado
        Usuario usuarioConId = usuarioService.getUsuarioPorUsername(usuario.getUsername());
        
        // Luego, asigna el rol utilizando el ID del usuario
        if (usuarioConId != null) {
            // crear el rol
            usuarioService.save(usuario, true);
        }
        
        return "redirect:/";
    }


    @PostMapping("/recordarUsuario")
    public String recordarUsuario(Model model, Usuario usuario) 
            throws MessagingException {
        model = registroService.recordarUsuario(model, usuario);
        return "/registro/salida";
    }
    
}

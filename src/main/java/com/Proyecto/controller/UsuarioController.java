
package com.Proyecto.controller;

import com.Proyecto.domain.Usuario;
import com.Proyecto.service.UsuarioService;
import com.Proyecto.service.FirebaseStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private FirebaseStorageService firebaseStorageService;


    @GetMapping("/modificar/{idUsuario}")
    public String usuarioModificar(Usuario usuario, Model model) {
        usuario = usuarioService.getUsuario(usuario);
        model.addAttribute("usuario", usuario);
        return "/usuario/modifica";
    }
    
    @PostMapping("/guardar")
    public String usuarioGuardar(Usuario usuario,
            @RequestParam("imagenFile") MultipartFile imagenFile) {
        
        boolean nuevo = true;
        
        //Validar si es una creacaión o modificación (Si tiene ID)
        if (usuario.getIdUsuario() != 0){        
            nuevo=false;
            Usuario actual = usuarioService.getUsuario(usuario);
            usuario.setPassword(actual.getPassword());
            usuario.setUsername(actual.getUsername());
            usuario.setRoles(actual.getRoles());            
            if (imagenFile.isEmpty()) {
            
                usuario.setFotoPerfil(actual.getFotoPerfil());
            }
        }else{
            usuario.setPassword(new BCryptPasswordEncoder().encode(usuario.getPassword()));
            usuario.setActivo(true);
        }        
        
        if (!imagenFile.isEmpty()) {
            usuarioService.save(usuario,false);
            usuario.setFotoPerfil(
                    firebaseStorageService.cargaImagen(
                            imagenFile,
                            "usuario",
                            usuario.getIdUsuario()));
        }
        usuarioService.save(usuario,true);
        return "redirect:/";
    }

}

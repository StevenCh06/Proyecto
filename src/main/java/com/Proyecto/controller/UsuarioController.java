
package com.Proyecto.controller;

import com.Proyecto.domain.Usuario;
import com.Proyecto.service.RestBarService;
import com.Proyecto.service.UsuarioService;
import com.Proyecto.serviceImpl.FirebaseStorageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;  
    
    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;
    
    @PostMapping("/guardar")
    public String usuarioGuardar(Usuario usuario,
            @RequestParam("imagenFile") MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()) {
            // Si se proporcionó una imagen, cárgala y asigna el nombre al usuario.
            String nombreImagen = firebaseStorageService.cargaImagen(imagenFile, "usuario", usuario.getIdUsuario());
            usuario.setFotoPerfil(nombreImagen);
        }

        // Guarda el usuario independientemente de si se proporcionó una imagen.
        usuarioService.save(usuario);

        return "sesionIniciada";
    }

    
}

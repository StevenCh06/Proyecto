
package com.Proyecto.serviceImpl;

import com.Proyecto.dao.RestBarDao;
import com.Proyecto.domain.RestBar;
import com.Proyecto.service.RestBarService;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RestBarServiceImpl implements RestBarService {
    
    @Autowired
    private RestBarDao restbarDao;
     
    @Override
    @Transactional(readOnly = true)
    public List<RestBar> getRestBar() {
        List<RestBar> restbares = restbarDao.findAll();
        
        return restbares;
    }
    
    @Override
    public RestBar getRestBar(RestBar restbar) {
       return restbarDao.findById(restbar.getIdLocal()).orElse(null);
    }

    @Override
    @Transactional
    public void save(RestBar restbar) {
        restbarDao.save(restbar);
    }

    @Override
    @Transactional
    public void delete(RestBar restbar) {
        restbarDao.delete(restbar);
    }

    @Override
    public List<RestBar> obtenerLocalesFiltrados(String tipos) {
        // Puedes implementar la lógica para obtener los locales filtrados
        // Aquí estoy asumiendo que los tipos son una cadena separada por comas

        List<String> tiposList = Arrays.asList(tipos.split(","));
        
        // Implementa la lógica para filtrar los locales según los tipos
        // Puedes acceder a tu repositorio de datos o cualquier otra lógica de acceso a la base de datos aquí

        if (tiposList.contains("Bar") && tiposList.contains("Restaurante")) {
            // Si ambos tipos están seleccionados, devuelve todos los locales
            return restbarDao.findAll();
        } else if (tiposList.contains("Bar")) {
            // Si solo "Bar" está seleccionado, devuelve locales de tipo "Bar"
            return restbarDao.findByTipo("Bar");
        } else if (tiposList.contains("Restaurante")) {
            // Si solo "Restaurante" está seleccionado, devuelve locales de tipo "Restaurante"
            return restbarDao.findByTipo("Restaurante");
        } else {
            // Si no se selecciona ningún tipo, devuelve una lista vacía o lo que consideres apropiado
            return Collections.emptyList();
        }
    }
    
}
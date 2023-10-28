
package com.Proyecto.serviceImpl;

import com.Proyecto.dao.RestBarDao;
import com.Proyecto.domain.RestBar;
import com.Proyecto.service.RestBarService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;




public class RestBarServiceImpl implements RestBarService {
     @Autowired
    private RestBarDao restbarDao;
    
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


}
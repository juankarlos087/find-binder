
package com.seguimiento.carpetas.Service.Implements;

import com.seguimiento.carpetas.Dao.CarpetaDao;
import com.seguimiento.carpetas.Models.Carpeta;
import com.seguimiento.carpetas.Services.CarpetaService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CarpetaServiceImpl implements CarpetaService {
    @Autowired
    private CarpetaDao carpetaDao;
    
    @Override
    @Transactional(readOnly=false)
    public Carpeta save(Carpeta carpeta){
        return carpetaDao.save(carpeta);
    }
    
    @Override
    @Transactional(readOnly=false)
    public void delete(Integer id){
        carpetaDao.deleteById(id);
    }
    
    @Override
    @Transactional(readOnly=true)
    public Carpeta findById(Integer id){
        return carpetaDao.findById(id).orElse(null);
    }
    
    @Override
    @Transactional(readOnly=true)
    public List<Carpeta> findByAll(){
        return (List<Carpeta>) carpetaDao.findAll();
    }
    
}
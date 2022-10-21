package com.sistema.seguimiento.Service.Implement;

import com.sistema.seguimiento.Models.Tipo;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sistema.seguimiento.Dao.TipoDao;
import com.sistema.seguimiento.Service.TipoService;

@Service
public class TipoServiceImpl implements TipoService {
    @Autowired
    private TipoDao tipoDao;
    
    @Override
    @Transactional(readOnly=false)
    public Tipo save(Tipo tipo){
        return tipoDao.save(tipo);
    }
    
    @Override
    @Transactional(readOnly=false)
    public void delete(Integer id){
        tipoDao.deleteById(id);
    }
    
    @Override
    @Transactional(readOnly=true)
    public Tipo findById(Integer id){
        return tipoDao.findById(id).orElse(null);
    }
    
    @Override
    @Transactional(readOnly=true)
    public List<Tipo> findByAll(){
        return (List<Tipo>) tipoDao.findAll();
    }
    
}

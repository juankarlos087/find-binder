package com.sistema.seguimiento.Service.Implement;

import com.sistema.seguimiento.Dao.UsuarioDao;
import com.sistema.seguimiento.Models.Usuario;
import com.sistema.seguimiento.Service.UsuarioService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioDao usuarioDao;
    
    @Override
    @Transactional(readOnly=false)
    public Usuario save(Usuario usuario){
        return usuarioDao.save(usuario);
    }
    
    @Override
    @Transactional(readOnly=false)
    public void delete(Integer id){
        usuarioDao.deleteById(id);
    }
    
    @Override
    @Transactional(readOnly=true)
    public Usuario findById(Integer id){
        return usuarioDao.findById(id).orElse(null);
    }
    
    @Override
    @Transactional(readOnly=true)
    public List<Usuario> findByAll(){
        return (List<Usuario>) usuarioDao.findAll();
    }
    
}

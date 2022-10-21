
package com.sistema.seguimiento.Dao;

import com.sistema.seguimiento.Models.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioDao extends CrudRepository<Usuario, Integer> {
    
}

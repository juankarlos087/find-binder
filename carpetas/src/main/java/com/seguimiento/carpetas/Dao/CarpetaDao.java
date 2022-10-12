
package com.seguimiento.carpetas.Dao;

import com.seguimiento.carpetas.Models.Carpeta;
import org.springframework.data.repository.CrudRepository;

public interface CarpetaDao extends CrudRepository<Carpeta, Integer> {
    
}

package com.seguimiento.carpetas.Services;

import com.seguimiento.carpetas.Models.Carpeta;
import java.util.List;

public interface CarpetaService {
    public Carpeta save(Carpeta carpeta);
    public void delete(Integer id);
    public Carpeta findById(Integer id);
    public List<Carpeta> findByAll();
}

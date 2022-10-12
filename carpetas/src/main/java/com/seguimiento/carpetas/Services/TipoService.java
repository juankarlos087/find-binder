
package com.seguimiento.carpetas.Services;

import com.seguimiento.carpetas.Models.Tipo;
import java.util.List;

public interface TipoService {
    public Tipo save(Tipo tipo);
    public void delete(Integer id);
    public Tipo findById(Integer id);
    public List<Tipo> findByAll();
}
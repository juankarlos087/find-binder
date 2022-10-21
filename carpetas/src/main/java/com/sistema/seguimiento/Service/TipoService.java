package com.sistema.seguimiento.Service;

import com.sistema.seguimiento.Models.Tipo;
import java.util.List;

public interface TipoService {
    public Tipo save(Tipo tipo);
    public void delete(Integer id);
    public Tipo findById(Integer id);
    public List<Tipo> findByAll();
}

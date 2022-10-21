package com.sistema.seguimiento.Service;

import com.sistema.seguimiento.Models.Carpeta;
import java.util.List;

public interface CarpetaService {
    public Carpeta save(Carpeta carpeta);
    public void delete(Integer id);
    public Carpeta findById(Integer id);
    public List<Carpeta> findByAll();
}

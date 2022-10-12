
package com.seguimiento.carpetas.Controller;

import com.seguimiento.carpetas.Models.Carpeta;
import com.seguimiento.carpetas.Services.CarpetaService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/carpeta")
public class CarpetaController {
    @Autowired
    private CarpetaService carpetaService;
    
    @PostMapping(value="/")
    public ResponseEntity<Carpeta> agregar(@RequestBody Carpeta carpeta){
        Carpeta obj = carpetaService.save(carpeta);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @DeleteMapping(value="/{id}")
    public ResponseEntity<Carpeta> eliminar(@PathVariable Integer id){
        Carpeta obj = carpetaService.findById(id);
        if(obj!=null){
            carpetaService.delete(id);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @PutMapping(value="/")
    public ResponseEntity<Carpeta> editar(@RequestBody Carpeta carpeta){
        Carpeta obj = carpetaService.findById(carpeta.getNumero_emp());
        if(obj!=null){
            obj.setTipo(carpeta.getTipo());
            obj.setNombre_emp(carpeta.getNombre_emp());
            obj.setIdentificacion_emp(carpeta.getIdentificacion_emp());
            carpetaService.save(obj);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @GetMapping("/list")
    public List<Carpeta> consultarTodo(){
        return carpetaService.findByAll();
    }
    
    @GetMapping("/list/{id}")
    public Carpeta consultarPorId(@PathVariable Integer id){
        return carpetaService.findById(id);
    }

}

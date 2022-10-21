package com.sistema.seguimiento.Controller;

import com.sistema.seguimiento.Models.Tipo;
import com.sistema.seguimiento.Service.TipoService;
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
@RequestMapping("/tipo")
public class TipoController {
    @Autowired
    private TipoService tipoService;
    
    @PostMapping(value="/")
    public ResponseEntity<Tipo> agregar(@RequestBody Tipo tipo){
        Tipo obj = tipoService.save(tipo);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @DeleteMapping(value="/{id}")
    public ResponseEntity<Tipo> eliminar(@PathVariable Integer id){
        Tipo obj = tipoService.findById(id);
        if(obj!=null){
            tipoService.delete(id);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @PutMapping(value="/")
    public ResponseEntity<Tipo> editar(@RequestBody Tipo tipo){
        Tipo obj = tipoService.findById(tipo.getCodigo_tip());
        if(obj!=null){
            obj.setEstado_tip(tipo.getEstado_tip());
            obj.setObservacion_tip(tipo.getObservacion_tip());
            tipoService.save(obj);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @GetMapping("/list")
    public List<Tipo> consultarTodo(){
        return tipoService.findByAll();
    }
    
    @GetMapping("/list/{id}")
    public Tipo consultarPorId(@PathVariable Integer id){
        return tipoService.findById(id);
    }

}

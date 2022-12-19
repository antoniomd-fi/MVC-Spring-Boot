package com.example.proyecto2.controller;

import com.example.proyecto2.dto.DireccionDTO;
import com.example.proyecto2.entity.Direccion;
import com.example.proyecto2.service.DireccionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class DireccionController {

    @Autowired
    public DireccionService direccionService;

    @GetMapping("/getDireccion/{id}")
    public ResponseEntity <DireccionDTO> getDireccion (@PathVariable("id") Integer id){
        return  new ResponseEntity<>(new DireccionDTO(this.direccionService.getById(id)), HttpStatus.OK);
    }

    @PostMapping("/createDireccion")
    public  ResponseEntity<DireccionDTO> createPersona (@RequestBody DireccionDTO data){
        Direccion direccion = new Direccion();
        System.out.println(data.id);
        try{
            direccion= this.direccionService.create(data.id, data.calle, data.numero_interior, data.numero_exterior,data.codigo_postal, data.colonia, data.ciudad, data.estado);
        }catch (Exception e){
            log.error("Something was wrong");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(new DireccionDTO(direccion), HttpStatus.OK);
    }

    @DeleteMapping("/deleteDireccion/{id}")
    public void deletePersona (@PathVariable("id") Integer id){
        this.direccionService.delete(id);
    }

    @PutMapping("/updateDireccion/{id}")
    public  ResponseEntity<DireccionDTO> updatePersona (@PathVariable("id")Integer id, @RequestParam("codigo_postal") Integer codigo_postal){
        Direccion direccion = this.direccionService.update(id,codigo_postal);

        return new ResponseEntity<>(new DireccionDTO(direccion),HttpStatus.OK);
    }
}

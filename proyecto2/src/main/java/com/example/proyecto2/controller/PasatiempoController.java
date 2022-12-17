package com.example.proyecto2.controller;

import com.example.proyecto2.dto.PasatiempoDTO;
import com.example.proyecto2.entity.Pasatiempo;
import com.example.proyecto2.service.PasatiempoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PasatiempoController {

    @Autowired
    public PasatiempoService pasatiempoService;

    @GetMapping("/getPasatiempo/{id}")
    public ResponseEntity<PasatiempoDTO> getPasatiempo (@PathVariable("id") Integer id){
        return new ResponseEntity<>(new PasatiempoDTO(this.pasatiempoService.getById(id)), HttpStatus.OK);
    }

    @PostMapping("/createPasatiempo")
    public  ResponseEntity<PasatiempoDTO> createPersona (@RequestBody PasatiempoDTO data){
        Pasatiempo pasatiempo = new Pasatiempo();
        try{
            pasatiempo= this.pasatiempoService.create(data.id, data.nombre, data.pasatiempo, data.id_persona);
        }catch (Exception e){
            System.out.println("Something was wrong");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(new PasatiempoDTO(pasatiempo), HttpStatus.OK);
    }

    @DeleteMapping("/deletePasatiempo/{id}")
    public void deletePersona (@PathVariable("id") Integer id){
        this.pasatiempoService.delete(id);
    }

    @PutMapping("/updatePasatiempo/{id}")
    public  ResponseEntity<PasatiempoDTO> updatePersona (@PathVariable("id")Integer id, @RequestParam("nombre") String nombre){
        Pasatiempo pasatiempo = this.pasatiempoService.update(id,nombre);

        return new ResponseEntity<>(new PasatiempoDTO(pasatiempo),HttpStatus.OK);
    }
}

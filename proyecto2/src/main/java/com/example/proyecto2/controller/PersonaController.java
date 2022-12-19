package com.example.proyecto2.controller;

import com.example.proyecto2.Producer;
import com.example.proyecto2.dto.PersonaDTO;
import com.example.proyecto2.entity.Persona;
import com.example.proyecto2.service.PersonaService;

import com.example.proyecto2.service.ProducerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
public class PersonaController {

    @Autowired
    public PersonaService personaService;
    @Autowired
    public ProducerService producerService;

    @GetMapping("/getPersona/{id}")
    public ResponseEntity<PersonaDTO> getPersona (@PathVariable("id") Integer id){
        return new ResponseEntity<>(new PersonaDTO(this.personaService.getById(id)), HttpStatus.OK);
    }

    @GetMapping("/listarPersonas/")
    public ResponseEntity<List<PersonaDTO>> getAllPersona () throws IOException {
        List<PersonaDTO> returnList = new ArrayList<>();
        List<Persona> list = personaService.getTable();

        for (int i = 0; i < list.size(); i++){
            returnList.add(new PersonaDTO(list.get(i)));
        }

        return new ResponseEntity<>(returnList,HttpStatus.OK);
    }
    //@Async
    @GetMapping("/enviarLista")
    public void sendList () {
        List<Persona> list = personaService.getTable();
        producerService.sendToRabbit(list);
    }





    @PostMapping("/createPersona")
    public  ResponseEntity<PersonaDTO> createPersona (@RequestBody PersonaDTO data){
        Persona persona = new Persona();
        try{
            persona= this.personaService.create(data.id, data.nombre, data.apellidos, data.direccion_id);
        }catch (Exception e){
            log.error("Something was wrong");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(new PersonaDTO(persona), HttpStatus.OK);
    }

    @DeleteMapping("/deletePersona/{id}")
    public void deletePersona (@PathVariable("id") Integer id){
        this.personaService.delete(id);
    }

    @PutMapping("/updatePersona/{id}")
    public  ResponseEntity<PersonaDTO> updatePersona (@PathVariable("id")Integer id, @RequestParam("nombre") String nombre, @RequestParam ("apellidos") String apellidos){
        Persona persona = this.personaService.update(id,nombre,apellidos);

        return new ResponseEntity<>(new PersonaDTO(persona),HttpStatus.OK);
    }


}

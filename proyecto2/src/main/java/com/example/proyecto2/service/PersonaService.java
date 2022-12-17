package com.example.proyecto2.service;

import com.example.proyecto2.entity.Persona;
import com.example.proyecto2.repository.PersonaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    public Persona getById(Integer id){
        return  this.personaRepository.findById(id).get();
    }

    public Persona create(Integer id, String nombre, String apellidos, Integer direccion_id){
        Persona persona = new Persona(id,nombre,apellidos,direccion_id);
        persona = personaRepository.save(persona);
        log.info("Registro creado en la tabla PERSONA");
        return persona;
    }

    public void delete (Integer id){
        Persona persona = getById(id);
        personaRepository.delete(persona);
        log.warn("Se ha borrado un registro de la tabla PERSONA");
    }

    public Persona update(Integer id, String nombre, String apellidos){
        Persona persona = getById(id);
        persona.setNombre(nombre);
        persona.setApellidos(apellidos);
        personaRepository.save(persona);
        log.info("Registro actualizado en la tabla PERSONA");
        return persona;
    }

    public List<Persona> getTable(){
        return personaRepository.findAll(Sort.by("id").ascending());
    }
}
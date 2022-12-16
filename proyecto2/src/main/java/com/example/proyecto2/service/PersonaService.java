package com.example.proyecto2.service;

import com.example.proyecto2.entity.Persona;
import com.example.proyecto2.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return persona;
    }

    public void delete (Integer id){
        Persona persona = getById(id);
        personaRepository.delete(persona);
    }

    public Persona update(Integer id, String nombre, String apellidos){
        Persona persona = getById(id);
        persona.setNombre(nombre);
        persona.setApellidos(apellidos);
        personaRepository.save(persona);
        return persona;
    }

    public List<Persona> getTable(){
        return personaRepository.findAll(Sort.by("id").ascending());
    }
}
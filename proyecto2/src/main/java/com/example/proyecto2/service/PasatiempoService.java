package com.example.proyecto2.service;
import com.example.proyecto2.entity.Pasatiempo;
import com.example.proyecto2.repository.PasatiempoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PasatiempoService {
    @Autowired
    private PasatiempoRepository pasatiempoRepository;

    public Pasatiempo getById(Integer id){
        return this.pasatiempoRepository.findById(id).get();
    }

    public Pasatiempo create (Integer id, String nombre, Integer pasatiempo, Integer id_persona){
        Pasatiempo pasatiempo1 = new Pasatiempo(id, nombre, pasatiempo, id_persona);
        pasatiempo1 = pasatiempoRepository.save(pasatiempo1);

        return pasatiempo1;
    }

    public void delete (Integer id){
        Pasatiempo pasatiempo = getById(id);
        pasatiempoRepository.delete(pasatiempo);
    }

    public Pasatiempo update(Integer id, String nombre){
        Pasatiempo pasatiempo = getById(id);
        pasatiempo.setNombre(nombre);
        pasatiempoRepository.save(pasatiempo);
        return pasatiempo;
    }
}

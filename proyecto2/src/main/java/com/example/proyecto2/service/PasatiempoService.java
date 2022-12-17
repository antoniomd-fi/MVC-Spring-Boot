package com.example.proyecto2.service;
import com.example.proyecto2.entity.Pasatiempo;
import com.example.proyecto2.repository.PasatiempoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
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
        log.info("Registro creado en la tabla PASATIEMPO");
        return pasatiempo1;
    }

    public void delete (Integer id){
        Pasatiempo pasatiempo = getById(id);
        pasatiempoRepository.delete(pasatiempo);
        log.warn("Se ha borrado un registro de la tabla PASATIEMPO");
    }

    public Pasatiempo update(Integer id, String nombre){
        Pasatiempo pasatiempo = getById(id);
        pasatiempo.setNombre(nombre);
        pasatiempoRepository.save(pasatiempo);
        log.info("Registro actualizado en la tabla PASATIEMPO");
        return pasatiempo;
    }
}

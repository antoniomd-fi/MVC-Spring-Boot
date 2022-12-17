package com.example.proyecto2.service;
import com.example.proyecto2.entity.Direccion;
import com.example.proyecto2.repository.DireccionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DireccionService {

    @Autowired
    private DireccionRepository direccionRepository;

    public Direccion getById(Integer id){
        return this.direccionRepository.findById(id).get();
    }

    public  Direccion create (Integer id, String calle, String numero_interior, String numero_exterior, Integer codigo_postal, String colonia, Integer ciudad, Integer estado){
        Direccion direccion = new Direccion(id, calle, numero_interior, numero_exterior, codigo_postal, colonia, ciudad, estado);
        direccion = direccionRepository.save(direccion);
        log.info("Registro creado en la tabla DIRECCION");
        return  direccion;
    }

    public void delete (Integer id){
        Direccion direccion = getById(id);
        direccionRepository.delete(direccion);
        log.warn("Se ha borrado un registro de la tabla DIRECCION");
    }

    public Direccion update(Integer id, Integer codigo_postal){
        Direccion direccion = getById(id);
        direccion.setCodigo_postal(codigo_postal);
        direccionRepository.save(direccion);
        log.info("Registro actualizado en la tabla DIRECCION");
        return direccion;
    }
}

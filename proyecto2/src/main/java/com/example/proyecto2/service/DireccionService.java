package com.example.proyecto2.service;
import com.example.proyecto2.entity.Direccion;
import com.example.proyecto2.repository.DireccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        return  direccion;
    }

    public void delete (Integer id){
        Direccion direccion = getById(id);
        direccionRepository.delete(direccion);
    }

    public Direccion update(Integer id, Integer codigo_postal){
        Direccion direccion = getById(id);
        direccion.setCodigo_postal(codigo_postal);
        direccionRepository.save(direccion);
        return direccion;
    }
}

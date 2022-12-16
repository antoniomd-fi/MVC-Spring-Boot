package com.example.proyecto2.dto;

import com.example.proyecto2.entity.Pasatiempo;

public class PasatiempoDTO {

    public Integer id;
    public String nombre;
    public Integer pasatiempo;
    public Integer id_persona;

    public  PasatiempoDTO (){

    }

    public  PasatiempoDTO (Pasatiempo pasatiempo){
        this.id = pasatiempo.getId();
        this.nombre = pasatiempo.getNombre();
        this.pasatiempo = pasatiempo.getPasatiempo();
        this.id_persona = pasatiempo.getId_persona();
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getPasatiempo() {
        return pasatiempo;
    }

    public Integer getId_persona() {
        return id_persona;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPasatiempo(Integer pasatiempo) {
        this.pasatiempo = pasatiempo;
    }

    public void setId_persona(Integer id_persona) {
        this.id_persona = id_persona;
    }
}

package com.example.proyecto2.dto;

import com.example.proyecto2.entity.Persona;

public class PersonaDTO {

    public Integer id;
    public  String nombre;
    public String apellidos;
    public Integer direccion_id;

    public PersonaDTO(){

    }

    public PersonaDTO(Persona persona){
        this.id = persona.getId();
        this.nombre = persona.getNombre();
        this.apellidos = persona.getApellidos();
        this.direccion_id = persona.getDireccion_id();
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Integer getDireccion_id() {
        return direccion_id;
    }

    public void setDireccion_id(Integer direccion_id) {
        this.direccion_id = direccion_id;
    }
}

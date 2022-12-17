package com.example.proyecto2.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "pasatiempos", schema = "public")
public class Pasatiempo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private Integer pasatiempo;
    private Integer id_persona;

    /*@ManyToMany(mappedBy = "pasatiempos")
    private List<Persona> personas;*/



    public Pasatiempo(){

    }
    public Pasatiempo(Integer id, String nombre, Integer pasatiempo, Integer id_persona) {
        this.id = id;
        this.nombre = nombre;
        this.pasatiempo = pasatiempo;
        this.id_persona = id_persona;
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

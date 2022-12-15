package com.example.proyecto2.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "direccion", schema = "public")
public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    private String calle;
    private String numero_interior;
    private String numero_exterior;
    private  Integer codigo_postal;
    private String colonia;
    private Integer ciudad;
    private Integer estado;

    @OneToMany(mappedBy = "direccion")
    private List<Persona> personas;

    public void addPersona(Persona persona){
        if(this.personas == null){
            this.personas = new ArrayList<>();
        }

        this.personas.add(persona);
    }


    public  Direccion (){

    }
    public Direccion(Integer id, String calle, String numero_interior, String numero_exterior, Integer codigo_postal, String colonia, Integer ciudad, Integer estado) {
        this.id = id;
        this.calle = calle;
        this.numero_interior = numero_interior;
        this.numero_exterior = numero_exterior;
        this.codigo_postal = codigo_postal;
        this.colonia = colonia;
        this.ciudad = ciudad;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public String getCalle() {
        return calle;
    }

    public String getNumero_interior() {
        return numero_interior;
    }

    public String getNumero_exterior() {
        return numero_exterior;
    }

    public Integer getCodigo_postal() {
        return codigo_postal;
    }

    public String getColonia() {
        return colonia;
    }

    public Integer getCiudad() {
        return ciudad;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public void setNumero_interior(String numero_interior) {
        this.numero_interior = numero_interior;
    }

    public void setNumero_exterior(String numero_exterior) {
        this.numero_exterior = numero_exterior;
    }

    public void setCodigo_postal(Integer codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public void setCiudad(Integer ciudad) {
        this.ciudad = ciudad;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }
}

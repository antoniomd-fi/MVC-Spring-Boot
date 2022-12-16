package com.example.proyecto2.dto;

import com.example.proyecto2.entity.Direccion;

public class DireccionDTO {

    public   Integer id;
    public String calle;
    public String numero_interior;
    public String numero_exterior;
    public  Integer codigo_postal;
    public String colonia;
    public Integer ciudad;
    public Integer estado;

    public DireccionDTO (){

    }

    public  DireccionDTO (Direccion direccion){
        this.id = direccion.getId();
        this.calle = direccion.getCalle();
        this.numero_exterior = direccion.getNumero_exterior();
        this.numero_interior = direccion.getNumero_interior();
        this.codigo_postal = direccion.getCodigo_postal();
        this.colonia=direccion.getColonia();
        this.ciudad = direccion.getCiudad();
        this.estado = direccion.getEstado();
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



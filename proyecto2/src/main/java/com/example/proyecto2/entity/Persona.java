package com.example.proyecto2.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


    @Entity
    @Table(name = "persona", schema = "public")
    public class Persona {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private  Integer id;
        private  String nombre;
        private String apellidos;
        private Integer direccion_id;

       /* @ManyToOne()
       @JoinColumn(name = "direccion_id", referencedColumnName = "id", nullable = false)
        private Direccion direccion;

        @JoinTable(
                name = "rel_persona_pasatiempo",
                joinColumns = @JoinColumn(name = "persona_fk", nullable = false),
                inverseJoinColumns = @JoinColumn(name="pasatiempo_fk", nullable = false)
        )
*/
        @ManyToMany(cascade = CascadeType.ALL)
        List<Pasatiempo> pasatiempos;

        public void addPasatiempo(Pasatiempo pasatiempo){
            if(this.pasatiempos == null){
                this.pasatiempos = new ArrayList<>();
            }

            this.pasatiempos.add(pasatiempo);
        }

        public Persona (){

        }

        public Persona(Integer id, String nombre, String apellidos, Integer direccion_id) {
            this.id = id;
            this.nombre = nombre;
            this.apellidos = apellidos;
            //this.direccion.setId(direccion_id);
            this.direccion_id = direccion_id;
        }

        public Integer getId() {
            return id;
        }

        public String getNombre() {
            return nombre;
        }

        public String getApellidos() {
            return apellidos;
        }

        public Integer getDireccion_id() {
            return direccion_id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void setApellidos(String apellidos) {
            this.apellidos = apellidos;
        }

        public void setDireccion_id(Integer direccion_id) {
            this.direccion_id = direccion_id;
        }

       /* public Direccion getDireccion() {
            return direccion;
        }

        public void setDireccion(Direccion direccion) {
            this.direccion = direccion;
        }*/


    }


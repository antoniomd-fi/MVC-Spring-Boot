package com.bedu.jmsconsumer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Persona {
    @Getter private Integer id;
    @Getter private String nombre;
    @Getter private String apellidos;
    @Getter private  Integer direccion_id;
}

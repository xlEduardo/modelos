package com.uabc.edu.modelos.model;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name="objetos")
public class Objeto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="objeto_id")
    private long objetoId;
    @Column(name="nombre")
    private String nombre;
    @Column(name="altura")
    private String altura;
    @Column(name="color")
    private String color;
    @Column(name="material")
    private String material;
}

package com.uabc.edu.modelos.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name="animales")
public class Animal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="animal_id")
    private long animalId;
    @Column(name="nombre")
    private String nombre;
    @Column(name="category")
    private String category;
    @Column(name="color")
    private String color;
    @Column(name="pelaje")
    private String pelaje;
}

package com.uabc.edu.modelos.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name="vehiculos")
public class Vehiculo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="vehiculo_id")
    private long vehiculoId;

    @Column(name="marca")
    private String marca;
    @Column(name="modelo")
    private String modelo;
    @Column(name="color")
    private String color;
    @Column(name="ano")
    private String anio;
}
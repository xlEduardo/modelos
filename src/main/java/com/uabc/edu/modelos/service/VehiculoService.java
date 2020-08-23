package com.uabc.edu.modelos.service;

import com.uabc.edu.modelos.model.Animal;
import com.uabc.edu.modelos.model.Vehiculo;
import com.uabc.edu.modelos.repository.animalRepository;
import com.uabc.edu.modelos.repository.vehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehiculoService  {
    @Autowired
    vehiculoRepository repo;
    //Agregar un vehiculo
    public void add(Vehiculo vehiculo){
        repo.save(vehiculo);
    }

    //Borrar con el objeto
    public void delete(Vehiculo vehiculo){
        repo.delete(vehiculo);
    }

    //Borrar por id
    public void deleteById(Long id){
        repo.deleteById(id);
    }

    //Buscar todos de una marca
    public List<Vehiculo> todos(String marca){

        return repo.findByMarca(marca);
    }
    public List<Vehiculo> todos(){
        List<Vehiculo> actualList = new ArrayList<Vehiculo>();
        repo.findAll().forEach(actualList::add);
        return actualList;
    }

}

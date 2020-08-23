package com.uabc.edu.modelos.service;

import com.uabc.edu.modelos.model.Animal;
import com.uabc.edu.modelos.repository.animalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnimalService {

    @Autowired
     animalRepository repo;


    //Agregar un animal
    public Animal registrarAnimal(Animal animal){
        Animal userSaved = repo.save(animal);

        return userSaved;
    }

    //Borrar por id
    public void deleteById(Long id){
        Animal animal = repo.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Invalid user Id:" + id));

        repo.delete(animal);
    }


    public void actualizarAnimal(long id){

        Animal animal = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        //TODO Enviar a la vista HTML en el objeto a editar en un Model
    }

    public void actualizarAnimal(Animal animal){

        repo.save(animal);
    }

    public List<Animal> todos(){
        List<Animal> actualList = new ArrayList<Animal>();
        repo.findAll().forEach(actualList::add);
        return actualList;
    }

    public Animal obtenerAnimalPorID(long id){

        return repo.findById(id).get();
    }

}

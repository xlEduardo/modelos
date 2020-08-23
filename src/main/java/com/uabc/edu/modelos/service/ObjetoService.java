package com.uabc.edu.modelos.service;


import com.uabc.edu.modelos.model.Animal;
import com.uabc.edu.modelos.model.Objeto;

import com.uabc.edu.modelos.repository.objetoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ObjetoService {
    @Autowired
    objetoRepository repo;
    //Agregar un objeto
    public void add(Objeto objeto){

        repo.save(objeto);
    }

    //Borrar con el objeto
    public void delete(Objeto objeto){
        repo.delete(objeto);
    }

    //Borrar por id
    public void deleteById(Long id){
        repo.deleteById(id);
    }

    public List<Objeto> todos(){
        List<Objeto> actualList = new ArrayList<Objeto>();
        repo.findAll().forEach(actualList::add);
        return actualList;
    }

    //Buscar todos de un color
    public List<Objeto> todos(String color){

        return repo.findByColor(color);

    }

}

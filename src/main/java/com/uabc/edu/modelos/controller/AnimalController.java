package com.uabc.edu.modelos.controller;

import com.uabc.edu.modelos.model.Animal;
import com.uabc.edu.modelos.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AnimalController {

    @Autowired
    AnimalService repo;

    @GetMapping("/mostrarA")
    public String index(Model model){
        List<Animal> animales = repo.todos();

        model.addAttribute("animal", animales);
        return "mostrarAnimal";
    }

    @GetMapping("agregarA")
    public String registrar(Animal animal){

        return "formularioAnimal";
    }


    @PostMapping("/addanimal")
    public String addAnimal(Animal animal, BindingResult result, Model model){

        if (result.hasErrors()){
            return "formularioAnimal";
        }

        repo.registrarAnimal(animal);

        return "redirect:mostrarA";
    }


    @GetMapping("eliminar/{id}")
    public String eliminar(@PathVariable("id") long laID, Model model){
        repo.deleteById(laID);
        model.addAttribute("animal",repo.todos());
        return "mostrarAnimal";
    }

    @GetMapping("editar/{id}")
    public String editarAnimal(@PathVariable("id")long id, Model model){
        Animal animal  = repo.obtenerAnimalPorID(id);
        model.addAttribute("animal",animal);

        return "update-animal";

    }

    @PostMapping("/actualizar/{id}")
    public String actualizar(@PathVariable("id") long id,
                             Animal animal, BindingResult result, Model model){


        if(result.hasErrors()){
            animal.setAnimalId(id);
            return "actualizar";
        }

        repo.actualizarAnimal(animal);


        return "redirect:/mostrarA";

    }





}

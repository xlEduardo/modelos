package com.uabc.edu.modelos.controller;

import com.uabc.edu.modelos.model.Animal;
import com.uabc.edu.modelos.model.Objeto;
import com.uabc.edu.modelos.model.Vehiculo;
import com.uabc.edu.modelos.service.AnimalService;
import com.uabc.edu.modelos.service.ObjetoService;
import com.uabc.edu.modelos.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class IndexController {
    @Autowired
    ObjetoService obj;
    @Autowired
    VehiculoService ve;

    @GetMapping("/")
    public String hola(){

        return "index";
    }

    @GetMapping("/vehiculo")
    public String mostrarVehiculo(Vehiculo vehiculo, Model model){
        model.addAttribute("vehiculo", new Vehiculo());

        return "formularioVehiculo";
    }

    @PostMapping("/vehiculo")
    public String vehiculoSubmit(@ModelAttribute Vehiculo vehiculo, Model model) {

        model.addAttribute("vehiculo", vehiculo);
        //GUARDANDO EL ARTICULO EN LA BD
        ve.add(vehiculo);

        List<Vehiculo> vehiculos = ve.todos();
        model.addAttribute("vehiculo", vehiculos)
        ;
        return "mostrarVehiculo";
    }

    @GetMapping("/objeto")
    public String mostrarObjeto(Objeto object, Model model){
        model.addAttribute("objeto", new Objeto());

        return "formularioObj";
    }

    @PostMapping("/objeto")
    public String objetoSubmit(@ModelAttribute Objeto objeto, Model model) {

        model.addAttribute("objeto", objeto);
        //GUARDANDO EL ARTICULO EN LA BD
        obj.add(objeto);

        List<Objeto> objetos = obj.todos();
        model.addAttribute("objeto", objetos);
        return "mostrarObj";
    }

}

package com.uabc.edu.modelos.repository;

import com.uabc.edu.modelos.model.Objeto;
import com.uabc.edu.modelos.model.Vehiculo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface objetoRepository extends CrudRepository<Objeto, Long> {
    List<Objeto> findByColor (String color);
}

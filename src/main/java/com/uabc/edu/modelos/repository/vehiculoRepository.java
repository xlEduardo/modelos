package com.uabc.edu.modelos.repository;

import com.uabc.edu.modelos.model.Animal;
import com.uabc.edu.modelos.model.Vehiculo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface vehiculoRepository extends CrudRepository <Vehiculo, Long> {
    List<Vehiculo> findByMarca (String marca);
}

package com.uabc.edu.modelos.repository;

import com.uabc.edu.modelos.model.Animal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface animalRepository extends CrudRepository <Animal, Long> {
    List<Animal> findByCategory (String category);

}

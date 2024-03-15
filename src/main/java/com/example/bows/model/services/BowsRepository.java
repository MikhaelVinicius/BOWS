package com.example.bows.model.services;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.bows.model.Bows;


@Repository
public interface BowsRepository extends JpaRepository<Bows, Long> {

    List<Bows> findByName(String name);
   


    
}

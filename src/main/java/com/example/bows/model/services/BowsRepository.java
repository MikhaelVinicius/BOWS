package com.example.bows.model.services;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.bows.model.Bows;


@Repository
public interface BowsRepository extends CrudRepository<Bows, Long> {
   

    
}

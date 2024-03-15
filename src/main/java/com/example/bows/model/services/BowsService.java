package com.example.bows.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bows.model.Bows;

@Service
public class BowsService {

    @Autowired
    private BowsRepository bowsRepository;

    public void registrarBows(Bows bows){
        bowsRepository.save(bows);
    }

}

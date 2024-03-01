package com.example.bows.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.bows.model.Bows;
import com.example.bows.model.services.BowsRepository;

import java.util.List;


@RestController
@RequestMapping("/bows")
public class BowsController {

    @Autowired
    private BowsRepository bowsRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Bows> getBowsById(@PathVariable Long id) {
        Bows bows = bowsRepository.findById(id).orElse(null);
        if (bows == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(bows);
        }
    }

    @PostMapping
    public ResponseEntity<Bows> createBows(@RequestBody Bows bows) {
        Bows savedBows = bowsRepository.save(bows);
        return ResponseEntity.ok(savedBows);
    }

    @GetMapping
    public ResponseEntity<List<Bows>> getAllBows() {
        List<Bows> bows = (List<Bows>) bowsRepository.findAll();
        return ResponseEntity.ok(bows);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bows> updateBows(@PathVariable Long id, @RequestBody Bows newBows) {
        return bowsRepository.findById(id)
                .map(bows -> {
                    bows.setName(newBows.getName());
                    bows.setAutor(newBows.getAutor());
                    bows.setOrganizacao(newBows.getOrganizacao());
                    bows.setLocalizado(newBows.getLocalizado());
                    bows.setAgente_biologico(newBows.getAgente_biologico());
                    bows.setInfo(newBows.getInfo());
                    Bows updatedBows = bowsRepository.save(bows);
                    return ResponseEntity.ok(updatedBows);
                })
                .orElseGet(() -> {
                    newBows.setId(id);
                    Bows savedBows = bowsRepository.save(newBows);
                    return ResponseEntity.ok(savedBows);
                });
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBows(@PathVariable Long id) {
        bowsRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/doPost")
    public ResponseEntity<Bows> submitForm(@RequestBody Bows bows) {
        Bows savedBows = bowsRepository.save(bows);
        return ResponseEntity.ok(savedBows);
    }

    
}

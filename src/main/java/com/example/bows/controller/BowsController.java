package com.example.bows.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.bows.model.Bows;
import com.example.bows.model.services.BowsRepository;

import ch.qos.logback.core.model.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*")
@RestController
public class BowsController {

    @Autowired
    private BowsRepository bowsRepository;



    @RequestMapping(value = "/bowsList", method = RequestMethod.GET)
    public ResponseEntity<List<Bows>> getAllBows() {
        List<Bows> bows = (List<Bows>) bowsRepository.findAll();
        return ResponseEntity.ok(bows);
    }

    @RequestMapping(value = "/bows/{id}", method = RequestMethod.GET)
    public ResponseEntity<Bows> getBowsById(@PathVariable Long id) {
        Bows bows = bowsRepository.findById(id).orElse(null);
        if (bows == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(bows);
        }
    }

  


    @RequestMapping(value = "/bows/add", method =  RequestMethod.POST)
    public ResponseEntity<Bows> submitForm(@RequestBody Bows bows) {
        Bows savedBows = bowsRepository.save(bows);
        return ResponseEntity.ok(savedBows);




        
    }
  
  




























/*
@GetMapping("/bows")
public ResponseEntity<List<Bows>> getAllBows(@RequestParam(required = false) String name) {
    try { List<Bows> bows = new ArrayList<Bows>();
        if (name == null)
        bowsRepository.findAll().forEach(bows::add);
      else
        bowsRepository.findByName(name).forEach(bows::add);

      if (bows.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }

      return new ResponseEntity<>(bows, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }


  @GetMapping("/bows/{id}")
  public ResponseEntity<Bows> getTutorialById(@PathVariable("id") long id) {
    Optional<Bows> bowsData = bowsRepository.findById(id);

    if (bowsData.isPresent()) {
      return new ResponseEntity<>(bowsData.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping("/bows")
  public ResponseEntity<Bows> createBows(@RequestBody Bows bows) {
    try {
      Bows _bows = bowsRepository.save(new Bows(bows.getName(), bows.getAutor(),bows.getOrganizacao(),bows.getLocalizado(),bows.getAgente_biologico(),bows.getInfo()));
      return new ResponseEntity<>(_bows, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
*/






    /* 

       
    @GetMapping("/doPost")
    public ResponseEntity<Bows> submitForm(@RequestBody Bows bows) {
        Bows savedBows = bowsRepository.save(bows);
        return ResponseEntity.ok(savedBows);
    }

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
*/
    
}
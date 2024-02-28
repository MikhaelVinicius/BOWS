package com.example.bows.model.services;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.bows.model.Usuario;

public interface UserRepository extends CrudRepository<Usuario, Long> {

}

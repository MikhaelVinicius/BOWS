package com.example.bows.controller;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;

import com.example.bows.model.Usuario;

public class UserManager {
	
	private Map<String,Usuario> users;

	public UserManager(Map<String, Usuario> users) {
        this.users = users;
    }

    
    public UserManager() {
        this.users = new HashMap<>();
    }
	public Map<String,Usuario> getUsers() {
		
		return users;
	}
	

    public void registerUser(Usuario userToRegister) throws InvalidParameterException, IllegalStateException {
        if (userToRegister == null || userToRegister.getEmail() == null || userToRegister.getEmail().isEmpty()) {
            throw new InvalidParameterException("O usuário ou o e-mail não podem ser nulos ou vazios.");
        }

        if (users.containsKey(userToRegister.getEmail())) {
            throw new IllegalStateException("O usuário já está registrado.");
        }

        users.put(userToRegister.getEmail(), userToRegister);
    }
    
    public Usuario loginUser(Usuario userToLogin) throws InvalidParameterException, IllegalArgumentException, IllegalStateException {
        if (userToLogin == null || userToLogin.getEmail() == null || userToLogin.getEmail().isEmpty() || userToLogin.getSenha() == null || userToLogin.getSenha().isEmpty()) {
            throw new InvalidParameterException("O e-mail ou a senha não podem ser nulos ou vazios.");
        }

        if (!users.containsKey(userToLogin.getEmail())) {
            throw new IllegalArgumentException("O usuário não existe.");
        }

        Usuario storedUser = users.get(userToLogin.getEmail());
        if (!storedUser.getSenha().equals(userToLogin.getSenha())) {
            throw new IllegalStateException("E-mail ou senha incorretos.");
        }

        return storedUser;
    }
    
}
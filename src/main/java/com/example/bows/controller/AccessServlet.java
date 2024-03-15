package com.example.bows.controller;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.example.bows.model.Usuario;

import jakarta.persistence.EntityManager;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AccessServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Autowired
    private UserController userController;
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public void init() throws ServletException {
        super.init();
       
    }



		
    
   

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            Long id = Long.parseLong(req.getParameter("id"));
            Usuario user = userController.getUserById(id).getBody();
            resp.setContentType("application/json");
            mapper.writeValue(resp.getOutputStream(), user);
        }
    
        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            Usuario user = mapper.readValue(req.getInputStream(), Usuario.class);
            Usuario savedUser = userController.createUser(user).getBody();
            resp.setContentType("application/json");
            mapper.writeValue(resp.getOutputStream(), savedUser);
        }
    
        @Override
        protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            Long id = Long.parseLong(req.getParameter("id"));
            Usuario newUser = mapper.readValue(req.getInputStream(), Usuario.class);
            Usuario updatedUser = userController.updateUser(id, newUser).getBody();
            resp.setContentType("application/json");
            mapper.writeValue(resp.getOutputStream(), updatedUser);
        }
    
        @Override
        protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            Long id = Long.parseLong(req.getParameter("id"));
            userController.delete(id);
            resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
        }
    
        @Override
        public void destroy() {
          
            super.destroy();
        }
    }
    
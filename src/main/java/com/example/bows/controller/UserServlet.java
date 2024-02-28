package com.example.bows.controller;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.example.bows.model.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/testeUser")
public class UserServlet extends HttpServlet {
    @PersistenceContext
    private EntityManager entityManager;
    private static final long serialVersionUID = 1L;
 
  
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
 
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String htmlFilePath = "C:\\Users\\mikha\\OneDrive\\Área de Trabalho\\bows\\src\\main\\resources\\templates\\UsuarioForm.html"; 
        String meuHtml = readHtmlFromFile(htmlFilePath);

        PrintWriter imprimir = response.getWriter();
        imprimir.println(meuHtml);

        String parametro = request.getParameter("Parametro1");
        if (parametro != null) {
            imprimir.println("O parâmetro digitado foi: " + parametro);
        }
    }

    private String readHtmlFromFile(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        }
        return content.toString();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String htmlFilePath = "C:\\Users\\mikha\\OneDrive\\Área de Trabalho\\bows\\src\\main\\resources\\templates\\UsuarioForm.html"; 
        String meuHtml = readHtmlFromFile(htmlFilePath);
    
        PrintWriter imprimir = response.getWriter();
        imprimir.println(meuHtml);
    
        String nome = request.getParameter("nome");
        String sobrenome = request.getParameter("sobrenome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
    
        if (nome != null && sobrenome != null && email != null && senha != null) {
            imprimir.println("Os dados do usuário foram recebidos: ");
            imprimir.println("Nome: " + nome);
            imprimir.println("Sobrenome: " + sobrenome);
            imprimir.println("Email: " + email);
            // Não imprima a senha por razões de segurança
        } else {
            imprimir.println("Os dados do usuário não foram completamente preenchidos.");
        }
        if (nome != null && sobrenome != null && email != null && senha != null) {
            Usuario usuario = new Usuario();
            usuario.setNome(nome);
            usuario.setSobrenome(sobrenome);
            usuario.setEmail(email);
            usuario.setSenha(senha);
            
            entityManager.getTransaction().begin();
            entityManager.persist(usuario);
            entityManager.getTransaction().commit();
            
    
            imprimir.println("Usuário salvo com sucesso.");
        } else {
            imprimir.println("Os dados do usuário não foram completamente preenchidos.");
        }
    }
    

 }
package com.example.bows.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/testeBows")
public class BowsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
  
    public BowsServlet() {
        super();
        
    }
 
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String htmlFilePath = "/caminho/para/o/seu/arquivo.html"; 
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
    	String nome = request.getParameter("name");
    	String autor = request.getParameter("autor");
    	String organizacao = request.getParameter("organizacao");
    	String localizacao = request.getParameter("localizacao");
    	String info = request.getParameter("infor");
 
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Dados recebidos:</h1>");
        out.println("<p>Nome da espécie: " + nome + "</p>");
        out.println("<p>Autor: " + autor + "</p>");
        out.println("<p>Organizacao: " + organizacao + "</p>");
        out.println("<p>Encontrado em/na: " + localizacao + "</p>");
        out.println("<p>Informações da espécie: " + info + "</p>");
        
        
        out.println("</body></html>");
    }
 
}
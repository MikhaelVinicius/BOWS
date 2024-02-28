package com.example.bows.model;


import java.util.Objects;

import jakarta.persistence.*;

@Entity
public class Bows {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

   
    private String autor;
    private String organizacao;
    private String localizado;
    private String agente_biologico;
    private String info;
    
    private static final long serialVersionUID = 0;

    
    public Bows(String name, String autor, String organizacao, String localizado, String agente_biologico,
            String info) {
        this.name = name;
        this.autor = autor;
        this.organizacao = organizacao;
        this.localizado = localizado;
        this.agente_biologico = agente_biologico;
        this.info = info;
    }


    public Bows(){
        
    }
    


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public String getOrganizacao() {
        return organizacao;
    }
    public void setOrganizacao(String organizacao) {
        this.organizacao = organizacao;
    }
    public String getLocalizado() {
        return localizado;
    }
    public void setLocalizado(String localizado) {
        this.localizado = localizado;
    }
    public String getAgente_biologico() {
        return agente_biologico;
    }
    public void setAgente_biologico(String agente_biologico) {
        this.agente_biologico = agente_biologico;
    }
    public String getInfo() {
        return info;
    }
    public void setInfo(String info) {
        this.info = info;
    }

    @Override
   	public int hashCode() {
   		return Objects.hash(name);
   	}


   	@Override
   	public boolean equals(Object obj) {
   		if (this == obj)
   			return true;
   		if (obj == null)
   			return false;
   		if (getClass() != obj.getClass())
   			return false;
   		Bows other = (Bows) obj;
   		return Objects.equals(name, other.name);
   	}
   	private String name;
  
}

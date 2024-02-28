package com.example.bows.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuario {
	

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	private String email;
	private String senha;
	private String nome;
	private String sobrenome;
	
	private static final long serialVersionUID = 0;
	

	public Usuario(String email, String senha, String nome, String sobrenome) {
		super();
		this.email = email;
		this.senha = senha;
		this.nome = nome;
		this.sobrenome = sobrenome;
	}


	public Usuario( String senha, String email) {
		super();
		this.senha = senha;
		this.email = email;}

	public Usuario(){
		
	}	
	


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(email, other.email);
	}

	
}

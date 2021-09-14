/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Garcia
 */
/**
 *
 * @author Garcia
 */
public class Usuario {
    private int id;
    private String nome;
    private String senha;
    private String email;
    private int status;
    public Usuario() {
   
    }
    
    

    public Usuario(int id, String nome, String email, String senha, int status) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.status= status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    }
   


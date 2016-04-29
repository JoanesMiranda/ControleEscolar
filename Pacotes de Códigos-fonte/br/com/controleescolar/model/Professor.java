/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controleescolar.model;

/**
 *
 * @author Joanes
 */
public class Professor {
    
    private int idprofessor;
    private String nome;
    private String matricula;

    public Professor() {
    }

    public Professor(String nome,String matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }
    
    /**
     * @return the idprofessor
     */
    public int getIdprofessor() {
        return idprofessor;
    }

    /**
     * @param idprofessor the idprofessor to set
     */
    public void setIdprofessor(int idprofessor) {
        this.idprofessor = idprofessor;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the matricula
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * @param matricula the matricula to set
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
}

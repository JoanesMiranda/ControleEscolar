/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controleescolar.model;

/**
 *
 * @author Júnior
 */
public class Disciplina {
    
    private int iddisciplina;
    private String nome;
    private String codigo;
    private int idprofessor;

    public Disciplina() {
    }

    public Disciplina(int iddisciplina, String nome, String codigo, int idprofessor) {
        this.iddisciplina = iddisciplina;
        this.nome = nome;
        this.codigo = codigo;
        this.idprofessor = idprofessor;
    }
   
    /**
     * @return the iddisciplina
     */
    public int getIddisciplina() {
        return iddisciplina;
    }

    /**
     * @param iddisciplina the iddisciplina to set
     */
    public void setIddisciplina(int iddisciplina) {
        this.iddisciplina = iddisciplina;
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
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    
}

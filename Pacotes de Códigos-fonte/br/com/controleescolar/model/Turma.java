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
public class Turma {
    
    private int idturma;
    private String nome;
    private String codigo;

    public Turma() {
    }

    public Turma(String nome, String codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }
    
    /**
     * @return the idturma
     */
    public int getIdturma() {
        return idturma;
    }

    /**
     * @param idturma the idturma to set
     */
    public void setIdturma(int idturma) {
        this.idturma = idturma;
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

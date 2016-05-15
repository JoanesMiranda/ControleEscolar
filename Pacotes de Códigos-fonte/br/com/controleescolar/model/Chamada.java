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
public class Chamada {
    
    private int idchamada;
    private String faltas;
    private int idprofessor;
    private int iddisciplina;

    public Chamada() {
    }

    public Chamada(String faltas, int idprofessor, int iddisciplina) {
        this.faltas = faltas;
        this.idprofessor = idprofessor;
        this.iddisciplina = iddisciplina;
    }

    /**
     * @return the idchamada
     */
    public int getIdchamada() {
        return idchamada;
    }

    /**
     * @param idchamada the idchamada to set
     */
    public void setIdchamada(int idchamada) {
        this.idchamada = idchamada;
    }

    /**
     * @return the faltas
     */
    public String getFaltas() {
        return faltas;
    }

    /**
     * @param faltas the faltas to set
     */
    public void setFaltas(String faltas) {
        this.faltas = faltas;
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
    
    
}

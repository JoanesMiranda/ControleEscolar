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
public class Login {
    
    private int idlogin;
    private String usuario;
    private String senha;
    private int idprofessor;

    public Login() {
    }
    
    public Login(String usuario, String senha, int idprofessor) {
        this.usuario = usuario;
        this.senha = senha;
        this.idprofessor = idprofessor;
    }

    /**
     * @return the idlogin
     */
    public int getIdlogin() {
        return idlogin;
    }

    /**
     * @param idlogin the idlogin to set
     */
    public void setIdlogin(int idlogin) {
        this.idlogin = idlogin;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
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
    
}

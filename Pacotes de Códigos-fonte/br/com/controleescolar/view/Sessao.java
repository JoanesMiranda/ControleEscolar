/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controleescolar.view;

/**
 *
 * @author Joanes
 */
public class Sessao {
    
    static private String usuario;
    static  private String senha;

    public Sessao() {
    }

    public static void close(){
        usuario = "";
        senha = "";
    }
    public Sessao(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

    
    /**
     * @return the usuario
     */
    static public String getUsuario() {
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
    static public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}

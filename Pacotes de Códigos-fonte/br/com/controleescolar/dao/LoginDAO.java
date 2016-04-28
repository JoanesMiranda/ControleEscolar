/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controleescolar.dao;

import br.com.controleescolar.controller.Conexao;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Joanes
 */
public class LoginDAO extends Conexao{
    int idprofessor;
    public boolean loginUsuario(String usuario,String senha){
        boolean confirma = false;
        abrirBanco();
            try{
                execultaSQL("SELECT usuario,senha FROM login");
                while(rs.next()){
                    String user = rs.getString("usuario");
                    String password = rs.getString("senha");

                    if(usuario.equals(user) && senha.equals(password)){
                        confirma = true;
                    }else{
                        confirma = false;
                    }
                }
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"erro!! ao recuperar dados"+ex);
            }    
        fecharBanco();
        return confirma;
    }   
    
    //este codigo vai ser remanejado para outra classe "DAO".
    public int insertIdProfessor(){
        abrirBanco();
            try{
                execultaSQL("SELECT idprofessor FROM professor");
                while(rs.next()){
                    idprofessor = rs.getInt("idprofessor");
                }
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"erro!! ao recuperar dados"+ex);
            }    
        fecharBanco();
        return idprofessor;
    }   
}

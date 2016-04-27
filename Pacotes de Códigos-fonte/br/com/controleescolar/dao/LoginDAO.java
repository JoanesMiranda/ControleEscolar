/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controleescolar.dao;

import br.com.controleescolar.controller.Conexao;
import br.com.controleescolar.model.Login;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Joanes
 */
public class LoginDAO extends Conexao{
    
    private boolean loginUsuario(Login login){
        boolean confirma = false;
        abrirBanco();
            try{
                execultaSQL("select usuario,senha from login");

                while(rs.next()){
                    String user = rs.getString("usuario");
                    String password = rs.getString("senha");

                    if(login.getUsuario().equals(user) && login.getSenha().equals(password)){
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
}

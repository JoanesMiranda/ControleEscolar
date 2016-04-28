/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controleescolar.controller;

import br.com.controleescolar.model.Login;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Joanes
 */
public class CLogin extends Conexao{
    
    public void salvar(Login login){
        abrirBanco();
            try {
                PreparedStatement stm = conn.prepareStatement("INSERT INTO login(FK_Professor,"
                        + "senha,usuario)VALUES(?,?,?)");
                
                stm.setInt(1,login.getIdprofessor());
                stm.setString(2, login.getSenha());
                stm.setString(3, login.getUsuario());
                stm.execute();
                JOptionPane.showMessageDialog(null,"salvo com sucesso na tabela login");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"erro ao salvar em login"+ex.getMessage());
            }
        fecharBanco();
    }
}

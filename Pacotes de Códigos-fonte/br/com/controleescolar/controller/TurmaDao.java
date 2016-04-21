/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controleescolar.controller;

import br.com.controleescolar.model.Turma;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Joanes
 */
public class TurmaDao extends ConexaoDao{
    
    public void salvar(Turma turma){
        abrirBanco();
            try {
                PreparedStatement stm = conn.prepareStatement("INSERT INTO turma(nome)"
                        + "VALUES(?)");
                stm.setString(1, turma.getNome());
                stm.execute();
                //JOptionPane.showMessageDialog(null,"salvo com sucesso na tabela turma");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"erro ao salvar em turma"+ex.getMessage());
            }
        fecharBanco();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controleescolar.controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Suporte
 */
public class TurmaTemProfessorController extends Conexao{
    
     public void salvar(int idturma,int idprofessor){
           
        abrirBanco(); 
            try {
                PreparedStatement stm = conn.prepareStatement("INSERT INTO turma_has_professor(FK_Turma,FK_Professor) VALUES(?,?)");
                stm.setInt(1, idturma);
                stm.setInt(2, idprofessor);
                stm.execute();
                JOptionPane.showMessageDialog(null,"salvo com sucesso na tabela turma_has_professor");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"erro ao salvar em professor"+ex.getMessage());
            }
        fecharBanco();   
    }
}

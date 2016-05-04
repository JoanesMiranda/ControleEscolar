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
public class TurmaController extends Conexao{
    
    public void salvarTurma(Turma turma){
        
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
    
    public void pesquisarTurma(int cod){
        
        abrirBanco();
            try {
                PreparedStatement stm = conn.prepareStatement("SELECT * FROM turma WHERE COD = ?");
                stm.setInt(1,cod);
                stm.execute();
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null," não cadastrado na base de dados"+ex.getMessage());
           }
        fecharBanco();
    }
    
    public void apagarTuma(int cod){
        
        abrirBanco();
            try {
                PreparedStatement stm = conn.prepareStatement("DELETE FROM turma WHERE cod = ?");
                stm.setInt(1,cod);
                stm.execute();
                 //JOptionPane.showMessageDialog(null,"Dados apagados com sucesso");
             } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"erro ao apagar dados da tabela turma"+ex.getMessage());
             }
        fecharBanco();
    }
  
    public void atualizarTurma(int cod,String nome){
        abrirBanco();
            try {
                 PreparedStatement  stm = conn.prepareStatement("UPDATE turma SET nome = ? WHERE cod = ?");
                 stm.setString(1,nome);
                 stm.setInt(2,cod);
                 stm.executeUpdate();
                 //JOptionPane.showMessageDialog(null, "dados atulizados com sucesso");
             } catch (SQLException ex) {
                 JOptionPane.showMessageDialog(null, "Erro ao atulizar a tabela turma"+ex.getMessage());
             }
        fecharBanco();
    }   
}

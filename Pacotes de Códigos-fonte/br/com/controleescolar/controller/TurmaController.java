/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controleescolar.controller;

import br.com.controleescolar.model.Turma;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Joanes
 */
public class TurmaController extends Conexao{
    
    public void salvarTurma(Turma turma){
        
        abrirBanco();
            try {
                PreparedStatement stm = conn.prepareStatement("INSERT INTO turma(nome,codigo)"
                        + "VALUES(?,?)");
                stm.setString(1, turma.getNome());
                stm.setString(2, turma.getCodigo());
                stm.execute();
                //JOptionPane.showMessageDialog(null,"salvo com sucesso na tabela turma");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"erro ao salvar em turma"+ex.getMessage());
            }
        fecharBanco();
    }
    
    public String pesquisarTurma(String codigo){
        String nome = null;
        abrirBanco();
            try {
                PreparedStatement stm = conn.prepareStatement("SELECT nome FROM turma WHERE codigo = ?");
                stm.setString(1,codigo);
                ResultSet rs = stm.executeQuery();
                rs.first();
                nome = rs.getString("nome");
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null," não cadastrado na base de dados"+ex.getMessage());
           }
        fecharBanco();
        return nome;
    }
    
    public void apagarTuma(String codigo){
        
        abrirBanco();
            try {
                PreparedStatement stm = conn.prepareStatement("DELETE FROM turma WHERE codigo = ?");
                stm.setString(1,codigo);
                stm.execute();
                 //JOptionPane.showMessageDialog(null,"Dados apagados com sucesso");
             } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"erro ao apagar dados da tabela turma"+ex.getMessage());
             }
        fecharBanco();
    }
  
    public void atualizarTurma(String codigo,String nome){
        abrirBanco();
            try {
                 PreparedStatement  stm = conn.prepareStatement("UPDATE turma SET nome = ? WHERE codigo = ?");
                 stm.setString(1,nome);
                 stm.setString(2,codigo);
                 stm.executeUpdate();
                 //JOptionPane.showMessageDialog(null, "dados atulizados com sucesso");
             } catch (SQLException ex) {
                 JOptionPane.showMessageDialog(null, "Erro ao atulizar a tabela turma"+ex.getMessage());
             }
        fecharBanco();
    }
    
    public ArrayList pesquisaTodasTurmas(){
     
        ArrayList array = new ArrayList();
        abrirBanco();
        try {
            execultaSQL("SELECT nome FROM turma");
            rs.first();
            do{
                array.add(rs.getString("nome"));
            }while(rs.next());
                //JOptionPane.showMessageDialog(rootPane,"sucesso ao pegar o valor do banco!");
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"Nenhuma turma Cadastrada!  "+ex.getMessage());
        }    
        return array;
    }  
}

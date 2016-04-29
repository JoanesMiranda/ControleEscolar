/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controleescolar.controller;

import br.com.controleescolar.model.Professor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Joanes
 */
public class CProfessor extends Conexao{
    int idprofessor;
    String nome;
    
    public void salvar(Professor professor){
        abrirBanco();
            try {
                PreparedStatement stm = conn.prepareStatement("INSERT INTO professor(nome,matricula) VALUES(?,?)");
                stm.setString(1, professor.getNome());
                stm.setString(2, professor.getMatricula());
                stm.execute();
                JOptionPane.showMessageDialog(null,"salvo com sucesso na tabela professor");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"erro ao salvar em professor"+ex.getMessage());
            }
        fecharBanco();
    }
    public int insertIdProfessor(String matricula){
        abrirBanco();
            try{
                PreparedStatement stm = conn.prepareStatement("SELECT idprofessor FROM professor WHERE matricula =?");
                stm.setString(1, matricula);
                ResultSet rs = stm.executeQuery();
                rs.next();
                idprofessor = rs.getInt("idprofessor");
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"erro!! ao recuperar dados"+ex);
            }    
        fecharBanco();
        return idprofessor;
    }    
    
    public void exluirProfessor(String matricula){
        abrirBanco();
            try {
                PreparedStatement stm = conn.prepareStatement("DELETE login,professor FROM login INNER JOIN"
                        + " professor ON login.FK_Professor = professor.idprofessor"
                        + " WHERE login.usuario = ?");
                stm.setString(1,matricula);
                stm.execute();
                JOptionPane.showMessageDialog(null,"Excluido com sucesso na tabela professor");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"erro ao Exluir em professor"+ex.getMessage());
            }
        fecharBanco();
    }
    
    public String pesquisarProfessor(String matricula){
        abrirBanco();
            try{
                execultaSQL("SELECT nome FROM professor WHERE matricula = '"+matricula+"'");
                    rs.next();
                    nome = rs.getString("nome");
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"erro!! ao recuperar dados"+ex);
            }    
        fecharBanco();
        return nome;
    }  
    public void atualizaProfessor(String nome,String matricula){
        abrirBanco();
            try {
                PreparedStatement stm = conn.prepareStatement("UPDATE professor SET nome = ?"
                        + "WHERE matricula = ?" );
                stm.setString(1,nome);
                stm.setString(2,matricula);   
                stm.execute();
                JOptionPane.showMessageDialog(null,"dados atualizados com sucesso na tabela professor");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"erro ao atualizar em professor"+ex.getMessage());
            }
        fecharBanco();
        
    }   
}

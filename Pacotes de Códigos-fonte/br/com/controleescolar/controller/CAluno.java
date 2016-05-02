/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controleescolar.controller;

import br.com.controleescolar.model.Aluno;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Joanes
 */
public class CAluno extends Conexao{
    
    public void salvar(Aluno aluno){
        abrirBanco();
            try {
                PreparedStatement stm = conn.prepareStatement("INSERT INTO aluno(nome,matricula,codcartaoarduino)VALUES(?,?,?)");
                stm.setString(1, aluno.getNome());
                stm.setString(2, aluno.getMatricula());
                stm.setString(3, aluno.getCodcartaoarduino());
                stm.execute();
                JOptionPane.showMessageDialog(null,"salvo com sucesso na tabela aluno");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"erro ao salvar em aluno"+ex.getMessage());
            }
        fecharBanco();
    }    
    
    public void excluirAluno(String matricula){
        abrirBanco();
            try {
                PreparedStatement stm = conn.prepareStatement("DELETE aluno WHERE matricula = ?)");
                stm.setString(1, matricula);
                stm.execute();
                JOptionPane.showMessageDialog(null,"Exluido com sucesso na tabela aluno");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"erro ao salvar em aluno"+ex.getMessage());
            }
        fecharBanco();   
    }    
    
    public void atualizaAluno(String nome,String codcartaoarduino,String matricula){
        abrirBanco();
            try {
                PreparedStatement stm = conn.prepareStatement("UPDATE aluno SET nome = ?,codcadtaoarduno = ? WHERE matricula = ?)");
                stm.setString(1, nome);
                stm.setString(2, codcartaoarduino);
                stm.setString(3, matricula);
                stm.execute();
                //JOptionPane.showMessageDialog(null,"salvo com sucesso na tabela aluno");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"Dados atualizados"+ex.getMessage());
            }
        fecharBanco(); 
    }
    
    String nome;
    public String pesquisaNomeAluno(String matricula){
        abrirBanco();
        try {
            execultaSQL("SELECT nome FROM aluno");
            rs.first();
            nome = rs.getString("nome");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Pesquisa do nome realizada com sucesso"+ex.getMessage());
        }
        fecharBanco();
        return nome;
    }
    
    String codArduino;
    public String pesquisaNomeCodarduino(String matricula){
        abrirBanco();
        try {
            execultaSQL("SELECT * FROM aluno");
            rs.first();
            codArduino = rs.getString("codcartaoarduino");
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Pesquisa do codarduino realizada com sucesso"+ex.getMessage());
        }
        fecharBanco();
        return codArduino;
    }
       
}

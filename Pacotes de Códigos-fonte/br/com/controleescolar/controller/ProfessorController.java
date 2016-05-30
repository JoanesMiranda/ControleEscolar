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
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Joanes
 */
public class ProfessorController extends Conexao{
    
    public void salvar(Professor professor){
           
        abrirBanco(); 
            try {
                PreparedStatement stm = conn.prepareStatement("INSERT INTO professor(nome,matricula) VALUES(?,?)");
                stm.setString(1, professor.getNome());
                stm.setString(2, professor.getMatricula());
                stm.execute();
                //JOptionPane.showMessageDialog(null,"salvo com sucesso na tabela professor");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"erro ao salvar em professor"+ex.getMessage());
            }
        fecharBanco();   
    }
    
    public int insertIdProfessor(String matricula){
        int idprofessor = 0;
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
                PreparedStatement stm = conn.prepareStatement("DELETE  FROM professor WHERE  matricula = ?");
                stm.setString(1,matricula);
                stm.execute();
                JOptionPane.showMessageDialog(null,"Excluido com sucesso na tabela professor");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"erro ao Exluir em professor"+ex.getMessage());
            }
        fecharBanco();
    }
    
    public String pesquisarProfessorMatricula(String matricula){
        String nome = null;
        abrirBanco();
            try{
                execultaSQL("SELECT nome FROM professor WHERE matricula = '"+matricula+"'");
                rs.next();
                nome = rs.getString("nome");
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"O sistema não possui Professor cadastrado");
            }    
        fecharBanco();
        return nome;
    }  
    
    public String pesquisarProfessorLogin(String usuario,String senha){
        String nomeProfessor = null;
        abrirBanco();
            try{
                PreparedStatement stm = conn.prepareStatement("SELECT nome FROM login INNER JOIN"
                        + " professor ON login.FK_Professor = professor.idProfessor WHERE"
                        + " login.usuario = ? AND login.senha = ?");
                stm.setString(1,usuario);
                stm.setString(2,senha);
                ResultSet rs = stm.executeQuery();
                rs.first();
                nomeProfessor = rs.getString("nome");
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"erro!! ao recuperar dados"+ex);
            }    
        fecharBanco();
        return nomeProfessor;   
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
    
    public boolean pesquisaMatriculaCadastrada(String matricula){
        boolean valor = false;
        abrirBanco();
            try{
                execultaSQL("SELECT matricula FROM professor");
                while(rs.next()){
                    if(matricula.equals(rs.getString("matricula"))){
                    valor = true;
                }
             } 
            }catch(SQLException ex){
               JOptionPane.showMessageDialog(null,"erro ao retornar comparação de matricula"+ ex);
            }
        fecharBanco();
        return valor;
    }
    public ArrayList pesquisaTodosProfessores(){
     
        ArrayList array = new ArrayList();
        abrirBanco();
        try {
            execultaSQL("SELECT nome FROM professor");
            rs.first();
            do{
                array.add(rs.getString("nome"));
            }while(rs.next());
                //JOptionPane.showMessageDialog(rootPane,"sucesso ao pegar o valor do banco!");
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"Nenhum Professor Cadastrado!  "+ex.getMessage());
        }    
        return array;
    }  
    
    public int pesquisaProfessoreNome(String nome){
     
        int idProfessor = 0;
        abrirBanco();
        try {
            execultaSQL("SELECT idProfessor FROM professor WHERE nome = '"+nome+"'");
            rs.first();
            do{
                idProfessor = rs.getInt("idProfessor");
            }while(rs.next());
                //JOptionPane.showMessageDialog(rootPane,"sucesso ao pegar o valor do banco!");
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"Nenhum Professor Cadastrado!  "+ex.getMessage());
        }    
        return idProfessor;
    }  
    
    
    
    
        
}

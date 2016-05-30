/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controleescolar.controller;

import br.com.controleescolar.model.Aluno;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Joanes
 */
public class AlunoControleler extends Conexao{
    
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
                PreparedStatement stm = conn.prepareStatement("DELETE FROM aluno WHERE matricula = ?");
                stm.setString(1, matricula);
                stm.execute();
                JOptionPane.showMessageDialog(null,"Exluido com sucesso na tabela aluno");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"erro ao excuir o aluno"+ex.getMessage());
            }
        fecharBanco();   
    }    
    
    public void atualizaAluno(String nome,String codcartaoarduino,String matricula){
        abrirBanco();
            try {
                PreparedStatement stm = conn.prepareStatement("UPDATE aluno SET nome = ?,codcartaoarduino = ? WHERE"
                        + " matricula = ?");
                stm.setString(1, nome);
                stm.setString(2, codcartaoarduino);
                stm.setString(3, matricula);
                stm.execute();
                JOptionPane.showMessageDialog(null,"Dados Atualizados com Sucesso");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"Erro ao atualizar Dados"+ex.getMessage());
            }
        fecharBanco(); 
    }
   
    public ArrayList pesquisaAluno(String matricula){
        ArrayList arrayAluno = new ArrayList();
        abrirBanco();
        try {
            execultaSQL("SELECT nome,codcartaoarduino FROM aluno WHERE matricula = '"+ matricula+"'");
            rs.first();
            arrayAluno.add(rs.getString("nome"));
            arrayAluno.add(rs.getString("codcartaoarduino"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"O Sistema não Possui Alunos Cadastrado com o Codigo Digitado");
        }
        fecharBanco();
        return arrayAluno;
    }    
    public int insertIdAluno(String matricula){
        int idaluno = 0;
        abrirBanco();
            try{
                PreparedStatement stm = conn.prepareStatement("SELECT idAluno FROM aluno WHERE matricula =?");
                stm.setString(1, matricula);
                ResultSet rs = stm.executeQuery();
                rs.next();
                idaluno = rs.getInt("idAluno");
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"erro!! ao recuperar dados"+ex);
            }    
        fecharBanco();
        return idaluno;
    }      
    
    public ArrayList pesquisaTodosAlunos(String nomeTurma){
        ArrayList arrayAluno = new ArrayList();
        //String arrayAluno = null;
        abrirBanco();
        try {
            execultaSQL("SELECT nome FROM aluno WHERE idAluno IN"
                    + "(SELECT FK_Aluno FROM turma_has_aluno WHERE FK_Turma = "
                    + "(SELECT idTurma FROM turma WHERE nome = '"+nomeTurma+"'))");
            rs.first();
            do{
                arrayAluno.add(rs.getString("nome"));
            }while(rs.next());
            //JOptionPane.showMessageDialog(null,"Pesquisa realizada com sucesso em todos os alunos");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"erro na pesquisa de todos os alunos"+ex.getMessage());
        }
        fecharBanco();
        return arrayAluno;
    }   
    
    public int pesquisaIdAluno(String nome){
        int idaluno = 0;
        abrirBanco();
            try{
                PreparedStatement stm = conn.prepareStatement("SELECT idAluno FROM aluno WHERE nome =?");
                stm.setString(1, nome);
                ResultSet rs = stm.executeQuery();
                rs.next();
                idaluno = rs.getInt("idAluno");
                //JOptionPane.showMessageDialog(null,"id dao aluno recuperado com sucesso");
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"erro!! ao recuperar dados"+ex);
            }    
        fecharBanco();
        return idaluno;
    }    
     public int pesquisaIdAlunoArduino(String codArduino){
        int idaluno = 0;
        abrirBanco();
            try{
                PreparedStatement stm = conn.prepareStatement("SELECT idAluno FROM aluno WHERE codcartaoarduino = ?");
                stm.setString(1, codArduino);
                ResultSet rs = stm.executeQuery();
                rs.next();
                idaluno = rs.getInt("idAluno");
                //JOptionPane.showMessageDialog(null,"id dao aluno recuperado com sucesso");
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"erro!! ao recuperar dados"+ex);
            }    
        fecharBanco();
        return idaluno;
    }    
    
     public String pesquisaAlunos(String nomeTurma){
        String arrayAluno = null;
        abrirBanco();
        try {
            execultaSQL("SELECT nome FROM aluno WHERE idAluno IN"
                    + "(SELECT FK_Aluno FROM turma_has_aluno WHERE FK_Turma = "
                    + "(SELECT idTurma FROM turma WHERE nome = '"+nomeTurma+"'))");
            rs.first();
            do{
                arrayAluno = rs.getString("nome");
            }while(rs.next());
            //JOptionPane.showMessageDialog(null,"Pesquisa realizada com sucesso em todos os alunos");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"erro na pesquisa de todos os alunos"+ex.getMessage());
        }
        fecharBanco();
        return arrayAluno;
    }   
     
     
     
    
}

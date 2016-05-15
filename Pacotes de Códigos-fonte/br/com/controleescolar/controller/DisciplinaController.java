/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controleescolar.controller;

import br.com.controleescolar.model.Disciplina;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Joanes
 */
public class DisciplinaController extends Conexao{
    
    public void salvar(Disciplina disciplina){
        abrirBanco();
            try {
                PreparedStatement stm = conn.prepareStatement("INSERT INTO disciplina(nome,codigo,FK_Professor)"
                        + "VALUES(?,?,?)");
                stm.setString(1, disciplina.getNome());
                stm.setString(2, disciplina.getCodigo());
                stm.setInt(3, disciplina.getIdprofessor());
                stm.execute();
                JOptionPane.showMessageDialog(null,"salvo com sucesso na tabela disciplina");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"erro ao salvar em disciplina"+ex.getMessage());
            }
        fecharBanco();
    }
    
    public ArrayList pesquisaTodasDisciplinas(){
     
        ArrayList array = new ArrayList();
        abrirBanco();
        try {
            execultaSQL("SELECT nome FROM disciplina");
            rs.first();
            do{
                array.add(rs.getString("nome"));
            }while(rs.next());
                //JOptionPane.showMessageDialog(rootPane,"sucesso ao pegar o valor do banco!");
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"Nenhuma Disciplina Cadastrada!  "+ex.getMessage());
        }    
        return array;
    }  
    
    public int pesquisaIdProfessor(String nome) {
        int idProfessor = 0;
        abrirBanco();
        try {
            execultaSQL("SELECT idprofessor FROM professor WHERE nome = '"+nome+"'");
            rs.first();
            idProfessor = rs.getInt("idprofessor");
         } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"idprofessor não recuperado!  "+ex.getMessage());
        } 
        fecharBanco();
        return idProfessor;
    }
    
     public void deletaDisciplina(String codigo){
        abrirBanco();
            try {
                PreparedStatement stm = conn.prepareStatement("DELETE FROM disciplina WHERE codigo = ?");
                stm.setString(1, codigo);
                stm.execute();
                JOptionPane.showMessageDialog(null,"Dados Apagados com Sucesso...");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"erro ao apagar  em disciplina"+ex.getMessage());
            }
        fecharBanco();
    }
     public void atualizaDisciplina(String nome,int idprofessor,String codigo){
        abrirBanco();
            try {
                PreparedStatement stm = conn.prepareStatement("UPDATE disciplina SET nome = ?, FK_Professor = ? WHERE codigo = ?");
                stm.setString(1, nome);
                stm.setInt(2, idprofessor);
                stm.setString(3, codigo);
                stm.execute();
                JOptionPane.showMessageDialog(null,"Dados atualizados com sucesso...");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"erro ao atualizar  em disciplina"+ex.getMessage());
            }
        fecharBanco();
    }
    
      public ArrayList pesquisaDisciplina(String codigo){
        ArrayList array = new ArrayList();
        abrirBanco();
        try {
            execultaSQL("SELECT * FROM disciplina WHERE codigo = '"+codigo+"'" );
            rs.first();
            do{
                array.add(rs.getString("nome"));
                array.add(rs.getInt("FK_Professor"));
            }while(rs.next());
                //JOptionPane.showMessageDialog(rootPane,"sucesso ao pegar o valor do banco!");
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"Nenhuma Disciplina Cadastrada!  "+ex.getMessage());
        }    
        return array;
    }  
    
      public String pesquisaNomeProfessor(int idprofessor){
        String nomeProfessor = null;
        abrirBanco();
            try {
                execultaSQL("SELECT nome FROM professor WHERE idprofessor = '"+idprofessor+"'");
                rs.first();
                nomeProfessor = rs.getString("nome");
             } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"idprofessor não recuperado!  "+ex.getMessage());
            } 
        fecharBanco();
        return nomeProfessor;
      }
      
      public int insertIdDisciplina(String nome){
        int iddisciplina = 0;
        abrirBanco();
            try{
                PreparedStatement stm = conn.prepareStatement("SELECT idDisciplina FROM disciplina WHERE nome =?");
                stm.setString(1, nome);
                ResultSet rs = stm.executeQuery();
                rs.next();
                iddisciplina= rs.getInt("idDisciplina");
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"erro!! ao recuperar iddisciplina"+ex);
            }    
        fecharBanco();
        return iddisciplina;
    }      
    
    public ArrayList pesquisaDisciplinaProfessor(String nomeProfessor){
          
        ArrayList array = new ArrayList();
        abrirBanco();
            try {
                execultaSQL("SELECT nome FROM disciplina WHERE FK_Professor ="
                        + " (SELECT idProfessor FROM professor WHERE nome = '"+nomeProfessor+"')");
                rs.first();
                do{
                    array.add(rs.getString("nome"));
                }while(rs.next());
                    //JOptionPane.showMessageDialog(rootPane,"sucesso ao pegar o valor do banco!");
            } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null,"Nenhuma Disciplina Cadastrada!  "+ex.getMessage());
            } 
        fecharBanco();
        return array;   
      }
       
}

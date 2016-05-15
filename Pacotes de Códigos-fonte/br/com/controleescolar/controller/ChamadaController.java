/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controleescolar.controller;

import br.com.controleescolar.model.Chamada;
import java.sql.*;

import javax.swing.JOptionPane;

/**
 *
 * @author Joanes
 */
public class ChamadaController extends Conexao{

    public void salvar(Chamada chamada){
        abrirBanco();
            try {
                PreparedStatement stm = conn.prepareStatement("INSERT INTO chamada(faltas,data,FK_professor,FK_disciplina)"
                        + "VALUES(?,?,?,?)");
                stm.setString(1, chamada.getFaltas());
                stm.setString(2, chamada.getData());
                stm.setInt(3, chamada.getIdprofessor());
                stm.setInt(4, chamada.getIddisciplina());
                stm.execute();
                //JOptionPane.showMessageDialog(null,"salvo com sucesso na tabela chamada");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"erro ao salvar em chamada"+ex.getMessage());
            }
        fecharBanco();
    }
    
    public String pesquisaFaltas(String nomeAluno){
        //ArrayList array = new ArrayList();
        String array = null;
        abrirBanco();
            try {
                execultaSQL("SELECT faltas FROM chamada WHERE FK_Disciplina IN"
                        + "(SELECT FK_Disciplina FROM aluno_has_disciplina WHERE FK_aluno ="
                        + " (SELECT idAluno FROM aluno WHERE nome = '"+nomeAluno+"'))");
                rs.first();
                do{
                    array = rs.getString("faltas");
                }while(rs.next());
                    //JOptionPane.showMessageDialog(null,"sucesso ao pegar o valor do banco!");
            } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null,"Nenhuma falta Cadastrada!  "+ex.getMessage());
            } 
        fecharBanco();
        return array;   
    }
    
    
    public void atualizarChamada(Chamada chamada){
        abrirBanco();
            try {
                PreparedStatement stm = conn.prepareStatement("INSERT INTO chamada(faltas,FK_professor,FK_disciplina)"
                        + "VALUES(?,?,?)");
                stm.setString(1, chamada.getFaltas());
                stm.setInt(2, chamada.getIdprofessor());
                stm.setInt(3, chamada.getIddisciplina());
                stm.execute();
                //JOptionPane.showMessageDialog(null,"salvo com sucesso na tabela chamada");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"erro ao salvar em chamada"+ex.getMessage());
            }
        fecharBanco();
    }
     
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controleescolar.controller;

import br.com.controleescolar.model.Aluno;
import br.com.controleescolar.model.Disciplina;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Suporte
 */
public class AlunoTemDisciplinaController extends Conexao{
    
     
    public void salvar(Aluno aluno,Disciplina disciplina){
        abrirBanco();
            try {
                PreparedStatement stm = conn.prepareStatement("INSERT INTO AlunoTemDisciplinaController(FK_Aluno,FK_Disciplina)VALUES(?,?)");
                stm.setInt(1, aluno.getIdaluno());
                stm.setInt(2, disciplina.getIddisciplina());
                stm.execute();
                JOptionPane.showMessageDialog(null,"salvo com sucesso na tabela aluno");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"erro ao salvar em aluno"+ex.getMessage());
            }
        fecharBanco();
    }    
}

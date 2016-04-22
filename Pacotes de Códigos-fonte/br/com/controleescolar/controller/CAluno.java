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
                stm.setString(2, aluno.getCodcartaoarduino());
                stm.execute();
                //JOptionPane.showMessageDialog(null,"salvo com sucesso na tabela aluno");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"erro ao salvar em aluno"+ex.getMessage());
            }
        fecharBanco();
    }
}

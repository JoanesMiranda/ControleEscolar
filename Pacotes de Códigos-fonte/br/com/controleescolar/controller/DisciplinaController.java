/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controleescolar.controller;

import br.com.controleescolar.model.Disciplina;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
                        + "VALUES(?,?)");
                stm.setString(1, disciplina.getNome());
                stm.setString(2, disciplina.getCodigo());
                stm.setInt(3, disciplina.getIdprofessor());
                stm.execute();
                //JOptionPane.showMessageDialog(null,"salvo com sucesso na tabela disciplina");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"erro ao salvar em disciplina"+ex.getMessage());
            }
        fecharBanco();
    }
}

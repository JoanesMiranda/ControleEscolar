/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controleescolar.controller;

import br.com.controleescolar.model.Chamada;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Joanes
 */
public class CChamada extends Conexao{

    public void salvar(Chamada chamada){
        abrirBanco();
            try {
                PreparedStatement stm = conn.prepareStatement("INSERT INTO chamada(faltas,FK_professor,FK_disciplina)"
                        + "VALUES(?,?,?)");
                stm.setInt(1, chamada.getFaltas());
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

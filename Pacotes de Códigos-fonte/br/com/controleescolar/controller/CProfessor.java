/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controleescolar.controller;

import br.com.controleescolar.model.Professor;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Joanes
 */
public class CProfessor extends Conexao{
    int idprofessor;
    public void salvar(Professor professor){
        abrirBanco();
            try {
                PreparedStatement stm = conn.prepareStatement("INSERT INTO professor(nome) VALUES(?)");
                stm.setString(1, professor.getNome());
                stm.execute();
                JOptionPane.showMessageDialog(null,"salvo com sucesso na tabela professor");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"erro ao salvar em professor"+ex.getMessage());
            }
        fecharBanco();
    }
    public int insertIdProfessor(){
        abrirBanco();
            try{
                execultaSQL("SELECT idprofessor FROM professor");
                while(rs.next()){
                    idprofessor = rs.getInt("idprofessor");
                }
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"erro!! ao recuperar dados"+ex);
            }    
        fecharBanco();
        return idprofessor;
    }    
}

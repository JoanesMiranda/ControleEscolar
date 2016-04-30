/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controleescolar.controller;

import br.com.controleescolar.model.Login;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Joanes
 */
public class CLogin extends Conexao{
    
    //Salva as informações no Banco de dados - tabela(login)
    public void salvar(Login login){
        abrirBanco();
            try {
                PreparedStatement stm = conn.prepareStatement("INSERT INTO login(FK_Professor,"
                        + "senha,usuario)VALUES(?,?,?)");
                
                stm.setInt(1,login.getIdprofessor());
                stm.setString(2, login.getSenha());
                stm.setString(3, login.getUsuario());
                stm.execute();
                JOptionPane.showMessageDialog(null,"salvo com sucesso na tabela login");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"erro ao salvar em login"+ex.getMessage());
            }
        fecharBanco();
    }
    //Autentica login do usuario(professor), cadastrado no sistema
    public boolean loginUsuario(String usuario,String senha){
        boolean confirma = false;
        abrirBanco();
            try{
                 execultaSQL("SELECT usuario,senha FROM login");
                 rs.first();//pega os primeiros elementos da tabela
                do{
                    String user = rs.getString("usuario");
                    String password = rs.getString("senha");

                    if(usuario.equals(user) && senha.equals(password)){
                        confirma = true;
                    }
               }while(rs.next()); // pega os demais eleemntos da tabela
                
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"erro!! ao recuperar dados"+ex);
            }    
        fecharBanco();
        return confirma;
    } 
    //Pesquisa o usuario da tabela login e retorma para a interface do usuario
    String usuario;
    public String pesquisarLoginUsuario(int idprofessor){
        abrirBanco();
            try{
                execultaSQL("SELECT usuario FROM login WHERE FK_professor = '"+idprofessor+"'");
                    rs.next();
                    usuario = rs.getString("usuario");
                    //JOptionPane.showMessageDialog(null,"Pesquisa concluida");
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"erro!! ao recuperar dados"+ex);
            }    
        fecharBanco();
        return usuario;
    }  
    //Pesquisa o usuario da tabela login e retorma para a interface do usuario
    String senha;
    public String pesquisarLoginSenha(int idprofessor){
        abrirBanco();
            try{
                execultaSQL("SELECT senha FROM login WHERE FK_professor = '"+idprofessor+"'");
                    rs.next();
                    senha = rs.getString("senha");
                    //JOptionPane.showMessageDialog(null,"Pesquisa concluida");
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"erro!! ao recuperar dados"+ex);
            }    
        fecharBanco();
        return senha;
    }
    // altera o nome do usuario e senha do sistema
    public void atualizaLogin(String usuario,String senha,int idprofessor){
        abrirBanco();
            try {
                PreparedStatement stm = conn.prepareStatement("UPDATE login SET usuario = ?,senha = ?"
                        + "WHERE FK_Professor = ?" );
                stm.setString(1,usuario);
                stm.setString(2,senha);
                stm.setInt(3,idprofessor);
                stm.execute();
                JOptionPane.showMessageDialog(null,"dados atualizados com sucesso na tabela professor");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"erro ao atualizar em login"+ex.getMessage());
            }
        fecharBanco();
    }  
}


package br.com.controleescolar.controller;

import java.sql.*;
import javax.swing.JOptionPane;

public class ConexaoDao {
    
    public Statement stm;
    public ResultSet rs;
    String driver = "com.mysql.jdbc.Driver";
    private String caminho = "jdbc:mysql://localhost:3306/ControleEscolar";;
    private String usuario = "root";;
    private String senha = "root";;
    public Connection conn;
    
    public void abrirBanco() {
        
        try {
            System.setProperty("jdbc.drivers", driver);
            conn = DriverManager.getConnection(caminho,usuario,senha);
            //JOptionPane.showMessageDialog(null,"conexão realizada com sucesso!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"erro ao conectar com o BD!!"+ex.getMessage());
        }     
    }
    public void execultaSQL(String sql){
        try {
            stm = conn.createStatement(rs.TYPE_SCROLL_SENSITIVE,rs.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"erro ao execultarSQL"+ex.getMessage());
        }
       
    }
    
    public void fecharBanco() {
    
        try {
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"erro ao fechar o BD!!"+ex.getMessage());
        }
    }   
}

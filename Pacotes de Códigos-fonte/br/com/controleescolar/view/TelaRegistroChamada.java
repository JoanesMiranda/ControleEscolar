/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controleescolar.view;

import br.com.controleescolar.controller.AlunoControleler;
import br.com.controleescolar.controller.ChamadaController;
import br.com.controleescolar.controller.DisciplinaController;
import br.com.controleescolar.controller.ProfessorController;
import br.com.controleescolar.controller.TurmaController;
import br.com.controleescolar.model.Chamada;
import javax.swing.table.DefaultTableModel;
//import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Joanes
 */
public class TelaRegistroChamada extends javax.swing.JFrame {

    /**
     * Creates new form TelaRegistroChamada
     */
    public TelaRegistroChamada() {
        
        initComponents();
   
        //seleciona o nome do professor logado no sistema e exibe na tela de registro de chamada
        if(!Sessao.getUsuario().isEmpty()){
           ProfessorController cprofessor = new ProfessorController();
           String usuario = Sessao.getUsuario();
           String senha = Sessao.getSenha();
           jTextFieldNomeProfessor.setText(cprofessor.pesquisarProfessorLogin(usuario,senha));
        }
        
        //Pesquisa todas as turmas salvas no BD e insere no "jComboBoxSelecionarTurma".
        //está funcionando normalmente
        TurmaController turmaC = new TurmaController();
        jComboBoxSelecionarTurma.removeAllItems();
        
        if(!turmaC.retornaTurmaHasProfessor(jTextFieldNomeProfessor.getText()).isEmpty()){
           for(int i = 0; i< turmaC.retornaTurmaHasProfessor(jTextFieldNomeProfessor.getText()).size(); i++){
                jComboBoxSelecionarTurma.addItem((String) turmaC.retornaTurmaHasProfessor(jTextFieldNomeProfessor.getText()).get(i));
           }
        }
        //mostra todas as diciplinas cadastradas com o professor
        DisciplinaController disciplinaC = new DisciplinaController();
        jComboBoxDisciplina.removeAllItems();
        
        if(!disciplinaC.pesquisaDisciplinaProfessor(jTextFieldNomeProfessor.getText()).isEmpty()){
           for(int i = 0; i< disciplinaC.pesquisaDisciplinaProfessor(jTextFieldNomeProfessor.getText()).size(); i++){
                jComboBoxDisciplina.addItem((String) disciplinaC.pesquisaDisciplinaProfessor(jTextFieldNomeProfessor.getText()).get(i));
           }
        }    
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldNomeProfessor = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButtonSalvar = new javax.swing.JButton();
        jComboBoxSelecionarTurma = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableNomesDosAlunos = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jComboBoxDisciplina = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registro de Frequência Escolar");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setText("Nome do Professor:");

        jTextFieldNomeProfessor.setEditable(false);
        jTextFieldNomeProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomeProfessorActionPerformed(evt);
            }
        });

        jLabel2.setText("Resgistro do dia: ");

        jLabel5.setFont(new java.awt.Font("Bookman Old Style", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 255));
        jLabel5.setText("Registro de Frequência Escolar");

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jComboBoxSelecionarTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSelecionarTurmaActionPerformed(evt);
            }
        });

        jLabel3.setText("Selecionar Turma");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/logouepbmenor.png"))); // NOI18N

        jButton2.setText("Editar");

        jButton3.setForeground(new java.awt.Color(255, 51, 51));
        jButton3.setText("Cancelar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel4.setText("Alunos Matriculados na Turma :");

        jTableNomesDosAlunos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nomes dos Alunos", "Faltas"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableNomesDosAlunos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableNomesDosAlunosMouseClicked(evt);
            }
        });
        jTableNomesDosAlunos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTableNomesDosAlunosKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTableNomesDosAlunos);
        if (jTableNomesDosAlunos.getColumnModel().getColumnCount() > 0) {
            jTableNomesDosAlunos.getColumnModel().getColumn(1).setResizable(false);
            jTableNomesDosAlunos.getColumnModel().getColumn(1).setPreferredWidth(1);
        }

        jLabel7.setText("Disciplina");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldNomeProfessor)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxSelecionarTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxDisciplina, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(40, 40, 40))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jLabel4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonSalvar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(125, 125, 125))))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton2, jSeparator2});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton3, jSeparator3});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonSalvar, jSeparator1});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextFieldNomeProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBoxSelecionarTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jComboBoxDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(jLabel4)
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jButton3)
                        .addGap(9, 9, 9)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jComboBoxSelecionarTurma, jLabel3});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(581, 537));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxSelecionarTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSelecionarTurmaActionPerformed
         //aqui
        DefaultTableModel NomesDosAlunos = (DefaultTableModel) jTableNomesDosAlunos.getModel();
     
        AlunoControleler alunoC = new AlunoControleler();
        ChamadaController chamadaC = new ChamadaController();
        
        alunoC.pesquisaTodosAlunos((String) jComboBoxSelecionarTurma.getSelectedItem());
        
        if(!alunoC.pesquisaTodosAlunos((String) jComboBoxSelecionarTurma.getSelectedItem()).isEmpty()){
            NomesDosAlunos.getDataVector().removeAllElements();
           for(int i = 0; i < alunoC.pesquisaTodosAlunos((String) jComboBoxSelecionarTurma.getSelectedItem()).size(); i++){
               Object[] nomes = {alunoC.pesquisaTodosAlunos((String) jComboBoxSelecionarTurma.getSelectedItem()).get(i),
               chamadaC.pesquisaFaltas((String) alunoC.pesquisaTodosAlunos((String) jComboBoxSelecionarTurma.getSelectedItem()).get(i))};
               NomesDosAlunos.addRow(nomes);
           }
        }  
   
    }//GEN-LAST:event_jComboBoxSelecionarTurmaActionPerformed

    private void jTextFieldNomeProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomeProfessorActionPerformed
      
    }//GEN-LAST:event_jTextFieldNomeProfessorActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    }//GEN-LAST:event_formWindowClosed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTableNomesDosAlunosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableNomesDosAlunosMouseClicked
        
        
    }//GEN-LAST:event_jTableNomesDosAlunosMouseClicked

    private void jTableNomesDosAlunosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableNomesDosAlunosKeyPressed
        
    }//GEN-LAST:event_jTableNomesDosAlunosKeyPressed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        DisciplinaController disciplina = new DisciplinaController();
        
        int valores = jTableNomesDosAlunos.getSelectedRow();
       
        Chamada chamada = new Chamada((String) jTableNomesDosAlunos.getModel().getValueAt(valores, 1),
                disciplina.pesquisaIdProfessor(jTextFieldNomeProfessor.getText()),
                disciplina.insertIdDisciplina((String) jComboBoxDisciplina.getSelectedItem()) );
        ChamadaController chamadaC = new ChamadaController();
        chamadaC.salvar(chamada);
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaRegistroChamada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaRegistroChamada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaRegistroChamada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaRegistroChamada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaRegistroChamada().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JComboBox<String> jComboBoxDisciplina;
    private javax.swing.JComboBox<String> jComboBoxSelecionarTurma;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable jTableNomesDosAlunos;
    private javax.swing.JTextField jTextFieldNomeProfessor;
    // End of variables declaration//GEN-END:variables
}

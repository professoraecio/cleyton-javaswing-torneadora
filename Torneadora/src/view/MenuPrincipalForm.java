/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import connection.FabricaConexao;
import controller.BancoDao;
import main.Principal;
import util.Alexa;

/**
 *
 * @author Admin
 */
public class MenuPrincipalForm extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipalForm
     */
    public MenuPrincipalForm() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gerenciarClientesButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        factoryModeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        gerenciarClientesButton.setText("GERENCIAR CLIENTES");
        gerenciarClientesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gerenciarClientesButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("MENU PRINCIPAL");

        factoryModeButton.setText("VOLTAR APLICAÇÃO AO MODO DE FÁBRICA (RE-CRIAR BANCO E ZERAR DADOS)");
        factoryModeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                factoryModeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(gerenciarClientesButton))
                .addContainerGap(1056, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(factoryModeButton)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gerenciarClientesButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 656, Short.MAX_VALUE)
                .addComponent(factoryModeButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void gerenciarClientesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gerenciarClientesButtonActionPerformed
        // TODO add your handling code here:
        MenuClientesForm menuClientesForm = new MenuClientesForm();
        menuClientesForm.setVisible(true);
        menuClientesForm.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_gerenciarClientesButtonActionPerformed

    private void factoryModeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_factoryModeButtonActionPerformed
        // TODO add your handling code here:
        FabricaConexao.resetDB(); // mudar de banco
        BancoDao bancoDao = new BancoDao();
        bancoDao.voltarModoDeFabrica(); // apagar banco de dados da torneadora
        Principal.criarBancoETabelas(); // re-criar tabelas
        FabricaConexao.setDefaultDB(); // voltar ao banco principal
        Alexa.escrevaJanela("Todos os dados do sistema foram apagados!");
    }//GEN-LAST:event_factoryModeButtonActionPerformed

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
            java.util.logging.Logger.getLogger(MenuPrincipalForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipalForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipalForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipalForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipalForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton factoryModeButton;
    private javax.swing.JButton gerenciarClientesButton;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}

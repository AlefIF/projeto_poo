/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

/**
 *
 * @author LUCASP
 */
public class FRMPrincipalFun extends javax.swing.JFrame {

    /**
     * Creates new form FRMPrincipal
     */
    public FRMPrincipalFun() {
        initComponents();
        setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btRVenda = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jbGerenciarCategoria = new javax.swing.JButton();
        jbGerenciarConsole = new javax.swing.JButton();
        btERelatorios = new javax.swing.JButton();
        btGCliente = new javax.swing.JButton();
        btGJogo = new javax.swing.JButton();
        btRTransacao = new javax.swing.JButton();
        btSair = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Funcionário");

        btRVenda.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btRVenda.setText("Realizar Venda");
        btRVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRVendaActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Opções:");

        jbGerenciarCategoria.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jbGerenciarCategoria.setText("Gerenciar Categoria");
        jbGerenciarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGerenciarCategoriaActionPerformed(evt);
            }
        });

        jbGerenciarConsole.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jbGerenciarConsole.setText("Gerenciar Console");
        jbGerenciarConsole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGerenciarConsoleActionPerformed(evt);
            }
        });

        btERelatorios.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btERelatorios.setText("Emitir Relatórios");
        btERelatorios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btERelatoriosActionPerformed(evt);
            }
        });

        btGCliente.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btGCliente.setText("Gerenciar clientes");
        btGCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGClienteActionPerformed(evt);
            }
        });

        btGJogo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btGJogo.setText("Gerenciar Jogos");
        btGJogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGJogoActionPerformed(evt);
            }
        });

        btRTransacao.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btRTransacao.setText("Aluguel/Devolução");
        btRTransacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRTransacaoActionPerformed(evt);
            }
        });

        btSair.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Visao/icons/Botões/JButtonLogin.png"))); // NOI18N
        btSair.setText("Sair");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Visao/icons/Interface gráfica/logo3.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 198, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(131, 131, 131)
                                .addComponent(btSair, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbGerenciarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btERelatorios, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btGCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btRVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(251, 251, 251)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jbGerenciarConsole, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btRTransacao, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btGJogo, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btSair, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btGCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btRVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbGerenciarConsole, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btRTransacao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(btGJogo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbGerenciarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btERelatorios, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(595, 436));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        FRMLogin login = new FRMLogin();
        FRMLogin.user = null;
        this.dispose();

        login.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_btSairActionPerformed

    private void btGClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGClienteActionPerformed
        FRMCliente cliente = new FRMCliente();
        this.dispose();
        cliente.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_btGClienteActionPerformed

    private void btGJogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGJogoActionPerformed
        FRMJogo jogo = new FRMJogo();
        this.dispose();
        jogo.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_btGJogoActionPerformed

    private void btRTransacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRTransacaoActionPerformed
        FRMTransacao trans = new FRMTransacao();
        this.dispose();
        trans.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_btRTransacaoActionPerformed

    private void btERelatoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btERelatoriosActionPerformed
        FRMEmitirRelatorios er = new FRMEmitirRelatorios();
        this.dispose();
        er.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_btERelatoriosActionPerformed

    private void jbGerenciarConsoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGerenciarConsoleActionPerformed
        FRMConsole console = new FRMConsole();
        this.dispose();
        console.setVisible(true);
    }//GEN-LAST:event_jbGerenciarConsoleActionPerformed

    private void jbGerenciarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGerenciarCategoriaActionPerformed
        FRMCategoria cat = new FRMCategoria();
        this.dispose();
        cat.setVisible(true);
    }//GEN-LAST:event_jbGerenciarCategoriaActionPerformed

    private void btRVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRVendaActionPerformed
        FRMVenda_1 frm = new FRMVenda_1();
        frm.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_btRVendaActionPerformed

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
            java.util.logging.Logger.getLogger(FRMPrincipalFun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FRMPrincipalFun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FRMPrincipalFun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FRMPrincipalFun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FRMPrincipalFun().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btERelatorios;
    private javax.swing.JButton btGCliente;
    private javax.swing.JButton btGJogo;
    private javax.swing.JButton btRTransacao;
    private javax.swing.JButton btRVenda;
    private javax.swing.JButton btSair;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton jbGerenciarCategoria;
    private javax.swing.JButton jbGerenciarConsole;
    // End of variables declaration//GEN-END:variables
}

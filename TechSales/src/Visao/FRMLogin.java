/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Controle.CaixaControle;
import Controle.EmpregoControle;
import Controle.LucroControle;
import Controle.VendedorControle;
import Modelo.CaixaBEAN;
import Modelo.EmpregoBEAN;
import Modelo.LucroBEAN;
import Modelo.VendedorBEAN;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author LUCASP
 */
public class FRMLogin extends javax.swing.JFrame {

    static VendedorBEAN user = new VendedorBEAN();
    VendedorControle vc = new VendedorControle();
    ArrayList<VendedorBEAN> al = vc.listarALL();
    CaixaControle caixaC = new CaixaControle();
    LucroControle lucC = new LucroControle();
    EmpregoControle cEmp = new EmpregoControle();

    /**
     * Creates new form FRMLogin
     */
    public FRMLogin() {
        setResizable(false);
        initComponents();

        //Cadastro Caixa
        int qtc = 0;
        for (CaixaBEAN c : caixaC.listarALL()) {
            qtc++;
        }
        if (qtc == 0) {
            CaixaBEAN a = new CaixaBEAN();
            a.setCaixaDinheiro(0);
            caixaC.cadastrar(a);
        }

        //Cadastro Lucro
        int qtl = 0;
        for (LucroBEAN l : lucC.listarALL()) {
            qtl++;
        }

        if (qtl == 0) {
            LucroBEAN b = new LucroBEAN();
            b.setLucPorcentagem(10);
            lucC.cadastrar(b);
        }

        //Cadastro Emprego
        int qte = 0;
        for (EmpregoBEAN e : cEmp.listarALL()) {
            qte++;
        }

        if (qte == 0) {
            EmpregoBEAN emp = new EmpregoBEAN();
            emp.setEmpNome("Vendedor");
            emp.setEmpSalarioPadrao(1000);
            emp.setEmpDescricao("Tem acesso à parte de Funcionarios do sistema");
            cEmp.cadastrar(emp);

            EmpregoBEAN emp2 = new EmpregoBEAN();
            emp.setEmpNome("Administrador");
            emp.setEmpSalarioPadrao(3000);
            emp.setEmpDescricao("Tem acesso à parte de Administrador do sistema");
            cEmp.cadastrar(emp2);
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

        tfSenha = new javax.swing.JPasswordField();
        tfUser = new javax.swing.JTextField();
        rbSenha = new javax.swing.JRadioButton();
        btSairPrograma = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(600, 300));
        setSize(new java.awt.Dimension(600, 300));
        getContentPane().setLayout(null);
        getContentPane().add(tfSenha);
        tfSenha.setBounds(200, 190, 120, 30);
        getContentPane().add(tfUser);
        tfUser.setBounds(200, 150, 120, 30);

        rbSenha.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        rbSenha.setText("Visualizar Senha");
        rbSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbSenhaActionPerformed(evt);
            }
        });
        getContentPane().add(rbSenha);
        rbSenha.setBounds(130, 230, 190, 23);

        btSairPrograma.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btSairPrograma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Visao/icons/Botões/JButtonFechar.png"))); // NOI18N
        btSairPrograma.setText("Fechar");
        btSairPrograma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairProgramaActionPerformed(evt);
            }
        });
        getContentPane().add(btSairPrograma);
        btSairPrograma.setBounds(373, 10, 100, 30);

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setText("Usuário:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(130, 160, 60, 20);

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setText("Senha:");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(130, 200, 60, 15);

        jButton3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton3.setText("Entrar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(200, 270, 90, 30);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Visao/icons/Interface gráfica/logo3.png"))); // NOI18N
        getContentPane().add(jLabel7);
        jLabel7.setBounds(170, 30, 160, 94);

        setSize(new java.awt.Dimension(501, 362));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void rbSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbSenhaActionPerformed
        if (rbSenha.isSelected()) {
            tfSenha.setEchoChar((char) 0);
        } else {

            tfSenha.setEchoChar('*');
        }
    }//GEN-LAST:event_rbSenhaActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String nome = tfUser.getText();
        String senha = tfSenha.getText();
        int i = 0;
        for (VendedorBEAN vendedor : al) {
            if (vendedor.getVenNomeUsuario().equals(nome) && vendedor.getVenSenha().equals(senha)) {
                if (vendedor.getFuncionario().getFunTrabalho().equals("Administrador")) {
                    user = vendedor;
                    FRMMenuADM fun = new FRMMenuADM();
                    this.dispose();
                    fun.setVisible(true);
                    i++;
                } else {
                    user = vendedor;
                    FRMMenuVendedor fun = new FRMMenuVendedor();
                    this.dispose();
                    fun.setVisible(true);
                    i++;
                }
            }
        }
        if (i == 0) {
            if (nome.equals("ADM") && (senha.equals("ADM"))) {
                FRMMenuADM adm = new FRMMenuADM();
                this.dispose();
                adm.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Usuário  não encontrado!");
            }
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void btSairProgramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairProgramaActionPerformed
        System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_btSairProgramaActionPerformed

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
            java.util.logging.Logger.getLogger(FRMLogin.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FRMLogin.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FRMLogin.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FRMLogin.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FRMLogin().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSairPrograma;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton rbSenha;
    private javax.swing.JPasswordField tfSenha;
    private javax.swing.JTextField tfUser;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Controle.CaixaControle;
import Controle.ClienteControle;
import Controle.EmpregoControle;
import Controle.LucroControle;
import Controle.RelLocalControle;
import Controle.VendedorControle;
import Modelo.CaixaBEAN;
import Modelo.ClienteBEAN;
import Modelo.EmpregoBEAN;
import Modelo.LocalRelatoriosBEAN;
import Modelo.LucroBEAN;
import Modelo.VendedorBEAN;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author LUCASP
 */
public class FRMLogin extends javax.swing.JFrame {

    public static VendedorBEAN user = new VendedorBEAN();
    private VendedorControle vc = new VendedorControle();
    private ArrayList<VendedorBEAN> al = vc.listarALL();
    private CaixaControle caixaC = new CaixaControle();
    private LucroControle lucC = new LucroControle();
    private EmpregoControle cEmp = new EmpregoControle();
    private RelLocalControle relC = new RelLocalControle();
    private ClienteControle conCli = new ClienteControle();

    /**
     * Creates new form FRMLogin
     */
    public FRMLogin() {
        setResizable(false);
        initComponents();
        this.setLocationRelativeTo(null);
        /*
        //Cadastro localRelatorios        
        int qtLR = 0;
        for (LocalRelatoriosBEAN rl : relC.listarALL()) {
            qtLR++;
        }
        if (qtLR == 0) {
            LocalRelatoriosBEAN rl1 = new LocalRelatoriosBEAN();
            rl1.setRelLocal("/desktop");
            relC.cadastrar(rl1);
        }
         */
 /*
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
                  
            EmpregoBEAN emp2 = new EmpregoBEAN();
            emp2.setEmpNome("Administrador");
            emp2.setEmpSalarioPadrao(3000);
            emp2.setEmpDescricao("Tem acesso à parte de Administrador do sistema");
            cEmp.cadastrar(emp2);
            
            EmpregoBEAN emp = new EmpregoBEAN();
            emp.setEmpNome("Vendedor");
            emp.setEmpSalarioPadrao(1000);
            emp.setEmpDescricao("Tem acesso à parte de Funcionarios do sistema");
            cEmp.cadastrar(emp);

        }
         */
        //Cadastro cliente à vista
        int qtdCli = 0;
        for (ClienteBEAN c : conCli.listarALL()) {
            qtdCli++;
        }

        if (qtdCli == 0) {
            ClienteBEAN a = new ClienteBEAN();
            a.setCliCodigo(1);
            a.setCliNome("Cliente à vista");
            conCli.cadastrar(a);
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

        rbSenha.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        rbSenha.setText("Visualizar Senha");
        rbSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbSenhaActionPerformed(evt);
            }
        });

        btSairPrograma.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btSairPrograma.setText("Fechar");
        btSairPrograma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairProgramaActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setText("Usuário:");

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setText("Senha:");

        jButton3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton3.setText("Login");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Visao/icons/Interface gráfica/logo3.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btSairPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(tfUser, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rbSenha)
                                    .addComponent(tfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(39, 39, 39))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(64, 64, 64))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfUser, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel9))
                    .addComponent(tfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(rbSenha)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSairPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(312, 322));
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
        String admL = "Administrador";

        int i = 0;
        if (nome.equals("ADM") && (senha.equals("ADM"))) {
            if (al.size() == 0) {
                FRMMenuADM adm = new FRMMenuADM();
                this.dispose();
                adm.setVisible(true);
            } else {
                System.out.println("Essa configuração de Senha só pode ser usada se não existir Administrador caadstrado");
            }
            i++;
        }
        for (VendedorBEAN vendedor : al) {
            if (vendedor.getVendedorNomeUsuario().equals(nome) && vendedor.getVendedorSenha().equals(senha)) {
                if (vendedor.getFuncionario().getEmprego().getEmpNome().equals(admL)) {
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
            JOptionPane.showMessageDialog(null, "Usuário  não encontrado!");
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

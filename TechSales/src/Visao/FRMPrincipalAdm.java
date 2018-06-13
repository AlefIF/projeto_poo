/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Controle.FuncionarioControle;

import Modelo.FuncionarioBEAN;
import Modelo.FuncionarioDAO;
import java.awt.Color;
import static java.awt.Color.BLACK;
import static java.awt.Color.GRAY;
import java.sql.SQLException;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LUCASP
 */
public class FRMPrincipalAdm extends javax.swing.JFrame {

    private ArrayList<FuncionarioBEAN> userD;
    private DefaultTableModel tbUsers;
    FuncionarioControle ct = new FuncionarioControle();

    /**
     * Creates new form FRMAdm
     */
    public FRMPrincipalAdm() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        this.preencheTabela();

    }

    private void preencheTabela() {
        tbUsers = this.criaTabela();
        tbUsers.addColumn("Código");
        tbUsers.addColumn("Nome");
        tbUsers.addColumn("telefone");
        tbUsers.addColumn("endereco");
        tbUsers.addColumn("nisPis");
        tbUsers.addColumn("CPF");
        tbUsers.addColumn("idade");
        tbUsers.addColumn("nomeUsuario");
        tbUsers.addColumn("senha");

        userD = ct.listarALL();

        for (FuncionarioBEAN d : userD) {
            tbUsers.addRow(new Object[]{
                d.getCodigo(),
                d.getNome(),
                d.getTelefone(),
                d.getEndereco(),
                d.getNisPis(),
                d.getCpf(),
                d.getIdade(),
                d.getNomeUsuario(),
                d.getSenha(),});
        }
        //set o modelo da tabela
        tbPesquisa.setModel(tbUsers);
    }

    private void limparCampos() {
        lbCodigo.setText("");
        tfNomeFun.setText("");
        tfCpfFun.setText("");
        tfEnderecoFun.setText("");
        tfNomeUserFun.setText("");
        tfIdadeFun.setText("");
        tfNPFun.setText("");
        tfTelefoneFun.setText("");
        tfSenhaUserFun.setText("");
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
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        tfNomeFun = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfEnderecoFun = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfNomeUserFun = new javax.swing.JTextField();
        jbEditarFun = new javax.swing.JToggleButton();
        jbExcluirFun = new javax.swing.JToggleButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tfNPFun = new javax.swing.JFormattedTextField();
        tfCpfFun = new javax.swing.JFormattedTextField();
        tfTelefoneFun = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        lbCodigo = new javax.swing.JLabel();
        tfSenhaUserFun = new javax.swing.JPasswordField();
        tfIdadeFun = new javax.swing.JTextField();
        jbCadastrarFun = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbPesquisa = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        tfPesquisaFun = new javax.swing.JTextField();
        btSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Administrador");
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setText("Nome:");

        jLabel2.setText("Endereço:");

        jLabel3.setText("Nome de usuário:");

        jbEditarFun.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Visao/icons/Botões/JButtonEdit.png"))); // NOI18N
        jbEditarFun.setText("Editar");
        jbEditarFun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditarFunActionPerformed(evt);
            }
        });

        jbExcluirFun.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Visao/icons/Botões/JButtonDeletarFun.png"))); // NOI18N
        jbExcluirFun.setText("Excluir");
        jbExcluirFun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirFunActionPerformed(evt);
            }
        });

        jLabel4.setText("Senha:");

        jLabel5.setText("CPF:");

        jLabel6.setText("Telefone:");

        jLabel7.setText("Idade:");

        jLabel10.setText("NIS/PIS:");

        try{
            javax.swing.text.MaskFormatter nis= new javax.swing.text.MaskFormatter("###.#####.##-#");
            tfNPFun = new javax.swing.JFormattedTextField(nis);
        }
        catch (Exception e){
        }

        try{
            javax.swing.text.MaskFormatter cpf= new javax.swing.text.MaskFormatter("###.###.###-##");
            tfCpfFun = new javax.swing.JFormattedTextField(cpf);
        }
        catch (Exception e){
        }

        try{
            javax.swing.text.MaskFormatter tel= new javax.swing.text.MaskFormatter("(##)# ####-####");
            tfTelefoneFun = new javax.swing.JFormattedTextField(tel);
        }
        catch (Exception e){
        }

        jLabel11.setText("Código:");

        lbCodigo.setText("...");

        tfIdadeFun.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfIdadeFunKeyTyped(evt);
            }
        });

        jbCadastrarFun.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Visao/icons/Botões/JButtonAddFun.png"))); // NOI18N
        jbCadastrarFun.setText("Cadastrar");
        jbCadastrarFun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCadastrarFunActionPerformed(evt);
            }
        });

        tbPesquisa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbPesquisa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbPesquisaMouseClicked(evt);
            }
        });
        tbPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbPesquisaKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tbPesquisa);

        jLabel13.setText("Buscar:");

        tfPesquisaFun.setForeground(new java.awt.Color(204, 204, 204));
        tfPesquisaFun.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfPesquisaFunFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfPesquisaFunFocusLost(evt);
            }
        });
        tfPesquisaFun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPesquisaFunActionPerformed(evt);
            }
        });
        tfPesquisaFun.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfPesquisaFunKeyTyped(evt);
            }
        });

        btSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Visao/icons/Botões/JButtonLogin.png"))); // NOI18N
        btSair.setText("Sair");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(lbCodigo)
                        .addGap(233, 233, 233)
                        .addComponent(btSair, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1)
                        .addGap(36, 36, 36)
                        .addComponent(tfNomeFun, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(tfIdadeFun, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(tfCpfFun, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel10)
                        .addGap(10, 10, 10)
                        .addComponent(tfNPFun, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(tfEnderecoFun, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel6)
                        .addGap(4, 4, 4)
                        .addComponent(tfTelefoneFun, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel3)
                        .addGap(10, 10, 10)
                        .addComponent(tfNomeUserFun, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(tfSenhaUserFun, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jbCadastrarFun)
                        .addGap(29, 29, 29)
                        .addComponent(jbEditarFun, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(jbExcluirFun))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel13)
                        .addGap(49, 49, 49)
                        .addComponent(tfPesquisaFun, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(lbCodigo)
                    .addComponent(btSair, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfNomeFun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel7)
                            .addComponent(tfIdadeFun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfCpfFun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNPFun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel10))))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tfEnderecoFun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(tfTelefoneFun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfNomeUserFun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(tfSenhaUserFun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbCadastrarFun)
                    .addComponent(jbEditarFun)
                    .addComponent(jbExcluirFun))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel13))
                    .addComponent(tfPesquisaFun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(-1, 0, 440, 490);

        setSize(new java.awt.Dimension(453, 526));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        FRMLogin login = new FRMLogin();
        this.dispose();
        login.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_btSairActionPerformed

    private void tfPesquisaFunKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPesquisaFunKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPesquisaFunKeyTyped

    private void tfPesquisaFunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPesquisaFunActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPesquisaFunActionPerformed

    private void tfPesquisaFunFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfPesquisaFunFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPesquisaFunFocusLost

    private void tfPesquisaFunFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfPesquisaFunFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPesquisaFunFocusGained

    private void tbPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbPesquisaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tbPesquisaKeyReleased

    private void tbPesquisaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPesquisaMouseClicked
        limparCampos();

        if (tbPesquisa.getSelectedRow() != -1) {
            if (Integer.parseInt(tbPesquisa.getValueAt(tbPesquisa.getSelectedRow(), 8).toString()) > 0) {
                lbCodigo.setText(tbPesquisa.getValueAt(tbPesquisa.getSelectedRow(), 0).toString());
                tfNomeFun.setText(tbPesquisa.getValueAt(tbPesquisa.getSelectedRow(), 1).toString());
                tfTelefoneFun.setText(tbPesquisa.getValueAt(tbPesquisa.getSelectedRow(), 2).toString());
                tfEnderecoFun.setText((tbPesquisa.getValueAt(tbPesquisa.getSelectedRow(), 3).toString()));
                tfNPFun.setText((tbPesquisa.getValueAt(tbPesquisa.getSelectedRow(), 4).toString()));
                tfCpfFun.setText(tbPesquisa.getValueAt(tbPesquisa.getSelectedRow(), 5).toString());
                tfIdadeFun.setText(tbPesquisa.getValueAt(tbPesquisa.getSelectedRow(), 6).toString());
                tfNomeUserFun.setText(tbPesquisa.getValueAt(tbPesquisa.getSelectedRow(), 7).toString());
                tfSenhaUserFun.setText(tbPesquisa.getValueAt(tbPesquisa.getSelectedRow(), 8).toString());
            }
        }
    }//GEN-LAST:event_tbPesquisaMouseClicked

    private void jbCadastrarFunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCadastrarFunActionPerformed
        if (verificaCampos() == false) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos");
        } else {
            cadastrar();
            this.preencheTabela();
            limpaCampos();
        }
    }//GEN-LAST:event_jbCadastrarFunActionPerformed

    private void tfIdadeFunKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfIdadeFunKeyTyped
        String caracteres = "0123456789";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_tfIdadeFunKeyTyped

    private void jbExcluirFunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirFunActionPerformed
        if (lbCodigo.getText().equals("...")) {
            JOptionPane.showMessageDialog(null, "É preciso ter localizado um usuário!");
        } else {
            ct.remover(Integer.parseInt(lbCodigo.getText()));
            limpaCampos();
            this.preencheTabela();

        }
    }//GEN-LAST:event_jbExcluirFunActionPerformed

    private void jbEditarFunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarFunActionPerformed
        if (verificaCampos() == false) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos");
        } else {
            editar();
            this.preencheTabela();
            limpaCampos();
        }
    }//GEN-LAST:event_jbEditarFunActionPerformed

    public void cadastrar() {
        FuncionarioBEAN c = new FuncionarioBEAN();
        c.setNome(tfNomeFun.getText());
        c.setIdade(Integer.parseInt(tfIdadeFun.getText()));
        c.setEndereco(tfEnderecoFun.getText());
        c.setCpf(tfCpfFun.getText());
        c.setNisPis(tfNPFun.getText());
        c.setNomeUsuario(tfNomeUserFun.getText());
        c.setSenha(tfSenhaUserFun.getText());
        c.setTelefone(tfTelefoneFun.getText());
        ct.cadastrar(c);
    }

    public void editar() {
        FuncionarioBEAN c = ct.localizarCodigo(Integer.parseInt(lbCodigo.getText()));
        c.setNome(tfNomeFun.getText());
        c.setIdade(Integer.parseInt(tfIdadeFun.getText()));
        c.setEndereco(tfEnderecoFun.getText());
        c.setCpf(tfCpfFun.getText());
        c.setNisPis(tfNPFun.getText());
        c.setNomeUsuario(tfNomeUserFun.getText());
        c.setSenha(tfSenhaUserFun.getText());
        c.setTelefone(tfTelefoneFun.getText());
        c.setCodigo(Integer.valueOf(lbCodigo.getText()));
        ct.editar(c);
    }

    public boolean verificaCampos() {
        if (tfNomeFun.getText().equals("") || tfIdadeFun.getText().equals("")
                || tfEnderecoFun.getText().equals("") || tfCpfFun.getText().equals("")
                || tfNPFun.getText().equals("") || tfTelefoneFun.getText().equals("")
                || tfNomeUserFun.getText().equals("") || tfSenhaUserFun.getText().equals("")) {
            return false;
        } else {
            return true;
        }
    }

    public void limpaCampos() {
        tfNomeFun.setText("");
        tfIdadeFun.setText("");
        tfEnderecoFun.setText("");
        tfCpfFun.setText("");
        tfNPFun.setText("");
        tfNomeUserFun.setText("");
        tfSenhaUserFun.setText("");
        tfTelefoneFun.setText("");
        lbCodigo.setText("...");
    }

    private void readJTableForNome(String funNome) {
        DefaultTableModel model = (DefaultTableModel) tbPesquisa.getModel();

        model.setNumRows(0);
        FuncionarioDAO dao = new FuncionarioDAO();

        for (FuncionarioBEAN d : dao.readForNome(funNome)) {
            tbUsers.addRow(new Object[]{
                d.getCodigo(),
                d.getNome(),
                d.getCpf(),});

        }
        //set o modelo da tabela
        tbPesquisa.setModel(tbUsers);
    }

    private DefaultTableModel criaTabela() {
        //sempre que usar JTable é necessário ter um DefaulttableModel
        DefaultTableModel tbUsers = new DefaultTableModel() {
            //Define o tipo dos campos (coluna) na mesma ordem que as colunas foram criadas
            Class[] types = new Class[]{
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class,};
            //define se os campos podem ser editados na propria tabela
            boolean[] canEdit = new boolean[]{
                false, false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        ;

        };
        //retorna o DefaultTableModel
    return tbUsers;
    }

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
            java.util.logging.Logger.getLogger(FRMPrincipalAdm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FRMPrincipalAdm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FRMPrincipalAdm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FRMPrincipalAdm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FRMPrincipalAdm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSair;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbCadastrarFun;
    private javax.swing.JToggleButton jbEditarFun;
    private javax.swing.JToggleButton jbExcluirFun;
    private javax.swing.JLabel lbCodigo;
    private javax.swing.JTable tbPesquisa;
    private javax.swing.JFormattedTextField tfCpfFun;
    private javax.swing.JTextField tfEnderecoFun;
    private javax.swing.JTextField tfIdadeFun;
    private javax.swing.JFormattedTextField tfNPFun;
    private javax.swing.JTextField tfNomeFun;
    private javax.swing.JTextField tfNomeUserFun;
    private javax.swing.JTextField tfPesquisaFun;
    private javax.swing.JPasswordField tfSenhaUserFun;
    private javax.swing.JFormattedTextField tfTelefoneFun;
    // End of variables declaration//GEN-END:variables

}

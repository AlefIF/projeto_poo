/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Controle.FornecedorControle;
import Controle.NotaDeCompraControle;
import Modelo.FornecedorBEAN;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import Modelo.NotaDecompraBEAN;
import java.sql.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Alef
 */
public class FRMNotaDeCompra extends javax.swing.JFrame {

    private NotaDeCompraControle ndcc = new NotaDeCompraControle();
    private DefaultTableModel dTable;
    private ArrayList<NotaDecompraBEAN> nDados;
    private FornecedorControle fCon = new FornecedorControle();

    /**
     * Creates new form FRMNotaDeCompra
     */
    public FRMNotaDeCompra() {
        initComponents();
        this.preencheTabela();
        for (FornecedorBEAN e : fCon.listarALL()) {
            jcFornecedor.addItem(e);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbCodigo = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfPrecoTT = new javax.swing.JTextField();
        tfNParcelas = new javax.swing.JTextField();
        tfPrecoParcela = new javax.swing.JTextField();
        tfValorEntrada = new javax.swing.JTextField();
        btSair = new javax.swing.JButton();
        jcSituacao = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tfDescricao = new javax.swing.JTextPane();
        tfData = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jcFornecedor = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jbCadastrarFun = new javax.swing.JButton();
        jbEditarFun = new javax.swing.JToggleButton();
        jbExcluirFun = new javax.swing.JToggleButton();
        jLabel13 = new javax.swing.JLabel();
        tfPesquisa = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableNotas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Preço Total:");

        jLabel2.setText("Situação:");

        jLabel3.setText("Número de parcelas:");

        jLabel6.setText("Preço por parcela:");

        jLabel11.setText("Código:");

        lbCodigo.setText("...");

        jLabel4.setText("Valor de entrada:");

        jLabel5.setText("Descrição:");

        tfPrecoTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPrecoTTActionPerformed(evt);
            }
        });

        btSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Visao/icons/Botões/JButtonLogin.png"))); // NOI18N
        btSair.setText("Sair");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });

        jcSituacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pendente", "Pago" }));

        jScrollPane1.setViewportView(tfDescricao);

        jLabel7.setText("Data:");

        jcFornecedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel8.setText("Fornecedor:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel6))
                                    .addGap(29, 29, 29)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(tfValorEntrada, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                                        .addComponent(tfPrecoParcela, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tfPrecoTT, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(tfNParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jLabel2)
                                                    .addGap(31, 31, 31))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jLabel7)
                                                    .addGap(49, 49, 49)))
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(tfData, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jcSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGap(5, 5, 5))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel11)
                                    .addGap(18, 18, 18)
                                    .addComponent(lbCodigo)
                                    .addGap(252, 252, 252)
                                    .addComponent(btSair, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel4)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jcFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(lbCodigo)
                    .addComponent(btSair, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfPrecoTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(tfNParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tfPrecoParcela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfValorEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)))
        );

        jbCadastrarFun.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Visao/icons/Botões/JButtonAddFun.png"))); // NOI18N
        jbCadastrarFun.setText("Cadastrar");
        jbCadastrarFun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCadastrarFunActionPerformed(evt);
            }
        });

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

        jLabel13.setText("Buscar:");

        tfPesquisa.setForeground(new java.awt.Color(204, 204, 204));
        tfPesquisa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfPesquisaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfPesquisaFocusLost(evt);
            }
        });
        tfPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPesquisaActionPerformed(evt);
            }
        });
        tfPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfPesquisaKeyTyped(evt);
            }
        });

        tableNotas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableNotas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableNotasMouseClicked(evt);
            }
        });
        tableNotas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tableNotasKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tableNotas);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jbCadastrarFun)
                        .addGap(49, 49, 49)
                        .addComponent(jbEditarFun, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbExcluirFun)
                        .addGap(42, 42, 42))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCadastrarFun)
                    .addComponent(jbEditarFun)
                    .addComponent(jbExcluirFun))
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(tfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private DefaultTableModel criaTabela() {
        //sempre que usar JTable é necessário ter um DefaulttableModel
        DefaultTableModel dTable = new DefaultTableModel() {
            //Define o tipo dos campos (coluna) na mesma ordem que as colunas foram criadas
            Class[] types = new Class[]{
                java.lang.Integer.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.Double.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,};
            //define se os campos podem ser editados na propria tabela
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false, false, false, false};

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        ;

        };
        //retorna o DefaultTableModel
    return dTable;
    }

    private void preencheTabela() {
        dTable = criaTabela();
        //seta o nome das colunas da tabela
        dTable.addColumn("Código");
        dTable.addColumn("Data");
        dTable.addColumn("Preço total");
        dTable.addColumn("Qtd. Parcelas");
        dTable.addColumn("Preço Parcelas");
        dTable.addColumn("Valor Entrada");
        dTable.addColumn("Fornecedor");
        dTable.addColumn("Descrição");
        dTable.addColumn("Situação");
        //pega os dados do ArrayList
        nDados = ndcc.listarALL();

        for (NotaDecompraBEAN d : nDados) {
            dTable.addRow(new Object[]{d.getNdcCodigo(), d.getNdcData(),
                d.getNdcPrecoTotal(), d.getNdcParcelas(), d.getNdcPrecoParcela(),
                d.getNdcEntrada(), d.getNdc_forCodigo(), d.getNdcDescricao(), d.getNdcSit()});
        }

        tableNotas.setModel(dTable);
    }

    private void limpaCampos() {
        lbCodigo.setText("");
        tfPrecoTT.setText("");
        tfValorEntrada.setText("");
        tfNParcelas.setText("");
        tfPrecoParcela.setText("");
        tfDescricao.setText("");
        jcSituacao.setSelectedIndex(0);
        tfData.setText("");
        jcFornecedor.setSelectedIndex(0);
    }

    private boolean verificaCampos() {
        if (tfData.getText().equals("")
                || tfDescricao.getText().equals("") || tfNParcelas.getText().equals("")
                || tfPesquisa.getText().equals("") || tfPrecoParcela.getText().equals("")
                || tfPrecoTT.getText().equals("") || tfValorEntrada.getText().equals("")) {
            return false;
        } else {
            return true;
        }
    }

    private void tfPrecoTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPrecoTTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPrecoTTActionPerformed

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        FRMLogin login = new FRMLogin();
        this.dispose();
        login.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_btSairActionPerformed

    private void jbCadastrarFunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCadastrarFunActionPerformed
        if (verificaCampos() == false) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos");
        } else {
            NotaDecompraBEAN f = new NotaDecompraBEAN();
            f.setNdcData(Date.valueOf(tfData.getText()));
            f.setNdcDescricao(tfDescricao.getText());
            f.setNdcEntrada(Float.valueOf(tfValorEntrada.getText()));
            f.setNdcParcelas(Integer.parseInt(tfNParcelas.getText()));
            f.setNdcPrecoParcela(Float.valueOf(tfPrecoParcela.getText()));
            f.setNdcPrecoTotal(Float.valueOf(tfPrecoTT.getText()));
            f.setNdcSit(jcSituacao.getSelectedIndex());
            FornecedorBEAN c = (FornecedorBEAN) jcFornecedor.getSelectedItem();
            f.setNdc_forCodigo(c.getForCodigo());
            ndcc.cadastrar(f);
            this.preencheTabela();
            limpaCampos();
        }
    }//GEN-LAST:event_jbCadastrarFunActionPerformed

    private void jbEditarFunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarFunActionPerformed
        if (verificaCampos() == false) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos");
        } else {
            NotaDecompraBEAN f = ndcc.localizar(Integer.parseInt(lbCodigo.getText()));
            f.setNdcData(Date.valueOf(tfData.getText()));
            f.setNdcDescricao(tfDescricao.getText());
            f.setNdcEntrada(Float.valueOf(tfValorEntrada.getText()));
            f.setNdcParcelas(Integer.parseInt(tfNParcelas.getText()));
            f.setNdcPrecoParcela(Float.valueOf(tfPrecoParcela.getText()));
            f.setNdcPrecoTotal(Float.valueOf(tfPrecoTT.getText()));
            f.setNdcSit(jcSituacao.getSelectedIndex());
            FornecedorBEAN c = (FornecedorBEAN) jcFornecedor.getSelectedItem();
            f.setNdc_forCodigo(c.getForCodigo());
            ndcc.editar(f);
            this.preencheTabela();
            limpaCampos();
        }
    }//GEN-LAST:event_jbEditarFunActionPerformed

    private void jbExcluirFunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirFunActionPerformed
        if (lbCodigo.getText().equals("...")) {
            JOptionPane.showMessageDialog(null, "É preciso ter localizado um usuário!");
        } else {
            ndcc.remover(Integer.parseInt(lbCodigo.getText()));
            limpaCampos();
            this.preencheTabela();

        }
    }//GEN-LAST:event_jbExcluirFunActionPerformed

    private void tfPesquisaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfPesquisaFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPesquisaFocusGained

    private void tfPesquisaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfPesquisaFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPesquisaFocusLost

    private void tfPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPesquisaActionPerformed

    private void tfPesquisaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPesquisaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPesquisaKeyTyped

    private void tableNotasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableNotasMouseClicked
        limpaCampos();

        if (tableNotas.getSelectedRow() != -1) {
            if (Integer.parseInt(tableNotas.getValueAt(tableNotas.getSelectedRow(), 8).toString()) > 0) {
                lbCodigo.setText(tableNotas.getValueAt(tableNotas.getSelectedRow(), 0).toString());
                tfData.setText(tableNotas.getValueAt(tableNotas.getSelectedRow(), 1).toString());
                tfPrecoTT.setText(tableNotas.getValueAt(tableNotas.getSelectedRow(), 2).toString());
                tfNParcelas.setText((tableNotas.getValueAt(tableNotas.getSelectedRow(), 3).toString()));
                tfPrecoParcela.setText((tableNotas.getValueAt(tableNotas.getSelectedRow(), 4).toString()));
                tfValorEntrada.setText(tableNotas.getValueAt(tableNotas.getSelectedRow(), 5).toString());

                for (NotaDecompraBEAN ndc : nDados) {
                    if ((tableNotas.getValueAt(tableNotas.getSelectedRow(), 6).toString().equals(ndc.getNdc_forCodigo()))) {
                        jcFornecedor.setSelectedIndex(ndc.getNdc_forCodigo());
                    }
                }

                tfDescricao.setText(tableNotas.getValueAt(tableNotas.getSelectedRow(), 7).toString());

                for (NotaDecompraBEAN ndc : nDados) {
                    if ((tableNotas.getValueAt(tableNotas.getSelectedRow(), 8).toString().equals(ndc.getNdcSit()))) {
                        jcSituacao.setSelectedIndex(ndc.getNdcSit());
                    }
                }

            }
        }
    }//GEN-LAST:event_tableNotasMouseClicked

    private void tableNotasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableNotasKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tableNotasKeyReleased

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
            java.util.logging.Logger.getLogger(FRMNotaDeCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FRMNotaDeCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FRMNotaDeCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FRMNotaDeCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FRMNotaDeCompra().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbCadastrarFun;
    private javax.swing.JToggleButton jbEditarFun;
    private javax.swing.JToggleButton jbExcluirFun;
    private javax.swing.JComboBox<Object> jcFornecedor;
    private javax.swing.JComboBox<String> jcSituacao;
    private javax.swing.JLabel lbCodigo;
    private javax.swing.JTable tableNotas;
    private javax.swing.JTextField tfData;
    private javax.swing.JTextPane tfDescricao;
    private javax.swing.JTextField tfNParcelas;
    private javax.swing.JTextField tfPesquisa;
    private javax.swing.JTextField tfPrecoParcela;
    private javax.swing.JTextField tfPrecoTT;
    private javax.swing.JTextField tfValorEntrada;
    // End of variables declaration//GEN-END:variables
}
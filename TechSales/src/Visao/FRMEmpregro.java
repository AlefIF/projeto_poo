/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Controle.EmpregoControle;
import Controle.FuncionarioControle;
import Modelo.EmpregoBEAN;
import Modelo.FuncionarioBEAN;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Alef
 */
public class FRMEmpregro extends javax.swing.JFrame {

    private EmpregoControle ec = new EmpregoControle();
    private FuncionarioControle fc = new FuncionarioControle();
    private DefaultTableModel tabEmp = new DefaultTableModel();

    /**
     * Creates new form FRMEmpregro
     */
    public FRMEmpregro() {
        initComponents();
        preencheTabela();
        this.setLocationRelativeTo(null);
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

        jLabel5 = new javax.swing.JLabel();
        tpGuia = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        lbCod = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfFuncao = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfSalario = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        btGravar = new javax.swing.JButton();
        btVoltar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tfDescricao = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaEmprego = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btEditar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btClonar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        tfChave = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerenciar Emprego");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setText("Gerenciar Emprego");

        lbCod.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbCod.setText("...");
        lbCod.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Código", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Função :");

        tfFuncao.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("Descrição:");

        tfSalario.setEnabled(false);
        tfSalario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfSalarioKeyTyped(evt);
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Menu de opções", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        btGravar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btGravar.setText("Gravar");
        btGravar.setEnabled(false);
        btGravar.setMaximumSize(new java.awt.Dimension(73, 23));
        btGravar.setMinimumSize(new java.awt.Dimension(73, 23));
        btGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGravarActionPerformed(evt);
            }
        });

        btVoltar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btVoltar.setText("Voltar");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton3.setText("Novo Dado");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btCancelar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btCancelar.setText("Cancelar");
        btCancelar.setEnabled(false);
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton5.setText("Localizar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btGravar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btGravar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("salário padrão:");

        tfDescricao.setColumns(20);
        tfDescricao.setRows(5);
        tfDescricao.setEnabled(false);
        jScrollPane1.setViewportView(tfDescricao);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(lbCod, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(tfFuncao, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(26, 26, 26)
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(tfSalario, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(18, 18, 18)
                            .addComponent(jScrollPane1)))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCod)
                    .addComponent(jLabel3)
                    .addComponent(tfFuncao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(tfSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tpGuia.addTab("Cadastrar emprego", jPanel1);

        tabelaEmprego.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tabelaEmprego.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabelaEmprego.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaEmpregoMouseClicked(evt);
            }
        });
        tabelaEmprego.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tabelaEmpregoKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(tabelaEmprego);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Menu de Seleção", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        btEditar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btEditar.setText("Editar");
        btEditar.setEnabled(false);
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });

        btExcluir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btExcluir.setText("Excluir");
        btExcluir.setEnabled(false);
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        btClonar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btClonar.setText("Clonar dados");
        btClonar.setEnabled(false);
        btClonar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btClonarActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton2.setText("Excluir todos");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btClonar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btClonar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tfChave.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Refinar Pesquisa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        tfChave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfChaveActionPerformed(evt);
            }
        });
        tfChave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfChaveKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfChaveKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfChaveKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfChave, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tfChave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tpGuia.addTab("Listar Emprego", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tpGuia)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(166, 166, 166))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tpGuia))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabelaEmpregoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelaEmpregoKeyTyped

    }//GEN-LAST:event_tabelaEmpregoKeyTyped

    private void tabelaEmpregoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaEmpregoMouseClicked
        if (tabelaEmprego.getSelectedRow() != -1) {
            btEditar.setEnabled(true);
            btExcluir.setEnabled(true);
            btClonar.setEnabled(true);
        }
    }//GEN-LAST:event_tabelaEmpregoMouseClicked

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        FRMMenuADM fun = new FRMMenuADM();
        this.dispose();
        fun.setVisible(true);
    }//GEN-LAST:event_btVoltarActionPerformed

    private void btGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGravarActionPerformed
        if (verificaCampos() == false) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos");
        } else {
            if (lbCod.getText().equals("...")) {
                cadastrar();
            } else {
                edit();
            }
            limpaCampos();
            limpaBotoes();
            desabilitaCampos();
        }
    }//GEN-LAST:event_btGravarActionPerformed

    private void tfSalarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfSalarioKeyTyped
        String caracteres = "0123456789.";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_tfSalarioKeyTyped

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        limpaCampos();
        EmpregoBEAN emp = ec.localizarCodigo(Integer.parseInt(tabelaEmprego.getValueAt(tabelaEmprego.getSelectedRow(), 0).toString()));
        lbCod.setText(String.valueOf(emp.getEmpCodigo()));
        tfFuncao.setText(String.valueOf(emp.getEmpNome()));
        tfSalario.setText(String.valueOf(emp.getEmpSalarioPadrao()));
        tfDescricao.setText(String.valueOf(emp.getEmpDescricao()));
        tpGuia.setSelectedIndex(0);
        habilitaCampos();
    }//GEN-LAST:event_btEditarActionPerformed

    private void tfChaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfChaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfChaveActionPerformed

    private void tfChaveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfChaveKeyPressed

    }//GEN-LAST:event_tfChaveKeyPressed

    private void tfChaveKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfChaveKeyTyped

    }//GEN-LAST:event_tfChaveKeyTyped
    private void limpaBotoes() {
        btGravar.setEnabled(false);
        btCancelar.setEnabled(false);
        btEditar.setEnabled(false);
        btClonar.setEnabled(false);
        btExcluir.setEnabled(false);
    }

    private void habilitaCampos() {
        tfFuncao.setEnabled(true);
        tfSalario.setEnabled(true);
        tfDescricao.setEnabled(true);

        btCancelar.setEnabled(true);
        btGravar.setEnabled(true);
    }

    private void desabilitaCampos() {
        tfFuncao.setEnabled(false);
        tfSalario.setEnabled(false);
        tfDescricao.setEnabled(false);
        tfDescricao.setEditable(false);
    }
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        limpaBotoes();
        limpaCampos();
        habilitaCampos();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        limpaBotoes();
        limpaCampos();
        desabilitaCampos();
    }//GEN-LAST:event_btCancelarActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        tpGuia.setSelectedIndex(1);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void tfChaveKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfChaveKeyReleased
        TableRowSorter sorter = null;
        DefaultTableModel model = (DefaultTableModel) tabelaEmprego.getModel();
        sorter = new TableRowSorter<TableModel>(model);
        tabelaEmprego.setRowSorter(sorter);
        String text = tfChave.getText();
        if (text.length() == 0) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.regexFilter(text));
        }
    }//GEN-LAST:event_tfChaveKeyReleased

    private void btClonarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btClonarActionPerformed
        limpaCampos();
        EmpregoBEAN emp = ec.localizarCodigo(Integer.parseInt(tabelaEmprego.getValueAt(tabelaEmprego.getSelectedRow(), 0).toString()));
        tfFuncao.setText(String.valueOf(emp.getEmpNome()));
        tfSalario.setText(String.valueOf(emp.getEmpSalarioPadrao()));
        tfDescricao.setText(String.valueOf(emp.getEmpDescricao()));
        tpGuia.setSelectedIndex(0);
        habilitaCampos();
    }//GEN-LAST:event_btClonarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        int cod = 0;
        int i = 0;
        if (tabelaEmprego.getSelectedRow() != -1) {
            cod = (Integer.parseInt(tabelaEmprego.getValueAt(tabelaEmprego.getSelectedRow(), 0).toString()));
        }
        for (FuncionarioBEAN j : fc.listarALL()) {
            if (j.getEmprego().getEmpCodigo() == cod) {
                i = 1;
            }
        }
        if (i == 0) {
            boolean retorno = false;
            retorno = ec.remover(cod);
            if (retorno == true) {
                JOptionPane.showMessageDialog(null, "Emprego EXCLUÍDO com sucesso");
                preencheTabela();
            }
        } else {
            JOptionPane.showMessageDialog(null, "ERRO na exclusão, essa emprego esta sendo usada em um funcionário cadastrado");
        }
        limpaBotoes();
    }//GEN-LAST:event_btExcluirActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ArrayList<EmpregoBEAN> catlista = new ArrayList<EmpregoBEAN>();
        for (EmpregoBEAN c : ec.listarALL()) {
            for (FuncionarioBEAN j : fc.listarALL()) {
                if (c.getEmpCodigo() == j.getEmprego().getEmpCodigo()) {
                    catlista.add(c);
                }
            }
        }
        int i = 0;
        for (EmpregoBEAN c : ec.listarALL()) {
            for (EmpregoBEAN cl : catlista) {
                if (cl.getEmpCodigo() == c.getEmpCodigo()) {
                    i++;
                }
            }
            if (i == 0) {
                ec.remover(c.getEmpCodigo());
            }
            i = 0;
        }
        preencheTabela();
        JOptionPane.showMessageDialog(null, "Todas os empregos não relacionadas a funcionários foram excluidas com sucesso");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void exclu() {
        boolean retorno = ec.remover(Integer.parseInt(lbCod.getText()));
        if (retorno == true) {
            JOptionPane.showMessageDialog(null, "Emprego EXCLUÍDO com sucesso");
            this.preencheTabela();
            this.limpaCampos();
        } else {
            JOptionPane.showMessageDialog(null, "ERRO na exclusão");
        }
    }

    private void edit() {
        EmpregoBEAN c = ec.localizarCodigo(Integer.parseInt(lbCod.getText()));
        c.setEmpNome(tfFuncao.getText());
        c.setEmpSalarioPadrao(Float.parseFloat(tfSalario.getText()));
        c.setEmpDescricao(tfDescricao.getText());

        boolean retorno = ec.editar(c);

        if (retorno == true) {
            JOptionPane.showMessageDialog(null, "Emprego MODIFICADO com sucesso");
            this.preencheTabela();
        } else {
            JOptionPane.showMessageDialog(null, "ERRO na EDIÇÃO");
        }
    }

    public void limpaCampos() {
        lbCod.setText("...");
        tfFuncao.setText("");
        tfDescricao.setText("");
        tfSalario.setText("");
    }

    public boolean verificaCampos() {
        if (tfFuncao.getText().equals("")
                || tfDescricao.getText().equals("")
                || tfSalario.getText().equals("")) {
            return false;
        } else {
            return true;
        }
    }

    public void cadastrar() {
        EmpregoBEAN emp = new EmpregoBEAN();
        emp.setEmpNome(tfFuncao.getText());
        emp.setEmpSalarioPadrao(Float.parseFloat(tfSalario.getText()));
        emp.setEmpDescricao(tfDescricao.getText());
        ec.cadastrar(emp);
        this.preencheTabela();
        JOptionPane.showMessageDialog(null, "Emprego CADASTRADO com sucesso");
    }

    private void preencheTabela() {
        tabEmp = this.criaTabela();
        tabEmp.addColumn("Código");
        tabEmp.addColumn("Função");
        tabEmp.addColumn("Salário");
        tabEmp.addColumn("Descrição");

        ArrayList<EmpregoBEAN> empL = ec.listarALL();

        for (EmpregoBEAN e : empL) {
            tabEmp.addRow(new Object[]{
                e.getEmpCodigo(),
                e.getEmpNome(),
                e.getEmpSalarioPadrao(),
                e.getEmpDescricao()});
        }
        //set o modelo da tabela
        tabelaEmprego.setModel(tabEmp);
    }

    private DefaultTableModel criaTabela() {
        //sempre que usar JTable é necessário ter um DefaulttableModel
        DefaultTableModel dTable = new DefaultTableModel() {
            //Define o tipo dos campos (coluna) na mesma ordem que as colunas foram criadas
            Class[] types = new Class[]{
                java.lang.Integer.class,
                java.lang.String.class,
                java.lang.Float.class,
                java.lang.String.class,};
            //define se os campos podem ser editados na propria tabela
            boolean[] canEdit = new boolean[]{
                false, false, false, false};

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        ;
        };
        //retorna o DefaultTableModel
    return dTable;
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
            java.util.logging.Logger.getLogger(FRMEmpregro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FRMEmpregro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FRMEmpregro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FRMEmpregro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FRMEmpregro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btClonar;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btGravar;
    private javax.swing.JButton btVoltar;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbCod;
    private javax.swing.JTable tabelaEmprego;
    private javax.swing.JTextField tfChave;
    private javax.swing.JTextArea tfDescricao;
    private javax.swing.JTextField tfFuncao;
    private javax.swing.JTextField tfSalario;
    private javax.swing.JTabbedPane tpGuia;
    // End of variables declaration//GEN-END:variables
}

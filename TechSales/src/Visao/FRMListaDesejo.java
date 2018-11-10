/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Controle.ClienteControle;
import Controle.ListaDesejoControle;
import Modelo.ClienteBEAN;
import Modelo.ListaDesejoBEAN;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Alef
 */
public class FRMListaDesejo extends javax.swing.JFrame {

    private DefaultTableModel cTable;
    private DefaultTableModel dTable;
    private ClienteControle cCliente = new ClienteControle();
    private ListaDesejoControle cLista = new ListaDesejoControle();

    /**
     * Creates new form FRMListaDesejo
     */
    public FRMListaDesejo() {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        tpGuia = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btGravar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        btVoltar = new javax.swing.JButton();
        lbCodCon = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        tfMarca = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfCliCod = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDesejo = new javax.swing.JTable();
        tfChave = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        btEditar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btClonar = new javax.swing.JButton();
        btExcluiAll = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel2.setText("Lista de Desejo");

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

        jButton2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton2.setText("Novo Dado");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btCancelar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btCancelar.setText("Cancelar");
        btCancelar.setEnabled(false);

        btVoltar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btVoltar.setText("Fechar");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btGravar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btGravar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54))
        );

        lbCodCon.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbCodCon.setText("...");
        lbCodCon.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Código ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Nome do Jogo :");

        tfNome.setEnabled(false);

        tfMarca.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("Console :");

        tfCliCod.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Codigo Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        tfCliCod.setEnabled(false);
        tfCliCod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfCliCodKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfCliCodKeyTyped(evt);
            }
        });

        jLabel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Nome", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfNome)
                            .addComponent(tfMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lbCodCon, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfCliCod, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(75, 75, 75))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 35, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCodCon)
                    .addComponent(tfCliCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(71, 71, 71)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tpGuia.addTab("Cadastro de Desejo", jPanel3);

        tableDesejo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tableDesejo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tableDesejo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDesejoMouseClicked(evt);
            }
        });
        tableDesejo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tableDesejoKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(tableDesejo);

        tfChave.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Refinar Pesquisa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        tfChave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfChaveKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfChaveKeyTyped(evt);
            }
        });

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Menu de Seleção", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        btEditar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btEditar.setText("Editar");
        btEditar.setEnabled(false);
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });

        btExcluir.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btExcluir.setText("Excluir");
        btExcluir.setEnabled(false);
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        btClonar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btClonar.setText("Clonar Dados");
        btClonar.setEnabled(false);
        btClonar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btClonarActionPerformed(evt);
            }
        });

        btExcluiAll.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btExcluiAll.setText("Excluir Todos");
        btExcluiAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluiAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btClonar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btExcluiAll)
                .addGap(24, 24, 24))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btEditar)
                    .addComponent(btExcluir)
                    .addComponent(btClonar)
                    .addComponent(btExcluiAll))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfChave, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(tfChave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tpGuia.addTab("Listar Desejos", jPanel8);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(130, 130, 130))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(tpGuia)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tpGuia, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btExcluiAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluiAllActionPerformed
        ArrayList<CategoriaBEAN> catlista = new ArrayList<CategoriaBEAN>();

        for (CategoriaBEAN c : catCon.listarALL()) {
            for (JogoBEAN j : cjogo.listarALL()) {
                if (c.getCatCodigo() == j.getCat().getCatCodigo()) {
                    catlista.add(c);
                }
            }
        }
        int i = 0;
        for (CategoriaBEAN c : catCon.listarALL()) {
            for (CategoriaBEAN cl : catlista) {
                if (cl.getCatCodigo() == c.getCatCodigo()) {
                    i++;
                }
            }
            if (i == 0) {
                catCon.remover(c.getCatCodigo());
            }
            i = 0;
        }

        preencheTabela();
        try {
            FRMJogo.povoaCombos();
        } catch (Exception e) {

        }
        JOptionPane.showMessageDialog(null, "Todas as categorias não relacionadas a jogos foram excluidas com sucesso");
    }//GEN-LAST:event_btExcluiAllActionPerformed

    private void btClonarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btClonarActionPerformed
        if (tableCategoria.getSelectedRow() != -1) {
            tfNome.setText(tableCategoria.getValueAt(tableCategoria.getSelectedRow(), 1).toString());
        }
        limpaBotoes();
        tfNome.setEnabled(true);
        btGravar.setEnabled(true);
        btCancela.setEnabled(true);
    }//GEN-LAST:event_btClonarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        int cod = 0;
        int i = 0;
        if (tableCategoria.getSelectedRow() != -1) {
            cod = (Integer.parseInt(tableCategoria.getValueAt(tableCategoria.getSelectedRow(), 0).toString()));
        }
        for (JogoBEAN j : cjogo.listarALL()) {
            if (j.getCat().getCatCodigo() == cod) {
                i = 1;
            }
        }
        if (i == 0) {
            boolean retorno = false;
            retorno = catCon.remover(cod);
            if (retorno == true) {
                JOptionPane.showMessageDialog(null, "Categoria EXCLUÍDA com sucesso");
                try {
                    FRMJogo.povoaCombos();
                } catch (Exception E) {

                }
                preencheTabela();
            }
        } else {
            JOptionPane.showMessageDialog(null, "ERRO na exclusão, essa categoria esta sendo usada em um Jogo cadastrado");
        }
        limpaBotoes();
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        if (tableCategoria.getSelectedRow() != -1) {
            lbCodCat.setText(tableCategoria.getValueAt(tableCategoria.getSelectedRow(), 0).toString());
            tfNome.setText(tableCategoria.getValueAt(tableCategoria.getSelectedRow(), 1).toString());
        }
        limpaBotoes();
        btCancela.setEnabled(true);
        tfNome.setEnabled(true);
        btGravar.setEnabled(true);
    }//GEN-LAST:event_btEditarActionPerformed

    private void tfChaveKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfChaveKeyTyped
        TableRowSorter sorter = null;
        DefaultTableModel model = (DefaultTableModel) tableCategoria.getModel();
        sorter = new TableRowSorter<TableModel>(model);
        tableCategoria.setRowSorter(sorter);
        String text = tfChave.getText();
        if (text.length() == 0) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.regexFilter(text));
        }
    }//GEN-LAST:event_tfChaveKeyTyped

    private void tfChaveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfChaveKeyPressed

    }//GEN-LAST:event_tfChaveKeyPressed

    private void tableDesejoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableDesejoKeyTyped

    }//GEN-LAST:event_tableDesejoKeyTyped

    private void tableDesejoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDesejoMouseClicked
        if (tableDesejo.getSelectedRow() != -1) {
            lbCodCon.setText(tableDesejo.getValueAt(tableDesejo.getSelectedRow(), 0).toString());
            lbCliCod.setText(tableDesejo.getValueAt(tableDesejo.getSelectedRow(), 1).toString());
            tfNome.setText(tableDesejo.getValueAt(tableDesejo.getSelectedRow(), 2).toString());
            tfMarca.setText(tableDesejo.getValueAt(tableDesejo.getSelectedRow(), 3).toString());
            btEditar.setEnabled(true);
            btExcluir.setEnabled(true);
        }
    }//GEN-LAST:event_tableDesejoMouseClicked

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        FRMMenuVendedor fun = new FRMMenuVendedor();
        this.dispose();
        fun.setVisible(true);
    }//GEN-LAST:event_btVoltarActionPerformed

    private void btGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGravarActionPerformed
        if (verificarCampos()) {
            ListaDesejoBEAN d = new ListaDesejoBEAN();
            d.setLisNomeJogo(tfNome.getText());
            d.setLisPlataforma(tfMarca.getText());
            ClienteBEAN c = cCliente.localizarCodigo(Integer.parseInt(lbCliCod.getText()));
            d.setCliente(c);
            cLista.cadastrar(d);
            this.preencheTabela();
            limparCampos();
            JOptionPane.showMessageDialog(null, "Desejo CADASTRADO com sucesso");
        } else {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos");
        }
    }//GEN-LAST:event_btGravarActionPerformed

    private void tfCliCodKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCliCodKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCliCodKeyPressed

    private void tfCliCodKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCliCodKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCliCodKeyTyped
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
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        limpaBotoes();
        limparCampos();
        habilitaCampos();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void limparCampos() {
        lbCodCon.setText("");
        tfCliCod.setText("");
        tfNome.setText("");
        tfMarca.setText("");
    }

    private void preencheTabela() {
        dTable = criaTabela();
        dTable.addColumn("Codigo");
        dTable.addColumn("Cliente");
        dTable.addColumn("Nome");
        dTable.addColumn("Plataforma");

        for (ListaDesejoBEAN dado : cLista.listarALL()) {
            dTable.addRow(new Object[]{dado.getLisCodigo(), dado.getCliente().getCliNome(),
                dado.getLisNomeJogo(), dado.getLisPlataforma()});
        }

        tableDesejo.setModel(dTable);
    }

    private DefaultTableModel criaTabela() {

        DefaultTableModel dTable = new DefaultTableModel() {

            Class[] types = new Class[]{
                java.lang.Integer.class, java.lang.String.class,
                java.lang.String.class, java.lang.String.class};

            boolean[] canEdit = new boolean[]{
                false, false, false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        ;
        };

    return dTable;
    }

    private boolean verificarCampos() {
        if (tfNome.getText().equals("")
                || tfMarca.getText().equals("")
                || tfCliCod.getText().equals("...")) {
            return false;
        } else {
            return true;
        }
    }

    private void edit() {
        if (verificarCampos()) {
            ListaDesejoBEAN c = cLista.localizar(Integer.parseInt(lbCodCon.getText()));
            c.setLisNomeJogo(tfNome.getText());
            c.setLisPlataforma(tfMarca.getText());
            boolean retorno = cLista.editar(c);
            if (retorno == true) {
                JOptionPane.showMessageDialog(null, "Desejo MODIFICADO com sucesso");
                this.preencheTabela();
                this.limparCampos();
            } else {
                JOptionPane.showMessageDialog(null, "ERRO na EDIÇÃO");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos");
        }
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
            java.util.logging.Logger.getLogger(FRMListaDesejo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FRMListaDesejo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FRMListaDesejo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FRMListaDesejo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FRMListaDesejo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btClonar;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btExcluiAll;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btGravar;
    private javax.swing.JButton btVoltar;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbCodCon;
    private javax.swing.JTable tableDesejo;
    private javax.swing.JTextField tfChave;
    private javax.swing.JTextField tfCliCod;
    private javax.swing.JTextField tfMarca;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTabbedPane tpGuia;
    // End of variables declaration//GEN-END:variables
}

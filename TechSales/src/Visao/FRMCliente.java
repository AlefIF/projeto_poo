package Visao;

import Controle.ClienteControle;
import Controle.GeraRelatorio;
import Modelo.ClienteBEAN;
import static java.awt.Color.BLACK;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class FRMCliente extends javax.swing.JFrame {

    private ClienteControle cCliente = new ClienteControle();
    private ArrayList<ClienteBEAN> cdados;
    private DefaultTableModel cTable; //usado para trabalhar com JTable

    public FRMCliente() {
        initComponents();
        setResizable(false);

        this.preencheTabela();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rbgLocalizar = new javax.swing.ButtonGroup();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tpGuia = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        tfEnderecoCli = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        tfNomeCli = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btCadastrar = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btLocalizar = new javax.swing.JButton();
        jLabelCodigo = new javax.swing.JLabel();
        tfCpfCli = new javax.swing.JFormattedTextField();
        tfTelCli = new javax.swing.JFormattedTextField();
        btRelatorio = new javax.swing.JButton();
        tfIdadeCli = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCliente = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        rbCpf = new javax.swing.JRadioButton();
        rbCodigo = new javax.swing.JRadioButton();
        rbNome = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        tfLocalizarNome = new javax.swing.JTextField();
        btVoltar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gerenciar Clientes");
        getContentPane().setLayout(null);

        jLabel3.setAlignmentX(612.0F);
        jLabel3.setAlignmentY(372.0F);
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 0, 0);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Cadastro de Clientes");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(260, 10, 184, 22);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Telefone");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Endereço");

        tfNomeCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNomeCliActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Nome");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Código:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Idade");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("CPF");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        btCadastrar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Visao/icons/Botões/JButtonAddUser.png"))); // NOI18N
        btCadastrar.setText("Cadastrar");
        btCadastrar.setMaximumSize(new java.awt.Dimension(73, 23));
        btCadastrar.setMinimumSize(new java.awt.Dimension(73, 23));
        btCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarActionPerformed(evt);
            }
        });

        btEditar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Visao/icons/Botões/JButtonEdit.png"))); // NOI18N
        btEditar.setText("Editar");
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });

        btExcluir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Visao/icons/Botões/JButtonDeletarFun.png"))); // NOI18N
        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        btLocalizar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btLocalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Visao/icons/Botões/JButtonConsultarCliente.png"))); // NOI18N
        btLocalizar.setText("Localizar");
        btLocalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLocalizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btEditar)
                .addGap(18, 18, 18)
                .addComponent(btLocalizar)
                .addGap(18, 18, 18)
                .addComponent(btExcluir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btEditar)
                    .addComponent(btExcluir)
                    .addComponent(btLocalizar))
                .addContainerGap())
        );

        jLabelCodigo.setText("...");

        try{
            javax.swing.text.MaskFormatter cpf= new javax.swing.text.MaskFormatter("###.###.###-##");
            tfCpfCli = new javax.swing.JFormattedTextField(cpf);
        }
        catch (Exception e){
        }

        try{
            javax.swing.text.MaskFormatter tel= new javax.swing.text.MaskFormatter("(##)# ####-####");
            tfTelCli = new javax.swing.JFormattedTextField(tel);
        }
        catch (Exception e){
        }

        btRelatorio.setText("Gerar Relatorio");
        btRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRelatorioActionPerformed(evt);
            }
        });

        tfIdadeCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfIdadeCliKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(tfCpfCli, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(tfTelCli, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel9)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabelCodigo))
                        .addComponent(tfNomeCli)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel10)
                                .addComponent(tfIdadeCli, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel11)
                                .addComponent(tfEnderecoCli, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(105, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btRelatorio)
                .addGap(97, 97, 97))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabelCodigo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfNomeCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfEnderecoCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfIdadeCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCpfCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfTelCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btRelatorio)
                .addGap(30, 30, 30))
        );

        tpGuia.addTab("Cadastrar", jPanel2);

        tableCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Idade", "CPF", "Endereço", "Telefone"
            }
        ));
        tableCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableCliente);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Localizar por:");

        rbgLocalizar.add(rbCpf);
        rbCpf.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rbCpf.setText("CPF");
        rbCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbCpfActionPerformed(evt);
            }
        });

        rbgLocalizar.add(rbCodigo);
        rbCodigo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rbCodigo.setText("Codigo");
        rbCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbCodigoActionPerformed(evt);
            }
        });

        rbgLocalizar.add(rbNome);
        rbNome.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rbNome.setText("Nome");
        rbNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbNomeActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED), "Digite aqui para localizar", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        jPanel4.setToolTipText("");

        tfLocalizarNome.setForeground(new java.awt.Color(204, 204, 204));
        tfLocalizarNome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfLocalizarNomeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfLocalizarNomeFocusLost(evt);
            }
        });
        tfLocalizarNome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tfLocalizarNomeMouseClicked(evt);
            }
        });
        tfLocalizarNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfLocalizarNomeActionPerformed(evt);
            }
        });
        tfLocalizarNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfLocalizarNomeKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(tfLocalizarNome, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(tfLocalizarNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 4, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(rbCodigo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbCpf)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(146, 146, 146))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbCodigo)
                            .addComponent(rbNome)
                            .addComponent(rbCpf)))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE))
        );

        tpGuia.addTab("Consulta Cliente", jPanel3);

        getContentPane().add(tpGuia);
        tpGuia.setBounds(10, 40, 680, 340);

        btVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Visao/icons/Botões/JButtonLogin.png"))); // NOI18N
        btVoltar.setText("Voltar");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });
        getContentPane().add(btVoltar);
        btVoltar.setBounds(600, 10, 80, 20);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Visao/icons/Interface gráfica/back2.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(-10, -10, 720, 400);

        setSize(new java.awt.Dimension(716, 417));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarActionPerformed

        ClienteBEAN cliente = new ClienteBEAN();

        cliente.setEndereco(tfEnderecoCli.getText());
        cliente.setIdade(Integer.parseInt(tfIdadeCli.getText()));
        cliente.setNome(tfNomeCli.getText());
        cliente.setTelefone(tfTelCli.getText());
        cliente.setCpf(tfCpfCli.getText());
        cCliente.cadastrar(cliente);
        this.preencheTabela();
        limparCampos();
        JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
    }//GEN-LAST:event_btCadastrarActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed

        ClienteBEAN cliente = cCliente.localizarCodigo((Integer.parseInt(jLabelCodigo.getText())));
        cliente.setCod(Integer.parseInt(jLabelCodigo.getText()));
        cliente.setEndereco(tfEnderecoCli.getText());
        cliente.setIdade(Integer.parseInt(tfIdadeCli.getText()));
        cliente.setNome(tfNomeCli.getText());
        cliente.setTelefone(tfTelCli.getText());
        cliente.setCpf(tfCpfCli.getText());

        boolean retorno = cCliente.editar(cliente);

        if (retorno == true) {
            JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso!");

            this.preencheTabela();

            this.limparCampos();
        } else {

            JOptionPane.showMessageDialog(null, "Erro na alteração");
        }
    }//GEN-LAST:event_btEditarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        boolean retorno = cCliente.remover(Integer.parseInt(jLabelCodigo.getText()));

        if (retorno == true) {
            JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso!");

            this.preencheTabela();

            this.limparCampos();
        } else {

            JOptionPane.showMessageDialog(null, "Erro na exclusão");
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btLocalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLocalizarActionPerformed
        tpGuia.setSelectedIndex(1);

    }//GEN-LAST:event_btLocalizarActionPerformed

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        FRMPrincipalFun fun = new FRMPrincipalFun();
        this.dispose();
        fun.setVisible(true);

    }//GEN-LAST:event_btVoltarActionPerformed

    private void tfNomeCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNomeCliActionPerformed

    }//GEN-LAST:event_tfNomeCliActionPerformed

    private void rbCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbCodigoActionPerformed
        tfLocalizarNome.setText("Insira o Código");

    }//GEN-LAST:event_rbCodigoActionPerformed

    private void rbNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbNomeActionPerformed
        tfLocalizarNome.setText("Insira o Nome");
    }//GEN-LAST:event_rbNomeActionPerformed

    private void rbCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbCpfActionPerformed
        tfLocalizarNome.setText("Insira o CPF");
    }//GEN-LAST:event_rbCpfActionPerformed

    private void tfLocalizarNomeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfLocalizarNomeFocusGained
        tfLocalizarNome.setText("");
        tfLocalizarNome.setForeground(BLACK);
// TODO add your handling code here:
    }//GEN-LAST:event_tfLocalizarNomeFocusGained

    private void tfLocalizarNomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfLocalizarNomeFocusLost
        rbgLocalizar.getSelection();

// TODO add your handling code here:
    }//GEN-LAST:event_tfLocalizarNomeFocusLost

    private void tfLocalizarNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfLocalizarNomeKeyTyped

        TableRowSorter sorter = null;
        DefaultTableModel model = (DefaultTableModel) tableCliente.getModel();
        sorter = new TableRowSorter<TableModel>(model);
        tableCliente.setRowSorter(sorter);
        String text = tfLocalizarNome.getText();
        sorter.setRowFilter(RowFilter.regexFilter(text));
    }//GEN-LAST:event_tfLocalizarNomeKeyTyped

    private void tableClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableClienteMouseClicked

        tpGuia.setSelectedIndex(0);

        if (tableCliente.getSelectedRow() != -1) {
            jLabelCodigo.setText(tableCliente.getValueAt(tableCliente.getSelectedRow(), 0).toString());
            tfNomeCli.setText(tableCliente.getValueAt(tableCliente.getSelectedRow(), 1).toString());
            tfIdadeCli.setText(tableCliente.getValueAt(tableCliente.getSelectedRow(), 2).toString());
            tfCpfCli.setText((tableCliente.getValueAt(tableCliente.getSelectedRow(), 3).toString()));
            tfEnderecoCli.setText(tableCliente.getValueAt(tableCliente.getSelectedRow(), 4).toString());
            tfTelCli.setText(tableCliente.getValueAt(tableCliente.getSelectedRow(), 5).toString());
        }

    }//GEN-LAST:event_tableClienteMouseClicked

    private void tfLocalizarNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfLocalizarNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfLocalizarNomeActionPerformed

    private void tfLocalizarNomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfLocalizarNomeMouseClicked

    }//GEN-LAST:event_tfLocalizarNomeMouseClicked

    private void btRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRelatorioActionPerformed
        //consulta do BD
        String query = "SELECT  * \n"
                + "FROM cliente \n";
        try {
            //passa o caminho onde o relatório esta no projeto - codigo compilado
            GeraRelatorio.gerarRelatorio(query, "./report/cliente.jasper");
        } catch (Exception x) {
        }
    }//GEN-LAST:event_btRelatorioActionPerformed

    private void tfIdadeCliKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfIdadeCliKeyTyped
        String caracteres = "0123456789.";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_tfIdadeCliKeyTyped

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
            java.util.logging.Logger.getLogger(FRMCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FRMCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FRMCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FRMCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FRMCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCadastrar;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btLocalizar;
    private javax.swing.JButton btRelatorio;
    private javax.swing.JButton btVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelCodigo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbCodigo;
    private javax.swing.JRadioButton rbCpf;
    private javax.swing.JRadioButton rbNome;
    private javax.swing.ButtonGroup rbgLocalizar;
    private javax.swing.JTable tableCliente;
    private javax.swing.JFormattedTextField tfCpfCli;
    private javax.swing.JTextField tfEnderecoCli;
    private javax.swing.JTextField tfIdadeCli;
    private javax.swing.JTextField tfLocalizarNome;
    private javax.swing.JTextField tfNomeCli;
    private javax.swing.JFormattedTextField tfTelCli;
    private javax.swing.JTabbedPane tpGuia;
    // End of variables declaration//GEN-END:variables

    private void preencheTabela() {
        cTable = criaTabela();
        //seta o nome das colunas da tabela
        cTable.addColumn("Código");
        cTable.addColumn("Nome");
        cTable.addColumn("Idade");
        cTable.addColumn("CPF");
        cTable.addColumn("Endereço");
        cTable.addColumn("Telefone");

        //pega os dados do ArrayList
        cdados = cCliente.listarALL();

        //cada célula do arrayList vira uma linha(row) na tabela
        for (ClienteBEAN dado : cdados) {
            cTable.addRow(new Object[]{dado.getCod(), dado.getNome(), dado.getIdade(), dado.getCpf(),
                dado.getEndereco(), dado.getTelefone()});

        }
        //set o modelo da tabela
        tableCliente.setModel(cTable);
    }

    private void limparCampos() {
        jLabelCodigo.setText("");
        tfEnderecoCli.setText("");
        tfIdadeCli.setText("");
        tfNomeCli.setText("");
        tfTelCli.setText("");
        tfCpfCli.setText("");
    }

    private DefaultTableModel criaTabela() {
        //sempre que usar JTable é necessário ter um DefaulttableModel
        DefaultTableModel cTable = new DefaultTableModel() {
            //Define o tipo dos campos (coluna) na mesma ordem que as colunas foram criadas
            Class[] types = new Class[]{
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class,
                java.lang.String.class, java.lang.Integer.class
            };
            //define se os campos podem ser editados na propria tabela
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        ;

        };
        //retorna o DefaultTableModel
    return cTable;
    }

}

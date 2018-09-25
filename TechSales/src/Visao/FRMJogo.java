/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Controle.CategoriaControle;
import Controle.ConsoleControle;
import Controle.FornecedorControle;
import Modelo.CategoriaBEAN;
import Modelo.ConsoleBEAN;
import Controle.JogoControle;
import Controle.LucroControle;
import Controle.NotaDeCompraControle;
import Modelo.FornecedorBEAN;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Modelo.JogoBEAN;
import Modelo.LucroBEAN;
import Modelo.NotaDecompraBEAN;
import Modelo.VendedorBEAN;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author LUCASP
 */
public class FRMJogo extends javax.swing.JFrame {

    private JogoControle jControle = new JogoControle();
    private ConsoleControle cControle = new ConsoleControle();
    private CategoriaControle catControle = new CategoriaControle();
    private NotaDeCompraControle notac = new NotaDeCompraControle();
    private FornecedorControle fc = new FornecedorControle();
    private ArrayList<JogoBEAN> jDados;
    private ArrayList<CategoriaBEAN> catDados;
    private ArrayList<ConsoleBEAN> cDados;
    private DefaultTableModel dTable;
    private DefaultTableModel dTable2;

    static int jogoCod = 0;

    /**
     * Creates new form FRMJogo
     */
    //Notas
    //O pega selecionado não funciona quando se usa a pesquisa refinada 
    //Não consegui inserir os atributos de conosole na tabela, eles são de outro objeto
    //Não implementei a funcionalidade inserir por falta de tempo
    public FRMJogo() {
        initComponents();
        setResizable(false);
        for (ConsoleBEAN e : cControle.listarALL()) {
            cbCon.addItem(e);
        }

        for (CategoriaBEAN d : catControle.listarALL()) {
            cbCat.addItem(d);
        }

        for (FornecedorBEAN f : fc.listarALL()) {
            cbFornecedor.addItem(f);
        }

        btCadNota.setEnabled(false);
        preencheTabela();

    }

    private void preencheTabela() {
        dTable = criaTabela();
        //seta o nome das colunas da tabela
        dTable.addColumn("Código");
        dTable.addColumn("Nome");
        dTable.addColumn("Fornecedor");
        dTable.addColumn("Faixa Etária");
        dTable.addColumn("Preço Padrão");
        dTable.addColumn("Tipo de Jogo");
        dTable.addColumn("Categoria");
        dTable.addColumn("Console");
        dTable.addColumn("Lote");
        dTable.addColumn("Quantidade");
        //pega os dados do ArrayList
        jDados = jControle.listarALL();
        catDados = catControle.listarALL();
        cDados = cControle.listarALL();

        for (JogoBEAN dado : jDados) {
            for (CategoriaBEAN dado2 : catDados) {
                if (dado.getCat().getCatCodigo() == dado2.getCatCodigo()) {
                    for (ConsoleBEAN c : cDados) {
                        if (dado.getConsole().getConCodigo() == c.getConCodigo()) {
                            dTable.addRow(new Object[]{dado.getJoCodigo(), dado.getJoNome(), dado.getFornecedor(),
                                dado.getJoFaixaEtaria(), dado.getJoPrecoPadrao(), dado.getJoTipo(),
                                dado2.getCatNome(), c.getConNome(), dado.getJoLote(), dado.getJoQtd()});
                        }
                    }
                }
            }
        }
        tableJogo.setModel(dTable);
    }

    private DefaultTableModel criaTabela() {
        //sempre que usar JTable é necessário ter um DefaulttableModel
        DefaultTableModel dTable = new DefaultTableModel() {
            //Define o tipo dos campos (coluna) na mesma ordem que as colunas foram criadas
            Class[] types = new Class[]{
                java.lang.Integer.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.Double.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.Integer.class
            };
            //define se os campos podem ser editados na propria tabela
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false, false, false, false, false};

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
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tpGuia = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btCadastrar = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btLocalizar = new javax.swing.JButton();
        btCadNota = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        cbCat = new javax.swing.JComboBox<>();
        tfFaixa = new javax.swing.JFormattedTextField();
        tfNome = new javax.swing.JTextField();
        lbCodigoJogo = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cbFornecedor = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cbCon = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cbTipo = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        tfLote = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tfQtde = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfPrecoPadrao = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableJogo = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        tfChave = new javax.swing.JTextField();
        btVoltar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Jogo");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(null);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Menu de opções", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        btCadastrar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Visao/icons/Botões/JButtonAddJogo.png"))); // NOI18N
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
        btExcluir.setText("Invalidar");
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

        btCadNota.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btCadNota.setText("Cadastrar Nota de Compra");
        btCadNota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadNotaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btEditar)
                .addGap(18, 18, 18)
                .addComponent(btLocalizar)
                .addGap(18, 18, 18)
                .addComponent(btExcluir)
                .addGap(18, 18, 18)
                .addComponent(btCadNota)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btEditar)
                    .addComponent(btExcluir)
                    .addComponent(btLocalizar)
                    .addComponent(btCadNota, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(20, 180, 710, 70);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados do Jogo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        cbCat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));

        try{
            javax.swing.text.MaskFormatter faixa= new javax.swing.text.MaskFormatter("+(##)");
            tfFaixa = new javax.swing.JFormattedTextField(faixa);
        }
        catch (Exception e){
        }
        tfFaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfFaixaActionPerformed(evt);
            }
        });
        tfFaixa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfFaixaKeyTyped(evt);
            }
        });

        tfNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNomeActionPerformed(evt);
            }
        });

        lbCodigoJogo.setText("...");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setText("Categoria :");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("Faixa etária :");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Nome :");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Código :");

        jLabel13.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel13.setText("Fornecedor:");

        cbFornecedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setText("Console :");

        cbCon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));
        cbCon.setToolTipText("");
        cbCon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbConActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setText("Tipo de jogo :");

        cbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Venda", "Aluguel" }));
        cbTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setText("Lote :");

        tfLote.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfLoteKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setText("Quantidade :");

        tfQtde.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfQtdeKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("Preço:");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(tfQtde, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfPrecoPadrao, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(4, 4, 4)
                                .addComponent(tfFaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)
                                .addGap(10, 10, 10)
                                .addComponent(cbCat, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbCon, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(6, 6, 6)
                        .addComponent(lbCodigoJogo)
                        .addGap(19, 19, 19)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel13)
                        .addGap(10, 10, 10)
                        .addComponent(cbFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfLote, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(lbCodigoJogo))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel3))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(tfLote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))))
                .addGap(16, 16, 16)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfFaixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbCon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(tfQtde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addComponent(tfPrecoPadrao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel6);
        jPanel6.setBounds(12, 13, 739, 150);

        tpGuia.addTab("Cadastrar jogo", jPanel1);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tableJogo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tableJogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableJogoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableJogo);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Refinar pesquisa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        jLabel12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel12.setText("Palavra Chave :");

        tfChave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfChaveActionPerformed(evt);
            }
        });
        tfChave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfChaveKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfChaveKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfChave)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(tfChave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 747, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        tpGuia.addTab("Consultar jogo", jPanel2);

        btVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Visao/icons/Botões/JButtonLogin.png"))); // NOI18N
        btVoltar.setText("Voltar");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel11.setText("Cadastro de jogos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(280, 280, 280)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(680, 680, 680)
                        .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(tpGuia)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tpGuia, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(792, 408));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private int retornaLinha() {
        //retorna a linha que o usuário selecionou na tabela
        int linha = tableJogo.getSelectedRow();
        return linha;
    }

    private int verificaLote() {
        int j = 0;
        jDados = jControle.listarALL();
        for (JogoBEAN jDado : jDados) {
            if (jDado.getJoLote().equals(tfLote.getText())) {

                j = jDado.getJoCodigo();

            }
        }
        return j;
    }

    private void cadastroNormal() {
        JogoBEAN jogo = new JogoBEAN();
        jogo.setJoNome(tfNome.getText());
        jogo.setFornecedor((FornecedorBEAN) cbFornecedor.getSelectedItem());
        jogo.setJoLote(tfLote.getText());
        jogo.setJoFaixaEtaria(tfFaixa.getText());
        jogo.setCat((CategoriaBEAN) cbCat.getSelectedItem());
        jogo.setConsole((ConsoleBEAN) cbCon.getSelectedItem());
        jogo.setJoTipo(String.valueOf(cbTipo.getSelectedItem()));
        jogo.setJoQtd(Integer.parseInt(tfQtde.getText()));
        jogo.setJoPrecoPadrao(Float.parseFloat(tfPrecoPadrao.getText()));

        jControle.cadastrar(jogo);

        this.preencheTabela();
        limparCampos();
        JOptionPane.showMessageDialog(null, "Jogo CADASTRADO com sucesso");
    }

    private boolean verificaCampos() {
        if (tfFaixa.getText().equals("+(  )") || tfNome.getText().equals("")
                || cbCat.getSelectedIndex() == (0) || tfLote.getText().equals("")
                || cbCon.getSelectedIndex() == (0) || cbTipo.getSelectedIndex() == (0)
                || cbFornecedor.getSelectedIndex() == (0)
                || tfPrecoPadrao.getText().equals("") || tfQtde.getText().equals("")) {
            return false;
        } else {
            return true;
        }
    }


    private void btCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarActionPerformed
        if (verificaCampos()) {
            int v = verificaLote();
            if (v == 0) {
                this.cadastroNormal();
            } else {
                JOptionPane.showMessageDialog(null, "Erro! Lote já existente,Código do produto:" + v);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Erro!Preencha todos os campos.");
        }
    }//GEN-LAST:event_btCadastrarActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        int cod = verificaLote();
        if (cod != Integer.valueOf(lbCodigoJogo.getText())) {
            cod = 0;
        }
        if (verificaCampos() == true) {
            JogoBEAN jogo = jControle.localizarCodigo(Integer.parseInt(lbCodigoJogo.getText()));
            jogo.setJoNome(tfNome.getText());
            jogo.setJoFaixaEtaria(tfFaixa.getText());
            jogo.setJoPrecoPadrao(Float.parseFloat((tfPrecoPadrao.getText())));
            jogo.setJoTipo(String.valueOf(cbTipo.getSelectedItem()));
            jogo.setJoQtd(Integer.parseInt(String.valueOf(tfQtde.getText())));
            jogo.setJoLote(String.valueOf(tfLote.getText()));
            CategoriaBEAN c = (CategoriaBEAN) cbCat.getSelectedItem();
            jogo.setCat(c);
            ConsoleBEAN w = (ConsoleBEAN) cbCon.getSelectedItem();
            jogo.setConsole(w);

            boolean retorno = jControle.editar(jogo);
            //se a variavel retorno for igual a true o usuario foi editado
            if (retorno == true) {
                JOptionPane.showMessageDialog(null, "Jogo MODIFICADO com sucesso");
                //solicita a atualização da tabela ou seja preenche ela toda novamente
                this.preencheTabela();
                //chama o método para limpar campos
                this.limparCampos();
            } else {
                //mensagem de erro
                JOptionPane.showMessageDialog(null, "ERRO na EDIÇÃO");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Erro! Insira todos os valores");
        }
    }//GEN-LAST:event_btEditarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        if (verificaCampos() == true) {
            JogoBEAN jogo = jControle.localizarCodigo(Integer.parseInt(lbCodigoJogo.getText()));
            jogo.setJoQtd(0);
            boolean retorno = jControle.editar(jogo);
            //se a variavel retorno for igual a true o usuario foi editado
            if (retorno == true) {
                JOptionPane.showMessageDialog(null, "Jogo MODIFICADO com sucesso");
                //solicita a atualização da tabela ou seja preenche ela toda novamente
                this.preencheTabela();
                //chama o método para limpar campos
                this.limparCampos();
            } else {
                //mensagem de erro
                JOptionPane.showMessageDialog(null, "ERRO na EDIÇÃO");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Erro! Insira todos os valores");
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btLocalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLocalizarActionPerformed
        tpGuia.setSelectedIndex(1);
        preencheTabela();
    }//GEN-LAST:event_btLocalizarActionPerformed

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        FRMPrincipalFun fun = new FRMPrincipalFun();
        this.dispose();
        fun.setVisible(true);
    }//GEN-LAST:event_btVoltarActionPerformed

    private void tableJogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableJogoMouseClicked
        int c = 0;
        limparCampos();
        tpGuia.setSelectedIndex(0);
        if (tableJogo.getSelectedRow() != -1) {
            JogoBEAN j = jControle.localizarCodigo(Integer.parseInt(tableJogo.getValueAt(tableJogo.getSelectedRow(), 0).toString()));
            lbCodigoJogo.setText(tableJogo.getValueAt(tableJogo.getSelectedRow(), 0).toString());
            tfNome.setText(tableJogo.getValueAt(tableJogo.getSelectedRow(), 1).toString());
            tfFaixa.setText(tableJogo.getValueAt(tableJogo.getSelectedRow(), 2).toString());
            if (j.getJoTipo().equals("Aluguel")) {
                cbTipo.setSelectedIndex(2);
            } else {
                cbTipo.setSelectedIndex(1);
            }

            int i = 0;
            for (CategoriaBEAN cat : catControle.listarALL()) {
                i++;
                if (j.getCat().getCatCodigo() == cat.getCatCodigo()) {
                    cbCat.setSelectedIndex(i);
                }
            }
            int z = 0;
            for (ConsoleBEAN console : cControle.listarALL()) {
                z++;
                if (j.getConsole().getConCodigo() == console.getConCodigo()) {
                    cbCon.setSelectedIndex(z);
                }
            }
            int x = 0;
            for (FornecedorBEAN f : fc.listarALL()) {
                x++;
                if (j.getFornecedor().getForCodigo() == f.getForCodigo()) {
                    cbFornecedor.setSelectedIndex(x);
                }
            }

            tfLote.setText(tableJogo.getValueAt(tableJogo.getSelectedRow(), 7).toString());
            tfQtde.setText(tableJogo.getValueAt(tableJogo.getSelectedRow(), 8).toString());

            for (NotaDecompraBEAN n : notac.listarALL()) {
                if (n.getJogo().getJoCodigo() == j.getJoCodigo()) {
                    c++;
                }
            }
            if (c == 0) {
                btCadNota.setEnabled(true);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Erro, jogo não disponível no estoque");
        }


    }//GEN-LAST:event_tableJogoMouseClicked

    private void tfChaveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfChaveKeyPressed

    }//GEN-LAST:event_tfChaveKeyPressed

    private void tfChaveKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfChaveKeyTyped
        TableRowSorter sorter = null;
        DefaultTableModel model = (DefaultTableModel) tableJogo.getModel();
        sorter = new TableRowSorter<TableModel>(model);
        tableJogo.setRowSorter(sorter);
        String text = tfChave.getText();
        if (text.length() == 0) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.regexFilter(text));
        }
    }//GEN-LAST:event_tfChaveKeyTyped


    private void tfChaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfChaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfChaveActionPerformed

    private void btCadNotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadNotaActionPerformed
        jogoCod = Integer.valueOf(lbCodigoJogo.getText());
        FRMNotaDeCompra ndc = new FRMNotaDeCompra();
        ndc.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btCadNotaActionPerformed

    private void tfQtdeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfQtdeKeyTyped
        String caracteres = "0123456789";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_tfQtdeKeyTyped

    private void tfLoteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfLoteKeyTyped

    }//GEN-LAST:event_tfLoteKeyTyped

    private void cbTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoActionPerformed

    }//GEN-LAST:event_cbTipoActionPerformed

    private void cbConActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbConActionPerformed

    }//GEN-LAST:event_cbConActionPerformed

    private void tfNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNomeActionPerformed

    private void tfFaixaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfFaixaKeyTyped
        String caracteres = "0123456789+";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_tfFaixaKeyTyped

    private void tfFaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfFaixaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfFaixaActionPerformed

    private void limparCampos() {
        lbCodigoJogo.setText("");
        tfNome.setText("");
        tfFaixa.setText("");
        tfPrecoPadrao.setText("");
        tfQtde.setText("");
        cbCat.setSelectedIndex(0);
        cbCon.setSelectedIndex(0);
        cbTipo.setSelectedIndex(0);
        tfLote.setText("");
        tfPrecoPadrao.setText("");
        tfQtde.setText("");
        btCadNota.setEnabled(false);

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
            java.util.logging.Logger.getLogger(FRMJogo.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FRMJogo.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FRMJogo.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FRMJogo.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FRMJogo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCadNota;
    private javax.swing.JButton btCadastrar;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btLocalizar;
    private javax.swing.JButton btVoltar;
    private javax.swing.JComboBox<Object> cbCat;
    private javax.swing.JComboBox<Object> cbCon;
    private javax.swing.JComboBox<Object> cbFornecedor;
    private javax.swing.JComboBox<String> cbTipo;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbCodigoJogo;
    private javax.swing.JTable tableJogo;
    private javax.swing.JTextField tfChave;
    private javax.swing.JFormattedTextField tfFaixa;
    private javax.swing.JTextField tfLote;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfPrecoPadrao;
    private javax.swing.JTextField tfQtde;
    private javax.swing.JTabbedPane tpGuia;
    // End of variables declaration//GEN-END:variables
}

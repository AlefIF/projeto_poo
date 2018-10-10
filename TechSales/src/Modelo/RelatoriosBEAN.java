/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controle.ContaControle;
import Controle.ControleRelatorios;
import Controle.JogoControle;
import Controle.JogoVendaControle;
import Controle.NotaDeCompraControle;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.StringReader;
import javax.swing.JOptionPane;

/**
 *
 * @author Alef
 */
public class RelatoriosBEAN {

    static ControleRelatorios jDAO = new ControleRelatorios();
    static NotaDeCompraControle cNdc = new NotaDeCompraControle();
    static ContaControle cContas = new ContaControle();

    public static void relatorioTopJogos() throws FileNotFoundException, DocumentException {
        String path = System.getProperty("user.home") + "/Desktop/Relatório Top Jogos" + ".pdf";
        Document document = new Document(PageSize.LETTER);
        PdfWriter.getInstance(document, new FileOutputStream(path));
        document.open();
        document.addAuthor("TechSales");
        document.addCreator("TechSales");
        document.addSubject("TechSales - Sistema de gerenciamento de locadoras");
        document.addCreationDate();
        document.addTitle("TechSales");

        HTMLWorker htmlWorker = new HTMLWorker(document);

        String frase;
        try {
            frase = "<html>"
                    + "<head> <meta charset=\"utf-8\"> </head>"
                    + "<body>"
                    + "<h1 align=center>Relatório de Jogos mais vendidos </h1>"
                    + "</br></br></br>"
                    + "<table BORDER RULES=rows border=0 style=\"  width:100%; \">\n"
                    + "<tr> "
                    + "<th align=center><strong>Código</strong></th> "
                    + "<th align=center><strong>Nome do Jogo</strong></th> "
                    + "<th align=center><strong>Quantidade Vendida</strong></th> "
                    + "<th align=center><strong>Valor Total</strong></th> "
                    + "</tr> ";
            for (JogoBEAN j : jDAO.topJogos()) {
                frase += "<tr align=center><td>" + j.getJoCodigo() + "</td><td>"
                        + j.getJoNome() + "</td><td>" + j.getJoQtd() + "</td><td>" + j.getJoPrecoPadrao() + "</td></tr>";
            }
            frase += "</table>";
            frase += "</body></html>";
            htmlWorker.parse(new StringReader(frase));
            document.close();
            if (Desktop.isDesktopSupported()) {
                try {
                    Desktop.getDesktop().open(new File(path));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void relatorioWorstJogos() throws FileNotFoundException, DocumentException {
        String path = System.getProperty("user.home") + "/Desktop/Relatório Worst Jogos" + ".pdf";
        Document document = new Document(PageSize.LETTER);
        PdfWriter.getInstance(document, new FileOutputStream(path));
        document.open();
        document.addAuthor("TechSales");
        document.addCreator("TechSales");
        document.addSubject("TechSales - Sistema de gerenciamento de locadoras");
        document.addCreationDate();
        document.addTitle("TechSales");

        HTMLWorker htmlWorker = new HTMLWorker(document);

        String frase;
        try {
            frase = "<html>"
                    + "<head> <meta charset=\"utf-8\"> </head>"
                    + "<body>"
                    + "<h1 align=center>Relatório de Jogos menos vendidos </h1>"
                    + "</br></br></br>"
                    + "<table BORDER RULES=rows border=0 style=\"  width:100%; \">\n"
                    + "<tr> "
                    + "<th align=center><strong>Código</strong></th> "
                    + "<th align=center><strong>Nome do Jogo</strong></th> "
                    + "<th align=center><strong>Quantidade Vendida</strong></th> "
                    + "<th align=center><strong>Valor Total</strong></th> "
                    + "</tr> ";
            for (JogoBEAN j : jDAO.worstJogos()) {
                frase += "<tr align=center><td>" + j.getJoCodigo() + "</td><td>"
                        + j.getJoNome() + "</td><td>" + j.getJoQtd() + "</td><td>" + j.getJoPrecoPadrao() + "</td></tr>";
            }
            frase += "</table>";
            frase += "</body></html>";
            htmlWorker.parse(new StringReader(frase));
            document.close();
            if (Desktop.isDesktopSupported()) {
                try {
                    Desktop.getDesktop().open(new File(path));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void relatorioTopAlugueis() throws FileNotFoundException, DocumentException {
        String path = System.getProperty("user.home") + "/Desktop/Relatório Top Alugueis" + ".pdf";
        Document document = new Document(PageSize.LETTER);
        PdfWriter.getInstance(document, new FileOutputStream(path));
        document.open();
        document.addAuthor("TechSales");
        document.addCreator("TechSales");
        document.addSubject("TechSales - Sistema de gerenciamento de locadoras");
        document.addCreationDate();
        document.addTitle("TechSales");

        HTMLWorker htmlWorker = new HTMLWorker(document);

        String frase;
        try {
            frase = "<html>"
                    + "<head> <meta charset=\"utf-8\"> </head>"
                    + "<body>"
                    + "<h1 align=center>Relatório de Jogos mais Alugados </h1>"
                    + "</br></br></br>"
                    + "<table BORDER RULES=rows border=0 style=\"  width:100%; \">\n"
                    + "<tr> "
                    + "<th align=center><strong>Código</strong></th> "
                    + "<th align=center><strong>Nome do Jogo</strong></th> "
                    + "<th align=center><strong>Quantidade Vendida</strong></th> "
                    + "<th align=center><strong>Valor Total</strong></th> "
                    + "</tr> ";
            for (JogoBEAN j : jDAO.topAluguelJogos()) {
                frase += "<tr align=center><td>" + j.getJoCodigo() + "</td><td>"
                        + j.getJoNome() + "</td><td>" + j.getJoQtd() + "</td><td>" + j.getJoPrecoPadrao() + "</td></tr>";
            }
            frase += "</table>";
            frase += "</body></html>";
            htmlWorker.parse(new StringReader(frase));
            document.close();
            if (Desktop.isDesktopSupported()) {
                try {
                    Desktop.getDesktop().open(new File(path));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void relatorioWorstAlugueis() throws FileNotFoundException, DocumentException {
        String path = System.getProperty("user.home") + "/Desktop/Relatório Worst Alugueis" + ".pdf";
        Document document = new Document(PageSize.LETTER);
        PdfWriter.getInstance(document, new FileOutputStream(path));
        document.open();
        document.addAuthor("TechSales");
        document.addCreator("TechSales");
        document.addSubject("TechSales - Sistema de gerenciamento de locadoras");
        document.addCreationDate();
        document.addTitle("TechSales");

        HTMLWorker htmlWorker = new HTMLWorker(document);

        String frase;
        try {
            frase = "<html>"
                    + "<head> <meta charset=\"utf-8\"> </head>"
                    + "<body>"
                    + "<h1 align=center>Relatório de Jogos menos Alugados </h1>"
                    + "</br></br></br>"
                    + "<table BORDER RULES=rows border=0 style=\"  width:100%; \">\n"
                    + "<tr> "
                    + "<th align=center><strong>Código</strong></th> "
                    + "<th align=center><strong>Nome do Jogo</strong></th> "
                    + "<th align=center><strong>Quantidade Vendida</strong></th> "
                    + "<th align=center><strong>Valor Total</strong></th> "
                    + "</tr> ";
            for (JogoBEAN j : jDAO.topAluguelJogos()) {
                frase += "<tr align=center><td>" + j.getJoCodigo() + "</td><td>"
                        + j.getJoNome() + "</td><td>" + j.getJoQtd() + "</td><td>" + j.getJoPrecoPadrao() + "</td></tr>";
            }
            frase += "</table>";
            frase += "</body></html>";
            htmlWorker.parse(new StringReader(frase));
            document.close();
            if (Desktop.isDesktopSupported()) {
                try {
                    Desktop.getDesktop().open(new File(path));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*-----------------------------------*/
    public static void relatorioCompras() throws FileNotFoundException, DocumentException {
        String path = System.getProperty("user.home") + "/Desktop/Relatório Compras" + ".pdf";
        Document document = new Document(PageSize.LETTER);
        PdfWriter.getInstance(document, new FileOutputStream(path));
        document.open();
        document.addAuthor("TechSales");
        document.addCreator("TechSales");
        document.addSubject("TechSales - Sistema de gerenciamento de locadoras");
        document.addCreationDate();
        document.addTitle("TechSales");

        HTMLWorker htmlWorker = new HTMLWorker(document);

        String frase;
        try {
            frase = "<html>"
                    + "<head> <meta charset=\"utf-8\"> </head>"
                    + "<body>"
                    + "<h1 align=center>Relatório de Jogos Comprados </h1>"
                    + "</br></br></br>"
                    + "<table BORDER RULES=rows border=0 style=\"  width:100%; \">\n"
                    + "<tr> "
                    + "<th align=center><strong>Código</strong></th> "
                    + "<th align=center><strong>Custo Unitário</strong></th> "
                    + "<th align=center><strong>Data</strong></th> "
                    + "<th align=center><strong>Valor da Entrada</strong></th> "
                    + "<th align=center><strong>Número de parcelas</strong></th> "
                    + "<th align=center><strong>Preço Total</strong></th> "
                    + "<th align=center><strong>Quantidade Compradra</strong></th> "
                    + "<th align=center><strong>Caixa</strong></th> "
                    + "<th align=center><strong>Jogo</strong></th> "
                    + "</tr> ";
            for (NotaDecompraBEAN n : cNdc.listarALL()) {
                frase += "<tr align=center><td>" + n.getNdcCodigo() + "</td><td>"
                        + n.getNdcCustoUnitario() + "</td><td>" + n.getNdcData() + "</td><td>" + n.getNdcEntrada() + "</td><td>"
                        + n.getNdcParcelas() + "</td><td>" + n.getNdcPrecoTotal() + "</td><td>" + n.getNdcQtdComprada()
                        + "</td><td>" + n.getCaixa().getCaixaCodigo() + "</td><td>" + n.getJogo().getJoNome() + "</td></tr>";
            }
            frase += "</table>";
            frase += "</body></html>";
            htmlWorker.parse(new StringReader(frase));
            document.close();
            if (Desktop.isDesktopSupported()) {
                try {
                    Desktop.getDesktop().open(new File(path));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*-----------------------------------------*/
    public static void relatorioContas() throws FileNotFoundException, DocumentException {
        String path = System.getProperty("user.home") + "/Desktop/Relatório Compras" + ".pdf";
        Document document = new Document(PageSize.LETTER);
        PdfWriter.getInstance(document, new FileOutputStream(path));
        document.open();
        document.addAuthor("TechSales");
        document.addCreator("TechSales");
        document.addSubject("TechSales - Sistema de gerenciamento de locadoras");
        document.addCreationDate();
        document.addTitle("TechSales");

        HTMLWorker htmlWorker = new HTMLWorker(document);

        String frase;
        try {
            frase = "<html>"
                    + "<head> <meta charset=\"utf-8\"> </head>"
                    + "<body>"
                    + "<h1 align=center>Relatório de Jogos Comprados </h1>"
                    + "</br></br></br>"
                    + "<table BORDER RULES=rows border=0 style=\"  width:100%; \">\n"
                    + "<tr> "
                    + "<th align=center><strong>Código</strong></th> "
                    + "<th align=center><strong>Custo Unitário</strong></th> "
                    + "<th align=center><strong>Data</strong></th> "
                    + "<th align=center><strong>Valor da Entrada</strong></th> "
                    + "<th align=center><strong>Número de parcelas</strong></th> "
                    + "<th align=center><strong>Quantidade Compradra</strong></th> "
                    + "<th align=center><strong>Preço Total</strong></th> "
                    + "<th align=center><strong>Descrição</strong></th> "
                    + "<th align=center><strong>Fornecedor</strong></th> "
                    + "<th align=center><strong>Caixa</strong></th> "
                    + "</tr> ";
            for (ContaBEAN n : cContas.listarALL()) {
                frase += "<tr align=center><td>" + n.getConCodigo() + "</td><td>"
                        + n.getConCustoUnitario() + "</td><td>" + n.getConData() + "</td><td>" + n.getConEntrada() + "</td><td>"
                        + n.getConNparcelas() + "</td><td>" + n.getConQtdComprada() + "</td><td>" + n.getConValorTotal()
                        + "</td><td>" + n.getConDescricao() + "</td><td>" + n.getFornecedor().getForNomeEmpresa()
                        + "</td><td>" + n.getCaixa().getCaixaCodigo() + "</td></tr>";
            }
            frase += "</table>";
            frase += "</body></html>";
            htmlWorker.parse(new StringReader(frase));
            document.close();
            if (Desktop.isDesktopSupported()) {
                try {
                    Desktop.getDesktop().open(new File(path));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*----------------------------------*/
    public static void relatorioMontanteVendedor() throws FileNotFoundException, DocumentException {
        String path = System.getProperty("user.home") + "/Desktop/Relatório Montante por Vendedor" + ".pdf";
        Document document = new Document(PageSize.LETTER);
        PdfWriter.getInstance(document, new FileOutputStream(path));
        document.open();
        document.addAuthor("TechSales");
        document.addCreator("TechSales");
        document.addSubject("TechSales - Sistema de gerenciamento de locadoras");
        document.addCreationDate();
        document.addTitle("TechSales");

        HTMLWorker htmlWorker = new HTMLWorker(document);

        String frase;
        try {
            frase = "<html>"
                    + "<head> <meta charset=\"utf-8\"> </head>"
                    + "<body>"
                    + "<h1 align=center>Relatório de Jogos menos Alugados </h1>"
                    + "</br></br></br>"
                    + "<table BORDER RULES=rows border=0 style=\"  width:100%; \">\n"
                    + "<tr> "
                    + "<th align=center><strong>Código do funcionario</strong></th> "
                    + "<th align=center><strong>Nome do funcionario</strong></th> "
                    + "<th align=center><strong>Número de vendas</strong></th> "
                    + "<th align=center><strong>Valor total das vendas</strong></th> "
                    + "<th align=center><strong>Quantidade de alugueis</strong></th> "
                    + "<th align=center><strong>Valor total de alugueis</strong></th> "
                    + "<th align=center><strong>Montante Total</strong></th> "
                    + "</tr> ";
            for (MontanteBEAN j : jDAO.montanteVendedor()) {
                frase += "<tr align=center><td>" + j.getFunCodigo()+ "</td><td>"
                        + j.getFunNome()+ "</td><td>" + j.getnVendas()+ "</td><td>" 
                        + j.getValorVendas()+"</td><td>" + j.getnAluguel()+ 
                        "</td><td>" +j.getValorAluguel()+ "</td><td>" +j.getValorTotal()+"</td></tr>";
            }
            frase += "</table>";
            frase += "</body></html>";
            htmlWorker.parse(new StringReader(frase));
            document.close();           
            if (Desktop.isDesktopSupported()) {
                try {
                    Desktop.getDesktop().open(new File(path));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /*----------------------------------------*/
    
    public static void relatorioVendaJogoPeriodo(String s,String dI,String dF) throws FileNotFoundException, DocumentException {
        String path = System.getProperty("user.home") + "/Desktop/Relatório de Venda de jogos por período" + ".pdf";
        Document document = new Document(PageSize.LETTER);
        PdfWriter.getInstance(document, new FileOutputStream(path));
        document.open();
        document.addAuthor("TechSales");
        document.addCreator("TechSales");
        document.addSubject("TechSales - Sistema de gerenciamento de locadoras");
        document.addCreationDate();
        document.addTitle("TechSales");

        HTMLWorker htmlWorker = new HTMLWorker(document);

        String frase;
        try {
            frase = "<html>"
                    + "<head> <meta charset=\"utf-8\"> </head>"
                    + "<body>"
                    + "<h1 align=center>Relatório de Jogos vendidos</h1>"
                    + "<h3 align=center>Período de "+dI+" a "+dF+"</h3>"
                    + "</br></br></br>"
                    + "<table BORDER RULES=rows border=0 style=\"  width:100%; \">\n"
                    + "<tr> "
                    + "<th align=center><strong>Código do jogo</strong></th> "
                    + "<th align=center><strong>Nome do jogo</strong></th> "
                    + "<th align=center><strong>Número de vendas</strong></th> "
                    + "<th align=center><strong>Valor total das vendas</strong></th> "
                    + "</tr> ";
            for (JogoBEAN j : jDAO.vendaPorPeriodo(s)) {
                frase += "<tr align=center><td>" + j.getJoCodigo()+ "</td><td>"
                        + j.getJoNome()+ "</td><td>" + j.getJoQtd()+ "</td><td>"
                        +j.getJoPrecoPadrao()+"</td></tr>";
            }
            frase += "</table>";
            frase += "</body></html>";
            htmlWorker.parse(new StringReader(frase));
            document.close();           
            if (Desktop.isDesktopSupported()) {
                try {
                    Desktop.getDesktop().open(new File(path));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    /*---------------------------------*/
    
     public static void relatorioAluguelJogoPeriodo(String s,String dI,String dF) throws FileNotFoundException, DocumentException {
        String path = System.getProperty("user.home") + "/Desktop/Relatório de alugueis de jogos po período" + ".pdf";
        Document document = new Document(PageSize.LETTER);
        PdfWriter.getInstance(document, new FileOutputStream(path));
        document.open();
        document.addAuthor("TechSales");
        document.addCreator("TechSales");
        document.addSubject("TechSales - Sistema de gerenciamento de locadoras");
        document.addCreationDate();
        document.addTitle("TechSales");

        HTMLWorker htmlWorker = new HTMLWorker(document);

        String frase;
        try {
            frase = "<html>"
                    + "<head> <meta charset=\"utf-8\"> </head>"
                    + "<body>"
                    + "<h1 align=center>Relatório de Jogos vendidos</h1>"
                    + "<h3 align=center>Período de "+dI+" a "+dF+"</h3>"
                    + "</br></br></br>"
                    + "<table BORDER RULES=rows border=0 style=\"  width:100%; \">\n"
                    + "<tr> "
                    + "<th align=center><strong>Código do jogo</strong></th> "
                    + "<th align=center><strong>Nome do jogo</strong></th> "
                    + "<th align=center><strong>Número de alugueis</strong></th> "
                    + "<th align=center><strong>Valor total dos alugueis</strong></th> "
                    + "</tr> ";
            for (JogoBEAN j : jDAO.aluguelPorPeriodo(s)) {
                frase += "<tr align=center><td>" + j.getJoCodigo()+ "</td><td>"
                        + j.getJoNome()+ "</td><td>" + j.getJoQtd()+ "</td><td>"
                        +j.getJoPrecoPadrao()+"</td></tr>";
            }
            frase += "</table>";
            frase += "</body></html>";
            htmlWorker.parse(new StringReader(frase));
            document.close();           
            if (Desktop.isDesktopSupported()) {
                try {
                    Desktop.getDesktop().open(new File(path));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     
     
    /*------------------------------------------------------*/
     
      public static void relatorioMontanteCliente() throws FileNotFoundException, DocumentException {
        String path = System.getProperty("user.home") + "/Desktop/Relatório Montante por Cliente" + ".pdf";
        Document document = new Document(PageSize.LETTER);
        PdfWriter.getInstance(document, new FileOutputStream(path));
        document.open();
        document.addAuthor("TechSales");
        document.addCreator("TechSales");
        document.addSubject("TechSales - Sistema de gerenciamento de locadoras");
        document.addCreationDate();
        document.addTitle("TechSales");

        HTMLWorker htmlWorker = new HTMLWorker(document);

        String frase;
        try {
            frase = "<html>"
                    + "<head> <meta charset=\"utf-8\"> </head>"
                    + "<body>"
                    + "<h1 align=center>Relatório de Jogos menos Alugados </h1>"
                    + "</br></br></br>"
                    + "<table BORDER RULES=rows border=0 style=\"  width:100%; \">\n"
                    + "<tr> "
                    + "<th align=center><strong>Código do cliente</strong></th> "
                    + "<th align=center><strong>Nome do cliente</strong></th> "
                    + "<th align=center><strong>Número de compras</strong></th> "
                    + "<th align=center><strong>Valor total das compras</strong></th> "
                    + "<th align=center><strong>Quantidade de alugueis</strong></th> "
                    + "<th align=center><strong>Valor total de alugueis</strong></th> "
                    + "<th align=center><strong>Montante Total</strong></th> "
                    + "</tr> ";
            for (MontanteBEAN j : jDAO.montanteCliente()) {
                frase += "<tr align=center><td>" + j.getFunCodigo()+ "</td><td>"
                        + j.getFunNome()+ "</td><td>" + j.getnVendas()+ "</td><td>" 
                        + j.getValorVendas()+"</td><td>" + j.getnAluguel()+ 
                        "</td><td>" +j.getValorAluguel()+ "</td><td>" +j.getValorTotal()+"</td></tr>";
            }
            frase += "</table>";
            frase += "</body></html>";
            htmlWorker.parse(new StringReader(frase));
            document.close();           
            if (Desktop.isDesktopSupported()) {
                try {
                    Desktop.getDesktop().open(new File(path));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     
}

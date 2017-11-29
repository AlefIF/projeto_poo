package Controle;

/* pacotes necessários */
import static Modelo.ConnectionFactory.getConnection;
import Modelo.UserDAO;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import Modelo.JogoMySqlDAO;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class RelFun {

    /* Gera o Relatorio e visualiza-o*/
    public static void gerarRelatorio(String query, String relatJasp)
            throws JRException, Exception {

        UserDAO dao = new UserDAO();
        ResultSet rs = dao.consulta(query);

        try {
            /* implementacaoo da interface JRDataSource para DataSource ResultSet 
            JRResultSetDataSource  clase para acessar um banco de dados*/
            JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);

            /* HashMap de parametros utilizados no relatório. 
            Sempre instanciados mesmo se nao tiver parâmetros */
            Map parameters = new HashMap();

            /* Preenche o relat�rio com os dados. 
            Gera o arquivo fun.jrprint */
            JasperViewer.viewReport(JasperFillManager.fillReport(relatJasp, parameters, jrRS));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar o relatório, " + e.getMessage(), "Erro", JOptionPane.INFORMATION_MESSAGE);
            System.out.println(e.getMessage());
        }

    }

    /*public static void gerarRelatorio2(String jrxml, String nomeArquivo) {
        JasperReport jasperReport;
        JasperPrint jasperPrint;
        //Try Catch necessário caso ocorra algum erro durante a geração do relatório

        try {
            //Formatando a data para nomear o arquivo PDF gerado
            SimpleDateFormat dt = new SimpleDateFormat("dd-MM-yyyy");
            //Pega a conexão para efetuar as operações no BD
            Connection con = getConnection();
            Map parameters = new HashMap();
            //Busca o relatório .jrxml
            JasperReport report = JasperCompileManager.compileReport("src/relatorios/" + jrxml + ".jrxml");
            //Chama o relatório passando o caminho, parâmtros especificados e a conexão com o BD
            JasperPrint impressao = JasperFillManager.fillReport(report, parameters, con);
            //Após ser gerado, a próxima linha exportará o documento em formato PDF
            JasperExportManager.exportReportToPdfFile(impressao, "src/relatorios/" + jrxml + "-" + dt.format(Calendar.getInstance().getTime()) + ".pdf");
            //Busca e exibe automaticamnete o arquivo PDF gerado
            File arquivo = new File("C:\\Users\\Alef\\Desktop\\projeto techsales poo\\TechSales\\src\\relatorios" + jrxml + "-" + dt.format(Calendar.getInstance().getTime()) + ".pdf");
            Desktop.getDesktop().open(arquivo);

        } catch (IOException | JRException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Gerar o Relatório, " + e.getMessage(), "Erro", JOptionPane.INFORMATION_MESSAGE);
            System.out.println(e.getMessage());
        }

    }*/
}

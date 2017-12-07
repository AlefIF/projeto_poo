/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.FunSql;
import Modelo.JogoMySqlDAO;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author alunos
 */
public class RelCliente {

    public static void gerarRelatorio2(String query, String relatJasp)
            throws JRException, Exception {

        FunSql dao = new FunSql();
        ResultSet rs = dao.consulta(query);

        try {
            /* implementacaoo da interface JRDataSource para DataSource ResultSet 
            JRResultSetDataSource  clase para acessar um banco de dados*/
            JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);

            /* HashMap de parametros utilizados no relatório. 
            Sempre instanciados mesmo se nao tiver parâmetros */
            Map parameters = new HashMap();

            /* Preenche o relat�rio com os dados. 
            Gera o arquivo Cliente.jrprint */
            JasperViewer.viewReport(JasperFillManager.fillReport(relatJasp, parameters, jrRS));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar o relatório, " + e.getMessage(), "Erro", JOptionPane.INFORMATION_MESSAGE);
            System.out.println(e.getMessage());
        }
    }
}

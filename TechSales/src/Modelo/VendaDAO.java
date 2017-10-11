/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Alef
 */
public class VendaDAO {

    //armazernar meu objeto de conexao com o BD MySQL    
    private Connection connection;
    //objeto stmt que executa as consultas no BD
    private PreparedStatement stmt;

    public VendaDAO() {
        //inicializa a conexão com o BD - chamando o FActory e Singleton
        this.connection = ConnectionFactory.getConnection();
    }

    public ArrayList<Venda> listarALL() {
        String sql = "select *from venda;";
        ArrayList<Venda> vendaAL = new ArrayList<Venda>();
        try {
            // prepared statement para seleção
            stmt = connection.prepareStatement(sql);

            // executa a consulta SQL usando o comando executeQuery
            ResultSet rs = stmt.executeQuery();
            //joga resultado da consulta no ArrayList
            while (rs.next()) {
                //joga os dados do rs dentro de um objeto c do tipo ContatoBEAN
                Venda c = new Venda();
                c.setVenCodigo(rs.getInt(1));
                c.setVenNNF(rs.getString(2));
                c.setVenDataEHora((rs.getTimestamp(3)));
                c.setVen_funCodigo(rs.getInt(4));
                //adiciona os dados no ArrayLIst
                vendaAL.add(c);
            }
            stmt.close();//fecha conexão - OBRIGATORIO SEMPRE!
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vendaAL;
    }

    public ResultSet consulta(String strSql) {
        try {
            //criando o objeto Statement para que seja possivel enviar as consultas
            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            //objeto do ResulSet para receber o resultado da consulta
            ResultSet rs = stmt.executeQuery(strSql);
            return rs;
        } catch (SQLException erro) {
            System.err.println(erro.getMessage());
            return null;
        }
    }
}

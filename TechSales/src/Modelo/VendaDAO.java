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
import java.util.List;

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

    public int cadastrar(VendaBEAN c) {

        String sql = "insert into venda (venNNF, venData, ven_funCodigo, cliente_cliCodigo) values (?,?,?,?);";
        try {
            // prepared statement para inserção
            stmt = connection.prepareStatement(sql);
            // seta os valores
            stmt.setString(1, c.getVenNNF());
            stmt.setDate(2, c.getVenData());
            stmt.setDouble(3, c.getVen_funCodigo());
            stmt.setInt(4, c.getCliente_cliCodigo());
            // executa
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return c.getVenCodigo();
    }

    public boolean editar(VendaBEAN c) {

        String sql = "update venda set venNNF = ?,venData = ?,"
                + " ven_funCodigo=?, cliente_cliCodigo = ? where venCodigo = ?;";
        try {
            /* metodo usado para criar um objeto que representa a instrução 
            SQL que será executada, sendo que é invocado através do objeto 
            Connection.
            
            Deve ser colocado dentro de um bloco try catch */
            stmt = connection.prepareStatement(sql);
            // seta os valores

            stmt.setString(1, c.getVenNNF());
            stmt.setDate(2, c.getVenData());
            stmt.setDouble(3, c.getVen_funCodigo());
            stmt.setInt(4, c.getCliente_cliCodigo());

            // executa update
            int linhasAtualizadas = stmt.executeUpdate();
            stmt.close();
            //apenas se quiser saber quantas linhas foram alteradas
            if (linhasAtualizadas > 0) {
                System.out.println("Foram alterados " + linhasAtualizadas + " registros");
            }
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean remover(int codigo) {
        String sql = "delete from venda where venCodigo = ?";
        try {
            // prepared statement para inserção
            stmt = connection.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1, codigo);
            // executa
            stmt.execute();
            stmt.close();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<VendaBEAN> listarALL() {
        String sql = "select *from venda;";
        ArrayList<VendaBEAN> vendaAL = new ArrayList<VendaBEAN>();
        try {
            // prepared statement para seleção
            stmt = connection.prepareStatement(sql);

            // executa a consulta SQL usando o comando executeQuery
            ResultSet rs = stmt.executeQuery();
            //joga resultado da consulta no ArrayList
            while (rs.next()) {
                //joga os dados do rs dentro de um objeto c do tipo ContatoBEAN
                VendaBEAN c = new VendaBEAN();
                c.setVenCodigo(rs.getInt(1));
                c.setVenNNF(rs.getString(2));
                c.setVenData((rs.getDate(3)));
                c.setCliente_cliCodigo((rs.getInt(4)));
                c.setVen_funCodigo(rs.getInt(5));
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

    public ArrayList consultar(String a) {

        ArrayList b= new ArrayList();
        try {
            // prepared statement para seleção
            stmt = connection.prepareStatement(a);

            // executa a consulta SQL usando o comando executeQuery
            ResultSet rs = stmt.executeQuery();
            //joga resultado da consulta no ArrayList
            while (rs.next()) {
                //joga os dados do rs dentro de um objeto c do tipo ContatoBEAN
                Object o= new Object();
                o.
                o.setInt(rs.getInt(1));
                o.setVenNNF(rs.getString(2));
                //adiciona os dados no ArrayLIst
                b.add(o);
            }
            stmt.close();//fecha conexão - OBRIGATORIO SEMPRE!
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return b;
    }

}

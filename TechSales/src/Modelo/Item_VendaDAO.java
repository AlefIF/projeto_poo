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
import java.util.ArrayList;

/**
 *
 * @author Alef
 */
public class Item_VendaDAO {

    //armazernar meu objeto de conexao com o BD MySQL    
    private Connection connection;
    //objeto stmt que executa as consultas no BD
    private PreparedStatement stmt;

    public Item_VendaDAO() {
        //inicializa a conexão com o BD - chamando o FActory e Singleton
        this.connection = ConnectionFactory.getConnection();
    }

    public void cadastrar(Item_VendaBEAN c) {

        String sql = "insert into item_venda (iv_joCodigo, ivQtd, ivPrecoUnitReal) values (?,?,?);";
        try {
            // prepared statement para inserção
            stmt = connection.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1, c.getIv_joCodigo());
            stmt.setInt(2, c.getvQtd());
            stmt.setDouble(3, c.getIvPrecoUnitReal());
            // executa
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public boolean editar(Item_VendaBEAN c) {

        String sql = "update item_venda set ivPrecoUnitReal=?, iv_joCodigo = ?,"
                + " ivQtd = ? where iv_venCodigo = ?;";
        try {
            /* metodo usado para criar um objeto que representa a instrução 
            SQL que será executada, sendo que é invocado através do objeto 
            Connection.
            
            Deve ser colocado dentro de um bloco try catch */
            stmt = connection.prepareStatement(sql);
            // seta os valores

            stmt.setDouble(1, c.getIvPrecoUnitReal());
            stmt.setInt(2, c.getIv_joCodigo());
            stmt.setInt(3, c.getvQtd());

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
        String sql = "delete from item_venda where venCodigo = ?";
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

    public ArrayList<Item_VendaBEAN> listarALL() {
        String sql = "select *from item_venda;";
        ArrayList<Item_VendaBEAN> itvAL = new ArrayList<Item_VendaBEAN>();
        try {
            // prepared statement para seleção
            stmt = connection.prepareStatement(sql);

            // executa a consulta SQL usando o comando executeQuery
            ResultSet rs = stmt.executeQuery();
            //joga resultado da consulta no ArrayList
            while (rs.next()) {
                //joga os dados do rs dentro de um objeto c do tipo ContatoBEAN
                Item_VendaBEAN c = new Item_VendaBEAN();
                c.setIv_venCodigo(rs.getInt(1));
                c.setIv_joCodigo(rs.getInt(2));
                c.setvQtd(rs.getInt(3));
                c.setIvPrecoUnitReal(rs.getFloat(4));

                //adiciona os dados no ArrayLIst
                itvAL.add(c);
            }
            stmt.close();//fecha conexão - OBRIGATORIO SEMPRE!
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return itvAL;
    }
}

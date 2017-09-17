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
    
    public ArrayList<Item_Venda> listarALL() {
        String sql = "select *from item_venda;";
        ArrayList<Item_Venda> itvAL = new ArrayList<Item_Venda>();
        try {
            // prepared statement para seleção
            stmt = connection.prepareStatement(sql);

            // executa a consulta SQL usando o comando executeQuery
            ResultSet rs = stmt.executeQuery();
            //joga resultado da consulta no ArrayList
            while (rs.next()) {
                //joga os dados do rs dentro de um objeto c do tipo ContatoBEAN
                Item_Venda c = new Item_Venda();
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
